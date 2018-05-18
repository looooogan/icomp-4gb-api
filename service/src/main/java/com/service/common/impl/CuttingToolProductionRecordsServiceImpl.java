package com.service.common.impl;


import com.common.mapper.ICuttingToolProductionRecordsMapper;
import com.common.pojo.CuttingToolProductionRecords;
import com.common.vo.CuttingToolProductionRecordsVO;
import com.service.common.ICuttingToolProductionRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName CuttingToolProductionRecordsServiceImpl
* @Description CuttingToolProductionRecords业务实现类
* @author Jivoin
*/
@Service("cuttingToolProductionRecordsService")
public class CuttingToolProductionRecordsServiceImpl implements ICuttingToolProductionRecordsService{

    @Autowired
    private ICuttingToolProductionRecordsMapper cuttingToolProductionRecordsMapper;



    /**
    * @Title: addCuttingToolProductionRecords
    * @Description: 新增CuttingToolProductionRecords
    * @param cuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void addCuttingToolProductionRecords(CuttingToolProductionRecords cuttingToolProductionRecords) throws Exception{
        cuttingToolProductionRecordsMapper.addCuttingToolProductionRecords(cuttingToolProductionRecords);
    }

    /**
    * @Title: delCuttingToolProductionRecords
    * @Description: 删除CuttingToolProductionRecords
    * @param cuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolProductionRecords(CuttingToolProductionRecords cuttingToolProductionRecords) throws Exception{
        cuttingToolProductionRecordsMapper.delCuttingToolProductionRecords(cuttingToolProductionRecords);
    }

    /**
    * @Title: delCuttingToolProductionRecordsForLogic
    * @Description: 逻辑删除CuttingToolProductionRecords
    * @param cuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolProductionRecordsForLogic(CuttingToolProductionRecords cuttingToolProductionRecords) throws Exception{
        cuttingToolProductionRecordsMapper.delCuttingToolProductionRecordsForLogic(cuttingToolProductionRecords);
    }

    /**
    * @Title: delCuttingToolProductionRecordsByVo
    * @Description: 根据条件删除CuttingToolProductionRecords
    * @param cuttingToolProductionRecordsVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolProductionRecordsByVo(CuttingToolProductionRecordsVO cuttingToolProductionRecordsVO) throws Exception{
        cuttingToolProductionRecordsMapper.delCuttingToolProductionRecordsByVo(cuttingToolProductionRecordsVO);
    }

    /**
    * @Title: updCuttingToolProductionRecords
    * @Description: 动态更新CuttingToolProductionRecords
    * @param cuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void updCuttingToolProductionRecords(CuttingToolProductionRecords cuttingToolProductionRecords) throws Exception{
        cuttingToolProductionRecordsMapper.updCuttingToolProductionRecords(cuttingToolProductionRecords);
    }

    /**
    * @Title: getCuttingToolProductionRecordsByPage
    * @Description: 分页查询
    * @param cuttingToolProductionRecordsVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<CuttingToolProductionRecords> getCuttingToolProductionRecordsByPage(CuttingToolProductionRecordsVO cuttingToolProductionRecordsVO) throws Exception{
        cuttingToolProductionRecordsVO.setTotalPage(cuttingToolProductionRecordsMapper.getCuttingToolProductionRecordsCount(cuttingToolProductionRecordsVO));
        return cuttingToolProductionRecordsMapper.getCuttingToolProductionRecordsByPage(cuttingToolProductionRecordsVO);
    }

    /**
    * @Title: getCuttingToolProductionRecordsCount
    * @Description: 获取记录数量
    * @param cuttingToolProductionRecordsVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getCuttingToolProductionRecordsCount(CuttingToolProductionRecordsVO cuttingToolProductionRecordsVO) throws Exception{
        return cuttingToolProductionRecordsMapper.getCuttingToolProductionRecordsCount(cuttingToolProductionRecordsVO);
    }

    /**
    * @Title: getCuttingToolProductionRecords
    * @Description: 根据查询条件查询
    * @param cuttingToolProductionRecordsVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public CuttingToolProductionRecords getCuttingToolProductionRecords(CuttingToolProductionRecordsVO cuttingToolProductionRecordsVO) throws Exception{
        return cuttingToolProductionRecordsMapper.getCuttingToolProductionRecords(cuttingToolProductionRecordsVO);
    }

}
