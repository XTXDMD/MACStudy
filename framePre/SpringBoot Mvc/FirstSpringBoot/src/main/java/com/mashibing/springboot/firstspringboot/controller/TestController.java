package com.mashibing.springboot.firstspringboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhy
 * @since 2021/5/17 17:55
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/list")
    public String list(){
        return "list";
    }

}
