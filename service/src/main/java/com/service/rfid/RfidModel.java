package com.service.rfid;

import com.common.constants.OperationEnum;
import com.common.constants.RFIDEnum;
import com.common.mapper.IAuthCustomerMapper;
import com.common.mapper.IRfidContainerMapper;
import com.common.pojo.AuthCustomer;
import com.common.pojo.RfidContainer;
import com.common.utils.UUID;
import com.common.vo.AuthCustomerVO;
import com.common.vo.RfidContainerVO;
import com.service.rfid.bo.RFIDBO;
import com.service.rfid.vo.RFIDBindVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by logan on 2018/5/29.
 */
@Component("RfidModel")
public class RfidModel {
    @Autowired
    private IRfidContainerMapper rfidContainerMapper;
    @Autowired
    private IAuthCustomerMapper authCustomerMapper;

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
        RfidContainer rfidContainer = new RfidContainer();
        if (StringUtils.isBlank(rfidBindVO.getRfidContainerVO().getLaserCode())){
            return rfidContainer;
        }
        rfidContainer = rfidContainerMapper.getRfidContainer(rfidBindVO.getRfidContainerVO());
        if (null == rfidContainer){
            rfidContainer = new RfidContainer();
            rfidContainer.setIsDel(0);
            rfidContainer.setUseCount(1);
            rfidContainer.setCode(UUID.getInstance());
            rfidContainer.setLaserCode(rfidBindVO.getRfidContainerVO().getLaserCode());
            rfidContainerMapper.addRfidContainer(rfidContainer);
        }
        rfidContainer.setLabelType(getLabelType(rfidBindVO.getOperationEnum()));
        rfidContainer.setPrevKey(rfidBindVO.getOperationEnum().getKey());
        rfidContainer.setPrevOperation(rfidBindVO.getOperationEnum().getName());
        rfidContainer.setOperatorCode(rfidBindVO.getAuthCustomer().getCode());
        rfidContainer.setOperatorName(rfidBindVO.getAuthCustomer().getName());
        rfidContainerMapper.updRfidContainer(rfidContainer);
        return rfidContainer;
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
