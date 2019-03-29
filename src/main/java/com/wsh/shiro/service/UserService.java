package com.wsh.shiro.service;

import java.util.List;
import com.wsh.common.base.PageQueryBean;
import com.wsh.shiro.domain.dto.UserDto;
import com.wsh.shiro.domain.dto.UserRoleDto;

/**
 * 
 *
 * @author
 * @version 1.0
 * @date 2019-03-27 18:40:35
 */
public interface UserService {


    /**
	 * 根据主键查询表信息
	 *
	 * @param users
	 * @return
	 */
    public UserDto findById(UserDto users);

    /**
	 * 根据对象查询表信息
	 *
	 * @param users
	 * @return
	 */
    public UserDto find(UserDto users);

    /**
	 * 保存表信息
	 *
	 * @param users
	 * @return
	 */
    public void save(UserDto users);

    /**
	 * 根据主键删除表信息
	 *
	 * @param users
	 */
    public void delete(UserDto users);

    /**
	 * 根据主键修改表信息
	 *
	 * @param users
	 */
    public void update(UserDto users);

    /**
	 * 查询所有表列表
	 *
	 * @param users
	 * @return
	 */
    public List<UserDto> list(UserDto users);

    /**
     * 分页查询表信息
     *
     * @param users
     */
    public PageQueryBean<UserDto> pageQuery(PageQueryBean<UserDto> page);


	public void batchDelete(List<UserDto> userDto);

	public void deleteUserRoleByUserId(UserRoleDto userRole);

	public void saveUserRole(List<UserRoleDto> userRole);
}

