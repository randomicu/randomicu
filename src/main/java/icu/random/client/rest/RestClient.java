package icu.random.client.rest;

import kong.unirest.GetRequest;

/**
 * Rest client for remote API
 *
 */
public interface RestClient {

  /**
   * Send HTTP GET request to Lipsum.com API
   * @param path full url where make request (https://www.example.com)
   * @return {@link GetRequest} object
   */
  GetRequest get(String path);
}
