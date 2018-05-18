package com.service.productline;

import com.common.pojo.ProductLineAssemblyline;
import com.common.pojo.ProductLineEquipment;
import com.common.pojo.SynthesisCuttingTool;
import com.common.pojo.SynthesisCuttingToolBind;
import com.common.vo.ProductLineVO;
import com.service.productline.vo.QueryEquipmentByRfidVO;
import com.service.productline.vo.QuerySynthesisCuttingToolVO;

import java.util.List;

/**
 * Created by logan on 2018/4/30.
 */
public interface IProductLineBusinessService {

    /**
     * 获取所有流水线
     * @return 流水线列表
     * @throws Exception
     */
    public List<ProductLineAssemblyline> getAllAssemblyline() throws Exception;

    /**
     * 根据流水线查询生产关联关系中的设备
     * @param productLineVO 生产关联关系查询条件封装
     * @return 设备列表
     * @throws Exception
     */
    public List<ProductLineEquipment> getEquipmentByAssemblyline(ProductLineVO productLineVO) throws Exception;

    /**
     * 初始化设备
     * @param productLineEquipments 设备列表
     * @throws Exception
     */
    public void addInitEquipment(ProductLineEquipment productLineEquipments) throws Exception;


    /**
     * 根据RFID查询合成刀信息
     * @param querySynthesisCuttingToolVO 查询条件
     * @throws Exception
     */
    public SynthesisCuttingToolBind querySynthesisCuttingTool(QuerySynthesisCuttingToolVO querySynthesisCuttingToolVO) throws Exception;


    public QueryEquipmentByRfidVO queryEquipmentByRFID(QueryEquipmentByRfidVO queryEquipmentByRfidVO) throws Exception;
}
