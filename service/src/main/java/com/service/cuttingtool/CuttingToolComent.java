package com.service.cuttingtool;

import com.common.constants.CuttingToolConsumeTypeEnum;
import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.DjOutapplyAkp;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.AuthCustomerVO;
import com.common.vo.CuttingToolVO;
import com.common.vo.DjOutapplyAkpVO;
import com.service.common.*;
import com.service.cuttingtool.bo.CuttingToolBindBO;
import com.service.orders.IDjQiMingDBService;
import com.service.writeback.IDjWriteBackService;
import com.service.orders.IOutApplyBusinessService;
import com.service.orders.vo.WBCuttingToolBindVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by logan on 2018/5/29.
 */
@Component("CuttingToolComent")
public class CuttingToolComent {

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


    public List<DjOutapplyAkp> getOutedOrders() throws Exception{
        DjOutapplyAkpVO djOutapplyAkpVO = new DjOutapplyAkpVO();
        djOutapplyAkpVO.setAuditid("2");
        List<DjOutapplyAkp> djOutapplyAkps = djOutapplyAkpService.getDjOutapplyAkpByPage(djOutapplyAkpVO);
        List<DjOutapplyAkp> resultDjOutapplyAkps = new ArrayList<>();
        CuttingToolVO cuttingToolVO = null;
        CuttingTool cuttingTool = null ;
        for (DjOutapplyAkp djOutapplyAkp : djOutapplyAkps) {
            cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setBusinessCode(djOutapplyAkp.getDjcode());
            cuttingTool = cuttingToolService.getCuttingTool(cuttingToolVO);
            if (!StringUtils.isBlank(cuttingTool.getConsumeType())&&cuttingTool.getConsumeType().equals(CuttingToolConsumeTypeEnum.griding_zt.getKey())){
                resultDjOutapplyAkps.add(djOutapplyAkp);
            }
        }
        return resultDjOutapplyAkps;
    }

    /**
     * 绑定刀具 新刀 旧刀
     * @param wbCuttingToolBindVO
     * @throws Exception
     */
    public void bindCuttingTool(WBCuttingToolBindVO wbCuttingToolBindVO) throws Exception{
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(wbCuttingToolBindVO.getAuthCustomer().getCode());
        wbCuttingToolBindVO.setAuthCustomer(authCustomerService.getAuthCustomer(authCustomerVO));

        for (CuttingToolBind cuttingToolBind : wbCuttingToolBindVO.getCuttingToolBinds()) {
            cuttingToolBusinessService.addBind0609(cuttingToolBind,wbCuttingToolBindVO.getAuthCustomer());
        }
        //回写数据
        writeBackService.writeBackCuttingToolBind(wbCuttingToolBindVO);
    }

    /**
     * 流转刀具绑定
     * @param cuttingToolBindBO 业务数据封装
     * @throws Exception
     */
    public void bindRunning(CuttingToolBindBO cuttingToolBindBO) throws Exception{
        cuttingToolBusinessService.bindRunningData(cuttingToolBindBO);
    }

}
