package icu.random.dto.sentence;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class SentencesDto {

  private List<SentenceDto> sentences;
  private Integer sentencesCount;

}
