package com.neuedu.service.impl;

import com.neuedu.entity.Emp;
import com.neuedu.mapper.EmpMapper;
import com.neuedu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Emp> emplist() {
        return empMapper.emplist();
    }

    @Override
    public int deleteEmpByIds(int[] ids) {
        return empMapper.deleteEmpByIds(ids);
    }

    @Override
    public int saveEmp(Emp emp) {
        return empMapper.saveEmp(emp);
    }

    @Override
    public int selectLastPageNum() {
        int aa=empMapper.selectCount();
        int page = aa%10==0? aa/10+1:aa/10;
        return page;
    }

    @Override
    public int updateEmpById(Emp emp) {
        return empMapper.updateEmpById(emp);
    }

    @Override
    public Emp selectEmpById(int id) {
        return empMapper.selectEmpById(id);
    }
}
