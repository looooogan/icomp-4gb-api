package com.service.common;

import com.common.pojo.QimingRecords;
import com.common.vo.QimingRecordsVO;

import java.util.List;


/**
*
* @ClassName IQimingRecordsService
* @Description QimingRecords业务接口
* @author Jivoin
*/
public interface IQimingRecordsService {

    /**
    * @Title: addQimingRecords
    * @Description: 新增QimingRecords
    * @param qimingRecords
    * @throws Exception
    * @return: void
    */
    public void addQimingRecords(QimingRecords qimingRecords) throws Exception;

    /**
    * @Title: delQimingRecords
    * @Description: 删除QimingRecords
    * @param qimingRecords
    * @throws Exception
    * @return: void
    */
    public void delQimingRecords(QimingRecords qimingRecords) throws Exception;

    /**
    * @Title: delQimingRecordsForLogic
    * @Description: 逻辑删除QimingRecords
    * @param qimingRecords
    * @throws Exception
    * @return: void
    */
    public void delQimingRecordsForLogic(QimingRecords qimingRecords) throws Exception;

    /**
    * @Title: delQimingRecordsByVo
    * @Description: 根据条件删除QimingRecords
    * @param qimingRecordsVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delQimingRecordsByVo(QimingRecordsVO qimingRecordsVO) throws Exception;

    /**
    * @Title: updQimingRecords
    * @Description: 动态更新QimingRecords
    * @param qimingRecords
    * @throws Exception
    * @return: void
    */
    public void updQimingRecords(QimingRecords qimingRecords) throws Exception;

    /**
    * @Title: getQimingRecordsByPage
    * @Description: 分页查询
    * @param qimingRecordsVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<QimingRecords> getQimingRecordsByPage(QimingRecordsVO qimingRecordsVO) throws Exception;

    /**
    * @Title: getQimingRecordsCount
    * @Description: 获取记录数量
    * @param qimingRecordsVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getQimingRecordsCount(QimingRecordsVO qimingRecordsVO) throws Exception;

    /**
    * @Title: getQimingRecords
    * @Description: 根据查询条件查询
    * @param qimingRecordsVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public QimingRecords getQimingRecords(QimingRecordsVO qimingRecordsVO) throws Exception;


    public Integer getMaxBatchNo() throws Exception;

    public List<QimingRecords> getAllQimingRecord(QimingRecordsVO qimingRecordsVO) throws Exception;

}
