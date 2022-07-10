package by.paul.idftesttask.service;

import by.paul.idftesttask.dto.UserDTO;
import by.paul.idftesttask.entity.User;
import by.paul.idftesttask.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserNotifyServiceImpl implements UserNotifyService {

  private final UserRepository userRepository;
  private final CurrencyPreviewService currencyPreviewService;
  private final ObjectMapper objectMapper;

  @Override
  public User addUser(UserDTO userDTO) {
    User user = objectMapper.convertValue(userDTO, User.class);
    user.setPriceUsd(
        currencyPreviewService.getCurrencyById(user.getCurrencyCode()).getPrice_usd());
    return userRepository.save(user);
  }

  @Override
  @Scheduled(fixedRate = 60000)
  public void notifyUser() {
    currencyPreviewService.getAllCurrencies()
        .forEach(currencyDTO -> userRepository
            .findAllByCurrencyCodeAndPriceUsd(currencyDTO.getId(), currencyDTO.getPrice_usd())
            .forEach(user -> log.warn(generateMessage(user, currencyDTO.getPrice_usd()))));
  }

  private String generateMessage(User user, Double newPrice) {
    return "currency code:" + user.getCurrencyCode() + ""
        + "username: " + user.getUsername() + "change percent: " + countPercent(user.getPriceUsd(),
        newPrice);
  }

  private Double countPercent(Double userPrice, Double newPrice) {
    return Math.abs((newPrice - userPrice) / userPrice * 100);
  }
}
