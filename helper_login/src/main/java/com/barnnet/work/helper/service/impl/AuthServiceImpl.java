package com.barnnet.work.helper.service.impl;

import com.barnnet.work.helper.bean.reponse.ResponseVo;
import com.barnnet.work.helper.bean.request.LoginInfo;
import com.barnnet.work.helper.entity.LoginUser;
import com.barnnet.work.helper.mapper.AuthMapper;
import com.barnnet.work.helper.service.IAuthService;
import com.barnnet.work.helper.util.redis.RedisHandler;
import com.barnnet.work.helper.util.token.TokenProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author barnnet
 * @date 2019/9/28
 */
@Service
public class AuthServiceImpl implements IAuthService {
    private static final Integer SUCCESSCODE = 1;
    private static final Integer FALLCODE = 0;
    @Resource
    private AuthMapper authMapper;
    @Resource
    private RedisHandler redisHandler;

    /**
     * 用户名登录
     * @param loginInfo
     * @return
     */
    @Override
    public ResponseVo selectLoginUser(LoginInfo loginInfo) {
        ResponseVo responseVo = new ResponseVo();
        LoginUser loginUser = authMapper.selectLoginUser(loginInfo.getUserName(), loginInfo.getUserPass());
        if (loginUser == null){
            responseVo.setReturnCode(FALLCODE);
            responseVo.setToken(null);
            responseVo.setRefreshToken(null);
            return responseVo;
        }else {
            HashMap<String,Object> hashMap = new HashMap<>(10);
            hashMap.put("role","admin");
            String token = TokenProducer.tokenProduce(loginUser);
            String refreshToken = TokenProducer.refreshTokenProduce(loginUser);
            responseVo.setReturnCode(SUCCESSCODE);
            responseVo.setToken(token);
            redisHandler.setString(loginUser.getId()+"token",token);
            redisHandler.setString(loginInfo.getIp()+"ip",loginInfo.getIp());
            responseVo.setRefreshToken(refreshToken);
            responseVo.setMessgae("登录成功");
            return responseVo;
        }
    }

    /**
     * 手机登录
     * @param loginInfo
     * @return
     */
    @Override
    public ResponseVo selectByPhone(LoginInfo loginInfo) {
        ResponseVo responseVo = new ResponseVo();
        LoginUser loginUser = authMapper.selectByPhone(loginInfo.getUserName());
        if (loginUser == null){
            responseVo.setReturnCode(FALLCODE);
            responseVo.setToken(null);
            responseVo.setRefreshToken(null);
            return responseVo;
        }else {
            HashMap<String,Object> hashMap = new HashMap<>(10);
            hashMap.put("role","admin");
            String token = TokenProducer.tokenProduce(loginUser);
            String refreshToken = TokenProducer.refreshTokenProduce(loginUser);
            responseVo.setReturnCode(SUCCESSCODE);
            responseVo.setToken(token);
            redisHandler.setString(loginUser.getId()+"token",token);
            redisHandler.setString(loginInfo.getIp()+"ip",loginInfo.getIp());
            responseVo.setRefreshToken(refreshToken);
            responseVo.setMessgae("登录成功");
            return responseVo;
        }
    }

    /**
     * 邮箱登录
     * @param loginInfo
     * @return
     */
    @Override
    public ResponseVo selectByEmail(LoginInfo loginInfo) {
        ResponseVo responseVo = new ResponseVo();
        LoginUser loginUser = authMapper.selectByEmail(loginInfo.getUserName());
        if (loginUser == null){
            responseVo.setReturnCode(FALLCODE);
            responseVo.setToken(null);
            responseVo.setRefreshToken(null);
            return responseVo;
        }else {
            HashMap<String,Object> hashMap = new HashMap<>(10);
            hashMap.put("role","admin");
            String token = TokenProducer.tokenProduce(loginUser);
            String refreshToken = TokenProducer.refreshTokenProduce(loginUser);
            responseVo.setReturnCode(SUCCESSCODE);
            responseVo.setToken(token);
            redisHandler.setString(loginUser.getId()+"token",token);
            redisHandler.setString(loginInfo.getIp()+"ip",loginInfo.getIp());
            responseVo.setRefreshToken(refreshToken);
            responseVo.setMessgae("登录成功");
            return responseVo;
        }
    }

    @Override
    public ResponseVo selectByPhone(String phone,String ipAddress) {
        ResponseVo responseVo = new ResponseVo();
        LoginUser loginUser = authMapper.selectByPhone(phone);
        if (loginUser == null){
            responseVo.setReturnCode(FALLCODE);
            responseVo.setToken(null);
            responseVo.setRefreshToken(null);
            return responseVo;
        }else {
            HashMap<String,Object> hashMap = new HashMap<>(10);
            hashMap.put("role","admin");
            String token = TokenProducer.tokenProduce(loginUser);
            String refreshToken = TokenProducer.refreshTokenProduce(loginUser);
            responseVo.setReturnCode(SUCCESSCODE);
            responseVo.setToken(token);
            redisHandler.setString(loginUser.getId()+"token",token);
            redisHandler.setString(ipAddress+"ip",ipAddress);
            responseVo.setRefreshToken(refreshToken);
            responseVo.setMessgae("登录成功");
            return responseVo;
        }
    }

    @Override
    public boolean selectByEmail(String email) {
        ResponseVo responseVo = new ResponseVo();
        LoginUser loginUser = authMapper.selectByEmail(email);
        if (loginUser == null){
            return false;
        }else {
            return true;
        }
    }
}
