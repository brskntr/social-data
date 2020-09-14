package com.demo.socialdata.repository;
/**
 * @author bariskantar
 */

import com.demo.socialdata.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,String> {
}
