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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by logan on 2018/5/6.
 */
@Service("authService")
public class AuthBusinessServiceImpl implements IAuthBusinessService {


    @Autowired
    private IAuthCustomerMapper customerMapper;

    @Autowired
    private IAuthDepartmentMapper departmentMapper;

    @Autowired
    private IAuthPositionMapper positionMapper;

    @Autowired
    private IAuthAgencyMapper authAgencyMapper;

    @Autowired
    private IAuthAuthorizationMapper authorizationMapper;

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

    @Override
    public void addInitAuthCustomer(AuthCustomer authCustomer) throws Exception {
        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(authCustomer.getRfidContainer().getLaserCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
        if (rfidContainer == null){
            rfidContainer = new RfidContainer();
            rfidContainer.setIsDel(0);
            rfidContainer.setUseCount(1);
            rfidContainer.setCode(UUID.getInstance());
            rfidContainer.setLaserCode(authCustomer.getRfidContainer().getLaserCode());
            rfidContainer.setLabelType(RFIDEnum.employee.getKey());
            rfidContainer.setOperatorCode(OperationEnum.Employee_code_Init.getKey());
            rfidContainer.setOperatorName(OperationEnum.Employee_code_Init.getName());
            rfidContainerMapper.addRfidContainer(rfidContainer);
        }else if (rfidContainer.getOperatorCode()== null || rfidContainer.getOperatorCode()== 0){
            rfidContainer.setPrevKey(rfidContainer.getOperatorCode());
            rfidContainer.setPrevOperation(rfidContainer.getOperatorName());
            rfidContainer.setUseCount(rfidContainer.getUseCount()+1);
            rfidContainer.setLabelType(RFIDEnum.employee.getKey());
            rfidContainer.setOperatorCode(OperationEnum.Employee_code_Init.getKey());
            rfidContainer.setOperatorName(OperationEnum.Employee_code_Init.getName());
            rfidContainerMapper.updRfidContainer(rfidContainer);
        }else {
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_IN_USE));
        }

        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setEmployeeCode(authCustomer.getEmployeeCode());
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
