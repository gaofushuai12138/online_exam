package com.heeexy.example.bean;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Department {

    private Integer departmentId;

    @NotNull
    private String departmentName;

    @NotNull
    private String departmentDes;             //部门职责

}
