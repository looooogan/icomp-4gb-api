package com.service.power;

import com.common.pojo.PowerHasGroup;
import com.common.vo.PowerHasGroupVO;

import java.util.List;


/**
*
* @ClassName IPowerHasGroupService
* @Description PowerHasGroup业务接口
* @author Jivoin
*/
public interface IPowerHasGroupService {

    /**
    * @Title: addPowerHasGroup
    * @Description: 新增PowerHasGroup
    * @param powerHasGroup
    * @throws Exception
    * @return: void
    */
    public void addPowerHasGroup(PowerHasGroup powerHasGroup) throws Exception;

    /**
    * @Title: delPowerHasGroup
    * @Description: 删除PowerHasGroup
    * @param powerHasGroup
    * @throws Exception
    * @return: void
    */
    public void delPowerHasGroup(PowerHasGroup powerHasGroup) throws Exception;

    /**
    * @Title: delPowerHasGroupForLogic
    * @Description: 逻辑删除PowerHasGroup
    * @param powerHasGroup
    * @throws Exception
    * @return: void
    */
    public void delPowerHasGroupForLogic(PowerHasGroup powerHasGroup) throws Exception;

    /**
    * @Title: delPowerHasGroupByVo
    * @Description: 根据条件删除PowerHasGroup
    * @param powerHasGroupVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delPowerHasGroupByVo(PowerHasGroupVO powerHasGroupVO) throws Exception;

    /**
    * @Title: updPowerHasGroup
    * @Description: 动态更新PowerHasGroup
    * @param powerHasGroup
    * @throws Exception
    * @return: void
    */
    public void updPowerHasGroup(PowerHasGroup powerHasGroup) throws Exception;

    /**
    * @Title: getPowerHasGroupByPage
    * @Description: 分页查询
    * @param powerHasGroupVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<PowerHasGroup> getPowerHasGroupByPage(PowerHasGroupVO powerHasGroupVO) throws Exception;

    /**
    * @Title: getPowerHasGroupCount
    * @Description: 获取记录数量
    * @param powerHasGroupVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getPowerHasGroupCount(PowerHasGroupVO powerHasGroupVO) throws Exception;

    /**
    * @Title: getPowerHasGroup
    * @Description: 根据查询条件查询
    * @param powerHasGroupVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public PowerHasGroup getPowerHasGroup(PowerHasGroupVO powerHasGroupVO) throws Exception;

}
