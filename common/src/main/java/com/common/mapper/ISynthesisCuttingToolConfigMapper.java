package com.common.mapper;

import com.common.pojo.SynthesisCuttingToolConfig;
import com.common.vo.SynthesisCuttingToolConfigVO;

import java.util.List;


/**
*
* @ClassName ISynthesisCuttingToolConfigMapper
* @Description TODO
* @author Jivoin
*/
public interface ISynthesisCuttingToolConfigMapper {

    /**
    * @Title: addSynthesisCuttingToolConfig
    * @Description: 新增SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfig
    * @throws Exception
    * @return: Integer
    */
    public Integer addSynthesisCuttingToolConfig(SynthesisCuttingToolConfig synthesisCuttingToolConfig) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolConfig
    * @Description: 删除SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfig
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolConfig(SynthesisCuttingToolConfig synthesisCuttingToolConfig) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolConfigForLogic
    * @Description: 逻辑删除SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfig
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolConfigForLogic(SynthesisCuttingToolConfig synthesisCuttingToolConfig) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolConfigByVo
    * @Description: 根据条件删除SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfigVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolConfigByVo(SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO) throws Exception;

    /**
    * @Title: updSynthesisCuttingToolConfig
    * @Description: 动态更新SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfig
    * @throws Exception
    * @return: void
    */
    public void updSynthesisCuttingToolConfig(SynthesisCuttingToolConfig synthesisCuttingToolConfig) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolConfigByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolConfigVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SynthesisCuttingToolConfig> getSynthesisCuttingToolConfigByPage(SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolConfigCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolConfigVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolConfigCount(SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolConfig
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolConfigVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolConfig getSynthesisCuttingToolConfig(SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO) throws Exception;

}
