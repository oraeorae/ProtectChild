package com.example.protect2.service.serviceImpl;

import java.util.List;
import com.example.protect2.pojo.Userinfo;
import com.example.protect2.service.UserinfoService;
import com.example.protect2.dao.UserinfoMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Orall
* @version 1.0
* @description: 用于实现UserinfoService接口中的函数
* @date 2022-9-11
*/
@Service
public class UserinfoServiceImpl implements UserinfoService {
    @Resource
    UserinfoMapper userinfoMapper;

    /**
     * @return 以列表形式返回实体类对象
     * @description 查询所有数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public List<Userinfo> listUserinfo(){
        return userinfoMapper.listUserinfo();
    }

    /**
     * @param id 主键id
     * @return 实体类对象
     * @description 根据id获取单条数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public Userinfo getUserinfoById(Integer id){
        return userinfoMapper.getUserinfoById(id);
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
    public List<Userinfo> listUserinfoByPage(int page, int limit){
        int first = (page - 1) * limit;
        int second = limit;
        return userinfoMapper.listUserinfoByPage(first,second);
    }

    /**
     * @param userinfo 要添加的实体类
     * @return 大于等于1则插入成功
     * @description 插入数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public int insertUserinfo(Userinfo userinfo){
        return userinfoMapper.insertUserinfo(userinfo);
    }

    /**
     * @param userinfo 要修改的实体类
     * @return 大于等于1则修改成功
     * @description 根据id修改数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public int updateUserinfoById(Userinfo userinfo){
        return userinfoMapper.updateUserinfoById(userinfo);
    }

    /**
     * @param id 主键id
     * @return 大于等于1则删除成功
     * @description 根据id删除数据
     * @author Orall
     * @date 2022-9-11
     */
    @Override
    public int deleteUserinfoById(Integer id){
        return userinfoMapper.deleteUserinfoById(id);
    }

    /**
     * @param userinfo 实体类
     * @return 存在返回1，否则0
     * @description 未成年人登录
     * @author Orall
     * @data 2022-9-11
     */
    @Override
    public int loginUnderAge(Userinfo userinfo){
        return userinfoMapper.loginUnderAge(userinfo);
    }

    /**
     * @paramuserinfo 实体类
     * @return 存在返回1，否则0
     * @description 成年人登录
     * @author Orall
     * @data 2022-9-11
     */
    @Override
    public int loginAdult(Userinfo userinfo){
        return userinfoMapper.loginAdult(userinfo);
    }

    /**
     * @param userinfo 实体类
     * @return 存在返回1，否则0
     * @description 未成年人登录得到更多信息
     * @author Orall
     * @data 2022-9-11
     */
    @Override
    public Userinfo getloginUnderAge(Userinfo userinfo){
        return userinfoMapper.getloginUnderAge(userinfo);
    }

    /**
     * @param userinfo 实体类
     * @return 存在返回1，否则0
     * @description 成年人登录得到更多信息
     * @author Orall
     * @data 2022-9-11
     */
    @Override
    public Userinfo getloginAdult(Userinfo userinfo){
        return userinfoMapper.getloginAdult(userinfo);
    }
}