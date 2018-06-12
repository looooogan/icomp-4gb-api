package com.service.synthesiscuttingtool.impl;

import com.common.constants.*;
import com.common.mapper.*;
import com.common.pojo.*;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.*;
import com.service.orders.vo.WriteBackVO;
import com.service.rfid.RfidModel;
import com.service.rfid.bo.RFIDBO;
import com.service.synthesiscuttingtool.ISynthesisCuttingToolBusinessService;
import com.service.synthesiscuttingtool.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.Local;
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
    private ISynthesisCuttingToolExchangeMapper exchangeMapper;
    @Autowired
    private IMaterialInventoryMapper materialInventoryMapper;
    @Autowired
    private ICuttingToolMapper cuttingToolMapper;
    @Autowired
    private ISynthesisCuttingToolMaterialInventoryMapper sMaterialInventoryMapper;
    @Autowired
    private ISynthesisCuttingToolProductionRecordsMapper sProductionRecordsMapper;
    @Autowired
    private ICuttingToolProductionRecordsMapper cuttingToolProductionRecordsMapper;
    @Autowired
    private IRfidContainerMapper rfidContainerMapper;
    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;
    @Autowired
    private ISynthesisCuttingToolMaterialInventoryMapper synthesismaterialInventoryMapper;
    @Autowired
    private IProductLineMapper productLineMapper;
    @Autowired
    private ISynthesisCuttingToolBindleRecordsMapper bindleRecordsMapper;
    @Autowired
    private IAuthCustomerMapper authCustomerMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;
    @Autowired
    private RfidModel rfidModel;


    /**
     *
     * @param synthesisCuttingToolInitVO 查询条件
     * @return 合成刀配置
     * @throws Exception
     */
    @Override
    public SynthesisCuttingToolConfig getSynthesisCuttingToolForInit(SynthesisCuttingToolInitVO synthesisCuttingToolInitVO) throws Exception {
        SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO = new SynthesisCuttingToolConfigVO();
        synthesisCuttingToolConfigVO.setIsDel(0);
        if (!StringUtils.isBlank(synthesisCuttingToolInitVO.getRfidCode())){
            RfidContainerVO rfidContainerVO = new RfidContainerVO();
            rfidContainerVO.setLaserCode(synthesisCuttingToolInitVO.getRfidCode());
            RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
            if (null == rfidContainer){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_NOT_EXISTS));
            }
            SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
            synthesisCuttingToolBindVO.setRfidContainerCode(rfidContainer.getCode());
            synthesisCuttingToolBindVO.setId(0);
            SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);
            if(null == synthesisCuttingToolBind){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_NOT_EXISTS));
            }
            synthesisCuttingToolConfigVO.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
        }
        if (!StringUtils.isBlank(synthesisCuttingToolInitVO.getSynthesisCode())){
            SynthesisCuttingToolVO synthesisCuttingToolVO = new SynthesisCuttingToolVO();
            synthesisCuttingToolVO.setSynthesisCode(synthesisCuttingToolInitVO.getSynthesisCode());
            SynthesisCuttingTool synthesisCuttingTool = synthesisCuttingToolMapper.getSynthesisCuttingTool(synthesisCuttingToolVO);
            if(null == synthesisCuttingTool){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_NOT_EXISTS));
            }
            synthesisCuttingToolConfigVO.setSynthesisCuttingToolCode(synthesisCuttingTool.getCode());
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
     * 查询绑定信息
     * @param synthesisCuttingToolInitVO 查询条件
     * @return
     * @throws Exception
     */
    @Override
    public SynthesisCuttingToolBind getSynthesisCuttingBind(SynthesisCuttingToolInitVO synthesisCuttingToolInitVO) throws Exception {

        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(synthesisCuttingToolInitVO.getRfidCode());
        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
        synthesisCuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);
        if (null == synthesisCuttingToolBind){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_NOT_EXISTS));
        }
        SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO = new SynthesisCuttingToolLocationVO();
        synthesisCuttingToolLocationVO.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
        List<SynthesisCuttingToolLocation> locations = synthesisCuttingToolLocationMapper.getSynthesisCuttingToolLocationByPage(synthesisCuttingToolLocationVO);
        synthesisCuttingToolBind.setSynthesisCuttingToolLocationList(locations);
        return synthesisCuttingToolBind;
    }

    /**
     * 初始化合成刀
     * @param synthesisCuttingToolBinds 多个合成刀信息
     * @throws Exception
     */
    @Override
    public WriteBackVO addInitSynthesisCuttingTool(List<SynthesisCuttingToolBind> synthesisCuttingToolBinds) throws Exception {

        WriteBackVO writeBackVO = new WriteBackVO();

        for (SynthesisCuttingToolBind synthesisCuttingToolBind : synthesisCuttingToolBinds) {

            RfidContainerVO rfidContainerVO = new RfidContainerVO();
            rfidContainerVO.setLaserCode(synthesisCuttingToolBind.getRfidContainer().getLaserCode());
            RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
            if (rfidContainer == null){
                rfidContainer = new RfidContainer();
                rfidContainer.setIsDel(0);
                rfidContainer.setUseCount(1);
                rfidContainer.setCode(UUID.getInstance());
                rfidContainer.setLaserCode(synthesisCuttingToolBind.getRfidContainer().getLaserCode());
                rfidContainer.setLabelType(RFIDEnum.synthesis_cutting_tool.getKey());
                rfidContainer.setOperatorCode(OperationEnum.SynthesisCuttingTool_Init.getKey());
                rfidContainer.setOperatorName(OperationEnum.SynthesisCuttingTool_Init.getName());
                rfidContainer.setOperatorTime(new Timestamp(System.currentTimeMillis()));
                rfidContainerMapper.addRfidContainer(rfidContainer);
            }else if (rfidContainer.getOperatorCode()==null ||rfidContainer.getOperatorCode() == 0){
                rfidContainer.setPrevKey(rfidContainer.getOperatorCode());
                rfidContainer.setPrevOperation(rfidContainer.getOperatorName());
                rfidContainer.setUseCount(rfidContainer.getUseCount()+1);
                rfidContainer.setLabelType(RFIDEnum.synthesis_cutting_tool.getKey());
                rfidContainer.setOperatorCode(OperationEnum.SynthesisCuttingTool_Init.getKey());
                rfidContainer.setOperatorName(OperationEnum.SynthesisCuttingTool_Init.getName());
                rfidContainer.setOperatorTime(new Timestamp(System.currentTimeMillis()));
                rfidContainerMapper.updRfidContainer(rfidContainer);
            }else {
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_IN_USE));
            }

            synthesisCuttingToolBind.setIsDel(0);
            synthesisCuttingToolBind.setRfidContainer(rfidContainer);
            synthesisCuttingToolBind.setCreateTime(new Timestamp(System.currentTimeMillis()));
            synthesisCuttingToolBind.setCode(UUID.getInstance());
            synthesisCuttingToolBind.setRfidContainerCode(rfidContainer.getCode());
            synthesisCuttingToolBindMapper.addSynthesisCuttingToolBind(synthesisCuttingToolBind);

            SynthesisCuttingToolMaterialInventoryVO materialInventoryVO = new SynthesisCuttingToolMaterialInventoryVO();
            materialInventoryVO.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
            SynthesisCuttingToolMaterialInventory materialInventory = synthesismaterialInventoryMapper.getSynthesisCuttingToolMaterialInventory(materialInventoryVO);
            if (null == materialInventory){
                materialInventory = new SynthesisCuttingToolMaterialInventory();
                materialInventory.setIsDel(0);
                materialInventory.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
                materialInventory.setPrepareLibraryCount(1);
                materialInventory.setTotal(1);
                materialInventory.setInUseCount(0);
                materialInventory.setToExchangeCount(0);
                materialInventory.setToInstallCount(0);
                synthesismaterialInventoryMapper.addSynthesisCuttingToolMaterialInventory(materialInventory);
            }else{
                materialInventory.setTotal(materialInventory.getTotal()+1);
                materialInventory.setPrepareLibraryCount(materialInventory.getPrepareLibraryCount()+1);
                synthesismaterialInventoryMapper.updSynthesisCuttingToolMaterialInventory(materialInventory);
            }

            //添加数据
            for (SynthesisCuttingToolLocation location : synthesisCuttingToolBind.getSynthesisCuttingToolLocationList()){
//                CuttingToolVO cuttingToolVO = new CuttingToolVO();
//                cuttingToolVO.setBusinessCode(location.get);
                location.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
                location.setIsDel(0);
                location.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
                synthesisCuttingToolLocationMapper.addSynthesisCuttingToolLocation(location);
            }

            //修改材料刀库存

        }

        writeBackVO.setNote(OperationEnum.SynthesisCuttingTool_Init.getName());
        return writeBackVO;
    }

    /**
     * 合成刀换装
     * @param exChangeVO 换装结果
     * @throws Exception
     */
    @Override
    public void writeSynthesisCuttingToolExChange(ExChangeVO exChangeVO,AuthCustomer authCustomer) throws Exception {

        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
        synthesisCuttingToolBindVO.setCode(exChangeVO.getSynthesisCuttingToolBind().getCode());
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);

        RfidContainerVO sRfidContainerVO = new RfidContainerVO();
        sRfidContainerVO.setLaserCode(exChangeVO.getSynthesisCuttingToolBind().getRfidContainer().getLaserCode());
        RfidContainer sRfidContainer = rfidContainerMapper.getRfidContainer(sRfidContainerVO);

        //todo 是否为全部换装

        //删除原有刀具信息
        SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO = new SynthesisCuttingToolLocationVO();
        synthesisCuttingToolLocationVO.setSynthesisCuttingToolBindCode(exChangeVO.getSynthesisCuttingToolBind().getCode());
        List<SynthesisCuttingToolLocation> locations = synthesisCuttingToolLocationMapper.getSynthesisCuttingToolLocationByPage(synthesisCuttingToolLocationVO);
        for (SynthesisCuttingToolLocation location : locations) {
            synthesisCuttingToolLocationMapper.delSynthesisCuttingToolLocation(location);
        }

        //添加新刀具
        for (UpCuttingToolVO upCuttingToolVO : exChangeVO.getUpCuttingToolVOS()) {
            CuttingToolVO cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setBusinessCode(upCuttingToolVO.getUpCode());
            CuttingTool cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
            SynthesisCuttingToolLocation location = new SynthesisCuttingToolLocation();
            if (!StringUtils.isBlank(upCuttingToolVO.getBladeCode())){
                location.setCuttingToolBladeCode(upCuttingToolVO.getBladeCode());
            }
            location.setIsDel(0);
            location.setSynthesisCuttingToolBindCode(exChangeVO.getSynthesisCuttingToolBind().getCode());
            location.setCuttingToolCode(cuttingTool.getCode());
            location.setCount(upCuttingToolVO.getUpCount());
            location.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
            synthesisCuttingToolLocationMapper.addSynthesisCuttingToolLocation(location);

        }

        //修改合成刀库存
        if (sRfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_Exchange.getKey() ||
                sRfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_Config.getKey()) {
            //不更新库存
        } else {
            //加备用刀 减戴换装
            SynthesisCuttingToolMaterialInventoryVO synthesisMaterialInventoryVo = new SynthesisCuttingToolMaterialInventoryVO();
            synthesisMaterialInventoryVo.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
            SynthesisCuttingToolMaterialInventory synthesisMaterialInventory = synthesismaterialInventoryMapper.getSynthesisCuttingToolMaterialInventory(synthesisMaterialInventoryVo);
            if (null == synthesisMaterialInventory) {
                synthesisMaterialInventory = new SynthesisCuttingToolMaterialInventory();
                synthesisMaterialInventory.setIsDel(0);
                synthesisMaterialInventory.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
                synthesisMaterialInventory.setPrepareLibraryCount(1);
                synthesisMaterialInventory.setInUseCount(0);
                synthesisMaterialInventory.setToExchangeCount(0);
                synthesisMaterialInventory.setToInstallCount(0);
                synthesismaterialInventoryMapper.addSynthesisCuttingToolMaterialInventory(synthesisMaterialInventory);
            } else {
                synthesisMaterialInventory.setPrepareLibraryCount(synthesisMaterialInventory.getPrepareLibraryCount() + 1);
                synthesisMaterialInventory.setToExchangeCount((synthesisMaterialInventory.getToExchangeCount() - 1) >= 0 ? synthesisMaterialInventory.getToExchangeCount() - 1 : 0);
                synthesismaterialInventoryMapper.updSynthesisCuttingToolMaterialInventory(synthesisMaterialInventory);
            }
        }

        if (sRfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
            //如果从设备上卸下则添加换装记录

            //查询安上设备记录信息
            SynthesisCuttingToolBindleRecordsVO downRecordsVO = new SynthesisCuttingToolBindleRecordsVO();
            downRecordsVO.setBindRfid(sRfidContainer.getLaserCode());
            downRecordsVO.setStatus(BindRecorderStatusEnum.UnInstall.getKey());
            SynthesisCuttingToolBindleRecords downRecords = bindleRecordsMapper.getLast(downRecordsVO);
            if (null!=downRecords){
                //换装信息
                SynthesisCuttingToolExchange exchange = new SynthesisCuttingToolExchange();
                //添加换装记录
                exchange.setSynthesisCode(synthesisCuttingToolBind.getSynthesisCode());
                exchange.setRfidCode(synthesisCuttingToolBind.getRfidContainerCode());
                exchange.setAxleCode(downRecords.getProductLineAxleCode());
                exchange.setAxleName(downRecords.getProductLineAxle().getName());
                exchange.setEquipmentCode(downRecords.getProductLineEquipmentCode());
                exchange.setEquipmentName(downRecords.getProductLineEquipment().getName());
                exchange.setPartsCode(downRecords.getProductLinePartsCode());
                exchange.setPartsName(downRecords.getProductLineParts().getName());
                exchange.setToolUpTime(new Timestamp(System.currentTimeMillis()));
                exchange.setProcessCode(downRecords.getProductLineProcessCode());
                exchange.setProcessName(downRecords.getProductLineProcess().getName());

                exchange.setToolUpTime(downRecords.getOperatorInstallTime());
                exchange.setToolUpCustomerCode(downRecords.getOperatorInstall());
                exchange.setTollUpCustomerName(downRecords.getOperatorInstallName());
                exchange.setToolDownTime(downRecords.getOperatorInstallTime());
                exchange.setToolDownTime(downRecords.getOperatorUninstallTime());
                exchange.setTollDownCustomerName(downRecords.getOperatorUninstallName());
                exchange.setToolDownCustomerCode(downRecords.getOperatorUninstall());
                exchangeMapper.addSynthesisCuttingToolExchange(exchange);
            }



        }

        int ctLibCount = 1;
        int ctExchangeCount = 1;
        if (sRfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_Exchange.getKey() ||
                sRfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_Config.getKey()) {
            ctLibCount = -1;
        } else {
            ctExchangeCount = -1;
        }
//
        //修改材料刀库存信息
        //换上的刀具
        for (UpCuttingToolVO upCuttingToolVO : exChangeVO.getUpCuttingToolVOS()) {

            //RFID解绑
            if (StringUtils.isBlank(upCuttingToolVO.getRfidCode())){
                continue;
            }
            RfidContainerVO upRfidVO = new RfidContainerVO();
            upRfidVO.setLaserCode(upCuttingToolVO.getRfidCode());
            CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
            cuttingToolBindVO.setRfidContainerVO(upRfidVO);
            CuttingToolBind cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);


            RfidContainer upRfid = cuttingToolBind.getRfidContainer();
            upRfid.setPrevOperation(upRfid.getOperatorName());
            upRfid.setPrevKey(upRfid.getOperatorCode());
            upRfid.setOperatorCode(OperationEnum.SynthesisCuttingTool_Exchange.getKey());
            upRfid.setOperatorName(OperationEnum.SynthesisCuttingTool_Exchange.getName());
            rfidContainerMapper.updRfidContainer(upRfid);


//            cuttingToolBind.setRfidContainerCode(null);
//            CuttingToolBindVO unbindVo = new CuttingToolBindVO();
//            unbindVo.setCode(cuttingToolBind.getCode());
//            cuttingToolBindMapper.unBindCuttingToolData(unbindVo);

            //修改库存

        }

        //换下的刀具
        for (DownCuttingToolVO downCuttingToolVO : exChangeVO.getDownCuttingToolVOS()) {

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
//            if (sRfidContainer.getOperatorCode()==OperationEnum.SynthesisCuttingTool_Config.getKey()
//                    ||sRfidContainer.getOperatorCode()==OperationEnum.SynthesisCuttingTool_Exchange.getKey()){
////                    materialInventory.setPrepareLibraryCount(materialInventory.getPrepareLibraryCount()-downCuttingToolVO.getDownCount()<=0?0:materialInventory.getPrepareLibraryCount()-downCuttingToolVO.getDownCount());
//            }
            if (sRfidContainer.getOperatorCode()==OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
                if (cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_dp.getKey())||
                        cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_zt.getKey())){
                    if (cuttingTool.getGrinding().equals(GrindingEnum.inside.getKey())){
                        materialInventory.setForGrindingInCount(materialInventory.getForGrindingInCount()+downCuttingToolVO.getDownCount());
                    }else{
                        materialInventory.setForGrindingOutCount(materialInventory.getGrindingOutCount()+downCuttingToolVO.getDownCount());
                    }
                }
                if (cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.single_use_dp.getKey())){
                    materialInventory.setScrapCount(materialInventory.getScrapCount()+downCuttingToolVO.getDownCount());
                }
                materialInventory.setToExchangeCount(materialInventory.getToExchangeCount()-downCuttingToolVO.getDownCount()<=0?0:materialInventory.getToExchangeCount()-downCuttingToolVO.getDownCount());
                materialInventoryMapper.updMaterialInventory(materialInventory);
            }

//                materialInventory.setPrepareLibraryCount(materialInventory.getPrepareLibraryCount()+downCuttingToolVO.getDownCount());

//            if (sRfidContainer.getOperatorCode()!=OperationEnum.SynthesisCuttingTool_Init.getKey()
//                    &&sRfidContainer.getOperatorCode()!=OperationEnum.SynthesisCuttingTool_Config.getKey()
//                    &&sRfidContainer.getOperatorCode()!=OperationEnum.SynthesisCuttingTool_Exchange.getKey()){
//                materialInventoryMapper.updMaterialInventory(materialInventory);
//            }

            //换下刀具绑定RFID
            if (!StringUtils.isBlank(downCuttingToolVO.getDownRfidCode())) {
                RfidContainerVO ctRfidContainerVO = new RfidContainerVO();
                ctRfidContainerVO.setLaserCode(downCuttingToolVO.getDownRfidCode());
                RfidContainer ctRfidContainer = rfidContainerMapper.getRfidContainer(ctRfidContainerVO);
                if (ctRfidContainer == null) {
                    ctRfidContainer = new RfidContainer();
                    ctRfidContainer.setIsDel(0);
                    ctRfidContainer.setUseCount(1);
                    ctRfidContainer.setCode(UUID.getInstance());
                    ctRfidContainer.setLaserCode(downCuttingToolVO.getDownRfidCode());
                    ctRfidContainer.setLabelType(RFIDEnum.cutting_tool.getKey());
                    ctRfidContainer.setOperatorCode(OperationEnum.SynthesisCuttingTool_Exchange.getKey());
                    ctRfidContainer.setOperatorName(OperationEnum.SynthesisCuttingTool_Exchange.getName());
                    rfidContainerMapper.addRfidContainer(ctRfidContainer);
                } else if (ctRfidContainer.getOperatorCode() == null || ctRfidContainer.getOperatorCode() == 0 ||
                        ctRfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_Exchange.getKey() ||
                        ctRfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_Config.getKey()
                        ) {
                    ctRfidContainer.setPrevKey(ctRfidContainer.getOperatorCode());
                    ctRfidContainer.setPrevOperation(ctRfidContainer.getOperatorName());
                    ctRfidContainer.setUseCount(ctRfidContainer.getUseCount() + 1);
                    ctRfidContainer.setLabelType(RFIDEnum.cutting_tool.getKey());
                    ctRfidContainer.setOperatorCode(OperationEnum.SynthesisCuttingTool_Exchange.getKey());
                    ctRfidContainer.setOperatorName(OperationEnum.SynthesisCuttingTool_Exchange.getName());
                    rfidContainerMapper.updRfidContainer(ctRfidContainer);
                } else {
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
//                cuttingToolBind.setRfidContainerCode(ctRfidContainer.getCode());
//                cuttingToolBind.setBladeCode(downCuttingToolVO.getBladeCode());
//                cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
            }
        }
        RFIDBO rfidbo = new RFIDBO();
        rfidbo.setLabelType(RFIDEnum.synthesis_cutting_tool.getKey());
        rfidbo.setLaserCode(sRfidContainer.getLaserCode());
        rfidbo.setPrevOperationKey(OperationEnum.SynthesisCuttingTool_Exchange.getKey());
        rfidModel.updateRfidStatusTemp(rfidbo);
    }


    /**
     * 刀具拆分
     * @param breakUpVO 拆分内容
     * @throws Exception
     */
    @Override
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
    }

    /**
     * 刀具组装
     * @param packageUpVO 组装内容
     * @throws Exception
     */
    @Override
    public void writeSynthesisCuttingToolPackageUp(PackageUpVO packageUpVO,AuthCustomer authCustomer) throws Exception {

        //更新rfid标签的最后使用记录
        RfidContainerVO rfidVO = new RfidContainerVO();
        rfidVO.setLaserCode(packageUpVO.getSynthesisCuttingToolBind().getRfidContainer().getLaserCode());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidVO);
        rfidContainer.setPrevOperation(rfidContainer.getOperatorName());
        rfidContainer.setPrevKey(rfidContainer.getOperatorCode());
        rfidContainer.setOperatorName(OperationEnum.SynthesisCuttingTool_Config.getName());
        rfidContainer.setOperatorCode(OperationEnum.SynthesisCuttingTool_Config.getKey());
        rfidContainerMapper.updRfidContainer(rfidContainer);

        //获取合成刀绑定记录
        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
        synthesisCuttingToolBindVO.setRfidContainerVO(rfidVO);
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);

        for (UpCuttingToolVO upCuttingToolVO : packageUpVO.getUpCuttingToolVOS()) {

            SynthesisCuttingToolLocation location = new SynthesisCuttingToolLocation();
            if (!StringUtils.isBlank(upCuttingToolVO.getRfidCode())){
                RfidContainerVO ctrfidContainerVO = new RfidContainerVO();
                ctrfidContainerVO.setLaserCode(upCuttingToolVO.getRfidCode());
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setRfidContainerVO(ctrfidContainerVO);
                CuttingToolBind cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
                RfidContainer ctRfidContainer = rfidContainerMapper.getRfidContainer(ctrfidContainerVO);
                if (null!=cuttingToolBind){
                    location.setCuttingToolBladeCode(cuttingToolBind.getBladeCode());
                    cuttingToolBind.setRfidContainerCode("");
                    cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
                }
                ctRfidContainer.setOperatorCode(OperationEnum.Cutting_tool_Bind.getKey());
                ctRfidContainer.setPrevOperation(ctRfidContainer.getOperatorName());
                ctRfidContainer.setPrevKey(ctRfidContainer.getOperatorCode());
                ctRfidContainer.setOperatorName(OperationEnum.Cutting_tool_Bind.getName());
                ctRfidContainer.setLabelType(RFIDEnum.cutting_tool.getKey());
                rfidContainerMapper.updRfidContainer(ctRfidContainer);
            }
            CuttingToolVO cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setBusinessCode(upCuttingToolVO.getUpCode());
            CuttingTool cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
            //创建location
            location.setIsDel(0);
            location.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
            location.setCuttingToolCode(cuttingTool.getCode());
            location.setCount(upCuttingToolVO.getUpCount());
            location.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
            synthesisCuttingToolLocationMapper.addSynthesisCuttingToolLocation(location);

        }

        //如果上一步是换装 则不更新库存
        if (rfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_Exchange.getKey()){
            return;
        }
        //更新合成刀库存
        SynthesisCuttingToolMaterialInventoryVO synthesisMaterialInventoryVo = new SynthesisCuttingToolMaterialInventoryVO();
        synthesisMaterialInventoryVo.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
        SynthesisCuttingToolMaterialInventory synthesisMaterialInventory = synthesismaterialInventoryMapper.getSynthesisCuttingToolMaterialInventory(synthesisMaterialInventoryVo);
        if (null == synthesisMaterialInventory){
            synthesisMaterialInventory = new SynthesisCuttingToolMaterialInventory();
            synthesisMaterialInventory.setIsDel(0);
            synthesisMaterialInventory.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
            synthesisMaterialInventory.setPrepareLibraryCount(1);
            synthesisMaterialInventory.setInUseCount(0);
            synthesisMaterialInventory.setToExchangeCount(0);
            synthesisMaterialInventory.setToInstallCount(0);
            synthesismaterialInventoryMapper.addSynthesisCuttingToolMaterialInventory(synthesisMaterialInventory);
        }else{
            synthesisMaterialInventory.setPrepareLibraryCount(synthesisMaterialInventory.getPrepareLibraryCount()+1);
            synthesisMaterialInventory.setToInstallCount((synthesisMaterialInventory.getToInstallCount()-1)>=0?synthesisMaterialInventory.getToInstallCount()-1:0);
            synthesismaterialInventoryMapper.updSynthesisCuttingToolMaterialInventory(synthesisMaterialInventory);
        }

    }

    @Override
    public List<ProductLineEquipment> getAllInUseEquipment(ProductLineVO productLineVO) throws Exception {
        return null;
    }

    /**
     * 合成刀绑定设备
     * @param bindEquipmentVO 绑定值
     * @throws Exception
     */
    @Override
    public void bindData(BindEquipmentVO bindEquipmentVO,AuthCustomer authCustomer) throws Exception {
        //添加换刀记录
        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
        synthesisCuttingToolBindVO.setCode(bindEquipmentVO.getSynthesisCuttingToolBind().getCode());
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);

        ProductLineVO productLineVO = new ProductLineVO();
        productLineVO.setEquipmentCode(bindEquipmentVO.getEquipment().getCode());
        productLineVO.setAxleCode(bindEquipmentVO.getAxle().getCode());
        productLineVO.setSynthesisCuttingToolCode(bindEquipmentVO.getSynthesisCuttingToolBind().getSynthesisCuttingToolCode());
        ProductLine productLine = productLineMapper.getAssemblylineByEquipmentAndAxle(productLineVO);

        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomer.getCode());
        authCustomer = authCustomerMapper.getAuthCustomer(authCustomerVO);

        SynthesisCuttingToolBindleRecordsVO tmpVO = new SynthesisCuttingToolBindleRecordsVO();
        tmpVO.setBindRfid(synthesisCuttingToolBind.getRfidContainer().getLaserCode());
        SynthesisCuttingToolBindleRecords tmpRecord = bindleRecordsMapper.getLast(tmpVO);
        if (null != tmpRecord && tmpRecord.getStatus().equals(BindRecorderStatusEnum.Installed.getKey())){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SBINDRECORDER_EXITS));
        }

        SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords = new SynthesisCuttingToolBindleRecords();
        synthesisCuttingToolBindleRecords.setIsDel(0);
        synthesisCuttingToolBindleRecords.setOperatorInstall(authCustomer.getCode());
        synthesisCuttingToolBindleRecords.setOperatorInstallName(authCustomer.getName());
        synthesisCuttingToolBindleRecords.setOperatorInstallTime(new Timestamp(System.currentTimeMillis()));
        synthesisCuttingToolBindleRecords.setProductLineAssemblylineCode(productLine.getAssemblylineCode());
        synthesisCuttingToolBindleRecords.setProductLineAxleCode(productLine.getAxleCode());
        synthesisCuttingToolBindleRecords.setProductLineEquipmentCode(productLine.getEquipmentCode());
        synthesisCuttingToolBindleRecords.setProductLineProcessCode(productLine.getProcessCode());
        synthesisCuttingToolBindleRecords.setProductLinePartsCode(productLine.getPartsCode());
        synthesisCuttingToolBindleRecords.setSynthesisCuttingToolCode(productLine.getSynthesisCuttingToolCode());
        synthesisCuttingToolBindleRecords.setSynthesisCode(productLine.getSynthesisCuttingTool().getSynthesisCode());
        synthesisCuttingToolBindleRecords.setStatus(BindRecorderStatusEnum.Installed.getKey());
        synthesisCuttingToolBindleRecords.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
        synthesisCuttingToolBindleRecords.setBindRfid(synthesisCuttingToolBind.getRfidContainer().getLaserCode());
        bindleRecordsMapper.addSynthesisCuttingToolBindleRecords(synthesisCuttingToolBindleRecords);

        RfidContainer rfidContainer = synthesisCuttingToolBind.getRfidContainer();
        //如过是卸下的合成刀 则减少待换装数量
        int toExchangeCount = 0;
        int libCount = 0;
        if (rfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
            toExchangeCount = -1;
        }else{
            libCount = -1;
        }

        rfidContainer.setPrevKey(rfidContainer.getOperatorCode());
        rfidContainer.setPrevOperation(rfidContainer.getOperatorName());
        rfidContainer.setOperatorName(OperationEnum.SynthesisCuttingTool_Install.getName());
        rfidContainer.setOperatorCode(OperationEnum.SynthesisCuttingTool_Install.getKey());
        rfidContainerMapper.updRfidContainer(rfidContainer);

        //更新合成刀库存
        SynthesisCuttingToolMaterialInventoryVO synthesisCuttingToolMaterialInventoryVO = new SynthesisCuttingToolMaterialInventoryVO();
        synthesisCuttingToolMaterialInventoryVO.setSynthesisCuttingToolCode(bindEquipmentVO.getSynthesisCuttingToolBind().getSynthesisCuttingToolCode());
        SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory =sMaterialInventoryMapper.getSynthesisCuttingToolMaterialInventory(synthesisCuttingToolMaterialInventoryVO);
        if (null == synthesisCuttingToolMaterialInventory){
            synthesisCuttingToolMaterialInventory = new SynthesisCuttingToolMaterialInventory();
            synthesisCuttingToolMaterialInventory.setIsDel(0);
            synthesisCuttingToolMaterialInventory.setSynthesisCuttingToolCode(synthesisCuttingToolBind.getSynthesisCuttingToolCode());
            synthesisCuttingToolMaterialInventory.setPrepareLibraryCount(1);
            synthesisCuttingToolMaterialInventory.setInUseCount(0);
            synthesisCuttingToolMaterialInventory.setToExchangeCount(0);
            synthesisCuttingToolMaterialInventory.setToInstallCount(0);
            synthesismaterialInventoryMapper.addSynthesisCuttingToolMaterialInventory(synthesisCuttingToolMaterialInventory);
        }else{
            synthesisCuttingToolMaterialInventory.setPrepareLibraryCount(synthesisCuttingToolMaterialInventory.getPrepareLibraryCount()+libCount<0?0:synthesisCuttingToolMaterialInventory.getPrepareLibraryCount()+libCount);
            synthesisCuttingToolMaterialInventory.setToExchangeCount(synthesisCuttingToolMaterialInventory.getToExchangeCount()+toExchangeCount<0?0:synthesisCuttingToolMaterialInventory.getToExchangeCount()+toExchangeCount);
            synthesismaterialInventoryMapper.updSynthesisCuttingToolMaterialInventory(synthesisCuttingToolMaterialInventory);
        }


        //更新材料刀库存
        SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO = new SynthesisCuttingToolLocationVO();
        synthesisCuttingToolLocationVO.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
        List<SynthesisCuttingToolLocation> locations = synthesisCuttingToolLocationMapper.getSynthesisCuttingToolLocationByPage(synthesisCuttingToolLocationVO);
        for (SynthesisCuttingToolLocation location : locations) {

            MaterialInventoryVO materialInventoryVO = new MaterialInventoryVO();
            materialInventoryVO.setCuttingToolCode(location.getCuttingToolCode());
            MaterialInventory materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);
            if (null == materialInventory) {
                materialInventory = new MaterialInventory();
                materialInventory.setIsDel(0);
                materialInventory.setCuttingToolCode(location.getCuttingTool().getCode());
                materialInventory.setPrepareLibraryCount(0);
                materialInventory.setProductLineCount(0);
                materialInventory.setToExchangeCount(0);
                materialInventory.setGrindingOutCount(0);
                materialInventory.setScrapCount(0);
                materialInventory.setForGrindingOutCount(0);
                materialInventory.setForGrindingInCount(0);
                materialInventoryMapper.addMaterialInventory(materialInventory);
            }
            materialInventory.setProductLineCount(materialInventory.getProductLineCount()+location.getCount());
            if (rfidContainer.getOperatorCode() == OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
                materialInventory.setToExchangeCount(materialInventory.getToExchangeCount()-location.getCount()<0?0:materialInventory.getToExchangeCount()-location.getCount());
            }else{
                materialInventory.setPrepareLibraryCount(materialInventory.getPrepareLibraryCount()-location.getCount()<0?0:materialInventory.getPrepareLibraryCount()-location.getCount());
            }
//            materialInventory.setToExchangeCount(materialInventory.getToExchangeCount()+location.getCount());
//            materialInventory.setProductLineCount(materialInventory.getProductLineCount()-location.getCount()<0?0:materialInventory.getProductLineCount()-location.getCount());
            materialInventoryMapper.updMaterialInventory(materialInventory);
        }
    }

    /**
     * 合成刀具卸下设备
     * @param unBindEquipmentVO
     * @return
     * @throws Exception
     */
    @Override
    public SynthesisCuttingToolBindleRecords unBindData(UnBindEquipmentVO unBindEquipmentVO,AuthCustomer authCustomer) throws Exception {
        //添加换刀记录
        SynthesisCuttingToolBindleRecordsVO bindleRecordsVO = new SynthesisCuttingToolBindleRecordsVO();
        bindleRecordsVO.setBindRfid(unBindEquipmentVO.getBindRfid());
        bindleRecordsVO.setStatus(BindRecorderStatusEnum.Installed.getKey());

        SynthesisCuttingToolBindleRecords bindleRecords =bindleRecordsMapper.getLast(bindleRecordsVO);
        bindleRecords.setStatus(BindRecorderStatusEnum.UnInstall.getKey());

        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomer.getCode());
        authCustomer = authCustomerMapper.getAuthCustomer(authCustomerVO);
        bindleRecords.setOperatorUninstall(authCustomer.getCode());
        bindleRecords.setOperatorUninstallName(authCustomer.getName());
        bindleRecords.setOperatorUninstallTime(new Timestamp(System.currentTimeMillis()));


        ProductLineVO productLineVO = new ProductLineVO();
        productLineVO.setAxleCode(bindleRecords.getProductLineAxleCode());
        productLineVO.setAssemblylineCode(bindleRecords.getProductLineAssemblylineCode());
        productLineVO.setProcessCode(bindleRecords.getProductLineProcessCode());
        productLineVO.setEquipmentCode(bindleRecords.getProductLineEquipmentCode());
        productLineVO.setPartsCode(bindleRecords.getProductLinePartsCode());
        productLineVO.setSynthesisCuttingToolCode(bindleRecords.getSynthesisCuttingToolCode());
        ProductLine productLine = productLineMapper.getProductLine(productLineVO);

        bindleRecords.setRatedNumber(productLine.getToolDurable());
        bindleRecords.setProcessingCount(unBindEquipmentVO.getCount());
        bindleRecords.setReason(unBindEquipmentVO.getUnBindReason());
        bindleRecordsMapper.updSynthesisCuttingToolBindleRecords(bindleRecords);


        //更新库存
        SynthesisCuttingToolMaterialInventoryVO synthesisCuttingToolMaterialInventoryVO = new SynthesisCuttingToolMaterialInventoryVO();
        synthesisCuttingToolMaterialInventoryVO.setSynthesisCuttingToolCode(unBindEquipmentVO.getProductLineVO().getSynthesisCuttingToolCode());
        SynthesisCuttingToolMaterialInventory synthesisMaterialInventory =sMaterialInventoryMapper.getSynthesisCuttingToolMaterialInventory(synthesisCuttingToolMaterialInventoryVO);
        if(null == synthesisMaterialInventory){
            synthesisMaterialInventory = new SynthesisCuttingToolMaterialInventory();
            synthesisMaterialInventory.setSynthesisCuttingToolCode(unBindEquipmentVO.getProductLineVO().getSynthesisCuttingToolCode());
            synthesisMaterialInventory.setIsDel(0);
            synthesisMaterialInventory.setPrepareLibraryCount(0);
            synthesisMaterialInventory.setInUseCount(0);
            synthesisMaterialInventory.setToExchangeCount(1);
            synthesisMaterialInventory.setToInstallCount(0);
            synthesismaterialInventoryMapper.addSynthesisCuttingToolMaterialInventory(synthesisMaterialInventory);
        }else{
            synthesisMaterialInventory.setInUseCount((synthesisMaterialInventory.getInUseCount()-1)>0?synthesisMaterialInventory.getInUseCount()-1:0);
            synthesisMaterialInventory.setToExchangeCount(synthesisMaterialInventory.getToExchangeCount()+1);
            synthesismaterialInventoryMapper.updSynthesisCuttingToolMaterialInventory(synthesisMaterialInventory);
        }
        //更新rfid标签状态
        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(unBindEquipmentVO.getBindRfid());
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);

        //更新合成刀生产记录
        SynthesisCuttingToolProductionRecords synthesisCuttingToolProductionRecords = new SynthesisCuttingToolProductionRecords();
        synthesisCuttingToolProductionRecords.setAssemblylineCode(bindleRecords.getProductLineAssemblyline().getCode());
        synthesisCuttingToolProductionRecords.setAssemblylineName(bindleRecords.getProductLineAssemblyline().getName());
        synthesisCuttingToolProductionRecords.setProcessCode(bindleRecords.getProductLineProcessCode());
        synthesisCuttingToolProductionRecords.setProcessName(bindleRecords.getProductLineProcess().getName());
        synthesisCuttingToolProductionRecords.setEquipmentCode(bindleRecords.getProductLineEquipmentCode());
        synthesisCuttingToolProductionRecords.setEquipmentName(bindleRecords.getProductLineEquipment().getName());
        synthesisCuttingToolProductionRecords.setAxleCode(bindleRecords.getProductLineAxleCode());
        synthesisCuttingToolProductionRecords.setAxleName(bindleRecords.getProductLineAxle().getName());
        synthesisCuttingToolProductionRecords.setPartsCode(bindleRecords.getProductLinePartsCode());
        synthesisCuttingToolProductionRecords.setPartsName(bindleRecords.getProductLineParts().getName());
        synthesisCuttingToolProductionRecords.setIsDel(0);
        synthesisCuttingToolProductionRecords.setLastTime(new Timestamp(System.currentTimeMillis()));
        synthesisCuttingToolProductionRecords.setProductLineCode(bindleRecords.getProductLineAssemblylineCode());
        synthesisCuttingToolProductionRecords.setProcessingCount(productLine.getToolDurable());
        synthesisCuttingToolProductionRecords.setRatedNumber(unBindEquipmentVO.getCount());
        synthesisCuttingToolProductionRecords.setSynthesisCuttingToolCode(bindleRecords.getSynthesisCuttingToolCode());
        synthesisCuttingToolProductionRecords.setSynthesisCode(bindleRecords.getSynthesisCuttingTool().getSynthesisCode());
        sProductionRecordsMapper.addSynthesisCuttingToolProductionRecords(synthesisCuttingToolProductionRecords);

        //更新材料刀生产记录
        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
        synthesisCuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
//        synthesisCuttingToolBindVO.setRfidContainerCode(bindleRecords.getBindRfid());
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);
        SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO = new SynthesisCuttingToolLocationVO();
        synthesisCuttingToolLocationVO.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
        List<SynthesisCuttingToolLocation>locations =synthesisCuttingToolLocationMapper.getSynthesisCuttingToolLocationByPage(synthesisCuttingToolLocationVO);
        for (SynthesisCuttingToolLocation location : locations) {
            CuttingToolBind cuttingToolBind = null;
            if (!StringUtils.isBlank(location.getCuttingToolBladeCode())){
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setBladeCode(location.getCuttingToolBladeCode());
                cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
            }



            if (null!= cuttingToolBind){
                cuttingToolBind.setJgcs(unBindEquipmentVO.getCount());
                cuttingToolBind.setJgsm(productLine.getToolDurable());
                cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
            }

            CuttingToolProductionRecords cuttingToolProductionRecords = new CuttingToolProductionRecords();
            cuttingToolProductionRecords.setBusinessCode(location.getCuttingTool().getBusinessCode());
            cuttingToolProductionRecords.setCuttingToolCode(location.getCuttingToolCode());
            cuttingToolProductionRecords.setAssemblylineCode(bindleRecords.getProductLineAssemblylineCode());
            cuttingToolProductionRecords.setAssemblylineName(bindleRecords.getProductLineAssemblyline().getName());
            cuttingToolProductionRecords.setProcessCode(bindleRecords.getProductLineProcessCode());
            cuttingToolProductionRecords.setProcessName(bindleRecords.getProductLineProcess().getName());
            cuttingToolProductionRecords.setAxleCode(bindleRecords.getProductLineAxleCode());
            cuttingToolProductionRecords.setAxleName(bindleRecords.getProductLineAxle().getName());
            cuttingToolProductionRecords.setEquipmentCode(bindleRecords.getProductLineEquipmentCode());
            cuttingToolProductionRecords.setEquipmentName(bindleRecords.getProductLineEquipment().getName());
            cuttingToolProductionRecords.setIsDel("0");
            cuttingToolProductionRecords.setLastTime(new Timestamp(System.currentTimeMillis()));
//            cuttingToolProductionRecords.setProductLineCode(bindleRecords.getProductLineAssemblylineCode());
            cuttingToolProductionRecords.setPartsCode(bindleRecords.getProductLinePartsCode());
            cuttingToolProductionRecords.setPartsName(bindleRecords.getProductLineParts().getName());
            cuttingToolProductionRecords.setSynthesisCuttingToolCode(bindleRecords.getSynthesisCuttingToolCode());
            cuttingToolProductionRecords.setSynthesisCode(bindleRecords.getSynthesisCuttingTool().getSynthesisCode());
            cuttingToolProductionRecords.setProcessingCount(unBindEquipmentVO.getCount());
            cuttingToolProductionRecords.setRatedNumber(productLine.getToolDurable());
            cuttingToolProductionRecordsMapper.addCuttingToolProductionRecords(cuttingToolProductionRecords);

            //更新材料刀库存



            MaterialInventoryVO materialInventoryVO = new MaterialInventoryVO();
            materialInventoryVO.setCuttingToolCode(location.getCuttingTool().getCode());
            MaterialInventory materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);
            if (null == materialInventory) {
                materialInventory = new MaterialInventory();
                materialInventory.setIsDel(0);
                materialInventory.setCuttingToolCode(location.getCuttingTool().getCode());
                materialInventory.setPrepareLibraryCount(0);
                materialInventory.setProductLineCount(0);
                materialInventory.setToExchangeCount(0);
                materialInventory.setGrindingOutCount(0);
                materialInventory.setScrapCount(0);
                materialInventory.setForGrindingOutCount(0);
                materialInventory.setForGrindingInCount(0);
                materialInventoryMapper.addMaterialInventory(materialInventory);
            }
            if (location.getCuttingTool().getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_dp.getKey())||
                    location.getCuttingTool().getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_zt.getKey())){
                materialInventory.setToExchangeCount(materialInventory.getForGrindingInCount()+location.getCount());
            }
            if (location.getCuttingTool().getConsumeType().equals(CuttingToolConsumeTypeEnum.single_use_dp.getKey())){
                materialInventory.setScrapCount(materialInventory.getScrapCount()+location.getCount());
            }
            if (location.getCuttingTool().getConsumeType().equals(CuttingToolConsumeTypeEnum.other.getKey())){
                materialInventory.setPrepareLibraryCount(materialInventory.getPrepareLibraryCount()+location.getCount());
            }
            materialInventoryMapper.updMaterialInventory(materialInventory);

        }
        rfidContainer.setPrevOperation(rfidContainer.getOperatorName());
        rfidContainer.setPrevKey(rfidContainer.getOperatorCode());
        rfidContainer.setOperatorCode(OperationEnum.SynthesisCuttingTool_UnInstall.getKey());
        rfidContainer.setOperatorName(OperationEnum.SynthesisCuttingTool_UnInstall.getName());
        rfidContainerMapper.updRfidContainer(rfidContainer);
//        productLine.setSynthesisCuttingToolCode(null);
//        productLineMapper.updProductLine(productLine);
        return bindleRecords;
    }

    @Override
    public RfidContainer queryRFIDForUnConfig(RfidContainerVO rfidContainerVO) throws Exception {
        RfidContainer rfidContainer = rfidContainerMapper.getRfidContainer(rfidContainerVO);
        if (null == rfidContainer){
            return null;
        }
        if (rfidContainer.getOperatorCode()!=OperationEnum.SynthesisCuttingTool_UnConfig.getKey()
                &&rfidContainer.getOperatorCode()!=OperationEnum.RFID_Clear.getKey()){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.RFID_IN_USE));
        }
        return null;
    }

    @Override
    public void insideFactory() throws Exception {

    }

    public void initRFID() throws Exception{

    }
}
