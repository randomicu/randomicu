package pw.stas.qautils.dao;

import pw.stas.qautils.model.Sentence;

public interface RandomSentenceDao {

  Sentence getRandomSentence();
  void setSymbolsCount(Integer symbolsCount);

}
