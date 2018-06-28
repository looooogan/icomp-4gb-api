package com.service.writeback.bo;

import com.common.pojo.ProductLine;
import com.common.pojo.SynthesisCuttingToolBind;
import com.common.pojo.SynthesisCuttingToolLocation;
import com.service.base.bo.BaseBO;

import java.util.List;

/**
 * Created by logan on 2018/6/14.
 */
public class InstallWBBO extends BaseBO{

    private SynthesisCuttingToolBind synthesisCuttingToolBind;

    private List<SynthesisCuttingToolLocation> locationList;

    private ProductLine productLine;

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

    public List<SynthesisCuttingToolLocation> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<SynthesisCuttingToolLocation> locationList) {
        this.locationList = locationList;
    }
}
