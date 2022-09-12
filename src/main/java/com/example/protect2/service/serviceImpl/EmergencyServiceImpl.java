package com.example.protect2.service.serviceImpl;

import java.util.List;
import com.example.protect2.pojo.Emergency;
import com.example.protect2.service.EmergencyService;
import com.example.protect2.dao.EmergencyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Orall
* @version 1.0
* @description: 用于实现EmergencyService接口中的函数
* @date 2022-9-11
*/
@Service
public class EmergencyServiceImpl implements EmergencyService {
    @Resource
    EmergencyMapper emergencyMapper;

    /**
     * @return 以列表形式返回实体类对象
     * @description 查询所有数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public List<Emergency> listEmergency(){
        return emergencyMapper.listEmergency();
    }

    /**
     * @param id 主键id
     * @return 实体类对象
     * @description 根据id获取单条数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public Emergency getEmergencyById(Integer id){
        return emergencyMapper.getEmergencyById(id);
    }

    /**
     * @param page 页数
     * @param limit 每页限制数据量
     * @return 以列表形式返回实体类对象
     * @description 分页查询数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public List<Emergency> listEmergencyByPage(int page, int limit){
        int first = (page - 1) * limit;
        int second = limit;
        return emergencyMapper.listEmergencyByPage(first,second);
    }

    /**
     * @param emergency 要添加的实体类
     * @return 大于等于1则插入成功
     * @description 插入数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public int insertEmergency(Emergency emergency){
        return emergencyMapper.insertEmergency(emergency);
    }

    /**
     * @param emergency 要修改的实体类
     * @return 大于等于1则修改成功
     * @description 根据id修改数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public int updateEmergencyById(Emergency emergency){
        return emergencyMapper.updateEmergencyById(emergency);
    }

    /**
     * @param id 主键id
     * @return 大于等于1则删除成功
     * @description 根据id删除数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public int deleteEmergencyById(Integer id){
        return emergencyMapper.deleteEmergencyById(id);
    }
}