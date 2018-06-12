package com.common.constants;

import com.common.pojo.ImpowerRecorder;

/**
 * Created by logan on 2018/5/28.
 */
public enum ImpowerReasonEnum {
    Repetition_Exchange("1","1","重复换装",OperationEnum.SynthesisCuttingTool_Exchange.getKey(),OperationEnum.SynthesisCuttingTool_Exchange.getKey()),
    Exchange_Config("2","2","换装后组装",OperationEnum.SynthesisCuttingTool_Exchange.getKey(),OperationEnum.SynthesisCuttingTool_Config.getKey()),
    Config_Exchange("3","2","组装后换装",OperationEnum.SynthesisCuttingTool_Config.getKey(),OperationEnum.SynthesisCuttingTool_Exchange.getKey()),
    Repetition_Init("4","3","重复初始化",OperationEnum.SynthesisCuttingTool_Init.getKey(),OperationEnum.SynthesisCuttingTool_Init.getKey()),
    UnInstall_Install("5","4","卸下后安上",OperationEnum.SynthesisCuttingTool_Install.getKey(),OperationEnum.SynthesisCuttingTool_UnInstall.getKey()),
    Repetition_Inside_Grinding("6","5","重复厂内刃磨",OperationEnum.Cutting_tool_Inside.getKey(),OperationEnum.Cutting_tool_Inside.getKey()),
    Repetition_OutSide_Grinding("7","5","重复厂外刃磨",OperationEnum.Cutting_tool_OutSide.getKey(),OperationEnum.Cutting_tool_OutSide.getKey()),
    Grinding_Inside_OutSide("8","5","重复刃磨-厂内场外",OperationEnum.Cutting_tool_Inside.getKey(),OperationEnum.Cutting_tool_OutSide.getKey()),
    Grinding_OutSide_Inside("9","5","重复刃磨-场外厂内",OperationEnum.Cutting_tool_OutSide.getKey(),OperationEnum.Cutting_tool_Inside.getKey()),
    Repetition_Coating("10","5","重复刃磨-涂层",OperationEnum.Cutting_tool_Inside_Coating.getKey(),OperationEnum.Cutting_tool_Inside_Coating.getKey()),
    Grinding_Coating_Inside("11","5","重复刃磨-涂层厂内",OperationEnum.Cutting_tool_Inside_Coating.getKey(),OperationEnum.Cutting_tool_Inside.getKey()),
    Grinding_Coating_OutSide("12","5","重复刃磨-涂层场外",OperationEnum.Cutting_tool_Inside_Coating.getKey(),OperationEnum.Cutting_tool_OutSide.getKey()),
    Grinding_OutSide_Coating("13","5","重复刃磨-厂内涂层",OperationEnum.Cutting_tool_OutSide.getKey(),OperationEnum.Cutting_tool_Inside_Coating.getKey()),
    Grinding_Inside_Coating("14","5","重复刃磨-场外涂层",OperationEnum.Cutting_tool_Inside.getKey(),OperationEnum.Cutting_tool_Inside_Coating.getKey()),
    ;

    private String reason;
    private String reasonKey;
    private String resonValue;
    private Integer operationKey;
    private Integer prevOperatoionKey;

    ImpowerReasonEnum(String reason, String reasonKey, String resonValue, Integer operationKey, Integer prevOperatoionKey) {
        this.reason = reason;
        this.reasonKey = reasonKey;
        this.resonValue = resonValue;
        this.operationKey = operationKey;
        this.prevOperatoionKey = prevOperatoionKey;
    }

    public static ImpowerReasonEnum getImpowerRecorderByOperation(Integer operationKey, Integer prevOperatoionKey){
        for (ImpowerReasonEnum impowerReasonEnum : values()) {
            if (impowerReasonEnum.getOperationKey()==operationKey
                    &&impowerReasonEnum.getPrevOperatoionKey() == prevOperatoionKey){
                return impowerReasonEnum;
            }
        }
        return null;
    }

    public String getReasonKey() {
        return reasonKey;
    }

    public void setReasonKey(String reasonKey) {
        this.reasonKey = reasonKey;
    }

    public String getResonValue() {
        return resonValue;
    }

    public void setResonValue(String resonValue) {
        this.resonValue = resonValue;
    }

    public Integer getOperationKey() {
        return operationKey;
    }

    public void setOperationKey(Integer operationKey) {
        this.operationKey = operationKey;
    }

    public Integer getPrevOperatoionKey() {
        return prevOperatoionKey;
    }

    public void setPrevOperatoionKey(Integer prevOperatoionKey) {
        this.prevOperatoionKey = prevOperatoionKey;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
