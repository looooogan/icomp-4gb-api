package com.service.common;

import com.common.pojo.DjMtlAkp;
import com.common.vo.DjMtlAkpVO;

import java.util.List;


/**
*
* @ClassName IDjMtlAkpService
* @Description DjMtlAkp业务接口
* @author Jivoin
*/
public interface IDjMtlAkpService {

    /**
    * @Title: addDjMtlAkp
    * @Description: 新增DjMtlAkp
    * @param djMtlAkp
    * @throws Exception
    * @return: void
    */
    public void addDjMtlAkp(DjMtlAkp djMtlAkp) throws Exception;

    /**
    * @Title: delDjMtlAkp
    * @Description: 删除DjMtlAkp
    * @param djMtlAkp
    * @throws Exception
    * @return: void
    */
    public void delDjMtlAkp(DjMtlAkp djMtlAkp) throws Exception;

    /**
    * @Title: delDjMtlAkpForLogic
    * @Description: 逻辑删除DjMtlAkp
    * @param djMtlAkp
    * @throws Exception
    * @return: void
    */
    public void delDjMtlAkpForLogic(DjMtlAkp djMtlAkp) throws Exception;

    /**
    * @Title: delDjMtlAkpByVo
    * @Description: 根据条件删除DjMtlAkp
    * @param djMtlAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delDjMtlAkpByVo(DjMtlAkpVO djMtlAkpVO) throws Exception;

    /**
    * @Title: updDjMtlAkp
    * @Description: 动态更新DjMtlAkp
    * @param djMtlAkp
    * @throws Exception
    * @return: void
    */
    public void updDjMtlAkp(DjMtlAkp djMtlAkp) throws Exception;

    /**
    * @Title: getDjMtlAkpByPage
    * @Description: 分页查询
    * @param djMtlAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<DjMtlAkp> getDjMtlAkpByPage(DjMtlAkpVO djMtlAkpVO) throws Exception;

    /**
    * @Title: getDjMtlAkpCount
    * @Description: 获取记录数量
    * @param djMtlAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjMtlAkpCount(DjMtlAkpVO djMtlAkpVO) throws Exception;

    /**
    * @Title: getDjMtlAkp
    * @Description: 根据查询条件查询
    * @param djMtlAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjMtlAkp getDjMtlAkp(DjMtlAkpVO djMtlAkpVO) throws Exception;

}
