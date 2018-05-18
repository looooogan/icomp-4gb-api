package com.common.mapper;

import com.common.pojo.SynthesisCuttingToolAdjust;
import com.common.vo.SynthesisCuttingToolAdjustVO;

import java.util.List;


/**
*
* @ClassName ISynthesisCuttingToolAdjustMapper
* @Description TODO
* @author Jivoin
*/
public interface ISynthesisCuttingToolAdjustMapper {

    /**
    * @Title: addSynthesisCuttingToolAdjust
    * @Description: 新增SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjust
    * @throws Exception
    * @return: void
    */
    public void addSynthesisCuttingToolAdjust(SynthesisCuttingToolAdjust synthesisCuttingToolAdjust) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolAdjust
    * @Description: 删除SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjust
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolAdjust(SynthesisCuttingToolAdjust synthesisCuttingToolAdjust) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolAdjustForLogic
    * @Description: 逻辑删除SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjust
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolAdjustForLogic(SynthesisCuttingToolAdjust synthesisCuttingToolAdjust) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolAdjustByVo
    * @Description: 根据条件删除SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjustVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolAdjustByVo(SynthesisCuttingToolAdjustVO synthesisCuttingToolAdjustVO) throws Exception;

    /**
    * @Title: updSynthesisCuttingToolAdjust
    * @Description: 动态更新SynthesisCuttingToolAdjust
    * @param synthesisCuttingToolAdjust
    * @throws Exception
    * @return: void
    */
    public void updSynthesisCuttingToolAdjust(SynthesisCuttingToolAdjust synthesisCuttingToolAdjust) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolAdjustByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolAdjustVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SynthesisCuttingToolAdjust> getSynthesisCuttingToolAdjustByPage(SynthesisCuttingToolAdjustVO synthesisCuttingToolAdjustVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolAdjustCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolAdjustVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolAdjustCount(SynthesisCuttingToolAdjustVO synthesisCuttingToolAdjustVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolAdjust
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolAdjustVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolAdjust getSynthesisCuttingToolAdjust(SynthesisCuttingToolAdjustVO synthesisCuttingToolAdjustVO) throws Exception;

}
