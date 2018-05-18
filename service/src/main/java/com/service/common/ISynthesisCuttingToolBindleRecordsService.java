package com.service.common;

import com.common.pojo.ProductLine;
import com.common.pojo.SynthesisCuttingToolBindleRecords;
import com.common.vo.CuttingToolBindleRecordsVO;
import com.common.vo.ProductLineVO;
import com.common.vo.SynthesisCuttingToolBindleRecordsVO;

import java.util.List;


/**
*
* @ClassName ISynthesisCuttingToolBindleRecordsService
* @Description SynthesisCuttingToolBindleRecords业务接口
* @author Jivoin
*/
public interface ISynthesisCuttingToolBindleRecordsService {

    /**
    * @Title: addSynthesisCuttingToolBindleRecords
    * @Description: 新增SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    public void addSynthesisCuttingToolBindleRecords(SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolBindleRecords
    * @Description: 删除SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolBindleRecords(SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolBindleRecordsForLogic
    * @Description: 逻辑删除SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolBindleRecordsForLogic(SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords) throws Exception;

    /**
    * @Title: delSynthesisCuttingToolBindleRecordsByVo
    * @Description: 根据条件删除SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecordsVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSynthesisCuttingToolBindleRecordsByVo(SynthesisCuttingToolBindleRecordsVO synthesisCuttingToolBindleRecordsVO) throws Exception;

    /**
    * @Title: updSynthesisCuttingToolBindleRecords
    * @Description: 动态更新SynthesisCuttingToolBindleRecords
    * @param synthesisCuttingToolBindleRecords
    * @throws Exception
    * @return: void
    */
    public void updSynthesisCuttingToolBindleRecords(SynthesisCuttingToolBindleRecords synthesisCuttingToolBindleRecords) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolBindleRecordsByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolBindleRecordsVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SynthesisCuttingToolBindleRecords> getSynthesisCuttingToolBindleRecordsByPage(SynthesisCuttingToolBindleRecordsVO synthesisCuttingToolBindleRecordsVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolBindleRecordsCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolBindleRecordsVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolBindleRecordsCount(SynthesisCuttingToolBindleRecordsVO synthesisCuttingToolBindleRecordsVO) throws Exception;

    /**
    * @Title: getSynthesisCuttingToolBindleRecords
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolBindleRecordsVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolBindleRecords getSynthesisCuttingToolBindleRecords(SynthesisCuttingToolBindleRecordsVO synthesisCuttingToolBindleRecordsVO) throws Exception;

    public SynthesisCuttingToolBindleRecords getLastRecords(SynthesisCuttingToolBindleRecordsVO cuttingToolBindleRecordsVO) throws Exception;


    public List<ProductLine> getParts(ProductLineVO productLineVO) throws Exception;

}
