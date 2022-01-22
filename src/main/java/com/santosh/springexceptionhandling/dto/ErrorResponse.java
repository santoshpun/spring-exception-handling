package com.santosh.springexceptionhandling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private String code;
    private String message;
    private int statusCode;
    private Date timestamp;

}
