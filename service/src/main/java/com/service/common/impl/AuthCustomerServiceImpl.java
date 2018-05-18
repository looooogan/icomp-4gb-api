package com.service.common.impl;


import com.common.mapper.*;
import com.common.pojo.AuthCustomer;
import com.common.utils.MD5;
import com.common.utils.UUID;
import com.common.vo.AuthCustomerVO;
import com.service.common.IAuthCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName AuthCustomerServiceImpl
* @Description AuthCustomer业务实现类
* @author Jivoin
*/
@Service("authCustomerService")
public class AuthCustomerServiceImpl implements IAuthCustomerService{

    @Autowired
    private IAuthCustomerMapper authCustomerMapper;

    @Autowired
    private IAuthPositionMapper authPositionMapper;
    @Autowired
    private IRfidContainerMapper rfidContainerMapper;
    @Autowired
    private IAuthDepartmentMapper authDepartmentMapper;
    @Autowired
    private IAuthAgencyMapper authAgencyMapper;


    /**
    * @Title: addAuthCustomer
    * @Description: 新增AuthCustomer
    * @param authCustomer
    * @throws Exception
    * @return: void
    */
    @Override
    public void addAuthCustomer(AuthCustomer authCustomer) throws Exception{
        authCustomer.setIsDel(0);
        authCustomer.setCode(UUID.getInstance());
        authCustomer.setPassword(MD5.getMD5(authCustomer.getPassword()));
        authCustomerMapper.addAuthCustomer(authCustomer);
    }

    /**
    * @Title: delAuthCustomer
    * @Description: 删除AuthCustomer
    * @param authCustomer
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthCustomer(AuthCustomer authCustomer) throws Exception{
        authCustomerMapper.delAuthCustomer(authCustomer);
    }

    /**
    * @Title: delAuthCustomerForLogic
    * @Description: 逻辑删除AuthCustomer
    * @param authCustomer
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthCustomerForLogic(AuthCustomer authCustomer) throws Exception{
        authCustomerMapper.delAuthCustomerForLogic(authCustomer);
    }

    /**
    * @Title: delAuthCustomerByVo
    * @Description: 根据条件删除AuthCustomer
    * @param authCustomerVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthCustomerByVo(AuthCustomerVO authCustomerVO) throws Exception{
        authCustomerMapper.delAuthCustomerByVo(authCustomerVO);
    }

    /**
    * @Title: updAuthCustomer
    * @Description: 动态更新AuthCustomer
    * @param authCustomer
    * @throws Exception
    * @return: void
    */
    @Override
    public void updAuthCustomer(AuthCustomer authCustomer) throws Exception{
        authCustomerMapper.updAuthCustomer(authCustomer);
    }

    /**
    * @Title: getAuthCustomerByPage
    * @Description: 分页查询
    * @param authCustomerVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<AuthCustomer> getAuthCustomerByPage(AuthCustomerVO authCustomerVO) throws Exception{
        authCustomerVO.setTotalPage(authCustomerMapper.getAuthCustomerCount(authCustomerVO));
        return authCustomerMapper.getAuthCustomerByPage(authCustomerVO);
    }

    /**
    * @Title: getAuthCustomerCount
    * @Description: 获取记录数量
    * @param authCustomerVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getAuthCustomerCount(AuthCustomerVO authCustomerVO) throws Exception{
        return authCustomerMapper.getAuthCustomerCount(authCustomerVO);
    }

    /**
    * @Title: getAuthCustomer
    * @Description: 根据查询条件查询
    * @param authCustomerVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public AuthCustomer getAuthCustomer(AuthCustomerVO authCustomerVO) throws Exception{
        return authCustomerMapper.getAuthCustomer(authCustomerVO);
    }

}
