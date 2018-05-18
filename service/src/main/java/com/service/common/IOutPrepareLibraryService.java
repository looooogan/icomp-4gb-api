package com.service.common;

import com.common.pojo.OutPrepareLibrary;
import com.common.vo.OutPrepareLibraryVO;

import java.util.List;


/**
*
* @ClassName IOutPrepareLibraryService
* @Description OutPrepareLibrary业务接口
* @author Jivoin
*/
public interface IOutPrepareLibraryService {

    /**
    * @Title: addOutPrepareLibrary
    * @Description: 新增OutPrepareLibrary
    * @param outPrepareLibrary
    * @throws Exception
    * @return: void
    */
    public void addOutPrepareLibrary(OutPrepareLibrary outPrepareLibrary) throws Exception;

    /**
    * @Title: delOutPrepareLibrary
    * @Description: 删除OutPrepareLibrary
    * @param outPrepareLibrary
    * @throws Exception
    * @return: void
    */
    public void delOutPrepareLibrary(OutPrepareLibrary outPrepareLibrary) throws Exception;

    /**
    * @Title: delOutPrepareLibraryForLogic
    * @Description: 逻辑删除OutPrepareLibrary
    * @param outPrepareLibrary
    * @throws Exception
    * @return: void
    */
    public void delOutPrepareLibraryForLogic(OutPrepareLibrary outPrepareLibrary) throws Exception;

    /**
    * @Title: delOutPrepareLibraryByVo
    * @Description: 根据条件删除OutPrepareLibrary
    * @param outPrepareLibraryVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delOutPrepareLibraryByVo(OutPrepareLibraryVO outPrepareLibraryVO) throws Exception;

    /**
    * @Title: updOutPrepareLibrary
    * @Description: 动态更新OutPrepareLibrary
    * @param outPrepareLibrary
    * @throws Exception
    * @return: void
    */
    public void updOutPrepareLibrary(OutPrepareLibrary outPrepareLibrary) throws Exception;

    /**
    * @Title: getOutPrepareLibraryByPage
    * @Description: 分页查询
    * @param outPrepareLibraryVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<OutPrepareLibrary> getOutPrepareLibraryByPage(OutPrepareLibraryVO outPrepareLibraryVO) throws Exception;

    /**
    * @Title: getOutPrepareLibraryCount
    * @Description: 获取记录数量
    * @param outPrepareLibraryVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getOutPrepareLibraryCount(OutPrepareLibraryVO outPrepareLibraryVO) throws Exception;

    /**
    * @Title: getOutPrepareLibrary
    * @Description: 根据查询条件查询
    * @param outPrepareLibraryVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public OutPrepareLibrary getOutPrepareLibrary(OutPrepareLibraryVO outPrepareLibraryVO) throws Exception;

}
