package com.service.common.impl;


import com.common.mapper.*;
import com.common.pojo.ProductLine;
import com.common.pojo.SynthesisCuttingToolBindleRecords;
import com.common.vo.CuttingToolBindleRecordsVO;
import com.common.vo.ProductLineVO;
import com.common.vo.SynthesisCuttingToolBindleRecordsVO;
import com.service.common.ISynthesisCuttingToolBindleRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SynthesisCuttingToolBindleRecordsServiceImpl
* @Description SynthesisCuttingToolBindleRecords业务实现类
* @author Jivoin
*/
@Service("synthesisCuttingToolBindleRecordsService")
public class SynthesisCuttingToolBindleRecordsServiceImpl implements ISynthesisCuttingToolBindleRecordsService{

    @Autowired
    private ISynthesisCuttingToolBindleRecordsMapper synthesisCuttingToolBindleRecordsMapper;

    @Autowired
    private IProductLineMapper productLineMapper;
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
    * @Title: addSynthesisCuttingToolBindleRecords
    * @Description: 新增SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSynthesisCuttingToolBindleRecords(SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords) throws Exception{
        synthesisCuttingToolBindleRecordsMapper.addSynthesisCuttingToolBindleRecords(synthesisCuttingToolBindleRecords);
    }

    /**
    * @Title: delSynthesisCuttingToolBindleRecords
    * @Description: 删除SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolBindleRecords(SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords) throws Exception{
        synthesisCuttingToolBindleRecordsMapper.delSynthesisCuttingToolBindleRecords(synthesisCuttingToolBindleRecords);
    }

    /**
    * @Title: delSynthesisCuttingToolBindleRecordsForLogic
    * @Description: 逻辑删除SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolBindleRecordsForLogic(SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords) throws Exception{
        synthesisCuttingToolBindleRecordsMapper.delSynthesisCuttingToolBindleRecordsForLogic(synthesisCuttingToolBindleRecords);
    }

    /**
    * @Title: delSynthesisCuttingToolBindleRecordsByVo
    * @Description: 根据条件删除SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecordsVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolBindleRecordsByVo(SynthesisCuttingToolBindleRecordsVO synthesisCuttingToolBindleRecordsVO) throws Exception{
        synthesisCuttingToolBindleRecordsMapper.delSynthesisCuttingToolBindleRecordsByVo(synthesisCuttingToolBindleRecordsVO);
    }

    /**
    * @Title: updSynthesisCuttingToolBindleRecords
    * @Description: 动态更新SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSynthesisCuttingToolBindleRecords(SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords) throws Exception{
        synthesisCuttingToolBindleRecordsMapper.updSynthesisCuttingToolBindleRecords(synthesisCuttingToolBindleRecords);
    }

    /**
    * @Title: getSynthesisCuttingToolBindleRecordsByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolBindleRecordsVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SynthesisCuttingToolBindleRecords> getSynthesisCuttingToolBindleRecordsByPage(SynthesisCuttingToolBindleRecordsVO synthesisCuttingToolBindleRecordsVO) throws Exception{
        synthesisCuttingToolBindleRecordsVO.setTotalPage(synthesisCuttingToolBindleRecordsMapper.getSynthesisCuttingToolBindleRecordsCount(synthesisCuttingToolBindleRecordsVO));
        return synthesisCuttingToolBindleRecordsMapper.getSynthesisCuttingToolBindleRecordsByPage(synthesisCuttingToolBindleRecordsVO);
    }

    /**
    * @Title: getSynthesisCuttingToolBindleRecordsCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolBindleRecordsVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolBindleRecordsCount(SynthesisCuttingToolBindleRecordsVO synthesisCuttingToolBindleRecordsVO) throws Exception{
        return synthesisCuttingToolBindleRecordsMapper.getSynthesisCuttingToolBindleRecordsCount(synthesisCuttingToolBindleRecordsVO);
    }

    /**
    * @Title: getSynthesisCuttingToolBindleRecords
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolBindleRecordsVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolBindleRecords getSynthesisCuttingToolBindleRecords(SynthesisCuttingToolBindleRecordsVO synthesisCuttingToolBindleRecordsVO) throws Exception{
        return synthesisCuttingToolBindleRecordsMapper.getSynthesisCuttingToolBindleRecords(synthesisCuttingToolBindleRecordsVO);
    }

    @Override
    public SynthesisCuttingToolBindleRecords getLastRecords(SynthesisCuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws Exception {
        return synthesisCuttingToolBindleRecordsMapper.getLast(cuttingToolBindleRecordsVO);
    }

    /**
     *  后续修改
     * @param productLineVO
     * @return
     * @throws Exception
     */
    @Override
    public List<ProductLine> getParts(ProductLineVO productLineVO) throws Exception {
        return productLineMapper.getProductLineByPage(productLineVO);
    }
}
