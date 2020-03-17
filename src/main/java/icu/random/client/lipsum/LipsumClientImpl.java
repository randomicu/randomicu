package icu.random.client.lipsum;

import icu.random.client.rest.RestClient;
import icu.random.client.rest.RestClientImpl;
import icu.random.dto.lipsum.LipsumDto;
import java.util.Map;
import kong.unirest.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LipsumClientImpl implements LipsumClient {

  private final RestClient client;

  @Value("${randomicu.external.lipsum.remote-url}")
  private String lipsumRemoteUrl;

  @Autowired
  public LipsumClientImpl(RestClientImpl client) {
    this.client = client;
  }

  @Override
  public HttpResponse<LipsumDto> getBytes(int amount, boolean startWithLorem) {
    Map<String, Object> params = Map.of("lipsumType", "bytes",
        "amount", amount,
        "startWithLorem", startWithLorem ? "yes" : "no");

    return this.getResponse(params);
  }

  @Override
  public HttpResponse<LipsumDto> getParagraphs(int amount, boolean startWithLorem) {
    Map<String, Object> params = Map.of("lipsumType", "paras",
        "amount", amount,
        "startWithLorem", startWithLorem ? "yes" : "no");

    return this.getResponse(params);
  }

  @Override
  public HttpResponse<LipsumDto> getWords(int amount, boolean startWithLorem) {
    Map<String, Object> params = Map.of("lipsumType", "words",
        "amount", amount,
        "startWithLorem", startWithLorem ? "yes" : "no");

    return this.getResponse(params);
  }

  @Override
  public HttpResponse<LipsumDto> getLists(int amount, boolean startWithLorem) {
    Map<String, Object> params = Map.of("lipsumType", "lists",
        "amount", amount,
        "startWithLorem", startWithLorem ? "yes" : "no");

    return this.getResponse(params);
  }

  private HttpResponse<LipsumDto> getResponse(Map<String, Object> params) {
//    return client.get("https://lipsum.com/feed/json?what={lipsumType}&amount={amount}&start={startWithLorem}")
    return client.get(lipsumRemoteUrl)
        .routeParam(params)
        .asObject(LipsumDto.class);
  }
}
