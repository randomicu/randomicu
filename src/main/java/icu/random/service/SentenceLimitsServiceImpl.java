package icu.random.service;

import icu.random.dto.SentenceLimitsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SentenceLimitsServiceImpl implements SentenceLimitsService {

  private final SentenceLimitsDto limits;

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

  public SentenceLimitsServiceImpl() {
    this.limits = new SentenceLimitsDto();
  }

  @Override
  public SentenceLimitsDto getSentenceLimits() {
    this.limits.setDefaultSentenceLength(defaultSentenceLength);
    this.limits.setDefaultSentencesCount(defaultSentencesCount);
    this.limits.setMaxSentenceLength(maxSentenceLength);
    this.limits.setMaxSentencesCount(maxSentencesCount);
    this.limits.setMaxWordLength(maxWordLength);
    this.limits.setMinWordLength(minWordLength);

    return this.limits;
  }
}
