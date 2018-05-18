package com.common.mapper;

import com.common.pojo.Outsidefactoryhistory;
import com.common.vo.OutsidefactoryhistoryVO;

import java.util.List;


/**
*
* @ClassName IOutsidefactoryhistoryMapper
* @Description TODO
* @author Jivoin
*/
public interface IOutsidefactoryhistoryMapper {

    /**
    * @Title: addOutsidefactoryhistory
    * @Description: 新增Outsidefactoryhistory
    * @param outsidefactoryhistory
    * @throws Exception
    * @return: void
    */
    public void addOutsidefactoryhistory(Outsidefactoryhistory outsidefactoryhistory) throws Exception;

    /**
    * @Title: delOutsidefactoryhistory
    * @Description: 删除Outsidefactoryhistory
    * @param outsidefactoryhistory
    * @throws Exception
    * @return: void
    */
    public void delOutsidefactoryhistory(Outsidefactoryhistory outsidefactoryhistory) throws Exception;

    /**
    * @Title: delOutsidefactoryhistoryForLogic
    * @Description: 逻辑删除Outsidefactoryhistory
    * @param outsidefactoryhistory
    * @throws Exception
    * @return: void
    */
    public void delOutsidefactoryhistoryForLogic(Outsidefactoryhistory outsidefactoryhistory) throws Exception;

    /**
    * @Title: delOutsidefactoryhistoryByVo
    * @Description: 根据条件删除Outsidefactoryhistory
    * @param outsidefactoryhistoryVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delOutsidefactoryhistoryByVo(OutsidefactoryhistoryVO outsidefactoryhistoryVO) throws Exception;

    /**
    * @Title: updOutsidefactoryhistory
    * @Description: 动态更新Outsidefactoryhistory
    * @param outsidefactoryhistory
    * @throws Exception
    * @return: void
    */
    public void updOutsidefactoryhistory(Outsidefactoryhistory outsidefactoryhistory) throws Exception;

    /**
    * @Title: getOutsidefactoryhistoryByPage
    * @Description: 分页查询
    * @param outsidefactoryhistoryVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<Outsidefactoryhistory> getOutsidefactoryhistoryByPage(OutsidefactoryhistoryVO outsidefactoryhistoryVO) throws Exception;

    /**
    * @Title: getOutsidefactoryhistoryCount
    * @Description: 获取记录数量
    * @param outsidefactoryhistoryVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getOutsidefactoryhistoryCount(OutsidefactoryhistoryVO outsidefactoryhistoryVO) throws Exception;

    /**
    * @Title: getOutsidefactoryhistory
    * @Description: 根据查询条件查询
    * @param outsidefactoryhistoryVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public Outsidefactoryhistory getOutsidefactoryhistory(OutsidefactoryhistoryVO outsidefactoryhistoryVO) throws Exception;

}
