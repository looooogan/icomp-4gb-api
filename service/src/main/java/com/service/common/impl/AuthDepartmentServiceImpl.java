package com.service.common.impl;


import com.common.mapper.IAuthDepartmentMapper;
import com.common.pojo.AuthDepartment;
import com.common.utils.UUID;
import com.common.vo.AuthDepartmentVO;
import com.service.common.IAuthDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName AuthDepartmentServiceImpl
* @Description AuthDepartment业务实现类
* @author Jivoin
*/
@Service("authDepartmentService")
public class AuthDepartmentServiceImpl implements IAuthDepartmentService{

    @Autowired
    private IAuthDepartmentMapper authDepartmentMapper;



    /**
    * @Title: addAuthDepartment
    * @Description: 新增AuthDepartment
    * @param authDepartment
    * @throws Exception
    * @return: void
    */
    @Override
    public void addAuthDepartment(AuthDepartment authDepartment) throws Exception{
        authDepartment.setCode(UUID.getInstance());
        authDepartment.setIsDel(0);
        authDepartmentMapper.addAuthDepartment(authDepartment);
    }

    /**
    * @Title: delAuthDepartment
    * @Description: 删除AuthDepartment
    * @param authDepartment
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthDepartment(AuthDepartment authDepartment) throws Exception{
        authDepartmentMapper.delAuthDepartment(authDepartment);
    }

    /**
    * @Title: delAuthDepartmentForLogic
    * @Description: 逻辑删除AuthDepartment
    * @param authDepartment
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthDepartmentForLogic(AuthDepartment authDepartment) throws Exception{
        authDepartmentMapper.delAuthDepartmentForLogic(authDepartment);
    }

    /**
    * @Title: delAuthDepartmentByVo
    * @Description: 根据条件删除AuthDepartment
    * @param authDepartmentVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthDepartmentByVo(AuthDepartmentVO authDepartmentVO) throws Exception{
        authDepartmentMapper.delAuthDepartmentByVo(authDepartmentVO);
    }

    /**
    * @Title: updAuthDepartment
    * @Description: 动态更新AuthDepartment
    * @param authDepartment
    * @throws Exception
    * @return: void
    */
    @Override
    public void updAuthDepartment(AuthDepartment authDepartment) throws Exception{
        authDepartmentMapper.updAuthDepartment(authDepartment);
    }

    /**
    * @Title: getAuthDepartmentByPage
    * @Description: 分页查询
    * @param authDepartmentVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<AuthDepartment> getAuthDepartmentByPage(AuthDepartmentVO authDepartmentVO) throws Exception{
        authDepartmentVO.setTotalPage(authDepartmentMapper.getAuthDepartmentCount(authDepartmentVO));
        return authDepartmentMapper.getAuthDepartmentByPage(authDepartmentVO);
    }

    /**
    * @Title: getAuthDepartmentCount
    * @Description: 获取记录数量
    * @param authDepartmentVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getAuthDepartmentCount(AuthDepartmentVO authDepartmentVO) throws Exception{
        return authDepartmentMapper.getAuthDepartmentCount(authDepartmentVO);
    }

    /**
    * @Title: getAuthDepartment
    * @Description: 根据查询条件查询
    * @param authDepartmentVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public AuthDepartment getAuthDepartment(AuthDepartmentVO authDepartmentVO) throws Exception{
        return authDepartmentMapper.getAuthDepartment(authDepartmentVO);
    }

}
