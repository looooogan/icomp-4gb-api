package com.service.common.impl;


import com.common.mapper.ISynthesisCuttingToolExchangeMapper;
import com.common.pojo.SynthesisCuttingToolExchange;
import com.common.vo.SynthesisCuttingToolExchangeVO;
import com.service.common.ISynthesisCuttingToolExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SynthesisCuttingToolExchangeServiceImpl
* @Description SynthesisCuttingToolExchange业务实现类
* @author Jivoin
*/
@Service("synthesisCuttingToolExchangeService")
public class SynthesisCuttingToolExchangeServiceImpl implements ISynthesisCuttingToolExchangeService{

    @Autowired
    private ISynthesisCuttingToolExchangeMapper synthesisCuttingToolExchangeMapper;



    /**
    * @Title: addSynthesisCuttingToolExchange
    * @Description: 新增SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchange
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSynthesisCuttingToolExchange(SynthesisCuttingToolExchange synthesisCuttingToolExchange) throws Exception{
        synthesisCuttingToolExchangeMapper.addSynthesisCuttingToolExchange(synthesisCuttingToolExchange);
    }

    /**
    * @Title: delSynthesisCuttingToolExchange
    * @Description: 删除SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchange
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolExchange(SynthesisCuttingToolExchange synthesisCuttingToolExchange) throws Exception{
        synthesisCuttingToolExchangeMapper.delSynthesisCuttingToolExchange(synthesisCuttingToolExchange);
    }

    /**
    * @Title: delSynthesisCuttingToolExchangeForLogic
    * @Description: 逻辑删除SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchange
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolExchangeForLogic(SynthesisCuttingToolExchange synthesisCuttingToolExchange) throws Exception{
        synthesisCuttingToolExchangeMapper.delSynthesisCuttingToolExchangeForLogic(synthesisCuttingToolExchange);
    }

    /**
    * @Title: delSynthesisCuttingToolExchangeByVo
    * @Description: 根据条件删除SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchangeVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolExchangeByVo(SynthesisCuttingToolExchangeVO synthesisCuttingToolExchangeVO) throws Exception{
        synthesisCuttingToolExchangeMapper.delSynthesisCuttingToolExchangeByVo(synthesisCuttingToolExchangeVO);
    }

    /**
    * @Title: updSynthesisCuttingToolExchange
    * @Description: 动态更新SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchange
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSynthesisCuttingToolExchange(SynthesisCuttingToolExchange synthesisCuttingToolExchange) throws Exception{
        synthesisCuttingToolExchangeMapper.updSynthesisCuttingToolExchange(synthesisCuttingToolExchange);
    }

    /**
    * @Title: getSynthesisCuttingToolExchangeByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolExchangeVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SynthesisCuttingToolExchange> getSynthesisCuttingToolExchangeByPage(SynthesisCuttingToolExchangeVO synthesisCuttingToolExchangeVO) throws Exception{
        synthesisCuttingToolExchangeVO.setTotalPage(synthesisCuttingToolExchangeMapper.getSynthesisCuttingToolExchangeCount(synthesisCuttingToolExchangeVO));
        return synthesisCuttingToolExchangeMapper.getSynthesisCuttingToolExchangeByPage(synthesisCuttingToolExchangeVO);
    }

    /**
    * @Title: getSynthesisCuttingToolExchangeCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolExchangeVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolExchangeCount(SynthesisCuttingToolExchangeVO synthesisCuttingToolExchangeVO) throws Exception{
        return synthesisCuttingToolExchangeMapper.getSynthesisCuttingToolExchangeCount(synthesisCuttingToolExchangeVO);
    }

    /**
    * @Title: getSynthesisCuttingToolExchange
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolExchangeVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolExchange getSynthesisCuttingToolExchange(SynthesisCuttingToolExchangeVO synthesisCuttingToolExchangeVO) throws Exception{
        return synthesisCuttingToolExchangeMapper.getSynthesisCuttingToolExchange(synthesisCuttingToolExchangeVO);
    }

}
