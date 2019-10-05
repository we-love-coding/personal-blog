package com.barnnet.work.helper.controller;

import com.barnnet.work.helper.bean.ResponseVo;
import com.barnnet.work.helper.service.IRegisterService;
import com.barnnet.work.helper.util.redis.RedisHandler;
import com.barnnet.work.helper.util.regex.RegexUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author barnnet
 * @date 2019/10/4
 */
@RestController
public class RegisterController {
    private static final Integer SUCCESSCODE = 1;
    private static final Integer FALLCODE = 0;
    @Resource
    private IRegisterService iRegisterService;
    @Resource
    private RedisHandler redisHandler;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseVo register(String x,String password,String code){
        ResponseVo responseVo = new ResponseVo();
        String redisCode = redisHandler.getObject(x + "code");
        if (RegexUtil.isPhone(x)){
            //比较code
            if (redisCode.equals(code)){
                try {
                    iRegisterService.register(x, password);
                    responseVo.setReturnCode(SUCCESSCODE);
                    responseVo.setMessage("注册成功");
                    return responseVo;
                } catch (Exception e) {
                    e.printStackTrace();
                    responseVo.setReturnCode(FALLCODE);
                    responseVo.setMessage("注册失败");
                    return responseVo;
                }
            }else {
                responseVo.setReturnCode(FALLCODE);
                responseVo.setMessage("验证码不正确");
                return responseVo;
            }
        }else if (RegexUtil.isEmail(x)){
            //比较code
            if (redisCode.equals(code)){
                try {
                    iRegisterService.register(x, password);
                    responseVo.setReturnCode(SUCCESSCODE);
                    responseVo.setMessage("注册成功");
                    return responseVo;
                } catch (Exception e) {
                    e.printStackTrace();
                    responseVo.setReturnCode(FALLCODE);
                    responseVo.setMessage("注册失败");
                    return responseVo;
                }
            }else {
                    responseVo.setReturnCode(FALLCODE);
                    responseVo.setMessage("验证码不正确");
                    return responseVo;
            }
        }else{
            //直接注册
            try {
                iRegisterService.register(x, password);
                responseVo.setReturnCode(SUCCESSCODE);
                responseVo.setMessage("注册成功");
                return responseVo;
            } catch (Exception e) {
                e.printStackTrace();
                responseVo.setReturnCode(FALLCODE);
                responseVo.setMessage("注册失败");
                return responseVo;
            }
        }

    }
}
