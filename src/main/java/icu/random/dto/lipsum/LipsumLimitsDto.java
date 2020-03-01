package icu.random.dto.lipsum;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LipsumLimitsDto {

  @JsonProperty(value = "default_bytes_count")
  private Integer defaultBytesCount;

  @JsonProperty(value = "default_paragraphs_count")
  private Integer defaultParagraphsCount;

  @JsonProperty(value = "default_words_count")
  private Integer defaultWordsCount;

  @JsonProperty(value = "default_lists_count")
  private Integer defaultListsCount;
}
