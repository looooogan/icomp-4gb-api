package com.service.common;

import com.common.pojo.DjUserAkp;
import com.common.vo.DjUserAkpVO;

import java.util.List;


/**
*
* @ClassName IDjUserAkpService
* @Description DjUserAkp业务接口
* @author Jivoin
*/
public interface IDjUserAkpService {

    /**
    * @Title: addDjUserAkp
    * @Description: 新增DjUserAkp
    * @param djUserAkp
    * @throws Exception
    * @return: void
    */
    public void addDjUserAkp(DjUserAkp djUserAkp) throws Exception;

    /**
    * @Title: delDjUserAkp
    * @Description: 删除DjUserAkp
    * @param djUserAkp
    * @throws Exception
    * @return: void
    */
    public void delDjUserAkp(DjUserAkp djUserAkp) throws Exception;

    /**
    * @Title: delDjUserAkpForLogic
    * @Description: 逻辑删除DjUserAkp
    * @param djUserAkp
    * @throws Exception
    * @return: void
    */
    public void delDjUserAkpForLogic(DjUserAkp djUserAkp) throws Exception;

    /**
    * @Title: delDjUserAkpByVo
    * @Description: 根据条件删除DjUserAkp
    * @param djUserAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delDjUserAkpByVo(DjUserAkpVO djUserAkpVO) throws Exception;

    /**
    * @Title: updDjUserAkp
    * @Description: 动态更新DjUserAkp
    * @param djUserAkp
    * @throws Exception
    * @return: void
    */
    public void updDjUserAkp(DjUserAkp djUserAkp) throws Exception;

    /**
    * @Title: getDjUserAkpByPage
    * @Description: 分页查询
    * @param djUserAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<DjUserAkp> getDjUserAkpByPage(DjUserAkpVO djUserAkpVO) throws Exception;

    /**
    * @Title: getDjUserAkpCount
    * @Description: 获取记录数量
    * @param djUserAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjUserAkpCount(DjUserAkpVO djUserAkpVO) throws Exception;

    /**
    * @Title: getDjUserAkp
    * @Description: 根据查询条件查询
    * @param djUserAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjUserAkp getDjUserAkp(DjUserAkpVO djUserAkpVO) throws Exception;

}
