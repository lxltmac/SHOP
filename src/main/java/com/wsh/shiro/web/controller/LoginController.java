package com.wsh.shiro.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.wsh.common.base.ResponseResult;
import com.wsh.shiro.domain.dto.UserDto;
import com.wsh.shiro.service.PermissionService;
import com.wsh.shiro.service.UserService;
import com.wsh.shiro.vo.Result;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/shiro")
public class LoginController {

	@RequestMapping(value = "notLogin",method=RequestMethod.GET)
	public ResponseResult<JSONObject> notLogin(){
		return new ResponseResult("403", "您尚未登陆！");
	}

    @RequestMapping(value = "login",method=RequestMethod.POST)
	public ResponseResult<JSONObject> login(@RequestBody UserDto userDto) {
		String userName = userDto.getUser_name();
		String password = userDto.getPassword();
    	if(userName == null || password == null){
			return new ResponseResult("403", "用户名或密码为空，请先登录");
		}

		UsernamePasswordToken token = new UsernamePasswordToken(userName.trim(), DigestUtils.md5Hex(password).toCharArray());
		Subject subject = SecurityUtils.getSubject();
		JSONObject jsonObject = new JSONObject();
		byte[] decodeBase64 = Base64.decodeBase64("20190329");
		String stringtoken = new String(decodeBase64);//Base64值
		try {
			subject.login(token);
			jsonObject.put("token",token);
		}catch (UnknownAccountException e) {
            return new ResponseResult("403", "用户名不存在");

		}catch(IncorrectCredentialsException e) {
            return new ResponseResult("403", "密码不正确");

		}

		return new ResponseResult<JSONObject>(jsonObject);
	}

//    @RequestMapping(value = "logout",method=RequestMethod.POST)
//	public Result logout(HttpSession session) {
//		Subject subject = SecurityUtils.getSubject();
//		subject.logout();
//		return Result.succeed("/index.jsp");
//	}
//
//	@RequestMapping("manageUI")
//	public String manageUI(HttpServletRequest request) {
//
//		//主体
//		Subject subject = SecurityUtils.getSubject();
//
//		UserDto user = (UserDto) subject.getPrincipal();
//
//		request.setAttribute("loginUser", user);
//
//		return "manageUI";
//	}
}
