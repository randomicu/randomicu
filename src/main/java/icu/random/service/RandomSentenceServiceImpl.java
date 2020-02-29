package icu.random.service;

import icu.random.dao.RandomSentenceDao;
import icu.random.dto.LimitsDto;
import icu.random.dto.sentence.SentenceDto;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomSentenceServiceImpl implements RandomSentenceService {

  private final RandomSentenceDao randomSentenceDao;

  @Autowired
  public RandomSentenceServiceImpl(RandomSentenceDao randomSentenceDao) {
    this.randomSentenceDao = randomSentenceDao;
  }

  @Override
  public SentenceDto getRandomSentence(Integer symbolsCount, boolean isParagraphsEnabled) {
    randomSentenceDao.setSymbolsCount(symbolsCount);
    randomSentenceDao.enableParagraphs(isParagraphsEnabled);

    return randomSentenceDao.getRandomSentence();
  }

  @Override
  public Map<String, List<SentenceDto>> getRandomSentences(Integer symbolsCount, Integer sentencesCount, boolean isParagraphsEnabled) {
    randomSentenceDao.setSymbolsCount(symbolsCount);
    randomSentenceDao.setSentencesCount(sentencesCount);
    randomSentenceDao.enableParagraphs(isParagraphsEnabled);

    return randomSentenceDao.getRandomSentences();
  }

  @Override
  public LimitsDto getCurrentLimits() {
    return randomSentenceDao.getCurrentLimits();
  }
}
