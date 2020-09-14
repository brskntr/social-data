package com.eureka.test;

import com.eureka.test.model.Player;
import com.eureka.test.model.PlayerInfo;
import com.eureka.test.model.ResponseModel;
import com.eureka.test.util.ContractFeeCalculator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author bariskantar
 */

@Slf4j
@RestController
public class PlayerInfoController {

    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    public PlayerInfoController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/v1/player-info")
    public ResponseEntity test(@RequestParam("playerId") String playerId) {

        StringBuilder urlStringBuilder = new StringBuilder();
        urlStringBuilder.append("http://localhost:8099/v1/player/get").append("?playerId=").append(playerId);
        ResponseModel model = restTemplate.getForObject(urlStringBuilder.toString(), ResponseModel.class);
        Player player = objectMapper.convertValue(model.getData(), Player.class);

        PlayerInfo info = ContractFeeCalculator.calculate(player);
        log.info("Player -> ", player.toString());
        return ResponseEntity.status(HttpStatus.OK).body(info);
    }
}
