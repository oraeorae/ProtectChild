package com.example.protect2.controller;

import com.example.protect2.pojo.Emergency;
import com.example.protect2.service.EmergencyService;
import com.example.protect2.utils.JwtUtils;
import com.example.protect2.utils.StatusCode;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

/**
* @author Orall
* @version 1.0
* @description Emergency的Controller层
* @data 2022-9-11
*/
@RestController
@RequestMapping(value = "/api/emergency")
public class EmergencyController {
    @Resource
    EmergencyService emergencyService;

    /**
    * @param emergency 添加的实体类
    * @return Map<String, Object> 自定义响应体
    * @description 添加数据
    * @author Orall
    * @data 2022-9-11
    */
    @PostMapping("/insert")
    @ApiOperation(value = "添加数据")
    public Map<String, Object> insertEmergency(@Valid Emergency emergency,@RequestParam("token") String token) {
        try {
            JwtUtils jwt = JwtUtils.getInstance();
            Claims claims = jwt.check(token);
            if (claims != null){
                Integer userid = (Integer)claims.get("userid");
                emergency.setUserid(userid);
            }else {
                return StatusCode.success("非法token，请先登录");
            }
            if( emergencyService.insertEmergency(emergency) >= 1 ){
                return StatusCode.success("添加成功");
            }else{
                return StatusCode.success("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return StatusCode.error("服务器内部错误：" + e.toString());
        }
    }


    /**
     * @param id 主键id
     * @return Map<String, Object> 自定义响应体
     * @description 根据id获取单条数据
     * @author Orall
     * @data 2022-9-11
     */
    @GetMapping("/get")
    @ApiOperation(value = "根据id获取单条数据")
    public Map<String, Object> getEmergencyById(@RequestParam("id") Integer id) {
        try {
            return StatusCode.success(emergencyService.getEmergencyById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return StatusCode.error(3001, "服务器内部错误：" + e.toString());
        }
    }

    /**
     * @param page 查询的页数
     * @return Map<String, Object> 自定义响应体
     * @description 分页查询数据（备注：limit默认为10）
     * @author Orall
     * @data 2022-9-11
     */
    @GetMapping("/list/page")
    @ApiOperation(value = "分页查询数据")
    public Map<String, Object> listEmergencyByPage(@RequestParam("page") int page) {
        try {
            //limit默认为10
            return StatusCode.success(emergencyService.listEmergencyByPage(page,10));
        } catch (Exception e) {
            e.printStackTrace();
            return StatusCode.error("服务器内部错误：" + e.toString());
        }
    }

    /**
     * @param emergency 需要修改的实体类
     * @return Map<String, Object> 自定义响应体
     * @description 根据id修改数据
     * @author Orall
     * @data 2022-9-11
     */
    @PutMapping("/update")
    @ApiOperation(value = "根据id修改数据")
    public Map<String, Object> updateEmergencyById(@Valid Emergency emergency) {
        try {
            if( emergencyService.updateEmergencyById(emergency) >= 1 ){
                return StatusCode.success("修改成功");
            }else{
                return StatusCode.success("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return StatusCode.error("服务器内部错误：" + e.toString());
        }
    }

    /**
     * @return Map<String, Object> 自定义响应体
     * @description 查询所有数据（备注：不常用）
     * @author Orall
     * @data 2022-9-11
     */
    @GetMapping("/list")
    @ApiOperation(value = "查询所有数据")
    public Map<String, Object> listEmergency() {
        try {
            return StatusCode.success(emergencyService.listEmergency());
        } catch (Exception e) {
            e.printStackTrace();
            return StatusCode.error("服务器内部错误：" + e.toString());
        }
    }

    /**
     * @param id 主键id
     * @return Map<String, Object> 自定义响应体
     * @description 根据id删除数据
     * @author Orall
     * @data 2022-9-11
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除数据")
    public Map<String, Object> deleteEmergencyById(@RequestParam("id") Integer id) {
        try {
            if( emergencyService.deleteEmergencyById(id) >= 1 ){
                return StatusCode.success("删除成功");
            }else{
                return StatusCode.success("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return StatusCode.error("服务器内部错误：" + e.toString());
        }
    }

}