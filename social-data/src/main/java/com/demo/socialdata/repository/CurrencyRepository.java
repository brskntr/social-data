package com.demo.socialdata.repository;

import com.demo.socialdata.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bariskantar
 */
public interface CurrencyRepository  extends JpaRepository<Currency,String> {
}
