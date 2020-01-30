package icu.random.dao;

import icu.random.model.Limits;
import icu.random.model.Sentence;
import java.util.List;
import java.util.Map;

public interface RandomSentenceDao {

  Sentence getRandomSentence();
  
  void setSymbolsCount(Integer symbolsCount);
  
  void setSentencesCount(Integer sentencesCount);

  void enableParagraphs(boolean isParagraphsEnabled);

  Map<String, List<Sentence>> getRandomSentences();

  Limits getCurrentLimits();
}
