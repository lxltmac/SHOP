package com.wsh.shiro.web.controller;

import com.wsh.common.base.PageQueryBean;
import com.wsh.common.base.ResponseResult;
import com.wsh.shiro.domain.dto.RoleDto;
import com.wsh.shiro.domain.dto.RolePermissionDto;
import com.wsh.shiro.domain.dto.UserRoleDto;
import com.wsh.shiro.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shiro/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

//	@RequiresPermissions("role:listUI")
//	@RequestMapping("listUI")
//	public String listUI() {
//
//		return "role/listUI";
//	}

	@RequiresPermissions("role:listUI")
    @RequestMapping(value = "list",method=RequestMethod.POST)
	public ResponseResult<PageQueryBean<RoleDto>> list(@RequestBody PageQueryBean<RoleDto> pageQueryBean) {
		PageQueryBean<RoleDto> pageInfo = roleService.pageQuery(pageQueryBean);
		return new ResponseResult<PageQueryBean<RoleDto>>(pageInfo);
	}

	@RequiresPermissions("user:setRole")
//	@RequestMapping("getRoleListWithSelected/{userId}")
//	@ResponseBody
    @RequestMapping(value = "getRoleListWithSelected",method=RequestMethod.POST)
	public ResponseResult<List<RoleDto>> getRoleListWithSelected(@RequestBody UserRoleDto userRoleDto) {
		List<RoleDto> roleList = roleService.getRoleListByUserId(userRoleDto);
		return new ResponseResult<List<RoleDto>>(roleList);
	}


//===================================保存/修改/删除方法=======================================

//	@RequestMapping("saveUI")
//    @RequestMapping(value = "saveUI",method=RequestMethod.POST)
//	public ResponseResult<RoleDto> saveUI(RoleDto roleDto) {
//        roleService.save(roleDto);
//        return new ResponseResult<RoleDto>();
//	}


	@RequiresPermissions(value={"role:add","role:update"})
    @RequestMapping(value = "save",method=RequestMethod.POST)
	public ResponseResult<RoleDto> save(@RequestBody RoleDto role) {
		if (role.getRole_id() == null) {
			roleService.save(role);
		} else {
			roleService.update(role);
		}
		return new ResponseResult<RoleDto>();
	}


	@RequiresPermissions("role:delete")
//	@RequestMapping("delete/{ids}")
//	@ResponseBody
    @RequestMapping(value = "delete",method=RequestMethod.POST)
	public ResponseResult<RoleDto> delete(@RequestBody RoleDto roleDto) {
	    roleService.delete(roleDto);
		return new ResponseResult<RoleDto>();
	}

    @RequiresPermissions("role:delete")
//	@RequestMapping("delete/{ids}")
//	@ResponseBody
    @RequestMapping(value = "batchDelete",method=RequestMethod.POST)
    public ResponseResult<RoleDto> batchDelete(@RequestBody List<RoleDto> roleDtos) {
	    roleService.batchDelete(roleDtos);
        return new ResponseResult<RoleDto>();
    }


	@RequiresPermissions("role:setPermission")
    @RequestMapping(value = "setPermission",method=RequestMethod.POST)
	public ResponseResult<RoleDto> setPermission(@RequestBody List<RolePermissionDto> rolePermissionDtos) {
		roleService.saveRolePermission(rolePermissionDtos);
		return new ResponseResult<>();
	}
}
