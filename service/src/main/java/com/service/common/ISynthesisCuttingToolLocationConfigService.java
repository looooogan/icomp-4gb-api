package com.service.common;

import com.common.pojo.SynthesisCuttingToolLocationConfig;
import com.common.vo.SynthesisCuttingToolLocationConfigVO;

import java.util.List;


/**
*
* @ClassName ISynthesisCuttingToolLocationConfigService
* @Description SynthesisCuttingToolLocationConfig业务接口
* @author Jivoin
*/
public interface ISynthesisCuttingToolLocationConfigService {

    /**
    * @Title: addSynthesisCuttingToolLocationConfig
    * @Description: 新增SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfig
    * @throws Exception
    * @return: void
    */
    public void addSynthesisCuttingToolLocationConfig(SynthesisCuttingToolLocationConfig synthesisCuttingToolLocationConfig) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolLocationConfig
    * @Description: 删除SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfig
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolLocationConfig(SynthesisCuttingToolLocationConfig synthesisCuttingToolLocationConfig) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolLocationConfigForLogic
    * @Description: 逻辑删除SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfig
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolLocationConfigForLogic(SynthesisCuttingToolLocationConfig synthesisCuttingToolLocationConfig) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolLocationConfigByVo
    * @Description: 根据条件删除SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfigVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolLocationConfigByVo(SynthesisCuttingToolLocationConfigVO synthesisCuttingToolLocationConfigVO) throws Exception;

    /**
    * @Title: updSynthesisCuttingToolLocationConfig
    * @Description: 动态更新SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfig
    * @throws Exception
    * @return: void
    */
    public void updSynthesisCuttingToolLocationConfig(SynthesisCuttingToolLocationConfig synthesisCuttingToolLocationConfig) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolLocationConfigByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolLocationConfigVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SynthesisCuttingToolLocationConfig> getSynthesisCuttingToolLocationConfigByPage(SynthesisCuttingToolLocationConfigVO synthesisCuttingToolLocationConfigVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolLocationConfigCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolLocationConfigVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolLocationConfigCount(SynthesisCuttingToolLocationConfigVO synthesisCuttingToolLocationConfigVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolLocationConfig
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolLocationConfigVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolLocationConfig getSynthesisCuttingToolLocationConfig(SynthesisCuttingToolLocationConfigVO synthesisCuttingToolLocationConfigVO) throws Exception;

}
