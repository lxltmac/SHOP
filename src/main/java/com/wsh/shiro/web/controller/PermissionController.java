package com.wsh.shiro.web.controller;

import com.wsh.common.base.PageQueryBean;
import com.wsh.common.base.ResponseResult;
import com.wsh.shiro.domain.dto.PermissionDto;
import com.wsh.shiro.domain.dto.RolePermissionDto;
import com.wsh.shiro.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shiro/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

//	@RequiresPermissions("permission:listUI")
//	@RequestMapping("listUI")
//	public String listUI() {
//		return "permission/listUI";
//	}

	@RequiresPermissions("permission:listUI")
    @RequestMapping(value = "list",method=RequestMethod.POST)
    public ResponseResult<PageQueryBean<PermissionDto>> list(@RequestBody PageQueryBean<PermissionDto> permissionDto) {
		PageQueryBean<PermissionDto> pageInfo = permissionService.pageQuery(permissionDto);
		return new ResponseResult<PageQueryBean<PermissionDto>>(pageInfo);
	}


	@RequiresPermissions("role:setPermission")
    @RequestMapping(value = "getPermissionListWithChecked",method=RequestMethod.POST)
    public ResponseResult<List<PermissionDto>> getPermissionListWithChecked(@RequestBody RolePermissionDto rolePermissionDto) {
		List<PermissionDto> permissionList = this.permissionService.getPermissionListByRoleId(rolePermissionDto);
		return new ResponseResult<List<PermissionDto>>(permissionList);
	}


//===================================保存/修改/删除方法=======================================

//	@RequestMapping("saveUI")
//	public String saveUI(Integer id,HttpServletRequest request) {
//		if (id != null) {
//			PermissionDto permission = this.permissionService.getById(id);
//			if (permission != null) {
//				request.setAttribute("permission", permission);
//			}
//		}
//		List<PermissionDto> parentList = this.permissionService.getPermissionWithoutButton();
//		List<PermissionDto> rt = new ArrayList<>();
//        recurData(parentList, rt, "━━");
//
//		request.setAttribute("parentList", rt);
//		return "permission/saveUI";
//	}

	@RequiresPermissions(value={"permission:add","permission:update"})
    @RequestMapping(value = "save",method=RequestMethod.POST)
    public ResponseResult<PermissionDto> save(@RequestBody PermissionDto permission) {
		if (permission.getId() != null) {
			this.permissionService.update(permission);
		} else {
			this.permissionService.save(permission);
		}
		return new ResponseResult<PermissionDto>();
	}

	@RequiresPermissions("permission:delete")
    @RequestMapping(value = "delete",method=RequestMethod.POST)
    public ResponseResult<PermissionDto> delete(@RequestBody PermissionDto permissionDto) {
		try {
			permissionService.deleteById(permissionDto);
			return new ResponseResult<PermissionDto>();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseResult("403", e.getMessage());
		}
	}
}
