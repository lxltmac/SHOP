package com.wsh.shiro.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.wsh.common.base.ResponseResult;
import com.wsh.shiro.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linxili
 * @Description
 * @Date: 2019/3/27 12:41
 */
@RestController
@RequestMapping("/api/lxl")
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "loginsd",method=RequestMethod.POST)
    public ResponseResult<JSONObject> login(@RequestBody JSONObject jsonObject) {
        String userName = jsonObject.getString("userName");
        String password = jsonObject.getString("password");
        System.out.println("username============="+userName);

        UsernamePasswordToken token = new UsernamePasswordToken(userName.trim(), DigestUtils.md5Hex(password).toCharArray());
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);

        }catch (UnknownAccountException e) {
            return new ResponseResult("403", "用户名或密码不存在");
//            return Result.fail(403, "用户名或密码不存在");

        }catch(IncorrectCredentialsException e) {
            return new ResponseResult("403", "密码不正确");
//            return Result.fail(403, "密码不正确");

        }

        return new ResponseResult<JSONObject>();
    }
}
