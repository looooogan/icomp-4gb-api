package com.common.mapper;

import com.common.pojo.RfidContainer;
import com.common.vo.RfidContainerVO;

import java.util.List;


/**
*
* @ClassName IRfidContainerMapper
* @Description TODO
* @author Jivoin
*/
public interface IRfidContainerMapper {

    /**
    * @Title: addRfidContainer
    * @Description: 新增RfidContainer
    * @param rfidContainer
    * @throws Exception
    * @return: void
    */
    public void addRfidContainer(RfidContainer rfidContainer) throws Exception;

    /**
    * @Title: delRfidContainer
    * @Description: 删除RfidContainer
    * @param rfidContainer
    * @throws Exception
    * @return: void
    */
    public void delRfidContainer(RfidContainer rfidContainer) throws Exception;

    /**
    * @Title: delRfidContainerForLogic
    * @Description: 逻辑删除RfidContainer
    * @param rfidContainer
    * @throws Exception
    * @return: void
    */
    public void delRfidContainerForLogic(RfidContainer rfidContainer) throws Exception;

    /**
    * @Title: delRfidContainerByVo
    * @Description: 根据条件删除RfidContainer
    * @param rfidContainerVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delRfidContainerByVo(RfidContainerVO rfidContainerVO) throws Exception;

    /**
    * @Title: updRfidContainer
    * @Description: 动态更新RfidContainer
    * @param rfidContainer
    * @throws Exception
    * @return: void
    */
    public void updRfidContainer(RfidContainer rfidContainer) throws Exception;

    /**
    * @Title: getRfidContainerByPage
    * @Description: 分页查询
    * @param rfidContainerVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<RfidContainer> getRfidContainerByPage(RfidContainerVO rfidContainerVO) throws Exception;

    /**
    * @Title: getRfidContainerCount
    * @Description: 获取记录数量
    * @param rfidContainerVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getRfidContainerCount(RfidContainerVO rfidContainerVO) throws Exception;

    /**
    * @Title: getRfidContainer
    * @Description: 根据查询条件查询
    * @param rfidContainerVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public RfidContainer getRfidContainer(RfidContainerVO rfidContainerVO) throws Exception;

}
