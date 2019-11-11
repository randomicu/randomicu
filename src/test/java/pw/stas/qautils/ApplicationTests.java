package pw.stas.qautils;

import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.hasToString;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTests {

  @Autowired
  private MockMvc mvc;

  @Test
  void defaultSymbolsCountTest() throws Exception {

    mvc.perform(get("/api/generators/random-text"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentence", hasLength(200)))
        .andExpect(jsonPath("$.symbols_count", hasToString("200")));
  }

  @Test
  void customSymbolscountTest() throws Exception {

    mvc.perform(get("/api/generators/random-text?count=500"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentence", hasLength(500)))
        .andExpect(jsonPath("$.symbols_count", hasToString("500")));

  }

  @Test
  void negativeSymbolsCountTest() throws Exception {

    mvc.perform(get("/api/generators/random-text?count=-2000"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentence", hasLength(200)))
        .andExpect(jsonPath("$.symbols_count", hasToString("200")));

  }

  @Test
  @Disabled
  void stringAsSymbolsCountTest() throws Exception {

    mvc.perform(get("/api/generators/random-text?count=abc"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentence", hasLength(200)))
        .andExpect(jsonPath("$.symbols_count", hasToString("200")));

  }

  @Test
  @Disabled
  void mixedCharactersAsSymbolsCountTest() throws Exception {

    mvc.perform(get("/api/generators/random-text?count=abc500"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentence", hasLength(200)))
        .andExpect(jsonPath("$.symbols_count", hasToString("200")));

  }
}
