package com.service.common.impl;


import com.common.constants.CuttingToolConsumeTypeEnum;
import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.IMaterialInventoryMapper;
import com.common.pojo.CuttingTool;
import com.common.pojo.MaterialInventory;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.CuttingToolVO;
import com.common.vo.MaterialInventoryVO;
import com.service.common.IMaterialInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName MaterialInventoryServiceImpl
* @Description MaterialInventory业务实现类
* @author Jivoin
*/
@Service("materialInventoryService")
public class MaterialInventoryServiceImpl implements IMaterialInventoryService{

    @Autowired
    private IMaterialInventoryMapper materialInventoryMapper;

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;

    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;


    /**
    * @Title: addMaterialInventory
    * @Description: 新增MaterialInventory
    * @param materialInventory
    * @throws Exception
    * @return: void
    */
    @Override
    public void addMaterialInventory(MaterialInventory materialInventory) throws Exception{
        CuttingToolVO cuttingToolVO = new CuttingToolVO();
        cuttingToolVO.setBusinessCode(materialInventory.getCuttingTool().getBusinessCode());
        CuttingTool cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
        if (cuttingTool == null){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.MATERIALINVENTORY_CUTTINGTOOL_UNFOUND));
        }

        if (cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_zt.getKey())){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.MATERIALINVENTORY_CUTTINGTOOL_TYPE_ERROR));
        }

        MaterialInventoryVO materialInventoryVO = new MaterialInventoryVO();
        materialInventoryVO.setCuttingToolVO(cuttingToolVO);
        List<MaterialInventory> materialInventories = materialInventoryMapper.getMaterialInventoryByPage(materialInventoryVO);
        if (null!=materialInventories && materialInventories.size()>0){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.MATERIALINVENTORY_CUTTINGTOOL_EXISTS));
        }

        materialInventory.setCuttingTool(cuttingTool);
        materialInventory.setCuttingToolCode(cuttingTool.getCode());
        materialInventory.setIsDel(0);
        materialInventory.setScrapCount(0);
        materialInventory.setGrindingOutCount(0);
        materialInventory.setForGrindingOutCount(0);
        materialInventory.setForGrindingInCount(0);
        materialInventory.setProductLineCount(0);
        materialInventory.setToExchangeCount(0);
        materialInventory.setToInstallCount(0);
        materialInventory.setToUninstallCount(0);
        materialInventoryMapper.addMaterialInventory(materialInventory);
    }

    /**
    * @Title: delMaterialInventory
    * @Description: 删除MaterialInventory
    * @param materialInventory
    * @throws Exception
    * @return: void
    */
    @Override
    public void delMaterialInventory(MaterialInventory materialInventory) throws Exception{
        materialInventoryMapper.delMaterialInventory(materialInventory);
    }

    /**
    * @Title: delMaterialInventoryForLogic
    * @Description: 逻辑删除MaterialInventory
    * @param materialInventory
    * @throws Exception
    * @return: void
    */
    @Override
    public void delMaterialInventoryForLogic(MaterialInventory materialInventory) throws Exception{
        materialInventoryMapper.delMaterialInventoryForLogic(materialInventory);
    }

    /**
    * @Title: delMaterialInventoryByVo
    * @Description: 根据条件删除MaterialInventory
    * @param materialInventoryVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delMaterialInventoryByVo(MaterialInventoryVO materialInventoryVO) throws Exception{
        materialInventoryMapper.delMaterialInventoryByVo(materialInventoryVO);
    }

    /**
    * @Title: updMaterialInventory
    * @Description: 动态更新MaterialInventory
    * @param materialInventory
    * @throws Exception
    * @return: void
    */
    @Override
    public void updMaterialInventory(MaterialInventory materialInventory) throws Exception{
        materialInventoryMapper.updMaterialInventory(materialInventory);
    }

    /**
    * @Title: getMaterialInventoryByPage
    * @Description: 分页查询
    * @param materialInventoryVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<MaterialInventory> getMaterialInventoryByPage(MaterialInventoryVO materialInventoryVO) throws Exception{
        materialInventoryVO.setTotalPage(materialInventoryMapper.getMaterialInventoryCount(materialInventoryVO));
        return materialInventoryMapper.getMaterialInventoryByPage(materialInventoryVO);
    }

    /**
    * @Title: getMaterialInventoryCount
    * @Description: 获取记录数量
    * @param materialInventoryVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getMaterialInventoryCount(MaterialInventoryVO materialInventoryVO) throws Exception{
        return materialInventoryMapper.getMaterialInventoryCount(materialInventoryVO);
    }

    /**
    * @Title: getMaterialInventory
    * @Description: 根据查询条件查询
    * @param materialInventoryVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public MaterialInventory getMaterialInventory(MaterialInventoryVO materialInventoryVO) throws Exception{
        return materialInventoryMapper.getMaterialInventory(materialInventoryVO);
    }

}
