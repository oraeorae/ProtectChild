package com.example.protect2.dao;

import com.example.protect2.pojo.Userinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Orall
 * @version 1.0
 * @description Userinfo的Mapper类
 * @date 2022-9-11
 */

@Mapper
public interface UserinfoMapper {
    /**
     * @return 以列表形式返回Userinfo实体类
     * @description 查询所有数据
     * @author Orall
     * @data 2022-9-11
     */
    @Select("select * from userinfo")
    List<Userinfo> listUserinfo();

    /**
     * @param id 主键id
     * @return 返回Userinfo实体类
     * @description 根据id获取单条数据（备注：这里的*换成对应想要获取的数据）
     * @author Orall
     * @data 2022-9-11
     */
    @Select("select * from userinfo where id=#{id}")
    Userinfo getUserinfoById(Integer id);

    /**
     * @param userinfo 实体类
     * @return 存在返回1，否则0
     * @description 未成年人登录
     * @author Orall
     * @data 2022-9-11
     */
    @Select("select count(*) from userinfo where guardian_tele=#{guardian_tele} and password=#{password} and type=#{type}")
    int loginUnderAge(Userinfo userinfo);

    /**
     * @param userinfo 实体类
     * @return 存在返回1，否则0
     * @description 未成年人登录得到更多信息
     * @author Orall
     * @data 2022-9-11
     */
    @Select("select * from userinfo where guardian_tele=#{guardian_tele} and password=#{password} and type=#{type}")
    Userinfo getloginUnderAge(Userinfo userinfo);

    /**
     * @paramuserinfo 实体类
     * @return 存在返回1，否则0
     * @description 成年人登录
     * @author Orall
     * @data 2022-9-11
     */
    @Select("select count(*) from userinfo where tele=#{tele} and password=#{password} and type=#{type}")
    int loginAdult(Userinfo userinfo);

    /**
     * @param userinfo 实体类
     * @return 存在返回1，否则0
     * @description 成年人登录得到更多信息
     * @author Orall
     * @data 2022-9-11
     */
    @Select("select * from userinfo where tele=#{tele} and password=#{password} and type=#{type}")
    Userinfo getloginAdult(Userinfo userinfo);

    /**
     * @param first 查询结果的索引值（默认从0开始）
     * @param second 查询结果返回的数量
     * @return 以列表形式返回Userinfo实体类
     * @description 分页查询数据（备注：这里的*换成对应想要获取的数据）
     * @author Orall
     * @data 2022-9-11
     */
    @Select("select * from userinfo limit #{first},#{second};")
    List<Userinfo> listUserinfoByPage(int first, int second);

    /**
     * @param userinfo 插入的实体类
     * @return 新增数据的ID
     * @description 插入数据
     * @author Orall
     * @data 2022-9-11
     */
    @Insert("insert into userinfo(name,sex,place,idcard,type,tele,guardian_tele,guardian_name,password) values(#{name},#{sex},#{place},#{idcard},#{type},#{tele},#{guardian_tele},#{guardian_name},#{password})")
    int insertUserinfo(Userinfo userinfo);

    /**
     * @param userinfo 要修改的实体类
     * @return 修改数据的条数
     * @description 根据id修改数据（备注：这里要修改的内容要根据实际改一下）
     * @author Orall
     * @data 2022-9-11
     */
    @Update("update userinfo set name = name where id=#{id}")
    int updateUserinfoById(Userinfo userinfo);

    /**
     * @param id 主键id
     * @return 删除数据的条数
     * @description 根据id删除数据
     * @author Orall
     * @since 2022-9-11
     */
    @Delete("delete from userinfo where id=#{id}")
    int deleteUserinfoById(Integer id);

}