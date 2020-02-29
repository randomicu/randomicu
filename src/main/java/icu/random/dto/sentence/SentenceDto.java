package icu.random.dto.sentence;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class SentenceDto {

  private String sentence;

  @JsonProperty("symbols")
  private Integer symbolsCount;

}
