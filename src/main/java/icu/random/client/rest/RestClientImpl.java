package icu.random.client.rest;

import kong.unirest.GetRequest;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;

/**
 * {@inheritDoc}
 */
@Component
public class RestClientImpl implements RestClient {

  @Override
  public GetRequest get(String path) {
    return Unirest.get(path);
  }
}
