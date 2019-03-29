package com.wsh.shiro.domain.dto;

import java.io.Serializable;

import com.wsh.shiro.domain.entity.RoleEntity;

/**
 *  数据传输对象
 *
 * @author
 * @version 1.0
 * @date 2019-03-27 18:40:35
 */
public class RoleDto extends RoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean selected;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
