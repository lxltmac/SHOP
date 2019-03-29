package com.wsh.shiro.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wsh.shiro.domain.dto.UserRoleDto;
import com.wsh.shiro.service.UserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsh.common.base.PageQueryBean;
import com.wsh.shiro.dao.UserDao;
import com.wsh.shiro.domain.dto.UserDto;
import com.wsh.shiro.service.UserService;


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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 根据主键查询表信息
     *
     * @param users
     * @return
     */
    @Override
    public UserDto findById(UserDto users){
        return userDao.findById(users);
    }

    /**
     * 根据对象查询表信息
     *
     * @param users
     * @return
     */
    @Override
    public UserDto find(UserDto users){
        return userDao.find(users);
    }

    /**
     * 保存表信息
     *
     * @param users
     * @return
     */
    @Override
    public void save(UserDto users){
        userDao.save(users);
    }

    /**
     * 根据主键删除表信息
     *
     * @param users
     */
    @Override
    public void delete(UserDto users){
        userDao.deleteById(users);
    }

    /**
     * @Author linxili
     * @Description: 批量删除
     * @Date: 2019/3/27
     * @param userDto
     * @return: void
     **/
    public void batchDelete(List<UserDto> userDto){
        userDao.batchDelete(userDto);
    }


    public void deleteUserRoleByUserId(UserRoleDto userRole){
        userRoleService.delete(userRole);
    }

    public void saveUserRole(List<UserRoleDto> userRole){
        // 解绑
        this.deleteUserRoleByUserId(userRole.get(0));

        if (!userRole.isEmpty() && null != userRole) {
            // 绑定
            userRoleService.batchAdd(userRole);
        }
    }

    /**
     * 根据主键修改表信息
     *
     * @param users
     */
    @Override
    public void update(UserDto users){
        userDao.editById(users);
    }

    /**
     * 查询所有表列表
     *
     * @param users
     * @return
     */
    @Override
    public List<UserDto> list(UserDto users){
        return userDao.list(users);
    }

    /**
     * 分页查询表信息
     *
     * @param users
     */
    @Override
    public PageQueryBean<UserDto> pageQuery(PageQueryBean<UserDto> page){
        return userDao.page(page);
    }

}
