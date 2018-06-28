package com.service.cuttingtool.impl;

import com.common.constants.CuttingToolConsumeTypeEnum;
import com.common.constants.GrindingEnum;
import com.common.constants.OperationEnum;
import com.common.constants.RFIDEnum;
import com.common.mapper.*;
import com.common.pojo.*;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.*;
import com.service.cuttingtool.ICuttingToolBusinessService;
import com.service.cuttingtool.bo.BindBladeBO;
import com.service.cuttingtool.bo.CuttingToolBindBO;
import com.service.rfid.RfidModel;
import com.service.rfid.vo.RFIDBindVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by logan on 2018/4/30.
 */
@Service("cuttingToolBusiness")
public class CuttingToolBusinessServiceImpl implements ICuttingToolBusinessService{

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;
    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;
    @Autowired
    private RfidModel rfidModel;
    @Autowired
    private ISynthesisCuttingToolConfigMapper configMapper;
    @Autowired
    private ISynthesisCuttingToolLocationConfigMapper locationConfigMapper;
    @Autowired
    private ISynthesisCuttingToolLocationMapper locationMapper;
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
//        cuttingToolBindVO.setUnbind(1);
        return cuttingToolBindMapper.getCuttingToolBindByPage(cuttingToolBindVO);
    }

    /**
     * 材料刀具绑定
     * @param cuttingToolBind
     * @throws Exception
     */
    @Override
    public void addBindOld(CuttingToolBind cuttingToolBind) throws Exception {
        //代码替换，旧版本有错误  注释

//        RfidContainerVO rfidContainerVO = new RfidContainerVO();
//        rfidContainerVO.setLaserCode(cuttingToolBind.getRfidContainer().getLaserCode());
//        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
//        if (rfidContainer == null){
//            rfidContainer = new RfidContainer();
//            rfidContainer.setIsDel(0);
//            rfidContainer.setUseCount(1);
//            rfidContainer.setCode(UUID.getInstance());
//            rfidContainer.setLaserCode(cuttingToolBind.getRfidContainer().getLaserCode());
//            rfidContainer.setLabelType(RFIDEnum.cutting_tool.getKey());
//            rfidContainer.setOperatorCode(OperationEnum.Cutting_tool_Bind.getKey());
//            rfidContainer.setOperatorName(OperationEnum.Cutting_tool_Bind.getName());
//            rfidContainerMapper.addRfidContainer(rfidContainer);
//        }else if (rfidContainer.getOperatorCode()==null|| rfidContainer.getOperatorCode() ==0){
//            rfidContainer.setPrevKey(rfidContainer.getOperatorCode());
//            rfidContainer.setPrevOperation(rfidContainer.getOperatorName());
//            rfidContainer.setUseCount(rfidContainer.getUseCount()+1);
//            rfidContainer.setLabelType(RFIDEnum.cutting_tool.getKey());
//            rfidContainer.setOperatorCode(OperationEnum.Cutting_tool_Bind.getKey());
//            rfidContainer.setOperatorName(OperationEnum.Cutting_tool_Bind.getName());
//            rfidContainerMapper.updRfidContainer(rfidContainer);
//        }else {
//            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_IN_USE));
//        }
//        cuttingToolBind.setRfidContainerCode(rfidContainer.getCode());
//        bindMapper.updCuttingToolBind(cuttingToolBind);

    }

    /**
     * 刀具绑定 0609
     * @param cuttingToolBind
     * @param authCustomer
     * @throws Exception
     */
    @Override
    public void addBind0609(CuttingToolBind cuttingToolBind, AuthCustomer authCustomer) throws Exception {

        //处理标签
        RFIDBindVO rfidBindVO = new RFIDBindVO();
        rfidBindVO.setLoginUser(authCustomer);
        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(cuttingToolBind.getRfidContainer().getLaserCode());
        rfidBindVO.setOperationEnum(OperationEnum.Cutting_tool_Bind);
        RfidContainer rfidContainer = rfidModel.bindRFID(rfidBindVO);

        //绑定
        CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
        cuttingToolBindVO.setBladeCode(cuttingToolBind.getBladeCode());
        CuttingToolBind cuttingToolBindTmp = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
        //如果已经存在则更新绑定
        if (null != cuttingToolBindTmp){
            cuttingToolBindTmp.setRfidContainer(rfidContainer);
            cuttingToolBindMapper.updCuttingToolBind(cuttingToolBindTmp);
        }
        //新增刀具绑定信息
        cuttingToolBindMapper.addCuttingToolBind(cuttingToolBind);
    }

    /**
     * 查询刀具绑定信息
     * @param cuttingToolBindBO 查询条件封装
     * @return
     * @throws Exception
     */
    @Override
    public CuttingToolBind queryBindInfo(CuttingToolBindBO cuttingToolBindBO) throws Exception {
        CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
        //根据RFID标签查询
        if (null!=cuttingToolBindBO.getRfidContainerVO()&&!StringUtils.isBlank(cuttingToolBindBO.getRfidContainerVO().getLaserCode())){
            cuttingToolBindVO.setRfidContainerVO(cuttingToolBindBO.getRfidContainerVO());
        }
        //根据刀身码查询
        if (!StringUtils.isBlank(cuttingToolBindBO.getBladeCode())){
            cuttingToolBindVO.setBladeCode(cuttingToolBindBO.getBladeCode());
        }
        return cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
    }

    /**
     * 根据合成刀T号查询材刀信息
     * @param synthesisCuttingToolVO
     * @throws Exception
     */
    @Override
    public List<CuttingTool> queryByTCode(SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception {
        List<CuttingTool> cuttingToolList = new ArrayList<>();
        //查询合成刀配置信息
        SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO = new SynthesisCuttingToolConfigVO();
        synthesisCuttingToolConfigVO.setSynthesisCuttingToolVO(synthesisCuttingToolVO);
        SynthesisCuttingToolConfig config = configMapper.getSynthesisCuttingToolConfig(synthesisCuttingToolConfigVO);
        SynthesisCuttingToolLocationConfigVO locationConfigVO = new SynthesisCuttingToolLocationConfigVO();
        locationConfigVO.setSynthesisCuttingToolConfigId(config.getId());
        List<SynthesisCuttingToolLocationConfig> locationConfigs = locationConfigMapper.getSynthesisCuttingToolLocationConfigByPage(locationConfigVO);

        for (SynthesisCuttingToolLocationConfig locationConfig : locationConfigs) {
            if (checkType(locationConfig.getCuttingTool())){
                cuttingToolList.add(locationConfig.getCuttingTool());
            }
            if (null!=locationConfig.getReplaceCuttingTool1()){
                if (checkType(locationConfig.getReplaceCuttingTool1())){
                    cuttingToolList.add(locationConfig.getReplaceCuttingTool1());
                }
            }
            if (null!=locationConfig.getReplaceCuttingTool2()){
                if (checkType(locationConfig.getReplaceCuttingTool2())){
                    cuttingToolList.add(locationConfig.getReplaceCuttingTool2());
                }
            }
        }
        return cuttingToolList;
    }

    /**
     * 校验刀具类型
     * @param cuttingTool 材料刀
     * @return
     * @throws Exception
     */
    public boolean checkType(CuttingTool cuttingTool) throws Exception{
        boolean flag = false;
        if (cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_zt.getKey())){
            flag = true;
        }
        return flag;
    }

    /**
     * 流转刀具绑定
     * @param cuttingToolBindBO
     * @throws Exception
     */
    @Override
    public void bindRunningData(CuttingToolBindBO cuttingToolBindBO) throws Exception {
        CuttingToolVO cuttingToolVO = new CuttingToolVO();
        cuttingToolVO.setCode(cuttingToolBindBO.getCuttingToolBind().getCuttingTool().getCode());
        CuttingTool cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
        //判断刀身码是否已经存在
        CuttingToolBindVO cuttingToolBindVOTmp = new CuttingToolBindVO();
        cuttingToolBindVOTmp.setBladeCode(cuttingTool.getBusinessCode()+"-"+cuttingToolBindBO.getCuttingToolBind().getBladeCode());
        CuttingToolBind cuttingToolBindTmp = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVOTmp);
        if (null != cuttingToolBindTmp){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESIS_BIND_EXISTS));
        }
        //执行绑定
        RFIDBindVO rfidBindVO = new RFIDBindVO();
        rfidBindVO.setLoginUser(cuttingToolBindBO.getLoginUser());
        rfidBindVO.setOperationEnum(OperationEnum.Cutting_tool_Bind);
        rfidBindVO.setRfidContainerVO(cuttingToolBindBO.getRfidContainerVO());
        RfidContainer rfidContainer = rfidModel.bindRFID(rfidBindVO);

        CuttingToolBind cuttingToolBind = new CuttingToolBind();
        cuttingToolBind.setCuttingToolCode(cuttingTool.getCode());
        cuttingToolBind.setBladeCode(cuttingTool.getBusinessCode()+"-"+cuttingToolBindBO.getCuttingToolBind().getBladeCode());
        cuttingToolBind.setCode(UUID.getInstance());
        cuttingToolBind.setLltm("");
        cuttingToolBind.setIsDel(0);
        cuttingToolBind.setRfidContainerCode(rfidContainer.getCode());
        cuttingToolBindMapper.addCuttingToolBind(cuttingToolBind);
        cuttingToolBindBO.setCuttingToolBind(cuttingToolBind);
    }

    /**
     * 补充刀身码
     * @param bindBladeBO
     * @throws Exception
     */
    @Override
    public void bindBladeData(BindBladeBO bindBladeBO) throws Exception {
        if (null != bindBladeBO.getCuttingToolBind()){
            CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
            cuttingToolBindVO.setCode(bindBladeBO.getCuttingToolBind().getCode());
            CuttingToolBind cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
            cuttingToolBind.setBladeCode(bindBladeBO.getCuttingToolBind().getBladeCode());
            cuttingToolBind.setCuttingToolCode(bindBladeBO.getCuttingToolBind().getCuttingToolCode());
            cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
        }
        if (null!=bindBladeBO.getLocation()){
            SynthesisCuttingToolLocationVO locationVO = new SynthesisCuttingToolLocationVO();
            locationVO.setId(bindBladeBO.getLocation().getId());
            SynthesisCuttingToolLocation location = locationMapper.getSynthesisCuttingToolLocation(locationVO);
            location.setCuttingToolBladeCode(bindBladeBO.getLocation().getCuttingToolBladeCode());
            location.setCuttingToolCode(bindBladeBO.getLocation().getCuttingToolCode());
            locationMapper.updSynthesisCuttingToolLocation(location);
        }
        if (null == bindBladeBO.getCuttingToolBind()){
            SynthesisCuttingToolLocationVO locationVO = new SynthesisCuttingToolLocationVO();
            locationVO.setId(bindBladeBO.getLocation().getId());
            SynthesisCuttingToolLocation location = locationMapper.getSynthesisCuttingToolLocation(locationVO);
            CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
            cuttingToolBindVO.setBladeCode(bindBladeBO.getLocation().getCuttingToolBladeCode());
            CuttingToolBind cuttingToolBindTmp = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
            if (cuttingToolBindTmp!=null){
                return;
            }
            CuttingToolBind cuttingToolBind = new CuttingToolBind();
            cuttingToolBind.setIsDel(0);
            cuttingToolBind.setLhcs(1);
            cuttingToolBind.setJgsm(0);
            cuttingToolBind.setSharpenTimes(0);
            cuttingToolBind.setBladeCode(location.getCuttingToolBladeCode());
            cuttingToolBind.setJgcs(0);
            cuttingToolBind.setCode(UUID.getInstance());
            cuttingToolBind.setCuttingToolCode(location.getCuttingToolCode());
            cuttingToolBind.setQimingSharpenTimes(0);
            cuttingToolBindMapper.addCuttingToolBind(cuttingToolBind);
        }

    }
}
