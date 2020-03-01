package icu.random.controller.api;

import static icu.random.api.ApiControllerPaths.API_ROOT_PATH;
import static icu.random.api.ApiControllerPaths.API_VERSION;
import static icu.random.api.ApiControllerPaths.LIPSUM_LIMITS_PATH;
import static icu.random.api.ApiControllerPaths.SENTENCE_LIMITS_PATH;
import icu.random.dto.lipsum.LipsumLimitsDto;
import icu.random.dto.sentence.SentenceLimitsDto;
import icu.random.service.LimitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API_ROOT_PATH + API_VERSION)
public class LimitsController {

  private final LimitsService sentenceLimitsService;

  @Autowired
  public LimitsController(LimitsService sentenceLimitsService) {
    this.sentenceLimitsService = sentenceLimitsService;
  }

  @GetMapping(value = SENTENCE_LIMITS_PATH)
  public SentenceLimitsDto sentenceLimits() {

    return sentenceLimitsService.getSentenceLimits();
  }

  @GetMapping(value = LIPSUM_LIMITS_PATH)
  public LipsumLimitsDto lipsumLimits() {

    return sentenceLimitsService.getLipsumLimits();
  }
}
