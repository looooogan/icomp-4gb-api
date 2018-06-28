package com.service.scrap.impl;

import com.common.constants.OperationEnum;
import com.common.mapper.ICuttingToolBindMapper;
import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.ICuttingToolsScrapMapper;
import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.CuttingToolVO;
import com.common.vo.RfidContainerVO;
import com.service.materialInventory.MaterialInventoryModel;
import com.service.materialInventory.bo.MaterialInventoryBO;
import com.service.rfid.RfidModel;
import com.service.rfid.bo.RFIDBO;
import com.service.rfid.vo.RFIDBindVO;
import com.service.scrap.IScrapService;
import com.service.scrap.bo.ScrapBO;
import com.service.scrap.model.ScrapModel;
import com.service.scrap.vo.ScrapVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by logan on 2018/5/6.
 */
@Service("scrapBusinessService")
public class ScrapServiceImpl implements IScrapService{

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;
    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;
    @Autowired
    private ICuttingToolsScrapMapper scrapMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;
    @Autowired
    private MaterialInventoryModel materialInventoryModel;
    @Autowired
    private ScrapModel scrapModel;
    @Autowired
    private RfidModel rfidModel;


    @Override
    public CuttingTool getCuttingTool(CuttingToolVO cuttingToolVO) throws Exception {
        return cuttingToolMapper.getCuttingTool(cuttingToolVO);
    }

    @Override
    public CuttingToolBind getCuttingToolBind(CuttingToolBindVO cuttingToolBindVO) throws Exception {
        return cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
    }

    /**
     * 刀具报废
     * @param scrapBO 报废刀具
     * @throws Exception
     */
    @Override
    public void addScraps(ScrapBO scrapBO) throws Exception {
        //添加报废记录
        scrapModel.scrap(scrapBO);
        //修改报废库存
        MaterialInventoryBO materialInventoryBO = new MaterialInventoryBO();
        materialInventoryBO.setScrapVOS(materialInventoryBO.getScrapVOS());
        materialInventoryModel.updateInventoryForScarp(materialInventoryBO);
        //修改rfid标签状态
        RFIDBindVO rfidBindVO = null;
        for (ScrapVO scrapVO : scrapBO.getScrapVOS()) {
            if (null == scrapVO.getCuttingToolBindVO() && StringUtils.isBlank(scrapVO.getCuttingToolBindVO().getCode())){
                continue;
            }
            rfidBindVO = new RFIDBindVO();
            rfidBindVO.setRfidContainerVO(scrapVO.getCuttingToolBindVO().getRfidContainerVO());
            rfidBindVO.setOperationEnum(OperationEnum.Cutting_tool_scap);
            rfidBindVO.setLoginUser(scrapBO.getLoginUser());
            rfidModel.upRFIDStatus(rfidBindVO);
        }
    }
}
