package pw.stas.qautils.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pw.stas.qautils.dao.RandomSentenceDao;
import pw.stas.qautils.model.Sentence;

@Service
public class RandomSentenceServiceImpl implements RandomSentenceService {

  private final RandomSentenceDao randomSentenceDao;

  @Autowired
  public RandomSentenceServiceImpl(RandomSentenceDao randomSentenceDao) {
    this.randomSentenceDao = randomSentenceDao;
  }

  @Override
  public Sentence getRandomSentence() {
    return randomSentenceDao.getRandomSentence();
  }

  @Override
  public void setSymbolsCount(int symbolsCount) {
    randomSentenceDao.setSymbolsCount(symbolsCount);
  }
}
