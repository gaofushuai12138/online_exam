package com.heeexy.example.bean.tableInfo;

import com.heeexy.example.bean.Department;
import lombok.Data;


@Data
public class DepartmentTableInfo extends SelectParams {
    private Department department;

}
