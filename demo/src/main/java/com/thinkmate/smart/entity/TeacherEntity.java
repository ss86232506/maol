package com.thinkmate.smart.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;


@Data
public class TeacherEntity implements Serializable {
    /**
     * 学生姓名
     */
    @Excel(name = "教师姓名", height = 20, width = 30, isImportField = "true_st")
    private String name;
    /**
     * 学生性别
     */
    @Excel(name = "教师性别", replace = {"男_1", "女_2"}, suffix = "生", isImportField = "true_st")
    private int sex;

}
