package com.service.synthesiscuttingtool.bo;

import com.common.pojo.SynthesisCuttingToolBind;
import com.common.vo.RfidContainerVO;
import com.common.vo.SynthesisCuttingToolBindVO;
import com.service.base.bo.BaseBO;
import com.service.synthesiscuttingtool.vo.DownCuttingToolVO;
import com.service.synthesiscuttingtool.vo.UpCuttingToolVO;

import java.util.List;

/**
 * Created by logan on 2018/6/13.
 */
public class SynthesisExchangeBO extends BaseBO{

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
      * @fieldName synthesisCuttingToolBind
     * @fieldType  SynthesisCuttingToolBind
     * @Description  合成刀绑定信息
     */
    private SynthesisCuttingToolBindVO synthesisCuttingToolBindVO;

    /**
      * @fieldName upCuttingToolVOS
     * @fieldType  UpCuttingToolVO
     * @Description  换上刀具封装
     */
    private List<UpCuttingToolVO> upCuttingToolVOS;

    /**
      * @fieldName downCuttingToolVOS
     * @fieldType  downCuttingToolVOS
     * @Description  换下刀具封装
     */
    private List<DownCuttingToolVO> downCuttingToolVOS;


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

    public String getBladeCode() {
        return bladeCode;
    }

    public void setBladeCode(String bladeCode) {
        this.bladeCode = bladeCode;
    }

    public SynthesisCuttingToolBindVO getSynthesisCuttingToolBindVO() {
        return synthesisCuttingToolBindVO;
    }

    public void setSynthesisCuttingToolBindVO(SynthesisCuttingToolBindVO synthesisCuttingToolBindVO) {
        this.synthesisCuttingToolBindVO = synthesisCuttingToolBindVO;
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
}
