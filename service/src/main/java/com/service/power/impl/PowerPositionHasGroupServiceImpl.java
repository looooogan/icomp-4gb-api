package com.service.power.impl;


import com.common.mapper.IAuthPositionMapper;
import com.common.mapper.IPowerGroupMapper;
import com.common.mapper.IPowerPositionHasGroupMapper;
import com.common.pojo.PowerPositionHasGroup;
import com.common.vo.PowerPositionHasGroupVO;
import com.service.power.IPowerPositionHasGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName PowerPositionHasGroupServiceImpl
* @Description PowerPositionHasGroup业务实现类
* @author Jivoin
*/
@Service("powerPositionHasGroupService")
public class PowerPositionHasGroupServiceImpl implements IPowerPositionHasGroupService{

    @Autowired
    private IPowerPositionHasGroupMapper powerPositionHasGroupMapper;

    @Autowired
    private IAuthPositionMapper authPositionMapper;
    @Autowired
    private IPowerGroupMapper powerGroupMapper;


    /**
    * @Title: addPowerPositionHasGroup
    * @Description: 新增PowerPositionHasGroup
    * @param powerPositionHasGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void addPowerPositionHasGroup(PowerPositionHasGroup powerPositionHasGroup) throws Exception{
        powerPositionHasGroupMapper.addPowerPositionHasGroup(powerPositionHasGroup);
    }

    /**
    * @Title: delPowerPositionHasGroup
    * @Description: 删除PowerPositionHasGroup
    * @param powerPositionHasGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerPositionHasGroup(PowerPositionHasGroup powerPositionHasGroup) throws Exception{
        powerPositionHasGroupMapper.delPowerPositionHasGroup(powerPositionHasGroup);
    }

    /**
    * @Title: delPowerPositionHasGroupForLogic
    * @Description: 逻辑删除PowerPositionHasGroup
    * @param powerPositionHasGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerPositionHasGroupForLogic(PowerPositionHasGroup powerPositionHasGroup) throws Exception{
        powerPositionHasGroupMapper.delPowerPositionHasGroupForLogic(powerPositionHasGroup);
    }

    /**
    * @Title: delPowerPositionHasGroupByVo
    * @Description: 根据条件删除PowerPositionHasGroup
    * @param powerPositionHasGroupVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delPowerPositionHasGroupByVo(PowerPositionHasGroupVO powerPositionHasGroupVO) throws Exception{
        powerPositionHasGroupMapper.delPowerPositionHasGroupByVo(powerPositionHasGroupVO);
    }

    /**
    * @Title: updPowerPositionHasGroup
    * @Description: 动态更新PowerPositionHasGroup
    * @param powerPositionHasGroup
    * @throws Exception
    * @return: void
    */
    @Override
    public void updPowerPositionHasGroup(PowerPositionHasGroup powerPositionHasGroup) throws Exception{
        powerPositionHasGroupMapper.updPowerPositionHasGroup(powerPositionHasGroup);
    }

    /**
    * @Title: getPowerPositionHasGroupByPage
    * @Description: 分页查询
    * @param powerPositionHasGroupVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<PowerPositionHasGroup> getPowerPositionHasGroupByPage(PowerPositionHasGroupVO powerPositionHasGroupVO) throws Exception{
        powerPositionHasGroupVO.setTotalPage(powerPositionHasGroupMapper.getPowerPositionHasGroupCount(powerPositionHasGroupVO));
        return powerPositionHasGroupMapper.getPowerPositionHasGroupByPage(powerPositionHasGroupVO);
    }

    /**
    * @Title: getPowerPositionHasGroupCount
    * @Description: 获取记录数量
    * @param powerPositionHasGroupVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getPowerPositionHasGroupCount(PowerPositionHasGroupVO powerPositionHasGroupVO) throws Exception{
        return powerPositionHasGroupMapper.getPowerPositionHasGroupCount(powerPositionHasGroupVO);
    }

    /**
    * @Title: getPowerPositionHasGroup
    * @Description: 根据查询条件查询
    * @param powerPositionHasGroupVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public PowerPositionHasGroup getPowerPositionHasGroup(PowerPositionHasGroupVO powerPositionHasGroupVO) throws Exception{
        return powerPositionHasGroupMapper.getPowerPositionHasGroup(powerPositionHasGroupVO);
    }

}
