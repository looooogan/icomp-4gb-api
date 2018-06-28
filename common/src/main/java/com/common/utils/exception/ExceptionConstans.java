package com.common.utils.exception;

/**
 * Created by logan on 2018/5/5.
 */
public class ExceptionConstans {

    //出库
    public static String OUTAPPLY_NON_ORDERS = "oa_001";

    //库存提示
    public static String MATERIALINVENTORY_CUTTINGTOOL_UNFOUND = "mc_001";
    public static String MATERIALINVENTORY_CUTTINGTOOL_EXISTS = "mc_002";
    public static String MATERIALINVENTORY_CUTTINGTOOL_TYPE_ERROR = "mc_003";

    //合成刀提示
    public static String SYNTHESISCUTTINGTOOL_CONFIG_EXISTS = "sctc_001";
    public static String SYNTHESISCUTTINGTOOL_CTTYPE_NOTMATCH = "sctc_002";
    public static String SYNTHESISCUTTINGTOOL_CTTYPE_ERROR = "sctc_003";
    public static String SYNTHESISCUTTINGTOOL_CTCOUNT_ERROR = "sctc_004";
    public static String SYNTHESISCUTTINGTOOL_NOT_EXISTS = "sctc_005";
    public static String SYNTHESISCUTTINGTOOL_CONFIG_NOT_EXISTS = "sctc_006";
    public static String SYNTHESISCUTTINGTOOL_SYNCODE_NULL = "sctc_007";
    //合成刀绑定提示
    public static String SYNTHESIS_BIND_EXISTS = "ssb_001";
    public static String SYNTHESIS_BIND_NOTEXISTS = "ssb_002";
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
    //合成刀刀身码
    public static String SYNTHESIS_BLADE_ERROR = "sb_001";
    public static String SYNTHESIS_BLADE_TOOLEXISTS = "sb_002";
    public static String SYNTHESIS_BLADE_NOTEXISTS = "sb_003";
    public static String SYNTHESIS_BLADE_INUSE = "sb_004";

    //启明
    public static String QM_SUSR20_UNITQTY_CHANGE_ERROR = "qm_001";
    public static String QM_DJOUTAPPLYAKP_MAP_ERROR = "qm_002";

    //提示
    public static String EXCHANGE_MESSAGE = "info_001";
    public static String CONFIG_MESSAGE = "info_002";
    public static String Installed_MESSAGE = "info_003";
    public static String UnInstalled_MESSAGE = "info_004";
    public static String UnConfig_MESSAGE = "info_005";
    public static String GRINDING_TYPE_ERROR_MESSAGE = "info_006";

    //生产关联关系
    public static String LINE_EQUIPMENT_EXISTS = "le_001";
    public static String LINE_PARTS_EXISTS = "lp_001";
    public static String LINE_PROSSES_EXISTS = "lps_001";


    public static String MESSAGE_SUFXX = " 上一步操作为:";

}
