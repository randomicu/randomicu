package pw.stas.qautils.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.StringUtils;


public class RandomSentenceGenerator {

  private Integer symbolsCount;

  public String generate() {

    return StringUtils.capitalize(
        RandomStringUtils.random(symbolsCount, "abcdefghijklmnopqrstuvwxyz ")
            .replaceAll(" {2}\\w", ". A")
    );
  }

  public void setSymbolsCount(Integer symbolsCount) {
    this.symbolsCount = symbolsCount;
  }
}
