package softuni.mobilele.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import softuni.mobilele.config.OpenExchangeRateConfig;
import softuni.mobilele.model.dto.ExchangeRatesDTO;
import softuni.mobilele.service.CurrencyService;

import java.util.Map;

@Component
public class ExchangeRatesInit implements CommandLineRunner {


    private final RestTemplate restTemplate;
    private final OpenExchangeRateConfig openExchangeRateConfig;

    private final CurrencyService currencyService;

    public ExchangeRatesInit(RestTemplate restTemplate, OpenExchangeRateConfig openExchangeRateConfig, CurrencyService currencyService) {
        this.restTemplate = restTemplate;
        this.openExchangeRateConfig = openExchangeRateConfig;
        this.currencyService = currencyService;
    }


    @Override
    public void run(String... args) throws Exception {

        String openExchangeRateUrlTemplate =
                openExchangeRateConfig.getSchema()
                        + "://"
                        + openExchangeRateConfig.getHost()
                        + openExchangeRateConfig.getPath()
                        + "?app_id={app_id}&symbols={symbols}";


        Map<String, String> requestParams = Map.of(
                "app_id" , openExchangeRateConfig.getAppId(),
                "symbols", String.join(",", openExchangeRateConfig.getSymbols())
        );

        ExchangeRatesDTO exchangeRatesDTO = restTemplate
                .getForObject(openExchangeRateUrlTemplate, ExchangeRatesDTO.class, requestParams);


        currencyService.refreshRates(exchangeRatesDTO);

    }
}
