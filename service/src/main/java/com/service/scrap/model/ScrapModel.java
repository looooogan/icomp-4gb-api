package com.service.scrap.model;

import com.common.mapper.ICuttingToolBindMapper;
import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.ICuttingToolsScrapMapper;
import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.CuttingToolsScrap;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.service.rfid.RfidModel;
import com.service.scrap.vo.ScrapVO;
import com.service.scrap.bo.ScrapBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by logan on 2018/6/28.
 */
@Component("ScrapModel")
public class ScrapModel {
    @Autowired
    private ICuttingToolMapper cuttingToolMapper;
    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;
    @Autowired
    private ICuttingToolsScrapMapper scrapMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;
    @Autowired
    private RfidModel rfidModel;

    /**
     * 刀具报废
     * @param scrapBO
     * @throws Exception
     */
    public void scrap(ScrapBO scrapBO) throws Exception{
        //添加报废记录
        CuttingToolsScrap scrap = null;
        CuttingTool cuttingTool = null;
        CuttingToolBind cuttingToolBind = null;
        for (ScrapVO scrapVO : scrapBO.getScrapVOS()) {
            if (null == scrapVO.getCuttingToolVO() || StringUtils.isBlank(scrapVO.getCuttingToolVO().getCode())){
                continue;
            }
            cuttingTool = cuttingToolMapper.getCuttingTool(scrapVO.getCuttingToolVO());
            if (null == cuttingTool){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.CUTTINGTOOL_NOT_EXISTS));
            }
            scrapVO.setCuttingTool(cuttingTool);

            if (null != scrapVO.getCuttingToolBindVO()&& StringUtils.isBlank(scrapVO.getCuttingToolBindVO().getCode())){
                cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(scrapVO.getCuttingToolBindVO());
                scrapVO.setCuttingToolBind(cuttingToolBind);
            }

            scrap = new CuttingToolsScrap();
            scrap.setToolType(cuttingTool.getType());
            scrap.setConsumeType(cuttingTool.getConsumeType());
            scrap.setMaterialNum(cuttingTool.getBusinessCode());
            scrap.setCount(scrapVO.getCount());
            scrap.setTime(new Timestamp(System.currentTimeMillis()));
            scrap.setId(0);
            scrap.setAuthorizedCode(scrapBO.getAuthCustomer().getCode());
            scrap.setAuthorizedName(scrapBO.getAuthCustomer().getName());
            scrap.setCustomerCode(scrapBO.getLoginUser().getCode());
            scrap.setCustormerName(scrapBO.getLoginUser().getName());
            scrap.setCuttingToolCode(cuttingTool.getCode());
            scrap.setStatus(scrap.getStatus());
            scrap.setCause(scrapBO.getReason());
            scrapMapper.addCuttingToolsScrap(scrap);
        }
    }

}
