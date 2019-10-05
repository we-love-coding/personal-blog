package com.barnnet.work.helper.mapper;
import com.barnnet.work.helper.entity.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author barnnet
 * @date 2019/9/28
 */
@Mapper
public interface AuthMapper {
    /**
     * 查询用户
     * @param userName
     * @param userPass
     * @return
     */
    public LoginUser selectLoginUser(@Param("userName") String userName,
                                     @Param("userPass") String userPass);

    /**
     * 手机登录
     * @param phone
     * @return
     */
    public LoginUser selectByPhone(@Param("phone") String phone);

    /**
     * 邮箱登录
     * @param email
     * @return
     */
    public LoginUser selectByEmail(@Param("email") String email);
}
