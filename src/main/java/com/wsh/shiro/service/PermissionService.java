package com.wsh.shiro.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.wsh.common.base.PageQueryBean;
import com.wsh.shiro.domain.dto.PermissionDto;
import com.wsh.shiro.domain.dto.RolePermissionDto;

/**
 * 
 *
 * @author
 * @version 1.0
 * @date 2019-03-27 18:40:35
 */
public interface PermissionService {


    /**
	 * 根据主键查询表信息
	 *
	 * @param permission
	 * @return
	 */
    public PermissionDto findById(PermissionDto permission);

    /**
	 * 根据对象查询表信息
	 *
	 * @param permission
	 * @return
	 */
    public PermissionDto find(PermissionDto permission);

    /**
	 * 保存表信息
	 *
	 * @param permission
	 * @return
	 */
    public void save(PermissionDto permission);

    /**
	 * 根据主键删除表信息
	 *
	 * @param permission
	 */
    public void delete(PermissionDto permission);

    /**
	 * 根据主键修改表信息
	 *
	 * @param permission
	 */
    public void update(PermissionDto permission);

    /**
	 * 查询所有表列表
	 *
	 * @param permission
	 * @return
	 */
    public List<PermissionDto> list(PermissionDto permission);

    /**
     * 分页查询表信息
     *
     * @param permission
     */
    public PageQueryBean<PermissionDto> pageQuery(PageQueryBean<PermissionDto> page);

    public PermissionDto getChildrenCount(PermissionDto permissionDto);

	public JSONObject getPermissionMapByUserId(PermissionDto permissionDto);

	public List<PermissionDto> getPermissionList(PermissionDto permissionDto);

	public void deleteById(PermissionDto permissionDto);

	public List<PermissionDto> getPermissionWithoutButton(PermissionDto permissionDto);

	public List<PermissionDto> getPermissionListByRoleId(RolePermissionDto rolePermissionDto);
}

