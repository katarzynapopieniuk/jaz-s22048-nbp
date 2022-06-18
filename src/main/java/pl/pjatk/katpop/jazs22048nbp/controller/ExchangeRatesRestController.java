package pl.pjatk.katpop.jazs22048nbp.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.katpop.jazs22048nbp.exchange.model.MeanCurrency;
import pl.pjatk.katpop.jazs22048nbp.service.ExchangeService;

@RestController
@RequestMapping("/exchange")
public class ExchangeRatesRestController {

    private final ExchangeService exchangeService;

    public ExchangeRatesRestController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/mean/{currency}")
    @ApiOperation(value = "Get mean currency exchange rate for last days")
    public ResponseEntity<MeanCurrency> getAllMovies(@PathVariable String currency,
                                                     @RequestParam String startDate,
                                                     @RequestParam String endDate) {
        return ResponseEntity.ok(exchangeService.getMeanCurrency(currency, startDate, endDate));
    }
}
