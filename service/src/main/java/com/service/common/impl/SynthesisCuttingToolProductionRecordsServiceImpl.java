package com.service.common.impl;


import com.common.mapper.ISynthesisCuttingToolProductionRecordsMapper;
import com.common.pojo.SynthesisCuttingToolProductionRecords;
import com.common.vo.SynthesisCuttingToolProductionRecordsVO;
import com.service.common.ISynthesisCuttingToolProductionRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SynthesisCuttingToolProductionRecordsServiceImpl
* @Description SynthesisCuttingToolProductionRecords业务实现类
* @author Jivoin
*/
@Service("synthesisCuttingToolProductionRecordsService")
public class SynthesisCuttingToolProductionRecordsServiceImpl implements ISynthesisCuttingToolProductionRecordsService{

    @Autowired
    private ISynthesisCuttingToolProductionRecordsMapper synthesisCuttingToolProductionRecordsMapper;



    /**
    * @Title: addSynthesisCuttingToolProductionRecords
    * @Description: 新增SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSynthesisCuttingToolProductionRecords(SynthesisCuttingToolProductionRecords synthesisCuttingToolProductionRecords) throws Exception{
        synthesisCuttingToolProductionRecordsMapper.addSynthesisCuttingToolProductionRecords(synthesisCuttingToolProductionRecords);
    }

    /**
    * @Title: delSynthesisCuttingToolProductionRecords
    * @Description: 删除SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolProductionRecords(SynthesisCuttingToolProductionRecords synthesisCuttingToolProductionRecords) throws Exception{
        synthesisCuttingToolProductionRecordsMapper.delSynthesisCuttingToolProductionRecords(synthesisCuttingToolProductionRecords);
    }

    /**
    * @Title: delSynthesisCuttingToolProductionRecordsForLogic
    * @Description: 逻辑删除SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolProductionRecordsForLogic(SynthesisCuttingToolProductionRecords synthesisCuttingToolProductionRecords) throws Exception{
        synthesisCuttingToolProductionRecordsMapper.delSynthesisCuttingToolProductionRecordsForLogic(synthesisCuttingToolProductionRecords);
    }

    /**
    * @Title: delSynthesisCuttingToolProductionRecordsByVo
    * @Description: 根据条件删除SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecordsVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolProductionRecordsByVo(SynthesisCuttingToolProductionRecordsVO synthesisCuttingToolProductionRecordsVO) throws Exception{
        synthesisCuttingToolProductionRecordsMapper.delSynthesisCuttingToolProductionRecordsByVo(synthesisCuttingToolProductionRecordsVO);
    }

    /**
    * @Title: updSynthesisCuttingToolProductionRecords
    * @Description: 动态更新SynthesisCuttingToolProductionRecords
    * @param synthesisCuttingToolProductionRecords
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSynthesisCuttingToolProductionRecords(SynthesisCuttingToolProductionRecords synthesisCuttingToolProductionRecords) throws Exception{
        synthesisCuttingToolProductionRecordsMapper.updSynthesisCuttingToolProductionRecords(synthesisCuttingToolProductionRecords);
    }

    /**
    * @Title: getSynthesisCuttingToolProductionRecordsByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolProductionRecordsVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SynthesisCuttingToolProductionRecords> getSynthesisCuttingToolProductionRecordsByPage(SynthesisCuttingToolProductionRecordsVO synthesisCuttingToolProductionRecordsVO) throws Exception{
        synthesisCuttingToolProductionRecordsVO.setTotalPage(synthesisCuttingToolProductionRecordsMapper.getSynthesisCuttingToolProductionRecordsCount(synthesisCuttingToolProductionRecordsVO));
        return synthesisCuttingToolProductionRecordsMapper.getSynthesisCuttingToolProductionRecordsByPage(synthesisCuttingToolProductionRecordsVO);
    }

    /**
    * @Title: getSynthesisCuttingToolProductionRecordsCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolProductionRecordsVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolProductionRecordsCount(SynthesisCuttingToolProductionRecordsVO synthesisCuttingToolProductionRecordsVO) throws Exception{
        return synthesisCuttingToolProductionRecordsMapper.getSynthesisCuttingToolProductionRecordsCount(synthesisCuttingToolProductionRecordsVO);
    }

    /**
    * @Title: getSynthesisCuttingToolProductionRecords
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolProductionRecordsVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolProductionRecords getSynthesisCuttingToolProductionRecords(SynthesisCuttingToolProductionRecordsVO synthesisCuttingToolProductionRecordsVO) throws Exception{
        return synthesisCuttingToolProductionRecordsMapper.getSynthesisCuttingToolProductionRecords(synthesisCuttingToolProductionRecordsVO);
    }

}
