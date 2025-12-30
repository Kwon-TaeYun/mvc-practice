package com.demo.devfun.controller;

import com.demo.devfun.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    HomeService homeservice;

    @RequestMapping(value="/requests", produces = "application/json")
    @ResponseBody
    public Map<String, Object> getRequestInfo(){

        return homeservice.getRequestInfo();
    }
}
