package icu.random.client.rest;

import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;

/**
 * Rest client for Lipsum.com API
 *
 */
public interface RestClient {

  /**
   * Send HTTP GET request to Lipsum.com API
   *
   * @return {@link HttpResponse} object
   */
  <T> HttpResponse<T> get(String path, Class<T> clazz);

  GetRequest get(String path);
}
