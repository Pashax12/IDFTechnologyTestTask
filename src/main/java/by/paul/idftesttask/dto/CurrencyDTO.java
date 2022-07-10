package by.paul.idftesttask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CurrencyDTO {

  @NotNull
  @JsonProperty("id")
  private Long id;
  @NotBlank
  @JsonProperty("symbol")
  private String symbol;
  @NotBlank
  @JsonProperty("name")
  private String name;
  @NotNull
  @JsonProperty("price_usd")
  private Double price_usd;
}
