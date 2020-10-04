package icu.random.dto.fakedata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto {
  private String academic_degree;
  private String age;
  private String avatar;
  private String blood_type;
}
