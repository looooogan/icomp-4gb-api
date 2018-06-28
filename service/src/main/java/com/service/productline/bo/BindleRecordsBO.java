package com.service.productline.bo;

import com.common.pojo.ProductLine;
import com.common.pojo.ProductLineParts;
import com.common.pojo.SynthesisCuttingToolBind;
import com.service.base.bo.BaseBO;

/**
 * Created by logan on 2018/6/13.
 */
public class BindleRecordsBO extends BaseBO{

    private SynthesisCuttingToolBind synthesisCuttingToolBind;

    private ProductLine productLine;

    private ProductLineParts parts;

    private Integer ratedNumber;

    private Integer processingCount;

    private String Reason;

    public ProductLineParts getParts() {
        return parts;
    }

    public void setParts(ProductLineParts parts) {
        this.parts = parts;
    }

    public Integer getRatedNumber() {
        return ratedNumber;
    }

    public void setRatedNumber(Integer ratedNumber) {
        this.ratedNumber = ratedNumber;
    }

    public Integer getProcessingCount() {
        return processingCount;
    }

    public void setProcessingCount(Integer processingCount) {
        this.processingCount = processingCount;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public SynthesisCuttingToolBind getSynthesisCuttingToolBind() {
        return synthesisCuttingToolBind;
    }

    public void setSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) {
        this.synthesisCuttingToolBind = synthesisCuttingToolBind;
    }
}
