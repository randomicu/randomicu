package pw.stas.qautils.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.StringUtils;


public class RandomSentenceGenerator {

  private Integer symbolsCount;
  private Integer sentencesCount;

  public String generate() {

    return StringUtils.capitalize(
        RandomStringUtils.random(symbolsCount, "abcdefghijklmnopqrstuvwxyz ")
            .replaceAll(" {2}\\w", ". A")
            .replaceAll("^\\s", "R"));
  }

  public void setSymbolsCount(Integer symbolsCount) {
    this.symbolsCount = symbolsCount;
  }

  public void setSentencesCount(Integer sentencesCount) {
    this.sentencesCount = sentencesCount;
  }

  public Integer getSymbolsCount() {
    return symbolsCount;
  }

  public Integer getSentencesCount() {
    return sentencesCount;
  }
}
