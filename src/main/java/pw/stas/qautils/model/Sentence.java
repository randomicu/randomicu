package pw.stas.qautils.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Sentence {

  private Long sentenceId;
  private String sentence;
  private Integer symbolsCount;

}
