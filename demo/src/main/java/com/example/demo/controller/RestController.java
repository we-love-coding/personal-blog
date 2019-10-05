package com.example.demo.controller;

import com.example.demo.bean.Loginuser;
import com.example.demo.mapper.RestMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author barnnet
 * @date 2019/10/1
 */
@Controller
@CrossOrigin
public class RestController {
    @Resource
    private RestMapper restMapper;
    @ResponseBody
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String ss(Integer type){
        List<Loginuser> list = restMapper.getList();
        return "ss";
    }
}
