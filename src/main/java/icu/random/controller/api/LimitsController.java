package icu.random.controller.api;

import static icu.random.api.ApiControllerPaths.API_ROOT_PATH;
import static icu.random.api.ApiControllerPaths.API_VERSION;
import static icu.random.api.ApiControllerPaths.CURRENT_LIMITS_PATH;
import icu.random.dto.SentenceLimitsDto;
import icu.random.service.SentenceLimitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API_ROOT_PATH + API_VERSION)
public class LimitsController {

  private final SentenceLimitsService sentenceLimitsService;

  @Autowired
  public LimitsController(SentenceLimitsService sentenceLimitsService) {
    this.sentenceLimitsService = sentenceLimitsService;
  }

  @GetMapping(value = CURRENT_LIMITS_PATH)
  public SentenceLimitsDto generatorCurrentLimits() {

    return sentenceLimitsService.getSentenceLimits();
  }
}
