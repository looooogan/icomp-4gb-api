package com.service.common.impl;


import com.common.mapper.ISynthesisBladeCodeMapper;
import com.common.mapper.ISynthesisCuttingToolMapper;
import com.common.pojo.SynthesisBladeCode;
import com.common.vo.SynthesisBladeCodeVO;
import com.service.common.ISynthesisBladeCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SynthesisBladeCodeServiceImpl
* @Description SynthesisBladeCode业务实现类
* @author Jivoin
*/
@Service("synthesisBladeCodeService")
public class SynthesisBladeCodeServiceImpl implements ISynthesisBladeCodeService{

    @Autowired
    private ISynthesisBladeCodeMapper synthesisBladeCodeMapper;

    @Autowired
    private ISynthesisCuttingToolMapper synthesisCuttingToolMapper;


    /**
    * @Title: addSynthesisBladeCode
    * @Description: 新增SynthesisBladeCode
    * @param synthesisBladeCode
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSynthesisBladeCode(SynthesisBladeCode synthesisBladeCode) throws Exception{
        synthesisBladeCodeMapper.addSynthesisBladeCode(synthesisBladeCode);
    }

    /**
    * @Title: delSynthesisBladeCode
    * @Description: 删除SynthesisBladeCode
    * @param synthesisBladeCode
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisBladeCode(SynthesisBladeCode synthesisBladeCode) throws Exception{
        synthesisBladeCodeMapper.delSynthesisBladeCode(synthesisBladeCode);
    }

    /**
    * @Title: delSynthesisBladeCodeForLogic
    * @Description: 逻辑删除SynthesisBladeCode
    * @param synthesisBladeCode
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisBladeCodeForLogic(SynthesisBladeCode synthesisBladeCode) throws Exception{
        synthesisBladeCodeMapper.delSynthesisBladeCodeForLogic(synthesisBladeCode);
    }

    /**
    * @Title: delSynthesisBladeCodeByVo
    * @Description: 根据条件删除SynthesisBladeCode
    * @param synthesisBladeCodeVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisBladeCodeByVo(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception{
        synthesisBladeCodeMapper.delSynthesisBladeCodeByVo(synthesisBladeCodeVO);
    }

    /**
    * @Title: updSynthesisBladeCode
    * @Description: 动态更新SynthesisBladeCode
    * @param synthesisBladeCode
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSynthesisBladeCode(SynthesisBladeCode synthesisBladeCode) throws Exception{
        synthesisBladeCodeMapper.updSynthesisBladeCode(synthesisBladeCode);
    }

    /**
    * @Title: getSynthesisBladeCodeByPage
    * @Description: 分页查询
    * @param synthesisBladeCodeVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SynthesisBladeCode> getSynthesisBladeCodeByPage(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception{
        synthesisBladeCodeVO.setTotalPage(synthesisBladeCodeMapper.getSynthesisBladeCodeCount(synthesisBladeCodeVO));
        return synthesisBladeCodeMapper.getSynthesisBladeCodeByPage(synthesisBladeCodeVO);
    }

    /**
    * @Title: getSynthesisBladeCodeCount
    * @Description: 获取记录数量
    * @param synthesisBladeCodeVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisBladeCodeCount(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception{
        return synthesisBladeCodeMapper.getSynthesisBladeCodeCount(synthesisBladeCodeVO);
    }

    /**
    * @Title: getSynthesisBladeCode
    * @Description: 根据查询条件查询
    * @param synthesisBladeCodeVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisBladeCode getSynthesisBladeCode(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception{
        return synthesisBladeCodeMapper.getSynthesisBladeCode(synthesisBladeCodeVO);
    }

}
