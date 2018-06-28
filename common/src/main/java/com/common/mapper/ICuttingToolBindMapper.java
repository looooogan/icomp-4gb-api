package com.common.mapper;

import com.common.pojo.CuttingToolBind;
import com.common.vo.CuttingToolBindVO;

import java.util.List;


/**
*
* @ClassName ICuttingToolBindMapper
* @Description TODO
* @author Jivoin
*/
public interface ICuttingToolBindMapper {

    /**
    * @Title: addCuttingToolBind
    * @Description: 新增CuttingToolBind
    * @param cuttingToolBind
    * @throws Exception
    * @return: void
    */
    public void addCuttingToolBind(CuttingToolBind cuttingToolBind) throws Exception;

    /**
    * @Title: delCuttingToolBind
    * @Description: 删除CuttingToolBind
    * @param cuttingToolBind
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolBind(CuttingToolBind cuttingToolBind) throws Exception;

    /**
    * @Title: delCuttingToolBindForLogic
    * @Description: 逻辑删除CuttingToolBind
    * @param cuttingToolBind
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolBindForLogic(CuttingToolBind cuttingToolBind) throws Exception;

    /**
    * @Title: delCuttingToolBindByVo
    * @Description: 根据条件删除CuttingToolBind
    * @param cuttingToolBindVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delCuttingToolBindByVo(CuttingToolBindVO cuttingToolBindVO) throws Exception;

    /**
    * @Title: updCuttingToolBind
    * @Description: 动态更新CuttingToolBind
    * @param cuttingToolBind
    * @throws Exception
    * @return: void
    */
    public void updCuttingToolBind(CuttingToolBind cuttingToolBind) throws Exception;

    /**
    * @Title: getCuttingToolBindByPage
    * @Description: 分页查询
    * @param cuttingToolBindVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<CuttingToolBind> getCuttingToolBindByPage(CuttingToolBindVO cuttingToolBindVO) throws Exception;

    /**
    * @Title: getCuttingToolBindCount
    * @Description: 获取记录数量
    * @param cuttingToolBindVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getCuttingToolBindCount(CuttingToolBindVO cuttingToolBindVO) throws Exception;

    /**
    * @Title: getCuttingToolBind
    * @Description: 根据查询条件查询
    * @param cuttingToolBindVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public CuttingToolBind getCuttingToolBind(CuttingToolBindVO cuttingToolBindVO) throws Exception;

    /**
     * 解绑
     * @param cuttingToolBindVO
     * @throws Exception
     */
    public void unBindCuttingToolData(CuttingToolBindVO cuttingToolBindVO) throws Exception;


    /**
     * @Title: clearRFIDData
     * @Description: 清空标签
     * @param cuttingToolBind 清空数据
     * @throws Exception
     * @return: 查询结果
     */
    public void clearRFIDData(CuttingToolBind cuttingToolBind) throws Exception;

}
