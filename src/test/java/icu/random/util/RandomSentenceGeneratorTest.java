package icu.random.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomSentenceGeneratorTest {

  private RandomSentenceGenerator generator;
  private int minWordLenght = 2;
  private int maxWordLenght = 15;

  @BeforeEach
  void setUp() {
    generator = new RandomSentenceGenerator();
    generator.setMinWordLength(minWordLenght);
    generator.setMaxWordLength(maxWordLenght);
  }

  @Test
  void generateRandomSentenceTestWithConfiguredLength() {
    generator.setSymbolsCount(10);
    assertEquals(10, generator.generate().length(), "Sentence symbols count is not equals to 10");
  }

  @Test
  void generateRandomSentenceWithoutLength() {
    assertThrows(NullPointerException.class,
        () -> assertEquals(200, generator.generate().length(), "Sentence symbols count is not equals to 200"));
  }

  @Test
  void generateRandomSentenceIfNegativeInteger() {
    assertThrows(StringIndexOutOfBoundsException.class,
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
