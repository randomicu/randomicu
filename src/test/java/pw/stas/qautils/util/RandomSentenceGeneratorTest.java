package pw.stas.qautils.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomSentenceGeneratorTest {

  private RandomSentenceGenerator generator;

  @BeforeEach
  void setUp() {
    generator = new RandomSentenceGenerator();
  }

  @Test
  void generateRandomSentenceTestWithConfiguredLength() {
    generator.setSymbolsCount(10);
    assertEquals(10, generator.generate().length(), "Sentence symbols count is not equals to 10");
  }

  @Test
  void generateRandomSentenceWithoutLength() {
    assertThrows(NullPointerException.class,
        () -> {
          assertEquals(200, generator.generate().length(), "Sentence symbols count is not equals to 200");
        });
  }

  @Test
  void generateRandomSentenceIfNegativeInteger() {
    assertThrows(IllegalArgumentException.class,
        () -> {
          generator.setSymbolsCount(-10);
          assertEquals(200, generator.generate().length(), "Sentence symbols count is not equals to 200");
        });
  }

  @Test
  void generateRandomSentenceIfNull() {
    assertThrows(NullPointerException.class,
        () -> {
          generator.setSymbolsCount(null);
          assertEquals(200, generator.generate().length(), "Sentence symbols count is not equals to 200");
        });
  }
}
