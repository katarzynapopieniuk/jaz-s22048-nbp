package pl.pjatk.katpop.jazs22048nbp.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class ExchangeRatesSeries {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;
}
