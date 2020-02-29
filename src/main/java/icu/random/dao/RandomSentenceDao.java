package icu.random.dao;

import icu.random.dto.LimitsDto;
import icu.random.dto.sentence.SentenceDto;
import java.util.List;
import java.util.Map;

public interface RandomSentenceDao {

  SentenceDto getRandomSentence();
  
  void setSymbolsCount(Integer symbolsCount);
  
  void setSentencesCount(Integer sentencesCount);

  void enableParagraphs(boolean isParagraphsEnabled);

  Map<String, List<SentenceDto>> getRandomSentences();

  LimitsDto getCurrentLimits();
}
