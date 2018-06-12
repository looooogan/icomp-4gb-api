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
import com.service.cuttingtool.CuttingToolModel;
import com.service.cuttingtool.bo.CuttingToolBindBO;
import com.service.cuttingtool.vo.CuttingToolModelBO;
import com.service.materialInventory.MaterialInventoryModel;
import com.service.materialInventory.MaterialInventoryModelBO;
import com.service.orders.IOutApplyBusinessService;
import com.service.orders.LibraryModel;
import com.service.orders.vo.OutApplyVO;
import com.service.orders.vo.WBOutApplyVO;
import org.apache.commons.lang3.StringUtils;
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
    private IAuthCustomerMapper customerMapper;
    @Autowired
    private LibraryModel libraryModel;
    @Autowired
    private MaterialInventoryModel materialInventoryModel;
    @Autowired
    private CuttingToolModel cuttingToolModel;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;

    /**
     * 出库
     * @param outApplyVO
     * @throws Exception
     */
    @Override
    public void outApplyData(OutApplyVO outApplyVO) throws Exception {
        //查询材料刀信息
        CuttingToolVO cuttingToolVO = new CuttingToolVO();
        cuttingToolVO.setWuliaoCode(outApplyVO.getMtlCode());
        CuttingTool cuttingTool = cuttingToolMapper.getCuttingTool(cuttingToolVO);
        outApplyVO.setCuttingTool(cuttingTool);
        //查询领料员
        outApplyVO.setLlAuthCustomer(customerMapper.getAuthCustomer(outApplyVO.getLlAuthCustomerVO()));
        //查询科长
        outApplyVO.setKzAuthCustomer(customerMapper.getAuthCustomer(outApplyVO.getKzAuthCustomerVO()));
        //库管员
        AuthCustomerVO kuguanVo = new AuthCustomerVO();
        kuguanVo.setCode(outApplyVO.getLoginUser().getCode());
        outApplyVO.setLoginUser(customerMapper.getAuthCustomer(kuguanVo));

        //创建刀具绑定信息
        if (null!=outApplyVO.getCuttingToolBinds()&&outApplyVO.getCuttingToolBinds().size()>0){
            List<CuttingToolBind> cuttingToolBinds = new ArrayList<>();
            CuttingToolBindBO cuttingToolBindBO = null;
            for (CuttingToolBind cuttingToolBind : outApplyVO.getCuttingToolBinds()) {
                if (StringUtils.isBlank(cuttingToolBind.getBladeCode())){
                    outApplyVO.setMaxDJH(outApplyVO.getMaxDJH()+1);
                    cuttingToolBindBO.setMaxDJH(outApplyVO.getMaxDJH());
                }
                cuttingToolBindBO = new CuttingToolBindBO();
                cuttingToolBindBO.setCuttingToolBind(cuttingToolBind);
                cuttingToolBindBO.setCuttingTool(outApplyVO.getCuttingTool());
                cuttingToolBindBO.setLltm(outApplyVO.getDjOutapplyAkp().getLltm());
                cuttingToolBindBO.setLoginUser(outApplyVO.getLoginUser());
                cuttingToolBind = cuttingToolModel.bindCuttingToolOnOutApply(cuttingToolBindBO);
                cuttingToolBinds.add(cuttingToolBind);
            }
            outApplyVO.setCuttingToolBinds(cuttingToolBinds);
        }
        //处理出库信息，添加库存记录和出库映射记录
        libraryModel.addOutPrepareLibraryRecorders(outApplyVO);
        //添加出库映射记录
        libraryModel.addQimingRecords(outApplyVO);
        //修改刀具库存
        MaterialInventoryModelBO materialInventoryModelBO = new MaterialInventoryModelBO();
        materialInventoryModelBO.setCuttingTool(outApplyVO.getCuttingTool());
        materialInventoryModelBO.setUnitqty(outApplyVO.getUnitqty());
        materialInventoryModel.OutApplyCuttingToolInventory(materialInventoryModelBO);
    }


}
