package com.wsh.shiro.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.wsh.shiro.domain.dto.RolePermissionDto;
import com.wsh.shiro.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wsh.common.base.PageQueryBean;
import com.wsh.shiro.dao.PermissionDao;
import com.wsh.shiro.domain.dto.PermissionDto;
import com.wsh.shiro.service.PermissionService;


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
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 根据主键查询表信息
     *
     * @param permission
     * @return
     */
    @Override
    public PermissionDto findById(PermissionDto permission){
        return permissionDao.findById(permission);
    }

    /**
     * 根据对象查询表信息
     *
     * @param permission
     * @return
     */
    @Override
    public PermissionDto find(PermissionDto permission){
        return permissionDao.find(permission);
    }

    /**
     * 保存表信息
     *
     * @param permission
     * @return
     */
    @Override
    public void save(PermissionDto permission){
        if (permission.getPid() != null && permission.getPid() != 0) {
            PermissionDto parent = this.findById(permission);
            System.out.println(parent);
            permission.setParent_name(parent.getName());
        }
        permissionDao.save(permission);
    }

    /**
     * 根据主键删除表信息
     *
     * @param permission
     */
    @Override
    public void delete(PermissionDto permission){
        permissionDao.deleteById(permission);
    }

    /**
     * 根据主键修改表信息
     *
     * @param permission
     */
    @Override
    public void update(PermissionDto permission){
        if (permission.getPid() != null && permission.getPid() != 0) {
            PermissionDto parent = this.findById(permission);
            permission.setParent_name(parent.getName());
        }
        permissionDao.editById(permission);
    }

    /**
     * 查询所有表列表
     *
     * @param permission
     * @return
     */
    @Override
    public List<PermissionDto> list(PermissionDto permission){
        return permissionDao.list(permission);
    }

    /**
     * 分页查询表信息
     *
     * @param page
     */
    @Override
    public PageQueryBean<PermissionDto> pageQuery(PageQueryBean<PermissionDto> page){
        return permissionDao.page(page);
    }

    public List<PermissionDto> getPermissionList(PermissionDto permissionDto){
        return permissionDao.list("getPermissionList",permissionDto);
    }

    public JSONObject getPermissionMapByUserId(PermissionDto permissionDto){
        List<PermissionDto> permissionList = this.getPermissionList(permissionDto);

        List<PermissionDto> menuList = new ArrayList<>();
        Map<Integer, PermissionDto> map = new HashMap<>();
        JSONObject jsonObject = new JSONObject();

        // 筛选目录
        for (PermissionDto permission : permissionList) {
            if (permission.getType() != 3 && permission.getPid() == 0L) {
                jsonObject.put(String.valueOf(permission.getId()), permission);
                menuList.add(permission);
            }
        }

        // 封装菜单
        for (PermissionDto permission : permissionList) {
            if (permission.getType() != 3 && map.get(permission.getPid()) != null) {
                PermissionDto parent = (PermissionDto) jsonObject.get(String.valueOf(permission.getPid()));
                parent.getChildren().add(permission);
            }
        }

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("menuList", menuList);
        jsonParam.put("permissionList", permissionList);

        return jsonParam;

    }

    public PermissionDto getChildrenCount(PermissionDto permissionDto){
        return permissionDao.find("getChildrenCount",permissionDto);
    }


    public void deleteById(PermissionDto permissionDto) {
        PermissionDto permission = this.findById(permissionDto);
        if (permission != null) {
            if (permission.getType() != 3) {
                int count = this.getChildrenCount(permissionDto).getChildrenCount();
                if (count > 0) {
                    throw new RuntimeException("该权限包含子权限，不能删除!如要删除，请将子权限删除再进行操作");
                }
            }
            permissionDao.deleteById(permissionDto);
        }
    }

    public List<PermissionDto> getPermissionWithoutButton(PermissionDto permissionDto) {
        return permissionDao.list("getPermissionWithoutButton",permissionDto);
    }


    public List<PermissionDto> getPermissionListByRoleId(RolePermissionDto rolePermissionDto) {
        List<RolePermissionDto> list = rolePermissionService.getPermissionListByRoleId(rolePermissionDto);
        PermissionDto permissionParam = new PermissionDto();
        List<PermissionDto> permissionList = this.list(permissionParam);

        for (PermissionDto permission : permissionList) {
            for (RolePermissionDto p : list) {
                if (permission.getId() == p.getPermission_id()) {
                    permission.setChecked(true);
                }
            }
        }

        return permissionList;
    }

}
