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
public class FastQueryServiceImpl implements IFastQueryService {
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

    /**
     * 快速查询接口
     * @param fastQueryVO 查询条件封装
     * @return
     * @throws Exception
     */
    @Override
    public FastQueryVO fastQuery(FastQueryVO fastQueryVO) throws Exception {
        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(fastQueryVO.getRfidLaserCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
        if (null==rfidContainer){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_NOT_EXISTS));
        }

        if (rfidContainer.getLabelType().equals(RFIDEnum.employee.getKey())){
            AuthCustomerVO authCustomerVO = new AuthCustomerVO();
            authCustomerVO.setRfidContainerVO(rfidContainerVO);
            fastQueryVO.setAuthCustomer(authCustomerMapper.getAuthCustomer(authCustomerVO));
        }

        if (rfidContainer.getLabelType().equals(RFIDEnum.equipment.getKey())){
            ProductLineEquipmentVO equipmentVO = new ProductLineEquipmentVO();
            equipmentVO.setRfidContainerVO(rfidContainerVO);
            fastQueryVO.setEquipment(equipmentMapper.getProductLineEquipment(equipmentVO));
        }

        if (rfidContainer.getLabelType().equals(RFIDEnum.cutting_tool.getKey())){
            CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
            cuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
            fastQueryVO.setCuttingToolBind(cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO));
        }

        if (rfidContainer.getLabelType().equals(RFIDEnum.synthesis_cutting_tool.getKey())){
            SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
            synthesisCuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
            fastQueryVO.setSynthesisCuttingToolBind(synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO));
        }
        return fastQueryVO;
    }


    /**
     * 为绑定查询标签
     * @param fastQueryVO 查询条件封装
     * @return
     * @throws Exception
     */
    @Override
    public FastQueryVO queryForBind(FastQueryVO fastQueryVO) throws Exception {
        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(fastQueryVO.getRfidLaserCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);

        // null标签正常流程
        if (null==rfidContainer){
            return fastQueryVO;
        }

        if (rfidContainer.getLabelType().equals(RFIDEnum.employee.getKey())){
            AuthCustomerVO authCustomerVO = new AuthCustomerVO();
            authCustomerVO.setRfidContainerVO(rfidContainerVO);
            fastQueryVO.setAuthCustomer(authCustomerMapper.getAuthCustomer(authCustomerVO));
        }

        if (rfidContainer.getLabelType().equals(RFIDEnum.equipment.getKey())){
            ProductLineEquipmentVO equipmentVO = new ProductLineEquipmentVO();
            equipmentVO.setRfidContainerVO(rfidContainerVO);
            fastQueryVO.setEquipment(equipmentMapper.getProductLineEquipment(equipmentVO));
        }

        if (rfidContainer.getLabelType().equals(RFIDEnum.cutting_tool.getKey())){
            CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
            cuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
            fastQueryVO.setCuttingToolBind(cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO));
        }

        if (rfidContainer.getLabelType().equals(RFIDEnum.synthesis_cutting_tool.getKey())){
            SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
            synthesisCuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
            fastQueryVO.setSynthesisCuttingToolBind(synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO));
        }
        return fastQueryVO;
    }
}
