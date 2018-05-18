package com.common.mapper;

import com.common.pojo.ProductLineProcess;
import com.common.vo.ProductLineProcessVO;

import java.util.List;


/**
*
* @ClassName IProductLineProcessMapper
* @Description TODO
* @author Jivoin
*/
public interface IProductLineProcessMapper {

    /**
    * @Title: addProductLineProcess
    * @Description: 新增ProductLineProcess
    * @param productLineProcess
    * @throws Exception
    * @return: void
    */
    public void addProductLineProcess(ProductLineProcess productLineProcess) throws Exception;

    /**
    * @Title: delProductLineProcess
    * @Description: 删除ProductLineProcess
    * @param productLineProcess
    * @throws Exception
    * @return: void
    */
    public void delProductLineProcess(ProductLineProcess productLineProcess) throws Exception;

    /**
    * @Title: delProductLineProcessForLogic
    * @Description: 逻辑删除ProductLineProcess
    * @param productLineProcess
    * @throws Exception
    * @return: void
    */
    public void delProductLineProcessForLogic(ProductLineProcess productLineProcess) throws Exception;

    /**
    * @Title: delProductLineProcessByVo
    * @Description: 根据条件删除ProductLineProcess
    * @param productLineProcessVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delProductLineProcessByVo(ProductLineProcessVO productLineProcessVO) throws Exception;

    /**
    * @Title: updProductLineProcess
    * @Description: 动态更新ProductLineProcess
    * @param productLineProcess
    * @throws Exception
    * @return: void
    */
    public void updProductLineProcess(ProductLineProcess productLineProcess) throws Exception;

    /**
    * @Title: getProductLineProcessByPage
    * @Description: 分页查询
    * @param productLineProcessVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<ProductLineProcess> getProductLineProcessByPage(ProductLineProcessVO productLineProcessVO) throws Exception;

    /**
    * @Title: getProductLineProcessCount
    * @Description: 获取记录数量
    * @param productLineProcessVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getProductLineProcessCount(ProductLineProcessVO productLineProcessVO) throws Exception;

    /**
    * @Title: getProductLineProcess
    * @Description: 根据查询条件查询
    * @param productLineProcessVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ProductLineProcess getProductLineProcess(ProductLineProcessVO productLineProcessVO) throws Exception;

}
