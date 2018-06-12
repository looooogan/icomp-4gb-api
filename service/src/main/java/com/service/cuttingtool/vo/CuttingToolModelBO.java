package com.service.cuttingtool.vo;

import com.common.pojo.CuttingTool;
import com.common.vo.CuttingToolVO;

import java.util.List;

/**
 * Created by logan on 2018/5/29.
 */
public class CuttingToolModelBO {

    //操作
    private Integer operationKey;
    //材料刀列表
    private List<CuttingToolVO> cuttingToolVOS;

    private Integer upOrDown;

    public Integer getUpOrDown() {
        return upOrDown;
    }

    public void setUpOrDown(Integer upOrDown) {
        this.upOrDown = upOrDown;
    }

    public Integer getOperationKey() {
        return operationKey;
    }

    public void setOperationKey(Integer operationKey) {
        this.operationKey = operationKey;
    }

    public List<CuttingToolVO> getCuttingToolVOS() {
        return cuttingToolVOS;
    }

    public void setCuttingToolVOS(List<CuttingToolVO> cuttingToolVOS) {
        this.cuttingToolVOS = cuttingToolVOS;
    }
}
