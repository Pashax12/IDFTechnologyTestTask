package by.paul.idftesttask.service;

import by.paul.idftesttask.dto.CurrencyCoinLoreDTO;
import by.paul.idftesttask.entity.Currency;
import by.paul.idftesttask.repository.CurrencyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

@RequiredArgsConstructor
@EnableAsync
@Service
public class CurrencyUpdateServiceImpl implements CurrencyUpdateService {

  private final CurrencyRepository currencyRepository;
  private final ResponseSpec currencyResponse;
  private final ObjectMapper objectMapper;

  @Override
  @Async
  @Scheduled(fixedRate = 60000)
  public void updateCurrenciesFromApi() {
    Arrays.stream(Objects
        .requireNonNull(currencyResponse.bodyToMono(CurrencyCoinLoreDTO[].class)
            .block()))
        .map(currencyCoinLoreDTO -> objectMapper.convertValue(currencyCoinLoreDTO, Currency.class))
        .forEach(currencyRepository::save);
  }
}
