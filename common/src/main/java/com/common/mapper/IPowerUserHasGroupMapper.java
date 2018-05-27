package com.common.mapper;

import com.common.pojo.PowerUserHasGroup;
import com.common.vo.PowerUserHasGroupVO;

import java.util.List;


/**
*
* @ClassName IPowerUserHasGroupMapper
* @Description TODO
* @author Jivoin
*/
public interface IPowerUserHasGroupMapper {

    /**
    * @Title: addPowerUserHasGroup
    * @Description: 新增PowerUserHasGroup
    * @param powerUserHasGroup
    * @throws Exception
    * @return: void
    */
    public void addPowerUserHasGroup(PowerUserHasGroup powerUserHasGroup) throws Exception;

    /**
    * @Title: delPowerUserHasGroup
    * @Description: 删除PowerUserHasGroup
    * @param powerUserHasGroup
    * @throws Exception
    * @return: void
    */
    public void delPowerUserHasGroup(PowerUserHasGroup powerUserHasGroup) throws Exception;

    /**
    * @Title: delPowerUserHasGroupForLogic
    * @Description: 逻辑删除PowerUserHasGroup
    * @param powerUserHasGroup
    * @throws Exception
    * @return: void
    */
    public void delPowerUserHasGroupForLogic(PowerUserHasGroup powerUserHasGroup) throws Exception;

    /**
    * @Title: delPowerUserHasGroupByVo
    * @Description: 根据条件删除PowerUserHasGroup
    * @param powerUserHasGroupVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delPowerUserHasGroupByVo(PowerUserHasGroupVO powerUserHasGroupVO) throws Exception;

    /**
    * @Title: updPowerUserHasGroup
    * @Description: 动态更新PowerUserHasGroup
    * @param powerUserHasGroup
    * @throws Exception
    * @return: void
    */
    public void updPowerUserHasGroup(PowerUserHasGroup powerUserHasGroup) throws Exception;

    /**
    * @Title: getPowerUserHasGroupByPage
    * @Description: 分页查询
    * @param powerUserHasGroupVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<PowerUserHasGroup> getPowerUserHasGroupByPage(PowerUserHasGroupVO powerUserHasGroupVO) throws Exception;

    /**
    * @Title: getPowerUserHasGroupCount
    * @Description: 获取记录数量
    * @param powerUserHasGroupVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getPowerUserHasGroupCount(PowerUserHasGroupVO powerUserHasGroupVO) throws Exception;

    /**
    * @Title: getPowerUserHasGroup
    * @Description: 根据查询条件查询
    * @param powerUserHasGroupVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public PowerUserHasGroup getPowerUserHasGroup(PowerUserHasGroupVO powerUserHasGroupVO) throws Exception;

}
