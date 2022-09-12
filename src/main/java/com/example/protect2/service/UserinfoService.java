package com.example.protect2.service;

import com.example.protect2.pojo.Userinfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Orall
 * @version 1.0
 * @description: 用于Userinfo的Service提供接口
 * @date 2022-9-11
 */
public interface UserinfoService {

    /**
     * @description 查询所有数据
     * @author Orall
     * @date 2022-9-11
     */
    List<Userinfo> listUserinfo();

    /**
     * @description 根据id获取单条数据
     * @author Orall
     * @date 2022-9-11
     */
    Userinfo getUserinfoById(Integer id);

    /**
     * @description 分页查询数据
     * @author Orall
     * @date 2022-9-11
     */
    List<Userinfo> listUserinfoByPage(int page, int limit);

    /**
     * @description 插入数据
     * @author Orall
     * @date 2022-9-11
     */
    int insertUserinfo(Userinfo userinfo);

    /**
     * @description 根据id修改数据
     * @author Orall
     * @date 2022-9-11
     */
    int updateUserinfoById(Userinfo userinfo);

    /**
     * @description 根据id删除数据
     * @author Orall
     * @date 2022-9-11
     */
    int deleteUserinfoById(Integer id);

    /**
     * @param userinfo 实体类
     * @return 存在返回1，否则0
     * @description 未成年人登录
     * @author Orall
     * @data 2022-9-11
     */
    int loginUnderAge(Userinfo userinfo);

    /**
     * @paramuserinfo 实体类
     * @return 存在返回1，否则0
     * @description 成年人登录
     * @author Orall
     * @data 2022-9-11
     */
    int loginAdult(Userinfo userinfo);


    /**
     * @param userinfo 实体类
     * @return 存在返回1，否则0
     * @description 未成年人登录得到更多信息
     * @author Orall
     * @data 2022-9-11
     */
    @Select("select * from userinfo where guardian_tele=#{tele} and password=#{password} and type=#{type}")
    Userinfo getloginUnderAge(Userinfo userinfo);


    /**
     * @param userinfo 实体类
     * @return 存在返回1，否则0
     * @description 成年人登录得到更多信息
     * @author Orall
     * @data 2022-9-11
     */
    Userinfo getloginAdult(Userinfo userinfo);

}