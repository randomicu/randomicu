package icu.random.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import kong.unirest.HeaderNames;
import kong.unirest.Unirest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

@Configuration
public class UnirestConfiguration {

  private static final int CONNECT_TIMEOUT_MS = 1000;

  @PostConstruct
  public void postConstruct() {
    Unirest.config()
        .connectTimeout(CONNECT_TIMEOUT_MS)
        .followRedirects(false)
        .enableCookieManagement(false)
        .setDefaultHeader(HeaderNames.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
  }

  @PreDestroy
  public void preDestroy() {
    Unirest.config().reset();
    Unirest.config().shutDown(true);
  }
}
