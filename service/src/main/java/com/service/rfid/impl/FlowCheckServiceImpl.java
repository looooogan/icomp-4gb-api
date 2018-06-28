package com.service.rfid.impl;

import com.common.constants.OperationEnum;
import com.common.mapper.ICuttingToolBindMapper;
import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.IRfidContainerMapper;
import com.common.pojo.RfidContainer;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.RfidContainerVO;
import com.service.rfid.DTO.FlowCheckDTO;
import com.service.rfid.IFlowCheckService;
import com.service.rfid.vo.FlowCheckVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by logan on 2018/5/27.
 */
@Service("flowCheck")
public class FlowCheckServiceImpl implements IFlowCheckService{
    @Autowired
    private IRfidContainerMapper rfidContainerMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;
    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;
    @Autowired
    private ICuttingToolMapper cuttingToolMapper;

    private String charCode = "iso8859-1";

    @Override
    public FlowCheckDTO checkFlow(FlowCheckVO flowCheckVO) throws Exception {

        FlowCheckDTO flowCheckDTO = new FlowCheckDTO();
        if ( null == flowCheckVO.getOperationCode()){
            return flowCheckDTO;
        }

        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(flowCheckVO.getRfidContainerVO());
        if (rfidContainer == null){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_NOT_EXISTS));
        }

        //刀具换装
        if (flowCheckVO.getOperationCode() == OperationEnum.SynthesisCuttingTool_Exchange.getKey()) {
            return checkExchange(rfidContainer);
        }
        //刀具组装
        if (flowCheckVO.getOperationCode() == OperationEnum.SynthesisCuttingTool_Config.getKey()) {
            return checkConfig(rfidContainer);
        }
        //刀具拆分
        if (flowCheckVO.getOperationCode() == OperationEnum.SynthesisCuttingTool_UnConfig.getKey()) {
            return checkUnConfig(rfidContainer);
        }
        //刀具安上设备
        if (flowCheckVO.getOperationCode() == OperationEnum.SynthesisCuttingTool_Install.getKey()) {
            return checkInstall(rfidContainer);
        }

        //刀具安上卸下设备
        if (flowCheckVO.getOperationCode() == OperationEnum.SynthesisCuttingTool_UnInstall.getKey()) {
            return checkUnInstall(rfidContainer);
        }

        //刀具刃磨
//        if (flowCheckVO.getOperationCode() == OperationEnum.Cutting_tool_Inside.getKey()||
//                flowCheckVO.getOperationCode() == OperationEnum.Cutting_tool_OutSide.getKey()||
//                flowCheckVO.getOperationCode() == OperationEnum.Cutting_tool_Inside_Coating.getKey()) {
//            return checkGrinding(rfidContainer);
//        }
        flowCheckDTO.setType("1");
        return flowCheckDTO;
    }

    public FlowCheckDTO checkExchange(RfidContainer rfidContainer) throws Exception{
        FlowCheckDTO flowCheckDTO = new FlowCheckDTO();
        do {
            if (rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_UnInstall.getKey()
                    || rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Init.getKey()){
                flowCheckDTO.setType("1");
                break;
            }
            if (rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Exchange.getKey()
                    ||rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Config.getKey()){
                String message = messageSourceHanlder.getValue(ExceptionConstans.EXCHANGE_MESSAGE)+ExceptionConstans.MESSAGE_SUFXX+rfidContainer.getPrevOperation();
//                flowCheckDTO.setMessage(new String(message.getBytes(),charCode));
                flowCheckDTO.setMessage(message);
                flowCheckDTO.setType("2");
                break;
            }
            String message = messageSourceHanlder.getValue(ExceptionConstans.CONFIG_MESSAGE)+ExceptionConstans.MESSAGE_SUFXX+rfidContainer.getPrevOperation();
            flowCheckDTO.setMessage(new String(message.getBytes(),charCode));
//            flowCheckDTO.setMessage(messageSourceHanlder.getValue(ExceptionConstans.EXCHANGE_MESSAGE)+ExceptionConstans.MESSAGE_SUFXX+rfidContainer.getPrevOperation());
            flowCheckDTO.setType("3");
        }while (1==2);
        return flowCheckDTO;
    }

    public FlowCheckDTO checkConfig(RfidContainer rfidContainer) throws Exception{
        FlowCheckDTO flowCheckDTO = new FlowCheckDTO();
        do {
            if (rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_UnConfig.getKey()
                    || rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Init.getKey()){
                flowCheckDTO.setType("1");
                break;
            }
            String message = messageSourceHanlder.getValue(ExceptionConstans.CONFIG_MESSAGE)+ExceptionConstans.MESSAGE_SUFXX+rfidContainer.getPrevOperation();
            flowCheckDTO.setMessage(new String(message.getBytes(),charCode));
//            flowCheckDTO.setMessage(message);
//            flowCheckDTO.setMessage(messageSourceHanlder.getValue(ExceptionConstans.CONFIG_MESSAGE+ExceptionConstans.MESSAGE_SUFXX+rfidContainer.getPrevOperation()));
            flowCheckDTO.setType("3");
        }while (1==2);
        return flowCheckDTO;
    }

    public FlowCheckDTO checkUnConfig(RfidContainer rfidContainer) throws Exception{
        FlowCheckDTO flowCheckDTO = new FlowCheckDTO();
        String message = "";
        do {
            if (rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
                flowCheckDTO.setType("1");
                break;
            }
            if (rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Exchange.getKey()
                    ||rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Config.getKey()
                    ||rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Init.getKey()){
                message = messageSourceHanlder.getValue(ExceptionConstans.CONFIG_MESSAGE)+ExceptionConstans.MESSAGE_SUFXX+rfidContainer.getPrevOperation();
                flowCheckDTO.setType("2");
                break;
            }
            message = messageSourceHanlder.getValue(ExceptionConstans.CONFIG_MESSAGE)+ExceptionConstans.MESSAGE_SUFXX+rfidContainer.getPrevOperation();
            flowCheckDTO.setType("3");
        }while (1==2);
//        flowCheckDTO.setMessage(message);
        flowCheckDTO.setMessage(new String(message.getBytes(),charCode));
        return flowCheckDTO;
    }

    public FlowCheckDTO checkInstall(RfidContainer rfidContainer) throws Exception{
        FlowCheckDTO flowCheckDTO = new FlowCheckDTO();
        String message = "";
        do {
            if (rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Exchange.getKey()||
                    rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Config.getKey()||
                    rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Init.getKey()){
                flowCheckDTO.setType("1");
                break;
            }

            if (rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
                message =messageSourceHanlder.getValue(ExceptionConstans.UnInstalled_MESSAGE);
                flowCheckDTO.setType("2");
                break;
            }

            if (rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Install.getKey()){
                message =messageSourceHanlder.getValue(ExceptionConstans.Installed_MESSAGE);
            }
            if (rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
                message =messageSourceHanlder.getValue(ExceptionConstans.UnInstalled_MESSAGE);
            }
            if (rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_UnConfig.getKey()){
                message =messageSourceHanlder.getValue(ExceptionConstans.UnInstalled_MESSAGE);
            }
            if (StringUtils.isBlank(message)){
                message = messageSourceHanlder.getValue(ExceptionConstans.CONFIG_MESSAGE)+ExceptionConstans.MESSAGE_SUFXX+rfidContainer.getPrevOperation();
            }
            flowCheckDTO.setType("3");
        }while (1==2);
//        flowCheckDTO.setMessage(message);
        flowCheckDTO.setMessage(new String(message.getBytes(),charCode));
        return flowCheckDTO;
    }

    public FlowCheckDTO checkUnInstall(RfidContainer rfidContainer) throws Exception{
        FlowCheckDTO flowCheckDTO = new FlowCheckDTO();
        do {
            if (rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Install.getKey()){
                flowCheckDTO.setType("1");
                break;
            }
            String message = messageSourceHanlder.getValue(ExceptionConstans.CONFIG_MESSAGE)+ExceptionConstans.MESSAGE_SUFXX+rfidContainer.getPrevOperation();
//            flowCheckDTO.setMessage(message);
            flowCheckDTO.setMessage(new String(message.getBytes(),charCode));
//            flowCheckDTO.setMessage(messageSourceHanlder.getValue(ExceptionConstans.CONFIG_MESSAGE)+ExceptionConstans.MESSAGE_SUFXX+rfidContainer.getPrevOperation());
            flowCheckDTO.setType("3");
        }while (1==2);
        return flowCheckDTO;
    }

    public FlowCheckDTO checkGrinding(RfidContainer rfidContainer) throws Exception{
        FlowCheckDTO flowCheckDTO = new FlowCheckDTO();
        do {
            if (rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_UnConfig.getKey()||
                    rfidContainer.getPrevKey() == OperationEnum.Equipment_Init.getKey()||
            rfidContainer.getPrevKey() == OperationEnum.SynthesisCuttingTool_Exchange.getKey()){
                flowCheckDTO.setType("1");
                break;
            }
            String message = messageSourceHanlder.getValue(ExceptionConstans.CONFIG_MESSAGE)+ExceptionConstans.MESSAGE_SUFXX+rfidContainer.getPrevOperation();
//            flowCheckDTO.setMessage(message);
            flowCheckDTO.setMessage(new String(message.getBytes(),charCode));
//            flowCheckDTO.setMessage(messageSourceHanlder.getValue(ExceptionConstans.CONFIG_MESSAGE)+ExceptionConstans.MESSAGE_SUFXX+rfidContainer.getPrevOperation());
            flowCheckDTO.setType("3");
        }while (1==2);
        return flowCheckDTO;
    }
}
