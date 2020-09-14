package com.demo.socialdata.repository;
/**
 * @author bariskantar
 */

import com.demo.socialdata.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,String> {
}
