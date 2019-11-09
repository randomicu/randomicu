package pw.stas.qautils.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pw.stas.qautils.util.RandomSentenceGenerator;

@Configuration
public class AppConfiguration {

  @Bean
  public RandomSentenceGenerator sentenceGenerator() {
    return new RandomSentenceGenerator();
  }

}
