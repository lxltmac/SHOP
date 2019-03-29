package com.wsh.shiro.service.impl;

import java.util.List;

import com.wsh.shiro.domain.dto.RolePermissionDto;
import com.wsh.shiro.domain.dto.UserRoleDto;
import com.wsh.shiro.service.RolePermissionService;
import com.wsh.shiro.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsh.common.base.PageQueryBean;
import com.wsh.shiro.dao.RoleDao;
import com.wsh.shiro.domain.dto.RoleDto;
import com.wsh.shiro.service.RoleService;


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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 根据主键查询表信息
     *
     * @param role
     * @return
     */
    @Override
    public RoleDto findById(RoleDto role){
        return roleDao.findById(role);
    }

    /**
     * 根据对象查询表信息
     *
     * @param role
     * @return
     */
    @Override
    public RoleDto find(RoleDto role){
        return roleDao.find(role);
    }

    /**
     * 保存表信息
     *
     * @param role
     * @return
     */
    @Override
    public void save(RoleDto role){
        roleDao.save(role);
    }

    /**
     * 根据主键删除表信息
     *
     * @param role
     */
    @Override
    public void delete(RoleDto role){
        roleDao.deleteById(role);
    }

    /**
     * 根据主键修改表信息
     *
     * @param role
     */
    @Override
    public void update(RoleDto role){
        roleDao.editById(role);
    }

    /**
     * 查询所有表列表
     *
     * @param role
     * @return
     */
    @Override
    public List<RoleDto> list(RoleDto role){
        return roleDao.list(role);
    }

    /**
     * 分页查询表信息
     *
     * @param role
     */
    @Override
    public PageQueryBean<RoleDto> pageQuery(PageQueryBean<RoleDto> page){
        return roleDao.page(page);
    }


    public void saveRolePermission(List<RolePermissionDto> rolePermissionDtos){
        // 解绑
        rolePermissionService.deleteRolePermissionByRoleId(rolePermissionDtos.get(0));

        if (!rolePermissionDtos.isEmpty() && null != rolePermissionDtos) {
            // 绑定
            rolePermissionService.batchInsert(rolePermissionDtos);
        }
    }

    public List<RoleDto> getRoleListByUserId(UserRoleDto userRoleDto){
        List<RoleDto> list = userRoleService.getRoleListByUserId(userRoleDto);
        RoleDto roleDto = new RoleDto();
        List<RoleDto> roleList = this.list(roleDto);

        for (RoleDto role : roleList) {
            for (RoleDto r : list) {
                if (role.getRole_id() == r.getRole_id()) {
                    role.setSelected(true);
                }
            }
        }
        return roleList;
    }

    /**
     * @Author linxili
     * @Description: 批量删除
     * @Date: 2019/3/28
     * @param roleDtos
     * @return: void
     **/
    public void batchDelete(List<RoleDto> roleDtos){
        roleDao.batchDelete(roleDtos);
    }
}
