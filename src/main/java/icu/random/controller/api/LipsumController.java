package icu.random.controller.api;

import static icu.random.api.ApiControllerPaths.API_ROOT_PATH;
import static icu.random.api.ApiControllerPaths.API_VERSION;
import static icu.random.api.ApiControllerPaths.LOREM_AS_BYTES_PATH;
import static icu.random.api.ApiControllerPaths.LOREM_AS_LISTS_PATH;
import static icu.random.api.ApiControllerPaths.LOREM_AS_PARAGRAPHS_PATH;
import static icu.random.api.ApiControllerPaths.LOREM_AS_WORDS_PATH;
import icu.random.dto.lipsum.LipsumDto;
import icu.random.dto.sentence.SentenceDto;
import icu.random.service.LipsumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(API_ROOT_PATH + API_VERSION)
public class LipsumController {

  private final LipsumService lipsumService;

  @Autowired
  public LipsumController(LipsumService lipsumService) {
    this.lipsumService = lipsumService;
  }

  @GetMapping(LOREM_AS_BYTES_PATH)
  public SentenceDto bytesGenerator(@RequestParam(required = false) Integer count,
                                    @RequestParam(required = false, defaultValue = "true") Boolean startWithLorem) {
    var lipsumDto = lipsumService.getBytes(count, startWithLorem).getBody();

    return LipsumDto.convertToSentence(lipsumDto);
  }

  @GetMapping(LOREM_AS_PARAGRAPHS_PATH)
  public SentenceDto paragraphsGenerator(@RequestParam(required = false) Integer count,
                                         @RequestParam(required = false, defaultValue = "true") Boolean startWithLorem,
                                         @RequestParam(required = false, defaultValue = "true") Boolean additionalBreak) {
    LipsumDto lipsumDto;

    if (additionalBreak) {
      lipsumDto = lipsumService.getParagraphsWithBreak(count, startWithLorem, true);
    } else {
      lipsumDto = lipsumService.getParagraphs(count, startWithLorem).getBody();
    }
    return LipsumDto.convertToSentence(lipsumDto);
  }

  @GetMapping(LOREM_AS_WORDS_PATH)
  public SentenceDto wordsGenerator(@RequestParam(required = false) Integer count,
                                    @RequestParam(required = false, defaultValue = "true") Boolean startWithLorem) {
    var lipsumDto = lipsumService.getWords(count, startWithLorem).getBody();

    return LipsumDto.convertToSentence(lipsumDto);
  }

  @GetMapping(LOREM_AS_LISTS_PATH)
  public SentenceDto listsGenerator(@RequestParam(required = false) Integer count,
                                    @RequestParam(required = false, defaultValue = "true") Boolean startWithLorem) {
    var lipsumDto = lipsumService.getLists(count, startWithLorem).getBody();

    return LipsumDto.convertToSentence(lipsumDto);
  }
}
