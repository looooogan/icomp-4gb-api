package com.service.common;

import com.common.pojo.OptionWarning;
import com.common.vo.OptionWarningVO;

import java.util.List;


/**
*
* @ClassName IOptionWarningService
* @Description OptionWarning业务接口
* @author Jivoin
*/
public interface IOptionWarningService {

    /**
    * @Title: addOptionWarning
    * @Description: 新增OptionWarning
    * @param optionWarning
    * @throws Exception
    * @return: void
    */
    public void addOptionWarning(OptionWarning optionWarning) throws Exception;

    /**
    * @Title: delOptionWarning
    * @Description: 删除OptionWarning
    * @param optionWarning
    * @throws Exception
    * @return: void
    */
    public void delOptionWarning(OptionWarning optionWarning) throws Exception;

    /**
    * @Title: delOptionWarningForLogic
    * @Description: 逻辑删除OptionWarning
    * @param optionWarning
    * @throws Exception
    * @return: void
    */
    public void delOptionWarningForLogic(OptionWarning optionWarning) throws Exception;

    /**
    * @Title: delOptionWarningByVo
    * @Description: 根据条件删除OptionWarning
    * @param optionWarningVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delOptionWarningByVo(OptionWarningVO optionWarningVO) throws Exception;

    /**
    * @Title: updOptionWarning
    * @Description: 动态更新OptionWarning
    * @param optionWarning
    * @throws Exception
    * @return: void
    */
    public void updOptionWarning(OptionWarning optionWarning) throws Exception;

    /**
    * @Title: getOptionWarningByPage
    * @Description: 分页查询
    * @param optionWarningVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<OptionWarning> getOptionWarningByPage(OptionWarningVO optionWarningVO) throws Exception;

    /**
    * @Title: getOptionWarningCount
    * @Description: 获取记录数量
    * @param optionWarningVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getOptionWarningCount(OptionWarningVO optionWarningVO) throws Exception;

    /**
    * @Title: getOptionWarning
    * @Description: 根据查询条件查询
    * @param optionWarningVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public OptionWarning getOptionWarning(OptionWarningVO optionWarningVO) throws Exception;

}
