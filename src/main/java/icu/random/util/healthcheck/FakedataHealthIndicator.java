package icu.random.util.healthcheck;

import icu.random.client.rest.RestClient;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Slf4j
@Component("fakedata-backend")
public class FakedataHealthIndicator implements HealthIndicator {

  @Value("${randomicu.fakedata.host}")
  private String host;
  
  @Value("${randomicu.fakedata.port}")
  private Integer port;

  @Value("${randomicu.fakedata.healthcheck}")
  private String healthcheck;

  private final RestClient restClient;

  private final Map<String, String> details = new HashMap<>();

  @Autowired
  public FakedataHealthIndicator(RestClient restClient) {
    this.restClient = restClient;
  }


  @Override
  public Health health() {
    if (!isRunning()) {
      return Health.down().withDetails(details).build();
    } else {
      return Health.up().build();
    }
  }

  private Boolean isRunning() {
    log.debug("Trying to open socket to {}:{}", host, port);

    try (var ignored = new Socket(host, port)) {
      log.debug("Successully opened socket to {}:{}", host, port);
    } catch (IOException e) {
      details.put("error", "Can't connect to fakedata backend server");
      log.error("Failed to open socket to {}:{}", host, port);
      return false;
    }

    var response = restClient.get(
        String.format("http://%s:%s/%s", host, port, healthcheck)
    ).asString();

    var statusCode = response.getStatus();
    var body = response.getBody();
    var expectedBody = "{\"status\":\"UP\"}";

    log.info("Status code: {}", statusCode);
    log.info("Healthcheck response: {}", body);

    if (response.getStatus() != 200) {
      log.error("Healtcheck failed - can't find healthcheck endpoint");
      details.put("healthcheck", "Can't find healthcheck endpoint");
      return false;
    }

    if (!body.equals(expectedBody)) {
      log.error("Healtcheck failed - response body is not as expected");
      log.error("Expected: {}, got: {}", expectedBody, body);
      details.put("healthcheck", "Response from healthcheck endpoind is invalid");
      return false;
    }

    return true;
  }
}
