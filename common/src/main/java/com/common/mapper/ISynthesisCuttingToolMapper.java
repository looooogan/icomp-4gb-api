package com.common.mapper;

import com.common.pojo.SynthesisCuttingTool;
import com.common.vo.SynthesisCuttingToolVO;

import java.util.List;


/**
*
* @ClassName ISynthesisCuttingToolMapper
* @Description TODO
* @author Jivoin
*/
public interface ISynthesisCuttingToolMapper {

    /**
    * @Title: addSynthesisCuttingTool
    * @Description: 新增SynthesisCuttingTool
    * @param synthesisCuttingTool
    * @throws Exception
    * @return: void
    */
    public void addSynthesisCuttingTool(SynthesisCuttingTool synthesisCuttingTool) throws Exception;

    /**
    * @Title: delSynthesisCuttingTool
    * @Description: 删除SynthesisCuttingTool
    * @param synthesisCuttingTool
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingTool(SynthesisCuttingTool synthesisCuttingTool) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolForLogic
    * @Description: 逻辑删除SynthesisCuttingTool
    * @param synthesisCuttingTool
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolForLogic(SynthesisCuttingTool synthesisCuttingTool) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolByVo
    * @Description: 根据条件删除SynthesisCuttingTool
    * @param synthesisCuttingToolVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolByVo(SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception;

    /**
    * @Title: updSynthesisCuttingTool
    * @Description: 动态更新SynthesisCuttingTool
    * @param synthesisCuttingTool
    * @throws Exception
    * @return: void
    */
    public void updSynthesisCuttingTool(SynthesisCuttingTool synthesisCuttingTool) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SynthesisCuttingTool> getSynthesisCuttingToolByPage(SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolCount(SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingTool
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingTool getSynthesisCuttingTool(SynthesisCuttingToolVO synthesisCuttingToolVO) throws Exception;

}
