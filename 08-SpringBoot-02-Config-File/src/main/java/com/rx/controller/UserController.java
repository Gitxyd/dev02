package com.rx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("hello")
    public String hello(){
        return "猪jio、鸡公煲、凉皮、粉面菜蛋";
    }
}
