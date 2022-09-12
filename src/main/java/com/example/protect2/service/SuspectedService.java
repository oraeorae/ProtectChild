package com.example.protect2.service;

import com.example.protect2.pojo.Suspected;
import java.util.List;

/**
 * @author Orall
 * @version 1.0
 * @description: 用于Suspected的Service提供接口
 * @date 2022-9-11
 */
public interface SuspectedService {

    /**
     * @description 查询所有数据
     * @author Orall
     * @date 2022-9-11
     */
    List<Suspected> listSuspected();

    /**
     * @description 根据id获取单条数据
     * @author Orall
     * @date 2022-9-11
     */
    Suspected getSuspectedById(Integer id);

    /**
     * @description 分页查询数据
     * @author Orall
     * @date 2022-9-11
     */
    List<Suspected> listSuspectedByPage(int page, int limit);

    /**
     * @description 插入数据
     * @author Orall
     * @date 2022-9-11
     */
    int insertSuspected(Suspected suspected);

    /**
     * @description 根据id修改数据
     * @author Orall
     * @date 2022-9-11
     */
    int updateSuspectedById(Suspected suspected);

    /**
     * @description 根据id删除数据
     * @author Orall
     * @date 2022-9-11
     */
    int deleteSuspectedById(Integer id);
}