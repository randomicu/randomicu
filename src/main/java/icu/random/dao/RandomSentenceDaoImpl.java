package icu.random.dao;

import icu.random.dto.LimitsDto;
import icu.random.dto.sentence.SentenceDto;
import icu.random.dto.sentence.SentencesDto;
import icu.random.util.RandomSentenceGenerator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomSentenceDaoImpl implements RandomSentenceDao {

  private final RandomSentenceGenerator sentenceGenerator;
  private final SentenceDto sentence;
  private final SentencesDto sentences;
  private final LimitsDto limits;

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

  @Autowired
  public RandomSentenceDaoImpl(RandomSentenceGenerator sentenceGenerator) {
    this.sentenceGenerator = sentenceGenerator;
    this.sentence = new SentenceDto();
    this.sentences = new SentencesDto();
    this.limits = new LimitsDto();
  }

  @Override
  public SentenceDto getRandomSentence() {
    sentence.setSentence(sentenceGenerator.generate());

    return sentence;
  }

  @Override
  public void setSymbolsCount(Integer symbolsCount) {
    var count = checkIfSymbolsCountValid(symbolsCount) ? symbolsCount : defaultSentenceLength;

    sentence.setSymbolsCount(count);
    sentenceGenerator.setSymbolsCount(count);
  }

  @Override
  public void setSentencesCount(Integer sentencesCount) {
    var count = checkIfSentencesCountValid(sentencesCount) ? sentencesCount : defaultSentencesCount;

    sentences.setSentencesCount(count);
  }

  @Override
  public Map<String, List<SentenceDto>> getRandomSentences() {
    List<SentenceDto> sentenceList = Stream.generate(
        () -> {
          var tempSentence = new SentenceDto();
          tempSentence.setSymbolsCount(this.sentenceGenerator.getSymbolsCount());
          tempSentence.setSentence(this.sentenceGenerator.generate());
          return tempSentence;
        })
        .limit(this.sentences.getSentencesCount())
        .collect(Collectors.toList());

    return Map.of("sentences", sentenceList);
  }

  @Override
  public void enableParagraphs(boolean isParagraphsEnabled) {
    sentenceGenerator.setParagraphsEnabled(isParagraphsEnabled);
  }

  @Override
  public LimitsDto getCurrentLimits() {
    this.limits.setDefaultSentenceLength(defaultSentenceLength);
    this.limits.setDefaultSentencesCount(defaultSentencesCount);
    this.limits.setMaxSentenceLength(maxSentenceLength);
    this.limits.setMaxSentencesCount(maxSentencesCount);
    this.limits.setMaxWordLength(maxWordLength);
    this.limits.setMinWordLength(minWordLength);

    return this.limits;
  }

  private boolean checkIfSymbolsCountValid(Integer symbolsCount) {
    if (checkifNotNull(symbolsCount) && symbolsCount > 0) {
      return symbolsCount <= maxSentenceLength;
    }
    return false;
  }

  private boolean checkIfSentencesCountValid(Integer sentencesCount) {
    if (checkifNotNull(sentencesCount) && sentencesCount > 0) {
      return sentencesCount <= maxSentencesCount;
    }
    return false;
  }

  private boolean checkifNotNull(Integer count) {
    return Objects.nonNull(count);
  }
}
