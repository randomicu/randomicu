package icu.random.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import icu.random.model.Sentence;
import icu.random.model.Sentences;
import icu.random.util.RandomSentenceGenerator;

@Component
public class RandomSentenceDaoImpl implements RandomSentenceDao {

  private final RandomSentenceGenerator sentenceGenerator;
  private final Sentence sentence;
  private final Sentences sentences;

  @Value("${randomicu.sentence.default-length}")
  private Integer defaultSentenceLength;

  @Value("${randomicu.sentence.default-sentences-count}")
  private Integer defaultSentencesCount;

  @Value("${randomicu.sentence.max-sentence-length}")
  private Integer maxSentenceLength;

  @Value("${randomicu.sentence.max-sentences-count}")
  private Integer maxSentencesCount;


  @Autowired
  public RandomSentenceDaoImpl(RandomSentenceGenerator sentenceGenerator) {
    this.sentenceGenerator = sentenceGenerator;
    this.sentence = new Sentence();
    this.sentences = new Sentences();
  }

  @Override
  public Sentence getRandomSentence() {
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
  public Map<String, List<Sentence>> getRandomSentences() {
    List<Sentence> sentenceList = Stream.generate(
        () -> {
          var tempSentence = new Sentence();
          tempSentence.setSymbolsCount(this.sentenceGenerator.getSymbolsCount());
          tempSentence.setSentence(this.sentenceGenerator.generate());
          return tempSentence;
        })
        .limit(this.sentences.getSentencesCount())
        .collect(Collectors.toList());

    Map<String, List<Sentence>> sentencesMap = new HashMap<>();
    sentencesMap.put("sentences", sentenceList);

    return sentencesMap;
  }

  @Override
  public void enableParagraphs(boolean isParagraphsEnabled) {
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
