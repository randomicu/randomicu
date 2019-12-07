package icu.random.util;

import java.util.Random;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;


@Data
public class RandomSentenceGenerator {

  private Integer symbolsCount;
  private Integer minWordLength;
  private Integer maxWordLength;
  private boolean paragraphsEnabled;

  public String generate() {

    Random rnd = new Random();
    StringBuilder sentence = new StringBuilder();

    while (sentence.length() < symbolsCount) {
      String word = generateWord();

      if (sentence.length() == 0 || sentence.length() >= minWordLength && sentence.substring(sentence.length() - 2).equals(". ")) {
        word = StringUtils.capitalize(word);
      }

      sentence.append(word);

      if (rnd.nextDouble() < 0.1) {
        sentence.append(".");

        if (paragraphsEnabled && symbolsCount >= 500 && rnd.nextDouble() < 0.2) {
          sentence.append("\n\n");
        }
      }

      if (!sentence.substring(sentence.length() - 2).startsWith("\n\n")) {
        sentence.append(" ");
      }
    }

    String newSentence = sentence.substring(0, symbolsCount)
        .replaceAll(".$", ".")
        .replaceAll("(?m)^[a-z]", "I");

    if (newSentence.endsWith(" .")) {
      newSentence = newSentence.replace(" .", "u.");
    }

    return newSentence;
  }

  private String generateWord() {
    return StringUtils.lowerCase(RandomStringUtils.randomAlphabetic(minWordLength, maxWordLength));
  }
}
