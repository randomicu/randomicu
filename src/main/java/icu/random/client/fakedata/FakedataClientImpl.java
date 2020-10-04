package icu.random.client.fakedata;

import icu.random.client.rest.RestClient;
import icu.random.dto.fakedata.AddressDto;
import icu.random.dto.fakedata.PersonDto;
import kong.unirest.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class FakedataClientImpl implements FakedataClient {

  private final RestClient client;

  @Value("${randomicu.fakedata.remote-url}")
  private String fakedataUrl;

  @Value("${randomicu.fakedata.remote-url.address-endpoint}")
  private String addressEndpoint;

  @Value("${randomicu.fakedata.remote-url.person-endpoint}")
  private String personEndpoint;



  @Autowired
  public FakedataClientImpl(RestClient client) {
    this.client = client;
  }

  @Override
  public HttpResponse<AddressDto> getAdress(String language) {
    String url = String.format(fakedataUrl, language, personEndpoint);

    return client.get(url).asObject(AddressDto.class);
  }

  @Override
  public HttpResponse<PersonDto> getPerson(String language) {
    String url = String.format(fakedataUrl, language, personEndpoint);

    return client.get(url).asObject(PersonDto.class);
  }
}
