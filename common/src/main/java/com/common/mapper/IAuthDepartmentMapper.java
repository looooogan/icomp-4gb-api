package com.common.mapper;

import com.common.pojo.AuthDepartment;
import com.common.vo.AuthDepartmentVO;

import java.util.List;


/**
*
* @ClassName IAuthDepartmentMapper
* @Description TODO
* @author Jivoin
*/
public interface IAuthDepartmentMapper {

    /**
    * @Title: addAuthDepartment
    * @Description: 新增AuthDepartment
    * @param authDepartment
    * @throws Exception
    * @return: void
    */
    public void addAuthDepartment(AuthDepartment authDepartment) throws Exception;

    /**
    * @Title: delAuthDepartment
    * @Description: 删除AuthDepartment
    * @param authDepartment
    * @throws Exception
    * @return: void
    */
    public void delAuthDepartment(AuthDepartment authDepartment) throws Exception;

    /**
    * @Title: delAuthDepartmentForLogic
    * @Description: 逻辑删除AuthDepartment
    * @param authDepartment
    * @throws Exception
    * @return: void
    */
    public void delAuthDepartmentForLogic(AuthDepartment authDepartment) throws Exception;

    /**
    * @Title: delAuthDepartmentByVo
    * @Description: 根据条件删除AuthDepartment
    * @param authDepartmentVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delAuthDepartmentByVo(AuthDepartmentVO authDepartmentVO) throws Exception;

    /**
    * @Title: updAuthDepartment
    * @Description: 动态更新AuthDepartment
    * @param authDepartment
    * @throws Exception
    * @return: void
    */
    public void updAuthDepartment(AuthDepartment authDepartment) throws Exception;

    /**
    * @Title: getAuthDepartmentByPage
    * @Description: 分页查询
    * @param authDepartmentVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<AuthDepartment> getAuthDepartmentByPage(AuthDepartmentVO authDepartmentVO) throws Exception;

    /**
    * @Title: getAuthDepartmentCount
    * @Description: 获取记录数量
    * @param authDepartmentVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getAuthDepartmentCount(AuthDepartmentVO authDepartmentVO) throws Exception;

    /**
    * @Title: getAuthDepartment
    * @Description: 根据查询条件查询
    * @param authDepartmentVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public AuthDepartment getAuthDepartment(AuthDepartmentVO authDepartmentVO) throws Exception;

}
