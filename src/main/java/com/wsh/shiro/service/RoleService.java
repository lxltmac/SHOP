package com.wsh.shiro.service;

import java.util.List;
import com.wsh.common.base.PageQueryBean;
import com.wsh.shiro.domain.dto.RoleDto;
import com.wsh.shiro.domain.dto.RolePermissionDto;
import com.wsh.shiro.domain.dto.UserRoleDto;

/**
 * 
 *
 * @author
 * @version 1.0
 * @date 2019-03-27 18:40:35
 */
public interface RoleService {


    /**
	 * 根据主键查询表信息
	 *
	 * @param role
	 * @return
	 */
    public RoleDto findById(RoleDto role);

    /**
	 * 根据对象查询表信息
	 *
	 * @param role
	 * @return
	 */
    public RoleDto find(RoleDto role);

    /**
	 * 保存表信息
	 *
	 * @param role
	 * @return
	 */
    public void save(RoleDto role);

    /**
	 * 根据主键删除表信息
	 *
	 * @param role
	 */
    public void delete(RoleDto role);

    /**
	 * 根据主键修改表信息
	 *
	 * @param role
	 */
    public void update(RoleDto role);

    /**
	 * 查询所有表列表
	 *
	 * @param role
	 * @return
	 */
    public List<RoleDto> list(RoleDto role);

    /**
     * 分页查询表信息
     *
     * @param role
     */
    public PageQueryBean<RoleDto> pageQuery(PageQueryBean<RoleDto> page);

	public void saveRolePermission(List<RolePermissionDto> rolePermissionDtos);

	public List<RoleDto> getRoleListByUserId(UserRoleDto userRoleDto);

	public void batchDelete(List<RoleDto> roleDtos);

}

