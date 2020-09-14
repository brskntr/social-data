package com.demo.socialdata.repository;
/**
 * @author bariskantar
 */

import com.demo.socialdata.model.PlayerTeam;
import com.demo.socialdata.model.Season;
import com.demo.socialdata.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerTeamRepository extends JpaRepository<PlayerTeam,String> {
    List<PlayerTeam> findByTeamAndSeason(Team team, Season season);
}
