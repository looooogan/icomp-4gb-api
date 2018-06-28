package com.common.mapper;

import com.common.pojo.AuthCustomer;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.CuttingToolBindleRecords;
import com.common.pojo.SynthesisCuttingToolBindleRecords;
import com.common.vo.CuttingToolBindleRecordsVO;

import java.util.List;


/**
*
* @ClassName ICuttingToolBindleRecordsMapper
* @Description TODO
* @author Jivoin
*/
public interface ICuttingToolBindleRecordsMapper {

    /**
    * @Title: addCuttingToolBindleRecords
    * @Description: 新增CuttingToolBindleRecords
    * @param cuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    public void addCuttingToolBindleRecords(CuttingToolBindleRecords cuttingToolBindleRecords) throws Exception;

    /**
    * @Title: delCuttingToolBindleRecords
    * @Description: 删除CuttingToolBindleRecords
    * @param cuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolBindleRecords(CuttingToolBindleRecords cuttingToolBindleRecords) throws Exception;

    /**
    * @Title: delCuttingToolBindleRecordsForLogic
    * @Description: 逻辑删除CuttingToolBindleRecords
    * @param cuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolBindleRecordsForLogic(CuttingToolBindleRecords cuttingToolBindleRecords) throws Exception;

    /**
    * @Title: delCuttingToolBindleRecordsByVo
    * @Description: 根据条件删除CuttingToolBindleRecords
    * @param cuttingToolBindleRecordsVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolBindleRecordsByVo(CuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws Exception;

    /**
    * @Title: updCuttingToolBindleRecords
    * @Description: 动态更新CuttingToolBindleRecords
    * @param cuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    public void updCuttingToolBindleRecords(CuttingToolBindleRecords cuttingToolBindleRecords) throws Exception;

    /**
    * @Title: getCuttingToolBindleRecordsByPage
    * @Description: 分页查询
    * @param cuttingToolBindleRecordsVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<CuttingToolBindleRecords> getCuttingToolBindleRecordsByPage(CuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws Exception;

    /**
    * @Title: getCuttingToolBindleRecordsCount
    * @Description: 获取记录数量
    * @param cuttingToolBindleRecordsVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getCuttingToolBindleRecordsCount(CuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws Exception;

    /**
    * @Title: getCuttingToolBindleRecords
    * @Description: 根据查询条件查询
    * @param cuttingToolBindleRecordsVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public CuttingToolBindleRecords getCuttingToolBindleRecords(CuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws Exception;



    public SynthesisCuttingToolBindleRecords getLastRecords(CuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws Exception;


}
