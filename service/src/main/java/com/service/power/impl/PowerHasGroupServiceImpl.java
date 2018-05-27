package com.service.power.impl;


import com.common.mapper.IPowerGroupMapper;
import com.common.mapper.IPowerHasGroupMapper;
import com.common.mapper.IPowerMapper;
import com.common.pojo.PowerHasGroup;
import com.common.vo.PowerHasGroupVO;
import com.service.power.IPowerHasGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName PowerHasGroupServiceImpl
* @Description PowerHasGroup业务实现类
* @author Jivoin
*/
@Service("powerHasGroupService")
public class PowerHasGroupServiceImpl implements IPowerHasGroupService{

    @Autowired
    private IPowerHasGroupMapper powerHasGroupMapper;

    @Autowired
    private IPowerGroupMapper powerGroupMapper;
    @Autowired
    private IPowerMapper powerMapper;


    /**
    * @Title: addPowerHasGroup
    * @Description: 新增PowerHasGroup
    * @param powerHasGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void addPowerHasGroup(PowerHasGroup powerHasGroup) throws Exception{
        powerHasGroupMapper.addPowerHasGroup(powerHasGroup);
    }

    /**
    * @Title: delPowerHasGroup
    * @Description: 删除PowerHasGroup
    * @param powerHasGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerHasGroup(PowerHasGroup powerHasGroup) throws Exception{
        powerHasGroupMapper.delPowerHasGroup(powerHasGroup);
    }

    /**
    * @Title: delPowerHasGroupForLogic
    * @Description: 逻辑删除PowerHasGroup
    * @param powerHasGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerHasGroupForLogic(PowerHasGroup powerHasGroup) throws Exception{
        powerHasGroupMapper.delPowerHasGroupForLogic(powerHasGroup);
    }

    /**
    * @Title: delPowerHasGroupByVo
    * @Description: 根据条件删除PowerHasGroup
    * @param powerHasGroupVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerHasGroupByVo(PowerHasGroupVO powerHasGroupVO) throws Exception{
        powerHasGroupMapper.delPowerHasGroupByVo(powerHasGroupVO);
    }

    /**
    * @Title: updPowerHasGroup
    * @Description: 动态更新PowerHasGroup
    * @param powerHasGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void updPowerHasGroup(PowerHasGroup powerHasGroup) throws Exception{
        powerHasGroupMapper.updPowerHasGroup(powerHasGroup);
    }

    /**
    * @Title: getPowerHasGroupByPage
    * @Description: 分页查询
    * @param powerHasGroupVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<PowerHasGroup> getPowerHasGroupByPage(PowerHasGroupVO powerHasGroupVO) throws Exception{
        powerHasGroupVO.setTotalPage(powerHasGroupMapper.getPowerHasGroupCount(powerHasGroupVO));
        return powerHasGroupMapper.getPowerHasGroupByPage(powerHasGroupVO);
    }

    /**
    * @Title: getPowerHasGroupCount
    * @Description: 获取记录数量
    * @param powerHasGroupVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getPowerHasGroupCount(PowerHasGroupVO powerHasGroupVO) throws Exception{
        return powerHasGroupMapper.getPowerHasGroupCount(powerHasGroupVO);
    }

    /**
    * @Title: getPowerHasGroup
    * @Description: 根据查询条件查询
    * @param powerHasGroupVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public PowerHasGroup getPowerHasGroup(PowerHasGroupVO powerHasGroupVO) throws Exception{
        return powerHasGroupMapper.getPowerHasGroup(powerHasGroupVO);
    }

}
