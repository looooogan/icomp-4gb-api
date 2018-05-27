package com.common.utils.exception;

/**
 * Created by logan on 2018/5/5.
 */
public class ExceptionConstans {

    //库存提示
    public static String MATERIALINVENTORY_CUTTINGTOOL_UNFOUND = "mc_001";
    public static String MATERIALINVENTORY_CUTTINGTOOL_EXISTS = "mc_002";
    public static String MATERIALINVENTORY_CUTTINGTOOL_TYPE_ERROR = "mc_003";

    //合成刀提示
    public static String SYNTHESISCUTTINGTOOL_CONFIG_EXISTS = "sctc_001";
    public static String SYNTHESISCUTTINGTOOL_CTTYPE_NOTMATCH = "sctc_002";
    public static String SYNTHESISCUTTINGTOOL_CTTYPE_ERROR = "sctc_003";
    public static String SYNTHESISCUTTINGTOOL_CTCOUNT_ERROR = "sctc_004";

    //材料刀提示
    public static String CUTTINGTOOL_NOT_EXISTS = "ctne_001";
    public static String CUTTINGTOOL_EXISTS = "ctne_002";

    //RFID提示
    public static String RFID_NOT_EXISTS = "rfid_001";
    public static String RFID_IN_USE = "rfid_002";
    public static String RFID_NOT_IN_USE = "rfid_003";

    //用户提示
    public static String AUTH_CUSTOMER_NOTEXISTS = "auc_001";
    public static String AUTH_CUSTOMER_PARAMERROR = "auc_002";

    //合成刀绑定记录
    public static String SBINDRECORDER_EXITS = "sbre_001";

    //启明
    public static String QM_SUSR20_UNITQTY_CHANGE_ERROR = "qm_001";
    public static String QM_DJOUTAPPLYAKP_MAP_ERROR = "qm_002";

}
