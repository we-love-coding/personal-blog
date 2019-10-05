package com.barnnet.work.helper.service;

import com.barnnet.work.helper.bean.reponse.ResponseVo;
import com.barnnet.work.helper.bean.request.LoginInfo;

/**
 * @author barnnet
 * @date 2019/9/28
 */
public interface IAuthService {

    public ResponseVo selectLoginUser(LoginInfo loginInfo);

    public ResponseVo selectByPhone(LoginInfo loginInfo);

    public ResponseVo selectByPhone(String phone,String ipAddress);

    public ResponseVo selectByEmail(LoginInfo loginInfo);

    //public boolean selectByPhone(String phone);

    public boolean selectByEmail(String email);
}
