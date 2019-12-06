package icu.random.model;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Sentences {

  private List<Sentence> sentences;
  private Integer sentencesCount;

}
