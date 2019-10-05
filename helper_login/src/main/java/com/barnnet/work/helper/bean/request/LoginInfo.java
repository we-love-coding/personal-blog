package com.barnnet.work.helper.bean.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author barnnet
 * @date 2019/9/28
 */
@Data
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 113323427779853001L;
    /**
     * ip电脑ip
     */
    private String ip;
    /**
     * userName用户名
     */
    private String userName;
    /**
     * userPass用户密码
     */
    private String userPass;
    /**
     * email用户邮箱
     */
    private String email;
    /**
     * phone用户手机号码
     */
    private String phone;

}
