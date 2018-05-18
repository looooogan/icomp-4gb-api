package com.common.mapper;

import com.common.pojo.AuthAgency;
import com.common.vo.AuthAgencyVO;

import java.util.List;


/**
*
* @ClassName IAuthAgencyMapper
* @Description TODO
* @author Jivoin
*/
public interface IAuthAgencyMapper {

    /**
    * @Title: addAuthAgency
    * @Description: 新增AuthAgency
    * @param authAgency
    * @throws Exception
    * @return: void
    */
    public void addAuthAgency(AuthAgency authAgency) throws Exception;

    /**
    * @Title: delAuthAgency
    * @Description: 删除AuthAgency
    * @param authAgency
    * @throws Exception
    * @return: void
    */
    public void delAuthAgency(AuthAgency authAgency) throws Exception;

    /**
    * @Title: delAuthAgencyForLogic
    * @Description: 逻辑删除AuthAgency
    * @param authAgency
    * @throws Exception
    * @return: void
    */
    public void delAuthAgencyForLogic(AuthAgency authAgency) throws Exception;

    /**
    * @Title: delAuthAgencyByVo
    * @Description: 根据条件删除AuthAgency
    * @param authAgencyVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delAuthAgencyByVo(AuthAgencyVO authAgencyVO) throws Exception;

    /**
    * @Title: updAuthAgency
    * @Description: 动态更新AuthAgency
    * @param authAgency
    * @throws Exception
    * @return: void
    */
    public void updAuthAgency(AuthAgency authAgency) throws Exception;

    /**
    * @Title: getAuthAgencyByPage
    * @Description: 分页查询
    * @param authAgencyVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<AuthAgency> getAuthAgencyByPage(AuthAgencyVO authAgencyVO) throws Exception;

    /**
    * @Title: getAuthAgencyCount
    * @Description: 获取记录数量
    * @param authAgencyVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getAuthAgencyCount(AuthAgencyVO authAgencyVO) throws Exception;

    /**
    * @Title: getAuthAgency
    * @Description: 根据查询条件查询
    * @param authAgencyVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public AuthAgency getAuthAgency(AuthAgencyVO authAgencyVO) throws Exception;

}
