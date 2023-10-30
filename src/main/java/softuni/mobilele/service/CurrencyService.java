package softuni.mobilele.service;

import softuni.mobilele.model.dto.ExchangeRatesDTO;

public interface CurrencyService {
    void refreshRates(ExchangeRatesDTO exchangeRatesDTO);
}
