package com.service.orders;

import com.common.constants.BindRecorderStatusEnum;
import com.common.constants.GrindingEnum;
import com.common.constants.OperationEnum;
import com.common.constants.QiMingOptionEnum;
import com.common.pojo.*;
import com.common.vo.*;
import com.service.common.*;
import com.service.orders.vo.WBUnInstallVO;
import com.service.synthesiscuttingtool.ISynthesisCuttingToolBusinessService;
import com.service.synthesiscuttingtool.vo.*;
import com.service.system.ISystemBusinessService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by logan on 2018/5/7.
 */
@Component("synthesiscuttingtoolComent")
public class synthesiscuttingtoolComent {

    @Autowired
    private ISystemBusinessService systemBusinessService;
    @Autowired
    private IQimingRecordsService qimingRecordsService;
    @Autowired
    private ICuttingToolService cuttingToolService;
    @Autowired
    private ICuttingToolBindService cuttingToolBindService;
    @Autowired
    private ISynthesisCuttingToolLocationService locationService;
    @Autowired
    private IProductLineService productLineService;
    @Autowired
    private ISynthesisCuttingToolBindleRecordsService bindleRecordsService;

    @Autowired
    private IDjOwnerAkpService djOwnerAkpService;
    @Autowired
    private IDjOutapplyAkpService djOutapplyAkpService;
    @Autowired
    private IDjCircleKanbanAkpService djCircleKanbanAkpService;
    @Autowired
    private IDjMtlAkpService djMtlAkpService;
    @Autowired
    private IDjWriteBackService writeBackService;
    @Autowired
    private IDjItrnAkpService djItrnAkpService;

    @Autowired
    private IRfidContainerService rfidContainerService;

    @Autowired
    private ISynthesisCuttingToolBusinessService synthesisCuttingToolBusinessService;

    @Autowired
    private ISynthesisCuttingToolBindService synthesisCuttingToolBindService;
    @Autowired
    private IDjWriteBackService djWriteBackService;

    public void init(List<SynthesisCuttingToolBind> synthesisCuttingToolBinds) throws Exception{
        //执行合成刀绑定
        synthesisCuttingToolBusinessService.addInitSynthesisCuttingTool(synthesisCuttingToolBinds);
        //回写数据
//        DjItrnAkp djItrnAkp = null;
//        Integer batchNo = djItrnAkpService.getMaxBatchNo();
//        for (SynthesisCuttingToolBind synthesisCuttingToolBind : synthesisCuttingToolBinds) {
//            for (SynthesisCuttingToolLocation synthesisCuttingToolLocation : synthesisCuttingToolBind.getSynthesisCuttingToolLocationList()) {
//                if (StringUtils.isBlank(synthesisCuttingToolLocation.getCuttingTool().getCode())){
//                    continue;
//                }
//
//                DjItrnAkpVO djItrnAkpVO = new DjItrnAkpVO();
//                CuttingToolBind cuttingToolBind = null;
//                if (!StringUtils.isBlank(synthesisCuttingToolLocation.getCuttingToolBladeCode())){
//                    CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
//                    cuttingToolBindVO.setBladeCode(synthesisCuttingToolLocation.getCuttingToolBladeCode());
//                    cuttingToolBind = cuttingToolBindService.getCuttingToolBind(cuttingToolBindVO);
//                }
//
//                if (null != cuttingToolBind){
//                    djItrnAkpVO.setCasecode(cuttingToolBind.getBladeCode());
//                }
//                //根据刀身码查询
//
//                djItrnAkpVO.setCasecode(cuttingToolBind.getBladeCode());
//                djItrnAkp = djItrnAkpService.getLast(djItrnAkpVO);
//                if (null!= djItrnAkp){
//                    DjItrnAkp djItrnAkpNew = djItrnAkp;
//                    djItrnAkpNew.setId(null);
//                    djItrnAkpNew.setBatchno(batchNo+1);
//                    djItrnAkpNew.setType(QiMingOptionEnum.);
//                    djItrnAkpNew.setNote(OperationEnum.SynthesisCuttingTool_Init.getName());
//                    djItrnAkpNew.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
//                    djItrnAkpService.addDjItrnAkp(djItrnAkp);
//                }
//            }
//        }
    }

    /**
     * 刀具换装
     * @param exChangeVO
     * @throws Exception
     */
    public void exChange(ExChangeVO exChangeVO,AuthCustomer authCustomer) throws Exception{

        synthesisCuttingToolBusinessService.writeSynthesisCuttingToolExChange(exChangeVO,authCustomer);
        //回写数据

        RfidContainerVO sRfidContainerVO = new RfidContainerVO();
        sRfidContainerVO.setLaserCode(exChangeVO.getSynthesisCuttingToolBind().getRfidContainer().getLaserCode());
        RfidContainer sRfidContainer = rfidContainerService.getRfidContainer(sRfidContainerVO);

        SynthesisCuttingToolBindleRecordsVO downRecordsVO = new SynthesisCuttingToolBindleRecordsVO();
        downRecordsVO.setBindRfid(exChangeVO.getSynthesisCuttingToolBind().getRfidContainer().getLaserCode());
        downRecordsVO.setStatus(BindRecorderStatusEnum.UnInstall.getKey());
        SynthesisCuttingToolBindleRecords bindleRecords = bindleRecordsService.getLastRecords(downRecordsVO);
        Integer batchNo = djItrnAkpService.getMaxBatchNo();
        DjItrnAkp djItrnAkp = null;
        for (DownCuttingToolVO downCuttingToolVO : exChangeVO.getDownCuttingToolVOS()) {
            DjItrnAkpVO djItrnAkpVO = new DjItrnAkpVO();
            CuttingToolBind cuttingToolBind = null;
            if (!StringUtils.isBlank(downCuttingToolVO.getBladeCode())){
                djItrnAkpVO.setCasecode(cuttingToolBind.getBladeCode());
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setBladeCode(downCuttingToolVO.getBladeCode());
                cuttingToolBind = cuttingToolBindService.getCuttingToolBind(cuttingToolBindVO);
            }
            //根据刀身码查询
            djItrnAkpVO.setDaojCase(downCuttingToolVO.getDownCode());
            djItrnAkp = djItrnAkpService.getLast(djItrnAkpVO);

            CuttingToolVO cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setBusinessCode(downCuttingToolVO.getDownCode());
            CuttingTool cuttingTool = cuttingToolService.getCuttingTool(cuttingToolVO);
            if (null == cuttingTool){
                continue;
            }
            if (null!= djItrnAkp){
                if (null == batchNo){
                    batchNo = 1;
                }
                DjItrnAkp djItrnAkpNew = djItrnAkp;
                djItrnAkpNew.setId(null);
                djItrnAkpNew.setBatchno(batchNo+1);
                djItrnAkpNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                //如果从设备上卸下之后换装则写出加工量
                if (sRfidContainer.getOperatorCode()==OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
                    //额定加工量
                    djItrnAkpNew.setJgsm(bindleRecords.getRatedNumber()+"");
                    //实际加工量
                    djItrnAkpNew.setJgcs(bindleRecords.getProcessingCount()+"");
                }

                if (cuttingTool.getGrinding().equals(GrindingEnum.inside.getKey())){
                    djItrnAkpNew.setType(QiMingOptionEnum.inside_sharpening.getKey());
                }
                if (cuttingTool.getGrinding().equals(GrindingEnum.outside_tuceng.getKey())){
                    djItrnAkpNew.setType(QiMingOptionEnum.outside_coating.getKey());
                }
                if (cuttingTool.getGrinding().equals(GrindingEnum.outside.getKey())){
                    djItrnAkpNew.setType(QiMingOptionEnum.outside_sharpening.getKey());
                }
                djItrnAkpNew.setNote(OperationEnum.SynthesisCuttingTool_Exchange.getName());
                if (null != cuttingToolBind){
                    djItrnAkpNew.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
                }
                djItrnAkpService.addDjItrnAkp(djItrnAkpNew);
            }
        }

        for (UpCuttingToolVO upCuttingToolVO : exChangeVO.getUpCuttingToolVOS()) {
            DjItrnAkpVO djItrnAkpVO = new DjItrnAkpVO();
            CuttingToolBind cuttingToolBind = null;
            if (!StringUtils.isBlank(upCuttingToolVO.getRfidCode())){
                RfidContainerVO rfidContainerVO = new RfidContainerVO();
                rfidContainerVO.setLaserCode(upCuttingToolVO.getRfidCode());
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
                cuttingToolBind = cuttingToolBindService.getCuttingToolBind(cuttingToolBindVO);
            }
            if (null != cuttingToolBind){
                djItrnAkpVO.setCasecode(cuttingToolBind.getBladeCode());
            }
            //根据刀身码查询
            djItrnAkpVO.setDaojCase(upCuttingToolVO.getUpCode());
            djItrnAkp = djItrnAkpService.getLast(djItrnAkpVO);
            if (null!= djItrnAkp){
                if (null == batchNo){
                    batchNo = 1;
                }
                CuttingToolVO cuttingToolVO = new CuttingToolVO();
                cuttingToolVO.setBusinessCode(upCuttingToolVO.getUpCode());
                CuttingTool cuttingTool = cuttingToolService.getCuttingTool(cuttingToolVO);
                DjItrnAkp djItrnAkpNew = djItrnAkp;
                if (cuttingTool.getGrinding().equals(GrindingEnum.inside.getKey())){
                    djItrnAkpNew.setType(QiMingOptionEnum.inside_sharpening.getKey());
                }
                if (cuttingTool.getGrinding().equals(GrindingEnum.outside_tuceng.getKey())){
                    djItrnAkpNew.setType(QiMingOptionEnum.outside_coating.getKey());
                }
                if (cuttingTool.getGrinding().equals(GrindingEnum.outside.getKey())){
                    djItrnAkpNew.setType(QiMingOptionEnum.outside_sharpening.getKey());
                }
                djItrnAkpNew.setNote(OperationEnum.SynthesisCuttingTool_Exchange.getName());
                if (null != cuttingToolBind){
                    djItrnAkpNew.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
                }
                djItrnAkpNew.setId(null);
                djItrnAkpNew.setBatchno(batchNo+1);
                djItrnAkpNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                djItrnAkpNew.setNote(OperationEnum.SynthesisCuttingTool_Exchange.getName());
                if (null != cuttingToolBind){
                    djItrnAkpNew.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
                }
                djItrnAkpService.addDjItrnAkp(djItrnAkpNew);
            }
        }
    }


    public void BreakUp(BreakUpVO breakUpVO,AuthCustomer authCustomer) throws Exception{
        synthesisCuttingToolBusinessService.writeSynthesisCuttingToolBreakUp(breakUpVO,authCustomer);
        Integer batchNo = djItrnAkpService.getMaxBatchNo();
        DjItrnAkp djItrnAkp = null;
        for (DownCuttingToolVO downCuttingToolVO : breakUpVO.getDownCuttingToolVOS()) {
            DjItrnAkpVO djItrnAkpVO = new DjItrnAkpVO();
            CuttingToolBind cuttingToolBind = null;
            if (!StringUtils.isBlank(downCuttingToolVO.getDownRfidCode())){
                RfidContainerVO rfidContainerVO = new RfidContainerVO();
                rfidContainerVO.setLaserCode(downCuttingToolVO.getDownRfidCode());
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
                cuttingToolBind = cuttingToolBindService.getCuttingToolBind(cuttingToolBindVO);
            }

            if (null != cuttingToolBind){
                djItrnAkpVO.setCasecode(cuttingToolBind.getBladeCode());
            }
            djItrnAkpVO.setDaojCase(downCuttingToolVO.getDownCode());
            djItrnAkp = djItrnAkpService.getLast(djItrnAkpVO);
            if (null!= djItrnAkp){
                DjItrnAkp djItrnAkpNew = djItrnAkp;
                djItrnAkpNew.setId(null);
                djItrnAkpNew.setBatchno(batchNo+1);
                djItrnAkpNew.setType(QiMingOptionEnum.to_outFactory.getKey());
                djItrnAkpNew.setNote(OperationEnum.SynthesisCuttingTool_UnConfig.getName());
                if (null != cuttingToolBind){
                    djItrnAkpNew.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
                }
                djItrnAkpService.addDjItrnAkp(djItrnAkp);
            }
        }
    }

    public void packageUp(PackageUpVO packageUpVO,AuthCustomer authCustomer) throws Exception{
        synthesisCuttingToolBusinessService.writeSynthesisCuttingToolPackageUp(packageUpVO,authCustomer);
        DjItrnAkp djItrnAkp = null;
        Integer batchNo = djItrnAkpService.getMaxBatchNo();
        for (UpCuttingToolVO upCuttingToolVO : packageUpVO.getUpCuttingToolVOS()) {
            DjItrnAkpVO djItrnAkpVO = new DjItrnAkpVO();
            CuttingToolBind cuttingToolBind = null;
            if (!StringUtils.isBlank(upCuttingToolVO.getRfidCode())){
                RfidContainerVO rfidContainerVO = new RfidContainerVO();
                rfidContainerVO.setLaserCode(upCuttingToolVO.getRfidCode());
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
                cuttingToolBind = cuttingToolBindService.getCuttingToolBind(cuttingToolBindVO);
                if (null != cuttingToolBind){
                    djItrnAkpVO.setCasecode(cuttingToolBind.getBladeCode());
                }
            }
            //根据刀身码查询
            djItrnAkpVO.setDaojCase(upCuttingToolVO.getUpCode());
            djItrnAkp = djItrnAkpService.getLast(djItrnAkpVO);
            if (null!= djItrnAkp){
                DjItrnAkp djItrnAkpNew = djItrnAkp;
                djItrnAkpNew.setId(null);
                djItrnAkpNew.setBatchno(batchNo+1);
                djItrnAkpNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                djItrnAkpNew.setType(QiMingOptionEnum.to_install.getKey());
                djItrnAkpNew.setNote(OperationEnum.SynthesisCuttingTool_Config.getName());
                if (null != cuttingToolBind){
                    djItrnAkpNew.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
                }
                djItrnAkpService.addDjItrnAkp(djItrnAkpNew);
            }
        }
    }

    public void bindEquipment(BindEquipmentVO bindEquipmentVO,AuthCustomer authCustomer) throws Exception{

        synthesisCuttingToolBusinessService.bindData(bindEquipmentVO,authCustomer);

        //回写记录
        ProductLineVO productLineVO = new ProductLineVO();
        productLineVO.setEquipmentCode(bindEquipmentVO.getEquipment().getCode());
        productLineVO.setAxleCode(bindEquipmentVO.getAxle().getCode());
        productLineVO.setSynthesisCuttingToolCode(bindEquipmentVO.getSynthesisCuttingToolBind().getSynthesisCuttingToolCode());
        ProductLine productLine = productLineService.getAssemblylineByEquipmentAndAxle(productLineVO);

        DjItrnAkp djItrnAkp = null;
        Integer batchNo = djItrnAkpService.getMaxBatchNo();
        SynthesisCuttingToolLocationVO locationVO = new SynthesisCuttingToolLocationVO();
        locationVO.setSynthesisCuttingToolBindCode(bindEquipmentVO.getSynthesisCuttingToolBind().getCode());
        List<SynthesisCuttingToolLocation> locations = locationService.getSynthesisCuttingToolLocationByPage(locationVO);

        for (SynthesisCuttingToolLocation location : locations) {
            if (StringUtils.isBlank(location.getSynthesisCuttingToolBindCode())){
                continue;
            }
            CuttingToolBind cuttingToolBind = null;
            DjItrnAkpVO djItrnAkpVO = new DjItrnAkpVO();
            if (!StringUtils.isBlank(location.getCuttingToolBladeCode())){
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setBladeCode(location.getCuttingToolBladeCode());
                cuttingToolBind = cuttingToolBindService.getCuttingToolBind(cuttingToolBindVO);
                djItrnAkpVO.setCasecode(cuttingToolBind.getBladeCode());
            }
            djItrnAkpVO.setDaojCase(location.getCuttingTool().getBusinessCode());
            djItrnAkp = djItrnAkpService.getLast(djItrnAkpVO);
            if (null!= djItrnAkp){
                DjItrnAkp djItrnAkpNew = djItrnAkp;
                djItrnAkpNew.setId(null);
                djItrnAkpNew.setBatchno(batchNo+1);
                djItrnAkpNew.setType(QiMingOptionEnum.installed.getKey());
                djItrnAkpNew.setGongw(productLine.getProductLineProcess().getName());
                djItrnAkpNew.setShengcx(productLine.getProductLineAssemblyline().getName());
                djItrnAkpNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                djItrnAkpNew.setNote(OperationEnum.SynthesisCuttingTool_Install.getName());
                if (null!=cuttingToolBind){
                    djItrnAkpNew.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
                }
                djItrnAkpService.addDjItrnAkp(djItrnAkpNew);
            }
        }
    }


    public void unBindEquipment(WBUnInstallVO wbUnInstallVO) throws Exception{
        UnBindEquipmentVO unBindEquipmentVO = wbUnInstallVO.getUnBindEquipmentVO();
        //合成刀卸下业务
        SynthesisCuttingToolBindleRecords bindleRecords = synthesisCuttingToolBusinessService.unBindData(unBindEquipmentVO,wbUnInstallVO.getAuthCustomer());


        RfidContainerVO rfidContainerVO = new RfidContainerVO();
        rfidContainerVO.setLaserCode(unBindEquipmentVO.getBindRfid());

        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
        synthesisCuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
        SynthesisCuttingToolBind synthesisCuttingToolBind = synthesisCuttingToolBindService.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);

        DjItrnAkp djItrnAkp = null;
        Integer batchNo = djItrnAkpService.getMaxBatchNo();
        SynthesisCuttingToolLocationVO locationVO = new SynthesisCuttingToolLocationVO();
        locationVO.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
        List<SynthesisCuttingToolLocation> locations = locationService.getSynthesisCuttingToolLocationByPage(locationVO);

        for (SynthesisCuttingToolLocation location : locations) {
            if (StringUtils.isBlank(location.getSynthesisCuttingToolBindCode())){
                continue;
            }
            CuttingToolBind cuttingToolBind = null;
            if (!StringUtils.isBlank(location.getCuttingToolBladeCode())){
                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setBladeCode(location.getCuttingToolBladeCode());
                cuttingToolBind = cuttingToolBindService.getCuttingToolBind(cuttingToolBindVO);
            }


            DjItrnAkpVO djItrnAkpVO = new DjItrnAkpVO();
            if (null != cuttingToolBind){
                djItrnAkpVO.setCasecode(cuttingToolBind.getBladeCode());
            }
            //根据刀身码查询
            djItrnAkpVO.setDaojCase(location.getCuttingTool().getBusinessCode());
            djItrnAkp = djItrnAkpService.getLast(djItrnAkpVO);
            if (null!= djItrnAkp){
                DjItrnAkp djItrnAkpNew = djItrnAkp;
                djItrnAkpNew.setId(null);
                djItrnAkpNew.setBatchno(batchNo+1);
                djItrnAkpNew.setJgcs(bindleRecords.getProcessingCount()+"");
                djItrnAkpNew.setJgsm(bindleRecords.getRatedNumber()+"");
                CuttingTool cuttingTool = location.getCuttingTool();
                if (cuttingTool.getGrinding().equals(GrindingEnum.inside.getKey())){
                    djItrnAkpNew.setType(QiMingOptionEnum.inside_sharpening.getKey());
                }
                if (cuttingTool.getGrinding().equals(GrindingEnum.outside_tuceng.getKey())){
                    djItrnAkpNew.setType(QiMingOptionEnum.outside_coating.getKey());
                }
                if (cuttingTool.getGrinding().equals(GrindingEnum.outside.getKey())){
                    djItrnAkpNew.setType(QiMingOptionEnum.outside_sharpening.getKey());
                }
                djItrnAkpNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
                djItrnAkpNew.setNote(OperationEnum.SynthesisCuttingTool_UnInstall.getName());
                if (null != cuttingToolBind){
                    djItrnAkpNew.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
                }
                djItrnAkpService.addDjItrnAkp(djItrnAkpNew);
            }
        }
    }

}
