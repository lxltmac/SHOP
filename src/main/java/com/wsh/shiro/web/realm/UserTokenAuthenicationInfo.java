package com.wsh.shiro.web.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

/**
 * @author linxili
 * @Description
 * @Date: 2019/3/29 9:42
 */
public class UserTokenAuthenicationInfo extends UsernamePasswordToken implements Serializable {


    private static final long serialVersionUID = 7242800590782870011L;

    private String accesstoken;


    /**
     * 重写getPrincipal方法
     */
    public Object getPrincipal() {
        // TODO Auto-generated method stub
        // 如果获取到用户名，则返回用户名，否则返回电话号码
        if (accesstoken == null) {
            return getUsername();
        } else {
            return getAccesstoken();
        }
    }

    /**
     * 重写getCredentials方法
     */
    public Object getCredentials() {
        // TODO Auto-generated method stub
        // 如果获取到密码，则返回密码，否则返回null
        if (accesstoken == null) {
            return getPassword();
        } else {
            return "ok";
        }
    }

    public UserTokenAuthenicationInfo() {
        // TODO Auto-generated constructor stub
    }

    public UserTokenAuthenicationInfo(final String accesstoken) {
        // TODO Auto-generated constructor stub
        this.accesstoken = accesstoken;
    }

    public UserTokenAuthenicationInfo(final String userName, final String password) {
        // TODO Auto-generated constructor stub
        super(userName, password);
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    @Override
    public String toString() {
        return "AccesstokenToken [accesstoken=" + accesstoken + "]";
    }


}
