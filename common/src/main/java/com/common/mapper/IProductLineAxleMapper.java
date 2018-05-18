package com.common.mapper;

import com.common.pojo.ProductLineAxle;
import com.common.vo.ProductLineAxleVO;

import java.util.List;


/**
*
* @ClassName IProductLineAxleMapper
* @Description TODO
* @author Jivoin
*/
public interface IProductLineAxleMapper {

    /**
    * @Title: addProductLineAxle
    * @Description: 新增ProductLineAxle
    * @param productLineAxle
    * @throws Exception
    * @return: void
    */
    public void addProductLineAxle(ProductLineAxle productLineAxle) throws Exception;

    /**
    * @Title: delProductLineAxle
    * @Description: 删除ProductLineAxle
    * @param productLineAxle
    * @throws Exception
    * @return: void
    */
    public void delProductLineAxle(ProductLineAxle productLineAxle) throws Exception;

    /**
    * @Title: delProductLineAxleForLogic
    * @Description: 逻辑删除ProductLineAxle
    * @param productLineAxle
    * @throws Exception
    * @return: void
    */
    public void delProductLineAxleForLogic(ProductLineAxle productLineAxle) throws Exception;

    /**
    * @Title: delProductLineAxleByVo
    * @Description: 根据条件删除ProductLineAxle
    * @param productLineAxleVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delProductLineAxleByVo(ProductLineAxleVO productLineAxleVO) throws Exception;

    /**
    * @Title: updProductLineAxle
    * @Description: 动态更新ProductLineAxle
    * @param productLineAxle
    * @throws Exception
    * @return: void
    */
    public void updProductLineAxle(ProductLineAxle productLineAxle) throws Exception;

    /**
    * @Title: getProductLineAxleByPage
    * @Description: 分页查询
    * @param productLineAxleVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<ProductLineAxle> getProductLineAxleByPage(ProductLineAxleVO productLineAxleVO) throws Exception;

    /**
    * @Title: getProductLineAxleCount
    * @Description: 获取记录数量
    * @param productLineAxleVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getProductLineAxleCount(ProductLineAxleVO productLineAxleVO) throws Exception;

    /**
    * @Title: getProductLineAxle
    * @Description: 根据查询条件查询
    * @param productLineAxleVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ProductLineAxle getProductLineAxle(ProductLineAxleVO productLineAxleVO) throws Exception;

}
