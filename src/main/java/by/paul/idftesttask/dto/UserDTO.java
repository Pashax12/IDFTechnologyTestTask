package by.paul.idftesttask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {

  @NotBlank
  @JsonProperty("username")
  private String username;
  @Email
  @JsonProperty("email")
  private String email;
  @NotNull
  @JsonProperty("currencyCode")
  private Long currencyCode;
}
