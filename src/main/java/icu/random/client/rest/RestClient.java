package icu.random.client.rest;

import kong.unirest.GetRequest;

/**
 * Rest client for Lipsum.com API
 *
 */
public interface RestClient {

  /**
   * Send HTTP GET request to Lipsum.com API
   *
   * @return {@link GetRequest} object
   */
  GetRequest get(String path);
}
