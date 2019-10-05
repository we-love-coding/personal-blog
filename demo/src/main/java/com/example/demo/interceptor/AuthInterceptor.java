package com.example.demo.interceptor;

import com.example.demo.util.JwtClaims;
import io.goeasy.GoEasy;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author barnnet
 * @date 2019/10/2
 */
@Slf4j
@CrossOrigin
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String ipAddress = request.getParameter("ipAddress");
        String token = request.getParameter("token");
        String refreshToken = request.getParameter("refreshToken");

            if (token == null || token.isEmpty()){
                log.info("token = "+token);
                return false;
            }else {
                try {
                        log.info("token = "+token);
                        Jws<Claims> jwsClaims = JwtClaims.getJwsClaims(token);
                        JwsHeader header = jwsClaims.getHeader();
                        String signature = jwsClaims.getSignature();
                        Claims body = JwtClaims.getClaims(token);
                        String role = (String)body.get("role");
                        Integer id = (Integer)body.get("id");
                        String username = (String)body.get("username");
                        return true;
                    }catch (ExpiredJwtException e) {
                        e.printStackTrace();
                        log.info("token过期");
                        try {
                            if (refreshToken != null || !refreshToken.isEmpty()){
                                    log.info("refreshToken:"+refreshToken);
                                /*GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-f6593166466b4bf88eaeddf169f766ae");
                                goEasy.publish("refreshToken","refresh-success");*/
                            }
                        }catch (ExpiredJwtException e1){
                            e1.printStackTrace();
                            log.info("refreshToken过期");
                            //内网做了防火墙安全拦截，无法访问外网goeasy。
                            return false;
                        }

                    }
            }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
