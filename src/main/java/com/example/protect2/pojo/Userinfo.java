package com.example.protect2.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Orall
 * @version 1.0
 * @description Userinfo的实体类
 * @date 2022-9-11
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Userinfo {
    private Integer id;
    private String name;
    private String sex;
    private String place;
    private String idcard;
    private String type;
    private String tele;
    private String guardian_tele;
    private String guardian_name;
    private String password;
}
