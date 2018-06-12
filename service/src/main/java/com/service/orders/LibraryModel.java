package com.service.orders;

import com.common.constants.ConsumeTypeEnum;
import com.common.constants.OperationEnum;
import com.common.mapper.ICuttingToolBindMapper;
import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.IOutPrepareLibraryMapper;
import com.common.mapper.IQimingRecordsMapper;
import com.common.pojo.*;
import com.common.utils.UUID;
import com.common.vo.CuttingToolVO;
import com.common.vo.MaterialInventoryVO;
import com.common.vo.RfidContainerVO;
import com.service.materialInventory.MaterialInventoryModel;
import com.service.orders.vo.OutApplyVO;
import com.service.rfid.RfidModel;
import com.service.rfid.vo.RFIDBindVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by logan on 2018/6/11.
 */
@Component("LibraryModel")
public class LibraryModel {
    @Autowired
    private ICuttingToolMapper cuttingToolMapper;
    @Autowired
    private IOutPrepareLibraryMapper outPrepareLibraryMapper;
    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;
    @Autowired
    private IQimingRecordsMapper qimingRecordsMapper;
    @Autowired
    private RfidModel rfidModel;
    @Autowired
    private MaterialInventoryModel materialInventoryModel;

    /**
     * 添加出库记录
     * @throws Exception
     */
    public void addOutPrepareLibraryRecorders(OutApplyVO outApplyVO) throws Exception{
        //添加出库记录
        OutPrepareLibrary outPrepareLibrary = new OutPrepareLibrary();
        outPrepareLibrary.setApplyNo(outApplyVO.getDjOutapplyAkp().getApplyno());
        outPrepareLibrary.setUnitqty(outApplyVO.getDjOutapplyAkp().getUnitqty());
        outPrepareLibrary.setMtlCode(outApplyVO.getDjOutapplyAkp().getMtlno());
        outPrepareLibrary.setLoc(outApplyVO.getDjCircleKanbanAkp().getLoc());
        outPrepareLibrary.setIsDel(0);
        outPrepareLibrary.setCuttingToolCode(outApplyVO.getCuttingTool().getCode());
        outPrepareLibrary.setProductlineProcess(outApplyVO.getDjOutapplyAkp().getLocation());
        outPrepareLibrary.setProductlineAssemblyline(outApplyVO.getDjOutapplyAkp().getProductline());
        outPrepareLibrary.setPlant(outApplyVO.getDjOutapplyAkp().getPlant());
        outPrepareLibrary.setKuguanOperatorCode(outApplyVO.getLoginUser().getCode());
        outPrepareLibrary.setKuguanOperatorName(outApplyVO.getLoginUser().getName());
        outPrepareLibrary.setLinglOperatorCode(outApplyVO.getLlAuthCustomer().getCode());
        outPrepareLibrary.setLinglOperatorName(outApplyVO.getLlAuthCustomer().getName());
        outPrepareLibrary.setKezhangCode(outApplyVO.getKzAuthCustomer().getCode());
        outPrepareLibrary.setKezhangName(outApplyVO.getKzAuthCustomer().getName());
        outPrepareLibrary.setCreateTime(new Timestamp(System.currentTimeMillis()));
        outPrepareLibraryMapper.addOutPrepareLibrary(outPrepareLibrary);
    }

    /**
     * 添加出库映射记录
     * @throws Exception
     */
    public void addQimingRecords(OutApplyVO outApplyVO) throws Exception{
        QimingRecords qimingRecords = null;
        if (outApplyVO.getCuttingTool().getConsumeType().equals(ConsumeTypeEnum.Applicable_Bit.getKey())){
            //可刃磨钻头
            List<CuttingToolBind> cuttingToolBinds= outApplyVO.getCuttingToolBinds();
            for (Integer i = 0; i < outApplyVO.getCuttingToolBinds().size(); i++) {
                //创建材料刀bind
                CuttingToolBind cuttingToolBind = new CuttingToolBind();
                cuttingToolBind.setCuttingToolCode(outApplyVO.getCuttingTool().getCode());
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
                qimingRecords.setBatchNo(outApplyVO.getBatchNo()+1);
                qimingRecords.setCuttingToolBindCode(cuttingToolBind.getCode());
                qimingRecords.setCuttingToolCode(outApplyVO.getCuttingTool().getCode());
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
            qimingRecords.setBatchNo(outApplyVO.getBatchNo()+1);
            qimingRecords.setCuttingToolCode(outApplyVO.getCuttingTool().getCode());
            qimingRecords.setIsDel(0);
            qimingRecords.setLoc(outApplyVO.getDjCircleKanbanAkp().getLoc());
            qimingRecords.setMtlCode(outApplyVO.getDjOutapplyAkp().getMtlno());
            qimingRecords.setUnitqty(outApplyVO.getDjOutapplyAkp().getUnitqty());
            qimingRecordsMapper.addQimingRecords(qimingRecords);
        }
    }
}
