package com.common.mapper;

import com.common.pojo.DjItrnAkp;
import com.common.vo.DjItrnAkpVO;

import java.util.List;


/**
*
* @ClassName IDjItrnAkpMapper
* @Description TODO
* @author Jivoin
*/
public interface IDjItrnAkpMapper {

    /**
    * @Title: addDjItrnAkp
    * @Description: 新增DjItrnAkp
    * @param djItrnAkp
    * @throws Exception
    * @return: void
    */
    public void addDjItrnAkp(DjItrnAkp djItrnAkp) throws Exception;

    /**
    * @Title: delDjItrnAkp
    * @Description: 删除DjItrnAkp
    * @param djItrnAkp
    * @throws Exception
    * @return: void
    */
    public void delDjItrnAkp(DjItrnAkp djItrnAkp) throws Exception;

    /**
    * @Title: delDjItrnAkpForLogic
    * @Description: 逻辑删除DjItrnAkp
    * @param djItrnAkp
    * @throws Exception
    * @return: void
    */
    public void delDjItrnAkpForLogic(DjItrnAkp djItrnAkp) throws Exception;

    /**
    * @Title: delDjItrnAkpByVo
    * @Description: 根据条件删除DjItrnAkp
    * @param djItrnAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delDjItrnAkpByVo(DjItrnAkpVO djItrnAkpVO) throws Exception;

    /**
    * @Title: updDjItrnAkp
    * @Description: 动态更新DjItrnAkp
    * @param djItrnAkp
    * @throws Exception
    * @return: void
    */
    public void updDjItrnAkp(DjItrnAkp djItrnAkp) throws Exception;

    /**
    * @Title: getDjItrnAkpByPage
    * @Description: 分页查询
    * @param djItrnAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<DjItrnAkp> getDjItrnAkpByPage(DjItrnAkpVO djItrnAkpVO) throws Exception;

    /**
    * @Title: getDjItrnAkpCount
    * @Description: 获取记录数量
    * @param djItrnAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjItrnAkpCount(DjItrnAkpVO djItrnAkpVO) throws Exception;

    /**
    * @Title: getDjItrnAkp
    * @Description: 根据查询条件查询
    * @param djItrnAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjItrnAkp getDjItrnAkp(DjItrnAkpVO djItrnAkpVO) throws Exception;

    /**
     * @Title: 获取最后一条记录
     * @Description: 根据查询条件查询
     * @param djItrnAkpVO 查询条件封装
     * @throws Exception
     * @return: 查询结果
     */
    public DjItrnAkp getLast(DjItrnAkpVO djItrnAkpVO) throws Exception;

    /**
     * @Title: 获取最大批次
     * @Description:
     * @throws Exception
     * @return: 查询结果
     */
    public Integer getMaxBatchNo() throws Exception;

    /**
     * @Title: 获取最大外委单据号
     * @Description:
     * @throws Exception
     * @return: 查询结果
     */
    public String getMaxWWOrderNum() throws Exception;

}
