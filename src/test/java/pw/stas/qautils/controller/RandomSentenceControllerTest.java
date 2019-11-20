package pw.stas.qautils.controller;

import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.hasToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import pw.stas.qautils.BaseApplicationTests;

public class RandomSentenceControllerTest extends BaseApplicationTests {

  @Autowired
  private MockMvc mvc;

  @Test
  void defaultSymbolsCountReturnJsonTest() throws Exception {

    mvc.perform(get("/api/generators/random-text"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentence", hasLength(200)))
        .andExpect(jsonPath("$.symbols", hasToString("200")));
  }

  @Test
  void customSymbolsCountReturnJsonTest() throws Exception {

    mvc.perform(get("/api/generators/random-text?count=500"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentence", hasLength(500)))
        .andExpect(jsonPath("$.symbols", hasToString("500")));
  }

  @Test
  void negativeSymbolsCountReturnJsonTest() throws Exception {

    mvc.perform(get("/api/generators/random-text?count=-2000"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentence", hasLength(200)))
        .andExpect(jsonPath("$.symbols", hasToString("200")));
  }

  @Test
  void stringAsSymbolsCountReturnJsonTest() throws Exception {

    mvc.perform(get("/api/generators/random-text?count=abc")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.exception", hasToString("Argument should be a number")));
  }

  @Test
  void mixedCharactersAsSymbolsCountReturnJsonTest() throws Exception {

    mvc.perform(get("/api/generators/random-text?count=abc500")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.exception", hasToString("Argument should be a number")));
  }

  @Test
  void mixedCharactersAsSymbolsCountReturnTextTest() throws Exception {

    mvc.perform(get("/api/generators/random-text?count=abc500")
        .accept(MediaType.TEXT_PLAIN))
        .andExpect(status().is4xxClientError())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
        .andExpect(content().string("Argument should be a number"));
  }

  @Test
  void defaultSymbolsCountReturnTextTest() throws Exception {

    mvc.perform(get("/api/generators/random-text")
        .accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
        .andExpect(content().string(hasLength(200)));

  }

  @Test
  void customSymbolsCountReturnTextTest() throws Exception {

    mvc.perform(get("/api/generators/random-text?count=400")
        .accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
        .andExpect(content().string(hasLength(400)));
  }
}
