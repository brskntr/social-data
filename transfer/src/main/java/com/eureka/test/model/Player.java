package com.eureka.test.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

/**
 * @author bariskantar
 */
@Getter
@Setter
public class Player {

    private String id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private Date licenseStartDate;

    private Set<Attribute> attributes;

}
