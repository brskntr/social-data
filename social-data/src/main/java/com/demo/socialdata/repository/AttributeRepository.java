package com.demo.socialdata.repository;

import com.demo.socialdata.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bariskantar
 */
public interface AttributeRepository extends JpaRepository<Attribute,String> {
}
