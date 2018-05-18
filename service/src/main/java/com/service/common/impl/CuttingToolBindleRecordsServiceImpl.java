package com.service.common.impl;


import com.common.mapper.*;
import com.common.pojo.CuttingToolBindleRecords;
import com.common.vo.CuttingToolBindleRecordsVO;
import com.service.common.ICuttingToolBindleRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName CuttingToolBindleRecordsServiceImpl
* @Description CuttingToolBindleRecords业务实现类
* @author Jivoin
*/
@Service("cuttingToolBindleRecordsService")
public class CuttingToolBindleRecordsServiceImpl implements ICuttingToolBindleRecordsService{

    @Autowired
    private ICuttingToolBindleRecordsMapper cuttingToolBindleRecordsMapper;

    @Autowired
    private IProductLineAssemblylineMapper productLineAssemblylineMapper;
    @Autowired
    private IProductLineAxleMapper productLineAxleMapper;
    @Autowired
    private IProductLineEquipmentMapper productLineEquipmentMapper;
    @Autowired
    private IProductLinePartsMapper productLinePartsMapper;
    @Autowired
    private IProductLineProcessMapper productLineProcessMapper;
    @Autowired
    private ISynthesisCuttingToolMapper synthesisCuttingToolMapper;


    /**
    * @Title: addCuttingToolBindleRecords
    * @Description: 新增CuttingToolBindleRecords
    * @param cuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void addCuttingToolBindleRecords(CuttingToolBindleRecords cuttingToolBindleRecords) throws Exception{
        cuttingToolBindleRecordsMapper.addCuttingToolBindleRecords(cuttingToolBindleRecords);
    }

    /**
    * @Title: delCuttingToolBindleRecords
    * @Description: 删除CuttingToolBindleRecords
    * @param cuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolBindleRecords(CuttingToolBindleRecords cuttingToolBindleRecords) throws Exception{
        cuttingToolBindleRecordsMapper.delCuttingToolBindleRecords(cuttingToolBindleRecords);
    }

    /**
    * @Title: delCuttingToolBindleRecordsForLogic
    * @Description: 逻辑删除CuttingToolBindleRecords
    * @param cuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolBindleRecordsForLogic(CuttingToolBindleRecords cuttingToolBindleRecords) throws Exception{
        cuttingToolBindleRecordsMapper.delCuttingToolBindleRecordsForLogic(cuttingToolBindleRecords);
    }

    /**
    * @Title: delCuttingToolBindleRecordsByVo
    * @Description: 根据条件删除CuttingToolBindleRecords
    * @param cuttingToolBindleRecordsVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolBindleRecordsByVo(CuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws Exception{
        cuttingToolBindleRecordsMapper.delCuttingToolBindleRecordsByVo(cuttingToolBindleRecordsVO);
    }

    /**
    * @Title: updCuttingToolBindleRecords
    * @Description: 动态更新CuttingToolBindleRecords
    * @param cuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void updCuttingToolBindleRecords(CuttingToolBindleRecords cuttingToolBindleRecords) throws Exception{
        cuttingToolBindleRecordsMapper.updCuttingToolBindleRecords(cuttingToolBindleRecords);
    }

    /**
    * @Title: getCuttingToolBindleRecordsByPage
    * @Description: 分页查询
    * @param cuttingToolBindleRecordsVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<CuttingToolBindleRecords> getCuttingToolBindleRecordsByPage(CuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws Exception{
        cuttingToolBindleRecordsVO.setTotalPage(cuttingToolBindleRecordsMapper.getCuttingToolBindleRecordsCount(cuttingToolBindleRecordsVO));
        return cuttingToolBindleRecordsMapper.getCuttingToolBindleRecordsByPage(cuttingToolBindleRecordsVO);
    }

    /**
    * @Title: getCuttingToolBindleRecordsCount
    * @Description: 获取记录数量
    * @param cuttingToolBindleRecordsVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getCuttingToolBindleRecordsCount(CuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws Exception{
        return cuttingToolBindleRecordsMapper.getCuttingToolBindleRecordsCount(cuttingToolBindleRecordsVO);
    }

    /**
    * @Title: getCuttingToolBindleRecords
    * @Description: 根据查询条件查询
    * @param cuttingToolBindleRecordsVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public CuttingToolBindleRecords getCuttingToolBindleRecords(CuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws Exception{
        return cuttingToolBindleRecordsMapper.getCuttingToolBindleRecords(cuttingToolBindleRecordsVO);
    }

}
