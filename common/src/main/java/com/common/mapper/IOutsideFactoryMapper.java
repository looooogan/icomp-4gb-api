package com.common.mapper;

import com.common.pojo.OutsideFactory;
import com.common.vo.OutsideFactoryVO;

import java.util.List;


/**
*
* @ClassName IOutsideFactoryMapper
* @Description TODO
* @author Jivoin
*/
public interface IOutsideFactoryMapper {

    /**
    * @Title: addOutsideFactory
    * @Description: 新增OutsideFactory
    * @param outsideFactory
    * @throws Exception
    * @return: void
    */
    public void addOutsideFactory(OutsideFactory outsideFactory) throws Exception;

    /**
    * @Title: delOutsideFactory
    * @Description: 删除OutsideFactory
    * @param outsideFactory
    * @throws Exception
    * @return: void
    */
    public void delOutsideFactory(OutsideFactory outsideFactory) throws Exception;

    /**
    * @Title: delOutsideFactoryForLogic
    * @Description: 逻辑删除OutsideFactory
    * @param outsideFactory
    * @throws Exception
    * @return: void
    */
    public void delOutsideFactoryForLogic(OutsideFactory outsideFactory) throws Exception;

    /**
    * @Title: delOutsideFactoryByVo
    * @Description: 根据条件删除OutsideFactory
    * @param outsideFactoryVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delOutsideFactoryByVo(OutsideFactoryVO outsideFactoryVO) throws Exception;

    /**
    * @Title: updOutsideFactory
    * @Description: 动态更新OutsideFactory
    * @param outsideFactory
    * @throws Exception
    * @return: void
    */
    public void updOutsideFactory(OutsideFactory outsideFactory) throws Exception;

    /**
    * @Title: getOutsideFactoryByPage
    * @Description: 分页查询
    * @param outsideFactoryVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<OutsideFactory> getOutsideFactoryByPage(OutsideFactoryVO outsideFactoryVO) throws Exception;

    /**
    * @Title: getOutsideFactoryCount
    * @Description: 获取记录数量
    * @param outsideFactoryVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getOutsideFactoryCount(OutsideFactoryVO outsideFactoryVO) throws Exception;

    /**
    * @Title: getOutsideFactory
    * @Description: 根据查询条件查询
    * @param outsideFactoryVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public OutsideFactory getOutsideFactory(OutsideFactoryVO outsideFactoryVO) throws Exception;

}
