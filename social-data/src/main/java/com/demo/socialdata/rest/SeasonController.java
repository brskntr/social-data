package com.demo.socialdata.rest;/*
 * @author bariskantar
 */

import com.demo.socialdata.model.GenericResponse;
import com.demo.socialdata.model.Season;
import com.demo.socialdata.service.SeasonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/season")
public class SeasonController {

    private SeasonService seasonService;

    public SeasonController(SeasonService seasonService){
        this.seasonService = seasonService;
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("Success", seasonService.list()));
    }

    @PutMapping("/save")
    public ResponseEntity save(@RequestBody Season season){
        return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse("Success", seasonService.save(season)));
    }



}
