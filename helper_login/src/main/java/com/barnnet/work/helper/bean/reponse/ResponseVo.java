package com.barnnet.work.helper.bean.reponse;

import lombok.Data;

import java.io.Serializable;

/**
 * @author barnnet
 * @date 2019/9/28
 */
@Data
public class ResponseVo implements Serializable {
    private static final long serialVersionUID = 113323427779853001L;
    /**
     * returnCode返回代码
     */
    private Integer returnCode;
    /**
     * token返回token
     */
    private String token;
    /**
     * refreshToken刷新token
     */
    private String refreshToken;
    /**
     * messgae
     */
    private String messgae;
}
