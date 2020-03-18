package icu.random.controller;

import icu.random.BaseApplicationTests;
import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RandomSentenceControllerTest extends BaseApplicationTests {

  @Autowired
  private MockMvc mvc;

  @Value("${randomicu.sentence.default-length}")
  Integer sentenceDefaultLength;

  @Value("${randomicu.sentence.default-sentences-count}")
  Integer sentencesDefaultCount;

  @Value("${randomicu.sentence.max-sentences-count}")
  Integer maxSentencesCount;

  @Value("${randomicu.sentence.max-sentence-length}")
  Integer maxSentenceLength;

  @Value("${randomicu.sentence.min-word-length}")
  Integer minWordLength;

  @Value("${randomicu.sentence.max-word-length}")
  Integer maxWordLength;

  @Test
  void defaultSymbolsCountReturnJsonTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCE_URL))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentence", hasLength(sentenceDefaultLength)))
        .andExpect(jsonPath("$.symbols", hasToString(sentenceDefaultLength.toString())));
  }

  @Test
  void customSymbolsCountReturnJsonTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCE_URL + "?count=500"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentence", hasLength(500)))
        .andExpect(jsonPath("$.symbols", hasToString("500")));
  }

  @Test
  void negativeSymbolsCountReturnJsonTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCE_URL + "?count=-2000"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentence", hasLength(sentenceDefaultLength)))
        .andExpect(jsonPath("$.symbols", hasToString(sentenceDefaultLength.toString())));
  }

  @Test
  void stringAsSymbolsCountReturnJsonTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCE_URL + "?count=abc")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.exception", hasToString("The parameter 'count' of value 'abc' could not be converted to type 'Integer'")));
  }

  @Test
  void mixedCharactersAsSymbolsCountReturnJsonTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCE_URL + "?count=abc500")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().is4xxClientError())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.exception", hasToString("The parameter 'count' of value 'abc500' could not be converted to type 'Integer'")));
  }

  @Test
  void mixedCharactersAsSymbolsCountReturnTextTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCE_URL + "?count=abc500")
        .accept(MediaType.TEXT_PLAIN))
        .andExpect(status().is4xxClientError())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
        .andExpect(content().string("The parameter 'count' of value 'abc500' could not be converted to type 'Integer'"));
  }

  @Test
  void defaultSymbolsCountReturnTextTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCE_URL)
        .accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
        .andExpect(content().string(hasLength(sentenceDefaultLength)));

  }

  @Test
  void customSymbolsCountReturnTextTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCE_URL + "?count=400")
        .accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
        .andExpect(content().string(hasLength(400)));
  }

  @Test
  void defaultRandomSentencesGeneratorTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCES_URL)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentences", hasSize(sentencesDefaultCount)))
        .andExpect(jsonPath("$.sentences[0].sentence", hasLength(sentenceDefaultLength)))
        .andExpect(jsonPath("$.sentences[0].symbols", hasToString(sentenceDefaultLength.toString())));
  }

  @Test
  void symbolsCountAndSentencesCountGreaterThanMaxTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCES_URL + "?count=70001&sentencesCount=11")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentences", hasSize(sentencesDefaultCount)))
        .andExpect(jsonPath("$.sentences[0].sentence", hasLength(sentenceDefaultLength)))
        .andExpect(jsonPath("$.sentences[0].symbols", hasToString(sentenceDefaultLength.toString())));
  }

  @Test
  void symbolsCountGreaterThatMaxAndSentencesCountIsMaxTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCES_URL + "?count=70001&sentencesCount=10")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentences", hasSize(maxSentencesCount)))
        .andExpect(jsonPath("$.sentences[0].sentence", hasLength(sentenceDefaultLength)))
        .andExpect(jsonPath("$.sentences[0].symbols", hasToString(sentenceDefaultLength.toString())));
  }

  @Test
  void symbolsCountIsMaxAndSentencesCountGreaterThatMaxTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCES_URL + "?count=5000&sentencesCount=11")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentences", hasSize(sentencesDefaultCount)))
        .andExpect(jsonPath("$.sentences[0].sentence", hasLength(5000)))
        .andExpect(jsonPath("$.sentences[0].symbols", hasToString("5000")));
  }

  @Test
  void symbolsCountIsZeroAndSentencesCountIsOneTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCES_URL + "?count=0&sentencesCount=1")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentences", hasSize(1)))
        .andExpect(jsonPath("$.sentences[0].sentence", hasLength(sentenceDefaultLength)))
        .andExpect(jsonPath("$.sentences[0].symbols", hasToString(sentenceDefaultLength.toString())));
  }

  @Test
  void symbolsCountAndSentencesCountIsZeroTest() throws Exception {

    mvc.perform(get(RANDOM_SENTENCES_URL + "?count=0&sentencesCount=0")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.sentences", hasSize(sentencesDefaultCount)))
        .andExpect(jsonPath("$.sentences[0].sentence", hasLength(sentenceDefaultLength)))
        .andExpect(jsonPath("$.sentences[0].symbols", hasToString(sentenceDefaultLength.toString())));
  }
}
