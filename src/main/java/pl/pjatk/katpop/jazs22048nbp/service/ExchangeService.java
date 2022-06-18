package pl.pjatk.katpop.jazs22048nbp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.katpop.jazs22048nbp.configuration.Endpoint;
import pl.pjatk.katpop.jazs22048nbp.exchange.mean.MeanCurrencyFactory;
import pl.pjatk.katpop.jazs22048nbp.exchange.model.ExchangeRatesSeries;
import pl.pjatk.katpop.jazs22048nbp.exchange.model.MeanCurrency;
import pl.pjatk.katpop.jazs22048nbp.repository.ExchangeRatesRepository;

import java.time.Instant;
import java.util.Objects;

@Service
public class ExchangeService {

    private final RestTemplate restTemplate;
    private final MeanCurrencyFactory meanCurrencyFactory;
    private final ExchangeRatesRepository exchangeRatesRepository;

    public ExchangeService(RestTemplate restTemplate,
                           MeanCurrencyFactory meanCurrencyFactory, ExchangeRatesRepository exchangeRatesRepository) {
        this.restTemplate = restTemplate;
        this.meanCurrencyFactory = meanCurrencyFactory;
        this.exchangeRatesRepository = exchangeRatesRepository;
    }

    public MeanCurrency getMeanCurrency(String currency, String startDate, String endDate) {
        Instant now = Instant.now();
        String requestUrl = prepareUrl(currency, startDate, endDate);
        ResponseEntity<ExchangeRatesSeries> response = restTemplate.getForEntity(requestUrl, ExchangeRatesSeries.class);
        MeanCurrency meanCurrency = meanCurrencyFactory.getMeanCurrency(Objects.requireNonNull(response.getBody()),
                startDate, endDate, now);
        return exchangeRatesRepository.save(meanCurrency);
    }

    private String prepareUrl(String currency, String startDate, String endDate) {
        return Endpoint.builder()
                .currency(currency)
                .tableType("a")
                .startDate(startDate)
                .endDate(endDate)
                .build()
                .getUrl();
    }
}
