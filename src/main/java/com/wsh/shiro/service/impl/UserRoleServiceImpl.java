package com.wsh.shiro.service.impl;

import java.util.List;

import com.wsh.shiro.domain.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsh.common.base.PageQueryBean;
import com.wsh.shiro.dao.UserRoleDao;
import com.wsh.shiro.domain.dto.UserRoleDto;
import com.wsh.shiro.service.UserRoleService;


/**
 *
 * 表服务实现
 *
 * @author
 * @version 1.0
 * @date 2019-03-27 18:40:35
 */
@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    /**
     * 根据主键查询表信息
     *
     * @param userRole
     * @return
     */
    @Override
    public UserRoleDto findById(UserRoleDto userRole){
        return userRoleDao.findById(userRole);
    }

    /**
     * 根据对象查询表信息
     *
     * @param userRole
     * @return
     */
    @Override
    public UserRoleDto find(UserRoleDto userRole){
        return userRoleDao.find(userRole);
    }

    /**
     * 保存表信息
     *
     * @param userRole
     * @return
     */
    @Override
    public void save(UserRoleDto userRole){
        userRoleDao.save(userRole);
    }

    /**
     * 根据主键删除表信息
     *
     * @param userRole
     */
    @Override
    public void delete(UserRoleDto userRole){
        userRoleDao.deleteById(userRole);
    }

    /**
     * 根据主键修改表信息
     *
     * @param userRole
     */
    @Override
    public void update(UserRoleDto userRole){
        userRoleDao.editById(userRole);
    }

    /**
     * 查询所有表列表
     *
     * @param userRole
     * @return
     */
    @Override
    public List<UserRoleDto> list(UserRoleDto userRole){
        return userRoleDao.list(userRole);
    }

    /**
     * 分页查询表信息
     *
     * @param page
     */
    @Override
    public PageQueryBean<UserRoleDto> pageQuery(PageQueryBean<UserRoleDto> page){
        return userRoleDao.page(page);
    }

    public void batchAdd(List<UserRoleDto> userRoleDtos){
        userRoleDao.batchInsert(userRoleDtos);
    }

    public List<RoleDto> getRoleListByUserId(UserRoleDto userRoleDto){
        return userRoleDao.list("getRoleListByUserId",userRoleDto,RoleDto.class);
    }

}
