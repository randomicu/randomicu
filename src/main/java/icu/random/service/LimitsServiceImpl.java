package icu.random.service;

import icu.random.dto.lipsum.LipsumLimitsDto;
import icu.random.dto.sentence.SentenceLimitsDto;
import icu.random.util.event.EventSender;
import icu.random.util.event.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LimitsServiceImpl implements LimitsService {

  private final SentenceLimitsDto sentenceLimits;
  private final LipsumLimitsDto lipsumLimits;
  private final EventSender eventSender;

  @Value("${randomicu.sentence.default-length}")
  private Integer defaultSentenceLength;

  @Value("${randomicu.sentence.default-sentences-count}")
  private Integer defaultSentencesCount;

  @Value("${randomicu.sentence.max-sentence-length}")
  private Integer maxSentenceLength;

  @Value("${randomicu.sentence.max-sentences-count}")
  private Integer maxSentencesCount;

  @Value("${randomicu.sentence.max-word-length}")
  private Integer maxWordLength;

  @Value("${randomicu.sentence.min-word-length}")
  private Integer minWordLength;

  @Value("${randomicu.external.lipsum.default-bytes-count}")
  private Integer defaultBytesCount;

  @Value("${randomicu.external.lipsum.default-paragraphs-count}")
  private Integer defaultParagraphsCount;

  @Value("${randomicu.external.lipsum.default-words-count}")
  private Integer defaultWordsCount;

  @Value("${randomicu.external.lipsum.default-lists-count}")
  private Integer defaultListsCount;

  @Autowired
  public LimitsServiceImpl(EventSender eventSender) {
    this.eventSender = eventSender;
    this.sentenceLimits = new SentenceLimitsDto();
    this.lipsumLimits = new LipsumLimitsDto();
  }

  @Override
  public SentenceLimitsDto getSentenceLimits() {

    this.sentenceLimits.setDefaultSentenceLength(defaultSentenceLength);
    this.sentenceLimits.setDefaultSentencesCount(defaultSentencesCount);
    this.sentenceLimits.setMaxSentenceLength(maxSentenceLength);
    this.sentenceLimits.setMaxSentencesCount(maxSentencesCount);
    this.sentenceLimits.setMaxWordLength(maxWordLength);
    this.sentenceLimits.setMinWordLength(minWordLength);

    eventSender.send(EventType.sentence_limits);

    return this.sentenceLimits;
  }

  @Override
  public LipsumLimitsDto getLipsumLimits() {

    this.lipsumLimits.setDefaultBytesCount(defaultBytesCount);
    this.lipsumLimits.setDefaultParagraphsCount(defaultParagraphsCount);
    this.lipsumLimits.setDefaultWordsCount(defaultWordsCount);
    this.lipsumLimits.setDefaultListsCount(defaultListsCount);

    eventSender.send(EventType.lorem_limits);

    return this.lipsumLimits;
  }
}
