package com.common.mapper;

import com.common.pojo.AuthAuthorization;
import com.common.vo.AuthAuthorizationVO;

import java.util.List;


/**
*
* @ClassName IAuthAuthorizationMapper
* @Description TODO
* @author Jivoin
*/
public interface IAuthAuthorizationMapper {

    /**
    * @Title: addAuthAuthorization
    * @Description: 新增AuthAuthorization
    * @param authAuthorization
    * @throws Exception
    * @return: void
    */
    public void addAuthAuthorization(AuthAuthorization authAuthorization) throws Exception;

    /**
    * @Title: delAuthAuthorization
    * @Description: 删除AuthAuthorization
    * @param authAuthorization
    * @throws Exception
    * @return: void
    */
    public void delAuthAuthorization(AuthAuthorization authAuthorization) throws Exception;

    /**
    * @Title: delAuthAuthorizationForLogic
    * @Description: 逻辑删除AuthAuthorization
    * @param authAuthorization
    * @throws Exception
    * @return: void
    */
    public void delAuthAuthorizationForLogic(AuthAuthorization authAuthorization) throws Exception;

    /**
    * @Title: delAuthAuthorizationByVo
    * @Description: 根据条件删除AuthAuthorization
    * @param authAuthorizationVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delAuthAuthorizationByVo(AuthAuthorizationVO authAuthorizationVO) throws Exception;

    /**
    * @Title: updAuthAuthorization
    * @Description: 动态更新AuthAuthorization
    * @param authAuthorization
    * @throws Exception
    * @return: void
    */
    public void updAuthAuthorization(AuthAuthorization authAuthorization) throws Exception;

    /**
    * @Title: getAuthAuthorizationByPage
    * @Description: 分页查询
    * @param authAuthorizationVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<AuthAuthorization> getAuthAuthorizationByPage(AuthAuthorizationVO authAuthorizationVO) throws Exception;

    /**
    * @Title: getAuthAuthorizationCount
    * @Description: 获取记录数量
    * @param authAuthorizationVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getAuthAuthorizationCount(AuthAuthorizationVO authAuthorizationVO) throws Exception;

    /**
    * @Title: getAuthAuthorization
    * @Description: 根据查询条件查询
    * @param authAuthorizationVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public AuthAuthorization getAuthAuthorization(AuthAuthorizationVO authAuthorizationVO) throws Exception;

}
