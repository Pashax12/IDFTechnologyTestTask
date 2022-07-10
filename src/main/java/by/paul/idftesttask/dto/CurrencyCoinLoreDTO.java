package by.paul.idftesttask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CurrencyCoinLoreDTO {


  @JsonProperty("id")
  private String id;
  @NotBlank
  @JsonProperty("symbol")
  private String symbol;
  @NotBlank
  @JsonProperty("name")
  private String name;
  @JsonProperty("nameid")
  private String nameid;
  @JsonProperty("rank")
  private int rank;
  @NotNull
  @JsonProperty("price_usd")
  private String price_usd;
  @JsonProperty("percent_change_24h")
  private String percentChange24h;
  @JsonProperty("percent_change_1h")
  private String percentChange1h;
  @JsonProperty("percent_change_7d")
  private String percentChange7d;
  @JsonProperty("market_cap_usd")
  private String marketCapUsd;
  @JsonProperty("volume24")
  private String volume24;
  @JsonProperty("volume24_native")
  private String volume24Native;
  @JsonProperty("csupply")
  private String cSupply;
  @JsonProperty("price_btc")
  private String priceBtc;
  @JsonProperty("tsupply")
  private String tSupply;
  @JsonProperty("msupply")
  private String mSupply;
}
