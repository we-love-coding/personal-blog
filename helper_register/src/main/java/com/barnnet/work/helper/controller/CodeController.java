package com.barnnet.work.helper.controller;

import com.barnnet.work.helper.entity.SendCode;
import com.barnnet.work.helper.util.redis.RedisHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author barnnet
 * @date 2019/10/3
 */
@Controller
public class CodeController {

    @Resource
    private RedisHandler redisHandler;
    @RequestMapping(value ="sendPhoneCode",method = RequestMethod.POST)
    public void sendPhoneCode(String phone,HttpServletRequest request, HttpServletResponse response, HttpSession session){
        try {
            String code = SendCode.sendCode();
//            session.setAttribute("code",code);
            redisHandler.setString(phone+"code",code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value ="sendEmailCode",method = RequestMethod.POST)
    public void sendEmailCode(String email,HttpServletRequest request, HttpServletResponse response, HttpSession session){
        try {
           /* String code = SendCode.sendCode();
//            session.setAttribute("code",code);
            redisHandler.setString(phone+"code",code);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
