package com.in28minutes.microservices.currency_conversion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//CHANGE-KUBERNETES
// @FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000")
@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_URI:http://localhost}:8000")
	// ou
//@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(
        @PathVariable String from, 
        @PathVariable String to
    );
}
