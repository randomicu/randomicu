package icu.random.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Sentence {

  private String sentence;

  @JsonProperty("symbols")
  private Integer symbolsCount;

}
