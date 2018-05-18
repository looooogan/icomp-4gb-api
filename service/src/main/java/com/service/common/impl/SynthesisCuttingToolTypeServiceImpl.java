package com.service.common.impl;


import com.common.mapper.ISynthesisCuttingToolTypeMapper;
import com.common.pojo.SynthesisCuttingToolType;
import com.common.vo.SynthesisCuttingToolTypeVO;
import com.service.common.ISynthesisCuttingToolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SynthesisCuttingToolTypeServiceImpl
* @Description SynthesisCuttingToolType业务实现类
* @author Jivoin
*/
@Service("synthesisCuttingToolTypeService")
public class SynthesisCuttingToolTypeServiceImpl implements ISynthesisCuttingToolTypeService{

    @Autowired
    private ISynthesisCuttingToolTypeMapper synthesisCuttingToolTypeMapper;



    /**
    * @Title: addSynthesisCuttingToolType
    * @Description: 新增SynthesisCuttingToolType
    * @param synthesisCuttingToolType
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSynthesisCuttingToolType(SynthesisCuttingToolType synthesisCuttingToolType) throws Exception{
        synthesisCuttingToolTypeMapper.addSynthesisCuttingToolType(synthesisCuttingToolType);
    }

    /**
    * @Title: delSynthesisCuttingToolType
    * @Description: 删除SynthesisCuttingToolType
    * @param synthesisCuttingToolType
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolType(SynthesisCuttingToolType synthesisCuttingToolType) throws Exception{
        synthesisCuttingToolTypeMapper.delSynthesisCuttingToolType(synthesisCuttingToolType);
    }

    /**
    * @Title: delSynthesisCuttingToolTypeForLogic
    * @Description: 逻辑删除SynthesisCuttingToolType
    * @param synthesisCuttingToolType
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolTypeForLogic(SynthesisCuttingToolType synthesisCuttingToolType) throws Exception{
        synthesisCuttingToolTypeMapper.delSynthesisCuttingToolTypeForLogic(synthesisCuttingToolType);
    }

    /**
    * @Title: delSynthesisCuttingToolTypeByVo
    * @Description: 根据条件删除SynthesisCuttingToolType
    * @param synthesisCuttingToolTypeVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolTypeByVo(SynthesisCuttingToolTypeVO synthesisCuttingToolTypeVO) throws Exception{
        synthesisCuttingToolTypeMapper.delSynthesisCuttingToolTypeByVo(synthesisCuttingToolTypeVO);
    }

    /**
    * @Title: updSynthesisCuttingToolType
    * @Description: 动态更新SynthesisCuttingToolType
    * @param synthesisCuttingToolType
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSynthesisCuttingToolType(SynthesisCuttingToolType synthesisCuttingToolType) throws Exception{
        synthesisCuttingToolTypeMapper.updSynthesisCuttingToolType(synthesisCuttingToolType);
    }

    /**
    * @Title: getSynthesisCuttingToolTypeByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolTypeVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SynthesisCuttingToolType> getSynthesisCuttingToolTypeByPage(SynthesisCuttingToolTypeVO synthesisCuttingToolTypeVO) throws Exception{
        synthesisCuttingToolTypeVO.setTotalPage(synthesisCuttingToolTypeMapper.getSynthesisCuttingToolTypeCount(synthesisCuttingToolTypeVO));
        return synthesisCuttingToolTypeMapper.getSynthesisCuttingToolTypeByPage(synthesisCuttingToolTypeVO);
    }

    /**
    * @Title: getSynthesisCuttingToolTypeCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolTypeVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolTypeCount(SynthesisCuttingToolTypeVO synthesisCuttingToolTypeVO) throws Exception{
        return synthesisCuttingToolTypeMapper.getSynthesisCuttingToolTypeCount(synthesisCuttingToolTypeVO);
    }

    /**
    * @Title: getSynthesisCuttingToolType
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolTypeVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolType getSynthesisCuttingToolType(SynthesisCuttingToolTypeVO synthesisCuttingToolTypeVO) throws Exception{
        return synthesisCuttingToolTypeMapper.getSynthesisCuttingToolType(synthesisCuttingToolTypeVO);
    }

}
