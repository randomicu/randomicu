package icu.random.client.rest;

import icu.random.client.rest.RestClient;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.stereotype.Component;

/**
 * {@inheritDoc}
 */
@Component
public class RestClientImpl implements RestClient {

  /**
   * @param <T> a Http Response holding a specific type of body
   *
   * @return {@link HttpResponse} object
   */
  @Override
  public <T> HttpResponse<T> get(String path, Class<T> clazz) {
    return Unirest.get(path).asObject(clazz);
  }

  @Override
  public GetRequest get(String path) {
    return Unirest.get(path);
  }
}
