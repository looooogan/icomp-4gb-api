package com.service.synthesiscuttingtool;

import com.common.constants.*;
import com.common.pojo.*;
import com.common.utils.UUID;
import com.common.vo.*;
import com.service.common.*;
import com.service.writeback.IDjWriteBackService;
import com.service.orders.vo.WBUnInstallVO;
import com.service.synthesiscuttingtool.bo.SynthesisExchangeBO;
import com.service.synthesiscuttingtool.bo.SynthesisInitBO;
import com.service.synthesiscuttingtool.vo.*;
import com.service.system.ISystemBusinessService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by logan on 2018/5/7.
 */
@Component("synthesiscuttingtoolComent")
public class synthesiscuttingtoolComent {

    @Autowired
    private IAuthCustomerService authCustomerService;
    @Autowired
    private ISynthesisCuttingToolBusinessService synthesisCuttingToolBusinessService;

    /**
     * 合成刀初始化Component
     * @param synthesisInitBO
     * @throws Exception
     */
    public void init(SynthesisInitBO synthesisInitBO) throws Exception{
        //执行合成刀绑定
        synthesisCuttingToolBusinessService.addInitSynthesisCuttingTool(synthesisInitBO);
    }

    /**
     * 合成刀换装
     * @param exChangeVO
     * @throws Exception
     */
    public void exChange(ExChangeVO exChangeVO,AuthCustomer authCustomer) throws Exception{

        //组装业务数据
        SynthesisExchangeBO synthesisExchangeBO = new SynthesisExchangeBO();
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomer.getCode());
        synthesisExchangeBO.setLoginUser(authCustomerService.getAuthCustomer(authCustomerVO));
        synthesisExchangeBO.setSynthesisCuttingToolBindVO(exChangeVO.getSynthesisCuttingToolBindVO());
        synthesisExchangeBO.setUpCuttingToolVOS(exChangeVO.getUpCuttingToolVOS());
        synthesisExchangeBO.setDownCuttingToolVOS(exChangeVO.getDownCuttingToolVOS());
        //执行刀具换装
        synthesisCuttingToolBusinessService.exChangeData(synthesisExchangeBO);
    }


    public void BreakUp(BreakUpVO breakUpVO,AuthCustomer authCustomer) throws Exception{
//        synthesisCuttingToolBusinessService.writeSynthesisCuttingToolBreakUp(breakUpVO,authCustomer);
//        Integer batchNo = djItrnAkpService.getMaxBatchNo();
//        if (null == batchNo){
//            batchNo = 0;
//        }
//        DjItrnAkp djItrnAkp = null;
//        for (DownCuttingToolVO downCuttingToolVO : breakUpVO.getDownCuttingToolVOS()) {
//            DjItrnAkpVO djItrnAkpVO = new DjItrnAkpVO();
//            CuttingToolBind cuttingToolBind = null;
//            if (!StringUtils.isBlank(downCuttingToolVO.getDownRfidCode())){
//                RfidContainerVO rfidContainerVO = new RfidContainerVO();
//                rfidContainerVO.setLaserCode(downCuttingToolVO.getDownRfidCode());
//                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
//                cuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
//                cuttingToolBind = cuttingToolBindService.getCuttingToolBind(cuttingToolBindVO);
//            }
//
//            if (null != cuttingToolBind){
//                djItrnAkpVO.setCasecode(cuttingToolBind.getBladeCode());
//            }
//            djItrnAkpVO.setDaojCase(downCuttingToolVO.getDownCode());
//            djItrnAkp = djItrnAkpService.getLast(djItrnAkpVO);
//            if (null == djItrnAkp){
//                djItrnAkp = new DjItrnAkp();
//            }
//
//            CuttingToolVO cuttingToolVO = new CuttingToolVO();
//            cuttingToolVO.setBusinessCode(downCuttingToolVO.getDownCode());
//            CuttingTool cuttingTool = cuttingToolService.getCuttingTool(cuttingToolVO);
//
//            djItrnAkp.setCode(UUID.getInstance());
//            djItrnAkp.setBatchno(batchNo+1);
//            //如果从设备上卸下之后换装则写出加工量
////            if (sRfidContainer.getOperatorCode()==OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
////                //额定加工量
////                djItrnAkp.setJgsm(bindleRecords.getRatedNumber()+"");
////                //实际加工量
////                djItrnAkp.setJgcs(bindleRecords.getProcessingCount()+"");
////            }
//            if (cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_zt.getKey())){
//                if (cuttingTool.getGrinding().equals(GrindingEnum.inside.getKey())){
//                    djItrnAkp.setType(QiMingOptionEnum.inside_sharpening.getKey());
//                }
//                if (cuttingTool.getGrinding().equals(GrindingEnum.outside_tuceng.getKey())){
//                    djItrnAkp.setType(QiMingOptionEnum.outside_coating.getKey());
//                }
//                if (cuttingTool.getGrinding().equals(GrindingEnum.outside.getKey())){
//                    djItrnAkp.setType(QiMingOptionEnum.outside_sharpening.getKey());
//                }
//
//            }
//            djItrnAkp.setNote(OperationEnum.SynthesisCuttingTool_UnConfig.getName());
//            if (null != cuttingToolBind){
//                djItrnAkp.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
//            }
//            djItrnAkpService.addDjItrnAkp(djItrnAkp);
//        }
    }

    public void packageUp(PackageUpVO packageUpVO,AuthCustomer authCustomer) throws Exception{
//        synthesisCuttingToolBusinessService.writeSynthesisCuttingToolPackageUp(packageUpVO,authCustomer);
//        DjItrnAkp djItrnAkp = null;
//        Integer batchNo = djItrnAkpService.getMaxBatchNo();
//        if (null == batchNo){
//            batchNo = 0;
//        }
//        for (UpCuttingToolVO upCuttingToolVO : packageUpVO.getUpCuttingToolVOS()) {
//            DjItrnAkpVO djItrnAkpVO = new DjItrnAkpVO();
//            CuttingToolBind cuttingToolBind = null;
//            if (!StringUtils.isBlank(upCuttingToolVO.getRfidCode())){
//                RfidContainerVO rfidContainerVO = new RfidContainerVO();
//                rfidContainerVO.setLaserCode(upCuttingToolVO.getRfidCode());
//                CuttingToolBindVO cuttingToolBindVO = new CuttingToolBindVO();
//                cuttingToolBindVO.setRfidContainerVO(rfidContainerVO);
//                cuttingToolBind = cuttingToolBindService.getCuttingToolBind(cuttingToolBindVO);
//                if (null != cuttingToolBind){
//                    djItrnAkpVO.setCasecode(cuttingToolBind.getBladeCode());
//                }
//            }
//            //根据刀身码查询
//            djItrnAkpVO.setDaojCase(upCuttingToolVO.getUpCode());
//            djItrnAkp = djItrnAkpService.getLast(djItrnAkpVO);
//            if (null == djItrnAkp){
//                djItrnAkp = new DjItrnAkp();
//            }
//            djItrnAkp.setCode(UUID.getInstance());
//            djItrnAkp.setBatchno(batchNo+1);
//            djItrnAkp.setCreateDate(new Timestamp(System.currentTimeMillis()));
//            djItrnAkp.setType(QiMingOptionEnum.to_install.getKey());
//            djItrnAkp.setNote(OperationEnum.SynthesisCuttingTool_Config.getName());
//            if (null != cuttingToolBind){
//                djItrnAkp.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
//            }
//            djItrnAkpService.addDjItrnAkp(djItrnAkp);
//        }
    }



}
