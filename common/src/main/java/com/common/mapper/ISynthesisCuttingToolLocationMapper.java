package com.common.mapper;

import com.common.pojo.SynthesisCuttingToolLocation;
import com.common.vo.SynthesisCuttingToolLocationVO;

import java.util.List;


/**
*
* @ClassName ISynthesisCuttingToolLocationMapper
* @Description TODO
* @author Jivoin
*/
public interface ISynthesisCuttingToolLocationMapper {

    /**
    * @Title: addSynthesisCuttingToolLocation
    * @Description: 新增SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocation
    * @throws Exception
    * @return: void
    */
    public void addSynthesisCuttingToolLocation(SynthesisCuttingToolLocation synthesisCuttingToolLocation) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolLocation
    * @Description: 删除SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocation
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolLocation(SynthesisCuttingToolLocation synthesisCuttingToolLocation) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolLocationForLogic
    * @Description: 逻辑删除SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocation
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolLocationForLogic(SynthesisCuttingToolLocation synthesisCuttingToolLocation) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolLocationByVo
    * @Description: 根据条件删除SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocationVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolLocationByVo(SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO) throws Exception;

    /**
    * @Title: updSynthesisCuttingToolLocation
    * @Description: 动态更新SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocation
    * @throws Exception
    * @return: void
    */
    public void updSynthesisCuttingToolLocation(SynthesisCuttingToolLocation synthesisCuttingToolLocation) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolLocationByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolLocationVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SynthesisCuttingToolLocation> getSynthesisCuttingToolLocationByPage(SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolLocationCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolLocationVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolLocationCount(SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolLocation
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolLocationVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolLocation getSynthesisCuttingToolLocation(SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO) throws Exception;

}
