package icu.random.client.lipsum;

import icu.random.client.rest.RestClient;
import icu.random.client.rest.RestClientImpl;
import icu.random.dto.lipsum.LipsumDto;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Map;
import kong.unirest.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LipsumClientImpl implements LipsumClient {

  private final RestClient restClient;

  @Value("${randomicu.external.lipsum.remote-url}")
  private String lipsumRemoteUrl;

  @Autowired
  public LipsumClientImpl(RestClientImpl restClient) {
    this.restClient = restClient;
  }

  @Override
  public HttpResponse<LipsumDto> getBytes(int amount, boolean startWithLorem) {
    Map<String, Object> params = Map.of("lipsumType", "bytes",
        "amount", amount,
        "startWithLorem", startWithLorem ? "yes" : "no");

    log.info("Params for request (getBytes): {}", params);
    return this.getResponse(params);
  }

  @Override
  public HttpResponse<LipsumDto> getParagraphs(int amount, boolean startWithLorem) {
    Map<String, Object> params = Map.of("lipsumType", "paras",
        "amount", amount,
        "startWithLorem", startWithLorem ? "yes" : "no");

    log.info("Params for request (getParagraphs): {}", params);
    return this.getResponse(params);
  }

  @Override
  public HttpResponse<LipsumDto> getWords(int amount, boolean startWithLorem) {
    Map<String, Object> params = Map.of("lipsumType", "words",
        "amount", amount,
        "startWithLorem", startWithLorem ? "yes" : "no");

    log.info("Params for request (getWords): {}", params);
    return this.getResponse(params);
  }

  @Override
  public HttpResponse<LipsumDto> getLists(int amount, boolean startWithLorem) {
    Map<String, Object> params = Map.of("lipsumType", "lists",
        "amount", amount,
        "startWithLorem", startWithLorem ? "yes" : "no");

    log.info("Params for request (getLists): {}", params);
    return this.getResponse(params);
  }

  private HttpResponse<LipsumDto> getResponse(Map<String, Object> params) {
    var request = restClient.get(lipsumRemoteUrl)
        .routeParam(params);

    var url = request.getUrl();
    log.info("Prepare request to url: {}", URLDecoder.decode(url, Charset.defaultCharset()));

    return request.asObject(LipsumDto.class)
        .ifSuccess(r -> {
          log.info("Request finished successfully. Status code: {}", r.getStatus());
        })
        .ifFailure(r -> {
          log.error("Request finished with error. Status code: {}", r.getStatus());
        });
  }
}
