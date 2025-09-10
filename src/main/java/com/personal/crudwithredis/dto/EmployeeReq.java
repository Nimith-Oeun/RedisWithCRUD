package com.personal.crudwithredis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EmployeeReq implements Serializable {

    private final static long serialVersionUID = 4123456789L;

    @JsonProperty("employee_id")
    private List<Long> id;
}
