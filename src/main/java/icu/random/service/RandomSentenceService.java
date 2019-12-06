package icu.random.service;

import java.util.List;
import java.util.Map;
import icu.random.model.Sentence;

public interface RandomSentenceService {

  Sentence getRandomSentence(Integer symbolsCount);

  Map<String, List<Sentence>> getRandomSentences(Integer count, Integer sentencesCount);
}
