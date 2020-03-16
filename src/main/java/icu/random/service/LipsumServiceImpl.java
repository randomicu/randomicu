package icu.random.service;

import icu.random.client.lipsum.LipsumClient;
import icu.random.dto.lipsum.LipsumDto;
import kong.unirest.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LipsumServiceImpl implements LipsumService {

  private final LipsumClient client;

  @Value("${randomicu.external.lipsum.default-bytes-count:300}")
  private Integer defaultLipsumBytesCount;

  @Value("${randomicu.external.lipsum.default-paragraphs-count:5}")
  private Integer defaultLipsumParagraphsCount;

  @Value("${randomicu.external.lipsum.default-words-count:150}")
  private Integer defaultLipsumWordsCount;

  @Value("${randomicu.external.lipsum.default-lists-count:3}")
  private Integer defaultLipsumListsCount;

  @Autowired
  public LipsumServiceImpl(LipsumClient client) {
    this.client = client;
  }

  @Override
  public HttpResponse<LipsumDto> getBytes(Integer amount, boolean startWithLorem) {
    var count = amount == null ? defaultLipsumBytesCount : amount;

    return client.getBytes(count, startWithLorem);
  }

  @Override
  public HttpResponse<LipsumDto> getParagraphs(Integer amount, boolean startWithLorem) {
    var count = amount == null ? defaultLipsumParagraphsCount : amount;

    return client.getParagraphs(count, startWithLorem);
  }

  @Override
  public HttpResponse<LipsumDto> getWords(Integer amount, boolean startWithLorem) {
    var count = amount == null ? defaultLipsumWordsCount : amount;

    return client.getWords(count, startWithLorem);
  }

  @Override
  public HttpResponse<LipsumDto> getLists(Integer amount, boolean startWithLorem) {
    var count = amount == null ? defaultLipsumListsCount : amount;

    return client.getLists(count, startWithLorem);
  }
}
