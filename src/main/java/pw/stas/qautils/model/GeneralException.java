package pw.stas.qautils.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeneralException {

  @JsonProperty(value = "status")
  private int statusCode;

  @JsonProperty(value = "exception")
  private String exceptionBody;

  @JsonProperty
  private long timestamp;

}
