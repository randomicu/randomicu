package icu.random.service;

import icu.random.dto.lipsum.LipsumLimitsDto;
import icu.random.dto.sentence.SentenceLimitsDto;

public interface LimitsService {

  SentenceLimitsDto getSentenceLimits();
  LipsumLimitsDto getLipsumLimits();
}
