package com.service.common.impl;


import com.common.mapper.ISynthesisCuttingToolAdjustMapper;
import com.common.pojo.SynthesisCuttingToolAdjust;
import com.common.vo.SynthesisCuttingToolAdjustVO;
import com.service.common.ISynthesisCuttingToolAdjustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SynthesisCuttingToolAdjustServiceImpl
* @Description SynthesisCuttingToolAdjust业务实现类
* @author Jivoin
*/
@Service("synthesisCuttingToolAdjustService")
public class SynthesisCuttingToolAdjustServiceImpl implements ISynthesisCuttingToolAdjustService{

    @Autowired
    private ISynthesisCuttingToolAdjustMapper synthesisCuttingToolAdjustMapper;



    /**
    * @Title: addSynthesisCuttingToolAdjust
    * @Description: 新增SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjust
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSynthesisCuttingToolAdjust(SynthesisCuttingToolAdjust synthesisCuttingToolAdjust) throws Exception{
        synthesisCuttingToolAdjustMapper.addSynthesisCuttingToolAdjust(synthesisCuttingToolAdjust);
    }

    /**
    * @Title: delSynthesisCuttingToolAdjust
    * @Description: 删除SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjust
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolAdjust(SynthesisCuttingToolAdjust synthesisCuttingToolAdjust) throws Exception{
        synthesisCuttingToolAdjustMapper.delSynthesisCuttingToolAdjust(synthesisCuttingToolAdjust);
    }

    /**
    * @Title: delSynthesisCuttingToolAdjustForLogic
    * @Description: 逻辑删除SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjust
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolAdjustForLogic(SynthesisCuttingToolAdjust synthesisCuttingToolAdjust) throws Exception{
        synthesisCuttingToolAdjustMapper.delSynthesisCuttingToolAdjustForLogic(synthesisCuttingToolAdjust);
    }

    /**
    * @Title: delSynthesisCuttingToolAdjustByVo
    * @Description: 根据条件删除SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjustVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolAdjustByVo(SynthesisCuttingToolAdjustVO synthesisCuttingToolAdjustVO) throws Exception{
        synthesisCuttingToolAdjustMapper.delSynthesisCuttingToolAdjustByVo(synthesisCuttingToolAdjustVO);
    }

    /**
    * @Title: updSynthesisCuttingToolAdjust
    * @Description: 动态更新SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjust
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSynthesisCuttingToolAdjust(SynthesisCuttingToolAdjust synthesisCuttingToolAdjust) throws Exception{
        synthesisCuttingToolAdjustMapper.updSynthesisCuttingToolAdjust(synthesisCuttingToolAdjust);
    }

    /**
    * @Title: getSynthesisCuttingToolAdjustByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolAdjustVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SynthesisCuttingToolAdjust> getSynthesisCuttingToolAdjustByPage(SynthesisCuttingToolAdjustVO synthesisCuttingToolAdjustVO) throws Exception{
        synthesisCuttingToolAdjustVO.setTotalPage(synthesisCuttingToolAdjustMapper.getSynthesisCuttingToolAdjustCount(synthesisCuttingToolAdjustVO));
        return synthesisCuttingToolAdjustMapper.getSynthesisCuttingToolAdjustByPage(synthesisCuttingToolAdjustVO);
    }

    /**
    * @Title: getSynthesisCuttingToolAdjustCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolAdjustVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolAdjustCount(SynthesisCuttingToolAdjustVO synthesisCuttingToolAdjustVO) throws Exception{
        return synthesisCuttingToolAdjustMapper.getSynthesisCuttingToolAdjustCount(synthesisCuttingToolAdjustVO);
    }

    /**
    * @Title: getSynthesisCuttingToolAdjust
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolAdjustVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolAdjust getSynthesisCuttingToolAdjust(SynthesisCuttingToolAdjustVO synthesisCuttingToolAdjustVO) throws Exception{
        return synthesisCuttingToolAdjustMapper.getSynthesisCuttingToolAdjust(synthesisCuttingToolAdjustVO);
    }

}
