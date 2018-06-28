package com.service.materialInventory.bo;

import com.common.pojo.SynthesisCuttingTool;
import com.common.pojo.SynthesisCuttingToolBind;
import com.common.vo.SynthesisCuttingToolBindVO;
import com.service.base.bo.BaseBO;

import java.util.List;

/**
 * Created by logan on 2018/6/13.
 */
public class SynthesisMaterialInventoryBO extends BaseBO{

    //合成刀绑定列表
    private List<SynthesisCuttingToolBindVO> synthesisCuttingToolBindVOS;

    //合成刀信息
    private SynthesisCuttingTool synthesisCuttingTool;

    //合成刀绑定信息
    private SynthesisCuttingToolBind synthesisCuttingToolBind;

    public List<SynthesisCuttingToolBindVO> getSynthesisCuttingToolBindVOS() {
        return synthesisCuttingToolBindVOS;
    }

    public void setSynthesisCuttingToolBindVOS(List<SynthesisCuttingToolBindVO> synthesisCuttingToolBindVOS) {
        this.synthesisCuttingToolBindVOS = synthesisCuttingToolBindVOS;
    }

    public SynthesisCuttingTool getSynthesisCuttingTool() {
        return synthesisCuttingTool;
    }

    public void setSynthesisCuttingTool(SynthesisCuttingTool synthesisCuttingTool) {
        this.synthesisCuttingTool = synthesisCuttingTool;
    }

    public SynthesisCuttingToolBind getSynthesisCuttingToolBind() {
        return synthesisCuttingToolBind;
    }

    public void setSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) {
        this.synthesisCuttingToolBind = synthesisCuttingToolBind;
    }
}
