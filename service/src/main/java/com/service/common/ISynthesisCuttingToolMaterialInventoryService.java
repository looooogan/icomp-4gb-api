package com.service.common;

import com.common.pojo.SynthesisCuttingToolMaterialInventory;
import com.common.vo.SynthesisCuttingToolMaterialInventoryVO;

import java.util.List;


/**
*
* @ClassName ISynthesisCuttingToolMaterialInventoryService
* @Description SynthesisCuttingToolMaterialInventory业务接口
* @author Jivoin
*/
public interface ISynthesisCuttingToolMaterialInventoryService {

    /**
    * @Title: addSynthesisCuttingToolMaterialInventory
    * @Description: 新增SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventory
    * @throws Exception
    * @return: void
    */
    public void addSynthesisCuttingToolMaterialInventory(SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolMaterialInventory
    * @Description: 删除SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventory
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolMaterialInventory(SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolMaterialInventoryForLogic
    * @Description: 逻辑删除SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventory
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolMaterialInventoryForLogic(SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolMaterialInventoryByVo
    * @Description: 根据条件删除SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventoryVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolMaterialInventoryByVo(SynthesisCuttingToolMaterialInventoryVO synthesisCuttingToolMaterialInventoryVO) throws Exception;

    /**
    * @Title: updSynthesisCuttingToolMaterialInventory
    * @Description: 动态更新SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventory
    * @throws Exception
    * @return: void
    */
    public void updSynthesisCuttingToolMaterialInventory(SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolMaterialInventoryByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolMaterialInventoryVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SynthesisCuttingToolMaterialInventory> getSynthesisCuttingToolMaterialInventoryByPage(SynthesisCuttingToolMaterialInventoryVO synthesisCuttingToolMaterialInventoryVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolMaterialInventoryCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolMaterialInventoryVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolMaterialInventoryCount(SynthesisCuttingToolMaterialInventoryVO synthesisCuttingToolMaterialInventoryVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolMaterialInventory
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolMaterialInventoryVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolMaterialInventory getSynthesisCuttingToolMaterialInventory(SynthesisCuttingToolMaterialInventoryVO synthesisCuttingToolMaterialInventoryVO) throws Exception;

}
