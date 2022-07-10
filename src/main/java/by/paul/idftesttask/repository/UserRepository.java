package by.paul.idftesttask.repository;

import by.paul.idftesttask.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  @Query(value = "SELECT * FROM Users u "
      + "WHERE u.currency_code = ?1 and "
      + "((?2 - u.price_usd)/u.price_usd >0.01 OR (?2 - u.price_usd)/u.price_usd < -0.01)",
      nativeQuery = true)
  List<User> findAllByCurrencyCodeAndPriceUsd(Long currencyCode, Double actualPrice);

}
