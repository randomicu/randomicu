package icu.random.controller.api;

import static icu.random.api.ApiControllerPaths.API_ROOT_PATH;
import static icu.random.api.ApiControllerPaths.API_VERSION;
import static icu.random.api.ApiControllerPaths.FAKEDATA_ADDRESS;
import static icu.random.api.ApiControllerPaths.FAKEDATA_PERSON;
import icu.random.dto.fakedata.AddressDto;
import icu.random.dto.fakedata.PersonDto;
import icu.random.service.FakedataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API_ROOT_PATH + API_VERSION)
public class FakedataController {

  private final FakedataService fakedataService;

  @Autowired
  public FakedataController(FakedataService fakedataService) {
    this.fakedataService = fakedataService;
  }

  @GetMapping(value = FAKEDATA_ADDRESS)
  public AddressDto address(@PathVariable() String language ) {
    return fakedataService.getAddress(language).getBody();
  }

  @GetMapping(value = FAKEDATA_PERSON)
  public PersonDto person(@PathVariable() String language ) {
    return fakedataService.getPerson(language).getBody();
  }
}
