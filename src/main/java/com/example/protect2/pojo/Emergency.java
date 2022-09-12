package com.example.protect2.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Orall
 * @version 1.0
 * @description Emergency的实体类
 * @date 2022-9-11
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Emergency {
    private Integer id;
    private Integer userid;
    private String place;
    private String situation;
}
