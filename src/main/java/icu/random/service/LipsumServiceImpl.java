package icu.random.service;

import icu.random.client.lipsum.LipsumClient;
import icu.random.dto.lipsum.LipsumDto;
import icu.random.util.event.EventSender;
import icu.random.util.event.EventType;
import kong.unirest.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LipsumServiceImpl implements LipsumService {

  private final LipsumClient client;
  private final EventSender eventSender;

  @Value("${randomicu.external.lipsum.default-bytes-count:300}")
  private Integer defaultLipsumBytesCount;

  @Value("${randomicu.external.lipsum.default-paragraphs-count:5}")
  private Integer defaultLipsumParagraphsCount;

  @Value("${randomicu.external.lipsum.default-words-count:150}")
  private Integer defaultLipsumWordsCount;

  @Value("${randomicu.external.lipsum.default-lists-count:3}")
  private Integer defaultLipsumListsCount;

  @Autowired
  public LipsumServiceImpl(LipsumClient client, EventSender eventSender) {
    this.client = client;
    this.eventSender = eventSender;
  }

  @Override
  public HttpResponse<LipsumDto> getBytes(Integer amount, boolean startWithLorem) {
    var count = amount == null ? defaultLipsumBytesCount : amount;

    eventSender.send(EventType.lorem_bytes);

    return client.getBytes(count, startWithLorem);
  }

  @Override
  public HttpResponse<LipsumDto> getParagraphs(Integer amount, boolean startWithLorem) {
    var count = amount == null ? defaultLipsumParagraphsCount : amount;

    eventSender.send(EventType.lorem_paragraphs);

    return client.getParagraphs(count, startWithLorem);
  }

  @Override
  public LipsumDto getParagraphsWithBreak(Integer amount, boolean startWithLorem, boolean additionalBreak) {
    var count = amount == null ? defaultLipsumParagraphsCount : amount;
    var paragraphs = client.getParagraphs(count, startWithLorem);

    eventSender.send(EventType.lorem_paragraphs_break);

    return insertAdditionalBreakTo(paragraphs);
  }

  @Override
  public HttpResponse<LipsumDto> getWords(Integer amount, boolean startWithLorem) {
    var count = amount == null ? defaultLipsumWordsCount : amount;

    eventSender.send(EventType.lorem_words);

    return client.getWords(count, startWithLorem);
  }

  @Override
  public HttpResponse<LipsumDto> getLists(Integer amount, boolean startWithLorem) {
    var count = amount == null ? defaultLipsumListsCount : amount;

    eventSender.send(EventType.lorem_lists);

    return client.getLists(count, startWithLorem);
  }

  private LipsumDto insertAdditionalBreakTo(HttpResponse<LipsumDto> response) {
    var lipsumDto = response.getBody();
    String originalLipsum = lipsumDto.getFeed().getLipsum();
    String replacedLipsum = originalLipsum.replace("\n", "\n\n");
    lipsumDto.getFeed().setLipsum(replacedLipsum);

    return lipsumDto;
  }

}
