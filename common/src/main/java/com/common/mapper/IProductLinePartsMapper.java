package com.common.mapper;

import com.common.pojo.ProductLineParts;
import com.common.vo.ProductLinePartsVO;

import java.util.List;


/**
*
* @ClassName IProductLinePartsMapper
* @Description TODO
* @author Jivoin
*/
public interface IProductLinePartsMapper {

    /**
    * @Title: addProductLineParts
    * @Description: 新增ProductLineParts
    * @param productLineParts
    * @throws Exception
    * @return: void
    */
    public void addProductLineParts(ProductLineParts productLineParts) throws Exception;

    /**
    * @Title: delProductLineParts
    * @Description: 删除ProductLineParts
    * @param productLineParts
    * @throws Exception
    * @return: void
    */
    public void delProductLineParts(ProductLineParts productLineParts) throws Exception;

    /**
    * @Title: delProductLinePartsForLogic
    * @Description: 逻辑删除ProductLineParts
    * @param productLineParts
    * @throws Exception
    * @return: void
    */
    public void delProductLinePartsForLogic(ProductLineParts productLineParts) throws Exception;

    /**
    * @Title: delProductLinePartsByVo
    * @Description: 根据条件删除ProductLineParts
    * @param productLinePartsVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delProductLinePartsByVo(ProductLinePartsVO productLinePartsVO) throws Exception;

    /**
    * @Title: updProductLineParts
    * @Description: 动态更新ProductLineParts
    * @param productLineParts
    * @throws Exception
    * @return: void
    */
    public void updProductLineParts(ProductLineParts productLineParts) throws Exception;

    /**
    * @Title: getProductLinePartsByPage
    * @Description: 分页查询
    * @param productLinePartsVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<ProductLineParts> getProductLinePartsByPage(ProductLinePartsVO productLinePartsVO) throws Exception;

    /**
    * @Title: getProductLinePartsCount
    * @Description: 获取记录数量
    * @param productLinePartsVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getProductLinePartsCount(ProductLinePartsVO productLinePartsVO) throws Exception;

    /**
    * @Title: getProductLineParts
    * @Description: 根据查询条件查询
    * @param productLinePartsVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ProductLineParts getProductLineParts(ProductLinePartsVO productLinePartsVO) throws Exception;

}
