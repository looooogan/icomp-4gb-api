package com.service.common.impl;


import com.common.mapper.IAuthAuthorizationMapper;
import com.common.mapper.IAuthCustomerMapper;
import com.common.pojo.AuthAuthorization;
import com.common.vo.AuthAuthorizationVO;
import com.service.common.IAuthAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName AuthAuthorizationServiceImpl
* @Description AuthAuthorization业务实现类
* @author Jivoin
*/
@Service("authAuthorizationService")
public class AuthAuthorizationServiceImpl implements IAuthAuthorizationService{

    @Autowired
    private IAuthAuthorizationMapper authAuthorizationMapper;

    @Autowired
    private IAuthCustomerMapper authCustomerMapper;


    /**
    * @Title: addAuthAuthorization
    * @Description: 新增AuthAuthorization
    * @param authAuthorization
    * @throws Exception
    * @return: void
    */
    @Override
    public void addAuthAuthorization(AuthAuthorization authAuthorization) throws Exception{
        authAuthorizationMapper.addAuthAuthorization(authAuthorization);
    }

    /**
    * @Title: delAuthAuthorization
    * @Description: 删除AuthAuthorization
    * @param authAuthorization
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthAuthorization(AuthAuthorization authAuthorization) throws Exception{
        authAuthorizationMapper.delAuthAuthorization(authAuthorization);
    }

    /**
    * @Title: delAuthAuthorizationForLogic
    * @Description: 逻辑删除AuthAuthorization
    * @param authAuthorization
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthAuthorizationForLogic(AuthAuthorization authAuthorization) throws Exception{
        authAuthorizationMapper.delAuthAuthorizationForLogic(authAuthorization);
    }

    /**
    * @Title: delAuthAuthorizationByVo
    * @Description: 根据条件删除AuthAuthorization
    * @param authAuthorizationVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthAuthorizationByVo(AuthAuthorizationVO authAuthorizationVO) throws Exception{
        authAuthorizationMapper.delAuthAuthorizationByVo(authAuthorizationVO);
    }

    /**
    * @Title: updAuthAuthorization
    * @Description: 动态更新AuthAuthorization
    * @param authAuthorization
    * @throws Exception
    * @return: void
    */
    @Override
    public void updAuthAuthorization(AuthAuthorization authAuthorization) throws Exception{
        authAuthorizationMapper.updAuthAuthorization(authAuthorization);
    }

    /**
    * @Title: getAuthAuthorizationByPage
    * @Description: 分页查询
    * @param authAuthorizationVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<AuthAuthorization> getAuthAuthorizationByPage(AuthAuthorizationVO authAuthorizationVO) throws Exception{
        authAuthorizationVO.setTotalPage(authAuthorizationMapper.getAuthAuthorizationCount(authAuthorizationVO));
        return authAuthorizationMapper.getAuthAuthorizationByPage(authAuthorizationVO);
    }

    /**
    * @Title: getAuthAuthorizationCount
    * @Description: 获取记录数量
    * @param authAuthorizationVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getAuthAuthorizationCount(AuthAuthorizationVO authAuthorizationVO) throws Exception{
        return authAuthorizationMapper.getAuthAuthorizationCount(authAuthorizationVO);
    }

    /**
    * @Title: getAuthAuthorization
    * @Description: 根据查询条件查询
    * @param authAuthorizationVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public AuthAuthorization getAuthAuthorization(AuthAuthorizationVO authAuthorizationVO) throws Exception{
        return authAuthorizationMapper.getAuthAuthorization(authAuthorizationVO);
    }

}
