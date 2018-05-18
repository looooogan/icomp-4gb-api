package com.apiclient.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* Created by jiangchenkeji
* Automated Build
* 实体 SynthesisCuttingToolBindleRecords 
*/
public class SynthesisCuttingToolBindleRecords implements Serializable{

    // 序列化接口属性
    private static final long serialVersionUID = 1L;
    /**
     * @fieldName id
    * @fieldType  Integer
    * @Description  标识
     */
    private Integer id;

    /**
     * @fieldName synthesisCuttingToolCode
    * @fieldType  String
    * @Description  
     */
    private String synthesisCuttingToolCode;
    /**
     * @fieldName synthesisCode
    * @fieldType  String
    * @Description  合成刀业务编码
     */
    private String synthesisCode;
    /**
     * @fieldName productLineEquipmentCode
    * @fieldType  String
    * @Description  设备
     */
    private String productLineEquipmentCode;
    /**
     * @fieldName productLineAssemblylineCode
    * @fieldType  String
    * @Description  流水线
     */
    private String productLineAssemblylineCode;
    /**
     * @fieldName productLineProcessCode
    * @fieldType  String
    * @Description  工序
     */
    private String productLineProcessCode;
    /**
     * @fieldName productLineAxleCode
    * @fieldType  String
    * @Description  
     */
    private String productLineAxleCode;
    /**
     * @fieldName productLinePartsCode
    * @fieldType  String
    * @Description  
     */
    private String productLinePartsCode;
    /**
     * @fieldName status
    * @fieldType  String
    * @Description  1 安上 2 卸下
     */
    private String status;
    /**
     * @fieldName operatorInstall
    * @fieldType  String
    * @Description  操作者
     */
    private String operatorInstall;
    /**
     * @fieldName reason
    * @fieldType  String
    * @Description  卸下原因
     */
    private String reason;
    /**
     * @fieldName ratedNumber
    * @fieldType  Integer
    * @Description  额定数量
     */
    private Integer ratedNumber;
    /**
     * @fieldName actualNumber
    * @fieldType  Integer
    * @Description  实际数量
     */
    private Integer actualNumber;
    /**
     * @fieldName isDel
    * @fieldType  Integer
    * @Description  逻辑删除
     */
    private Integer isDel;
    /**
     * @fieldName operatorUninstall
    * @fieldType  String
    * @Description  
     */
    private String operatorUninstall;
    /**
     * @fieldName operatorInstallName
    * @fieldType  String
    * @Description  
     */
    private String operatorInstallName;
    /**
     * @fieldName operatorUninstallName
    * @fieldType  String
    * @Description  
     */
    private String operatorUninstallName;
    /**
     * @fieldName operatorUninstallTime
    * @fieldType  Timestamp
    * @Description  卸下时间
     */
    private Timestamp operatorUninstallTime;
    /**
     * @fieldName operatorInstallTime
    * @fieldType  Timestamp
    * @Description  按上时间
     */
    private Timestamp operatorInstallTime;
    /**
     * @fieldName synthesisCuttingToolBindCode
    * @fieldType  String
    * @Description  
     */
    private String synthesisCuttingToolBindCode;
    /**
     * @fieldName bindRfid
    * @fieldType  String
    * @Description  
     */
    private String bindRfid;

    /**
     * @fieldName productLineAssemblylineCode
    * @fieldType  
    * @Description  流水线
     */
    private ProductLineAssemblyline productLineAssemblyline;
    /**
     * @fieldName productLineAxleCode
    * @fieldType  
    * @Description  
     */
    private ProductLineAxle productLineAxle;
    /**
     * @fieldName productLineEquipmentCode
    * @fieldType  
    * @Description  设备
     */
    private ProductLineEquipment productLineEquipment;
    /**
     * @fieldName productLinePartsCode
    * @fieldType  
    * @Description  
     */
    private ProductLineParts productLineParts;
    /**
     * @fieldName productLineProcessCode
    * @fieldType  
    * @Description  工序
     */
    private ProductLineProcess productLineProcess;
    /**
     * @fieldName synthesisCuttingToolCode
    * @fieldType  
    * @Description  
     */
    private SynthesisCuttingTool synthesisCuttingTool;
    /**
     * @fieldName synthesisCuttingToolBindCode
    * @fieldType  
    * @Description  
     */
    private SynthesisCuttingToolBind synthesisCuttingToolBind;



    /* 标识 */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSynthesisCuttingToolCode() {
        return synthesisCuttingToolCode;
    }

    public void setSynthesisCuttingToolCode(String synthesisCuttingToolCode) {
        this.synthesisCuttingToolCode = synthesisCuttingToolCode;
    }
    public String getSynthesisCode() {
        return synthesisCode;
    }

    public void setSynthesisCode(String synthesisCode) {
        this.synthesisCode = synthesisCode;
    }
    public String getProductLineEquipmentCode() {
        return productLineEquipmentCode;
    }

    public void setProductLineEquipmentCode(String productLineEquipmentCode) {
        this.productLineEquipmentCode = productLineEquipmentCode;
    }
    public String getProductLineAssemblylineCode() {
        return productLineAssemblylineCode;
    }

    public void setProductLineAssemblylineCode(String productLineAssemblylineCode) {
        this.productLineAssemblylineCode = productLineAssemblylineCode;
    }
    public String getProductLineProcessCode() {
        return productLineProcessCode;
    }

    public void setProductLineProcessCode(String productLineProcessCode) {
        this.productLineProcessCode = productLineProcessCode;
    }
    public String getProductLineAxleCode() {
        return productLineAxleCode;
    }

    public void setProductLineAxleCode(String productLineAxleCode) {
        this.productLineAxleCode = productLineAxleCode;
    }
    public String getProductLinePartsCode() {
        return productLinePartsCode;
    }

    public void setProductLinePartsCode(String productLinePartsCode) {
        this.productLinePartsCode = productLinePartsCode;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getOperatorInstall() {
        return operatorInstall;
    }

    public void setOperatorInstall(String operatorInstall) {
        this.operatorInstall = operatorInstall;
    }
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public Integer getRatedNumber() {
        return ratedNumber;
    }

    public void setRatedNumber(Integer ratedNumber) {
        this.ratedNumber = ratedNumber;
    }
    public Integer getActualNumber() {
        return actualNumber;
    }

    public void setActualNumber(Integer actualNumber) {
        this.actualNumber = actualNumber;
    }
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
    public String getOperatorUninstall() {
        return operatorUninstall;
    }

    public void setOperatorUninstall(String operatorUninstall) {
        this.operatorUninstall = operatorUninstall;
    }
    public String getOperatorInstallName() {
        return operatorInstallName;
    }

    public void setOperatorInstallName(String operatorInstallName) {
        this.operatorInstallName = operatorInstallName;
    }
    public String getOperatorUninstallName() {
        return operatorUninstallName;
    }

    public void setOperatorUninstallName(String operatorUninstallName) {
        this.operatorUninstallName = operatorUninstallName;
    }
    public Timestamp getOperatorUninstallTime() {
        return operatorUninstallTime;
    }

    public void setOperatorUninstallTime(Timestamp operatorUninstallTime) {
        this.operatorUninstallTime = operatorUninstallTime;
    }
    public Timestamp getOperatorInstallTime() {
        return operatorInstallTime;
    }

    public void setOperatorInstallTime(Timestamp operatorInstallTime) {
        this.operatorInstallTime = operatorInstallTime;
    }
    public String getSynthesisCuttingToolBindCode() {
        return synthesisCuttingToolBindCode;
    }

    public void setSynthesisCuttingToolBindCode(String synthesisCuttingToolBindCode) {
        this.synthesisCuttingToolBindCode = synthesisCuttingToolBindCode;
    }
    public String getBindRfid() {
        return bindRfid;
    }

    public void setBindRfid(String bindRfid) {
        this.bindRfid = bindRfid;
    }

    public ProductLineAssemblyline getProductLineAssemblyline() {
        return productLineAssemblyline;
    }

    public void setProductLineAssemblyline(ProductLineAssemblyline productLineAssemblyline) {
        this.productLineAssemblyline = productLineAssemblyline;
    }
    public ProductLineAxle getProductLineAxle() {
        return productLineAxle;
    }

    public void setProductLineAxle(ProductLineAxle productLineAxle) {
        this.productLineAxle = productLineAxle;
    }
    public ProductLineEquipment getProductLineEquipment() {
        return productLineEquipment;
    }

    public void setProductLineEquipment(ProductLineEquipment productLineEquipment) {
        this.productLineEquipment = productLineEquipment;
    }
    public ProductLineParts getProductLineParts() {
        return productLineParts;
    }

    public void setProductLineParts(ProductLineParts productLineParts) {
        this.productLineParts = productLineParts;
    }
    public ProductLineProcess getProductLineProcess() {
        return productLineProcess;
    }

    public void setProductLineProcess(ProductLineProcess productLineProcess) {
        this.productLineProcess = productLineProcess;
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
