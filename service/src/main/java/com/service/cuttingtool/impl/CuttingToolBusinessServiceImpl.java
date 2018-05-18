package com.service.cuttingtool.impl;

import com.common.constants.OperationEnum;
import com.common.constants.RFIDEnum;
import com.common.mapper.ICuttingToolBindMapper;
import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.IRfidContainerMapper;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.RfidContainer;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.RfidContainerVO;
import com.service.cuttingtool.ICuttingToolBusinessService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by logan on 2018/4/30.
 */
@Service("cuttingToolBusiness")
public class CuttingToolBusinessServiceImpl implements ICuttingToolBusinessService{


    @Autowired
    private ICuttingToolBindMapper bindMapper;

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;

    @Autowired
    private IRfidContainerMapper rfidContainerMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;
    /**
     * 获取刀具出库订单列表
     * @return 订单列表
     * @throws Exception
     */
    @Override
    public List getOrderNumList() throws Exception {
        return null;
    }

    /**
     * 根据材料号获取所有未绑定刀具
     * @param cuttingToolBindVO
     * @return
     * @throws Exception
     */
    @Override
    public List<CuttingToolBind> getBindByCode(CuttingToolBindVO cuttingToolBindVO) throws Exception {
        cuttingToolBindVO.setUnbind(1);
        return bindMapper.getCuttingToolBindByPage(cuttingToolBindVO);
    }

    /**
     * 绑定
     * @param cuttingToolBind
     * @throws Exception
     */
    @Override
    public void addBind(CuttingToolBind cuttingToolBind) throws Exception {


        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(cuttingToolBind.getRfidContainer().getLaserCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
        if (rfidContainer == null){
            rfidContainer = new RfidContainer();
            rfidContainer.setIsDel(0);
            rfidContainer.setUseCount(1);
            rfidContainer.setCode(UUID.getInstance());
            rfidContainer.setLaserCode(cuttingToolBind.getRfidContainer().getLaserCode());
            rfidContainer.setLabelType(RFIDEnum.cutting_tool.getKey());
            rfidContainer.setOperatorCode(OperationEnum.Cutting_tool_Bind.getKey());
            rfidContainer.setOperatorName(OperationEnum.Cutting_tool_Bind.getName());
            rfidContainerMapper.addRfidContainer(rfidContainer);
        }else if (rfidContainer.getOperatorCode()==null|| rfidContainer.getOperatorCode() ==0){
            rfidContainer.setPrevKey(rfidContainer.getOperatorCode());
            rfidContainer.setPrevOperation(rfidContainer.getOperatorName());
            rfidContainer.setUseCount(rfidContainer.getUseCount()+1);
            rfidContainer.setLabelType(RFIDEnum.cutting_tool.getKey());
            rfidContainer.setOperatorCode(OperationEnum.Cutting_tool_Bind.getKey());
            rfidContainer.setOperatorName(OperationEnum.Cutting_tool_Bind.getName());
            rfidContainerMapper.updRfidContainer(rfidContainer);
        }else {
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_IN_USE));
        }
        cuttingToolBind.setRfidContainerCode(rfidContainer.getCode());
        bindMapper.updCuttingToolBind(cuttingToolBind);

    }
}
