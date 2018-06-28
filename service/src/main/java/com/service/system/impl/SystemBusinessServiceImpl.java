package com.service.system.impl;

import com.common.constants.OperationEnum;
import com.common.constants.RFIDEnum;
import com.common.mapper.*;
import com.common.pojo.*;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.*;
import com.service.rfid.RfidModel;
import com.service.rfid.vo.RFIDBindVO;
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
    @Autowired
    private IAuthCustomerMapper authCustomerMapper;
    @Autowired
    private RfidModel rfidModel;


    @Override
    public void chagneRFIDData(ChangeRFIDVO changeRFIDVO) throws Exception {
        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(changeRFIDVO.getNewLaserCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
        if (null!= rfidContainer &&rfidContainer.getPrevKey() != OperationEnum.RFID_Clear.getKey()){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_IN_USE));
        }
        RfidContainerVO oldVO = new RfidContainerVO();
        oldVO.setLaserCode(changeRFIDVO.getLaserCode());
        RfidContainer old = rfidContainerMapper.getRfidContainer(oldVO);
        old.setLaserCode(changeRFIDVO.getNewLaserCode());
        rfidContainerMapper.updRfidContainer(old);
    }

    @Override
    public void clearRFIDData(RFIDQueryVO rfidQueryVO) throws Exception {

        AuthCustomerVO loginVO = new AuthCustomerVO();
        loginVO.setCode(rfidQueryVO.getLoginUser().getCode());
        AuthCustomer loginUser = authCustomerMapper.getAuthCustomer(loginVO);


        for (RfidContainerVO rfidContainerVO : rfidQueryVO.getRfidContainerVOList()) {
            rfidContainerVO.setLaserCode(rfidQueryVO.getRfidCode());
            RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
            if (null == rfidContainer){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_NOT_EXISTS));
            }
            do {
                SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
                synthesisCuttingToolBindVO.setRfidContainerCode(rfidContainer.getCode());
                SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);
                if (null!=synthesisCuttingToolBind){
                    synthesisCuttingToolBind.setRfidContainerCode("0");
                    synthesisCuttingToolBindMapper.clearRFIDData(synthesisCuttingToolBind);
                }
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setRfidContainerCode(rfidContainer.getCode());
                CuttingToolBind cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
                if (null!=cuttingToolBind){
                    cuttingToolBind.setRfidContainerCode("0");
                    cuttingToolBindMapper.clearRFIDData(cuttingToolBind);
                }

                ProductLineEquipmentVO equipmentVO = new ProductLineEquipmentVO();
                equipmentVO.setRfidContainerCode(rfidContainer.getCode());
                ProductLineEquipment equipment = equipmentMapper.getProductLineEquipment(equipmentVO);
                if (null!=equipment){
                    equipment.setRfidContainerCode(null);
                    equipmentMapper.clearRFIDData(equipment);
                }

                AuthCustomerVO authCustomerVO = new AuthCustomerVO();
                authCustomerVO.setRfidContainerCode(rfidContainer.getCode());
                AuthCustomer authCustomer = authCustomerMapper.getAuthCustomer(authCustomerVO);
                if (null!=authCustomer){
                    authCustomer.setRfidContainerCode("0");
                    authCustomerMapper.clearRFIDData(authCustomer);
                }
                rfidContainerMapper.delRfidContainerForLogic(rfidContainer);
            }while (false);
//            RFIDBindVO rfidBindVO = new RFIDBindVO();
//            rfidBindVO.setLoginUser(loginUser);
//            rfidBindVO.setOperationEnum(OperationEnum.RFID_Clear);
//            rfidBindVO.setRfidContainerVO(rfidContainerVO);
//            rfidModel.unBindRFID(rfidBindVO);
        }
    }

    /**
     * 快速查询
     * @param rfidQueryVO
     * @return
     * @throws Exception
     */
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

        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setRfidContainerVO(rfidContainerVO);
        AuthCustomer authCustomer = authCustomerMapper.getAuthCustomer(authCustomerVO);
        if (null != authCustomer){
            returnRFIDQueryVO.setAuthCustomer(authCustomer);
        }

        return returnRFIDQueryVO;
    }
}
