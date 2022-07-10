package by.paul.idftesttask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrencyDTO {

  @JsonProperty("id")
  private Long id;
  @JsonProperty("symbol")
  private String symbol;
  @JsonProperty("name")
  private String name;
  @JsonProperty("price_usd")
  private Double price_usd;

}
