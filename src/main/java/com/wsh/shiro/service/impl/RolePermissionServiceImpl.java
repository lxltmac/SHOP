package com.wsh.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsh.common.base.PageQueryBean;
import com.wsh.shiro.dao.RolePermissionDao;
import com.wsh.shiro.domain.dto.RolePermissionDto;
import com.wsh.shiro.service.RolePermissionService;


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
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    /**
     * 根据主键查询表信息
     *
     * @param rolePermission
     * @return
     */
    @Override
    public RolePermissionDto findById(RolePermissionDto rolePermission){
        return rolePermissionDao.findById(rolePermission);
    }

    /**
     * 根据对象查询表信息
     *
     * @param rolePermission
     * @return
     */
    @Override
    public RolePermissionDto find(RolePermissionDto rolePermission){
        return rolePermissionDao.find(rolePermission);
    }

    /**
     * 保存表信息
     *
     * @param rolePermission
     * @return
     */
    @Override
    public void save(RolePermissionDto rolePermission){
        rolePermissionDao.save(rolePermission);
    }

    /**
     * 根据主键删除表信息
     *
     * @param rolePermission
     */
    @Override
    public void delete(RolePermissionDto rolePermission){
        rolePermissionDao.deleteById(rolePermission);
    }

    /**
     * 根据主键修改表信息
     *
     * @param rolePermission
     */
    @Override
    public void update(RolePermissionDto rolePermission){
        rolePermissionDao.editById(rolePermission);
    }

    @Override
    public void deleteRolePermissionByRoleId(RolePermissionDto rolePermission){
        rolePermissionDao.delete("deleteRolePermissionByRoleId",rolePermission);
    }

    /**
     * 查询所有表列表
     *
     * @param rolePermission
     * @return
     */
    @Override
    public List<RolePermissionDto> list(RolePermissionDto rolePermission){
        return rolePermissionDao.list(rolePermission);
    }

    /**
     * 分页查询表信息
     *
     * @param page
     */
    @Override
    public PageQueryBean<RolePermissionDto> pageQuery(PageQueryBean<RolePermissionDto> page){
        return rolePermissionDao.page(page);
    }

    @Override
    public void batchInsert(List<RolePermissionDto> rolePermissionDtos){
        rolePermissionDao.batchInsert(rolePermissionDtos);
    }

    public List<RolePermissionDto> getPermissionListByRoleId(RolePermissionDto rolePermissionDto){
        return rolePermissionDao.list("getPermissionListByRoleId",rolePermissionDto);
    }

}
