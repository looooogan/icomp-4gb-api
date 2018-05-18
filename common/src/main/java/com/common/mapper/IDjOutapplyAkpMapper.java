package com.common.mapper;

import com.common.pojo.DjOutapplyAkp;
import com.common.vo.DjOutapplyAkpVO;

import java.util.List;


/**
*
* @ClassName IDjOutapplyAkpMapper
* @Description TODO
* @author Jivoin
*/
public interface IDjOutapplyAkpMapper {

    /**
    * @Title: addDjOutapplyAkp
    * @Description: 新增DjOutapplyAkp
    * @param djOutapplyAkp
    * @throws Exception
    * @return: void
    */
    public void addDjOutapplyAkp(DjOutapplyAkp djOutapplyAkp) throws Exception;

    /**
    * @Title: delDjOutapplyAkp
    * @Description: 删除DjOutapplyAkp
    * @param djOutapplyAkp
    * @throws Exception
    * @return: void
    */
    public void delDjOutapplyAkp(DjOutapplyAkp djOutapplyAkp) throws Exception;

    /**
    * @Title: delDjOutapplyAkpForLogic
    * @Description: 逻辑删除DjOutapplyAkp
    * @param djOutapplyAkp
    * @throws Exception
    * @return: void
    */
    public void delDjOutapplyAkpForLogic(DjOutapplyAkp djOutapplyAkp) throws Exception;

    /**
    * @Title: delDjOutapplyAkpByVo
    * @Description: 根据条件删除DjOutapplyAkp
    * @param djOutapplyAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delDjOutapplyAkpByVo(DjOutapplyAkpVO djOutapplyAkpVO) throws Exception;

    /**
    * @Title: updDjOutapplyAkp
    * @Description: 动态更新DjOutapplyAkp
    * @param djOutapplyAkp
    * @throws Exception
    * @return: void
    */
    public void updDjOutapplyAkp(DjOutapplyAkp djOutapplyAkp) throws Exception;

    /**
    * @Title: getDjOutapplyAkpByPage
    * @Description: 分页查询
    * @param djOutapplyAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<DjOutapplyAkp> getDjOutapplyAkpByPage(DjOutapplyAkpVO djOutapplyAkpVO) throws Exception;

    /**
    * @Title: getDjOutapplyAkpCount
    * @Description: 获取记录数量
    * @param djOutapplyAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjOutapplyAkpCount(DjOutapplyAkpVO djOutapplyAkpVO) throws Exception;

    /**
    * @Title: getDjOutapplyAkp
    * @Description: 根据查询条件查询
    * @param djOutapplyAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjOutapplyAkp getDjOutapplyAkp(DjOutapplyAkpVO djOutapplyAkpVO) throws Exception;

}
