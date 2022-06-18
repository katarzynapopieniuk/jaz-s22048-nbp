package pl.pjatk.katpop.jazs22048nbp.configuration;

import lombok.Builder;

@Builder
public class Endpoint {

    private static final String ENDPOINT_FORMAT = "http://api.nbp.pl/api/exchangerates/rates/%s/%s/%s/%s?format=json";

    private final String tableType;
    private final String currency;
    private final String startDate;
    private final String endDate;

    public String getUrl() {
        return String.format(ENDPOINT_FORMAT, tableType, currency, startDate, endDate);
    }
}
