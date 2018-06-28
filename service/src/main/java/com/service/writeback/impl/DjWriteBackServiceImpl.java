package com.service.writeback.impl;

import com.common.constants.GrindingEnum;
import com.common.constants.OperationEnum;
import com.common.constants.QiMingOptionEnum;
import com.common.mapper.IDjItrnAkpMapper;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.DjItrnAkp;
import com.common.pojo.SynthesisCuttingToolLocation;
import com.common.utils.FCBCodeHandler;
import com.common.utils.UUID;
import com.common.vo.CuttingToolVO;
import com.common.vo.DjItrnAkpVO;
import com.service.inoutFactory.bo.InOutGrindingBO;
import com.service.inoutFactory.vo.GrindingVO;
import com.service.scrap.bo.ScrapBO;
import com.service.scrap.vo.ScrapVO;
import com.service.writeback.IDjWriteBackService;
import com.service.orders.vo.OutApplyVO;
import com.service.orders.vo.WBCuttingToolBindVO;
import com.service.writeback.bo.InstallWBBO;
import com.service.writeback.bo.UnInstallWBBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by logan on 2018/5/7.
 */
@Service("DjWriteBackServiceImpl")
public class DjWriteBackServiceImpl implements IDjWriteBackService {

    @Autowired
    private IDjItrnAkpMapper djItrnAkpMapper;

    @Override
    public void writeBackOutLibrary(OutApplyVO outApplyVO) throws Exception {

        int count =1;
        if (outApplyVO.getCuttingToolBinds()!=null&&outApplyVO.getCuttingToolBinds().size()>0){
            count = outApplyVO.getCuttingToolBinds().size();
        }
        Integer batchNo = djItrnAkpMapper.getMaxBatchNo();
        if (null == batchNo){
            batchNo = 0;
        }
        int index = 0;
        do {
            DjItrnAkp djItrnAkp = new DjItrnAkp();
            //批次
            djItrnAkp.setBatchno(batchNo+1);
            //仓库
            djItrnAkp.setWhCode(outApplyVO.getDjCircleKanbanAkp().getWhCode());
            //供应商号
            djItrnAkp.setOwnerCode(outApplyVO.getDjCircleKanbanAkp().getOwnerCode());
            //物料号，加外委类型
            djItrnAkp.setMtlCode(outApplyVO.getDjCircleKanbanAkp().getMtlCode());
            //规格型号
            djItrnAkp.setGgxh(outApplyVO.getDjCircleKanbanAkp().getSusr2());
            //工位
            djItrnAkp.setGongw(outApplyVO.getDjOutapplyAkp().getLocation());
            //生产线
            djItrnAkp.setShengcx(outApplyVO.getDjOutapplyAkp().getProductline());
            //加工寿命  获取刀具的加工寿命
            djItrnAkp.setJgsm(outApplyVO.getDjOutapplyAkp().getDjqty());
            //价格
            djItrnAkp.setPrice(outApplyVO.getDjCircleKanbanAkp().getSusr3());
            //类型：N生成 U领用 R归还 S1车间刃磨 S2外委刃磨 S3直接外委 SR刃磨归还 SD刃磨报废 D报废
            if (StringUtils.isBlank(FCBCodeHandler.getFCBCodeSuffix(outApplyVO.getDjCircleKanbanAkp().getMtlCode()))){
                djItrnAkp.setType(QiMingOptionEnum.NewOutPreLibrary.getKey());
                djItrnAkp.setNote(QiMingOptionEnum.NewOutPreLibrary.getIcompName());
            }else{
                djItrnAkp.setType(QiMingOptionEnum.OutPreLibrary.getKey());
                djItrnAkp.setNote(QiMingOptionEnum.OutPreLibrary.getIcompName());
            }
            //外委单号
            djItrnAkp.setCode(UUID.getInstance());
            if (outApplyVO.getCuttingToolBinds()!=null){
                CuttingToolBind cuttingToolBind = outApplyVO.getCuttingToolBinds().get(index);
                djItrnAkp.setJgcs(cuttingToolBind.getJgcs()+"");
                djItrnAkp.setLhcs(cuttingToolBind.getLhcs()+"");
                djItrnAkp.setSharpenTimes(cuttingToolBind.getSharpenTimes());
                djItrnAkp.setCasecode(cuttingToolBind.getBladeCode());
                djItrnAkp.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
            }
            //实际加工寿命，加工次数
//            djItrnAkp.setCreateBy(outApplyVO.getOpratorName());
            djItrnAkp.setCreateDate(outApplyVO.getOpratorTime());
            djItrnAkp.setKanbanCode(outApplyVO.getDjMtlAkp().getSusr11());
            djItrnAkp.setMaxDjh(outApplyVO.getSusr20()+"");
            djItrnAkp.setDaojCase(outApplyVO.getDjMtlAkp().getSusr11());
            djItrnAkp.setCKanbanCode(outApplyVO.getDjOutapplyAkp().getLltm());
            djItrnAkpMapper.addDjItrnAkp(djItrnAkp);
            index++;
        }while (index<count);
    }

    @Override
    public void writeBackCuttingToolBind(WBCuttingToolBindVO wbCuttingToolBindVO) throws Exception {
        Integer batchNo = djItrnAkpMapper.getMaxBatchNo();
        if (null == batchNo) {
            batchNo = 0;
        }
        DjItrnAkp djItrnAkp = null;
        //根据刀身码查询
        DjItrnAkpVO djItrnAkpVO = new DjItrnAkpVO();
        CuttingToolVO cuttingToolVO = new CuttingToolVO();
        if(!StringUtils.isBlank(wbCuttingToolBindVO.getCuttingToolBind().getBladeCode())){
            djItrnAkpVO.setCasecode(wbCuttingToolBindVO.getCuttingToolBind().getBladeCode());
        }
        djItrnAkpVO.setDaojCase(wbCuttingToolBindVO.getCuttingToolBind().getCuttingTool().getBusinessCode());
        djItrnAkp = djItrnAkpMapper.getLast(djItrnAkpVO);
        if (null == djItrnAkp){
            djItrnAkp = new DjItrnAkp();
        }

        djItrnAkp.setCode(UUID.getInstance());
        djItrnAkp.setBatchno(batchNo+1);
        djItrnAkp.setType(QiMingOptionEnum.Cutting_tool_Bind.getKey());
        djItrnAkp.setNote(OperationEnum.Cutting_tool_Bind.getName());
        djItrnAkp.setCreateDate(new Timestamp(System.currentTimeMillis()));
        djItrnAkp.setRfid(wbCuttingToolBindVO.getCuttingToolBind().getRfidContainer().getLaserCode());
        djItrnAkpMapper.addDjItrnAkp(djItrnAkp);
    }

    @Override
    public void writeBackOutLibrary0609(OutApplyVO outApplyVO) throws Exception {
        int count =1;
        if (outApplyVO.getCuttingToolBinds()!=null&&outApplyVO.getCuttingToolBinds().size()>0){
            count = outApplyVO.getCuttingToolBinds().size();
        }
        int index = 0;
        do {
            DjItrnAkp djItrnAkp = new DjItrnAkp();
            //批次
            djItrnAkp.setBatchno(outApplyVO.getBatchNo()+1);
            //仓库
            djItrnAkp.setWhCode(outApplyVO.getDjCircleKanbanAkp().getWhCode());
            //供应商号
            djItrnAkp.setOwnerCode(outApplyVO.getDjCircleKanbanAkp().getOwnerCode());
            //物料号，加外委类型
            djItrnAkp.setMtlCode(outApplyVO.getDjCircleKanbanAkp().getMtlCode());
            //规格型号
            djItrnAkp.setGgxh(outApplyVO.getDjCircleKanbanAkp().getSusr2());
            //工位
            djItrnAkp.setGongw(outApplyVO.getDjOutapplyAkp().getLocation());
            //生产线
            djItrnAkp.setShengcx(outApplyVO.getDjOutapplyAkp().getProductline());
            //加工寿命  获取刀具的加工寿命
            djItrnAkp.setJgsm(outApplyVO.getDjOutapplyAkp().getDjqty());
            //价格
            djItrnAkp.setPrice(outApplyVO.getDjCircleKanbanAkp().getSusr3());
            //类型：N生成 U领用 R归还 S1车间刃磨 S2外委刃磨 S3直接外委 SR刃磨归还 SD刃磨报废 D报废
            if (StringUtils.isBlank(FCBCodeHandler.getFCBCodeSuffix(outApplyVO.getMtlCode()))){
                djItrnAkp.setType(QiMingOptionEnum.NewOutPreLibrary.getKey());
                djItrnAkp.setNote(QiMingOptionEnum.NewOutPreLibrary.getName());
            }else{
                djItrnAkp.setType(QiMingOptionEnum.OutPreLibrary.getKey());
                djItrnAkp.setNote(QiMingOptionEnum.OutPreLibrary.getName());
            }
            //外委单号
            djItrnAkp.setCode(UUID.getInstance());
            if (outApplyVO.getCuttingToolBinds()!=null){
                CuttingToolBind cuttingToolBind = outApplyVO.getCuttingToolBinds().get(index);
                djItrnAkp.setJgcs(cuttingToolBind.getJgcs()+"");
                if (null!=cuttingToolBind.getRfidContainer()){
                    djItrnAkp.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
                }
                djItrnAkp.setLhcs(cuttingToolBind.getLhcs()+"");
                djItrnAkp.setSharpenTimes(cuttingToolBind.getSharpenTimes());
                djItrnAkp.setCasecode(cuttingToolBind.getBladeCode());
            }
            //todo 为提供用户与启明用户的匹配规则
//            djItrnAkp.setCreateBy(outApplyVO.getOpratorName());
            djItrnAkp.setCreateDate(outApplyVO.getOpratorTime());
            djItrnAkp.setKanbanCode(outApplyVO.getDjOutapplyAkp().getApplyno());
            djItrnAkp.setMaxDjh(outApplyVO.getMaxDJH()+"");
            djItrnAkp.setDaojCase(outApplyVO.getDjMtlAkp().getSusr11());
            djItrnAkp.setCKanbanCode(outApplyVO.getDjOutapplyAkp().getLltm());
            djItrnAkpMapper.addDjItrnAkp(djItrnAkp);
            index++;
        }while (index<count);
    }

    /**
     * 安上设备回写
     * @param installWBBO 业务封装
     * @throws Exception
     */
    @Override
    public void writeBackInstall(InstallWBBO installWBBO) throws Exception {
        Integer batchNo = djItrnAkpMapper.getMaxBatchNo();
        if (null == batchNo){
            batchNo = 0;
        }
        DjItrnAkp djItrnAkp = null;
        CuttingToolBind cuttingToolBind = null;
        DjItrnAkpVO djItrnAkpVO = null;
        for (SynthesisCuttingToolLocation location : installWBBO.getLocationList()) {
            djItrnAkpVO = new DjItrnAkpVO();
            if (!StringUtils.isBlank(location.getCuttingToolBladeCode())){
                djItrnAkpVO.setCasecode(location.getCuttingToolBladeCode());
            }
            djItrnAkpVO.setDaojCase(location.getCuttingTool().getBusinessCode());
            djItrnAkp = djItrnAkpMapper.getLast(djItrnAkpVO);
            if (null == djItrnAkp){
                djItrnAkp = new DjItrnAkp();
            }
            djItrnAkp.setCode(UUID.getInstance());
            djItrnAkp.setBatchno(batchNo+1);
            djItrnAkp.setType(QiMingOptionEnum.installed.getKey());
            djItrnAkp.setGongw(installWBBO.getProductLine().getProductLineProcess().getName());
            djItrnAkp.setShengcx(installWBBO.getProductLine().getProductLineAssemblyline().getName());
            djItrnAkp.setCreateDate(new Timestamp(System.currentTimeMillis()));
            djItrnAkp.setCreateBy(installWBBO.getLoginUser().getId());
            djItrnAkp.setNote(OperationEnum.SynthesisCuttingTool_Install.getName());
            if (null!=cuttingToolBind){
                djItrnAkp.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
            }
            djItrnAkpMapper.addDjItrnAkp(djItrnAkp);
        }
    }

    /**
     * 卸下设备回写
     * @param unInstallWBBO
     * @throws Exception
     */
    @Override
    public void writeBackUnInstall(UnInstallWBBO unInstallWBBO) throws Exception {
        Integer batchNo = djItrnAkpMapper.getMaxBatchNo();
        if (null == batchNo){
            batchNo = 0;
        }
        DjItrnAkp djItrnAkp = null;
        DjItrnAkpVO djItrnAkpVO = null;
        for (SynthesisCuttingToolLocation location : unInstallWBBO.getLocationList()) {
            djItrnAkpVO = new DjItrnAkpVO();
            if (!StringUtils.isBlank(location.getCuttingToolBladeCode())){
                djItrnAkpVO.setCasecode(location.getCuttingToolBladeCode());
            }
            djItrnAkpVO.setDaojCase(location.getCuttingTool().getBusinessCode());
            djItrnAkp = djItrnAkpMapper.getLast(djItrnAkpVO);
            if (null == djItrnAkp){
                djItrnAkp = new DjItrnAkp();
            }
            djItrnAkp.setCode(UUID.getInstance());
            djItrnAkp.setBatchno(batchNo+1);
            djItrnAkp.setGongw(unInstallWBBO.getBindleRecords().getProductLineProcess().getName());
            djItrnAkp.setShengcx(unInstallWBBO.getBindleRecords().getProductLineAssemblyline().getName());
            djItrnAkp.setCreateDate(new Timestamp(System.currentTimeMillis()));
            djItrnAkp.setCreateBy(unInstallWBBO.getLoginUser().getId());
            djItrnAkp.setType(QiMingOptionEnum.to_exchange.getKey());
            djItrnAkp.setNote(QiMingOptionEnum.to_exchange.getName());
            djItrnAkpMapper.addDjItrnAkp(djItrnAkp);
        }
    }

    /**
     * 场内刃磨回写
     * @param inOutGrindingBO 业务数据封装
     * @throws Exception
     */
    @Override
    public void writeBackGrindingIn(InOutGrindingBO inOutGrindingBO) throws Exception {
        Integer batchNo = djItrnAkpMapper.getMaxBatchNo();
        if (null == batchNo){
            batchNo = 0;
        }
        DjItrnAkp djItrnAkp = null;
        DjItrnAkpVO djItrnAkpVO = null;
        for (GrindingVO grindingVO : inOutGrindingBO.getGrindingVOS()) {
            djItrnAkpVO = new DjItrnAkpVO();
            if (!StringUtils.isBlank(grindingVO.getCuttingToolBind().getBladeCode())){
                djItrnAkpVO.setCasecode(grindingVO.getCuttingToolBind().getBladeCode());
            }
            djItrnAkpVO.setDaojCase(grindingVO.getCuttingTool().getBusinessCode());
            djItrnAkp = djItrnAkpMapper.getLast(djItrnAkpVO);
            if (null == djItrnAkp){
                djItrnAkp = new DjItrnAkp();
            }
            djItrnAkp.setCode(UUID.getInstance());
            djItrnAkp.setBatchno(batchNo+1);
            djItrnAkp.setCreateDate(new Timestamp(System.currentTimeMillis()));
            djItrnAkp.setCreateBy(inOutGrindingBO.getLoginUser().getId());

            if (grindingVO.getCuttingToolBind()!=null){
                djItrnAkp.setJgcs(grindingVO.getCuttingToolBind().getJgcs()+"");
                djItrnAkp.setLhcs(grindingVO.getCuttingToolBind().getLhcs()+"");
            }
            djItrnAkp.setType(QiMingOptionEnum.inside_sharpening.getKey());
            djItrnAkp.setNote(OperationEnum.Cutting_tool_Inside.getName());
            djItrnAkpMapper.addDjItrnAkp(djItrnAkp);
        }
    }

    /**
     * 厂外刃磨回写
     * @param inOutGrindingBO 业务数据封装
     * @throws Exception
     */
    @Override
    public void writeBackGrindingOut(InOutGrindingBO inOutGrindingBO) throws Exception {
        Integer batchNo = djItrnAkpMapper.getMaxBatchNo();
        if (null == batchNo){
            batchNo = 0;
        }
        DjItrnAkp djItrnAkp = null;
        DjItrnAkpVO djItrnAkpVO = null;
        for (GrindingVO grindingVO : inOutGrindingBO.getGrindingVOS()) {
            djItrnAkpVO = new DjItrnAkpVO();
            if (null!=grindingVO.getCuttingToolBind()&&!StringUtils.isBlank(grindingVO.getCuttingToolBind().getBladeCode())){
                djItrnAkpVO.setCasecode(grindingVO.getCuttingToolBind().getBladeCode());
            }
            djItrnAkpVO.setDaojCase(grindingVO.getCuttingTool().getBusinessCode());
            djItrnAkp = djItrnAkpMapper.getLast(djItrnAkpVO);
            if (null == djItrnAkp){
                djItrnAkp = new DjItrnAkp();
            }
            djItrnAkp.setCode(UUID.getInstance());
            djItrnAkp.setBatchno(batchNo+1);
            djItrnAkp.setCreateDate(new Timestamp(System.currentTimeMillis()));
            djItrnAkp.setCreateBy(inOutGrindingBO.getLoginUser().getId());

            if (grindingVO.getCuttingToolBind()!=null){
                djItrnAkp.setJgcs(grindingVO.getCuttingToolBind().getJgcs()+"");
                djItrnAkp.setLhcs(grindingVO.getCuttingToolBind().getLhcs()+"");
            }
            //判断是否为外委涂层
            djItrnAkp.setType(QiMingOptionEnum.outside_sharpening.getKey());
            djItrnAkp.setNote(OperationEnum.Cutting_tool_OutSide.getName());
            if (!StringUtils.isBlank(grindingVO.getCuttingTool().getGrinding())){
                if (grindingVO.getCuttingTool().getGrinding().equals(GrindingEnum.outside_tuceng.getKey())){
                    djItrnAkp.setType(QiMingOptionEnum.outside_coating.getKey());
                    djItrnAkp.setNote(OperationEnum.Cutting_tool_Inside_Coating.getName());
                }
            }
            djItrnAkp.setWwOwner(inOutGrindingBO.getSharpenProviderCode());
            djItrnAkp.setWwcode(inOutGrindingBO.getOrderNum());
            djItrnAkp.setZcCode(inOutGrindingBO.getZcCode());
            djItrnAkpMapper.addDjItrnAkp(djItrnAkp);
        }
    }

    /**
     * 刀具报废数据回写
     * @param  scrapBO 业务数据封装
     * @throws Exception
     */
    @Override
    public void writeBackScrap(ScrapBO scrapBO) throws Exception {
        Integer batchNo = djItrnAkpMapper.getMaxBatchNo();
        if (null == batchNo){
            batchNo = 0;
        }
        DjItrnAkp djItrnAkp = null;
        DjItrnAkpVO djItrnAkpVO = null;
        for (ScrapVO scrapVO : scrapBO.getScrapVOS()) {
            djItrnAkpVO = new DjItrnAkpVO();
            if (null!=scrapVO.getCuttingToolBind()&&!StringUtils.isBlank(scrapVO.getCuttingToolBind().getBladeCode())){
                djItrnAkpVO.setCasecode(scrapVO.getCuttingToolBind().getBladeCode());
            }
            djItrnAkpVO.setDaojCase(scrapVO.getCuttingTool().getBusinessCode());
            djItrnAkp = djItrnAkpMapper.getLast(djItrnAkpVO);
            if (null == djItrnAkp){
                djItrnAkp = new DjItrnAkp();
            }
            djItrnAkp.setCode(UUID.getInstance());
            djItrnAkp.setBatchno(batchNo+1);
            djItrnAkp.setCreateDate(new Timestamp(System.currentTimeMillis()));
            djItrnAkp.setCreateBy(scrapBO.getLoginUser().getId());
            if (scrapVO.getCuttingToolBind()!=null){
                djItrnAkp.setJgcs(scrapVO.getCuttingToolBind().getJgcs()+"");
                djItrnAkp.setLhcs(scrapVO.getCuttingToolBind().getLhcs()+"");
                djItrnAkp.setCasecode(scrapVO.getCuttingToolBind().getBladeCode());
            }
            djItrnAkp.setType(QiMingOptionEnum.scap.getKey());
            djItrnAkp.setNote(OperationEnum.Cutting_tool_scap.getName());
            djItrnAkpMapper.addDjItrnAkp(djItrnAkp);
        }
    }
}
