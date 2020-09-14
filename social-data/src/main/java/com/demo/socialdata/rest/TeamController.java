package com.demo.socialdata.rest;
/**
 * @author bariskantar
 */

import com.demo.socialdata.model.GenericResponse;
import com.demo.socialdata.model.PlayerTeam;
import com.demo.socialdata.model.Team;
import com.demo.socialdata.service.PlayerTeamService;
import com.demo.socialdata.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/team")
public class TeamController {

    private TeamService teamService;

    private PlayerTeamService playerTeamService;

    public TeamController(TeamService teamService,PlayerTeamService playerTeamService){
        this.teamService = teamService;
        this.playerTeamService = playerTeamService;
    }


    @GetMapping("/list")
    public ResponseEntity list(){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("Success", teamService.list()));
    }

    @PutMapping("/save")
    public ResponseEntity save(@RequestBody Team team){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("Success", teamService.save(team)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String playerId){
        teamService.delete(playerId);
        return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
    }

    @PatchMapping("/update")
    public ResponseEntity update(@RequestBody Team team){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("Success",teamService.update(team)));
    }

    @GetMapping("/players")
    public ResponseEntity players(@RequestParam("teamId") String teamId,@RequestParam("seasonId") String seasonId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new GenericResponse("Success", playerTeamService.findByTeamAndPlayer(teamId,seasonId).stream().map(PlayerTeam::getPlayer).collect(Collectors.toList())));
    }

}
