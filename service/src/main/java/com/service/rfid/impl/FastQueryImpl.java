package com.service.rfid.impl;

import com.common.constants.RFIDEnum;
import com.common.mapper.*;
import com.common.pojo.RfidContainer;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.*;
import com.service.rfid.IFastQueryService;
import com.service.rfid.vo.FastQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by logan on 2018/5/27.
 */
@Service("fastQuery")
public class FastQueryImpl implements IFastQueryService {
    @Autowired
    private IRfidContainerMapper rfidContainerMapper;
    @Autowired
    private IAuthCustomerMapper authCustomerMapper;
    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;
    @Autowired
    private ISynthesisCuttingToolBindMapper synthesisCuttingToolBindMapper;
    @Autowired
    private IProductLineEquipmentMapper equipmentMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;

    @Override
    public FastQueryVO fastQuery(FastQueryVO fastQueryVO) throws Exception {
        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(fastQueryVO.getRfidLaserCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
        if (null==rfidContainer){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_NOT_EXISTS));
        }

        if (rfidContainer.getBindType().equals(RFIDEnum.employee.getKey())){
            AuthCustomerVO authCustomerVO = new AuthCustomerVO();
            authCustomerVO.setRfidContainerVO(rfidContainerVO);
            fastQueryVO.setAuthCustomer(authCustomerMapper.getAuthCustomer(authCustomerVO));
        }

        if (rfidContainer.getBindType().equals(RFIDEnum.equipment.getKey())){
            ProductLineEquipmentVO equipmentVO = new ProductLineEquipmentVO();
            equipmentVO.setRfidContainerVO(rfidContainerVO);
            fastQueryVO.setEquipment(equipmentMapper.getProductLineEquipment(equipmentVO));
        }

        if (rfidContainer.getBindType().equals(RFIDEnum.cutting_tool.getKey())){
            CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
            cuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
            fastQueryVO.setCuttingToolBind(cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO));
        }

        if (rfidContainer.getBindType().equals(RFIDEnum.synthesis_cutting_tool.getKey())){
            SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
            synthesisCuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
            fastQueryVO.setSynthesisCuttingToolBind(synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO));
        }
        return fastQueryVO;
    }
}
