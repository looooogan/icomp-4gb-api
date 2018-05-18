package com.service.common.impl;


import com.common.mapper.IWarningSettingMapper;
import com.common.pojo.WarningSetting;
import com.common.vo.WarningSettingVO;
import com.service.common.IWarningSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName WarningSettingServiceImpl
* @Description WarningSetting业务实现类
* @author Jivoin
*/
@Service("warningSettingService")
public class WarningSettingServiceImpl implements IWarningSettingService{

    @Autowired
    private IWarningSettingMapper warningSettingMapper;



    /**
    * @Title: addWarningSetting
    * @Description: 新增WarningSetting
    * @param warningSetting
    * @throws Exception
    * @return: void
    */
    @Override
    public void addWarningSetting(WarningSetting warningSetting) throws Exception{
        warningSettingMapper.addWarningSetting(warningSetting);
    }

    /**
    * @Title: delWarningSetting
    * @Description: 删除WarningSetting
    * @param warningSetting
    * @throws Exception
    * @return: void
    */
    @Override
    public void delWarningSetting(WarningSetting warningSetting) throws Exception{
        warningSettingMapper.delWarningSetting(warningSetting);
    }

    /**
    * @Title: delWarningSettingForLogic
    * @Description: 逻辑删除WarningSetting
    * @param warningSetting
    * @throws Exception
    * @return: void
    */
    @Override
    public void delWarningSettingForLogic(WarningSetting warningSetting) throws Exception{
        warningSettingMapper.delWarningSettingForLogic(warningSetting);
    }

    /**
    * @Title: delWarningSettingByVo
    * @Description: 根据条件删除WarningSetting
    * @param warningSettingVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delWarningSettingByVo(WarningSettingVO warningSettingVO) throws Exception{
        warningSettingMapper.delWarningSettingByVo(warningSettingVO);
    }

    /**
    * @Title: updWarningSetting
    * @Description: 动态更新WarningSetting
    * @param warningSetting
    * @throws Exception
    * @return: void
    */
    @Override
    public void updWarningSetting(WarningSetting warningSetting) throws Exception{
        warningSettingMapper.updWarningSetting(warningSetting);
    }

    /**
    * @Title: getWarningSettingByPage
    * @Description: 分页查询
    * @param warningSettingVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<WarningSetting> getWarningSettingByPage(WarningSettingVO warningSettingVO) throws Exception{
        warningSettingVO.setTotalPage(warningSettingMapper.getWarningSettingCount(warningSettingVO));
        return warningSettingMapper.getWarningSettingByPage(warningSettingVO);
    }

    /**
    * @Title: getWarningSettingCount
    * @Description: 获取记录数量
    * @param warningSettingVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getWarningSettingCount(WarningSettingVO warningSettingVO) throws Exception{
        return warningSettingMapper.getWarningSettingCount(warningSettingVO);
    }

    /**
    * @Title: getWarningSetting
    * @Description: 根据查询条件查询
    * @param warningSettingVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public WarningSetting getWarningSetting(WarningSettingVO warningSettingVO) throws Exception{
        return warningSettingMapper.getWarningSetting(warningSettingVO);
    }

}
