package com.service.orders;

import com.common.constants.QiMingOrderEnum;
import com.common.pojo.CuttingTool;
import com.common.pojo.DjCircleKanbanAkp;
import com.common.pojo.DjOutapplyAkp;
import com.common.pojo.QimingRecords;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.CuttingToolVO;
import com.common.vo.DjCircleKanbanAkpVO;
import com.common.vo.DjOutapplyAkpVO;
import com.common.vo.QimingRecordsVO;
import com.service.common.*;
import com.service.orders.vo.OutApplyVO;
import com.service.orders.vo.SearchOutLiberaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by logan on 2018/6/9.
 */
@Component("LibraryComent")
public class LibraryComent {

    @Autowired
    private IQimingRecordsService qimingRecordsService;
    @Autowired
    private ICuttingToolService cuttingToolService;

    @Autowired
    private IDjOutapplyAkpService djOutapplyAkpService;
    @Autowired
    private IDjCircleKanbanAkpService djCircleKanbanAkpService;
    @Autowired
    private IDjQiMingDBService qiMingDBService;
    @Autowired
    private IOutApplyBusinessService outApplyBusinessService;
    @Autowired
    private IDjWriteBackService writeBackService;
    @Autowired
    private IDjItrnAkpService djItrnAkpService;

    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;

    /**
     * 获取所有未出库订单
     * @return
     * @throws Exception
     */
    public List<SearchOutLiberaryVO> getUnOutOrders() throws Exception {
        List<SearchOutLiberaryVO> searchOutLiberaryVOS = new ArrayList<>();

        //查询启明数据库 获取所有订单
        DjOutapplyAkpVO djOutapplyAkpVO = new DjOutapplyAkpVO();
        djOutapplyAkpVO.setAuditid(QiMingOrderEnum.approved.getKey());
        List<DjOutapplyAkp> djOutapplyAkps = djOutapplyAkpService.getDjOutapplyAkpByPage(djOutapplyAkpVO);
        if (djOutapplyAkps == null){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.OUTAPPLY_NON_ORDERS));
        }

        QimingRecordsVO qimingRecordsVO = new QimingRecordsVO();
        List<QimingRecords> qimingRecords = qimingRecordsService.getQimingRecordsByPage(qimingRecordsVO);

        boolean flag;
        for (DjOutapplyAkp djOutapplyAkp : djOutapplyAkps) {
            if (null == djOutapplyAkp){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.QM_DJOUTAPPLYAKP_MAP_ERROR));
            }
            flag = true;
            for (QimingRecords qimingRecord : qimingRecords) {
                if (djOutapplyAkp.getApplyno().equals(qimingRecord.getApplyNo())){
                    flag = false;
                    break;
                }
            }
            if (flag){
                SearchOutLiberaryVO searchOutLiberaryVO = new SearchOutLiberaryVO();
                DjCircleKanbanAkpVO djCircleKanbanAkpVO = new DjCircleKanbanAkpVO();
                djCircleKanbanAkpVO.setCKanbanCode(djOutapplyAkp.getLltm());
                DjCircleKanbanAkp djCircleKanbanAkp = djCircleKanbanAkpService.getDjCircleKanbanAkp(djCircleKanbanAkpVO);
                if (null == djCircleKanbanAkp){
                    throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.QM_DJOUTAPPLYAKP_MAP_ERROR));
                }
                CuttingToolVO cuttingToolVO = new CuttingToolVO();
                cuttingToolVO.setBusinessCode(djCircleKanbanAkp.getLoc());
                CuttingTool cuttingTool = cuttingToolService.getCuttingTool(cuttingToolVO);
                if (null == cuttingTool){
                    throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.QM_DJOUTAPPLYAKP_MAP_ERROR));
                }
                searchOutLiberaryVO.setApplyno(djOutapplyAkp.getApplyno());
                searchOutLiberaryVO.setMtlno(djOutapplyAkp.getMtlno());
                searchOutLiberaryVO.setCuttingtollBusinessCode(cuttingTool.getBusinessCode());
                searchOutLiberaryVO.setSpecifications(cuttingTool.getSpecifications());
                searchOutLiberaryVO.setName(djOutapplyAkp.getName());
                searchOutLiberaryVO.setProductline(djOutapplyAkp.getProductline());
                searchOutLiberaryVO.setLocation(djOutapplyAkp.getLocation());
                searchOutLiberaryVO.setUnitqty(djOutapplyAkp.getUnitqty());
                searchOutLiberaryVO.setCuttingToolType(cuttingTool.getType());
                searchOutLiberaryVO.setCuttingToolConsumeType(cuttingTool.getConsumeType());
                searchOutLiberaryVO.setGrinding(cuttingTool.getGrinding());
                searchOutLiberaryVO.setDjOutapplyAkp(djOutapplyAkp);
                searchOutLiberaryVOS.add(searchOutLiberaryVO);
            }
        }
        return searchOutLiberaryVOS;
    }


    /**
     * 订单出库
     * @throws Exception
     */
    public void outApply(OutApplyVO outApplyVO) throws Exception{
        Integer batchNo = djItrnAkpService.getMaxBatchNo();
        if (null == batchNo){
            batchNo = 0;
        }
        outApplyVO.setBatchNo(batchNo);
        //查询启明数据库出库信息
        outApplyVO = qiMingDBService.getInfo(outApplyVO);
        //出库 将数据写入icomp数据库
        outApplyBusinessService.outApplyData(outApplyVO);
        //修改启明数据
        //组织回写数据
        writeBackService.writeBackOutLibrary0609(outApplyVO);
    }

}



