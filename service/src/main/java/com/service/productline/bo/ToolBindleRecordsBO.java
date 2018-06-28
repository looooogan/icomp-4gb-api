package com.service.productline.bo;

import com.common.pojo.SynthesisCuttingToolBind;
import com.common.pojo.SynthesisCuttingToolBindleRecords;

/**
 * Created by logan on 2018/6/14.
 */
public class ToolBindleRecordsBO {

    private SynthesisCuttingToolBind synthesisCuttingToolBind;

    private Integer processingCount;

    private SynthesisCuttingToolBindleRecords bindleRecords;

    public SynthesisCuttingToolBindleRecords getBindleRecords() {
        return bindleRecords;
    }

    public void setBindleRecords(SynthesisCuttingToolBindleRecords bindleRecords) {
        this.bindleRecords = bindleRecords;
    }

    public Integer getProcessingCount() {
        return processingCount;
    }

    public void setProcessingCount(Integer processingCount) {
        this.processingCount = processingCount;
    }

    public SynthesisCuttingToolBind getSynthesisCuttingToolBind() {
        return synthesisCuttingToolBind;
    }

    public void setSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) {
        this.synthesisCuttingToolBind = synthesisCuttingToolBind;
    }
}
