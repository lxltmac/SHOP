package com.wsh.shiro.domain.dto;

import java.io.Serializable;

import com.wsh.shiro.domain.entity.RolePermissionEntity;

/**
 *  数据传输对象
 *
 * @author
 * @version 1.0
 * @date 2019-03-27 18:40:35
 */
public class RolePermissionDto extends RolePermissionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
