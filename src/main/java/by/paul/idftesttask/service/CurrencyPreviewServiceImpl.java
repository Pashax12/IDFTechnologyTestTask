package by.paul.idftesttask.service;

import by.paul.idftesttask.dto.CurrencyDTO;
import by.paul.idftesttask.exception.NoSuchCurrencyException;
import by.paul.idftesttask.repository.CurrencyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CurrencyPreviewServiceImpl implements CurrencyPreviewService {

  @Value("${exception.text.noSuchCurrency}")
  private String exceptionMessage;

  private final ObjectMapper objectMapper;
  private final CurrencyRepository currencyRepository;

  @Override
  public CurrencyDTO getCurrencyById(Long id) {
    return objectMapper.convertValue(currencyRepository.findById(id)
        .orElseThrow(() -> new NoSuchCurrencyException(exceptionMessage)), CurrencyDTO.class);
  }

  @Override
  public CurrencyDTO getCurrencyBySymbol(String symbol) {
    return objectMapper.convertValue(currencyRepository.findBySymbol(symbol)
        .orElseThrow(() -> new NoSuchCurrencyException(exceptionMessage)), CurrencyDTO.class);
  }

  @Override
  public List<CurrencyDTO> getAllCurrencies() {
    return currencyRepository.findAll().stream()
        .map(currency -> objectMapper.convertValue(currency, CurrencyDTO.class))
        .collect(Collectors.toList());
  }
}
