package pw.stas.qautils.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.StringUtils;


public class RandomSentenceGenerator {

  private Integer count;

  public String generate() {

    if (count == null) {
      count = 100;
    }

    return StringUtils.capitalize(
        RandomStringUtils.random(count, "abcdefghijklmnopqrstuvwxyz ")
            .replaceAll(" {2}\\w", ". A")
    );
  }

  public void setSymbolsCount(Integer count) {
    this.count = count;
  }
}
