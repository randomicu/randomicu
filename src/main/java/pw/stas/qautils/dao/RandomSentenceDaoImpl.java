package pw.stas.qautils.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pw.stas.qautils.model.Sentence;
import pw.stas.qautils.model.Sentences;
import pw.stas.qautils.util.RandomSentenceGenerator;

@Component
public class RandomSentenceDaoImpl implements RandomSentenceDao {

  private final RandomSentenceGenerator sentenceGenerator;
  private final Sentence sentence;
  private final Sentences sentences;

  @Value("${qa-utils.sentence.default-length:100}")
  private Integer sentenceDefaultLength;

  @Value("${qa-utils.sentences-count.default:2}")
  private Integer sentencesDefaultCount;

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
    var count = symbolsCount;

    if (count == null || count < 0) {
      count = sentenceDefaultLength;
    }

    sentence.setSymbolsCount(count);
    sentenceGenerator.setSymbolsCount(count);
  }

  @Override
  public void setSentencesCount(Integer sentencesCount) {
    var count = sentencesCount;

    if (count == null || count < 0) {
      count = sentencesDefaultCount;
    }

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
}
