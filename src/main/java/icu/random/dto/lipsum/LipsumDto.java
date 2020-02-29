package icu.random.dto.lipsum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import icu.random.dto.sentence.SentenceDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LipsumDto {

  private Feed feed;

  @Data
  public static class Feed {
    private String lipsum;
    private String generated;
    private String donatelink;
    private String creditlink;
    private String creditname;
  }

  public static SentenceDto convertToSentence(LipsumDto dto) {
    SentenceDto sentence = new SentenceDto();
    sentence.setSentence(dto.getFeed().getLipsum());
    sentence.setSymbolsCount(dto.getFeed().getLipsum().length());
    return sentence;
  }
}
