package icu.random.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import icu.random.util.RandomSentenceGenerator;

@Configuration
public class AppConfiguration {

  @Value("${randomicu.sentence.min-word-length:2}")
  private Integer minWordLenght;

  @Value("${randomicu.sentence.max-word-length:15}")
  private Integer maxWordLenght;


  @Bean
  public RandomSentenceGenerator sentenceGenerator() {
    var generator = new RandomSentenceGenerator();
    generator.setMinWordLength(minWordLenght);
    generator.setMaxWordLength(maxWordLenght);

    return generator;
  }

}
