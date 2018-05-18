package com.service.common;

import com.common.pojo.DjLineAkp;
import com.common.vo.DjLineAkpVO;

import java.util.List;


/**
*
* @ClassName IDjLineAkpService
* @Description DjLineAkp业务接口
* @author Jivoin
*/
public interface IDjLineAkpService {

    /**
    * @Title: addDjLineAkp
    * @Description: 新增DjLineAkp
    * @param djLineAkp
    * @throws Exception
    * @return: void
    */
    public void addDjLineAkp(DjLineAkp djLineAkp) throws Exception;

    /**
    * @Title: delDjLineAkp
    * @Description: 删除DjLineAkp
    * @param djLineAkp
    * @throws Exception
    * @return: void
    */
    public void delDjLineAkp(DjLineAkp djLineAkp) throws Exception;

    /**
    * @Title: delDjLineAkpForLogic
    * @Description: 逻辑删除DjLineAkp
    * @param djLineAkp
    * @throws Exception
    * @return: void
    */
    public void delDjLineAkpForLogic(DjLineAkp djLineAkp) throws Exception;

    /**
    * @Title: delDjLineAkpByVo
    * @Description: 根据条件删除DjLineAkp
    * @param djLineAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delDjLineAkpByVo(DjLineAkpVO djLineAkpVO) throws Exception;

    /**
    * @Title: updDjLineAkp
    * @Description: 动态更新DjLineAkp
    * @param djLineAkp
    * @throws Exception
    * @return: void
    */
    public void updDjLineAkp(DjLineAkp djLineAkp) throws Exception;

    /**
    * @Title: getDjLineAkpByPage
    * @Description: 分页查询
    * @param djLineAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<DjLineAkp> getDjLineAkpByPage(DjLineAkpVO djLineAkpVO) throws Exception;

    /**
    * @Title: getDjLineAkpCount
    * @Description: 获取记录数量
    * @param djLineAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjLineAkpCount(DjLineAkpVO djLineAkpVO) throws Exception;

    /**
    * @Title: getDjLineAkp
    * @Description: 根据查询条件查询
    * @param djLineAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjLineAkp getDjLineAkp(DjLineAkpVO djLineAkpVO) throws Exception;

}
