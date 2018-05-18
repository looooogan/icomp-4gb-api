package com.service.orders.impl;

import com.common.constants.ConsumeTypeEnum;
import com.common.constants.GrindingEnum;
import com.common.mapper.*;
import com.common.pojo.*;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.*;
import com.service.orders.IOutApplyBusinessService;
import com.service.orders.vo.OutApplyVO;
import com.service.orders.vo.WBOutApplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by logan on 2018/5/7.
 */
@Service("OutApplyService")
public class OutApplyBusinessServiceImpl implements IOutApplyBusinessService {

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;
    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;
    @Autowired
    private IMaterialInventoryMapper materialInventoryMapper;
    @Autowired
    private IAuthCustomerMapper customerMapper;
    @Autowired
    private IOutPrepareLibraryMapper outPrepareLibraryMapper;

    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;
    @Autowired
    private IQimingRecordsMapper qimingRecordsMapper;

    @Autowired
    private IDjOutapplyAkpMapper djOutapplyAkpMapper;
    @Autowired
    private IDjCircleKanbanAkpMapper djCircleKanbanAkpMapper;
    @Autowired
    private IDjMtlAkpMapper djMtlAkpMapper;


    /**
     * 出库
     * @param outApplyVO
     * @throws Exception
     */
    @Override
    public void outApplyData(OutApplyVO outApplyVO) throws Exception {
        //查询刀具信息
        CuttingToolVO cuttingToolVO = new CuttingToolVO();
        cuttingToolVO.setBusinessCode(outApplyVO.getDjCircleKanbanAkp().getLoc());
        CuttingTool cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
        if (null == cuttingTool){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.CUTTINGTOOL_NOT_EXISTS));
        }

        QimingRecords qimingRecords = null;
        Integer batchNo = qimingRecordsMapper.getMaxBatchNo();
        if (batchNo == null){
            batchNo = 0;
        }
        //计算批次
        outApplyVO.setBatchNo(batchNo+1);

        RfidContainerVO linglRfidContainerVO = new RfidContainerVO();
        linglRfidContainerVO.setLaserCode(outApplyVO.getLinglOperatorRfidCode());
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setRfidContainerVO(linglRfidContainerVO);
        AuthCustomer lingl = customerMapper.getAuthCustomer(authCustomerVO);

        outApplyVO.setOpratorName(lingl.getName());
        outApplyVO.setOpratorTime(new Timestamp(System.currentTimeMillis()));

        RfidContainerVO kezhangRfidContainerVO = new RfidContainerVO();
        kezhangRfidContainerVO.setLaserCode(outApplyVO.getKezhangRfidCode());
        AuthCustomerVO kezhangAuthCustomerVO = new AuthCustomerVO();
        kezhangAuthCustomerVO.setRfidContainerVO(kezhangRfidContainerVO);
        AuthCustomer kezhang = customerMapper.getAuthCustomer(kezhangAuthCustomerVO);

        AuthCustomerVO kuguanVo = new AuthCustomerVO();
        kuguanVo.setCode(outApplyVO.getKuguanOperatorCode());
        AuthCustomer kuguan = customerMapper.getAuthCustomer(kezhangAuthCustomerVO);

        //添加出库记录
        OutPrepareLibrary outPrepareLibrary = new OutPrepareLibrary();
        outPrepareLibrary.setApplyNo(outApplyVO.getDjOutapplyAkp().getApplyno());
        outPrepareLibrary.setUnitqty(outApplyVO.getDjOutapplyAkp().getUnitqty());
        outPrepareLibrary.setMtlCode(outApplyVO.getDjOutapplyAkp().getMtlno());
        outPrepareLibrary.setLoc(outApplyVO.getDjCircleKanbanAkp().getLoc());
        outPrepareLibrary.setIsDel(0);
        outPrepareLibrary.setCuttingToolCode(cuttingTool.getCode());
        outPrepareLibrary.setProductlineProcess(outApplyVO.getDjOutapplyAkp().getLocation());
        outPrepareLibrary.setProductlineAssemblyline(outApplyVO.getDjOutapplyAkp().getProductline());
        outPrepareLibrary.setPlant(outApplyVO.getDjOutapplyAkp().getPlant());
        outPrepareLibrary.setKuguanOperatorCode(kuguan.getCode());
        outPrepareLibrary.setKuguanOperatorName(kuguan.getName());
        outPrepareLibrary.setLinglOperatorCode(lingl.getCode());
        outPrepareLibrary.setLinglOperatorName(lingl.getName());
        outPrepareLibrary.setKezhangCode(kezhang.getCode());
        outPrepareLibrary.setKezhangName(kezhang.getName());
        outPrepareLibrary.setCreateTime(new Timestamp(System.currentTimeMillis()));
        outPrepareLibraryMapper.addOutPrepareLibrary(outPrepareLibrary);

        if (cuttingTool.getConsumeType().equals(ConsumeTypeEnum.Applicable_Bit.getKey())){
            //可刃磨钻头
            List<CuttingToolBind> cuttingToolBinds= new ArrayList<>();
            for (Integer i = 0; i < outApplyVO.getUnitqty(); i++) {
                //创建材料刀bind
                CuttingToolBind cuttingToolBind = new CuttingToolBind();
                cuttingToolBind.setCuttingToolCode(cuttingTool.getCode());
                outApplyVO.setSusr20(outApplyVO.getSusr20()+1);
                cuttingToolBind.setBladeCode(outApplyVO.getDjMtlAkp().getMtlCode()+"-"+outApplyVO.getSusr20());
                cuttingToolBind.setCode(UUID.getInstance());
                cuttingToolBind.setLltm(outApplyVO.getDjOutapplyAkp().getLltm());
                cuttingToolBind.setIsDel(0);
                cuttingToolBindMapper.addCuttingToolBind(cuttingToolBind);

                cuttingToolBinds.add(cuttingToolBind);

                //添加历史记录
                qimingRecords = new QimingRecords();
                qimingRecords.setApplyNo(outApplyVO.getDjOutapplyAkp().getApplyno());
                qimingRecords.setBatchNo(batchNo+1);
                qimingRecords.setCuttingToolBindCode(cuttingToolBind.getCode());
                qimingRecords.setCuttingToolCode(cuttingTool.getCode());
                qimingRecords.setBladeCode(cuttingToolBind.getBladeCode());
                qimingRecords.setIsDel(0);
                qimingRecords.setLoc(outApplyVO.getDjCircleKanbanAkp().getLoc());
                qimingRecords.setMtlCode(outApplyVO.getDjOutapplyAkp().getMtlno());
                qimingRecords.setUnitqty(outApplyVO.getDjOutapplyAkp().getUnitqty());
                qimingRecordsMapper.addQimingRecords(qimingRecords);
            }
            outApplyVO.setCuttingToolBinds(cuttingToolBinds);
        }else {
            qimingRecords = new QimingRecords();
            qimingRecords.setApplyNo(outApplyVO.getDjOutapplyAkp().getApplyno());
            qimingRecords.setBatchNo(batchNo+1);
            qimingRecords.setCuttingToolCode(cuttingTool.getCode());
            qimingRecords.setIsDel(0);
            qimingRecords.setLoc(outApplyVO.getDjCircleKanbanAkp().getLoc());
            qimingRecords.setMtlCode(outApplyVO.getDjOutapplyAkp().getMtlno());
            qimingRecords.setUnitqty(outApplyVO.getDjOutapplyAkp().getUnitqty());
            qimingRecordsMapper.addQimingRecords(qimingRecords);
        }

        MaterialInventoryVO materialInventoryVO = new MaterialInventoryVO();
        materialInventoryVO.setCuttingToolCode(cuttingTool.getCode());
        MaterialInventory materialInventory = materialInventoryMapper.getMaterialInventory(materialInventoryVO);
        //添加材料刀备用刀库数量
        if (null == materialInventory) {
            materialInventory = new MaterialInventory();
            materialInventory.setIsDel(0);
            materialInventory.setCuttingToolCode(cuttingTool.getCode());
            materialInventory.setPrepareLibraryCount(Integer.parseInt(outApplyVO.getDjOutapplyAkp().getUnitqty()));
            materialInventory.setProductLineCount(0);
            materialInventory.setToExchangeCount(0);
            materialInventory.setGrindingOutCount(0);
            materialInventory.setScrapCount(0);
            materialInventory.setForGrindingInCount(0);
            materialInventory.setForGrindingOutCount(0);
            materialInventoryMapper.addMaterialInventory(materialInventory);
        } else {
            // todo 如果是外委回来  减少待回厂数量
            materialInventory.setPrepareLibraryCount(materialInventory.getPrepareLibraryCount()+Integer.parseInt(outApplyVO.getDjOutapplyAkp().getUnitqty()));
            materialInventoryMapper.updMaterialInventory(materialInventory);
        }
    }


}
