package com.common.mapper;

import com.common.pojo.SynthesisBladeCode;
import com.common.vo.SynthesisBladeCodeVO;

import java.util.List;


/**
*
* @ClassName ISynthesisBladeCodeMapper
* @Description TODO
* @author Jivoin
*/
public interface ISynthesisBladeCodeMapper {

    /**
    * @Title: addSynthesisBladeCode
    * @Description: 新增SynthesisBladeCode
    * @param synthesisBladeCode
    * @throws Exception
    * @return: void
    */
    public void addSynthesisBladeCode(SynthesisBladeCode synthesisBladeCode) throws Exception;

    /**
    * @Title: delSynthesisBladeCode
    * @Description: 删除SynthesisBladeCode
    * @param synthesisBladeCode
    * @throws Exception
    * @return: void
    */
    public void delSynthesisBladeCode(SynthesisBladeCode synthesisBladeCode) throws Exception;

    /**
    * @Title: delSynthesisBladeCodeForLogic
    * @Description: 逻辑删除SynthesisBladeCode
    * @param synthesisBladeCode
    * @throws Exception
    * @return: void
    */
    public void delSynthesisBladeCodeForLogic(SynthesisBladeCode synthesisBladeCode) throws Exception;

    /**
    * @Title: delSynthesisBladeCodeByVo
    * @Description: 根据条件删除SynthesisBladeCode
    * @param synthesisBladeCodeVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSynthesisBladeCodeByVo(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception;

    /**
    * @Title: updSynthesisBladeCode
    * @Description: 动态更新SynthesisBladeCode
    * @param synthesisBladeCode
    * @throws Exception
    * @return: void
    */
    public void updSynthesisBladeCode(SynthesisBladeCode synthesisBladeCode) throws Exception;

    /**
    * @Title: getSynthesisBladeCodeByPage
    * @Description: 分页查询
    * @param synthesisBladeCodeVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SynthesisBladeCode> getSynthesisBladeCodeByPage(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception;

    /**
    * @Title: getSynthesisBladeCodeCount
    * @Description: 获取记录数量
    * @param synthesisBladeCodeVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisBladeCodeCount(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception;

    /**
    * @Title: getSynthesisBladeCode
    * @Description: 根据查询条件查询
    * @param synthesisBladeCodeVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisBladeCode getSynthesisBladeCode(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception;


    /**
     * @Title: getSynthesisBladeCodeForGroup
     * @Description: 分页查询
     * @param synthesisBladeCodeVO 查询条件封装
     * @throws Exception
     * @return: 结果集
     */
    public List<SynthesisBladeCode> getSynthesisBladeCodeForGroup(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception;

    /**
     * @Title: getSynthesisBladeCodeCountForGroup
     * @Description: 获取记录数量
     * @param synthesisBladeCodeVO 查询条件封装
     * @throws Exception
     * @return: Integer
     */
    public Integer getSynthesisBladeCodeCountForGroup(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception;

    /**
     * 获取范围最大值
     * @return
     * @throws Exception
     */
    public Integer getMaxValue() throws Exception;

    /**
     * 获取范围最小值
     * @return
     * @throws Exception
     */
    public Integer getMinValue() throws Exception;


}
