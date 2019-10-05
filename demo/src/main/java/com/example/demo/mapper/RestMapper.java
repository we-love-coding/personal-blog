package com.example.demo.mapper;

import com.example.demo.bean.Loginuser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author barnnet
 * @date 2019/10/1
 */
@Mapper
public interface RestMapper {

    public List<Loginuser> getList();
}
