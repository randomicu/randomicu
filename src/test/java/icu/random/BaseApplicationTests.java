package icu.random;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(print = MockMvcPrint.NONE)
@ActiveProfiles("test")
abstract public class BaseApplicationTests {

  public static final String RANDOM_SENTENCE_URL = "/api/generators/random-sentence";
  public static final String RANDOM_SENTENCES_URL = "/api/generators/random-sentences";
  public static final String CURRENT_LIMITS_PATH = "/api/generators/limits";

}
