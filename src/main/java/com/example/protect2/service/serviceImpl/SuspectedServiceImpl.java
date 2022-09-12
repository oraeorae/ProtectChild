package com.example.protect2.service.serviceImpl;

import java.util.List;
import com.example.protect2.pojo.Suspected;
import com.example.protect2.service.SuspectedService;
import com.example.protect2.dao.SuspectedMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Orall
* @version 1.0
* @description: 用于实现SuspectedService接口中的函数
* @date 2022-9-11
*/
@Service
public class SuspectedServiceImpl implements SuspectedService {
    @Resource
    SuspectedMapper suspectedMapper;

    /**
     * @return 以列表形式返回实体类对象
     * @description 查询所有数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public List<Suspected> listSuspected(){
        return suspectedMapper.listSuspected();
    }

    /**
     * @param id 主键id
     * @return 实体类对象
     * @description 根据id获取单条数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public Suspected getSuspectedById(Integer id){
        return suspectedMapper.getSuspectedById(id);
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
    public List<Suspected> listSuspectedByPage(int page, int limit){
        int first = (page - 1) * limit;
        int second = limit;
        return suspectedMapper.listSuspectedByPage(first,second);
    }

    /**
     * @param suspected 要添加的实体类
     * @return 大于等于1则插入成功
     * @description 插入数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public int insertSuspected(Suspected suspected){
        return suspectedMapper.insertSuspected(suspected);
    }

    /**
     * @param suspected 要修改的实体类
     * @return 大于等于1则修改成功
     * @description 根据id修改数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public int updateSuspectedById(Suspected suspected){
        return suspectedMapper.updateSuspectedById(suspected);
    }

    /**
     * @param id 主键id
     * @return 大于等于1则删除成功
     * @description 根据id删除数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public int deleteSuspectedById(Integer id){
        return suspectedMapper.deleteSuspectedById(id);
    }
}