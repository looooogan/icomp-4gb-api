package com.common.mapper;

import com.common.pojo.Power;
import com.common.vo.PowerVO;

import java.util.List;


/**
*
* @ClassName IPowerMapper
* @Description TODO
* @author Jivoin
*/
public interface IPowerMapper {

    /**
    * @Title: addPower
    * @Description: 新增Power
    * @param power
    * @throws Exception
    * @return: void
    */
    public void addPower(Power power) throws Exception;

    /**
    * @Title: delPower
    * @Description: 删除Power
    * @param power
    * @throws Exception
    * @return: void
    */
    public void delPower(Power power) throws Exception;

    /**
    * @Title: delPowerForLogic
    * @Description: 逻辑删除Power
    * @param power
    * @throws Exception
    * @return: void
    */
    public void delPowerForLogic(Power power) throws Exception;

    /**
    * @Title: delPowerByVo
    * @Description: 根据条件删除Power
    * @param powerVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delPowerByVo(PowerVO powerVO) throws Exception;

    /**
    * @Title: updPower
    * @Description: 动态更新Power
    * @param power
    * @throws Exception
    * @return: void
    */
    public void updPower(Power power) throws Exception;

    /**
    * @Title: getPowerByPage
    * @Description: 分页查询
    * @param powerVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<Power> getPowerByPage(PowerVO powerVO) throws Exception;

    /**
    * @Title: getPowerCount
    * @Description: 获取记录数量
    * @param powerVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getPowerCount(PowerVO powerVO) throws Exception;

    /**
    * @Title: getPower
    * @Description: 根据查询条件查询
    * @param powerVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public Power getPower(PowerVO powerVO) throws Exception;

}
