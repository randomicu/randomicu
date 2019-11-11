package pw.stas.qautils.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomSentenceGeneratorTest {

  private RandomSentenceGenerator generator;

  @BeforeEach
  void setup() {
    generator = new RandomSentenceGenerator();
  }

  @Test
  void generateRandomSentenceTestWithConfiguredLength() {
    generator.setSymbolsCount(10);
    assertEquals(10, generator.generate().length(), "Sentence symbols count is not equals to 10");
  }

  @Test
  void generateRandomSentenceWithoutLength() {
    assertEquals(200,generator.generate().length(), "Sentence symbols count is not equals to 200");
  }

  @Test
  void generateRandomSentenceIfNegativeInteger() {
    generator.setSymbolsCount(-10);
    assertEquals(200,generator.generate().length(), "Sentence symbols count is not equals to 200");
  }

  @Test
  void generateRandomSentenceIfNull() {
    generator.setSymbolsCount(null);
    assertEquals(200,generator.generate().length(), "Sentence symbols count is not equals to 200");
  }
}
