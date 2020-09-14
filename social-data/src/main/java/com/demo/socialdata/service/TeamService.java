package com.demo.socialdata.service;
/**
 * @author bariskantar
 */

import com.demo.socialdata.exception.NotFoundException;
import com.demo.socialdata.model.Currency;
import com.demo.socialdata.model.Team;
import com.demo.socialdata.repository.CurrencyRepository;
import com.demo.socialdata.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    private CurrencyRepository currencyRepository;

    public TeamService(TeamRepository teamRepository,CurrencyRepository currencyRepository){
        this.teamRepository = teamRepository;
        this.currencyRepository = currencyRepository;
    }

    public Team save(Team team) {
        Currency currency = currencyRepository.findById(team.getCurrency().getId()).orElse(null);
        team.setCurrency(currency);
        return teamRepository.save(team);
    }


    public List<Team> list() {
        return teamRepository.findAll();
    }

    public void delete(String teamId) {
        teamRepository.findById(teamId).ifPresent(p -> {
            teamRepository.delete(p);
        });
    }

    public Team update(Team team) {
        boolean exists =  teamRepository.existsById(team.getId());
        if(exists){
            return teamRepository.save(team);
        }
        throw new NotFoundException("Team not found");
    }

    public Team findById(String id){
        return teamRepository.findById(id).get();
    }
}
