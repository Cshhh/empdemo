package com.neuedu.mapper;

import com.neuedu.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    List<Emp> emplist();
    int deleteEmpByIds(int[] ids);

    /**
     * 添加Emp
     * @param emp
     * @return
     */
    int saveEmp(@Param("emp") Emp emp);

    /**
     * 查询一共有多少条数据
     * @return
     */
    int selectCount();
    int updateEmpById(@Param("emp")Emp emp);
    /**
     * 根据id查询单条数据
     */
    Emp selectEmpById(int id);
}
