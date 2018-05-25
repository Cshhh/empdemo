package com.neuedu.service;

import com.neuedu.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpService {
    List<Emp> emplist();
    int deleteEmpByIds(int[] ids);
    int saveEmp(Emp emp);
    int selectLastPageNum();
    int updateEmpById(Emp emp);
    Emp selectEmpById(int id);
}
