package com.wsh.shiro.service;

import java.util.List;
import com.wsh.common.base.PageQueryBean;
import com.wsh.shiro.domain.dto.RolePermissionDto;

/**
 * 
 *
 * @author
 * @version 1.0
 * @date 2019-03-27 18:40:35
 */
public interface RolePermissionService {


    /**
	 * 根据主键查询表信息
	 *
	 * @param rolePermission
	 * @return
	 */
    public RolePermissionDto findById(RolePermissionDto rolePermission);

    /**
	 * 根据对象查询表信息
	 *
	 * @param rolePermission
	 * @return
	 */
    public RolePermissionDto find(RolePermissionDto rolePermission);

    /**
	 * 保存表信息
	 *
	 * @param rolePermission
	 * @return
	 */
    public void save(RolePermissionDto rolePermission);

    /**
	 * 根据主键删除表信息
	 *
	 * @param rolePermission
	 */
    public void delete(RolePermissionDto rolePermission);

    public void deleteRolePermissionByRoleId(RolePermissionDto rolePermission);

	public void batchInsert(List<RolePermissionDto> rolePermissionDtos);

    /**
	 * 根据主键修改表信息
	 *
	 * @param rolePermission
	 */
    public void update(RolePermissionDto rolePermission);

    /**
	 * 查询所有表列表
	 *
	 * @param rolePermission
	 * @return
	 */
    public List<RolePermissionDto> list(RolePermissionDto rolePermission);

    /**
     * 分页查询表信息
     *
     * @param rolePermission
     */
    public PageQueryBean<RolePermissionDto> pageQuery(PageQueryBean<RolePermissionDto> page);


    public List<RolePermissionDto> getPermissionListByRoleId(RolePermissionDto rolePermissionDto);

}

