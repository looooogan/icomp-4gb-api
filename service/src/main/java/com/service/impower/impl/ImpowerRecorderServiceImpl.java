package com.service.impower.impl;


import com.common.constants.ImpowerReasonEnum;
import com.common.constants.OperationEnum;
import com.common.constants.ToolStatusEnum;
import com.common.mapper.IAuthCustomerMapper;
import com.common.mapper.IImpowerRecorderMapper;
import com.common.mapper.IRfidContainerMapper;
import com.common.pojo.AuthCustomer;
import com.common.pojo.ImpowerRecorder;
import com.common.pojo.RfidContainer;
import com.common.vo.AuthCustomerVO;
import com.common.vo.ImpowerRecorderVO;
import com.common.vo.RfidContainerVO;
import com.service.impower.IImpowerRecorderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;


/**
*
* @ClassName ImpowerRecorderServiceImpl
* @Description ImpowerRecorder业务实现类
* @author Jivoin
*/
@Service("impowerRecorderService")
public class ImpowerRecorderServiceImpl implements IImpowerRecorderService{

    @Autowired
    private IImpowerRecorderMapper impowerRecorderMapper;
    @Autowired
    private IAuthCustomerMapper authCustomerMapper;
    @Autowired
    private IRfidContainerMapper rfidContainerMapper;




    /**
    * @Title: addImpowerRecorder
    * @Description: 新增ImpowerRecorder
    * @param impowerRecorder
    * @throws Exception
    * @return: void
    */
    @Override
    public void addImpowerRecorder(ImpowerRecorder impowerRecorder) throws Exception{
        impowerRecorder.setIsDel(0);
        impowerRecorderMapper.addImpowerRecorder(impowerRecorder);
    }

    /**
    * @Title: delImpowerRecorder
    * @Description: 删除ImpowerRecorder
    * @param impowerRecorder
    * @throws Exception
    * @return: void
    */
    @Override
    public void delImpowerRecorder(ImpowerRecorder impowerRecorder) throws Exception{
        impowerRecorderMapper.delImpowerRecorder(impowerRecorder);
    }

    /**
    * @Title: delImpowerRecorderForLogic
    * @Description: 逻辑删除ImpowerRecorder
    * @param impowerRecorder
    * @throws Exception
    * @return: void
    */
    @Override
    public void delImpowerRecorderForLogic(ImpowerRecorder impowerRecorder) throws Exception{
        impowerRecorderMapper.delImpowerRecorderForLogic(impowerRecorder);
    }

    /**
    * @Title: delImpowerRecorderByVo
    * @Description: 根据条件删除ImpowerRecorder
    * @param impowerRecorderVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delImpowerRecorderByVo(ImpowerRecorderVO impowerRecorderVO) throws Exception{
        impowerRecorderMapper.delImpowerRecorderByVo(impowerRecorderVO);
    }

    /**
    * @Title: updImpowerRecorder
    * @Description: 动态更新ImpowerRecorder
    * @param impowerRecorder
    * @throws Exception
    * @return: void
    */
    @Override
    public void updImpowerRecorder(ImpowerRecorder impowerRecorder) throws Exception{
        impowerRecorderMapper.updImpowerRecorder(impowerRecorder);
    }

    /**
    * @Title: getImpowerRecorderByPage
    * @Description: 分页查询
    * @param impowerRecorderVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<ImpowerRecorder> getImpowerRecorderByPage(ImpowerRecorderVO impowerRecorderVO) throws Exception{
        impowerRecorderVO.setTotalPage(impowerRecorderMapper.getImpowerRecorderCount(impowerRecorderVO));
        return impowerRecorderMapper.getImpowerRecorderByPage(impowerRecorderVO);
    }

    /**
    * @Title: getImpowerRecorderCount
    * @Description: 获取记录数量
    * @param impowerRecorderVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getImpowerRecorderCount(ImpowerRecorderVO impowerRecorderVO) throws Exception{
        return impowerRecorderMapper.getImpowerRecorderCount(impowerRecorderVO);
    }

    /**
    * @Title: getImpowerRecorder
    * @Description: 根据查询条件查询
    * @param impowerRecorderVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ImpowerRecorder getImpowerRecorder(ImpowerRecorderVO impowerRecorderVO) throws Exception{
        return impowerRecorderMapper.getImpowerRecorder(impowerRecorderVO);
    }

    @Override
    public void addImpowerRecorders(List<ImpowerRecorder> impowerRecorders) throws Exception {
        if (null == impowerRecorders){
            return;
        }
        for (ImpowerRecorder impowerRecorder : impowerRecorders) {
            AuthCustomerVO operatorVo = new AuthCustomerVO();
            operatorVo.setCode(impowerRecorder.getOperatorUserCode());
            AuthCustomer operatorUser = authCustomerMapper.getAuthCustomer(operatorVo);
            impowerRecorder.setOperatorUserName(operatorUser.getName());

            AuthCustomerVO impowerVo = new AuthCustomerVO();
            impowerVo.setCode(impowerRecorder.getImpowerUser());
            AuthCustomer impowerUser = authCustomerMapper.getAuthCustomer(operatorVo);
            impowerRecorder.setImpowerUserName(impowerUser.getName());

            if (StringUtils.isBlank(impowerRecorder.getOperatorKey())){
                impowerRecorder.setOperatorValue(OperationEnum.getEnumByKey(Integer.parseInt(impowerRecorder.getOperatorKey())).getName());
            }

            RfidContainerVO rfidContainerVO = new RfidContainerVO();
            rfidContainerVO.setCode(impowerRecorder.getRfidLasercode());
            RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
            ImpowerReasonEnum impowerReasonEnum = ImpowerReasonEnum.getImpowerRecorderByOperation(Integer.parseInt(impowerRecorder.getOperatorKey()),rfidContainer.getPrevKey());
            impowerRecorder.setReasonKey(impowerReasonEnum.getReasonKey());
            impowerRecorder.setReasonValue(impowerReasonEnum.getResonValue());
            impowerRecorder.setResume(impowerReasonEnum.getResonValue());
            impowerRecorder.setCurrentStatusName(ToolStatusEnum.getToolStatusEnumByOperationKey(impowerRecorder.getOperatorKey()+"").getName());
            impowerRecorder.setCurrentStatusKey(ToolStatusEnum.getToolStatusEnumByOperationKey(impowerRecorder.getOperatorKey()+"").getKey());

            impowerRecorder.setCreateTime(new Timestamp(System.currentTimeMillis()));
            impowerRecorder.setIsDel(0);
            impowerRecorderMapper.addImpowerRecorder(impowerRecorder);

        }
    }
}
