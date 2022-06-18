package pl.pjatk.katpop.jazs22048nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.katpop.jazs22048nbp.exchange.model.MeanCurrency;

public interface ExchangeRatesRepository extends JpaRepository<MeanCurrency, Integer> {
}
