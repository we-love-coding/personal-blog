package com.barnnet.work.helper.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import	java.util.Map;

/**
 * @author barnnet
 * @date 2019/10/4
 */
@Mapper
public interface RegisterMapper {
    /**
     * 手机注册
     * @param phone
     * @param password
     */
    public void registerByPhone(@Param("phone") String phone,@Param("password") String password);

    /**
     * 邮箱注册
     * @param email
     * @param password
     */
    public void registerByEmail(@Param("email") String email,@Param("password") String password);

    /**
     * 用户注册
     * @param user
     * @param password
     */
    public void registerByUser(@Param("user") String user,@Param("password") String password);


}
