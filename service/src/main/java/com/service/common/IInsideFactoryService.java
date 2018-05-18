package com.service.common;

import com.common.pojo.InsideFactory;
import com.common.vo.InsideFactoryVO;

import java.util.List;


/**
*
* @ClassName IInsideFactoryService
* @Description InsideFactory业务接口
* @author Jivoin
*/
public interface IInsideFactoryService {

    /**
    * @Title: addInsideFactory
    * @Description: 新增InsideFactory
    * @param insideFactory
    * @throws Exception
    * @return: void
    */
    public void addInsideFactory(InsideFactory insideFactory) throws Exception;

    /**
    * @Title: delInsideFactory
    * @Description: 删除InsideFactory
    * @param insideFactory
    * @throws Exception
    * @return: void
    */
    public void delInsideFactory(InsideFactory insideFactory) throws Exception;

    /**
    * @Title: delInsideFactoryForLogic
    * @Description: 逻辑删除InsideFactory
    * @param insideFactory
    * @throws Exception
    * @return: void
    */
    public void delInsideFactoryForLogic(InsideFactory insideFactory) throws Exception;

    /**
    * @Title: delInsideFactoryByVo
    * @Description: 根据条件删除InsideFactory
    * @param insideFactoryVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delInsideFactoryByVo(InsideFactoryVO insideFactoryVO) throws Exception;

    /**
    * @Title: updInsideFactory
    * @Description: 动态更新InsideFactory
    * @param insideFactory
    * @throws Exception
    * @return: void
    */
    public void updInsideFactory(InsideFactory insideFactory) throws Exception;

    /**
    * @Title: getInsideFactoryByPage
    * @Description: 分页查询
    * @param insideFactoryVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<InsideFactory> getInsideFactoryByPage(InsideFactoryVO insideFactoryVO) throws Exception;

    /**
    * @Title: getInsideFactoryCount
    * @Description: 获取记录数量
    * @param insideFactoryVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getInsideFactoryCount(InsideFactoryVO insideFactoryVO) throws Exception;

    /**
    * @Title: getInsideFactory
    * @Description: 根据查询条件查询
    * @param insideFactoryVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public InsideFactory getInsideFactory(InsideFactoryVO insideFactoryVO) throws Exception;

}
