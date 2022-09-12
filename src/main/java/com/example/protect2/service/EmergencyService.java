package com.example.protect2.service;

import com.example.protect2.pojo.Emergency;
import java.util.List;

/**
 * @author Orall
 * @version 1.0
 * @description: 用于Emergency的Service提供接口
 * @date 2022-9-11
 */
public interface EmergencyService {

    /**
     * @description 查询所有数据
     * @author Orall
     * @date 2022-9-11
     */
    List<Emergency> listEmergency();

    /**
     * @description 根据id获取单条数据
     * @author Orall
     * @date 2022-9-11
     */
    Emergency getEmergencyById(Integer id);

    /**
     * @description 分页查询数据
     * @author Orall
     * @date 2022-9-11
     */
    List<Emergency> listEmergencyByPage(int page, int limit);

    /**
     * @description 插入数据
     * @author Orall
     * @date 2022-9-11
     */
    int insertEmergency(Emergency emergency);

    /**
     * @description 根据id修改数据
     * @author Orall
     * @date 2022-9-11
     */
    int updateEmergencyById(Emergency emergency);

    /**
     * @description 根据id删除数据
     * @author Orall
     * @date 2022-9-11
     */
    int deleteEmergencyById(Integer id);
}