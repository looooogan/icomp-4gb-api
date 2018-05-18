package com.common.mapper;

import com.common.pojo.ProductLine;
import com.common.vo.ProductLineVO;

import java.util.List;


/**
*
* @ClassName IProductLineMapper
* @Description TODO
* @author Jivoin
*/
public interface IProductLineMapper {

    /**
    * @Title: addProductLine
    * @Description: 新增ProductLine
    * @param productLine
    * @throws Exception
    * @return: void
    */
    public void addProductLine(ProductLine productLine) throws Exception;

    /**
    * @Title: delProductLine
    * @Description: 删除ProductLine
    * @param productLine
    * @throws Exception
    * @return: void
    */
    public void delProductLine(ProductLine productLine) throws Exception;

    /**
    * @Title: delProductLineForLogic
    * @Description: 逻辑删除ProductLine
    * @param productLine
    * @throws Exception
    * @return: void
    */
    public void delProductLineForLogic(ProductLine productLine) throws Exception;

    /**
    * @Title: delProductLineByVo
    * @Description: 根据条件删除ProductLine
    * @param productLineVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delProductLineByVo(ProductLineVO productLineVO) throws Exception;

    /**
    * @Title: updProductLine
    * @Description: 动态更新ProductLine
    * @param productLine
    * @throws Exception
    * @return: void
    */
    public void updProductLine(ProductLine productLine) throws Exception;

    /**
    * @Title: getProductLineByPage
    * @Description: 分页查询
    * @param productLineVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<ProductLine> getProductLineByPage(ProductLineVO productLineVO) throws Exception;

    /**
    * @Title: getProductLineCount
    * @Description: 获取记录数量
    * @param productLineVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getProductLineCount(ProductLineVO productLineVO) throws Exception;

    /**
    * @Title: getProductLine
    * @Description: 根据查询条件查询
    * @param productLineVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ProductLine getProductLine(ProductLineVO productLineVO) throws Exception;


    /**
     * @Title: getAssemblylineByEquipmentAndAxle
     * @Description: 根据设备和轴查询生产线
     * @param productLineVO 查询条件封装
     * @throws Exception
     * @return: 查询结果
     */
    public ProductLine getAssemblylineByEquipmentAndAxle(ProductLineVO productLineVO) throws Exception;
}
