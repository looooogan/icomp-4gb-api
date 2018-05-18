package com.common.mapper;

import com.common.pojo.MaterialInventory;
import com.common.vo.MaterialInventoryVO;

import java.util.List;


/**
*
* @ClassName IMaterialInventoryMapper
* @Description TODO
* @author Jivoin
*/
public interface IMaterialInventoryMapper {

    /**
    * @Title: addMaterialInventory
    * @Description: 新增MaterialInventory
    * @param materialInventory
    * @throws Exception
    * @return: void
    */
    public void addMaterialInventory(MaterialInventory materialInventory) throws Exception;

    /**
    * @Title: delMaterialInventory
    * @Description: 删除MaterialInventory
    * @param materialInventory
    * @throws Exception
    * @return: void
    */
    public void delMaterialInventory(MaterialInventory materialInventory) throws Exception;

    /**
    * @Title: delMaterialInventoryForLogic
    * @Description: 逻辑删除MaterialInventory
    * @param materialInventory
    * @throws Exception
    * @return: void
    */
    public void delMaterialInventoryForLogic(MaterialInventory materialInventory) throws Exception;

    /**
    * @Title: delMaterialInventoryByVo
    * @Description: 根据条件删除MaterialInventory
    * @param materialInventoryVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delMaterialInventoryByVo(MaterialInventoryVO materialInventoryVO) throws Exception;

    /**
    * @Title: updMaterialInventory
    * @Description: 动态更新MaterialInventory
    * @param materialInventory
    * @throws Exception
    * @return: void
    */
    public void updMaterialInventory(MaterialInventory materialInventory) throws Exception;

    /**
    * @Title: getMaterialInventoryByPage
    * @Description: 分页查询
    * @param materialInventoryVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<MaterialInventory> getMaterialInventoryByPage(MaterialInventoryVO materialInventoryVO) throws Exception;

    /**
    * @Title: getMaterialInventoryCount
    * @Description: 获取记录数量
    * @param materialInventoryVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getMaterialInventoryCount(MaterialInventoryVO materialInventoryVO) throws Exception;

    /**
    * @Title: getMaterialInventory
    * @Description: 根据查询条件查询
    * @param materialInventoryVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public MaterialInventory getMaterialInventory(MaterialInventoryVO materialInventoryVO) throws Exception;

}
