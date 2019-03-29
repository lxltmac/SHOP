package com.wsh.shiro.domain.dto;

import java.io.Serializable;
import java.util.List;

import com.wsh.shiro.domain.entity.UserEntity;

/**
 *  数据传输对象
 *
 * @author
 * @version 1.0
 * @date 2019-03-27 18:40:35
 */
public class UserDto extends UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 封装目录+菜单
     */
    private List<PermissionDto> menuList;

    /**
     * 封装目录+菜单+按钮
     */
    private List<PermissionDto> permissionList;

    public List<PermissionDto> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<PermissionDto> menuList) {
        this.menuList = menuList;
    }

    public List<PermissionDto> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionDto> permissionList) {
        this.permissionList = permissionList;
    }
}
