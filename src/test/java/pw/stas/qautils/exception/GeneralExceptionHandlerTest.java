package pw.stas.qautils.exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import pw.stas.qautils.BaseApplicationTests;

public class GeneralExceptionHandlerTest extends BaseApplicationTests {

  @Autowired
  private MockMvc mvc;

  @Test
  void methodIsNotSupportedExceptionJsonTest() throws Exception {

    mvc.perform(post("/api/generators/random-text")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isMethodNotAllowed())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }

  @Test
  void methodIsNotSupportedExceptionTextTest() throws Exception {

    mvc.perform(post("/api/generators/random-text")
        .accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isMethodNotAllowed())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN));
  }

  @Test
  void mediaTypeNotAcceptableExceptionTextTest() throws Exception {

    mvc.perform(get("/api/generators/random-text")
        .accept("not/acceptable"))
        .andExpect(status().isNotAcceptable())
        .andExpect(content().string("Could not find acceptable representation"));
  }
}
