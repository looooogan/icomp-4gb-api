package com.common.mapper;

import com.common.pojo.ProductLineAssemblyline;
import com.common.pojo.ProductLineEquipment;
import com.common.vo.ProductLineEquipmentVO;

import java.util.List;


/**
*
* @ClassName IProductLineEquipmentMapper
* @Description TODO
* @author Jivoin
*/
public interface IProductLineEquipmentMapper {

    /**
    * @Title: addProductLineEquipment
    * @Description: 新增ProductLineEquipment
    * @param productLineEquipment
    * @throws Exception
    * @return: void
    */
    public void addProductLineEquipment(ProductLineEquipment productLineEquipment) throws Exception;

    /**
    * @Title: delProductLineEquipment
    * @Description: 删除ProductLineEquipment
    * @param productLineEquipment
    * @throws Exception
    * @return: void
    */
    public void delProductLineEquipment(ProductLineEquipment productLineEquipment) throws Exception;

    /**
    * @Title: delProductLineEquipmentForLogic
    * @Description: 逻辑删除ProductLineEquipment
    * @param productLineEquipment
    * @throws Exception
    * @return: void
    */
    public void delProductLineEquipmentForLogic(ProductLineEquipment productLineEquipment) throws Exception;

    /**
    * @Title: delProductLineEquipmentByVo
    * @Description: 根据条件删除ProductLineEquipment
    * @param productLineEquipmentVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delProductLineEquipmentByVo(ProductLineEquipmentVO productLineEquipmentVO) throws Exception;

    /**
    * @Title: updProductLineEquipment
    * @Description: 动态更新ProductLineEquipment
    * @param productLineEquipment
    * @throws Exception
    * @return: void
    */
    public void updProductLineEquipment(ProductLineEquipment productLineEquipment) throws Exception;

    /**
    * @Title: getProductLineEquipmentByPage
    * @Description: 分页查询
    * @param productLineEquipmentVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<ProductLineEquipment> getProductLineEquipmentByPage(ProductLineEquipmentVO productLineEquipmentVO) throws Exception;

    /**
    * @Title: getProductLineEquipmentCount
    * @Description: 获取记录数量
    * @param productLineEquipmentVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getProductLineEquipmentCount(ProductLineEquipmentVO productLineEquipmentVO) throws Exception;

    /**
    * @Title: getProductLineEquipment
    * @Description: 根据查询条件查询
    * @param productLineEquipmentVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ProductLineEquipment getProductLineEquipment(ProductLineEquipmentVO productLineEquipmentVO) throws Exception;


    /**
     * @Title: clearRFIDData
     * @Description: 清空标签
     * @param productLineEquipment 清空数据
     * @throws Exception
     * @return: 查询结果
     */
    public void clearRFIDData(ProductLineEquipment productLineEquipment) throws Exception;

}
