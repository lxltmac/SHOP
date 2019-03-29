package com.wsh.shiro.domain.dto;

import java.io.Serializable;

import com.wsh.shiro.domain.entity.UserRoleEntity;

/**
 *  数据传输对象
 *
 * @author
 * @version 1.0
 * @date 2019-03-27 18:40:35
 */
public class UserRoleDto extends UserRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
