package icu.random.service;

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
import org.springframework.stereotype.Service;

@Service
public class RandomSentenceServiceImpl implements RandomSentenceService {

  // <editor-fold desc="Fields and variables from config files">
  private final RandomSentenceGenerator sentenceGenerator;
  private final SentenceDto sentence;
  private final SentencesDto sentences;

  @Value("${randomicu.sentence.default-length}")
  private Integer defaultSentenceLength;

  @Value("${randomicu.sentence.default-sentences-count}")
  private Integer defaultSentencesCount;

  @Value("${randomicu.sentence.max-sentence-length}")
  private Integer maxSentenceLength;

  @Value("${randomicu.sentence.max-sentences-count}")
  private Integer maxSentencesCount;
  // </editor-fold>

  @Autowired
  public RandomSentenceServiceImpl(RandomSentenceGenerator sentenceGenerator) {
    this.sentenceGenerator = sentenceGenerator;
    this.sentence = new SentenceDto();
    this.sentences = new SentencesDto();
  }

  @Override
  public SentenceDto getRandomSentence(Integer symbolsCount, boolean isParagraphEnabled) {
    this.setSymbolsCount(symbolsCount);
    this.enableParagraphs(isParagraphEnabled);

    return this.getRandomSentence();
  }

  @Override
  public Map<String, List<SentenceDto>> getRandomSentences(Integer count, Integer sentencesCount, boolean isParagraphsEnabled) {
    this.setSentencesCount(sentencesCount);
    this.setSymbolsCount(count);
    this.enableParagraphs(isParagraphsEnabled);

    return getRandomSentences();
  }

  private SentenceDto getRandomSentence() {
    sentence.setSentence(sentenceGenerator.generate());

    return sentence;
  }

  private Map<String, List<SentenceDto>> getRandomSentences() {
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

  private void setSymbolsCount(Integer symbolsCount) {
    var count = checkIfSymbolsCountValid(symbolsCount) ? symbolsCount : defaultSentenceLength;

    sentence.setSymbolsCount(count);
    sentenceGenerator.setSymbolsCount(count);
  }

  private void setSentencesCount(Integer sentencesCount) {
    var count = checkIfSentencesCountValid(sentencesCount) ? sentencesCount : defaultSentencesCount;

    sentences.setSentencesCount(count);
  }

  private void enableParagraphs(boolean isParagraphsEnabled) {
    sentenceGenerator.setParagraphsEnabled(isParagraphsEnabled);
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
