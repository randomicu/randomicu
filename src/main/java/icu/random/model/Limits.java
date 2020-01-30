package icu.random.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Limits {

  @JsonProperty(value = "default_sentence_length")
  private Integer defaultSentenceLength;

  @JsonProperty(value = "default_sentences_count")
  private Integer defaultSentencesCount;

  @JsonProperty(value = "max_sentence_length")
  private Integer maxSentenceLength;

  @JsonProperty(value = "max_sentences_count")
  private Integer maxSentencesCount;

  @JsonProperty(value = "max_word_length")
  private Integer maxWordLength;

  @JsonProperty(value = "min_word_length")
  private Integer minWordLength;

}
