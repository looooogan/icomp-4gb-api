package com.service.system.impl;

import com.common.constants.OperationEnum;
import com.common.constants.RFIDEnum;
import com.common.mapper.ICuttingToolBindMapper;
import com.common.mapper.IProductLineEquipmentMapper;
import com.common.mapper.IRfidContainerMapper;
import com.common.mapper.ISynthesisCuttingToolBindMapper;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.ProductLineEquipment;
import com.common.pojo.RfidContainer;
import com.common.pojo.SynthesisCuttingToolBind;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.*;
import com.service.system.ISystemBusinessService;
import com.service.system.vo.ChangeRFIDVO;
import com.service.system.vo.RFIDQueryVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by logan on 2018/5/6.
 */
@Service("systemBusinessService")
public class SystemBusinessServiceImpl implements ISystemBusinessService{

    @Autowired
    private ISynthesisCuttingToolBindMapper synthesisCuttingToolBindMapper;

    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;

    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;

    @Autowired
    private IRfidContainerMapper rfidContainerMapper;

    @Autowired
    private IProductLineEquipmentMapper equipmentMapper;




    @Override
    public void chagneRFIDForTool(ChangeRFIDVO changeRFIDVO) throws Exception {

        CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
        cuttingToolBindVO.setBladeCode(changeRFIDVO.getToolCode());
        CuttingToolBind cuttingToolBind =cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
        if (null == changeRFIDVO){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.CUTTINGTOOL_NOT_EXISTS));
        }

        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(changeRFIDVO.getRfidCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
        if (rfidContainer == null){
            rfidContainer = new RfidContainer();
            rfidContainer.setIsDel(0);
            rfidContainer.setUseCount(1);
            rfidContainer.setCode(UUID.getInstance());
            rfidContainer.setLaserCode(changeRFIDVO.getRfidCode());
            rfidContainer.setLabelType(RFIDEnum.equipment.getKey());
            rfidContainer.setOperatorCode(OperationEnum.Equipment_Init.getKey());
            rfidContainer.setOperatorName(OperationEnum.Equipment_Init.getName());
            rfidContainerMapper.addRfidContainer(rfidContainer);
        }else if (rfidContainer.getOperatorCode() == null || rfidContainer.getOperatorCode() ==0){
            rfidContainer.setPrevKey(rfidContainer.getOperatorCode());
            rfidContainer.setPrevOperation(rfidContainer.getOperatorName());
            rfidContainer.setUseCount(rfidContainer.getUseCount()+1);
            rfidContainer.setLabelType(RFIDEnum.equipment.getKey());
            rfidContainer.setOperatorCode(OperationEnum.Equipment_Init.getKey());
            rfidContainer.setOperatorName(OperationEnum.Equipment_Init.getName());
            rfidContainerMapper.updRfidContainer(rfidContainer);
        }else {
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_IN_USE));
        }

        cuttingToolBind.setRfidContainerCode(rfidContainer.getCode());
        cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
    }

    @Override
    public void clearRFID(RFIDQueryVO rfidQueryVO) throws Exception {
        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(rfidQueryVO.getRfidCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
        if (null == rfidContainer){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_NOT_EXISTS));
        }

        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
        synthesisCuttingToolBindVO.setRfidContainerCode(rfidContainer.getCode());
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);
        if (null!=synthesisCuttingToolBind){
            synthesisCuttingToolBind.setRfidContainerCode("");
            synthesisCuttingToolBindMapper.updSynthesisCuttingToolBind(synthesisCuttingToolBind);
        }

        CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
        cuttingToolBindVO.setRfidContainerCode(rfidContainer.getCode());
        CuttingToolBind cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
        if (null!=cuttingToolBind){
            cuttingToolBind.setRfidContainerCode("");
            cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
        }

        ProductLineEquipmentVO equipmentVO = new ProductLineEquipmentVO();
        equipmentVO.setRfidContainerCode(rfidContainer.getCode());
        ProductLineEquipment equipment = equipmentMapper.getProductLineEquipment(equipmentVO);
        if (null!=equipment){
            equipment.setRfidContainerCode("");
            equipmentMapper.updProductLineEquipment(equipment);
        }


    }

    @Override
    public RFIDQueryVO queryByRFID(RFIDQueryVO rfidQueryVO) throws Exception {
        RFIDQueryVO returnRFIDQueryVO = new RFIDQueryVO();

        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(rfidQueryVO.getRfidCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
        if (null == rfidContainer){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_NOT_EXISTS));
        }

        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
        synthesisCuttingToolBindVO.setRfidContainerCode(rfidContainer.getCode());
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);
        if (null!=synthesisCuttingToolBind){
            returnRFIDQueryVO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        }

        CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
        cuttingToolBindVO.setRfidContainerCode(rfidContainer.getCode());
        CuttingToolBind cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
        if (null!=cuttingToolBind){
            returnRFIDQueryVO.setCuttingToolBind(cuttingToolBind);
        }

        ProductLineEquipmentVO equipmentVO = new ProductLineEquipmentVO();
        equipmentVO.setRfidContainerCode(rfidContainer.getCode());
        ProductLineEquipment equipment = equipmentMapper.getProductLineEquipment(equipmentVO);
        if (null!=equipment){
            returnRFIDQueryVO.setEquipment(equipment);
        }
        return returnRFIDQueryVO;
    }
}
