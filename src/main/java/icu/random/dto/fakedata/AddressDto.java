package icu.random.dto.fakedata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {
  private String address;
  private String calling_code;
  private String city;
  private String continent;
  private Map<String, String> coordinates = Map.of();
  private String country;
  private String country_code;
  private String latitude;
  private String longitude;
  private String postal_code;
  private String state;
  private String street_name;
  private String street_number;
  private String street_suffix;
  private String zip_code;
}
