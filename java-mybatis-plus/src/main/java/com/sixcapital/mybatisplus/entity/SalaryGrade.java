package com.sixcapital.mybatisplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mo on 2020/9/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryGrade {

    //等级
    private int grade;
    //最低薪资
    private int lowsal;
    //最高薪资
    private int  higsal;

}
