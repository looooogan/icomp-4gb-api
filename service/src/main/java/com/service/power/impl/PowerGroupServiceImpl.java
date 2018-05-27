package com.service.power.impl;


import com.common.mapper.IPowerGroupMapper;
import com.common.pojo.PowerGroup;
import com.common.vo.PowerGroupVO;
import com.service.power.IPowerGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName PowerGroupServiceImpl
* @Description PowerGroup业务实现类
* @author Jivoin
*/
@Service("powerGroupService")
public class PowerGroupServiceImpl implements IPowerGroupService{

    @Autowired
    private IPowerGroupMapper powerGroupMapper;



    /**
    * @Title: addPowerGroup
    * @Description: 新增PowerGroup
    * @param powerGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void addPowerGroup(PowerGroup powerGroup) throws Exception{
        powerGroupMapper.addPowerGroup(powerGroup);
    }

    /**
    * @Title: delPowerGroup
    * @Description: 删除PowerGroup
    * @param powerGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerGroup(PowerGroup powerGroup) throws Exception{
        powerGroupMapper.delPowerGroup(powerGroup);
    }

    /**
    * @Title: delPowerGroupForLogic
    * @Description: 逻辑删除PowerGroup
    * @param powerGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerGroupForLogic(PowerGroup powerGroup) throws Exception{
        powerGroupMapper.delPowerGroupForLogic(powerGroup);
    }

    /**
    * @Title: delPowerGroupByVo
    * @Description: 根据条件删除PowerGroup
    * @param powerGroupVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerGroupByVo(PowerGroupVO powerGroupVO) throws Exception{
        powerGroupMapper.delPowerGroupByVo(powerGroupVO);
    }

    /**
    * @Title: updPowerGroup
    * @Description: 动态更新PowerGroup
    * @param powerGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void updPowerGroup(PowerGroup powerGroup) throws Exception{
        powerGroupMapper.updPowerGroup(powerGroup);
    }

    /**
    * @Title: getPowerGroupByPage
    * @Description: 分页查询
    * @param powerGroupVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<PowerGroup> getPowerGroupByPage(PowerGroupVO powerGroupVO) throws Exception{
        powerGroupVO.setTotalPage(powerGroupMapper.getPowerGroupCount(powerGroupVO));
        return powerGroupMapper.getPowerGroupByPage(powerGroupVO);
    }

    /**
    * @Title: getPowerGroupCount
    * @Description: 获取记录数量
    * @param powerGroupVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getPowerGroupCount(PowerGroupVO powerGroupVO) throws Exception{
        return powerGroupMapper.getPowerGroupCount(powerGroupVO);
    }

    /**
    * @Title: getPowerGroup
    * @Description: 根据查询条件查询
    * @param powerGroupVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public PowerGroup getPowerGroup(PowerGroupVO powerGroupVO) throws Exception{
        return powerGroupMapper.getPowerGroup(powerGroupVO);
    }

}
