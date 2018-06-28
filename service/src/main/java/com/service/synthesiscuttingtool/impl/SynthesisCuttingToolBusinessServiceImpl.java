package com.service.synthesiscuttingtool.impl;

import com.common.constants.*;
import com.common.mapper.*;
import com.common.pojo.*;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.*;
import com.service.cuttingtool.CuttingToolModel;
import com.service.cuttingtool.bo.CuttingToolBindBO;
import com.service.materialInventory.MaterialInventoryModel;
import com.service.materialInventory.SynthesisInventoryModel;
import com.service.materialInventory.bo.MaterialInventoryBO;
import com.service.materialInventory.bo.SynthesisMaterialInventoryBO;
import com.service.rfid.RfidModel;
import com.service.rfid.vo.RFIDBindVO;
import com.service.synthesiscuttingtool.BladeModel;
import com.service.synthesiscuttingtool.ISynthesisCuttingToolBusinessService;
import com.service.synthesiscuttingtool.SynthesisExchangeModel;
import com.service.synthesiscuttingtool.bo.ExchangeRecordersBO;
import com.service.synthesiscuttingtool.bo.SynthesisExchangeBO;
import com.service.synthesiscuttingtool.bo.SynthesisInitBO;
import com.service.synthesiscuttingtool.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by logan on 2018/4/29.
 */
@Service("synthesisCuttingToolBusinessService")
public class SynthesisCuttingToolBusinessServiceImpl implements ISynthesisCuttingToolBusinessService{

    @Autowired
    private ISynthesisCuttingToolMapper synthesisCuttingToolMapper;
    @Autowired
    private ISynthesisCuttingToolConfigMapper synthesisCuttingToolConfigMapper;
    @Autowired
    private ISynthesisCuttingToolLocationConfigMapper synthesisCuttingToolLocationConfigMapper;
    @Autowired
    private ISynthesisCuttingToolBindMapper synthesisCuttingToolBindMapper;
    @Autowired
    private ISynthesisCuttingToolLocationMapper synthesisCuttingToolLocationMapper;
    @Autowired
    private IRfidContainerMapper rfidContainerMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;
    @Autowired
    private RfidModel rfidModel;
    @Autowired
    private SynthesisInventoryModel synthesisInventoryModel;
    @Autowired
    private MaterialInventoryModel materialInventoryModel;
    @Autowired
    private SynthesisExchangeModel exchangeModel;
    @Autowired
    private CuttingToolModel cuttingToolModel;
    @Autowired
    private BladeModel bladeModel;


    /**
     * 获取合成刀配置
     * @param synthesisInitBO 查询条件
     * @return 合成刀配置
     * @throws Exception
     */
    @Override
    public SynthesisCuttingToolConfig getSynthesisCuttingToolForInit(SynthesisInitBO synthesisInitBO) throws Exception {
        SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO = new SynthesisCuttingToolConfigVO();

        //根据RFID标签查询合成刀配置
        if (null!=synthesisInitBO.getRfidContainerVO()&&!StringUtils.isBlank(synthesisInitBO.getRfidContainerVO().getLaserCode())){
            RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(synthesisInitBO.getRfidContainerVO());
            if (null == rfidContainer){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_NOT_EXISTS));
            }
            SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
            synthesisCuttingToolBindVO.setRfidContainerVO(synthesisInitBO.getRfidContainerVO());
            SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);
            if(null == synthesisCuttingToolBind){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_NOT_EXISTS));
            }
            synthesisCuttingToolConfigVO.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
        }

        //根据合成刀T号查询合成刀配置
        if (!StringUtils.isBlank(synthesisInitBO.getSynthesisCode())){
            SynthesisCuttingToolVO synthesisCuttingToolVO = new SynthesisCuttingToolVO();
            synthesisCuttingToolVO.setSynthesisCode(synthesisInitBO.getSynthesisCode());
            SynthesisCuttingTool synthesisCuttingTool = synthesisCuttingToolMapper.getSynthesisCuttingTool(synthesisCuttingToolVO);
            if(null == synthesisCuttingTool){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_NOT_EXISTS));
            }
            synthesisCuttingToolConfigVO.setSynthesisCuttingToolCode(synthesisCuttingTool.getCode());
        }

        //根据合成刀刀身码查询合成刀配置
        if (null!=synthesisInitBO.getRfidContainerVO()&&!StringUtils.isBlank(synthesisInitBO.getRfidContainerVO().getSynthesisBladeCode())){
            SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
            synthesisCuttingToolBindVO.setRfidContainerVO(synthesisInitBO.getRfidContainerVO());
            SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);
            if(null == synthesisCuttingToolBind.getSynthesisCuttingTool()){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_NOT_EXISTS));
            }
            synthesisCuttingToolConfigVO.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingTool().getCode());
        }

        SynthesisCuttingToolConfig synthesisCuttingToolConfig = synthesisCuttingToolConfigMapper.getSynthesisCuttingToolConfig(synthesisCuttingToolConfigVO);
        if (null == synthesisCuttingToolConfig){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_CONFIG_NOT_EXISTS));
        }
        SynthesisCuttingToolLocationConfigVO locationConfigVO = new SynthesisCuttingToolLocationConfigVO();
        locationConfigVO.setSynthesisCuttingToolConfigId(synthesisCuttingToolConfig.getId());
        synthesisCuttingToolConfig.setSynthesisCuttingToolLocationConfigList(synthesisCuttingToolLocationConfigMapper.getSynthesisCuttingToolLocationConfigByPage(locationConfigVO));

        return synthesisCuttingToolConfig;
    }

    /**
     * 查询合成刀绑定信息
     * @param synthesisExchangeBO 查询条件
     * @return
     * @throws Exception
     */
    @Override
    public SynthesisCuttingToolBind getSynthesisCuttingBind(SynthesisExchangeBO synthesisExchangeBO) throws Exception {
        SynthesisCuttingToolBind synthesisCuttingToolBind = null;
        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
        //根据RFID标签查询合成刀绑定信息
        if (null!=synthesisExchangeBO.getRfidContainerVO()&&!StringUtils.isBlank(synthesisExchangeBO.getRfidContainerVO().getLaserCode())){
            synthesisCuttingToolBindVO.setRfidContainerVO(synthesisExchangeBO.getRfidContainerVO());
        }

        //根据合成刀T号查询合成刀绑定信息
        if (!StringUtils.isBlank(synthesisExchangeBO.getSynthesisCode())){
            synthesisCuttingToolBindVO.setSynthesisCode(synthesisExchangeBO.getSynthesisCode());
        }

        //根据合成刀刀身码查询合成刀绑定信息
        if (null!=synthesisExchangeBO.getRfidContainerVO()&&!StringUtils.isBlank(synthesisExchangeBO.getRfidContainerVO().getSynthesisBladeCode())){
            synthesisCuttingToolBindVO.setRfidContainerVO(synthesisExchangeBO.getRfidContainerVO());
        }
        //查询合成刀绑定信息
        synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);
        if (null == synthesisCuttingToolBind){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESIS_BIND_NOTEXISTS));
        }
        //查询合成刀组装信息
        SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO = new SynthesisCuttingToolLocationVO();
        synthesisCuttingToolLocationVO.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
        List<SynthesisCuttingToolLocation> locations = synthesisCuttingToolLocationMapper.getSynthesisCuttingToolLocationByPage(synthesisCuttingToolLocationVO);
        synthesisCuttingToolBind.setSynthesisCuttingToolLocationList(locations);
        return synthesisCuttingToolBind;
    }

    /**
     * 合成刀初始化
     * @param synthesisInitBO 初始化参数
     * @throws Exception
     */
    @Override
    public void addInitSynthesisCuttingTool(SynthesisInitBO synthesisInitBO) throws Exception {

        if (null == synthesisInitBO.getSynthesisCuttingToolBindVOS()
                ||synthesisInitBO.getSynthesisCuttingToolBindVOS().size()<=0){
            return;
        }
        //查询合成刀信息
        SynthesisCuttingToolVO synthesisCuttingToolVO = new SynthesisCuttingToolVO();
        synthesisCuttingToolVO.setSynthesisCode(synthesisInitBO.getSynthesisCuttingToolBindVOS().get(0).getSynthesisCode());
        SynthesisCuttingTool synthesisCuttingTool = synthesisCuttingToolMapper.getSynthesisCuttingTool(synthesisCuttingToolVO);


        //进行合刀绑定
        RFIDBindVO rfidBindVO = null;
        RfidContainer rfidContainer = null;
        RfidContainer rfidContainerTmp = null;
        SynthesisCuttingToolBind synthesisCuttingToolBind = null;
        SynthesisCuttingToolLocation synthesisCuttingToolLocation = null;
        SynthesisCuttingToolBindVO queryBindVO = null;
        SynthesisCuttingToolBind queryBind = null;
        for (SynthesisCuttingToolBindVO synthesisCuttingToolBindVO : synthesisInitBO.getSynthesisCuttingToolBindVOS()) {

            if (!StringUtils.isBlank(synthesisCuttingToolBindVO.getRfidContainerVO().getSynthesisBladeCode())){
                //处理合成刀刀身码
                SynthesisBladeCodeVO synthesisBladeCodeVO = new SynthesisBladeCodeVO();
                synthesisBladeCodeVO.setSynthesisCuttingToolCode(synthesisCuttingTool.getCode());
                synthesisBladeCodeVO.setBladeCode(synthesisCuttingToolBindVO.getRfidContainerVO().getSynthesisBladeCode());
                bladeModel.checkBladeCode(synthesisBladeCodeVO);
            }


            //处理rfid标签信息
            rfidBindVO = new RFIDBindVO();
            rfidBindVO.setLoginUser(synthesisInitBO.getLoginUser());
            rfidBindVO.setOperationEnum(OperationEnum.SynthesisCuttingTool_Init);
            rfidBindVO.setRfidContainerVO(synthesisCuttingToolBindVO.getRfidContainerVO());
            rfidContainer = rfidModel.bindRFID(rfidBindVO);

            //创建合成刀绑定信息
            synthesisCuttingToolBind = new SynthesisCuttingToolBind();
            //判断刀身码是否存在，存在则提示用户
            if (!StringUtils.isBlank(synthesisCuttingToolBindVO.getBladeCode())){
                queryBindVO = new SynthesisCuttingToolBindVO();
                queryBindVO.setBladeCode(synthesisCuttingToolBindVO.getBladeCode());
                queryBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(queryBindVO);
                if (null!= queryBind){
                    throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESIS_BIND_EXISTS));
                }
            }

            if (null != rfidContainer){
                synthesisCuttingToolBind.setRfidContainerCode(rfidContainer.getCode());
            }
            if (!StringUtils.isBlank(synthesisCuttingToolBindVO.getBladeCode())){
                synthesisCuttingToolBind.setBladeCode(synthesisCuttingToolBindVO.getBladeCode());
            }
            synthesisCuttingToolBind.setSynthesisCuttingToolCode(synthesisCuttingTool.getCode());
            synthesisCuttingToolBind.setSynthesisCode(synthesisCuttingTool.getSynthesisCode());
            synthesisCuttingToolBind.setIsDel(0);
            synthesisCuttingToolBind.setCreateTime(new Timestamp(System.currentTimeMillis()));
            synthesisCuttingToolBind.setCode(UUID.getInstance());
            synthesisCuttingToolBindMapper.addSynthesisCuttingToolBind(synthesisCuttingToolBind);


            SynthesisCuttingToolConfigVO configVO = new SynthesisCuttingToolConfigVO();
            configVO.setSynthesisCuttingToolCode(synthesisCuttingTool.getCode());
            SynthesisCuttingToolLocationConfigVO locationConfigVO = new SynthesisCuttingToolLocationConfigVO();
            locationConfigVO.setSynthesisCuttingToolConfigVO(configVO);

            List<SynthesisCuttingToolLocationConfig> locationConfigList = synthesisCuttingToolLocationConfigMapper.getSynthesisCuttingToolLocationConfigByPage(locationConfigVO);

            //添加合成刀上的材料刀具组装记录
            for (SynthesisCuttingToolLocationConfig locationConfig : locationConfigList) {
                synthesisCuttingToolLocation = new SynthesisCuttingToolLocation();
                synthesisCuttingToolLocation.setIsDel(0);
                synthesisCuttingToolLocation.setSynthesisCuttingToolCode(synthesisCuttingTool.getCode());
                synthesisCuttingToolLocation.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
                synthesisCuttingToolLocation.setCuttingToolCode(locationConfig.getCuttingToolCode());
                synthesisCuttingToolLocation.setCount(locationConfig.getCount());
//                synthesisCuttingToolLocation.setCuttingToolBladeCode(locationConfig.getCuttingToolBladeCode());
                synthesisCuttingToolLocationMapper.addSynthesisCuttingToolLocation(synthesisCuttingToolLocation);
            }
        }
        //更新合成刀库存
        SynthesisMaterialInventoryBO synthesisMaterialInventoryBO = new SynthesisMaterialInventoryBO();
        synthesisMaterialInventoryBO.setSynthesisCuttingTool(synthesisCuttingTool);
        synthesisMaterialInventoryBO.setSynthesisCuttingToolBindVOS(synthesisInitBO.getSynthesisCuttingToolBindVOS());
        synthesisInventoryModel.updateInventoryForInit(synthesisMaterialInventoryBO);
    }

    /**
     * 合成刀换装
     * @param synthesisExchangeBO 换装信息
     * @throws Exception
     */
    @Override
    public void exChangeData(SynthesisExchangeBO synthesisExchangeBO) throws Exception {
        //查询合成刀绑定信息
        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = synthesisExchangeBO.getSynthesisCuttingToolBindVO();
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);

        /**根据换装结果修改组装信息 开始**/
        SynthesisCuttingToolLocationVO LocationVO = null;
        SynthesisCuttingToolLocation location = null;
        //修改换下刀具的数量
        for (DownCuttingToolVO downCuttingToolVO : synthesisExchangeBO.getDownCuttingToolVOS()) {
            LocationVO = new SynthesisCuttingToolLocationVO();
            LocationVO.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
            if (StringUtils.isBlank(downCuttingToolVO.getBladeCode())){
                LocationVO.setCuttingToolBladeCode(downCuttingToolVO.getBladeCode());
            }
            LocationVO.setCuttingToolCode(downCuttingToolVO.getDownCode());
            location = synthesisCuttingToolLocationMapper.getSynthesisCuttingToolLocation(LocationVO);

            if (downCuttingToolVO.getDownCount() == location.getCount()){
                //如果全部换装，删除该条记录
                synthesisCuttingToolLocationMapper.delSynthesisCuttingToolLocation(location);
            }else{
                //部分换装修改数量
//                location.setCount(location.getCount()-downCuttingToolVO.getDownCount());
//                synthesisCuttingToolLocationMapper.updSynthesisCuttingToolLocation(location);
            }
        }
        //修改换上刀具的数量
        for (UpCuttingToolVO upCuttingToolVO : synthesisExchangeBO.getUpCuttingToolVOS()) {
            LocationVO = new SynthesisCuttingToolLocationVO();
            LocationVO.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
            if (StringUtils.isBlank(upCuttingToolVO.getBladeCode())){
                LocationVO.setCuttingToolBladeCode(upCuttingToolVO.getBladeCode());
            }
            LocationVO.setCuttingToolCode(upCuttingToolVO.getUpCode());
            location = synthesisCuttingToolLocationMapper.getSynthesisCuttingToolLocation(LocationVO);
            if (null == location){
                location = new SynthesisCuttingToolLocation();
                location.setIsDel(0);
                location.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingTool().getCode());
                location.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
                location.setCuttingToolCode(upCuttingToolVO.getUpCode());
                location.setCount(upCuttingToolVO.getUpCount());
                if (!StringUtils.isBlank(upCuttingToolVO.getBladeCode())){
                    location.setCuttingToolBladeCode(upCuttingToolVO.getBladeCode());
                }
                synthesisCuttingToolLocationMapper.addSynthesisCuttingToolLocation(location);
            }else{
//                location.setCount(upCuttingToolVO.getUpCount());
//                synthesisCuttingToolLocationMapper.updSynthesisCuttingToolLocation(location);
            }
        }
        //修改合成刀刀具库存
        SynthesisMaterialInventoryBO synthesisMaterialInventoryBO = new SynthesisMaterialInventoryBO();
        synthesisMaterialInventoryBO.setSynthesisCuttingTool(synthesisCuttingToolBind.getSynthesisCuttingTool());
        synthesisMaterialInventoryBO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        synthesisInventoryModel.updateInventoryForExchange(synthesisMaterialInventoryBO);

        //修改换上材料刀库存
        MaterialInventoryBO materialInventoryBO = new MaterialInventoryBO();
        materialInventoryBO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
//        materialInventoryBO.setUpCuttingToolVOS(synthesisExchangeBO.getUpCuttingToolVOS());
//        materialInventoryModel.updateInventoryForUpExchange(materialInventoryBO);
        //修改换下材料刀库存
        //todo  丢到直接报废
        materialInventoryBO.setDownCuttingToolVOS(synthesisExchangeBO.getDownCuttingToolVOS());
        materialInventoryModel.updateInventoryForDownExchange(materialInventoryBO);
        //换上材刀解绑rfid
        CuttingToolBindBO cuttingToolBindBO = new CuttingToolBindBO();
        cuttingToolBindBO.setLoginUser(synthesisExchangeBO.getLoginUser());
        cuttingToolBindBO.setUpCuttingToolVOS(synthesisExchangeBO.getUpCuttingToolVOS());
        cuttingToolModel.unBindRFID(cuttingToolBindBO);
        //换下材料刀绑定rfid
        cuttingToolBindBO.setDownCuttingToolVOS(synthesisExchangeBO.getDownCuttingToolVOS());
        cuttingToolModel.bindRFIDForExchange(cuttingToolBindBO);
        //添加换装记录
        ExchangeRecordersBO exchangeRecordersBO = new ExchangeRecordersBO();
        exchangeRecordersBO.setSynthesisCuttingToolBind(synthesisCuttingToolBind);
        exchangeModel.addExchangeRecorders(exchangeRecordersBO);

        //修改合成刀的rfid标签状态
        RFIDBindVO sRFIDBindVO = new RFIDBindVO();
        sRFIDBindVO.setLoginUser(synthesisExchangeBO.getLoginUser());
        sRFIDBindVO.setOperationEnum(OperationEnum.SynthesisCuttingTool_Exchange);
        sRFIDBindVO.setRfidContainerVO(synthesisCuttingToolBindVO.getRfidContainerVO());
        rfidModel.upRFIDStatus(sRFIDBindVO);

    }


    /**
     * 刀具拆分
     * @param breakUpVO 拆分内容
     * @throws Exception
     */
    /*@Override
    public void writeSynthesisCuttingToolBreakUp(BreakUpVO breakUpVO,AuthCustomer authCustomer) throws Exception {

        //更新合成刀绑定信息
        SynthesisCuttingToolLocationVO locationVO = new SynthesisCuttingToolLocationVO();
        locationVO.setSynthesisCuttingToolBindCode(breakUpVO.getSynthesisCuttingToolBind().getCode());
        List<SynthesisCuttingToolLocation> locations = synthesisCuttingToolLocationMapper.getSynthesisCuttingToolLocationByPage(locationVO);
        for (SynthesisCuttingToolLocation location : locations) {
            synthesisCuttingToolLocationMapper.delSynthesisCuttingToolLocation(location);
        }

        RfidContainerVO rfidVO = new RfidContainerVO();
        rfidVO.setLaserCode(breakUpVO.getSynthesisCuttingToolBind().getRfidContainer().getLaserCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidVO);

        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
        synthesisCuttingToolBindVO.setRfidContainerVO(rfidVO);
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);

        //更新合成刀库存
        SynthesisCuttingToolMaterialInventoryVO synthesisMaterialInventoryVo = new SynthesisCuttingToolMaterialInventoryVO();
        synthesisMaterialInventoryVo.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
        SynthesisCuttingToolMaterialInventory synthesisMaterialInventory = synthesismaterialInventoryMapper.getSynthesisCuttingToolMaterialInventory(synthesisMaterialInventoryVo);

        //如果上一步是换装或者组装  减少备用刀库存 否则 s减少待换装库存
        int libCount =0;
        int ctLibCount = 1;
        int exchangeCount = 0;
        int ctExchangeCount = 1;
        if (rfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_Exchange.getKey()||
                rfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_Config.getKey()){
            libCount -=1;
            ctLibCount =-1;
        }else{
            exchangeCount -=1;
            ctExchangeCount =-1;
        }
        if (null == synthesisMaterialInventory){
            synthesisMaterialInventory = new SynthesisCuttingToolMaterialInventory();
            synthesisMaterialInventory.setIsDel(0);
            synthesisMaterialInventory.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
            synthesisMaterialInventory.setPrepareLibraryCount(0);
            synthesisMaterialInventory.setInUseCount(0);
            synthesisMaterialInventory.setToExchangeCount(0);
            synthesisMaterialInventory.setToInstallCount(1);
            synthesismaterialInventoryMapper.addSynthesisCuttingToolMaterialInventory(synthesisMaterialInventory);
        }else{
            if (synthesisMaterialInventory.getToExchangeCount()+exchangeCount<0){
                synthesisMaterialInventory.setToExchangeCount(0);
            }else{
                synthesisMaterialInventory.setToExchangeCount(synthesisMaterialInventory.getToExchangeCount()+exchangeCount);
            }
            if (synthesisMaterialInventory.getPrepareLibraryCount()+libCount<0){
                synthesisMaterialInventory.setPrepareLibraryCount(0);
            }else{
                synthesisMaterialInventory.setPrepareLibraryCount(synthesisMaterialInventory.getPrepareLibraryCount()+libCount);
            }
            synthesisMaterialInventory.setToInstallCount(synthesisMaterialInventory.getToInstallCount()+1);
            synthesismaterialInventoryMapper.updSynthesisCuttingToolMaterialInventory(synthesisMaterialInventory);
        }

        //换下的刀具  更新库存
        for (DownCuttingToolVO downCuttingToolVO : breakUpVO.getDownCuttingToolVOS()) {
            CuttingToolVO cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setBusinessCode(downCuttingToolVO.getDownCode());
            CuttingTool cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);

            MaterialInventoryVO materialInventoryVO = new MaterialInventoryVO();
            materialInventoryVO.setCuttingToolCode(cuttingTool.getCode());
            MaterialInventory materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);

            if (null == materialInventory){
                materialInventory = new MaterialInventory();
                materialInventory.setIsDel(0);
                materialInventory.setCuttingToolCode(cuttingTool.getCode());
                materialInventory.setPrepareLibraryCount(0);
                materialInventory.setProductLineCount(0);
                materialInventory.setToExchangeCount(0);
                materialInventory.setGrindingOutCount(0);
                materialInventory.setScrapCount(0);
                materialInventory.setForGrindingInCount(0);
                materialInventory.setForGrindingOutCount(0);
                materialInventoryMapper.addMaterialInventory(materialInventory);
            }
            if (rfidContainer.getOperatorCode()==OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
                materialInventory.setToExchangeCount(materialInventory.getToExchangeCount()-downCuttingToolVO.getDownCount()<=0?0:materialInventory.getToExchangeCount()-downCuttingToolVO.getDownCount());
            }
            if (rfidContainer.getOperatorCode()==OperationEnum.SynthesisCuttingTool_Config.getKey()
                    ||rfidContainer.getOperatorCode()==OperationEnum.SynthesisCuttingTool_Exchange.getKey()){
                materialInventory.setPrepareLibraryCount(materialInventory.getPrepareLibraryCount()-downCuttingToolVO.getDownCount()<=0?0:materialInventory.getPrepareLibraryCount()-downCuttingToolVO.getDownCount());
            }
            if (cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_dp.getKey())||
                    cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_zt.getKey())){
                if (cuttingTool.getGrinding().equals(GrindingEnum.inside.getKey())){
                    materialInventory.setForGrindingInCount(downCuttingToolVO.getDownCount());
                }else{
                    materialInventory.setForGrindingOutCount(downCuttingToolVO.getDownCount());
                }
            }
            if (cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.single_use_dp.getKey())){
                materialInventory.setScrapCount(downCuttingToolVO.getDownCount());
            }
            if (cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.other.getKey())){
                materialInventory.setPrepareLibraryCount(downCuttingToolVO.getDownCount());
            }
            materialInventoryMapper.updMaterialInventory(materialInventory);


           //换下刀具绑定RFID
            if (!StringUtils.isBlank(downCuttingToolVO.getDownRfidCode())){
                RfidContainerVO ctRfidContainerVO = new RfidContainerVO();
                ctRfidContainerVO.setLaserCode(downCuttingToolVO.getDownRfidCode());
                RfidContainer ctRfidContainer = rfidContainerMapper.getRfidContainer(ctRfidContainerVO);

                if (ctRfidContainer == null){
                    ctRfidContainer = new RfidContainer();
                    ctRfidContainer.setIsDel(0);
                    ctRfidContainer.setUseCount(1);
                    ctRfidContainer.setCode(UUID.getInstance());
                    ctRfidContainer.setLaserCode(downCuttingToolVO.getDownRfidCode());
                    ctRfidContainer.setLabelType(RFIDEnum.cutting_tool.getKey());
                    ctRfidContainer.setOperatorCode(OperationEnum.SynthesisCuttingTool_UnConfig.getKey());
                    ctRfidContainer.setOperatorName(OperationEnum.SynthesisCuttingTool_UnConfig.getName());
                    rfidContainerMapper.addRfidContainer(ctRfidContainer);
                }else if (ctRfidContainer.getOperatorCode() ==null || ctRfidContainer.getOperatorCode() == 0||
                        ctRfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_Exchange.getKey()||
                        ctRfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_Config.getKey()
                        ){
                    ctRfidContainer.setPrevKey(ctRfidContainer.getOperatorCode());
                    ctRfidContainer.setPrevOperation(ctRfidContainer.getOperatorName());
                    ctRfidContainer.setUseCount(ctRfidContainer.getUseCount()+1);
                    ctRfidContainer.setLabelType(RFIDEnum.cutting_tool.getKey());
                    ctRfidContainer.setOperatorCode(OperationEnum.SynthesisCuttingTool_UnConfig.getKey());
                    ctRfidContainer.setOperatorName(OperationEnum.SynthesisCuttingTool_UnConfig.getName());
                    rfidContainerMapper.updRfidContainer(ctRfidContainer);
                }else {
                    throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_IN_USE));
                }

                CuttingToolBind cuttingToolBind = null;
                if (StringUtils.isBlank(downCuttingToolVO.getBladeCode())){
                    cuttingToolBind = new CuttingToolBind();
                    cuttingToolBind = new CuttingToolBind();
                    cuttingToolBind.setCode(UUID.getInstance());
                    cuttingToolBind.setIsDel(0);
                    cuttingToolBind.setCuttingToolCode(cuttingTool.getCode());
                    cuttingToolBindMapper.addCuttingToolBind(cuttingToolBind);
                }else{
                    CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                    cuttingToolBindVO.setBladeCode(downCuttingToolVO.getBladeCode());
                    cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
                }
                cuttingToolBind.setRfidContainerCode(ctRfidContainer.getCode());
                cuttingToolBind.setBladeCode(downCuttingToolVO.getBladeCode());
                cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
            }

        }
    }*/

    /**
     * 刀具组装
     * @param packageUpVO 组装内容
     * @throws Exception
     */
//    @Override
//    public void writeSynthesisCuttingToolPackageUp(PackageUpVO packageUpVO,AuthCustomer authCustomer) throws Exception {
//
//        //更新rfid标签的最后使用记录
//        RfidContainerVO rfidVO = new RfidContainerVO();
//        rfidVO.setLaserCode(packageUpVO.getSynthesisCuttingToolBind().getRfidContainer().getLaserCode());
//        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidVO);
//        rfidContainer.setPrevOperation(rfidContainer.getOperatorName());
//        rfidContainer.setPrevKey(rfidContainer.getOperatorCode());
//        rfidContainer.setOperatorName(OperationEnum.SynthesisCuttingTool_Config.getName());
//        rfidContainer.setOperatorCode(OperationEnum.SynthesisCuttingTool_Config.getKey());
//        rfidContainerMapper.updRfidContainer(rfidContainer);
//
//        //获取合成刀绑定记录
//        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
//        synthesisCuttingToolBindVO.setRfidContainerVO(rfidVO);
//        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);
//
//        for (UpCuttingToolVO upCuttingToolVO : packageUpVO.getUpCuttingToolVOS()) {
//
//            SynthesisCuttingToolLocation location = new SynthesisCuttingToolLocation();
//            if (!StringUtils.isBlank(upCuttingToolVO.getRfidCode())){
//                RfidContainerVO ctrfidContainerVO = new RfidContainerVO();
//                ctrfidContainerVO.setLaserCode(upCuttingToolVO.getRfidCode());
//                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
//                cuttingToolBindVO.setRfidContainerVO(ctrfidContainerVO);
//                CuttingToolBind cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
//                RfidContainer ctRfidContainer = rfidContainerMapper.getRfidContainer(ctrfidContainerVO);
//                if (null!=cuttingToolBind){
//                    location.setCuttingToolBladeCode(cuttingToolBind.getBladeCode());
//                    cuttingToolBind.setRfidContainerCode("");
//                    cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
//                }
//                ctRfidContainer.setOperatorCode(OperationEnum.Cutting_tool_Bind.getKey());
//                ctRfidContainer.setPrevOperation(ctRfidContainer.getOperatorName());
//                ctRfidContainer.setPrevKey(ctRfidContainer.getOperatorCode());
//                ctRfidContainer.setOperatorName(OperationEnum.Cutting_tool_Bind.getName());
//                ctRfidContainer.setLabelType(RFIDEnum.cutting_tool.getKey());
//                rfidContainerMapper.updRfidContainer(ctRfidContainer);
//            }
//            CuttingToolVO cuttingToolVO = new CuttingToolVO();
//            cuttingToolVO.setBusinessCode(upCuttingToolVO.getUpCode());
//            CuttingTool cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
//            //创建location
//            location.setIsDel(0);
//            location.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
//            location.setCuttingToolCode(cuttingTool.getCode());
//            location.setCount(upCuttingToolVO.getUpCount());
//            location.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
//            synthesisCuttingToolLocationMapper.addSynthesisCuttingToolLocation(location);
//
//        }
//
//        //如果上一步是换装 则不更新库存
//        if (rfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_Exchange.getKey()){
//            return;
//        }
//        //更新合成刀库存
//        SynthesisCuttingToolMaterialInventoryVO synthesisMaterialInventoryVo = new SynthesisCuttingToolMaterialInventoryVO();
//        synthesisMaterialInventoryVo.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
//        SynthesisCuttingToolMaterialInventory synthesisMaterialInventory = synthesismaterialInventoryMapper.getSynthesisCuttingToolMaterialInventory(synthesisMaterialInventoryVo);
//        if (null == synthesisMaterialInventory){
//            synthesisMaterialInventory = new SynthesisCuttingToolMaterialInventory();
//            synthesisMaterialInventory.setIsDel(0);
//            synthesisMaterialInventory.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
//            synthesisMaterialInventory.setPrepareLibraryCount(1);
//            synthesisMaterialInventory.setInUseCount(0);
//            synthesisMaterialInventory.setToExchangeCount(0);
//            synthesisMaterialInventory.setToInstallCount(0);
//            synthesismaterialInventoryMapper.addSynthesisCuttingToolMaterialInventory(synthesisMaterialInventory);
//        }else{
//            synthesisMaterialInventory.setPrepareLibraryCount(synthesisMaterialInventory.getPrepareLibraryCount()+1);
//            synthesisMaterialInventory.setToInstallCount((synthesisMaterialInventory.getToInstallCount()-1)>=0?synthesisMaterialInventory.getToInstallCount()-1:0);
//            synthesismaterialInventoryMapper.updSynthesisCuttingToolMaterialInventory(synthesisMaterialInventory);
//        }
//
//    }
//
//    @Override
//    public List<ProductLineEquipment> getAllInUseEquipment(ProductLineVO productLineVO) throws Exception {
//        return null;
//    }


}
