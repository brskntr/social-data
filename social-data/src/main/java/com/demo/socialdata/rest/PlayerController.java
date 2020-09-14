package com.demo.socialdata.rest;
/**
 * @author bariskantar
 */

import com.demo.socialdata.model.GenericResponse;
import com.demo.socialdata.model.Player;
import com.demo.socialdata.model.PlayerTeam;
import com.demo.socialdata.service.PlayerService;
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
@RequestMapping("/v1/player")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("Success", playerService.list()));
    }

    @PutMapping("/save")
    public ResponseEntity save(@RequestBody Player player){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("Success", playerService.save(player)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String playerId){
        playerService.delete(playerId);
        return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
    }

    @PatchMapping("/update")
    public ResponseEntity update(@RequestBody Player player){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("Success",playerService.update(player)));
    }


    @GetMapping("/teams")
    public ResponseEntity teams(@RequestParam("playerId") String playerId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new GenericResponse("Success", playerService.findById(playerId).getPlayerTeamSet().stream().map(PlayerTeam::getTeam).collect(Collectors.toList())));
    }

    @GetMapping("/get")
    public ResponseEntity get(@RequestParam("playerId")String playerId){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("Success", playerService.findById(playerId)));
    }
}
