package com.demo.socialdata.service;/*
 * @author bariskantar
 */

import com.demo.socialdata.model.PlayerTeam;
import com.demo.socialdata.model.Season;
import com.demo.socialdata.model.Team;
import com.demo.socialdata.repository.PlayerTeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerTeamService {

    private PlayerTeamRepository playerTeamRepository;

    private TeamService teamService;

    private SeasonService seasonService;

    public PlayerTeamService(PlayerTeamRepository playerTeamRepository,TeamService teamService,SeasonService seasonService){
        this.playerTeamRepository = playerTeamRepository;
        this.teamService = teamService;
        this.seasonService = seasonService;
    }

    public PlayerTeam save(PlayerTeam playerTeam){
        return playerTeamRepository.save(playerTeam);
    }

    public List<PlayerTeam> findByTeamAndPlayer(String teamId,String seasonId){
        Team team = teamService.findById(teamId);
        Season season = seasonService.findById(seasonId);
        return playerTeamRepository.findByTeamAndSeason(team,season);
    }

}
