package pw.stas.qautils.service;

import java.util.List;
import java.util.Map;
import pw.stas.qautils.model.Sentence;

public interface RandomSentenceService {

  Sentence getRandomSentence(Integer symbolsCount);

  Map<String, List<Sentence>> getRandomSentences(Integer count, Integer sentencesCount);
}
