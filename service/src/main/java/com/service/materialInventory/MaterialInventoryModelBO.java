package com.service.materialInventory;

import com.common.pojo.CuttingTool;

/**
 * Created by logan on 2018/6/11.
 */
public class MaterialInventoryModelBO {

    private CuttingTool cuttingTool;

    private Integer Unitqty;

    private String mtlCode;

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
