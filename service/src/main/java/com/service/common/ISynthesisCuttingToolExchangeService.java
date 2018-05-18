package com.service.common;

import com.common.pojo.SynthesisCuttingToolExchange;
import com.common.vo.SynthesisCuttingToolExchangeVO;

import java.util.List;


/**
*
* @ClassName ISynthesisCuttingToolExchangeService
* @Description SynthesisCuttingToolExchange业务接口
* @author Jivoin
*/
public interface ISynthesisCuttingToolExchangeService {

    /**
    * @Title: addSynthesisCuttingToolExchange
    * @Description: 新增SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchange
    * @throws Exception
    * @return: void
    */
    public void addSynthesisCuttingToolExchange(SynthesisCuttingToolExchange synthesisCuttingToolExchange) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolExchange
    * @Description: 删除SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchange
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolExchange(SynthesisCuttingToolExchange synthesisCuttingToolExchange) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolExchangeForLogic
    * @Description: 逻辑删除SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchange
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolExchangeForLogic(SynthesisCuttingToolExchange synthesisCuttingToolExchange) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolExchangeByVo
    * @Description: 根据条件删除SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchangeVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolExchangeByVo(SynthesisCuttingToolExchangeVO synthesisCuttingToolExchangeVO) throws Exception;

    /**
    * @Title: updSynthesisCuttingToolExchange
    * @Description: 动态更新SynthesisCuttingToolExchange
    * @param synthesisCuttingToolExchange
    * @throws Exception
    * @return: void
    */
    public void updSynthesisCuttingToolExchange(SynthesisCuttingToolExchange synthesisCuttingToolExchange) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolExchangeByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolExchangeVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SynthesisCuttingToolExchange> getSynthesisCuttingToolExchangeByPage(SynthesisCuttingToolExchangeVO synthesisCuttingToolExchangeVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolExchangeCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolExchangeVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolExchangeCount(SynthesisCuttingToolExchangeVO synthesisCuttingToolExchangeVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolExchange
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolExchangeVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolExchange getSynthesisCuttingToolExchange(SynthesisCuttingToolExchangeVO synthesisCuttingToolExchangeVO) throws Exception;

}
