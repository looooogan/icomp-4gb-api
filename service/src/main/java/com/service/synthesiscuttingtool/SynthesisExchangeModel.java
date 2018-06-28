package com.service.synthesiscuttingtool;

import com.common.constants.BindRecorderStatusEnum;
import com.common.constants.OperationEnum;
import com.common.mapper.ISynthesisCuttingToolBindleRecordsMapper;
import com.common.mapper.ISynthesisCuttingToolExchangeMapper;
import com.common.pojo.RfidContainer;
import com.common.pojo.SynthesisCuttingToolBind;
import com.common.pojo.SynthesisCuttingToolBindleRecords;
import com.common.pojo.SynthesisCuttingToolExchange;
import com.common.vo.SynthesisCuttingToolBindleRecordsVO;
import com.service.synthesiscuttingtool.bo.ExchangeRecordersBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by logan on 2018/6/13.
 */
@Component("SynthesisExchangeModel")
public class SynthesisExchangeModel {
    @Autowired
    private ISynthesisCuttingToolBindleRecordsMapper bindleRecordsMapper;
    @Autowired
    private ISynthesisCuttingToolExchangeMapper exchangeMapper;


    /**
     * 添加合成刀换装记录
     * @param exchangeRecordersBO
     * @throws Exception
     */
    public void addExchangeRecorders(ExchangeRecordersBO exchangeRecordersBO) throws Exception{
        RfidContainer rfidContainer = exchangeRecordersBO.getSynthesisCuttingToolBind().getRfidContainer();
        if (rfidContainer.getPrevKey()!= OperationEnum.SynthesisCuttingTool_UnInstall.getKey()){
            return;
        }
        //如果从设备上卸下则添加换装记录
        SynthesisCuttingToolBind synthesisCuttingToolBind = exchangeRecordersBO.getSynthesisCuttingToolBind();
        //查询安上设备记录信息
        SynthesisCuttingToolBindleRecordsVO downRecordsVO = new SynthesisCuttingToolBindleRecordsVO();
        downRecordsVO.setBindRfid(rfidContainer.getCode());
        downRecordsVO.setStatus(BindRecorderStatusEnum.UnInstall.getKey());
        SynthesisCuttingToolBindleRecords downRecords = bindleRecordsMapper.getLast(downRecordsVO);
        if (null!=downRecords){
            //换装信息
            SynthesisCuttingToolExchange exchange = new SynthesisCuttingToolExchange();
            //添加换装记录
            exchange.setSynthesisCode(synthesisCuttingToolBind.getSynthesisCode());
            exchange.setRfidCode(synthesisCuttingToolBind.getRfidContainerCode());
//            exchange.setAxleCode(downRecords.getProductLineAxleCode());
//            exchange.setAxleName(downRecords.getProductLineAxle().getName());
            exchange.setEquipmentCode(downRecords.getProductLineEquipmentCode());
            exchange.setEquipmentName(downRecords.getProductLineEquipment().getName());
            exchange.setPartsCode(downRecords.getProductLinePartsCode());
            exchange.setPartsName(downRecords.getProductLineParts().getName());
            exchange.setToolUpTime(new Timestamp(System.currentTimeMillis()));
            exchange.setProcessCode(downRecords.getProductLineProcessCode());
            exchange.setProcessName(downRecords.getProductLineProcess().getName());

            exchange.setToolUpTime(downRecords.getOperatorInstallTime());
            exchange.setToolUpCustomerCode(downRecords.getOperatorInstall());
            exchange.setTollUpCustomerName(downRecords.getOperatorInstallName());
            exchange.setToolDownTime(downRecords.getOperatorInstallTime());
            exchange.setToolDownTime(downRecords.getOperatorUninstallTime());
            exchange.setTollDownCustomerName(downRecords.getOperatorUninstallName());
            exchange.setToolDownCustomerCode(downRecords.getOperatorUninstall());
            exchangeMapper.addSynthesisCuttingToolExchange(exchange);
        }
    }

}
