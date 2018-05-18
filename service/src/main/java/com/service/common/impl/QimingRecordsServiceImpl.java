package com.service.common.impl;


import com.common.mapper.IQimingRecordsMapper;
import com.common.pojo.QimingRecords;
import com.common.vo.QimingRecordsVO;
import com.service.common.IQimingRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName QimingRecordsServiceImpl
* @Description QimingRecords业务实现类
* @author Jivoin
*/
@Service("qimingRecordsService")
public class QimingRecordsServiceImpl implements IQimingRecordsService{

    @Autowired
    private IQimingRecordsMapper qimingRecordsMapper;



    /**
    * @Title: addQimingRecords
    * @Description: 新增QimingRecords
    * @param qimingRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void addQimingRecords(QimingRecords qimingRecords) throws Exception{
        qimingRecordsMapper.addQimingRecords(qimingRecords);
    }

    /**
    * @Title: delQimingRecords
    * @Description: 删除QimingRecords
    * @param qimingRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void delQimingRecords(QimingRecords qimingRecords) throws Exception{
        qimingRecordsMapper.delQimingRecords(qimingRecords);
    }

    /**
    * @Title: delQimingRecordsForLogic
    * @Description: 逻辑删除QimingRecords
    * @param qimingRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void delQimingRecordsForLogic(QimingRecords qimingRecords) throws Exception{
        qimingRecordsMapper.delQimingRecordsForLogic(qimingRecords);
    }

    /**
    * @Title: delQimingRecordsByVo
    * @Description: 根据条件删除QimingRecords
    * @param qimingRecordsVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delQimingRecordsByVo(QimingRecordsVO qimingRecordsVO) throws Exception{
        qimingRecordsMapper.delQimingRecordsByVo(qimingRecordsVO);
    }

    /**
    * @Title: updQimingRecords
    * @Description: 动态更新QimingRecords
    * @param qimingRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void updQimingRecords(QimingRecords qimingRecords) throws Exception{
        qimingRecordsMapper.updQimingRecords(qimingRecords);
    }

    /**
    * @Title: getQimingRecordsByPage
    * @Description: 分页查询
    * @param qimingRecordsVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<QimingRecords> getQimingRecordsByPage(QimingRecordsVO qimingRecordsVO) throws Exception{
        qimingRecordsVO.setTotalPage(qimingRecordsMapper.getQimingRecordsCount(qimingRecordsVO));
        return qimingRecordsMapper.getQimingRecordsByPage(qimingRecordsVO);
    }

    /**
    * @Title: getQimingRecordsCount
    * @Description: 获取记录数量
    * @param qimingRecordsVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getQimingRecordsCount(QimingRecordsVO qimingRecordsVO) throws Exception{
        return qimingRecordsMapper.getQimingRecordsCount(qimingRecordsVO);
    }

    /**
    * @Title: getQimingRecords
    * @Description: 根据查询条件查询
    * @param qimingRecordsVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public QimingRecords getQimingRecords(QimingRecordsVO qimingRecordsVO) throws Exception{
        return qimingRecordsMapper.getQimingRecords(qimingRecordsVO);
    }


    @Override
    public Integer getMaxBatchNo() throws Exception {
        return qimingRecordsMapper.getMaxBatchNo();
    }

    @Override
    public List<QimingRecords> getAllQimingRecord(QimingRecordsVO qimingRecordsVO) throws Exception{
        return qimingRecordsMapper.getQimingRecordsByPage(qimingRecordsVO);
    }
}
