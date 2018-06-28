package com.service.materialInventory.bo;

import com.common.pojo.CuttingTool;
import com.common.pojo.SynthesisCuttingToolBind;
import com.service.inoutFactory.vo.GrindingVO;
import com.service.scrap.vo.ScrapVO;
import com.service.synthesiscuttingtool.vo.DownCuttingToolVO;
import com.service.synthesiscuttingtool.vo.UpCuttingToolVO;

import java.util.List;

/**
 * Created by logan on 2018/6/11.
 */
public class MaterialInventoryBO {

    private CuttingTool cuttingTool;

    private Integer Unitqty;

    private String mtlCode;

    private SynthesisCuttingToolBind synthesisCuttingToolBind;

    private List<UpCuttingToolVO> upCuttingToolVOS;

    private List<DownCuttingToolVO> downCuttingToolVOS;

    private List<GrindingVO> grindingVOS;

    private List<ScrapVO> scrapVOS;

    public List<ScrapVO> getScrapVOS() {
        return scrapVOS;
    }

    public void setScrapVOS(List<ScrapVO> scrapVOS) {
        this.scrapVOS = scrapVOS;
    }

    public List<GrindingVO> getGrindingVOS() {
        return grindingVOS;
    }

    public void setGrindingVOS(List<GrindingVO> grindingVOS) {
        this.grindingVOS = grindingVOS;
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

    public SynthesisCuttingToolBind getSynthesisCuttingToolBind() {
        return synthesisCuttingToolBind;
    }

    public void setSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) {
        this.synthesisCuttingToolBind = synthesisCuttingToolBind;
    }

    public String getMtlCode() {
        return mtlCode;
    }

    public void setMtlCode(String mtlCode) {
        this.mtlCode = mtlCode;
    }

    public Integer getUnitqty() {
        return Unitqty;
    }

    public void setUnitqty(Integer unitqty) {
        Unitqty = unitqty;
    }

    public CuttingTool getCuttingTool() {
        return cuttingTool;
    }

    public void setCuttingTool(CuttingTool cuttingTool) {
        this.cuttingTool = cuttingTool;
    }
}
