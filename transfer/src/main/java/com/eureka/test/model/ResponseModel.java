package com.eureka.test.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bariskantar
 */

@Setter
@Getter
public class ResponseModel {
    private String message;
    private Object data;
}
