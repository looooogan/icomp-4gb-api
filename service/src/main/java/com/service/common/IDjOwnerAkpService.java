package com.service.common;

import com.common.pojo.DjOwnerAkp;
import com.common.vo.DjOwnerAkpVO;

import java.util.List;


/**
*
* @ClassName IDjOwnerAkpService
* @Description DjOwnerAkp业务接口
* @author Jivoin
*/
public interface IDjOwnerAkpService {

    /**
    * @Title: addDjOwnerAkp
    * @Description: 新增DjOwnerAkp
    * @param djOwnerAkp
    * @throws Exception
    * @return: void
    */
    public void addDjOwnerAkp(DjOwnerAkp djOwnerAkp) throws Exception;

    /**
    * @Title: delDjOwnerAkp
    * @Description: 删除DjOwnerAkp
    * @param djOwnerAkp
    * @throws Exception
    * @return: void
    */
    public void delDjOwnerAkp(DjOwnerAkp djOwnerAkp) throws Exception;

    /**
    * @Title: delDjOwnerAkpForLogic
    * @Description: 逻辑删除DjOwnerAkp
    * @param djOwnerAkp
    * @throws Exception
    * @return: void
    */
    public void delDjOwnerAkpForLogic(DjOwnerAkp djOwnerAkp) throws Exception;

    /**
    * @Title: delDjOwnerAkpByVo
    * @Description: 根据条件删除DjOwnerAkp
    * @param djOwnerAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delDjOwnerAkpByVo(DjOwnerAkpVO djOwnerAkpVO) throws Exception;

    /**
    * @Title: updDjOwnerAkp
    * @Description: 动态更新DjOwnerAkp
    * @param djOwnerAkp
    * @throws Exception
    * @return: void
    */
    public void updDjOwnerAkp(DjOwnerAkp djOwnerAkp) throws Exception;

    /**
    * @Title: getDjOwnerAkpByPage
    * @Description: 分页查询
    * @param djOwnerAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<DjOwnerAkp> getDjOwnerAkpByPage(DjOwnerAkpVO djOwnerAkpVO) throws Exception;

    /**
    * @Title: getDjOwnerAkpCount
    * @Description: 获取记录数量
    * @param djOwnerAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjOwnerAkpCount(DjOwnerAkpVO djOwnerAkpVO) throws Exception;

    /**
    * @Title: getDjOwnerAkp
    * @Description: 根据查询条件查询
    * @param djOwnerAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjOwnerAkp getDjOwnerAkp(DjOwnerAkpVO djOwnerAkpVO) throws Exception;

}
