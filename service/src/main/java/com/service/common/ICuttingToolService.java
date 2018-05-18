package com.service.common;

import com.common.pojo.CuttingTool;
import com.common.vo.CuttingToolVO;

import java.util.List;


/**
*
* @ClassName ICuttingToolService
* @Description CuttingTool业务接口
* @author Jivoin
*/
public interface ICuttingToolService {

    /**
    * @Title: addCuttingTool
    * @Description: 新增CuttingTool
    * @param cuttingTool
    * @throws Exception
    * @return: void
    */
    public void addCuttingTool(CuttingTool cuttingTool) throws Exception;

    /**
    * @Title: delCuttingTool
    * @Description: 删除CuttingTool
    * @param cuttingTool
    * @throws Exception
    * @return: void
    */
    public void delCuttingTool(CuttingTool cuttingTool) throws Exception;

    /**
    * @Title: delCuttingToolForLogic
    * @Description: 逻辑删除CuttingTool
    * @param cuttingTool
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolForLogic(CuttingTool cuttingTool) throws Exception;

    /**
    * @Title: delCuttingToolByVo
    * @Description: 根据条件删除CuttingTool
    * @param cuttingToolVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolByVo(CuttingToolVO cuttingToolVO) throws Exception;

    /**
    * @Title: updCuttingTool
    * @Description: 动态更新CuttingTool
    * @param cuttingTool
    * @throws Exception
    * @return: void
    */
    public void updCuttingTool(CuttingTool cuttingTool) throws Exception;

    /**
    * @Title: getCuttingToolByPage
    * @Description: 分页查询
    * @param cuttingToolVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<CuttingTool> getCuttingToolByPage(CuttingToolVO cuttingToolVO) throws Exception;

    /**
    * @Title: getCuttingToolCount
    * @Description: 获取记录数量
    * @param cuttingToolVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getCuttingToolCount(CuttingToolVO cuttingToolVO) throws Exception;

    /**
    * @Title: getCuttingTool
    * @Description: 根据查询条件查询
    * @param cuttingToolVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public CuttingTool getCuttingTool(CuttingToolVO cuttingToolVO) throws Exception;

}
