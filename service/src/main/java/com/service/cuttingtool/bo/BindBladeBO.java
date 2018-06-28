package com.service.cuttingtool.bo;

import com.common.pojo.*;

/**
 * Created by logan on 2018/6/15.
 */
public class BindBladeBO {

    private CuttingToolBind cuttingToolBind;

    private SynthesisCuttingToolLocation location;

    private SynthesisCuttingTool synthesisCuttingTool;

    private SynthesisCuttingToolBind synthesisCuttingToolBind;

    private CuttingTool cuttingTool;

    public SynthesisCuttingToolBind getSynthesisCuttingToolBind() {
        return synthesisCuttingToolBind;
    }

    public void setSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) {
        this.synthesisCuttingToolBind = synthesisCuttingToolBind;
    }

    public CuttingTool getCuttingTool() {
        return cuttingTool;
    }

    public void setCuttingTool(CuttingTool cuttingTool) {
        this.cuttingTool = cuttingTool;
    }

    public SynthesisCuttingTool getSynthesisCuttingTool() {
        return synthesisCuttingTool;
    }

    public void setSynthesisCuttingTool(SynthesisCuttingTool synthesisCuttingTool) {
        this.synthesisCuttingTool = synthesisCuttingTool;
    }

    public CuttingToolBind getCuttingToolBind() {
        return cuttingToolBind;
    }

    public void setCuttingToolBind(CuttingToolBind cuttingToolBind) {
        this.cuttingToolBind = cuttingToolBind;
    }

    public SynthesisCuttingToolLocation getLocation() {
        return location;
    }

    public void setLocation(SynthesisCuttingToolLocation location) {
        this.location = location;
    }
}
