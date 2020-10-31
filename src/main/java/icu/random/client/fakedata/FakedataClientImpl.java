package icu.random.client.fakedata;

import icu.random.client.rest.RestClient;
import icu.random.dto.fakedata.AddressDto;
import icu.random.dto.fakedata.PersonDto;
import icu.random.exception.HttpClientFailureException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Map;
import kong.unirest.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FakedataClientImpl implements FakedataClient {

  private final RestClient httpClient;

  @Value("${randomicu.fakedata.remote-url}")
  private String fakedataUrl;

  @Value("${randomicu.fakedata.remote-url.address-endpoint}")
  private String addressEndpoint;

  @Value("${randomicu.fakedata.remote-url.person-endpoint}")
  private String personEndpoint;


  @Autowired
  public FakedataClientImpl(RestClient client) {
    this.httpClient = client;
  }

  @Override
  public HttpResponse<AddressDto> getAdress(String language) {
    return this.getResponse(
        Map.of("locale", language,
            "endpoint", addressEndpoint),
        AddressDto.class
    );
  }

  @Override
  public HttpResponse<PersonDto> getPerson(String language) {
    return this.getResponse(
        Map.of("locale", language,
            "endpoint", personEndpoint),
        PersonDto.class
    );
  }

  private <T> HttpResponse<T> getResponse(Map<String, Object> params, Class<T> clazz) {
    var request = httpClient.get(fakedataUrl).routeParam(params);

    var url = request.getUrl();
    log.info("Prepare request to url: {}", URLDecoder.decode(url, Charset.defaultCharset()));

    return request.asObject(clazz)
        .ifSuccess(r -> log.info("Request finished successfully. Status code: {}", r.getStatus()))
        .ifFailure(r -> {
          var status = r.getStatus();
          log.error("Request finished with error. Status code: {}", status);

          r.getParsingError().ifPresent(e -> {
            log.error("Parsing Exception: {}", e.toString());
            log.error("Original Body: {}", e.getOriginalBody());
          });

          if (status == HttpStatus.NOT_FOUND.value()) {
            throw new HttpClientFailureException(String.format("Status code from Fakedata backend: %d. " +
                "Possible invalid url: %s", status, url), HttpStatus.NOT_FOUND);
          }

          throw new HttpClientFailureException(String.format("Status code from Fakedata backend: %d. " +
              "Possible invalid url: %s", status, url), HttpStatus.BAD_REQUEST);
        });
  }
}
