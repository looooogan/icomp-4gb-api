package com.service.productline.bo;

import com.common.pojo.SynthesisCuttingToolBindleRecords;
import com.common.vo.ProductLineEquipmentVO;
import com.common.vo.ProductLinePartsVO;
import com.common.vo.ProductLineVO;
import com.common.vo.SynthesisCuttingToolBindVO;
import com.service.base.bo.BaseBO;

/**
 * Created by logan on 2018/6/13.
 */
public class ProductLineBO extends BaseBO{

    private ProductLineVO productLineVO;

    private ProductLineEquipmentVO productLineEquipmentVO;

    private SynthesisCuttingToolBindVO synthesisCuttingToolBindVO;

    private String unBindReason;

    private Integer processingCount;

    private ProductLinePartsVO partsVO;

    private SynthesisCuttingToolBindleRecords bindleRecords;

    public SynthesisCuttingToolBindleRecords getBindleRecords() {
        return bindleRecords;
    }

    public void setBindleRecords(SynthesisCuttingToolBindleRecords bindleRecords) {
        this.bindleRecords = bindleRecords;
    }

    public ProductLinePartsVO getPartsVO() {
        return partsVO;
    }

    public void setPartsVO(ProductLinePartsVO partsVO) {
        this.partsVO = partsVO;
    }

    public String getUnBindReason() {
        return unBindReason;
    }

    public void setUnBindReason(String unBindReason) {
        this.unBindReason = unBindReason;
    }

    public Integer getProcessingCount() {
        return processingCount;
    }

    public void setProcessingCount(Integer processingCount) {
        this.processingCount = processingCount;
    }

    public SynthesisCuttingToolBindVO getSynthesisCuttingToolBindVO() {
        return synthesisCuttingToolBindVO;
    }

    public void setSynthesisCuttingToolBindVO(SynthesisCuttingToolBindVO synthesisCuttingToolBindVO) {
        this.synthesisCuttingToolBindVO = synthesisCuttingToolBindVO;
    }

    public ProductLineEquipmentVO getProductLineEquipmentVO() {
        return productLineEquipmentVO;
    }

    public void setProductLineEquipmentVO(ProductLineEquipmentVO productLineEquipmentVO) {
        this.productLineEquipmentVO = productLineEquipmentVO;
    }

    public ProductLineVO getProductLineVO() {
        return productLineVO;
    }

    public void setProductLineVO(ProductLineVO productLineVO) {
        this.productLineVO = productLineVO;
    }
}
