package com.demo.socialdata.service;

import com.demo.socialdata.model.Attribute;
import com.demo.socialdata.repository.AttributeRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author bariskantar
 */
@Service
public class AttributeService {

    private AttributeRepository attributeRepository;

    public AttributeService(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    public Attribute save(Attribute attribute){
        return attributeRepository.save(attribute);
    }

    public Collection<Attribute> saveAll(Collection<Attribute> attributes){
        return attributeRepository.saveAll(attributes);
    }
}
