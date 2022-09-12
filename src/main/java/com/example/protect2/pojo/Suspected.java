package com.example.protect2.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Orall
 * @version 1.0
 * @description Suspected的实体类
 * @date 2022-9-11
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Suspected {
    private Integer id;
    private Integer userid;
    private String victim_name;
    private String victim_idcard;
    private String victim_place;
    private String infringer_name;
    private String infringer_idcard;
    private String infringer_place;
    private String situation;
}
