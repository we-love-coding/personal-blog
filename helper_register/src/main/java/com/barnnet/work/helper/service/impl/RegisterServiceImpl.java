package com.barnnet.work.helper.service.impl;

import com.barnnet.work.helper.mapper.RegisterMapper;
import com.barnnet.work.helper.service.IRegisterService;
import com.barnnet.work.helper.util.regex.RegexUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author barnnet
 * @date 2019/10/4
 */
@Service
public class RegisterServiceImpl implements IRegisterService {

    @Resource
    private RegisterMapper registerMapper;
    @Override
    public void register(String x, String password) throws Exception{
        boolean phone = RegexUtil.isPhone(x);
        boolean email = RegexUtil.isEmail(x);
        if (phone){
            registerMapper.registerByPhone(x, password);
        }else if (email){
            registerMapper.registerByEmail(x, password);
        }else {
            registerMapper.registerByUser(x, password);
        }
    }
}
