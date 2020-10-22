package icu.random.dto.fakedata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDto {
  private String age;
  private String email;
  private String first_name;
  private String full_name;
  private String gender;
  private String height;
  private String identifier;
  private String last_name;
  private String nationality;
  private String occupation;
  private String password;
  private String political_views;
  private String telephone;
  private String title;
  private String university;
  private String username;
  private String weight;
  private String work_experience;
  private String inn;
  private String kpp;
  private String bic;
  private String ogrn;
  private String passport;
}
