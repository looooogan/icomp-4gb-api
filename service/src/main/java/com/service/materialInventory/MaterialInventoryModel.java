package com.service.materialInventory;

import com.common.constants.CuttingToolConsumeTypeEnum;
import com.common.constants.GrindingEnum;
import com.common.constants.OperationEnum;
import com.common.constants.ToolBusinessStatusEnum;
import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.IMaterialInventoryMapper;
import com.common.mapper.ISynthesisCuttingToolLocationMapper;
import com.common.pojo.CuttingTool;
import com.common.pojo.MaterialInventory;
import com.common.pojo.RfidContainer;
import com.common.pojo.SynthesisCuttingToolLocation;
import com.common.utils.FCBCodeHandler;
import com.common.vo.CuttingToolVO;
import com.common.vo.MaterialInventoryVO;
import com.common.vo.SynthesisCuttingToolLocationVO;
import com.service.inoutFactory.vo.GrindingVO;
import com.service.materialInventory.bo.MaterialInventoryBO;
import com.service.scrap.vo.ScrapVO;
import com.service.synthesiscuttingtool.vo.DownCuttingToolVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by logan on 2018/6/11.
 */
@Component("MaterialInventoryModel")
public class MaterialInventoryModel {

    @Autowired
    private IMaterialInventoryMapper materialInventoryMapper;
    @Autowired
    private ICuttingToolMapper cuttingToolMapper;
    @Autowired
    private ISynthesisCuttingToolLocationMapper locationMapper;

    /**
     * 出库修改材料刀库存
     * @throws Exception
     */
    public void OutApplyCuttingToolInventory(MaterialInventoryBO materialInventoryModelBO) throws Exception{
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
            materialInventory.setGrindingOutCount(countHandler(materialInventory.getGrindingOutCount(),materialInventoryModelBO.getUnitqty()));
        }
        materialInventoryMapper.updMaterialInventory(materialInventory);
    }

    /**
     * 合成刀换装，换上刀具修改库存
     * @param materialInventoryBO
     * @throws Exception
     */
    public void updateInventoryForUpExchange(MaterialInventoryBO materialInventoryBO) throws Exception{
        //如果上一步操作为初始化、换装、组装 换上的刀具数量不变
        RfidContainer rfidContainer = materialInventoryBO.getSynthesisCuttingToolBind().getRfidContainer();
        //如果上一步操作为换装、组装则不更新库存
        if (rfidContainer.getPrevKey()== OperationEnum.SynthesisCuttingTool_Exchange.getKey()
                ||rfidContainer.getPrevKey()== OperationEnum.SynthesisCuttingTool_Config.getKey()
                ||rfidContainer.getPrevKey()== OperationEnum.SynthesisCuttingTool_Init.getKey()){
            return;
        }
        //减少备刀库数量，增加待按上
    }

    /**
     * 合成刀换装，换下刀具修改库存
     * @param materialInventoryBO
     * @throws Exception
     */
    public void updateInventoryForDownExchange(MaterialInventoryBO materialInventoryBO) throws Exception{

        //如果上一步操作为初始化、换装、组装 换上的刀具数量不变
        RfidContainer rfidContainer = materialInventoryBO.getSynthesisCuttingToolBind().getRfidContainer();
        //如果上一步操作为换装、组装则不更新库存
        if (rfidContainer.getPrevKey()== OperationEnum.SynthesisCuttingTool_Exchange.getKey()
                ||rfidContainer.getPrevKey()== OperationEnum.SynthesisCuttingTool_Config.getKey()
                ||rfidContainer.getPrevKey()== OperationEnum.SynthesisCuttingTool_Init.getKey()){
            return;
        }
        //减少待换装数量、增加场内、外、报废数量
        MaterialInventoryVO materialInventoryVO = null;
        MaterialInventory materialInventory = null;
        CuttingToolVO cuttingToolVO = null;
        CuttingTool cuttingTool = null;
        for (DownCuttingToolVO downCuttingToolVO : materialInventoryBO.getDownCuttingToolVOS()) {
            //查询刀具信息，获取刀具刃磨类型
            cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setCode(downCuttingToolVO.getDownCode());
            cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
            if (null == cuttingTool){
                continue;
            }
            materialInventoryVO = new MaterialInventoryVO();
            materialInventoryVO.setCuttingToolCode(downCuttingToolVO.getDownCode());
            materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);
            if (null == materialInventory) {
                materialInventory = newMaterialInventory();
                materialInventory.setCuttingToolCode(downCuttingToolVO.getDownCode());
                materialInventoryMapper.addMaterialInventory(materialInventory);
            }
            //判断刀具刃磨类型
            materialInventory.setToExchangeCount(countHandler(materialInventory.getToExchangeCount(),downCuttingToolVO.getDownCount()));
            if (cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_dp.getKey())||
                    cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_zt.getKey())){
                if (cuttingTool.getGrinding().equals(GrindingEnum.outside.getKey())){
                    materialInventory.setForGrindingOutCount(materialInventory.getGrindingOutCount()+downCuttingToolVO.getDownCount());
                }else{
                    materialInventory.setForGrindingInCount(materialInventory.getForGrindingInCount()+downCuttingToolVO.getDownCount());
                }
            }
            if (cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.single_use_dp.getKey())){
                //todo 是否添加报废记录
                materialInventory.setScrapCount(materialInventory.getScrapCount()+downCuttingToolVO.getDownCount());
            }
            materialInventoryMapper.updMaterialInventory(materialInventory);
        }
    }


    /**
     * 安上设备，材料刀库存
     * @param materialInventoryBO
     * @throws Exception
     */
    public void updateInventoryForInstall(MaterialInventoryBO materialInventoryBO) throws Exception{

        RfidContainer rfidContainer = materialInventoryBO.getSynthesisCuttingToolBind().getRfidContainer();
        SynthesisCuttingToolLocationVO locationVO = new SynthesisCuttingToolLocationVO();
        locationVO.setSynthesisCuttingToolBindCode(materialInventoryBO.getSynthesisCuttingToolBind().getCode());
        List<SynthesisCuttingToolLocation> locationList = locationMapper.getSynthesisCuttingToolLocationByPage(locationVO);
        MaterialInventoryVO materialInventoryVO = null;
        MaterialInventory materialInventory = null;
        for (SynthesisCuttingToolLocation location : locationList) {
            materialInventoryVO = new MaterialInventoryVO();
            materialInventoryVO.setCuttingToolCode(location.getCuttingToolCode());
            materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);
            if (null == materialInventory) {
                materialInventory = newMaterialInventory();
                materialInventory.setCuttingToolCode(location.getCuttingToolCode());
                materialInventoryMapper.addMaterialInventory(materialInventory);
            }
            if (rfidContainer.getPrevKey()==OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
                materialInventory.setToExchangeCount(countHandler(materialInventory.getToExchangeCount(),location.getCount()));
            }else{
                materialInventory.setPrepareLibraryCount(countHandler(materialInventory.getPrepareLibraryCount(),location.getCount()));
            }
            materialInventory.setProductLineCount(materialInventory.getProductLineCount()+location.getCount());
            materialInventoryMapper.updMaterialInventory(materialInventory);
        }
    }

    /**
     * 卸下设备，材料刀库存
     * @param materialInventoryBO
     * @throws Exception
     */
    public void updateInventoryForUnInstall(MaterialInventoryBO materialInventoryBO) throws Exception{
        //获取刀具组装信息
        SynthesisCuttingToolLocationVO locationVO = new SynthesisCuttingToolLocationVO();
        locationVO.setSynthesisCuttingToolBindCode(materialInventoryBO.getSynthesisCuttingToolBind().getCode());
        List<SynthesisCuttingToolLocation> locationList = locationMapper.getSynthesisCuttingToolLocationByPage(locationVO);
        MaterialInventoryVO materialInventoryVO = null;
        MaterialInventory materialInventory = null;
        for (SynthesisCuttingToolLocation location : locationList) {
            materialInventoryVO = new MaterialInventoryVO();
            materialInventoryVO.setCuttingToolCode(location.getCuttingToolCode());
            materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);
            if (null == materialInventory) {
                materialInventory = newMaterialInventory();
                materialInventory.setCuttingToolCode(location.getCuttingToolCode());
                materialInventoryMapper.addMaterialInventory(materialInventory);
            }
            materialInventory.setProductLineCount(countHandler(materialInventory.getProductLineCount(),location.getCount()));
            materialInventory.setToExchangeCount(materialInventory.getToExchangeCount()+location.getCount());
            materialInventoryMapper.updMaterialInventory(materialInventory);
        }
    }


    /**
     * 场内刃磨，材料刀库存
     * @param materialInventoryBO
     * @throws Exception
     */
    public void updateInventoryForInGrinding(MaterialInventoryBO materialInventoryBO) throws Exception{
        MaterialInventoryVO materialInventoryVO = null;
        MaterialInventory materialInventory = null;
        CuttingToolVO cuttingToolVO = null;
        CuttingTool cuttingTool = null;
        for (GrindingVO grindingVO : materialInventoryBO.getGrindingVOS()) {
            materialInventoryVO = new MaterialInventoryVO();
            materialInventoryVO.setCuttingToolCode(grindingVO.getCuttingTool().getCode());
            materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);
            if (null == materialInventory) {
                materialInventory = newMaterialInventory();
                materialInventory.setCuttingToolCode(grindingVO.getCuttingTool().getCode());
                materialInventoryMapper.addMaterialInventory(materialInventory);
            }

            cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setCode(grindingVO.getCuttingTool().getCode());
            cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
            materialInventory.setForGrindingInCount(countHandler(materialInventory.getForGrindingInCount(),grindingVO.getGrindingCount()));
            if (cuttingTool.getGrinding().equals(GrindingEnum.outside_tuceng.getKey())){
                materialInventory.setForGrindingOutCount(materialInventory.getGrindingOutCount()+grindingVO.getGrindingCount());
            }else {
                materialInventory.setPrepareLibraryCount(materialInventory.getPrepareLibraryCount()+grindingVO.getGrindingCount());
            }
            materialInventoryMapper.updMaterialInventory(materialInventory);
        }
    }


    /**
     * 场外刃磨，材料刀库存
     * @param materialInventoryBO
     * @throws Exception
     */
    public void updateInventoryForOutGrinding(MaterialInventoryBO materialInventoryBO) throws Exception{
        MaterialInventoryVO materialInventoryVO = null;
        MaterialInventory materialInventory = null;
        for (GrindingVO grindingVO : materialInventoryBO.getGrindingVOS()) {
            materialInventoryVO = new MaterialInventoryVO();
            materialInventoryVO.setCuttingToolCode(grindingVO.getCuttingTool().getCode());
            materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);
            if (null == materialInventory) {
                materialInventory = newMaterialInventory();
                materialInventory.setCuttingToolCode(grindingVO.getCuttingTool().getCode());
                materialInventoryMapper.addMaterialInventory(materialInventory);
            }
            materialInventory.setForGrindingOutCount(countHandler(materialInventory.getGrindingOutCount(),grindingVO.getGrindingCount()));
            materialInventory.setGrindingOutCount(materialInventory.getGrindingOutCount()+grindingVO.getGrindingCount());
            materialInventoryMapper.updMaterialInventory(materialInventory);
        }
    }

    /**
     * 刀具报废，修改库存
     * @param materialInventoryBO
     * @throws Exception
     */
    public void updateInventoryForScarp(MaterialInventoryBO materialInventoryBO) throws Exception{
        MaterialInventoryVO materialInventoryVO = null;
        MaterialInventory materialInventory = null;
        for (ScrapVO scrapVO : materialInventoryBO.getScrapVOS()) {
            materialInventoryVO = new MaterialInventoryVO();
            materialInventoryVO.setCuttingToolCode(scrapVO.getCuttingToolVO().getCode());
            materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);
            if (null == materialInventory) {
                materialInventory = newMaterialInventory();
                materialInventory.setCuttingToolCode(scrapVO.getCuttingToolVO().getCode());
                materialInventoryMapper.addMaterialInventory(materialInventory);
            }
            materialInventory.setScrapCount(materialInventory.getScrapCount()+scrapVO.getCount());
            if (scrapVO.getStatus().equals(ToolBusinessStatusEnum.Library.getKey())){
                materialInventory.setPrepareLibraryCount(countHandler(materialInventory.getPrepareLibraryCount(),scrapVO.getCount()));
            }
            if (scrapVO.getStatus().equals(ToolBusinessStatusEnum.ForGrinding.getKey())){
                if (!StringUtils.isBlank(scrapVO.getCuttingTool().getGrinding())){
                    if (scrapVO.getCuttingTool().getGrinding().equals(GrindingEnum.inside)){
                        materialInventory.setForGrindingInCount(countHandler(materialInventory.getForGrindingInCount(),scrapVO.getCount()));
                    }else{
                        materialInventory.setForGrindingOutCount(countHandler(materialInventory.getForGrindingOutCount(),scrapVO.getCount()));
                    }

                }
            }
            materialInventoryMapper.updMaterialInventory(materialInventory);
        }
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
