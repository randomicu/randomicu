package pw.stas.qautils.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pw.stas.qautils.util.RandomSentenceGenerator;

@Configuration
public class AppConfiguration {

  @Value("${qa-utils.sentence.min-word-length}")
  private Integer minWordLenght;

  @Value("${qa-utils.sentence.max-word-length}")
  private Integer maxWordLenght;


  @Bean
  public RandomSentenceGenerator sentenceGenerator() {
    var generator = new RandomSentenceGenerator();
    generator.setMinWordLength(minWordLenght);
    generator.setMaxWordLength(maxWordLenght);

    return generator;
  }

}
