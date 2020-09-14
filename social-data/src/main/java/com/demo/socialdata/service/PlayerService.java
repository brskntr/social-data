package com.demo.socialdata.service;
/**
 * @author bariskantar
 */

import com.demo.socialdata.exception.NotFoundException;
import com.demo.socialdata.model.Attribute;
import com.demo.socialdata.model.Player;
import com.demo.socialdata.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    private AttributeService attributeService;

    public PlayerService(PlayerRepository playerRepository,AttributeService attributeService) {
        this.playerRepository = playerRepository;
        this.attributeService = attributeService;
    }

    public Player save(Player player) {
        player = playerRepository.save(player);
        Set<Attribute> attributeSet = new HashSet<>();
        for(Attribute attribute :player.getAttributes()){
            attribute.setPlayer(player);
            attributeSet.add(attribute);
        }
        attributeService.saveAll(attributeSet);
        return player;
    }


    public List<Player> list() {
        return playerRepository.findAll();
    }

    public void delete(String playerId) {
        playerRepository.findById(playerId).ifPresent(p -> {
            playerRepository.delete(p);
        });
    }

    public Player update(Player player) {
        boolean exists =  playerRepository.existsById(player.getId());
        if(exists){
            return playerRepository.save(player);
        }
        throw new NotFoundException("Player not found");
    }

    public Player findById(String id){
        return playerRepository.findById(id).get();
    }
}
