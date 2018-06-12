package com.service.materialInventory;

import com.common.constants.GrindingEnum;
import com.common.mapper.IMaterialInventoryMapper;
import com.common.pojo.MaterialInventory;
import com.common.utils.FCBCodeHandler;
import com.common.vo.MaterialInventoryVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by logan on 2018/6/11.
 */
@Component("MaterialInventoryModel")
public class MaterialInventoryModel {

    @Autowired
    private IMaterialInventoryMapper materialInventoryMapper;

    /**
     * 出库修改材料刀库存
     * @throws Exception
     */
    public void OutApplyCuttingToolInventory(MaterialInventoryModelBO materialInventoryModelBO) throws Exception{
        MaterialInventoryVO materialInventoryVO = new MaterialInventoryVO();
        materialInventoryVO.setCuttingToolCode(materialInventoryModelBO.getCuttingTool().getCode());
        MaterialInventory materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);
        //添加材料刀备用刀库数量
        if (null == materialInventory) {
            materialInventory = newMaterialInventory();
            materialInventory.setCuttingToolCode(materialInventoryModelBO.getCuttingTool().getCode());
            materialInventoryMapper.addMaterialInventory(materialInventory);
        }
        materialInventory.setPrepareLibraryCount(materialInventory.getPrepareLibraryCount()+materialInventoryModelBO.getUnitqty());
        //如果是外委回来，减少厂外刃磨数量
        if (StringUtils.isBlank(FCBCodeHandler.getFCBCodeSuffix(materialInventoryModelBO.getMtlCode()))){
            materialInventory.setGrindingOutCount(materialInventory.getGrindingOutCount()-materialInventoryModelBO.getUnitqty()<0?0:materialInventory.getGrindingOutCount()-materialInventoryModelBO.getUnitqty());
        }
        materialInventoryMapper.updMaterialInventory(materialInventory);
    }

    /**
     * 初始化库存
     * @return
     * @throws Exception
     */
    public MaterialInventory newMaterialInventory() throws Exception{
        MaterialInventory materialInventory = new MaterialInventory();
        materialInventory.setIsDel(0);
        materialInventory.setPrepareLibraryCount(0);
        materialInventory.setProductLineCount(0);
        materialInventory.setToExchangeCount(0);
        materialInventory.setGrindingOutCount(0);
        materialInventory.setScrapCount(0);
        materialInventory.setForGrindingInCount(0);
        materialInventory.setForGrindingOutCount(0);
        materialInventory.setGrindingOutCount(0);
        return materialInventory;
    }
}
