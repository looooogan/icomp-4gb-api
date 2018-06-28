package com.service.productline.model;

import com.common.constants.BindRecorderStatusEnum;
import com.common.mapper.ISynthesisCuttingToolBindleRecordsMapper;
import com.common.pojo.ProductLine;
import com.common.pojo.SynthesisCuttingToolBind;
import com.common.pojo.SynthesisCuttingToolBindleRecords;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.SynthesisCuttingToolBindleRecordsVO;
import com.service.productline.bo.BindleRecordsBO;
import com.service.productline.bo.ProductLineBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by logan on 2018/6/13.
 */
@Component("BindleRecordsModel")
public class BindleRecordsModel {
    @Autowired
    private ISynthesisCuttingToolBindleRecordsMapper bindleRecordsMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;


    /**
     * 添加调刀记录
     * @param bindleRecordsBO
     * @throws Exception
     */
    public void addBindleRecords(BindleRecordsBO bindleRecordsBO) throws Exception{
        ProductLine productLine = bindleRecordsBO.getProductLine();
        SynthesisCuttingToolBind synthesisCuttingToolBind = bindleRecordsBO.getSynthesisCuttingToolBind();
        SynthesisCuttingToolBindleRecordsVO tmpVO = new SynthesisCuttingToolBindleRecordsVO();
        tmpVO.setBindRfid(bindleRecordsBO.getSynthesisCuttingToolBind().getRfidContainer().getCode());
        SynthesisCuttingToolBindleRecords tmpRecord = bindleRecordsMapper.getLast(tmpVO);
        if (null != tmpRecord && tmpRecord.getStatus().equals(BindRecorderStatusEnum.Installed.getKey())){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SBINDRECORDER_EXITS));
        }
        SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords = new SynthesisCuttingToolBindleRecords();
        synthesisCuttingToolBindleRecords.setIsDel(0);
        synthesisCuttingToolBindleRecords.setOperatorInstall(bindleRecordsBO.getLoginUser().getCode());
        synthesisCuttingToolBindleRecords.setOperatorInstallName(bindleRecordsBO.getLoginUser().getName());
        synthesisCuttingToolBindleRecords.setOperatorInstallTime(new Timestamp(System.currentTimeMillis()));
        synthesisCuttingToolBindleRecords.setProductLineAssemblylineCode(productLine.getAssemblylineCode());
//        synthesisCuttingToolBindleRecords.setProductLineAxleCode(productLine.getAxleCode());
        synthesisCuttingToolBindleRecords.setProductLineEquipmentCode(productLine.getEquipmentCode());
        synthesisCuttingToolBindleRecords.setProductLineProcessCode(productLine.getProcessCode());
        synthesisCuttingToolBindleRecords.setProductLinePartsCode(productLine.getPartsCode());
        synthesisCuttingToolBindleRecords.setSynthesisCuttingToolCode(productLine.getSynthesisCuttingToolCode());
        synthesisCuttingToolBindleRecords.setSynthesisCode(productLine.getSynthesisCuttingTool().getSynthesisCode());
        synthesisCuttingToolBindleRecords.setStatus(BindRecorderStatusEnum.Installed.getKey());
        synthesisCuttingToolBindleRecords.setSynthesisCuttingToolBindCode(synthesisCuttingToolBind.getCode());
        synthesisCuttingToolBindleRecords.setBindRfid(synthesisCuttingToolBind.getRfidContainer().getCode());
        synthesisCuttingToolBindleRecords.setRatedNumber(productLine.getToolDurable());
        bindleRecordsMapper.addSynthesisCuttingToolBindleRecords(synthesisCuttingToolBindleRecords);
    }

    /**
     * 根据RFID查询调刀记录
     * @param bindleRecordsBO
     * @return
     * @throws Exception
     */
    public SynthesisCuttingToolBindleRecords queryByRFID(BindleRecordsBO bindleRecordsBO) throws Exception{
        SynthesisCuttingToolBindleRecordsVO bindleRecordsVO = new SynthesisCuttingToolBindleRecordsVO();
        bindleRecordsVO.setBindRfid(bindleRecordsBO.getSynthesisCuttingToolBind().getRfidContainer().getCode());
        bindleRecordsVO.setStatus(BindRecorderStatusEnum.Installed.getKey());
        return bindleRecordsMapper.getLast(bindleRecordsVO);
    }

    /**
     * 添加卸下设备的调刀记录
     * @param bindleRecordsBO
     * @return
     * @throws Exception
     */
    public SynthesisCuttingToolBindleRecords updBindleRecords(BindleRecordsBO bindleRecordsBO) throws Exception{
        SynthesisCuttingToolBindleRecordsVO bindleRecordsVO = new SynthesisCuttingToolBindleRecordsVO();
        bindleRecordsVO.setBindRfid(bindleRecordsBO.getSynthesisCuttingToolBind().getRfidContainer().getCode());
        bindleRecordsVO.setStatus(BindRecorderStatusEnum.Installed.getKey());
        SynthesisCuttingToolBindleRecords bindleRecords =bindleRecordsMapper.getLast(bindleRecordsVO);
        bindleRecords.setStatus(BindRecorderStatusEnum.UnInstall.getKey());
        bindleRecords.setReason(bindleRecordsBO.getReason());
        bindleRecords.setProcessingCount(bindleRecordsBO.getProcessingCount());
        bindleRecordsMapper.updSynthesisCuttingToolBindleRecords(bindleRecords);
        return bindleRecords;
    }
}
