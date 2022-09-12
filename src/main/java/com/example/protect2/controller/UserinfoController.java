package com.example.protect2.controller;

import com.example.protect2.pojo.Userinfo;
import com.example.protect2.service.UserinfoService;
import com.example.protect2.utils.JwtUtils;
import com.example.protect2.utils.StatusCode;
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
* @description Userinfo的Controller层
* @data 2022-9-11
*/
@RestController
@RequestMapping(value = "/api/userinfo")
public class UserinfoController {
    @Resource
    UserinfoService userinfoService;

    /**
    * @param userinfo 添加的实体类
    * @return Map<String, Object> 自定义响应体
    * @description 添加数据
    * @author Orall
    * @data 2022-9-11
    */
    @PostMapping("/insert")
    @ApiOperation(value = "添加数据")
    public Map<String, Object> insertUserinfo(@Valid Userinfo userinfo) {
        try {
            if( userinfoService.insertUserinfo(userinfo) >= 1 ){
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
    public Map<String, Object> getUserinfoById(@RequestParam("id") Integer id) {
        try {
            return StatusCode.success(userinfoService.getUserinfoById(id));
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
    public Map<String, Object> listUserinfoByPage(@RequestParam("page") int page) {
        try {
            //limit默认为10
            return StatusCode.success(userinfoService.listUserinfoByPage(page,10));
        } catch (Exception e) {
            e.printStackTrace();
            return StatusCode.error("服务器内部错误：" + e.toString());
        }
    }

    /**
     * @param userinfo 需要修改的实体类
     * @return Map<String, Object> 自定义响应体
     * @description 根据id修改数据
     * @author Orall
     * @data 2022-9-11
     */
    @PutMapping("/update")
    @ApiOperation(value = "根据id修改数据")
    public Map<String, Object> updateUserinfoById(@Valid Userinfo userinfo) {
        try {
            if( userinfoService.updateUserinfoById(userinfo) >= 1 ){
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
    public Map<String, Object> listUserinfo() {
        try {
            return StatusCode.success(userinfoService.listUserinfo());
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
    public Map<String, Object> deleteUserinfoById(@RequestParam("id") Integer id) {
        try {
            if( userinfoService.deleteUserinfoById(id) >= 1 ){
                return StatusCode.success("删除成功");
            }else{
                return StatusCode.success("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return StatusCode.error("服务器内部错误：" + e.toString());
        }
    }


    /**
     * @return Map<String, Object> 自定义响应体
     * @description 成年人登录
     * @author Orall
     * @data 2022-9-11
     */
    @GetMapping("/loginadult")
    @ApiOperation(value = "成年人登录")
    public Map<String, Object> loginAdult(@Valid Userinfo userinfo) {
        try {
            if( userinfoService.loginAdult(userinfo) >= 1 ){
                Userinfo tmp = userinfoService.getloginAdult(userinfo);
                JwtUtils jwt = JwtUtils.getInstance();
                String token = jwt
                        .setClaim("userid",tmp.getId())
                        .setClaim("name",userinfo.getName())
                        .setClaim("tele",userinfo.getTele())
                        .setExpired(50000)
                        .generateToken();
                return StatusCode.success(token);
            }else{
                return StatusCode.success("用户不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return StatusCode.error("服务器内部错误：" + e.toString());
        }
    }

    /**
     * @return Map<String, Object> 自定义响应体
     * @description 未成年人登录
     * @author Orall
     * @data 2022-9-11
     */
    @GetMapping("/loginunderage")
    @ApiOperation(value = "未成年人登录")
    public Map<String, Object> loginUnderAge(@Valid Userinfo userinfo) {
        try {
            if( userinfoService.loginUnderAge(userinfo) >= 1 ){
                Userinfo tmp = userinfoService.getloginUnderAge(userinfo);
                JwtUtils jwt = JwtUtils.getInstance();
                String token = jwt
                        .setClaim("userid",tmp.getId())
                        .setClaim("name",userinfo.getName())
                        .setClaim("guardian_tele",userinfo.getGuardian_tele())
                        .setExpired(50000)
                        .generateToken();
                return StatusCode.success(token);
            }else{
                return StatusCode.success("用户不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return StatusCode.error("服务器内部错误：" + e.toString());
        }
    }

}