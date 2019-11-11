package pw.stas.qautils.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Sentence {

  private String sentence;

  @JsonProperty("symbols_count")
  private Integer symbolsCount;

}
