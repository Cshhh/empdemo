package com.neuedu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.entity.Dept;
import com.neuedu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = {"/dept"})
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping("/deptlist")
    public ModelAndView deptlist(ModelMap param, @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("deptlist");
        //开启插件，设置每页10条数据
        PageHelper.startPage(pageNum,10);
        //查询列表页
        List<Dept> deptList = deptService.deptlist();
        PageInfo<Dept> pageInfo = new PageInfo<>(deptList,5);
        System.out.println(pageInfo);
        param.put("pageInfo",pageInfo);
        httpSession.setAttribute("deptPageNum",pageInfo.getPageNum());
        return modelAndView;
    }
}
