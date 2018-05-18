package com.service.common;

import com.common.pojo.SynthesisCuttingToolType;
import com.common.vo.SynthesisCuttingToolTypeVO;

import java.util.List;


/**
*
* @ClassName ISynthesisCuttingToolTypeService
* @Description SynthesisCuttingToolType业务接口
* @author Jivoin
*/
public interface ISynthesisCuttingToolTypeService {

    /**
    * @Title: addSynthesisCuttingToolType
    * @Description: 新增SynthesisCuttingToolType
    * @param synthesisCuttingToolType
    * @throws Exception
    * @return: void
    */
    public void addSynthesisCuttingToolType(SynthesisCuttingToolType synthesisCuttingToolType) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolType
    * @Description: 删除SynthesisCuttingToolType
    * @param synthesisCuttingToolType
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolType(SynthesisCuttingToolType synthesisCuttingToolType) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolTypeForLogic
    * @Description: 逻辑删除SynthesisCuttingToolType
    * @param synthesisCuttingToolType
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolTypeForLogic(SynthesisCuttingToolType synthesisCuttingToolType) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolTypeByVo
    * @Description: 根据条件删除SynthesisCuttingToolType
    * @param synthesisCuttingToolTypeVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolTypeByVo(SynthesisCuttingToolTypeVO synthesisCuttingToolTypeVO) throws Exception;

    /**
    * @Title: updSynthesisCuttingToolType
    * @Description: 动态更新SynthesisCuttingToolType
    * @param synthesisCuttingToolType
    * @throws Exception
    * @return: void
    */
    public void updSynthesisCuttingToolType(SynthesisCuttingToolType synthesisCuttingToolType) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolTypeByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolTypeVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SynthesisCuttingToolType> getSynthesisCuttingToolTypeByPage(SynthesisCuttingToolTypeVO synthesisCuttingToolTypeVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolTypeCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolTypeVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolTypeCount(SynthesisCuttingToolTypeVO synthesisCuttingToolTypeVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolType
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolTypeVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolType getSynthesisCuttingToolType(SynthesisCuttingToolTypeVO synthesisCuttingToolTypeVO) throws Exception;

}
