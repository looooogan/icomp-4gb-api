package com.service.power;

import com.common.pojo.PowerPositionHasGroup;
import com.common.vo.PowerPositionHasGroupVO;

import java.util.List;


/**
*
* @ClassName IPowerPositionHasGroupService
* @Description PowerPositionHasGroup业务接口
* @author Jivoin
*/
public interface IPowerPositionHasGroupService {

    /**
    * @Title: addPowerPositionHasGroup
    * @Description: 新增PowerPositionHasGroup
    * @param powerPositionHasGroup
    * @throws Exception
    * @return: void
    */
    public void addPowerPositionHasGroup(PowerPositionHasGroup powerPositionHasGroup) throws Exception;

    /**
    * @Title: delPowerPositionHasGroup
    * @Description: 删除PowerPositionHasGroup
    * @param powerPositionHasGroup
    * @throws Exception
    * @return: void
    */
    public void delPowerPositionHasGroup(PowerPositionHasGroup powerPositionHasGroup) throws Exception;

    /**
    * @Title: delPowerPositionHasGroupForLogic
    * @Description: 逻辑删除PowerPositionHasGroup
    * @param powerPositionHasGroup
    * @throws Exception
    * @return: void
    */
    public void delPowerPositionHasGroupForLogic(PowerPositionHasGroup powerPositionHasGroup) throws Exception;

    /**
    * @Title: delPowerPositionHasGroupByVo
    * @Description: 根据条件删除PowerPositionHasGroup
    * @param powerPositionHasGroupVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delPowerPositionHasGroupByVo(PowerPositionHasGroupVO powerPositionHasGroupVO) throws Exception;

    /**
    * @Title: updPowerPositionHasGroup
    * @Description: 动态更新PowerPositionHasGroup
    * @param powerPositionHasGroup
    * @throws Exception
    * @return: void
    */
    public void updPowerPositionHasGroup(PowerPositionHasGroup powerPositionHasGroup) throws Exception;

    /**
    * @Title: getPowerPositionHasGroupByPage
    * @Description: 分页查询
    * @param powerPositionHasGroupVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<PowerPositionHasGroup> getPowerPositionHasGroupByPage(PowerPositionHasGroupVO powerPositionHasGroupVO) throws Exception;

    /**
    * @Title: getPowerPositionHasGroupCount
    * @Description: 获取记录数量
    * @param powerPositionHasGroupVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getPowerPositionHasGroupCount(PowerPositionHasGroupVO powerPositionHasGroupVO) throws Exception;

    /**
    * @Title: getPowerPositionHasGroup
    * @Description: 根据查询条件查询
    * @param powerPositionHasGroupVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public PowerPositionHasGroup getPowerPositionHasGroup(PowerPositionHasGroupVO powerPositionHasGroupVO) throws Exception;

}
