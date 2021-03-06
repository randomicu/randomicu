package icu.random;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
abstract public class BaseApplicationTests {

  public static final String RANDOM_SENTENCE_URL = "/api/v1/generators/random-sentence";
  public static final String RANDOM_SENTENCES_URL = "/api/v1/generators/random-sentences";
  public static final String SENTENCE_LIMITS_PATH = "/api/v1/generators/sentence-limits";
  public static final String LOREM_LIMITS_PATH = "/api/v1/generators/lorem-limits";

}
