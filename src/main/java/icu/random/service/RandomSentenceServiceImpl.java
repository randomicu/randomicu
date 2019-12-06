package icu.random.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import icu.random.dao.RandomSentenceDao;
import icu.random.model.Sentence;

@Service
public class RandomSentenceServiceImpl implements RandomSentenceService {

  private final RandomSentenceDao randomSentenceDao;

  @Autowired
  public RandomSentenceServiceImpl(RandomSentenceDao randomSentenceDao) {
    this.randomSentenceDao = randomSentenceDao;
  }

  @Override
  public Sentence getRandomSentence(Integer symbolsCount) {
    randomSentenceDao.setSymbolsCount(symbolsCount);

    return randomSentenceDao.getRandomSentence();
  }

  @Override
  public Map<String, List<Sentence>> getRandomSentences(Integer symbolsCount, Integer sentencesCount) {
    randomSentenceDao.setSymbolsCount(symbolsCount);
    randomSentenceDao.setSentencesCount(sentencesCount);

    return randomSentenceDao.getRandomSentences();
  }
}
