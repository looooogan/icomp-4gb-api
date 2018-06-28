package com.service.writeback.bo;

import com.common.pojo.SynthesisCuttingToolBindleRecords;
import com.common.pojo.SynthesisCuttingToolLocation;
import com.service.base.bo.BaseBO;

import java.util.List;

/**
 * Created by logan on 2018/6/14.
 */
public class UnInstallWBBO extends BaseBO{

    private List<SynthesisCuttingToolLocation> locationList;

    private SynthesisCuttingToolBindleRecords bindleRecords;

    public SynthesisCuttingToolBindleRecords getBindleRecords() {
        return bindleRecords;
    }

    public void setBindleRecords(SynthesisCuttingToolBindleRecords bindleRecords) {
        this.bindleRecords = bindleRecords;
    }

    public List<SynthesisCuttingToolLocation> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<SynthesisCuttingToolLocation> locationList) {
        this.locationList = locationList;
    }
}
