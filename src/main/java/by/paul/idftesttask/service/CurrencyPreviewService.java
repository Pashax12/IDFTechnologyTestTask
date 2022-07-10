package by.paul.idftesttask.service;

import by.paul.idftesttask.dto.CurrencyDTO;
import java.util.List;

public interface CurrencyPreviewService {
  CurrencyDTO getCurrencyById(Long id);
  CurrencyDTO getCurrencyBySymbol(String symbol);
  List<CurrencyDTO> getAllCurrencies();

}
