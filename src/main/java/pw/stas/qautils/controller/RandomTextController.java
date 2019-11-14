package pw.stas.qautils.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static pw.stas.qautils.api.ControllerPaths.API_ROOT_PATH;
import static pw.stas.qautils.api.ControllerPaths.RANDOM_SENTENCE_GENERATOR_PATH;
import pw.stas.qautils.model.Sentence;
import pw.stas.qautils.service.RandomSentenceService;

@RestController
@RequestMapping(API_ROOT_PATH)
public class RandomTextController {

  private final RandomSentenceService randomSentenceService;

  @Autowired
  public RandomTextController(RandomSentenceService randomSentenceService) {
    this.randomSentenceService = randomSentenceService;
  }

  @GetMapping(value = RANDOM_SENTENCE_GENERATOR_PATH)
  public Sentence RandomSentenceJsonGenerator(@RequestParam(required = false) Integer count) {

    return randomSentenceService.getRandomSentence(count);
  }

  @GetMapping(value = RANDOM_SENTENCE_GENERATOR_PATH,
      produces = {MediaType.TEXT_PLAIN_VALUE})
  public String RandomSentenceTextGenerator(@RequestParam(required = false) Integer count) {

    return randomSentenceService.getRandomSentence(count).getSentence();
  }
}
