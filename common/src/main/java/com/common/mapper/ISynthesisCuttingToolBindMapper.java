package com.common.mapper;

import com.common.pojo.SynthesisCuttingToolBind;
import com.common.vo.SynthesisCuttingToolBindVO;

import java.util.List;


/**
*
* @ClassName ISynthesisCuttingToolBindMapper
* @Description TODO
* @author Jivoin
*/
public interface ISynthesisCuttingToolBindMapper {

    /**
    * @Title: addSynthesisCuttingToolBind
    * @Description: 新增SynthesisCuttingToolBind
    * @param synthesisCuttingToolBind
    * @throws Exception
    * @return: void
    */
    public void addSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolBind
    * @Description: 删除SynthesisCuttingToolBind
    * @param synthesisCuttingToolBind
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolBindForLogic
    * @Description: 逻辑删除SynthesisCuttingToolBind
    * @param synthesisCuttingToolBind
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolBindForLogic(SynthesisCuttingToolBind synthesisCuttingToolBind) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolBindByVo
    * @Description: 根据条件删除SynthesisCuttingToolBind
    * @param synthesisCuttingToolBindVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolBindByVo(SynthesisCuttingToolBindVO synthesisCuttingToolBindVO) throws Exception;

    /**
    * @Title: updSynthesisCuttingToolBind
    * @Description: 动态更新SynthesisCuttingToolBind
    * @param synthesisCuttingToolBind
    * @throws Exception
    * @return: void
    */
    public void updSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolBindByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolBindVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SynthesisCuttingToolBind> getSynthesisCuttingToolBindByPage(SynthesisCuttingToolBindVO synthesisCuttingToolBindVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolBindCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolBindVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolBindCount(SynthesisCuttingToolBindVO synthesisCuttingToolBindVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolBind
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolBindVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolBind getSynthesisCuttingToolBind(SynthesisCuttingToolBindVO synthesisCuttingToolBindVO) throws Exception;

}
