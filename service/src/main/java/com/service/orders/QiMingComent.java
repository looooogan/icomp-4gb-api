package com.service.orders;

import com.common.pojo.*;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.*;
import com.service.common.*;
import com.service.cuttingtool.ICuttingToolBusinessService;
import com.service.orders.vo.OutApplyVO;
import com.service.orders.vo.SearchOutLiberaryVO;
import com.service.orders.vo.WBCuttingToolBindVO;
import com.service.writeback.IDjWriteBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by logan on 2018/5/7.
 */
@Component("qimingComponent")
public class QiMingComent {


    @Autowired
    private IAuthCustomerService authCustomerService;

    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;
    @Autowired
    private ICuttingToolBusinessService cuttingToolBusinessService;
    @Autowired
    private IOutApplyBusinessService outApplyService;

    @Autowired
    private IDjOutapplyAkpService djOutapplyAkpService;
    @Autowired
    private IDjCircleKanbanAkpService djCircleKanbanAkpService;

    @Autowired
    private IDjQiMingDBService qiMingDBService;

    @Autowired
    private ICuttingToolService cuttingToolService;
    @Autowired
    private IDjWriteBackService writeBackService;


    /**
     * 获取所有可出库订单
     * @return
     * @throws Exception
     */
    public List<SearchOutLiberaryVO> getOrders() throws Exception {
        List<SearchOutLiberaryVO> searchOutLiberaryVOS = new ArrayList<>();
        DjOutapplyAkpVO djOutapplyAkpVO = new DjOutapplyAkpVO();
        djOutapplyAkpVO.setAuditid("1");

        List<DjOutapplyAkp> djOutapplyAkps = djOutapplyAkpService.getDjOutapplyAkpByPage(djOutapplyAkpVO);
        if (djOutapplyAkps == null){

        }

        for (DjOutapplyAkp djOutapplyAkp : djOutapplyAkps) {
            if (null == djOutapplyAkp){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.QM_DJOUTAPPLYAKP_MAP_ERROR));
            }
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

        return searchOutLiberaryVOS;
    }

    /**
     * 订单出库
     * @throws Exception
     */
    public void outApply(OutApplyVO outApplyVO) throws Exception{
        //查询启明数据库出库信息
        outApplyVO = qiMingDBService.getInfo(outApplyVO);
        //出库 将数据写入icomp数据库
        outApplyService.outApplyData(outApplyVO);
        //修改启明数据
//        qiMingDBService.updateDjOutapplyAkpForOut(outApplyVO);
        //组织回写数据
        writeBackService.writeBackOutLibrary(outApplyVO);
    }

    /**
     * 刀具绑定 旧版本
     * @throws Exception
     */
    public void bindCuttingTool(WBCuttingToolBindVO wbCuttingToolBindVO) throws Exception{
//        cuttingToolBusinessService.addBind0609(wbCuttingToolBindVO.getCuttingToolBind());
//        //回写数据
//        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
//        authCustomerVO.setCode(wbCuttingToolBindVO.getAuthCustomer().getCode());
//        wbCuttingToolBindVO.setAuthCustomer(authCustomerService.getAuthCustomer(authCustomerVO));
//        writeBackService.writeBackCuttingToolBind(wbCuttingToolBindVO);
    }

    public void insideFactory() throws Exception{

    }

}
