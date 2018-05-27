package com.service.power;

import com.common.pojo.PowerGroup;
import com.common.vo.PowerGroupVO;

import java.util.List;


/**
*
* @ClassName IPowerGroupService
* @Description PowerGroup业务接口
* @author Jivoin
*/
public interface IPowerGroupService {

    /**
    * @Title: addPowerGroup
    * @Description: 新增PowerGroup
    * @param powerGroup
    * @throws Exception
    * @return: void
    */
    public void addPowerGroup(PowerGroup powerGroup) throws Exception;

    /**
    * @Title: delPowerGroup
    * @Description: 删除PowerGroup
    * @param powerGroup
    * @throws Exception
    * @return: void
    */
    public void delPowerGroup(PowerGroup powerGroup) throws Exception;

    /**
    * @Title: delPowerGroupForLogic
    * @Description: 逻辑删除PowerGroup
    * @param powerGroup
    * @throws Exception
    * @return: void
    */
    public void delPowerGroupForLogic(PowerGroup powerGroup) throws Exception;

    /**
    * @Title: delPowerGroupByVo
    * @Description: 根据条件删除PowerGroup
    * @param powerGroupVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delPowerGroupByVo(PowerGroupVO powerGroupVO) throws Exception;

    /**
    * @Title: updPowerGroup
    * @Description: 动态更新PowerGroup
    * @param powerGroup
    * @throws Exception
    * @return: void
    */
    public void updPowerGroup(PowerGroup powerGroup) throws Exception;

    /**
    * @Title: getPowerGroupByPage
    * @Description: 分页查询
    * @param powerGroupVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<PowerGroup> getPowerGroupByPage(PowerGroupVO powerGroupVO) throws Exception;

    /**
    * @Title: getPowerGroupCount
    * @Description: 获取记录数量
    * @param powerGroupVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getPowerGroupCount(PowerGroupVO powerGroupVO) throws Exception;

    /**
    * @Title: getPowerGroup
    * @Description: 根据查询条件查询
    * @param powerGroupVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public PowerGroup getPowerGroup(PowerGroupVO powerGroupVO) throws Exception;

}
