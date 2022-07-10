package by.paul.idftesttask.repository;

import by.paul.idftesttask.entity.Currency;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {

  Optional<Currency> findById(Long id);

  List<Currency> findAll();

  Optional<Currency> findBySymbol(String symbol);
}
