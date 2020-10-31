package icu.random.util.healthcheck;

import java.io.IOException;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Slf4j
@Component("fakedata-backend")
public class FakedataHealthIndicator implements HealthIndicator {

  @Value("${randomicu.fakedata.url}")
  private String url;
  
  @Value("${randomicu.fakedata.port}")
  private Integer port;


  @Override
  public Health health() {
    if (!isRunning()) {
      return Health.down().withDetail("error", "Can't connect to fakedata backend server").build();
    } else {
      return Health.up().build();
    }
  }

  private Boolean isRunning() {
    try (var ignored = new Socket(url, port)) {
      log.debug("Successully opened socket to {}:{}", url, port);
    } catch (IOException e) {
      log.error("Failed to open socket to {}:{}", url, port);
      return false;
    }
    return true;
  }
}
