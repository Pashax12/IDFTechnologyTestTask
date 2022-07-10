package by.paul.idftesttask.controller;

import by.paul.idftesttask.dto.CurrencyDTO;
import by.paul.idftesttask.service.CurrencyPreviewServiceImpl;
import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currencies")
public class CurrencyPreviewController {

  private final CurrencyPreviewServiceImpl currencyPreviewService;

  @GetMapping("/sym/currency")
  public ResponseEntity<CurrencyDTO> getCurrencyBySymbol(
      @RequestParam @NotBlank String symbol) {
    return ResponseEntity.ok(currencyPreviewService.getCurrencyBySymbol(symbol));
  }

  @GetMapping("/id/currency")
  public ResponseEntity<CurrencyDTO> getCurrencyById(
      @RequestParam @NotBlank Long id) {
    return ResponseEntity.ok(currencyPreviewService.getCurrencyById(id));
  }

  @GetMapping
  public ResponseEntity<List<CurrencyDTO>> getAllCurrencies() {
    return ResponseEntity.ok(currencyPreviewService.getAllCurrencies());
  }

}
