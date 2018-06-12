package com.service.impower;

import com.common.pojo.ImpowerRecorder;
import com.common.vo.ImpowerRecorderVO;

import java.util.List;


/**
*
* @ClassName IImpowerRecorderService
* @Description ImpowerRecorder业务接口
* @author Jivoin
*/
public interface IImpowerRecorderService {

    /**
    * @Title: addImpowerRecorder
    * @Description: 新增ImpowerRecorder
    * @param impowerRecorder
    * @throws Exception
    * @return: void
    */
    public void addImpowerRecorder(ImpowerRecorder impowerRecorder) throws Exception;

    /**
     * @Title: addImpowerRecorders
     * @Description: 批量新增ImpowerRecorder
     * @param impowerRecorders
     * @throws Exception
     * @return: void
     */
    public void addImpowerRecorders(List<ImpowerRecorder> impowerRecorders) throws Exception;

    /**
    * @Title: delImpowerRecorder
    * @Description: 删除ImpowerRecorder
    * @param impowerRecorder
    * @throws Exception
    * @return: void
    */
    public void delImpowerRecorder(ImpowerRecorder impowerRecorder) throws Exception;

    /**
    * @Title: delImpowerRecorderForLogic
    * @Description: 逻辑删除ImpowerRecorder
    * @param impowerRecorder
    * @throws Exception
    * @return: void
    */
    public void delImpowerRecorderForLogic(ImpowerRecorder impowerRecorder) throws Exception;

    /**
    * @Title: delImpowerRecorderByVo
    * @Description: 根据条件删除ImpowerRecorder
    * @param impowerRecorderVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delImpowerRecorderByVo(ImpowerRecorderVO impowerRecorderVO) throws Exception;

    /**
    * @Title: updImpowerRecorder
    * @Description: 动态更新ImpowerRecorder
    * @param impowerRecorder
    * @throws Exception
    * @return: void
    */
    public void updImpowerRecorder(ImpowerRecorder impowerRecorder) throws Exception;

    /**
    * @Title: getImpowerRecorderByPage
    * @Description: 分页查询
    * @param impowerRecorderVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<ImpowerRecorder> getImpowerRecorderByPage(ImpowerRecorderVO impowerRecorderVO) throws Exception;

    /**
    * @Title: getImpowerRecorderCount
    * @Description: 获取记录数量
    * @param impowerRecorderVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getImpowerRecorderCount(ImpowerRecorderVO impowerRecorderVO) throws Exception;

    /**
    * @Title: getImpowerRecorder
    * @Description: 根据查询条件查询
    * @param impowerRecorderVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ImpowerRecorder getImpowerRecorder(ImpowerRecorderVO impowerRecorderVO) throws Exception;

}
