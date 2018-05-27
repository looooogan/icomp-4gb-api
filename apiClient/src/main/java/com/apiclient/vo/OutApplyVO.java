package com.apiclient.vo;

import com.apiclient.pojo.DjCircleKanbanAkp;
import com.apiclient.pojo.DjMtlAkp;
import com.apiclient.pojo.DjOutapplyAkp;

/**
 * Created by logan on 2018/5/7.
 */
public class OutApplyVO {

    private Integer batchno;

    private DjOutapplyAkp djOutapplyAkp;

    private DjCircleKanbanAkp djCircleKanbanAkp;

    private DjMtlAkp djMtlAkp;

    private Integer susr20;

    private Integer unitqty;

    public Integer getBatchno() {
        return batchno;
    }

    public void setBatchno(Integer batchno) {
        this.batchno = batchno;
    }

    public DjOutapplyAkp getDjOutapplyAkp() {
        return djOutapplyAkp;
    }

    public void setDjOutapplyAkp(DjOutapplyAkp djOutapplyAkp) {
        this.djOutapplyAkp = djOutapplyAkp;
    }

    public DjCircleKanbanAkp getDjCircleKanbanAkp() {
        return djCircleKanbanAkp;
    }

    public void setDjCircleKanbanAkp(DjCircleKanbanAkp djCircleKanbanAkp) {
        this.djCircleKanbanAkp = djCircleKanbanAkp;
    }

    public DjMtlAkp getDjMtlAkp() {
        return djMtlAkp;
    }

    public void setDjMtlAkp(DjMtlAkp djMtlAkp) {
        this.djMtlAkp = djMtlAkp;
    }

    public Integer getSusr20() {
        return susr20;
    }

    public void setSusr20(Integer susr20) {
        this.susr20 = susr20;
    }

    public Integer getUnitqty() {
        return unitqty;
    }

    public void setUnitqty(Integer unitqty) {
        this.unitqty = unitqty;
    }
}
