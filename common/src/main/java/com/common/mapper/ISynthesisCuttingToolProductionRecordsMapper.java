package com.common.mapper;

import com.common.pojo.SynthesisCuttingToolProductionRecords;
import com.common.vo.SynthesisCuttingToolProductionRecordsVO;

import java.util.List;


/**
*
* @ClassName ISynthesisCuttingToolProductionRecordsMapper
* @Description TODO
* @author Jivoin
*/
public interface ISynthesisCuttingToolProductionRecordsMapper {

    /**
    * @Title: addSynthesisCuttingToolProductionRecords
    * @Description: 新增SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    public void addSynthesisCuttingToolProductionRecords(SynthesisCuttingToolProductionRecords synthesisCuttingToolProductionRecords) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolProductionRecords
    * @Description: 删除SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolProductionRecords(SynthesisCuttingToolProductionRecords synthesisCuttingToolProductionRecords) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolProductionRecordsForLogic
    * @Description: 逻辑删除SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolProductionRecordsForLogic(SynthesisCuttingToolProductionRecords synthesisCuttingToolProductionRecords) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolProductionRecordsByVo
    * @Description: 根据条件删除SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecordsVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolProductionRecordsByVo(SynthesisCuttingToolProductionRecordsVO synthesisCuttingToolProductionRecordsVO) throws Exception;

    /**
    * @Title: updSynthesisCuttingToolProductionRecords
    * @Description: 动态更新SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    public void updSynthesisCuttingToolProductionRecords(SynthesisCuttingToolProductionRecords synthesisCuttingToolProductionRecords) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolProductionRecordsByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolProductionRecordsVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SynthesisCuttingToolProductionRecords> getSynthesisCuttingToolProductionRecordsByPage(SynthesisCuttingToolProductionRecordsVO synthesisCuttingToolProductionRecordsVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolProductionRecordsCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolProductionRecordsVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolProductionRecordsCount(SynthesisCuttingToolProductionRecordsVO synthesisCuttingToolProductionRecordsVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolProductionRecords
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolProductionRecordsVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolProductionRecords getSynthesisCuttingToolProductionRecords(SynthesisCuttingToolProductionRecordsVO synthesisCuttingToolProductionRecordsVO) throws Exception;

}
