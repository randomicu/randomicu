package icu.random.client.fakedata;

import icu.random.client.rest.RestClient;
import icu.random.dto.fakedata.AddressDto;
import icu.random.dto.fakedata.PersonDto;
import icu.random.exception.HttpClientFailureException;
import java.util.Map;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


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
    var request = this.getRequest(
        Map.of("locale", language,
            "endpoint", addressEndpoint)
    );

    String url = request.getUrl();

    return httpClient.get(url).asObject(AddressDto.class)
        .ifFailure(r -> {
          throw new HttpClientFailureException(String.format("Status code from Fakedata backend: %d. " +
              "Possible invalid url: %s", r.getStatus(), url));
        });
  }

  @Override
  public HttpResponse<PersonDto> getPerson(String language) {
    var request = this.getRequest(
        Map.of("locale", language,
            "endpoint", personEndpoint)
    );

    String url = request.getUrl();

    return request.asObject(PersonDto.class)
        .ifFailure(r -> {
          throw new HttpClientFailureException(String.format("Status code from Fakedata backend: %d. " +
              "Possible invalid url: %s", r.getStatus(), url));
        });
  }

  private GetRequest getRequest(Map<String, Object> params) {
    return httpClient.get(fakedataUrl)
        .routeParam(params);
  }
}
