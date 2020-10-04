package icu.random.client.fakedata;

import icu.random.dto.fakedata.AddressDto;
import icu.random.dto.fakedata.PersonDto;
import kong.unirest.HttpResponse;

public interface FakedataClient {
  HttpResponse<AddressDto> getAdress(String language);
  HttpResponse<PersonDto> getPerson(String language);
}
