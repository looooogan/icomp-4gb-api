package com.service.common;

import com.common.pojo.ProductLine;
import com.common.vo.ProductLineVO;
import com.service.productline.vo.ProductLineAddVO;

import java.util.List;


/**
*
* @ClassName IProductLineService
* @Description ProductLine业务接口
* @author Jivoin
*/
public interface IProductLineService {

    /**
    * @Title: addProductLine
    * @Description: 新增ProductLine
    * @param productLine
    * @throws Exception
    * @return: void
    */
    public void addProductLine(ProductLine productLine) throws Exception;

    /**
     * @Title: addProductLine
     * @Description: 新增ProductLine
     * @param productLineAddVO
     * @throws Exception
     * @return: void
     */
    public void addForWeb(ProductLineAddVO productLineAddVO) throws Exception;

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
     * 卸下获取流水线嘻嘻你
     * @throws Exception
     */
    public ProductLine getAssemblylineByEquipmentAndAxle(ProductLineVO productLineVO) throws Exception;

}
