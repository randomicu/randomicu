package icu.random.service;

import icu.random.dto.LimitsDto;
import icu.random.dto.sentence.SentenceDto;
import java.util.List;
import java.util.Map;

public interface RandomSentenceService {

  SentenceDto getRandomSentence(Integer symbolsCount, boolean isParagraphEnabled);

  Map<String, List<SentenceDto>> getRandomSentences(Integer count, Integer sentencesCount, boolean isParagraphsEnabled);

  LimitsDto getCurrentLimits();
}
