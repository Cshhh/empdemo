package com.neuedu.controller;

import com.neuedu.entity.Test;
import com.neuedu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @RequestMapping(value = {"/hello"})
    public String hello(){
        System.out.println("hello");
        return "";
    }
    @Autowired
    private TestService testService;
    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("test",testService.score());
        return modelAndView;
    }
   /* public String test(ModelMap map){
        List<Test> list = testService.score();
        map.put("test",list);
        return "test";
    }*/

}
