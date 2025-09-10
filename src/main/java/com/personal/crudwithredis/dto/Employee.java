package com.personal.crudwithredis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {

    private final static long serialVersionUID = 4123456789L;

    private long id;

    @JsonProperty("employee_id")
    private String employeeId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("work_dpt")
    private String workDpt;
}
