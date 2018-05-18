package com.common.mapper;

import com.common.pojo.CuttingToolsScrap;
import com.common.vo.CuttingToolsScrapVO;

import java.util.List;


/**
*
* @ClassName ICuttingToolsScrapMapper
* @Description TODO
* @author Jivoin
*/
public interface ICuttingToolsScrapMapper {

    /**
    * @Title: addCuttingToolsScrap
    * @Description: 新增CuttingToolsScrap
    * @param cuttingToolsScrap
    * @throws Exception
    * @return: void
    */
    public void addCuttingToolsScrap(CuttingToolsScrap cuttingToolsScrap) throws Exception;

    /**
    * @Title: delCuttingToolsScrap
    * @Description: 删除CuttingToolsScrap
    * @param cuttingToolsScrap
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolsScrap(CuttingToolsScrap cuttingToolsScrap) throws Exception;

    /**
    * @Title: delCuttingToolsScrapForLogic
    * @Description: 逻辑删除CuttingToolsScrap
    * @param cuttingToolsScrap
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolsScrapForLogic(CuttingToolsScrap cuttingToolsScrap) throws Exception;

    /**
    * @Title: delCuttingToolsScrapByVo
    * @Description: 根据条件删除CuttingToolsScrap
    * @param cuttingToolsScrapVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolsScrapByVo(CuttingToolsScrapVO cuttingToolsScrapVO) throws Exception;

    /**
    * @Title: updCuttingToolsScrap
    * @Description: 动态更新CuttingToolsScrap
    * @param cuttingToolsScrap
    * @throws Exception
    * @return: void
    */
    public void updCuttingToolsScrap(CuttingToolsScrap cuttingToolsScrap) throws Exception;

    /**
    * @Title: getCuttingToolsScrapByPage
    * @Description: 分页查询
    * @param cuttingToolsScrapVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<CuttingToolsScrap> getCuttingToolsScrapByPage(CuttingToolsScrapVO cuttingToolsScrapVO) throws Exception;

    /**
    * @Title: getCuttingToolsScrapCount
    * @Description: 获取记录数量
    * @param cuttingToolsScrapVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getCuttingToolsScrapCount(CuttingToolsScrapVO cuttingToolsScrapVO) throws Exception;

    /**
    * @Title: getCuttingToolsScrap
    * @Description: 根据查询条件查询
    * @param cuttingToolsScrapVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public CuttingToolsScrap getCuttingToolsScrap(CuttingToolsScrapVO cuttingToolsScrapVO) throws Exception;

}
