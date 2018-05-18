package com.service.common.impl;


import com.common.mapper.IAuthDepartmentMapper;
import com.common.mapper.IAuthPositionMapper;
import com.common.pojo.AuthPosition;
import com.common.utils.UUID;
import com.common.vo.AuthPositionVO;
import com.service.common.IAuthPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName AuthPositionServiceImpl
* @Description AuthPosition业务实现类
* @author Jivoin
*/
@Service("authPositionService")
public class AuthPositionServiceImpl implements IAuthPositionService{

    @Autowired
    private IAuthPositionMapper authPositionMapper;

    @Autowired
    private IAuthDepartmentMapper authDepartmentMapper;


    /**
    * @Title: addAuthPosition
    * @Description: 新增AuthPosition
    * @param authPosition
    * @throws Exception
    * @return: void
    */
    @Override
    public void addAuthPosition(AuthPosition authPosition) throws Exception{
        authPosition.setCode(UUID.getInstance());
        authPosition.setIsDel(0);
        authPositionMapper.addAuthPosition(authPosition);
    }

    /**
    * @Title: delAuthPosition
    * @Description: 删除AuthPosition
    * @param authPosition
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthPosition(AuthPosition authPosition) throws Exception{
        authPositionMapper.delAuthPosition(authPosition);
    }

    /**
    * @Title: delAuthPositionForLogic
    * @Description: 逻辑删除AuthPosition
    * @param authPosition
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthPositionForLogic(AuthPosition authPosition) throws Exception{
        authPositionMapper.delAuthPositionForLogic(authPosition);
    }

    /**
    * @Title: delAuthPositionByVo
    * @Description: 根据条件删除AuthPosition
    * @param authPositionVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delAuthPositionByVo(AuthPositionVO authPositionVO) throws Exception{
        authPositionMapper.delAuthPositionByVo(authPositionVO);
    }

    /**
    * @Title: updAuthPosition
    * @Description: 动态更新AuthPosition
    * @param authPosition
    * @throws Exception
    * @return: void
    */
    @Override
    public void updAuthPosition(AuthPosition authPosition) throws Exception{
        authPositionMapper.updAuthPosition(authPosition);
    }

    /**
    * @Title: getAuthPositionByPage
    * @Description: 分页查询
    * @param authPositionVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<AuthPosition> getAuthPositionByPage(AuthPositionVO authPositionVO) throws Exception{
        authPositionVO.setTotalPage(authPositionMapper.getAuthPositionCount(authPositionVO));
        return authPositionMapper.getAuthPositionByPage(authPositionVO);
    }

    /**
    * @Title: getAuthPositionCount
    * @Description: 获取记录数量
    * @param authPositionVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getAuthPositionCount(AuthPositionVO authPositionVO) throws Exception{
        return authPositionMapper.getAuthPositionCount(authPositionVO);
    }

    /**
    * @Title: getAuthPosition
    * @Description: 根据查询条件查询
    * @param authPositionVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public AuthPosition getAuthPosition(AuthPositionVO authPositionVO) throws Exception{
        return authPositionMapper.getAuthPosition(authPositionVO);
    }

}
