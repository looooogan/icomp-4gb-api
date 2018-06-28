package com.service.productline;

import com.common.pojo.ProductLineAssemblyline;
import com.common.pojo.ProductLineEquipment;
import com.common.vo.ProductLineVO;
import com.service.productline.bo.ProductLineBO;
import com.service.productline.vo.QueryVO;

import java.util.List;
import java.util.Map;

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
     * @param productLineBO 设备
     * @throws Exception
     */
    public void addInitEquipment(ProductLineBO productLineBO) throws Exception;


    /**
     * 为安上设备查询信息
     * @param productLineBO 设备
     * @throws Exception
     */
    public QueryVO queryForInstall(ProductLineBO productLineBO) throws Exception;

    /**
     * 安上设备
     * @param productLineBO
     * @throws Exception
     */
    public void installData(ProductLineBO productLineBO) throws Exception;

    /**
     * 为卸下设备查询信息
     * @param productLineBO 设备
     * @throws Exception
     */
    public QueryVO queryForUnInstall(ProductLineBO productLineBO) throws Exception;

    /**
     * 卸下设备
     * @param productLineBO
     * @throws Exception
     */
    public ProductLineBO unInstallData(ProductLineBO productLineBO) throws Exception;

}
