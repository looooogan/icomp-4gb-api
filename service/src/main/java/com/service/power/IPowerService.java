package com.service.power;

import com.common.pojo.AuthCustomer;
import com.common.pojo.Power;
import com.common.vo.PowerVO;
import com.service.power.vo.PowerSearchVO;

import java.util.List;


/**
*
* @ClassName IPowerService
* @Description Power业务接口
* @author Jivoin
*/
public interface IPowerService {

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

    /**
     * @Title: getPowerByVO
     * @Description: 根据查询条件查询
     * @param powerSearchVO 查询条件封装
     * @throws Exception
     * @return: 查询结果
     */
    public List<Power> getPowerByVO(PowerSearchVO powerSearchVO) throws Exception;

    /**
     * @Title: checkUserHasPower
     * @Description: 检查用户是否拥有权限
     * @param powerSearchVO 查询条件封装
     * @throws Exception
     * @return: 查询结果
     */
    public boolean checkUserHasPower(PowerSearchVO powerSearchVO) throws Exception;

    /**
     * @Title: getMenuPower
     * @Description: 获取菜单权限列表
     * @param powerSearchVO 查询条件封装
     * @throws Exception
     * @return: 查询结果
     */
    public boolean getMenuPower(PowerSearchVO powerSearchVO) throws Exception;


    /**
     * @Title: getPowerForSetting
     * @Description: 设置权限查询
     * @param powerSearchVO 查询条件封装
     * @throws Exception
     * @return: 查询结果
     */
    public List<Power> getPowerForSetting(PowerSearchVO powerSearchVO) throws Exception;

    /**
     * @Title: bindPowers
     * @Description: 绑定权限
     * @param powerSearchVO 查询条件封装
     * @throws Exception
     * @return: 查询结果
     */
    public void bindPowersData(PowerSearchVO powerSearchVO) throws Exception;


    /**
     * @Title: imPower
     * @Description: 授权
     * @param powerSearchVO 查询条件封装
     * @throws Exception
     * @return: 查询结果
     */
    public AuthCustomer imPower(PowerSearchVO powerSearchVO) throws Exception;



}
