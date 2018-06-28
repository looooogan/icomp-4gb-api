package com.service.auth.impl;

import com.common.constants.OperationEnum;
import com.common.constants.RFIDEnum;
import com.common.mapper.*;
import com.common.pojo.AuthCustomer;
import com.common.pojo.RfidContainer;
import com.common.utils.MD5;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.AuthCustomerVO;
import com.common.vo.RfidContainerVO;
import com.service.auth.IAuthBusinessService;
import com.service.auth.bo.AuthBO;
import com.service.rfid.RfidModel;
import com.service.rfid.vo.RFIDBindVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by logan on 2018/5/6.
 */
@Service("authService")
public class AuthBusinessServiceImpl implements IAuthBusinessService {


    @Autowired
    private IAuthCustomerMapper customerMapper;
    @Autowired
    private RfidModel rfidModel;

    @Autowired
    private IRfidContainerMapper rfidContainerMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;
    @Autowired
    private IAuthCustomerMapper authCustomerMapper;

    /**
     *
     * @param authCustomerVO 员工信息
     * @return
     * @throws Exception
     */
    @Override
    public AuthCustomer queryAuthCustomerByEmployeeCode(AuthCustomerVO authCustomerVO) throws Exception {
        return customerMapper.getAuthCustomer(authCustomerVO);
    }

    /**
     * 员工初始化
     * @param authBO
     * @throws Exception
     */
    @Override
    public void addInitAuthCustomer(AuthBO authBO) throws Exception {
        RFIDBindVO rfidBindVO = new RFIDBindVO();
        rfidBindVO.setRfidContainerVO(authBO.getAuthCustomerVO().getRfidContainerVO());
        rfidBindVO.setLoginUser(authBO.getLoginUser());
        rfidBindVO.setOperationEnum(OperationEnum.Employee_code_Init);
        RfidContainer rfidContainer = rfidModel.bindRFID(rfidBindVO);

        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authBO.getAuthCustomerVO().getCode());
        AuthCustomer authCustomerTmp = customerMapper.getAuthCustomer(authCustomerVO);
        authCustomerTmp.setRfidContainerCode(rfidContainer.getCode());
        customerMapper.updAuthCustomer(authCustomerTmp);
    }

    /**
     *
     * @param authCustomerVO
     * @return
     * @throws Exception
     */
    @Override
    public AuthCustomer loginForPDA(AuthCustomerVO authCustomerVO) throws Exception {

        if (StringUtils.isBlank(authCustomerVO.getPassword())&&StringUtils.isBlank(authCustomerVO.getRfidContainerVO().getLaserCode())){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.AUTH_CUSTOMER_PARAMERROR));
        }

        AuthCustomerVO loginVo = new AuthCustomerVO();
        AuthCustomer authCustomer = null;
        if (null!=authCustomerVO.getRfidContainerVO()&&!StringUtils.isBlank(authCustomerVO.getRfidContainerVO().getLaserCode())){
            loginVo.setRfidContainerVO(authCustomerVO.getRfidContainerVO());
            authCustomer = authCustomerMapper.getAuthCustomer(loginVo);
            if (null == authCustomer){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.AUTH_CUSTOMER_NOTEXISTS));
            }
            return authCustomer;
        }


        loginVo.setAccount(authCustomerVO.getAccount());
        loginVo.setPassword(MD5.getMD5(authCustomerVO.getPassword()));
        authCustomer = authCustomerMapper.getAuthCustomer(loginVo);
        if (null == authCustomer){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.AUTH_CUSTOMER_NOTEXISTS));
        }
        return authCustomer;
    }
}
