package com.service.power.impl;


import com.common.constants.OperationEnum;
import com.common.constants.PowerTypeEnum;
import com.common.mapper.*;
import com.common.pojo.*;
import com.common.vo.*;
import com.service.power.IPowerService;
import com.service.power.vo.PowerSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
*
* @ClassName PowerServiceImpl
* @Description Power业务实现类
* @author Jivoin
*/
@Service("powerService")
public class PowerServiceImpl implements IPowerService{

    @Autowired
    private IPowerMapper powerMapper;
    @Autowired
    private IPowerUserHasGroupMapper powerUserHasGroupMapper;
    @Autowired
    private IPowerHasGroupMapper powerHasGroupMapper;
    @Autowired
    private IPowerPositionHasGroupMapper powerPositionHasGroupMapper;
    @Autowired
    private IPowerGroupMapper powerGroupMapper;
    @Autowired
    private IAuthCustomerMapper authCustomerMapper;



    /**
    * @Title: addPower
    * @Description: 新增Power
    * @param power
    * @throws Exception
    * @return: void
    */
    @Override
    public void addPower(Power power) throws Exception{
        powerMapper.addPower(power);
    }

    /**
    * @Title: delPower
    * @Description: 删除Power
    * @param power
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPower(Power power) throws Exception{
        powerMapper.delPower(power);
    }

    /**
    * @Title: delPowerForLogic
    * @Description: 逻辑删除Power
    * @param power
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerForLogic(Power power) throws Exception{
        powerMapper.delPowerForLogic(power);
    }

    /**
    * @Title: delPowerByVo
    * @Description: 根据条件删除Power
    * @param powerVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerByVo(PowerVO powerVO) throws Exception{
        powerMapper.delPowerByVo(powerVO);
    }

    /**
    * @Title: updPower
    * @Description: 动态更新Power
    * @param power
    * @throws Exception
    * @return: void
    */
    @Override
    public void updPower(Power power) throws Exception{
        powerMapper.updPower(power);
    }

    /**
    * @Title: getPowerByPage
    * @Description: 分页查询
    * @param powerVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<Power> getPowerByPage(PowerVO powerVO) throws Exception{
        powerVO.setTotalPage(powerMapper.getPowerCount(powerVO));
        return powerMapper.getPowerByPage(powerVO);
    }

    /**
    * @Title: getPowerCount
    * @Description: 获取记录数量
    * @param powerVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getPowerCount(PowerVO powerVO) throws Exception{
        return powerMapper.getPowerCount(powerVO);
    }

    /**
    * @Title: getPower
    * @Description: 根据查询条件查询
    * @param powerVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public Power getPower(PowerVO powerVO) throws Exception{
        return powerMapper.getPower(powerVO);
    }

    @Override
    public List<Power> getPowerByVO(PowerSearchVO powerSearchVO) throws Exception {
        List<Power> powers = new ArrayList<>();
        if (null!=powerSearchVO.getUserCode()&&!"".equals(powerSearchVO.getUserCode())){
            AuthCustomerVO authCustomerVO = new AuthCustomerVO();
            authCustomerVO.setCode(powerSearchVO.getUserCode());
            AuthCustomer authCustomer = authCustomerMapper.getAuthCustomer(authCustomerVO);
            powerSearchVO.setPositionId(authCustomer.getAuthPositionCode());
            //获取用户的权限
            PowerUserHasGroupVO userHasGroupVO = new PowerUserHasGroupVO();
            userHasGroupVO.setAuthCustomerCode(powerSearchVO.getUserCode());
            List<PowerUserHasGroup> powerUserHasGroups = powerUserHasGroupMapper.getPowerUserHasGroupByPage(userHasGroupVO);

            PowerHasGroupVO powerHasGroupVO = null;
            List<Power> tempPowers = null;

            for (PowerUserHasGroup powerUserHasGroup : powerUserHasGroups) {
                powerHasGroupVO = new PowerHasGroupVO();
                powerHasGroupVO.setPowerGroupCode(powerUserHasGroup.getPowerGroupCode());
                tempPowers = getPowerByGroup(powerHasGroupVO);
                tempPowers.stream().forEach(power -> {
                    if (!powers.contains(power)){
                        powers.add(power);
                    }
                });
            }
        }

        //获取职位的权限
        if (null!=powerSearchVO.getPositionId()){
            PowerPositionHasGroupVO powerPositionHasGroupVO = new PowerPositionHasGroupVO();
            powerPositionHasGroupVO.setAuthPositionCode(powerSearchVO.getPositionId());
            List<PowerPositionHasGroup> powerPositionHasGroups = powerPositionHasGroupMapper.getPowerPositionHasGroupByPage(powerPositionHasGroupVO);
            PowerHasGroupVO powerHasGroupVO = null;
            List<Power> tempPowers = null;
            for (PowerPositionHasGroup powerPositionHasGroup : powerPositionHasGroups) {
                powerHasGroupVO = new PowerHasGroupVO();
                powerHasGroupVO.setPowerGroupCode(powerPositionHasGroup.getPowerGroupCode());
                tempPowers = getPowerByGroup(powerHasGroupVO);
                tempPowers.stream().forEach(power -> {
                    if (!powers.contains(power)){
                        powers.add(power);
                    }
                });

            }
        }
        return powers;
    }

    public List<Power> getPowerByGroup(PowerHasGroupVO powerHasGroupVO) throws Exception{
        List<Power> powers = new ArrayList<>();
        List<PowerHasGroup> tempPowers = powerHasGroupMapper.getPowerHasGroupByPage(powerHasGroupVO);
        if (null == tempPowers || tempPowers.size()<=0){
            return powers;
        }
        tempPowers.stream().forEach(powerHasGroup -> {
            if (!powers.contains(powerHasGroup.getPower())){
                powers.add(powerHasGroup.getPower());
            }
        });
        return powers;
    }

    @Override
    public boolean checkUserHasPower(PowerSearchVO powerSearchVO) throws Exception {
        return false;
    }

    @Override
    public boolean getMenuPower(PowerSearchVO powerSearchVO) throws Exception {
        return false;
    }

    @Override
    public List<Power> getPowerForSetting(PowerSearchVO powerSearchVO) throws Exception {
        powerSearchVO.setIsRoot(PowerTypeEnum.root.getTypeKey());
        PowerVO powerVO = new PowerVO();
        powerVO.setIsRoot(PowerTypeEnum.root.getTypeKey());
        return getPowerByRecursion(powerVO);
    }

    public List<Power> getPowerByRecursion(PowerVO powerVO) throws Exception{
        List<Power> powers = powerMapper.getPowerByPage(powerVO);
        PowerVO tempPowerVO = null;
        for (Power power : powers) {
            tempPowerVO = new PowerVO();
            tempPowerVO.setParentId(power.getId());
            power.setChildPowers(getPowerByRecursion(tempPowerVO));
        }
        return powers;
    }

    @Override
    public void bindPowersData(PowerSearchVO powerSearchVO) throws Exception {
        PowerPositionHasGroupVO powerPositionHasGroupVO = new PowerPositionHasGroupVO();
        powerPositionHasGroupVO.setAuthPositionCode(powerSearchVO.getPositionId());

        //删除之前的配置
        powerPositionHasGroupMapper.delPowerPositionHasGroupByVo(powerPositionHasGroupVO);

        List<PowerPositionHasGroup> powerPositionHasGroups = powerPositionHasGroupMapper.getPowerPositionHasGroupByPage(powerPositionHasGroupVO);
        PowerGroupVO powerGroupVO = null;
        PowerHasGroupVO powerHasGroupVO = null;
        for (PowerPositionHasGroup powerPositionHasGroup : powerPositionHasGroups) {
            powerGroupVO = new PowerGroupVO();
            powerHasGroupVO = new PowerHasGroupVO();
            powerHasGroupVO.setPowerGroupCode(powerPositionHasGroup.getPowerGroupCode());
            powerHasGroupMapper.delPowerHasGroupByVo(powerHasGroupVO);

            powerGroupVO.setId(powerPositionHasGroup.getPowerGroupCode());
            powerGroupMapper.delPowerGroupByVo(powerGroupVO);
        }


        //添加新的配置
        PowerGroup powerGroup = new PowerGroup();
        powerGroup.setIsDel(0);
        powerGroup.setIsRole("0");
        powerGroupMapper.addPowerGroup(powerGroup);

        PowerPositionHasGroup powerPositionHasGroup = new PowerPositionHasGroup();
        powerPositionHasGroup.setPowerGroupCode(powerGroup.getId());
        powerPositionHasGroup.setAuthPositionCode(powerSearchVO.getPositionId());
        powerPositionHasGroup.setIsDel(0);
        powerPositionHasGroupMapper.addPowerPositionHasGroup(powerPositionHasGroup);

        PowerHasGroup powerHasGroup = null;
        for (Integer powerId : powerSearchVO.getPowerIds()) {
            powerHasGroup = new PowerHasGroup();
            powerHasGroup.setPowerCode(powerId);
            powerHasGroup.setPowerGroupCode(powerGroup.getId());
            powerHasGroup.setIsDel(0);
            powerHasGroupMapper.addPowerHasGroup(powerHasGroup);
        }

    }

    @Override
    public AuthCustomer imPower(PowerSearchVO powerSearchVO) throws Exception {
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(powerSearchVO.getUserCode());
        AuthCustomer authCustomer = authCustomerMapper.getAuthCustomer(authCustomerVO);
        powerSearchVO.setPositionId(authCustomer.getAuthPositionCode());
        List<Power> powers = this.getPowerByVO(powerSearchVO);
        boolean flag =false;
        for (Power power : powers) {
            if (power.getIdentify().equals(OperationEnum.Audit.getIdentify())){
                flag = true;
                break;
            }
        }
        if (flag){
            return authCustomer;
        }

        return null;
    }
}
