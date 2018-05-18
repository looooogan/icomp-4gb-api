package com.apiclient.pojo;

import java.io.Serializable;
import java.util.List;

/**
* Created by jiangchenkeji
* Automated Build
* 实体 RfidContainer 
*/
public class RfidContainer implements Serializable{

    // 序列化接口属性
    private static final long serialVersionUID = 1L;
    /**
     * @fieldName id
    * @fieldType  Integer
    * @Description  RFID载体ID
     */
    private Integer id;

    /**
     * @fieldName code
    * @fieldType  String
    * @Description  RFID标签
     */
    private String code;
    /**
     * @fieldName useCount
    * @fieldType  Integer
    * @Description  使用次数
     */
    private Integer useCount;
    /**
     * @fieldName laserCode
    * @fieldType  String
    * @Description  激光识别码
     */
    private String laserCode;
    /**
     * @fieldName bindType
    * @fieldType  Integer
    * @Description  绑定类型(0RFID 1 激光码 2 工具盘 9 其他)
     */
    private Integer bindType;
    /**
     * @fieldName labelType
    * @fieldType  Integer
    * @Description  标签类型（0库位标签，1单品刀，2合成刀具，3员工卡，4设备，5容器，6备刀库）
     */
    private Integer labelType;
    /**
     * @fieldName isDel
    * @fieldType  Integer
    * @Description  删除区分(0有效1删除)
     */
    private Integer isDel;
    /**
     * @fieldName operatorCode
    * @fieldType  String
    * @Description  操作人
     */
    private String operatorCode;


    private List<AuthCustomer> authCustomerList;
    private List<CuttingToolBind> cuttingToolBindList;
    private List<ProductLineEquipment> productLineEquipmentList;
    private List<SynthesisCuttingToolBind> synthesisCuttingToolBindList;


    /* RFID载体ID */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }
    public String getLaserCode() {
        return laserCode;
    }

    public void setLaserCode(String laserCode) {
        this.laserCode = laserCode;
    }
    public Integer getBindType() {
        return bindType;
    }

    public void setBindType(Integer bindType) {
        this.bindType = bindType;
    }
    public Integer getLabelType() {
        return labelType;
    }

    public void setLabelType(Integer labelType) {
        this.labelType = labelType;
    }
    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }


    public List<AuthCustomer> getAuthCustomerList() {
        return authCustomerList;
    }

    public void setAuthCustomerList(List<AuthCustomer> authCustomerList) {
        this.authCustomerList = authCustomerList;
    }
    public List<CuttingToolBind> getCuttingToolBindList() {
        return cuttingToolBindList;
    }

    public void setCuttingToolBindList(List<CuttingToolBind> cuttingToolBindList) {
        this.cuttingToolBindList = cuttingToolBindList;
    }
    public List<ProductLineEquipment> getProductLineEquipmentList() {
        return productLineEquipmentList;
    }

    public void setProductLineEquipmentList(List<ProductLineEquipment> productLineEquipmentList) {
        this.productLineEquipmentList = productLineEquipmentList;
    }
    public List<SynthesisCuttingToolBind> getSynthesisCuttingToolBindList() {
        return synthesisCuttingToolBindList;
    }

    public void setSynthesisCuttingToolBindList(List<SynthesisCuttingToolBind> synthesisCuttingToolBindList) {
        this.synthesisCuttingToolBindList = synthesisCuttingToolBindList;
    }

}
