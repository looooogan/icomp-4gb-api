package com.service.common.impl;


import com.common.mapper.ISynthesisCuttingToolMapper;
import com.common.mapper.ISynthesisCuttingToolTypeMapper;
import com.common.pojo.SynthesisCuttingTool;
import com.common.vo.SynthesisCuttingToolVO;
import com.service.common.ISynthesisCuttingToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SynthesisCuttingToolServiceImpl
* @Description SynthesisCuttingTool业务实现类
* @author Jivoin
*/
@Service("synthesisCuttingToolService")
public class SynthesisCuttingToolServiceImpl implements ISynthesisCuttingToolService{

    @Autowired
    private ISynthesisCuttingToolMapper synthesisCuttingToolMapper;

    @Autowired
    private ISynthesisCuttingToolTypeMapper synthesisCuttingToolTypeMapper;


    /**
    * @Title: addSynthesisCuttingTool
    * @Description: 新增SynthesisCuttingTool
    * @param synthesisCuttingTool
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSynthesisCuttingTool(SynthesisCuttingTool synthesisCuttingTool) throws Exception{
        synthesisCuttingToolMapper.addSynthesisCuttingTool(synthesisCuttingTool);
    }

    /**
    * @Title: delSynthesisCuttingTool
    * @Description: 删除SynthesisCuttingTool
    * @param synthesisCuttingTool
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingTool(SynthesisCuttingTool synthesisCuttingTool) throws Exception{
        synthesisCuttingToolMapper.delSynthesisCuttingTool(synthesisCuttingTool);
    }

    /**
    * @Title: delSynthesisCuttingToolForLogic
    * @Description: 逻辑删除SynthesisCuttingTool
    * @param synthesisCuttingTool
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolForLogic(SynthesisCuttingTool synthesisCuttingTool) throws Exception{
        synthesisCuttingToolMapper.delSynthesisCuttingToolForLogic(synthesisCuttingTool);
    }

    /**
    * @Title: delSynthesisCuttingToolByVo
    * @Description: 根据条件删除SynthesisCuttingTool
    * @param synthesisCuttingToolVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolByVo(SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception{
        synthesisCuttingToolMapper.delSynthesisCuttingToolByVo(synthesisCuttingToolVO);
    }

    /**
    * @Title: updSynthesisCuttingTool
    * @Description: 动态更新SynthesisCuttingTool
    * @param synthesisCuttingTool
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSynthesisCuttingTool(SynthesisCuttingTool synthesisCuttingTool) throws Exception{
        synthesisCuttingToolMapper.updSynthesisCuttingTool(synthesisCuttingTool);
    }

    /**
    * @Title: getSynthesisCuttingToolByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SynthesisCuttingTool> getSynthesisCuttingToolByPage(SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception{
        synthesisCuttingToolVO.setTotalPage(synthesisCuttingToolMapper.getSynthesisCuttingToolCount(synthesisCuttingToolVO));
        return synthesisCuttingToolMapper.getSynthesisCuttingToolByPage(synthesisCuttingToolVO);
    }

    /**
    * @Title: getSynthesisCuttingToolCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolCount(SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception{
        return synthesisCuttingToolMapper.getSynthesisCuttingToolCount(synthesisCuttingToolVO);
    }

    /**
    * @Title: getSynthesisCuttingTool
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingTool getSynthesisCuttingTool(SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception{
        return synthesisCuttingToolMapper.getSynthesisCuttingTool(synthesisCuttingToolVO);
    }

}
