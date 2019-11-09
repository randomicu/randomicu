package pw.stas.qautils.model;

import org.springframework.stereotype.Component;

@Component
public class Sentence {

  private Long sentenceId;
  private String sentence;
  private Integer symbolsCount;

  public Sentence() {
  }

  public Long getSentenceId() {
    return sentenceId;
  }

  public void setSentenceId(Long sentenceId) {
    this.sentenceId = sentenceId;
  }

  public String getSentence() {
    return sentence;
  }

  public void setSentence(String sentence) {
    this.sentence = sentence;
  }

  public Integer getSymbolsCount() {
    return symbolsCount;
  }

  public void setSymbolsCount(Integer symbolsCount) {
    this.symbolsCount = symbolsCount;
  }

  @Override
  public String toString() {
    return "RandomText{" +
        "id=" + sentenceId +
        ", response='" + sentence + '\'' +
        '}';
  }
}
