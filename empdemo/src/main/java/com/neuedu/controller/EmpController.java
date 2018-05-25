package com.neuedu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.entity.Dept;
import com.neuedu.entity.Emp;
import com.neuedu.service.DeptService;
import com.neuedu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;
    @RequestMapping("/emplist")
    public ModelAndView emplist(ModelMap map, @RequestParam(name = "pageNum",defaultValue = "1")int pageNum, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("emplist");
        //使用分页插件在查询前调用分页方法
        PageHelper.startPage(pageNum,10);
        List<Emp> empList = empService.emplist();
        PageInfo<Emp> pageInfo = new PageInfo<>(empList,10);
        map.put("pageInfo",pageInfo);
        httpSession.setAttribute("nowPageNum",pageInfo.getPageNum());
//        System.out.println(pageInfo);
        return modelAndView;
    }
/*    public String emplist(ModelMap map){
        map.put("emplist",empService.emplist());
        return "emplist";
    }*/
    /* public String emplist(ModelMap map,@RequestParam(name = "pageNum",defaultValue = "1")int pageNum){
         PageHelper.startPage(pageNum,10);
         List<Emp> empList=empService.emplist();
        map.put("emplist",empList);
        return "emplist";
    }*/
    @RequestMapping("/deleteEmpById")
    public ModelAndView deleteEmpById(int[] id,HttpSession httpSession){
        Integer pageNum = (Integer) httpSession.getAttribute("nowPageNum");
        ModelAndView modelAndView = new ModelAndView("redirect:/emp/emplist?pageNum="+pageNum);
        empService.deleteEmpByIds(id);
        return modelAndView;
    }
    @RequestMapping(value = {"/addEmpView"})
    public ModelAndView addEmpView(ModelMap param){
        ModelAndView modelAndView = new ModelAndView("addEmpView");
        param.put("deptlist",deptService.deptlist());
        return modelAndView;
    }
    @RequestMapping(value = {"/addEmp"})
    public ModelAndView addEmp(Emp emp){
//        int pageNum = empService.saveEmp(emp);
        int Num = empService.selectLastPageNum();
        empService.saveEmp(emp);
        ModelAndView modelAndView = new ModelAndView("redirect:/emp/emplist?pageNum="+Num);
        return modelAndView;
    }
    @RequestMapping(value = {"/updateEmpView"})
    public String updateEmpById(ModelMap map,int id){
        Emp emp = empService.selectEmpById(id);
        map.put("deptlist",deptService.deptlist());
        map.put("emp",emp);
        System.out.println(deptService.deptlist());
        System.out.println(emp);
        return "updateEmp";
    }
    @RequestMapping("/updateEmp")
    public String updateEmp(Emp emp,HttpSession httpSession){
        Integer pageNum = (Integer) httpSession.getAttribute("nowPageNum");
        empService.updateEmpById(emp);
        return "redirect:/emp/emplist?pageNum="+pageNum;
    }
}
