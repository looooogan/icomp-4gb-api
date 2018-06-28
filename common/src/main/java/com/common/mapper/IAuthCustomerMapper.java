package com.common.mapper;

import com.common.pojo.AuthCustomer;
import com.common.pojo.ProductLineAssemblyline;
import com.common.vo.AuthCustomerVO;

import java.util.List;


/**
*
* @ClassName IAuthCustomerMapper
* @Description TODO
* @author Jivoin
*/
public interface IAuthCustomerMapper {

    /**
    * @Title: addAuthCustomer
    * @Description: 新增AuthCustomer
    * @param authCustomer
    * @throws Exception
    * @return: void
    */
    public void addAuthCustomer(AuthCustomer authCustomer) throws Exception;

    /**
    * @Title: delAuthCustomer
    * @Description: 删除AuthCustomer
    * @param authCustomer
    * @throws Exception
    * @return: void
    */
    public void delAuthCustomer(AuthCustomer authCustomer) throws Exception;

    /**
    * @Title: delAuthCustomerForLogic
    * @Description: 逻辑删除AuthCustomer
    * @param authCustomer
    * @throws Exception
    * @return: void
    */
    public void delAuthCustomerForLogic(AuthCustomer authCustomer) throws Exception;

    /**
    * @Title: delAuthCustomerByVo
    * @Description: 根据条件删除AuthCustomer
    * @param authCustomerVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delAuthCustomerByVo(AuthCustomerVO authCustomerVO) throws Exception;

    /**
    * @Title: updAuthCustomer
    * @Description: 动态更新AuthCustomer
    * @param authCustomer
    * @throws Exception
    * @return: void
    */
    public void updAuthCustomer(AuthCustomer authCustomer) throws Exception;

    /**
    * @Title: getAuthCustomerByPage
    * @Description: 分页查询
    * @param authCustomerVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<AuthCustomer> getAuthCustomerByPage(AuthCustomerVO authCustomerVO) throws Exception;

    /**
    * @Title: getAuthCustomerCount
    * @Description: 获取记录数量
    * @param authCustomerVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getAuthCustomerCount(AuthCustomerVO authCustomerVO) throws Exception;

    /**
    * @Title: getAuthCustomer
    * @Description: 根据查询条件查询
    * @param authCustomerVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public AuthCustomer getAuthCustomer(AuthCustomerVO authCustomerVO) throws Exception;

    /**
     * @Title: clearRFIDData
     * @Description: 清空标签
     * @param authCustomer 清空数据
     * @throws Exception
     * @return: 查询结果
     */
    public void clearRFIDData(AuthCustomer authCustomer) throws Exception;

}
