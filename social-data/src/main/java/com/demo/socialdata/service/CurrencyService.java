package com.demo.socialdata.service;

import com.demo.socialdata.model.Currency;
import com.demo.socialdata.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bariskantar
 */

@Service
public class CurrencyService {

    private CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public Currency save(Currency currency){
        return currencyRepository.save(currency);
    }

    public List<Currency> list(){
        return currencyRepository.findAll();
    }
}
