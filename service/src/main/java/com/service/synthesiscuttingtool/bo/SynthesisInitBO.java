package com.service.synthesiscuttingtool.bo;

import com.common.pojo.SynthesisCuttingToolBind;
import com.common.vo.RfidContainerVO;
import com.common.vo.SynthesisCuttingToolBindVO;
import com.service.base.bo.BaseBO;

import java.util.List;

/**
 * Created by logan on 2018/6/13.
 */
public class SynthesisInitBO extends BaseBO{
    /**
      * @fieldName synthesisCode
     * @fieldType  String
     * @Description  合成刀业务编码
     */
    private String synthesisCode;

    /**
      * @fieldName rfidContainerCode
     * @fieldType
     * @Description  RFID标签
     */
    private RfidContainerVO rfidContainerVO;

    /**
      * @fieldName bladeCode
     * @fieldType  Integer
     * @Description  刀身码
     */
    private String bladeCode;

    /**
      * @fieldName synthesisCuttingToolBinds
     * @fieldType
     * @Description  合成刀绑定信息
     */
    private List<SynthesisCuttingToolBindVO> synthesisCuttingToolBindVOS;

    public String getBladeCode() {
        return bladeCode;
    }

    public void setBladeCode(String bladeCode) {
        this.bladeCode = bladeCode;
    }

    public List<SynthesisCuttingToolBindVO> getSynthesisCuttingToolBindVOS() {
        return synthesisCuttingToolBindVOS;
    }

    public void setSynthesisCuttingToolBindVOS(List<SynthesisCuttingToolBindVO> synthesisCuttingToolBindVOS) {
        this.synthesisCuttingToolBindVOS = synthesisCuttingToolBindVOS;
    }

    public String getSynthesisCode() {
        return synthesisCode;
    }

    public void setSynthesisCode(String synthesisCode) {
        this.synthesisCode = synthesisCode;
    }

    public RfidContainerVO getRfidContainerVO() {
        return rfidContainerVO;
    }

    public void setRfidContainerVO(RfidContainerVO rfidContainerVO) {
        this.rfidContainerVO = rfidContainerVO;
    }
}
