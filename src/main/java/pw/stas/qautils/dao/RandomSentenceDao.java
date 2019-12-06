package pw.stas.qautils.dao;

import java.util.List;
import java.util.Map;
import pw.stas.qautils.model.Sentence;

public interface RandomSentenceDao {

  Sentence getRandomSentence();
  
  void setSymbolsCount(Integer symbolsCount);
  
  void setSentencesCount(Integer sentencesCount);

  Map<String, List<Sentence>> getRandomSentences();
}
