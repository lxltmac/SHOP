package com.wsh.shiro.service;

import java.util.List;
import com.wsh.common.base.PageQueryBean;
import com.wsh.shiro.domain.dto.RoleDto;
import com.wsh.shiro.domain.dto.UserRoleDto;

/**
 * 
 *
 * @author
 * @version 1.0
 * @date 2019-03-27 18:40:35
 */
public interface UserRoleService {


    /**
	 * 根据主键查询表信息
	 *
	 * @param userRole
	 * @return
	 */
    public UserRoleDto findById(UserRoleDto userRole);

    /**
	 * 根据对象查询表信息
	 *
	 * @param userRole
	 * @return
	 */
    public UserRoleDto find(UserRoleDto userRole);

    /**
	 * 保存表信息
	 *
	 * @param userRole
	 * @return
	 */
    public void save(UserRoleDto userRole);

    /**
	 * 根据主键删除表信息
	 *
	 * @param userRole
	 */
    public void delete(UserRoleDto userRole);

    /**
	 * 根据主键修改表信息
	 *
	 * @param userRole
	 */
    public void update(UserRoleDto userRole);

    /**
	 * 查询所有表列表
	 *
	 * @param userRole
	 * @return
	 */
    public List<UserRoleDto> list(UserRoleDto userRole);

    /**
     * 分页查询表信息
     *
     * @param userRole
     */
    public PageQueryBean<UserRoleDto> pageQuery(PageQueryBean<UserRoleDto> page);

    public void batchAdd(List<UserRoleDto> userRoleDtos);

    public List<RoleDto> getRoleListByUserId(UserRoleDto userRoleDto);
}

