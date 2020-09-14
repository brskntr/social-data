package com.demo.socialdata.repository;
/**
 * @author bariskantar
 */

import com.demo.socialdata.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season,String> {
}
