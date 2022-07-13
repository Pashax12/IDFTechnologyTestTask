package by.paul.idftesttask;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyPreviewControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @SneakyThrows
  void getCurrencyBySymbolIfProvideEthereumSymbol(){
    this.mockMvc.perform(get("/currencies/sym/currency").param("symbol", "ETH")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value(80))
        .andExpect(jsonPath("$.symbol").value("ETH"))
        .andDo(print());
  }
  @Test
  @SneakyThrows
  void getCurrencyBySymbolIfNoSymbolProvided(){
    this.mockMvc.perform(get("/currencies/sym/currency").param("symbol", " ")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN_VALUE))
        .andDo(print());
  }
  @Test
  @SneakyThrows
  void getCurrencyByIdIfProvideEthereumId(){
    this.mockMvc.perform(get("/currencies/id/currency").param("id", "80")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").value(80))
        .andExpect(jsonPath("$.symbol").value("ETH"))
        .andDo(print());
  }
  @Test
  @SneakyThrows
  void getCurrencyByIdIfNoIdProvided(){
    this.mockMvc.perform(get("/currencies/id/currency").param("id", "-1")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN_VALUE))
        .andDo(print());
  }
}
