package com.service.common;

import com.common.pojo.DjStationAkp;
import com.common.vo.DjStationAkpVO;

import java.util.List;


/**
*
* @ClassName IDjStationAkpService
* @Description DjStationAkp业务接口
* @author Jivoin
*/
public interface IDjStationAkpService {

    /**
    * @Title: addDjStationAkp
    * @Description: 新增DjStationAkp
    * @param djStationAkp
    * @throws Exception
    * @return: void
    */
    public void addDjStationAkp(DjStationAkp djStationAkp) throws Exception;

    /**
    * @Title: delDjStationAkp
    * @Description: 删除DjStationAkp
    * @param djStationAkp
    * @throws Exception
    * @return: void
    */
    public void delDjStationAkp(DjStationAkp djStationAkp) throws Exception;

    /**
    * @Title: delDjStationAkpForLogic
    * @Description: 逻辑删除DjStationAkp
    * @param djStationAkp
    * @throws Exception
    * @return: void
    */
    public void delDjStationAkpForLogic(DjStationAkp djStationAkp) throws Exception;

    /**
    * @Title: delDjStationAkpByVo
    * @Description: 根据条件删除DjStationAkp
    * @param djStationAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delDjStationAkpByVo(DjStationAkpVO djStationAkpVO) throws Exception;

    /**
    * @Title: updDjStationAkp
    * @Description: 动态更新DjStationAkp
    * @param djStationAkp
    * @throws Exception
    * @return: void
    */
    public void updDjStationAkp(DjStationAkp djStationAkp) throws Exception;

    /**
    * @Title: getDjStationAkpByPage
    * @Description: 分页查询
    * @param djStationAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<DjStationAkp> getDjStationAkpByPage(DjStationAkpVO djStationAkpVO) throws Exception;

    /**
    * @Title: getDjStationAkpCount
    * @Description: 获取记录数量
    * @param djStationAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjStationAkpCount(DjStationAkpVO djStationAkpVO) throws Exception;

    /**
    * @Title: getDjStationAkp
    * @Description: 根据查询条件查询
    * @param djStationAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjStationAkp getDjStationAkp(DjStationAkpVO djStationAkpVO) throws Exception;

}
