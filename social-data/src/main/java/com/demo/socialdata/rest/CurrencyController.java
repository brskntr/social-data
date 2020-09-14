package com.demo.socialdata.rest;

import com.demo.socialdata.model.Currency;
import com.demo.socialdata.model.GenericResponse;
import com.demo.socialdata.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bariskantar
 */

@RestController
@RequestMapping("/v1/currency")
public class CurrencyController {

    private CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("Success", currencyService.list()));
    }

    @PutMapping("/save")
    public ResponseEntity save(@RequestBody Currency currency){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("Success", currencyService.save(currency)));
    }
}
