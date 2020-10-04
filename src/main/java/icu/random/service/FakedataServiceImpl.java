package icu.random.service;

import icu.random.client.fakedata.FakedataClient;
import icu.random.dto.fakedata.AddressDto;
import icu.random.dto.fakedata.PersonDto;
import icu.random.exception.IncorrectLanguageException;
import java.util.Set;
import kong.unirest.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FakedataServiceImpl implements FakedataService {

  private final Set<String> ALLOWED_LANGUAGES = Set.of("ru", "en");
  private final FakedataClient client;

  @Autowired
  public FakedataServiceImpl(FakedataClient client) {
    this.client = client;
  }

  @Override
  public HttpResponse<AddressDto> getAddress(String language) {
    this.checkLanguage(language);

    return this.client.getAdress(language);
  }

  @Override
  public HttpResponse<PersonDto> getPerson(String language) {
    this.checkLanguage(language);

    return this.client.getPerson(language);
  }

  private void checkLanguage(String language) {
    if (!ALLOWED_LANGUAGES.contains(language)) {
      throw new IncorrectLanguageException(String.format("Incorrect locale, use one of: %s", ALLOWED_LANGUAGES));
    }
  }
}
