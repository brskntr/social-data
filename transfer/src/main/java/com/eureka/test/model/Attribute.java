package com.eureka.test.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bariskantar
 */
@Getter
@Setter
public class Attribute {

    private String id;

    private String name;

    private String value;

    private Player player;
}
