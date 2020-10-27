package icu.random.controller;

import icu.random.BaseApplicationTests;
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

public class LimitsContollerTest extends BaseApplicationTests {

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

  @Value("${randomicu.external.lipsum.default-bytes-count}")
  private Integer defaultBytesCount;

  @Value("${randomicu.external.lipsum.default-paragraphs-count}")
  private Integer defaultParagraphsCount;

  @Value("${randomicu.external.lipsum.default-words-count}")
  private Integer defaultWordsCount;

  @Value("${randomicu.external.lipsum.default-lists-count}")
  private Integer defaultListsCount;

  @Test
  void sentenceLimitsTest() throws Exception {

    mvc.perform(get(SENTENCE_LIMITS_PATH).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.default_sentence_length", hasToString(sentenceDefaultLength.toString())))
        .andExpect(jsonPath("$.default_sentences_count", hasToString(sentencesDefaultCount.toString())))
        .andExpect(jsonPath("$.max_sentence_length", hasToString(maxSentenceLength.toString())))
        .andExpect(jsonPath("$.max_sentences_count", hasToString(maxSentencesCount.toString())))
        .andExpect(jsonPath("$.max_word_length", hasToString(maxWordLength.toString())))
        .andExpect(jsonPath("$.min_word_length", hasToString(minWordLength.toString())));
  }

  @Test
  void lipsumLimitsTest() throws Exception {

    mvc.perform(get(LOREM_LIMITS_PATH).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.default_bytes_count", hasToString(defaultBytesCount.toString())))
        .andExpect(jsonPath("$.default_paragraphs_count", hasToString(defaultParagraphsCount.toString())))
        .andExpect(jsonPath("$.default_words_count", hasToString(defaultWordsCount.toString())))
        .andExpect(jsonPath("$.default_lists_count", hasToString(defaultListsCount.toString())));
  }
}
