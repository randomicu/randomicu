package icu.random.exception;

import icu.random.BaseApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GeneralExceptionHandlerTest extends BaseApplicationTests {

  @Autowired
  private MockMvc mvc;

  @Test
  public void methodIsNotSupportedExceptionJsonTest() throws Exception {
    mvc.perform(post(RANDOM_SENTENCE_URL)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isMethodNotAllowed())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }

  @Test
  void methodIsNotSupportedExceptionTextTest() throws Exception {
    mvc.perform(post(RANDOM_SENTENCE_URL)
        .accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isMethodNotAllowed())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN));
  }

  @Test
  void mediaTypeNotAcceptableExceptionTextTest() throws Exception {
    mvc.perform(get(RANDOM_SENTENCE_URL)
        .accept("not/acceptable"))
        .andExpect(status().isNotAcceptable())
        .andExpect(content().string("Could not find acceptable representation"));
  }
}
