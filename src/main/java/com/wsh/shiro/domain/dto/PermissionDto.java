package com.wsh.shiro.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.wsh.shiro.domain.entity.PermissionEntity;
import io.swagger.models.auth.In;

/**
 *  数据传输对象
 *
 * @author
 * @version 1.0
 * @date 2019-03-27 18:40:35
 */
public class PermissionDto extends PermissionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Boolean checked;

    private List<PermissionDto> children = new ArrayList<>();

    private Integer childrenCount;

    private Integer userId;

    private Integer permissionId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public List<PermissionDto> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionDto> children) {
        this.children = children;
    }

    public Integer getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
