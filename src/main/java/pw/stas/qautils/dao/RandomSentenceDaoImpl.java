package pw.stas.qautils.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pw.stas.qautils.model.Sentence;
import pw.stas.qautils.util.RandomSentenceGenerator;

@Component
public class RandomSentenceDaoImpl implements RandomSentenceDao {

  private final RandomSentenceGenerator sentenceGenerator;
  private final Sentence sentence;

  @Autowired
  public RandomSentenceDaoImpl(RandomSentenceGenerator sentenceGenerator) {
    this.sentenceGenerator = sentenceGenerator;
    this.sentence = new Sentence();
  }

  @Override
  public Sentence getRandomSentence() {

    sentence.setSentence(sentenceGenerator.generate());

    return sentence;
  }

  @Override
  public void setSymbolsCount(Integer symbolsCount) {

    if(symbolsCount == null || symbolsCount < 0) {
      symbolsCount = 200;
    }

    sentence.setSymbolsCount(symbolsCount);
    sentenceGenerator.setSymbolsCount(symbolsCount);
  }
}
