package com.common.mapper;

import com.common.pojo.AuthPosition;
import com.common.vo.AuthPositionVO;

import java.util.List;


/**
*
* @ClassName IAuthPositionMapper
* @Description TODO
* @author Jivoin
*/
public interface IAuthPositionMapper {

    /**
    * @Title: addAuthPosition
    * @Description: 新增AuthPosition
    * @param authPosition
    * @throws Exception
    * @return: void
    */
    public void addAuthPosition(AuthPosition authPosition) throws Exception;

    /**
    * @Title: delAuthPosition
    * @Description: 删除AuthPosition
    * @param authPosition
    * @throws Exception
    * @return: void
    */
    public void delAuthPosition(AuthPosition authPosition) throws Exception;

    /**
    * @Title: delAuthPositionForLogic
    * @Description: 逻辑删除AuthPosition
    * @param authPosition
    * @throws Exception
    * @return: void
    */
    public void delAuthPositionForLogic(AuthPosition authPosition) throws Exception;

    /**
    * @Title: delAuthPositionByVo
    * @Description: 根据条件删除AuthPosition
    * @param authPositionVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delAuthPositionByVo(AuthPositionVO authPositionVO) throws Exception;

    /**
    * @Title: updAuthPosition
    * @Description: 动态更新AuthPosition
    * @param authPosition
    * @throws Exception
    * @return: void
    */
    public void updAuthPosition(AuthPosition authPosition) throws Exception;

    /**
    * @Title: getAuthPositionByPage
    * @Description: 分页查询
    * @param authPositionVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<AuthPosition> getAuthPositionByPage(AuthPositionVO authPositionVO) throws Exception;

    /**
    * @Title: getAuthPositionCount
    * @Description: 获取记录数量
    * @param authPositionVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getAuthPositionCount(AuthPositionVO authPositionVO) throws Exception;

    /**
    * @Title: getAuthPosition
    * @Description: 根据查询条件查询
    * @param authPositionVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public AuthPosition getAuthPosition(AuthPositionVO authPositionVO) throws Exception;

}
