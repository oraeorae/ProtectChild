package com.example.protect2.dao;

import com.example.protect2.pojo.Emergency;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import java.util.List;

/**
 * @author Orall
 * @version 1.0
 * @description Emergency的Mapper类
 * @date 2022-9-11
 */

@Mapper
public interface EmergencyMapper {
    /**
     * @return 以列表形式返回Emergency实体类
     * @description 查询所有数据
     * @author Orall
     * @data 2022-9-11
     */
    @Select("select * from emergency")
    List<Emergency> listEmergency();

    /**
     * @param id 主键id
     * @return 返回Emergency实体类
     * @description 根据id获取单条数据（备注：这里的*换成对应想要获取的数据）
     * @author Orall
     * @data 2022-9-11
     */
    @Select("select * from emergency where id=#{id}")
    Emergency getEmergencyById(Integer id);

    /**
     * @param first 查询结果的索引值（默认从0开始）
     * @param second 查询结果返回的数量
     * @return 以列表形式返回Emergency实体类
     * @description 分页查询数据（备注：这里的*换成对应想要获取的数据）
     * @author Orall
     * @data 2022-9-11
     */
    @Select("select * from emergency limit #{first},#{second};")
    List<Emergency> listEmergencyByPage(int first, int second);

    /**
     * @param emergency 插入的实体类
     * @return 新增数据的ID
     * @description 插入数据
     * @author Orall
     * @data 2022-9-11
     */
    @Insert("insert into emergency(userid,place,situation) values(#{userid},#{place},#{situation})")
    int insertEmergency(Emergency emergency);

    /**
     * @param emergency 要修改的实体类
     * @return 修改数据的条数
     * @description 根据id修改数据（备注：这里要修改的内容要根据实际改一下）
     * @author Orall
     * @data 2022-9-11
     */
    @Update("update emergency set userid = userid where id=#{id}")
    int updateEmergencyById(Emergency emergency);

    /**
     * @param id 主键id
     * @return 删除数据的条数
     * @description 根据id删除数据
     * @author Orall
     * @since 2022-9-11
     */
    @Delete("delete from emergency where id=#{id}")
    int deleteEmergencyById(Integer id);

}