package com.service.productline.model;

import com.common.mapper.ICuttingToolBindMapper;
import com.common.mapper.ICuttingToolProductionRecordsMapper;
import com.common.mapper.ISynthesisCuttingToolLocationMapper;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.CuttingToolProductionRecords;
import com.common.pojo.SynthesisCuttingToolBind;
import com.common.pojo.SynthesisCuttingToolLocation;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.SynthesisCuttingToolBindVO;
import com.common.vo.SynthesisCuttingToolLocationVO;
import com.service.productline.bo.ToolBindleRecordsBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by logan on 2018/6/14.
 */
@Component("ToolBindleRecordsModel")
public class ToolBindleRecordsModel {

    @Autowired
    private ISynthesisCuttingToolLocationMapper locationMapper;
    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;
    @Autowired
    private ICuttingToolProductionRecordsMapper recordsMapper;

    public void addToolBindleRecords(ToolBindleRecordsBO toolBindleRecordsBO) throws Exception{
        SynthesisCuttingToolBindVO synthesisCuttingToolBindVO = new SynthesisCuttingToolBindVO();
        synthesisCuttingToolBindVO.setCode(toolBindleRecordsBO.getSynthesisCuttingToolBind().getCode());

        SynthesisCuttingToolLocationVO locationVO = new SynthesisCuttingToolLocationVO();
        locationVO.setSynthesisCuttingToolBindCode(toolBindleRecordsBO.getSynthesisCuttingToolBind().getCode());
        List<SynthesisCuttingToolLocation> locations = locationMapper.getSynthesisCuttingToolLocationByPage(locationVO);

        CuttingToolBind cuttingToolBind = null;
        CuttingToolBindVO cuttingToolBindVO = null;
        CuttingToolProductionRecords cuttingToolProductionRecords = null;
        for (SynthesisCuttingToolLocation location : locations) {
            if (!StringUtils.isBlank(location.getCuttingToolBladeCode())){
                cuttingToolBindVO = new CuttingToolBindVO();
                cuttingToolBindVO.setBladeCode(location.getCuttingToolBladeCode());
                cuttingToolBind = cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
                if (null!= cuttingToolBind){
                    cuttingToolBind.setJgcs(toolBindleRecordsBO.getProcessingCount());
                    if (null == cuttingToolBind.getProcessingCount()){
                        cuttingToolBind.setProcessingCount(0);
                    }
                    cuttingToolBind.setProcessingCount(cuttingToolBind.getProcessingCount());
                    cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
                }
            }

            cuttingToolProductionRecords = new CuttingToolProductionRecords();
            cuttingToolProductionRecords.setBusinessCode(location.getCuttingTool().getBusinessCode());
            cuttingToolProductionRecords.setCuttingToolCode(location.getCuttingTool().getCode());
            cuttingToolProductionRecords.setAssemblylineCode(toolBindleRecordsBO.getBindleRecords().getProductLineAssemblyline().getCode());
            cuttingToolProductionRecords.setAssemblylineName(toolBindleRecordsBO.getBindleRecords().getProductLineAssemblyline().getName());
            cuttingToolProductionRecords.setProcessCode(toolBindleRecordsBO.getBindleRecords().getProductLineProcess().getCode());
            cuttingToolProductionRecords.setProcessName(toolBindleRecordsBO.getBindleRecords().getProductLineProcess().getName());
//            cuttingToolProductionRecords.setAxleCode(toolBindleRecordsBO.getBindleRecords().getProductLineAxle().getCode());
//            cuttingToolProductionRecords.setAxleName(toolBindleRecordsBO.getBindleRecords().getProductLineAxle().getName());
            cuttingToolProductionRecords.setEquipmentCode(toolBindleRecordsBO.getBindleRecords().getProductLineEquipment().getCode());
            cuttingToolProductionRecords.setEquipmentName(toolBindleRecordsBO.getBindleRecords().getProductLineEquipment().getName());
//            cuttingToolProductionRecords.setProductLineCode(bindleRecords.getProductLineAssemblylineCode());
            cuttingToolProductionRecords.setPartsCode(toolBindleRecordsBO.getBindleRecords().getProductLineParts().getCode());
            cuttingToolProductionRecords.setPartsName(toolBindleRecordsBO.getBindleRecords().getProductLineParts().getName());
            cuttingToolProductionRecords.setSynthesisCuttingToolCode(toolBindleRecordsBO.getSynthesisCuttingToolBind().getSynthesisCuttingTool().getCode());
            cuttingToolProductionRecords.setSynthesisCode(toolBindleRecordsBO.getSynthesisCuttingToolBind().getSynthesisCuttingTool().getSynthesisCode());
            cuttingToolProductionRecords.setProcessingCount(toolBindleRecordsBO.getBindleRecords().getProcessingCount());
            cuttingToolProductionRecords.setRatedNumber(toolBindleRecordsBO.getBindleRecords().getRatedNumber());
            cuttingToolProductionRecords.setIsDel("0");
            cuttingToolProductionRecords.setLastTime(new Timestamp(System.currentTimeMillis()));
            recordsMapper.addCuttingToolProductionRecords(cuttingToolProductionRecords);

        }
    }
}


