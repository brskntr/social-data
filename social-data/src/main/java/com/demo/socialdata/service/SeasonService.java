package com.demo.socialdata.service;/*
 * @author bariskantar
 */

import com.demo.socialdata.model.Season;
import com.demo.socialdata.repository.SeasonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonService {
    private SeasonRepository seasonRepository;

    public SeasonService(SeasonRepository seasonRepository){
        this.seasonRepository = seasonRepository;
    }

    public Season save(Season season) {
        return seasonRepository.save(season);
    }

    public List<Season> list() {
        return seasonRepository.findAll();
    }

    public Season findById(String id){
        return seasonRepository.findById(id).get();
    }

}
