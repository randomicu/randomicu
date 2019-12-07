package icu.random.service;

import icu.random.model.Sentence;
import java.util.List;
import java.util.Map;

public interface RandomSentenceService {

  Sentence getRandomSentence(Integer symbolsCount, boolean isParagraphEnabled);

  Map<String, List<Sentence>> getRandomSentences(Integer count, Integer sentencesCount, boolean isParagraphsEnabled);
}
