package com.service.rfid;

import com.common.constants.OperationEnum;
import com.common.constants.RFIDEnum;
import com.common.mapper.IAuthCustomerMapper;
import com.common.mapper.IRfidContainerMapper;
import com.common.pojo.AuthCustomer;
import com.common.pojo.RfidContainer;
import com.common.pojo.SynthesisCuttingToolBind;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.AuthCustomerVO;
import com.common.vo.RfidContainerVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.service.rfid.bo.RFIDBO;
import com.service.rfid.vo.RFIDBindVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by logan on 2018/5/29.
 */
@Component("RfidModel")
public class RfidModel {
    @Autowired
    private IRfidContainerMapper rfidContainerMapper;
    @Autowired
    private IAuthCustomerMapper authCustomerMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;

    @Deprecated
    public void updateRfidStatus(RFIDBO rfidbo) throws Exception{
        RfidContainerVO rfidContainerVO  = new RfidContainerVO();
        rfidContainerVO.setLaserCode(rfidbo.getLaserCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
        rfidContainer.setPrevKey(rfidbo.getPrevOperationKey());
        rfidContainer.setPrevOperation(OperationEnum.getEnumByKey(rfidbo.getPrevOperationKey()).getName());
        rfidContainer.setLabelType(rfidbo.getLabelType());
        rfidContainer.setOperatorTime(new Timestamp(System.currentTimeMillis()));
        //todo 修改
//        rfidContainer.setOperatorCode(rfidbo.getOperatorCode()+"");
    }

    @Deprecated
    public void updateRfidStatusTemp(RFIDBO rfidbo) throws Exception{
        RfidContainerVO rfidContainerVO  = new RfidContainerVO();
        rfidContainerVO.setLaserCode(rfidbo.getLaserCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
//        rfidContainer.setOperatorCode(rfidbo.getPrevOperationKey());
        rfidContainer.setOperatorName(OperationEnum.getEnumByKey(rfidbo.getPrevOperationKey()).getName());
        rfidContainer.setLabelType(rfidbo.getLabelType());
        rfidContainer.setOperatorTime(new Timestamp(System.currentTimeMillis()));
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(rfidbo.getOperatorCode());
//        AuthCustomer authCustomer = authCustomerMapper.getAuthCustomer(authCustomerVO);
        rfidContainerMapper.updRfidContainer(rfidContainer);
    }

    /**
     * 绑定RFID标签
     * @param rfidBindVO
     * @return
     * @throws Exception
     */
    public RfidContainer bindRFID(RFIDBindVO rfidBindVO) throws Exception{
        RfidContainer rfidContainer = null;
        if (null==rfidBindVO.getRfidContainerVO()
                ||(StringUtils.isBlank(rfidBindVO.getRfidContainerVO().getLaserCode()) && StringUtils.isBlank(rfidBindVO.getRfidContainerVO().getSynthesisBladeCode()))){
            return rfidContainer;
        }
        rfidContainer = rfidContainerMapper.getRfidContainer(rfidBindVO.getRfidContainerVO());
        if (null!=rfidContainer){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_IN_USE));
        }
        rfidContainer = new RfidContainer();
        rfidContainer.setIsDel(0);
        rfidContainer.setUseCount(0);
        rfidContainer.setCode(UUID.getInstance());
        rfidContainer.setLaserCode(rfidBindVO.getRfidContainerVO().getLaserCode());
        rfidContainer.setSynthesisBladeCode(rfidBindVO.getRfidContainerVO().getSynthesisBladeCode());
        rfidContainer.setUseCount(rfidContainer.getUseCount()+1);
        rfidContainer.setLabelType(getLabelType(rfidBindVO.getOperationEnum()));
        rfidContainer.setPrevKey(rfidBindVO.getOperationEnum().getKey());
        rfidContainer.setPrevOperation(rfidBindVO.getOperationEnum().getName());
        rfidContainer.setOperatorCode(rfidBindVO.getLoginUser().getCode());
        rfidContainer.setOperatorName(rfidBindVO.getLoginUser().getName());
        rfidContainer.setOperatorTime(new Timestamp(System.currentTimeMillis()));
        rfidContainerMapper.addRfidContainer(rfidContainer);
        return rfidContainer;
    }

    /**
     * 替换RFID标签
     * @param rfidBindVO
     * @return
     * @throws Exception
     */
    public RfidContainer replaceRFID(RFIDBindVO rfidBindVO) throws Exception{
        RfidContainer rfidContainer = null;
        if (null==rfidBindVO.getRfidContainerVO()
                ||(StringUtils.isBlank(rfidBindVO.getRfidContainerVO().getLaserCode()) && StringUtils.isBlank(rfidBindVO.getRfidContainerVO().getSynthesisBladeCode()))){
            return rfidContainer;
        }
        rfidContainer = rfidContainerMapper.getRfidContainer(rfidBindVO.getRfidContainerVO());
        if (null ==rfidContainer){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_NOT_EXISTS));
        }
        rfidContainer.setSynthesisBladeCode(rfidBindVO.getRfidContainerVO().getSynthesisBladeCode());
        rfidContainer.setUseCount(rfidContainer.getUseCount()+1);
        rfidContainer.setLabelType(getLabelType(rfidBindVO.getOperationEnum()));
        rfidContainer.setPrevKey(rfidBindVO.getOperationEnum().getKey());
        rfidContainer.setPrevOperation(rfidBindVO.getOperationEnum().getName());
        rfidContainer.setOperatorCode(rfidBindVO.getLoginUser().getCode());
        rfidContainer.setOperatorName(rfidBindVO.getLoginUser().getName());
        rfidContainer.setOperatorTime(new Timestamp(System.currentTimeMillis()));
        rfidContainerMapper.updRfidContainer(rfidContainer);
        return rfidContainer;
    }

    /**
     * 根据标签修改rfid标签状态
     * @param rfidBindVO
     * @return
     * @throws Exception
     */
    public RfidContainer upRFIDStatus(RFIDBindVO rfidBindVO) throws Exception{
        RfidContainer rfidContainer = new RfidContainer();
        if (null==rfidBindVO.getRfidContainerVO()
                ||(StringUtils.isBlank(rfidBindVO.getRfidContainerVO().getLaserCode()) && StringUtils.isBlank(rfidBindVO.getRfidContainerVO().getSynthesisBladeCode()))){
            return rfidContainer;
        }
        rfidContainer = rfidContainerMapper.getRfidContainer(rfidBindVO.getRfidContainerVO());
        if (null == rfidContainer){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_NOT_EXISTS));
        }
        rfidContainer.setPrevKey(rfidBindVO.getOperationEnum().getKey());
        rfidContainer.setPrevOperation(rfidBindVO.getOperationEnum().getName());
        rfidContainer.setOperatorCode(rfidBindVO.getLoginUser().getCode());
        rfidContainer.setOperatorName(rfidBindVO.getLoginUser().getName());
        rfidContainer.setOperatorTime(new Timestamp(System.currentTimeMillis()));
        rfidContainerMapper.updRfidContainer(rfidContainer);
        return rfidContainer;
    }

    /**
     * 解绑rfid标签
     * @param rfidBindVO
     * @throws Exception
     */
    public void unBindRFID(RFIDBindVO rfidBindVO) throws Exception{
        RfidContainer rfidContainer = new RfidContainer();
        if (null==rfidBindVO.getRfidContainerVO()
                ||(StringUtils.isBlank(rfidBindVO.getRfidContainerVO().getLaserCode()) && StringUtils.isBlank(rfidBindVO.getRfidContainerVO().getSynthesisBladeCode()))){
            return;
        }
        rfidContainer = rfidContainerMapper.getRfidContainer(rfidBindVO.getRfidContainerVO());
        if (null == rfidContainer){
            return;
        }
//        rfidContainer.setSynthesisBladeCode("0");
        rfidContainer.setLabelType(0);
        rfidContainer.setPrevKey(rfidBindVO.getOperationEnum().getKey());
        rfidContainer.setPrevOperation(rfidBindVO.getOperationEnum().getName());
        rfidContainer.setOperatorCode(rfidBindVO.getLoginUser().getCode());
        rfidContainer.setOperatorName(rfidBindVO.getLoginUser().getName());
        rfidContainer.setOperatorTime(new Timestamp(System.currentTimeMillis()));
        rfidContainerMapper.updRfidContainer(rfidContainer);
    }

    /**
     * 获取rfid标签的绑定类型
     * @param operationEnum
     * @return
     * @throws Exception
     */
    public Integer getLabelType(OperationEnum operationEnum) throws Exception{

        //判断是否属于合成刀操作
        if (operationEnum.getKey() == OperationEnum.SynthesisCuttingTool_Init.getKey()
                ||operationEnum.getKey() == OperationEnum.SynthesisCuttingTool_UnConfig.getKey()
                ||operationEnum.getKey() == OperationEnum.SynthesisCuttingTool_Exchange.getKey()
                ||operationEnum.getKey() == OperationEnum.SynthesisCuttingTool_UnInstall.getKey()
                ||operationEnum.getKey() == OperationEnum.SynthesisCuttingTool_Install.getKey()
                ||operationEnum.getKey() == OperationEnum.SynthesisCuttingTool_Config.getKey()
                ){
            return RFIDEnum.synthesis_cutting_tool.getKey();
        }

        //判断属于材料刀的操作
        if (operationEnum.getKey() == OperationEnum.Cutting_tool_OutSide.getKey()
                ||operationEnum.getKey() == OperationEnum.Cutting_tool_Inside.getKey()
                ||operationEnum.getKey() == OperationEnum.Cutting_tool_Inside_Coating.getKey()
                ||operationEnum.getKey() == OperationEnum.Cutting_tool_Bind.getKey()
                ||operationEnum.getKey() == OperationEnum.Cutting_tool_scap.getKey()
                ||operationEnum.getKey() == OperationEnum.Cutting_tool_Add_Code.getKey()
                ){
            return RFIDEnum.cutting_tool.getKey();
        }
        //判断属于员工的操作
        if (operationEnum.getKey() == OperationEnum.Employee_code_Init.getKey()){
            return RFIDEnum.employee.getKey();
        }

        //判断属于设备的操作
        if (operationEnum.getKey() == OperationEnum.Equipment_Init.getKey()){
            return RFIDEnum.equipment.getKey();
        }
        return 0;
    }



}
