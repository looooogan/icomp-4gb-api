package com.service.common.impl;


import com.common.mapper.IOptionWarningMapper;
import com.common.pojo.OptionWarning;
import com.common.vo.OptionWarningVO;
import com.service.common.IOptionWarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName OptionWarningServiceImpl
* @Description OptionWarning业务实现类
* @author Jivoin
*/
@Service("optionWarningService")
public class OptionWarningServiceImpl implements IOptionWarningService{

    @Autowired
    private IOptionWarningMapper optionWarningMapper;



    /**
    * @Title: addOptionWarning
    * @Description: 新增OptionWarning
    * @param optionWarning
    * @throws Exception
    * @return: void
    */
    @Override
    public void addOptionWarning(OptionWarning optionWarning) throws Exception{
        optionWarningMapper.addOptionWarning(optionWarning);
    }

    /**
    * @Title: delOptionWarning
    * @Description: 删除OptionWarning
    * @param optionWarning
    * @throws Exception
    * @return: void
    */
    @Override
    public void delOptionWarning(OptionWarning optionWarning) throws Exception{
        optionWarningMapper.delOptionWarning(optionWarning);
    }

    /**
    * @Title: delOptionWarningForLogic
    * @Description: 逻辑删除OptionWarning
    * @param optionWarning
    * @throws Exception
    * @return: void
    */
    @Override
    public void delOptionWarningForLogic(OptionWarning optionWarning) throws Exception{
        optionWarningMapper.delOptionWarningForLogic(optionWarning);
    }

    /**
    * @Title: delOptionWarningByVo
    * @Description: 根据条件删除OptionWarning
    * @param optionWarningVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delOptionWarningByVo(OptionWarningVO optionWarningVO) throws Exception{
        optionWarningMapper.delOptionWarningByVo(optionWarningVO);
    }

    /**
    * @Title: updOptionWarning
    * @Description: 动态更新OptionWarning
    * @param optionWarning
    * @throws Exception
    * @return: void
    */
    @Override
    public void updOptionWarning(OptionWarning optionWarning) throws Exception{
        optionWarningMapper.updOptionWarning(optionWarning);
    }

    /**
    * @Title: getOptionWarningByPage
    * @Description: 分页查询
    * @param optionWarningVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<OptionWarning> getOptionWarningByPage(OptionWarningVO optionWarningVO) throws Exception{
        optionWarningVO.setTotalPage(optionWarningMapper.getOptionWarningCount(optionWarningVO));
        return optionWarningMapper.getOptionWarningByPage(optionWarningVO);
    }

    /**
    * @Title: getOptionWarningCount
    * @Description: 获取记录数量
    * @param optionWarningVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getOptionWarningCount(OptionWarningVO optionWarningVO) throws Exception{
        return optionWarningMapper.getOptionWarningCount(optionWarningVO);
    }

    /**
    * @Title: getOptionWarning
    * @Description: 根据查询条件查询
    * @param optionWarningVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public OptionWarning getOptionWarning(OptionWarningVO optionWarningVO) throws Exception{
        return optionWarningMapper.getOptionWarning(optionWarningVO);
    }

}
