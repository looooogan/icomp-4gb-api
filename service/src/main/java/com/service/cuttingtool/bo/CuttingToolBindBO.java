package com.service.cuttingtool.bo;

import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.vo.RfidContainerVO;
import com.service.base.bo.BaseBO;
import com.service.synthesiscuttingtool.vo.DownCuttingToolVO;
import com.service.synthesiscuttingtool.vo.UpCuttingToolVO;

import java.util.List;

/**
 * Created by logan on 2018/6/11.
 */
public class CuttingToolBindBO extends BaseBO{

    private String cuttingToolCode;

    private String bladeCode;

    private String laserCode;

    private CuttingTool cuttingTool;

    private CuttingToolBind cuttingToolBind;

    private Integer maxDJH;

    private String lltm;

    private RfidContainerVO rfidContainerVO;

    private List<UpCuttingToolVO> upCuttingToolVOS;

    private List<DownCuttingToolVO> downCuttingToolVOS;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<UpCuttingToolVO> getUpCuttingToolVOS() {
        return upCuttingToolVOS;
    }

    public void setUpCuttingToolVOS(List<UpCuttingToolVO> upCuttingToolVOS) {
        this.upCuttingToolVOS = upCuttingToolVOS;
    }

    public List<DownCuttingToolVO> getDownCuttingToolVOS() {
        return downCuttingToolVOS;
    }

    public void setDownCuttingToolVOS(List<DownCuttingToolVO> downCuttingToolVOS) {
        this.downCuttingToolVOS = downCuttingToolVOS;
    }

    public RfidContainerVO getRfidContainerVO() {
        return rfidContainerVO;
    }

    public void setRfidContainerVO(RfidContainerVO rfidContainerVO) {
        this.rfidContainerVO = rfidContainerVO;
    }

    public String getLltm() {
        return lltm;
    }

    public void setLltm(String lltm) {
        this.lltm = lltm;
    }

    public Integer getMaxDJH() {
        return maxDJH;
    }

    public void setMaxDJH(Integer maxDJH) {
        this.maxDJH = maxDJH;
    }

    public CuttingToolBind getCuttingToolBind() {
        return cuttingToolBind;
    }

    public void setCuttingToolBind(CuttingToolBind cuttingToolBind) {
        this.cuttingToolBind = cuttingToolBind;
    }

    public CuttingTool getCuttingTool() {
        return cuttingTool;
    }

    public void setCuttingTool(CuttingTool cuttingTool) {
        this.cuttingTool = cuttingTool;
    }

    public String getCuttingToolCode() {
        return cuttingToolCode;
    }

    public void setCuttingToolCode(String cuttingToolCode) {
        this.cuttingToolCode = cuttingToolCode;
    }

    public String getBladeCode() {
        return bladeCode;
    }

    public void setBladeCode(String bladeCode) {
        this.bladeCode = bladeCode;
    }

    public String getLaserCode() {
        return laserCode;
    }

    public void setLaserCode(String laserCode) {
        this.laserCode = laserCode;
    }
}
