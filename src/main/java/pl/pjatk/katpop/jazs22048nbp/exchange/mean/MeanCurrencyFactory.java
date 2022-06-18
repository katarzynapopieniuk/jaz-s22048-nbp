package pl.pjatk.katpop.jazs22048nbp.exchange.mean;

import org.springframework.stereotype.Component;
import pl.pjatk.katpop.jazs22048nbp.exchange.helper.DateFormatter;
import pl.pjatk.katpop.jazs22048nbp.exchange.model.ExchangeRatesSeries;
import pl.pjatk.katpop.jazs22048nbp.exchange.model.MeanCurrency;
import pl.pjatk.katpop.jazs22048nbp.exchange.model.Rate;

import java.time.Instant;

@Component
public class MeanCurrencyFactory {

    public MeanCurrency getMeanCurrency(ExchangeRatesSeries exchangeRatesSeries, String startDate, String endDate, Instant now) {
        return MeanCurrency.builder()
                .currencyCode(exchangeRatesSeries.getCode())
                .startDate(startDate)
                .endDate(endDate)
                .timeStamp(DateFormatter.formatDateTime(now))
                .mean(countMean(exchangeRatesSeries))
                .build();
    }

    private Double countMean(ExchangeRatesSeries exchangeRatesSeries) {
        return getSum(exchangeRatesSeries) / exchangeRatesSeries.getRates().size();
    }

    private double getSum(ExchangeRatesSeries exchangeRatesSeries) {
        return exchangeRatesSeries.getRates().stream()
                .map(Rate::getMid)
                .mapToDouble(d -> d)
                .sum();
    }
}
