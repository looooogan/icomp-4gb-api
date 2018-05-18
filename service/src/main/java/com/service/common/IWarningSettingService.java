package com.service.common;

import com.common.pojo.WarningSetting;
import com.common.vo.WarningSettingVO;

import java.util.List;


/**
*
* @ClassName IWarningSettingService
* @Description WarningSetting业务接口
* @author Jivoin
*/
public interface IWarningSettingService {

    /**
    * @Title: addWarningSetting
    * @Description: 新增WarningSetting
    * @param warningSetting
    * @throws Exception
    * @return: void
    */
    public void addWarningSetting(WarningSetting warningSetting) throws Exception;

    /**
    * @Title: delWarningSetting
    * @Description: 删除WarningSetting
    * @param warningSetting
    * @throws Exception
    * @return: void
    */
    public void delWarningSetting(WarningSetting warningSetting) throws Exception;

    /**
    * @Title: delWarningSettingForLogic
    * @Description: 逻辑删除WarningSetting
    * @param warningSetting
    * @throws Exception
    * @return: void
    */
    public void delWarningSettingForLogic(WarningSetting warningSetting) throws Exception;

    /**
    * @Title: delWarningSettingByVo
    * @Description: 根据条件删除WarningSetting
    * @param warningSettingVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delWarningSettingByVo(WarningSettingVO warningSettingVO) throws Exception;

    /**
    * @Title: updWarningSetting
    * @Description: 动态更新WarningSetting
    * @param warningSetting
    * @throws Exception
    * @return: void
    */
    public void updWarningSetting(WarningSetting warningSetting) throws Exception;

    /**
    * @Title: getWarningSettingByPage
    * @Description: 分页查询
    * @param warningSettingVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<WarningSetting> getWarningSettingByPage(WarningSettingVO warningSettingVO) throws Exception;

    /**
    * @Title: getWarningSettingCount
    * @Description: 获取记录数量
    * @param warningSettingVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getWarningSettingCount(WarningSettingVO warningSettingVO) throws Exception;

    /**
    * @Title: getWarningSetting
    * @Description: 根据查询条件查询
    * @param warningSettingVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public WarningSetting getWarningSetting(WarningSettingVO warningSettingVO) throws Exception;

}
