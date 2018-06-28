package com.service.materialInventory;

import com.common.constants.OperationEnum;
import com.common.mapper.ISynthesisCuttingToolMaterialInventoryMapper;
import com.common.pojo.RfidContainer;
import com.common.pojo.SynthesisCuttingToolMaterialInventory;
import com.common.vo.SynthesisCuttingToolMaterialInventoryVO;
import com.service.materialInventory.bo.SynthesisMaterialInventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 合成刀库存管理模块
 * Created by logan on 2018/6/13.
 */
@Component("SynthesisInventoryModel")
public class SynthesisInventoryModel {
    @Autowired
    private ISynthesisCuttingToolMaterialInventoryMapper synthesismaterialInventoryMapper;

    /**
     * 合成刀初始化更新库存
     * @param synthesisMaterialInventoryBO 业务数据封装
     * @throws Exception
     */
    public void updateInventoryForInit(SynthesisMaterialInventoryBO synthesisMaterialInventoryBO) throws Exception{
        SynthesisCuttingToolMaterialInventoryVO materialInventoryVO = new SynthesisCuttingToolMaterialInventoryVO();
        materialInventoryVO.setSynthesisCuttingToolCode(synthesisMaterialInventoryBO.getSynthesisCuttingTool().getCode());
        SynthesisCuttingToolMaterialInventory materialInventory = synthesismaterialInventoryMapper.getSynthesisCuttingToolMaterialInventory(materialInventoryVO);
        if (null == materialInventory){
            materialInventory = getNew(synthesisMaterialInventoryBO.getSynthesisCuttingTool().getCode());
            synthesismaterialInventoryMapper.addSynthesisCuttingToolMaterialInventory(materialInventory);
        }
        if (null!=synthesisMaterialInventoryBO.getSynthesisCuttingToolBindVOS()
                &&synthesisMaterialInventoryBO.getSynthesisCuttingToolBindVOS().size()>0){
            materialInventory.setTotal(materialInventory.getTotal()+synthesisMaterialInventoryBO.getSynthesisCuttingToolBindVOS().size());
            materialInventory.setPrepareLibraryCount(materialInventory.getPrepareLibraryCount()+synthesisMaterialInventoryBO.getSynthesisCuttingToolBindVOS().size());
            synthesismaterialInventoryMapper.updSynthesisCuttingToolMaterialInventory(materialInventory);
        }
    }

    /**
     * 合成刀换装更新库存
     * @param synthesisMaterialInventoryBO
     * @throws Exception
     */
    public void updateInventoryForExchange(SynthesisMaterialInventoryBO synthesisMaterialInventoryBO) throws Exception{
        RfidContainer rfidContainer = synthesisMaterialInventoryBO.getSynthesisCuttingToolBind().getRfidContainer();
        //如果上一步操作为换装、组装则不更新库存
        if (rfidContainer.getPrevKey()== OperationEnum.SynthesisCuttingTool_Exchange.getKey()
                ||rfidContainer.getPrevKey()== OperationEnum.SynthesisCuttingTool_Config.getKey()
                ||rfidContainer.getPrevKey()== OperationEnum.SynthesisCuttingTool_Init.getKey()){
            return;
        }
        //增加备刀库库存减少待换装库存
        SynthesisCuttingToolMaterialInventoryVO materialInventoryVO = new SynthesisCuttingToolMaterialInventoryVO();
        materialInventoryVO.setSynthesisCuttingToolCode(synthesisMaterialInventoryBO.getSynthesisCuttingTool().getCode());
        SynthesisCuttingToolMaterialInventory materialInventory = synthesismaterialInventoryMapper.getSynthesisCuttingToolMaterialInventory(materialInventoryVO);
        if (null == materialInventory){
            materialInventory = getNew(synthesisMaterialInventoryBO.getSynthesisCuttingTool().getCode());
            synthesismaterialInventoryMapper.addSynthesisCuttingToolMaterialInventory(materialInventory);
        }
        materialInventory.setPrepareLibraryCount(materialInventory.getPrepareLibraryCount()+1);
        materialInventory.setToExchangeCount(countHandler(materialInventory.getToExchangeCount(),1));
        synthesismaterialInventoryMapper.updSynthesisCuttingToolMaterialInventory(materialInventory);

    }

    /**
     * 合成刀安上设备更新库存
     * @param synthesisMaterialInventoryBO
     * @throws Exception
     */
    public void updateInventoryForInstall(SynthesisMaterialInventoryBO synthesisMaterialInventoryBO) throws Exception{
        RfidContainer rfidContainer = synthesisMaterialInventoryBO.getSynthesisCuttingToolBind().getRfidContainer();
        //减备刀库库存增加设备上库存
        SynthesisCuttingToolMaterialInventoryVO materialInventoryVO = new SynthesisCuttingToolMaterialInventoryVO();
        materialInventoryVO.setSynthesisCuttingToolCode(synthesisMaterialInventoryBO.getSynthesisCuttingToolBind().getSynthesisCuttingTool().getCode());
        SynthesisCuttingToolMaterialInventory materialInventory = synthesismaterialInventoryMapper.getSynthesisCuttingToolMaterialInventory(materialInventoryVO);
        if (null == materialInventory){
            materialInventory = getNew(synthesisMaterialInventoryBO.getSynthesisCuttingTool().getCode());
            synthesismaterialInventoryMapper.addSynthesisCuttingToolMaterialInventory(materialInventory);
        }
        if (rfidContainer.getPrevKey()==OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
            materialInventory.setToExchangeCount(countHandler(materialInventory.getToExchangeCount(),1));
        }else{
            materialInventory.setPrepareLibraryCount(countHandler(materialInventory.getPrepareLibraryCount(),1));
        }
        materialInventory.setInUseCount(materialInventory.getInUseCount()+1);
        synthesismaterialInventoryMapper.updSynthesisCuttingToolMaterialInventory(materialInventory);
    }

    /**
     * 合成刀卸下设备更新库存
     * @param synthesisMaterialInventoryBO
     * @throws Exception
     */
    public void updateInventoryForUnInstall(SynthesisMaterialInventoryBO synthesisMaterialInventoryBO) throws Exception{
        //减少设备上数量，增加待换装数量
        SynthesisCuttingToolMaterialInventoryVO materialInventoryVO = new SynthesisCuttingToolMaterialInventoryVO();
        materialInventoryVO.setSynthesisCuttingToolCode(synthesisMaterialInventoryBO.getSynthesisCuttingTool().getCode());
        SynthesisCuttingToolMaterialInventory materialInventory = synthesismaterialInventoryMapper.getSynthesisCuttingToolMaterialInventory(materialInventoryVO);
        if (null == materialInventory){
            materialInventory = getNew(synthesisMaterialInventoryBO.getSynthesisCuttingTool().getCode());
            synthesismaterialInventoryMapper.addSynthesisCuttingToolMaterialInventory(materialInventory);
        }
        materialInventory.setInUseCount(countHandler(materialInventory.getInUseCount(),1));
        materialInventory.setToExchangeCount(materialInventory.getToExchangeCount()+1);
        synthesismaterialInventoryMapper.updSynthesisCuttingToolMaterialInventory(materialInventory);
    }


    public SynthesisCuttingToolMaterialInventory getNew(String synthesisCode) throws Exception{
        SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory = new SynthesisCuttingToolMaterialInventory();
        synthesisCuttingToolMaterialInventory.setIsDel(0);
        synthesisCuttingToolMaterialInventory.setSynthesisCuttingToolCode(synthesisCode);
        synthesisCuttingToolMaterialInventory.setPrepareLibraryCount(0);
        synthesisCuttingToolMaterialInventory.setTotal(0);
        synthesisCuttingToolMaterialInventory.setInUseCount(0);
        synthesisCuttingToolMaterialInventory.setToExchangeCount(0);
        synthesisCuttingToolMaterialInventory.setToInstallCount(0);
        return synthesisCuttingToolMaterialInventory;
    }

    /**
     * 库存计算，不能低于0
     * @param nowCount 当前数量
     * @param num 减少数量
     * @return
     * @throws Exception
     */
    public Integer countHandler(Integer nowCount,Integer num) throws Exception{
        return nowCount-num<0?0:nowCount-num;
    }

}
