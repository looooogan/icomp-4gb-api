package com.common.mapper;

import com.common.pojo.CuttingToolProductionRecords;
import com.common.vo.CuttingToolProductionRecordsVO;

import java.util.List;


/**
*
* @ClassName ICuttingToolProductionRecordsMapper
* @Description TODO
* @author Jivoin
*/
public interface ICuttingToolProductionRecordsMapper {

    /**
    * @Title: addCuttingToolProductionRecords
    * @Description: 新增CuttingToolProductionRecords
    * @param cuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    public void addCuttingToolProductionRecords(CuttingToolProductionRecords cuttingToolProductionRecords) throws Exception;

    /**
    * @Title: delCuttingToolProductionRecords
    * @Description: 删除CuttingToolProductionRecords
    * @param cuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolProductionRecords(CuttingToolProductionRecords cuttingToolProductionRecords) throws Exception;

    /**
    * @Title: delCuttingToolProductionRecordsForLogic
    * @Description: 逻辑删除CuttingToolProductionRecords
    * @param cuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolProductionRecordsForLogic(CuttingToolProductionRecords cuttingToolProductionRecords) throws Exception;

    /**
    * @Title: delCuttingToolProductionRecordsByVo
    * @Description: 根据条件删除CuttingToolProductionRecords
    * @param cuttingToolProductionRecordsVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolProductionRecordsByVo(CuttingToolProductionRecordsVO cuttingToolProductionRecordsVO) throws Exception;

    /**
    * @Title: updCuttingToolProductionRecords
    * @Description: 动态更新CuttingToolProductionRecords
    * @param cuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    public void updCuttingToolProductionRecords(CuttingToolProductionRecords cuttingToolProductionRecords) throws Exception;

    /**
    * @Title: getCuttingToolProductionRecordsByPage
    * @Description: 分页查询
    * @param cuttingToolProductionRecordsVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<CuttingToolProductionRecords> getCuttingToolProductionRecordsByPage(CuttingToolProductionRecordsVO cuttingToolProductionRecordsVO) throws Exception;

    /**
    * @Title: getCuttingToolProductionRecordsCount
    * @Description: 获取记录数量
    * @param cuttingToolProductionRecordsVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getCuttingToolProductionRecordsCount(CuttingToolProductionRecordsVO cuttingToolProductionRecordsVO) throws Exception;

    /**
    * @Title: getCuttingToolProductionRecords
    * @Description: 根据查询条件查询
    * @param cuttingToolProductionRecordsVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public CuttingToolProductionRecords getCuttingToolProductionRecords(CuttingToolProductionRecordsVO cuttingToolProductionRecordsVO) throws Exception;

}
