package com.service.scrap.vo;

import com.common.pojo.AuthCustomer;
import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.CuttingToolVO;
import com.service.inoutFactory.vo.SharpenVO;

import java.util.List;

/**
 * Created by logan on 2018/5/12.
 */
public class ScrapVO {

    private CuttingToolVO cuttingToolVO;

    private CuttingToolBindVO cuttingToolBindVO;

    private CuttingTool cuttingTool;

    private CuttingToolBind cuttingToolBind;

    private Integer count;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CuttingTool getCuttingTool() {
        return cuttingTool;
    }

    public void setCuttingTool(CuttingTool cuttingTool) {
        this.cuttingTool = cuttingTool;
    }

    public CuttingToolBind getCuttingToolBind() {
        return cuttingToolBind;
    }

    public void setCuttingToolBind(CuttingToolBind cuttingToolBind) {
        this.cuttingToolBind = cuttingToolBind;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CuttingToolVO getCuttingToolVO() {
        return cuttingToolVO;
    }

    public void setCuttingToolVO(CuttingToolVO cuttingToolVO) {
        this.cuttingToolVO = cuttingToolVO;
    }

    public CuttingToolBindVO getCuttingToolBindVO() {
        return cuttingToolBindVO;
    }

    public void setCuttingToolBindVO(CuttingToolBindVO cuttingToolBindVO) {
        this.cuttingToolBindVO = cuttingToolBindVO;
    }
}
