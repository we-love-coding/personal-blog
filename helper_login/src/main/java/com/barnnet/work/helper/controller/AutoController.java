package com.barnnet.work.helper.controller;

import com.barnnet.work.helper.bean.reponse.ResponseVo;
import com.barnnet.work.helper.bean.request.LoginInfo;
import com.barnnet.work.helper.service.IAuthService;
import com.barnnet.work.helper.util.redis.RedisHandler;
import com.barnnet.work.helper.util.regex.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author barnnet
 * @date 2019/9/28
 */
@RestController
@CrossOrigin
public class AutoController {
    private static final Integer SUCCESSCODE = 1;
    private static final Integer FALLCODE = 0;
    @Resource
    private IAuthService iAuthService;
    @Resource
    private RedisHandler redisHandler;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseVo auth(LoginInfo loginInfo){

        ResponseVo responseVo1 = null;
        if (loginInfo == null){
            responseVo1 = new ResponseVo();
            responseVo1.setReturnCode(FALLCODE);
            responseVo1.setToken(null);
            return responseVo1;
        }
        String userName = loginInfo.getUserName();
        boolean phone = RegexUtil.isPhone(userName);
        boolean email = RegexUtil.isEmail(userName);
        if (phone){
            //手机号码登录
            ResponseVo responseVo3 = iAuthService.selectByPhone(loginInfo);
            return responseVo3;
        }else if (email){
            //邮箱登录
            ResponseVo responseVo4 = iAuthService.selectByEmail(loginInfo);
            return responseVo4;
        }else {
            //账户登录，密码
            ResponseVo responseVo2 = iAuthService.selectLoginUser(loginInfo);
            return responseVo2;
        }
        /*if (type == 0){
            //账户登录，密码
            ResponseVo responseVo2 = iAuthService.selectLoginUser(loginInfo);
            return responseVo2;
        }else if (type == 1){
            //手机号码登录
            ResponseVo responseVo3 = iAuthService.selectByPhone(loginInfo);
            return responseVo3;
        }else {
            //邮箱登录
            ResponseVo responseVo4 = iAuthService.selectByEmail(loginInfo);
            return responseVo4;
        }*/
    }
    @RequestMapping(value = "/codeByPhone" ,method = RequestMethod.GET)
    public ResponseVo codeByPhone(String phone, String code, String ipAddress,HttpServletRequest request,HttpSession session){
        //ResponseVo responseVo5 = new ResponseVo();
        ResponseVo responseVo = iAuthService.selectByPhone(phone, ipAddress);
        //String phoneCode = (String) request.getSession().getAttribute("code");
        //String phoneCode = (String) session.getAttribute("code");
        String phoneCode = redisHandler.getObject(phone + "code");
        if (code.equals(phoneCode)&&responseVo.getReturnCode().equals(SUCCESSCODE)){

            /*//短信通知，调用阿里巴巴的api

                String msg = "登录成功";
                responseVo5.setReturnCode(SUCCESSCODE);
                responseVo5.setMessgae(msg);*/

            return responseVo;
        }else {
            //要么替用户创建用户
            //要么通知用户去注册
            /*responseVo5.setReturnCode(FALLCODE);
            responseVo5.setMessgae("请注册");*/
            return responseVo;
        }
    }

    @RequestMapping(value = "/codeByEmail" ,method = RequestMethod.GET)
    public ResponseVo codeByEmail(String email){
        ResponseVo responseVo6 = new ResponseVo();
        boolean bool = iAuthService.selectByEmail(email);
        if (bool){
            //邮箱通知，调用阿里巴巴的api
            String msg = "ALIBABA";
            responseVo6.setReturnCode(SUCCESSCODE);
            responseVo6.setMessgae(msg);
            return responseVo6;
        }else {
            //要么替用户创建用户
            //要么通知用户去注册
            responseVo6.setReturnCode(FALLCODE);
            responseVo6.setMessgae("请注册");
            return responseVo6;
        }
    }


}
