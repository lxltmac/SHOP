package com.wsh.shiro.web.realm;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.wsh.shiro.domain.dto.PermissionDto;
import com.wsh.shiro.domain.dto.UserDto;
import com.wsh.shiro.service.PermissionService;
import com.wsh.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Autowired
	private PermissionService permissionService;

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("————身份认证方法————");
		// 获取用户名
		String userName = (String) token.getPrincipal();
		UserDto userDto = new UserDto();
		userDto.setUser_name(userName);
		// 通过用户名获取用户对象
		UserDto user = userService.find(userDto);

		if (user == null) {
			return null;
		}

		// 通过 userId 获取该用户拥有的所有权限，返回值根据自己要求设置，并非固定值。
		PermissionDto permissionDto = new PermissionDto();
		permissionDto.setUserId(user.getUser_id());
		JSONObject permissionJsonObject = permissionService.getPermissionMapByUserId(permissionDto);

		// （目录+菜单，分层级）
		user.setMenuList((List<PermissionDto>) permissionJsonObject.get("menuList"));
		// （目录+菜单+按钮）
		user.setPermissionList((List<PermissionDto>) permissionJsonObject.get("permissionList"));

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());

		return info;
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		UserDto user = (UserDto) principals.getPrimaryPrincipal();

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // （目录+菜单+按钮）
        List<PermissionDto> permissionList = user.getPermissionList();

        for (PermissionDto permission : permissionList) {
        	if (StringUtil.isNotEmpty(permission.getCode())) {
        		info.addStringPermission(permission.getCode());
        	}
        }

		return info;
	}

}
