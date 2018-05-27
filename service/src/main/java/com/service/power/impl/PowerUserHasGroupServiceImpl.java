package com.service.power.impl;


import com.common.mapper.IAuthCustomerMapper;
import com.common.mapper.IPowerGroupMapper;
import com.common.mapper.IPowerUserHasGroupMapper;
import com.common.pojo.PowerUserHasGroup;
import com.common.vo.PowerUserHasGroupVO;
import com.service.power.IPowerUserHasGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName PowerUserHasGroupServiceImpl
* @Description PowerUserHasGroup业务实现类
* @author Jivoin
*/
@Service("powerUserHasGroupService")
public class PowerUserHasGroupServiceImpl implements IPowerUserHasGroupService{

    @Autowired
    private IPowerUserHasGroupMapper powerUserHasGroupMapper;

    @Autowired
    private IAuthCustomerMapper authCustomerMapper;
    @Autowired
    private IPowerGroupMapper powerGroupMapper;


    /**
    * @Title: addPowerUserHasGroup
    * @Description: 新增PowerUserHasGroup
    * @param powerUserHasGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void addPowerUserHasGroup(PowerUserHasGroup powerUserHasGroup) throws Exception{
        powerUserHasGroupMapper.addPowerUserHasGroup(powerUserHasGroup);
    }

    /**
    * @Title: delPowerUserHasGroup
    * @Description: 删除PowerUserHasGroup
    * @param powerUserHasGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerUserHasGroup(PowerUserHasGroup powerUserHasGroup) throws Exception{
        powerUserHasGroupMapper.delPowerUserHasGroup(powerUserHasGroup);
    }

    /**
    * @Title: delPowerUserHasGroupForLogic
    * @Description: 逻辑删除PowerUserHasGroup
    * @param powerUserHasGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerUserHasGroupForLogic(PowerUserHasGroup powerUserHasGroup) throws Exception{
        powerUserHasGroupMapper.delPowerUserHasGroupForLogic(powerUserHasGroup);
    }

    /**
    * @Title: delPowerUserHasGroupByVo
    * @Description: 根据条件删除PowerUserHasGroup
    * @param powerUserHasGroupVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerUserHasGroupByVo(PowerUserHasGroupVO powerUserHasGroupVO) throws Exception{
        powerUserHasGroupMapper.delPowerUserHasGroupByVo(powerUserHasGroupVO);
    }

    /**
    * @Title: updPowerUserHasGroup
    * @Description: 动态更新PowerUserHasGroup
    * @param powerUserHasGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void updPowerUserHasGroup(PowerUserHasGroup powerUserHasGroup) throws Exception{
        powerUserHasGroupMapper.updPowerUserHasGroup(powerUserHasGroup);
    }

    /**
    * @Title: getPowerUserHasGroupByPage
    * @Description: 分页查询
    * @param powerUserHasGroupVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<PowerUserHasGroup> getPowerUserHasGroupByPage(PowerUserHasGroupVO powerUserHasGroupVO) throws Exception{
        powerUserHasGroupVO.setTotalPage(powerUserHasGroupMapper.getPowerUserHasGroupCount(powerUserHasGroupVO));
        return powerUserHasGroupMapper.getPowerUserHasGroupByPage(powerUserHasGroupVO);
    }

    /**
    * @Title: getPowerUserHasGroupCount
    * @Description: 获取记录数量
    * @param powerUserHasGroupVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getPowerUserHasGroupCount(PowerUserHasGroupVO powerUserHasGroupVO) throws Exception{
        return powerUserHasGroupMapper.getPowerUserHasGroupCount(powerUserHasGroupVO);
    }

    /**
    * @Title: getPowerUserHasGroup
    * @Description: 根据查询条件查询
    * @param powerUserHasGroupVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public PowerUserHasGroup getPowerUserHasGroup(PowerUserHasGroupVO powerUserHasGroupVO) throws Exception{
        return powerUserHasGroupMapper.getPowerUserHasGroup(powerUserHasGroupVO);
    }

}
