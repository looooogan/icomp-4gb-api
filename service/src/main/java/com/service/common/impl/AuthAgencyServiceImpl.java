package com.service.common.impl;


import com.common.mapper.IAuthAgencyMapper;
import com.common.pojo.AuthAgency;
import com.common.utils.UUID;
import com.common.vo.AuthAgencyVO;
import com.service.common.IAuthAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName AuthAgencyServiceImpl
* @Description AuthAgency业务实现类
* @author Jivoin
*/
@Service("authAgencyService")
public class AuthAgencyServiceImpl implements IAuthAgencyService{

    @Autowired
    private IAuthAgencyMapper authAgencyMapper;



    /**
    * @Title: addAuthAgency
    * @Description: 新增AuthAgency
    * @param authAgency
    * @throws Exception
    * @return: void
    */
    @Override
    public void addAuthAgency(AuthAgency authAgency) throws Exception{
        authAgency.setIsDel(0);
        authAgency.setCode(UUID.getInstance());
        authAgencyMapper.addAuthAgency(authAgency);
    }

    /**
    * @Title: delAuthAgency
    * @Description: 删除AuthAgency
    * @param authAgency
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthAgency(AuthAgency authAgency) throws Exception{
        authAgencyMapper.delAuthAgency(authAgency);
    }

    /**
    * @Title: delAuthAgencyForLogic
    * @Description: 逻辑删除AuthAgency
    * @param authAgency
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthAgencyForLogic(AuthAgency authAgency) throws Exception{
        authAgencyMapper.delAuthAgencyForLogic(authAgency);
    }

    /**
    * @Title: delAuthAgencyByVo
    * @Description: 根据条件删除AuthAgency
    * @param authAgencyVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthAgencyByVo(AuthAgencyVO authAgencyVO) throws Exception{
        authAgencyMapper.delAuthAgencyByVo(authAgencyVO);
    }

    /**
    * @Title: updAuthAgency
    * @Description: 动态更新AuthAgency
    * @param authAgency
    * @throws Exception
    * @return: void
    */
    @Override
    public void updAuthAgency(AuthAgency authAgency) throws Exception{
        authAgencyMapper.updAuthAgency(authAgency);
    }

    /**
    * @Title: getAuthAgencyByPage
    * @Description: 分页查询
    * @param authAgencyVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<AuthAgency> getAuthAgencyByPage(AuthAgencyVO authAgencyVO) throws Exception{
        authAgencyVO.setTotalPage(authAgencyMapper.getAuthAgencyCount(authAgencyVO));
        return authAgencyMapper.getAuthAgencyByPage(authAgencyVO);
    }

    /**
    * @Title: getAuthAgencyCount
    * @Description: 获取记录数量
    * @param authAgencyVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getAuthAgencyCount(AuthAgencyVO authAgencyVO) throws Exception{
        return authAgencyMapper.getAuthAgencyCount(authAgencyVO);
    }

    /**
    * @Title: getAuthAgency
    * @Description: 根据查询条件查询
    * @param authAgencyVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public AuthAgency getAuthAgency(AuthAgencyVO authAgencyVO) throws Exception{
        return authAgencyMapper.getAuthAgency(authAgencyVO);
    }

}
