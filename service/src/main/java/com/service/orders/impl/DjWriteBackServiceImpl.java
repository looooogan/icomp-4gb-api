package com.service.orders.impl;

import com.common.constants.OperationEnum;
import com.common.constants.QiMingOptionEnum;
import com.common.mapper.IDjItrnAkpMapper;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.DjItrnAkp;
import com.common.utils.FCBCodeHandler;
import com.common.utils.UUID;
import com.common.vo.CuttingToolVO;
import com.common.vo.DjItrnAkpVO;
import com.service.orders.IDjWriteBackService;
import com.service.orders.vo.OutApplyVO;
import com.service.orders.vo.WBCuttingToolBindVO;
import com.service.orders.vo.WBUnInstallVO;
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
            //todo  修改 外委部分的回库
            djItrnAkp.setType(QiMingOptionEnum.NewOutPreLibrary.getKey());
            //外委单号
            djItrnAkp.setWwcode("");
            djItrnAkp.setCode(UUID.getInstance());
            if (outApplyVO.getCuttingToolBinds()!=null){
                CuttingToolBind cuttingToolBind = outApplyVO.getCuttingToolBinds().get(index);
                djItrnAkp.setJgcs(cuttingToolBind.getJgcs()+"");
                //djItrnAkp
                djItrnAkp.setLhcs(cuttingToolBind.getLhcs()+"");
                djItrnAkp.setSharpenTimes(cuttingToolBind.getSharpenTimes());
                djItrnAkp.setCasecode(cuttingToolBind.getBladeCode());
            }

            //实际加工寿命，加工次数

            //归还类型 1外委归还 2刃磨归还 3报废
//            djItrnAkp.setReturnType();
//            djItrnAkp.setCreateBy(outApplyVO.getOpratorName());
            djItrnAkp.setCreateDate(outApplyVO.getOpratorTime());
            //刃磨次数

            //报废原因
            djItrnAkp.setKanbanCode(outApplyVO.getDjMtlAkp().getSusr11());
            djItrnAkp.setMaxDjh(outApplyVO.getSusr20()+"");

//            djItrnAkp.setRfid(cuttingToolBind.getRfidContainer().getLaserCode());
            //刀身码
            djItrnAkp.setDaojCase(outApplyVO.getDjMtlAkp().getSusr11());

            djItrnAkp.setCKanbanCode(outApplyVO.getDjOutapplyAkp().getLltm());
            //todo 判断外委号   如果是外
            if (1==1){
                djItrnAkp.setNote(QiMingOptionEnum.NewOutPreLibrary.getIcompName());
            }else{
                djItrnAkp.setNote(QiMingOptionEnum.NewOutPreLibrary.getIcompName());
            }

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
            djItrnAkp.setKanbanCode(outApplyVO.getDjCircleKanbanAkp().getCKanbanCode());
            djItrnAkp.setMaxDjh(outApplyVO.getMaxDJH()+"");
            djItrnAkp.setDaojCase(outApplyVO.getDjMtlAkp().getSusr11());
            djItrnAkp.setCKanbanCode(outApplyVO.getDjOutapplyAkp().getLltm());
            djItrnAkpMapper.addDjItrnAkp(djItrnAkp);
            index++;
        }while (index<count);
    }
}
