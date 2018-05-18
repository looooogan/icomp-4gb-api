package com.service.common;

import com.common.pojo.DjCircleKanbanAkp;
import com.common.vo.DjCircleKanbanAkpVO;

import java.util.List;


/**
*
* @ClassName IDjCircleKanbanAkpService
* @Description DjCircleKanbanAkp业务接口
* @author Jivoin
*/
public interface IDjCircleKanbanAkpService {

    /**
    * @Title: addDjCircleKanbanAkp
    * @Description: 新增DjCircleKanbanAkp
    * @param djCircleKanbanAkp
    * @throws Exception
    * @return: void
    */
    public void addDjCircleKanbanAkp(DjCircleKanbanAkp djCircleKanbanAkp) throws Exception;

    /**
    * @Title: delDjCircleKanbanAkp
    * @Description: 删除DjCircleKanbanAkp
    * @param djCircleKanbanAkp
    * @throws Exception
    * @return: void
    */
    public void delDjCircleKanbanAkp(DjCircleKanbanAkp djCircleKanbanAkp) throws Exception;

    /**
    * @Title: delDjCircleKanbanAkpForLogic
    * @Description: 逻辑删除DjCircleKanbanAkp
    * @param djCircleKanbanAkp
    * @throws Exception
    * @return: void
    */
    public void delDjCircleKanbanAkpForLogic(DjCircleKanbanAkp djCircleKanbanAkp) throws Exception;

    /**
    * @Title: delDjCircleKanbanAkpByVo
    * @Description: 根据条件删除DjCircleKanbanAkp
    * @param djCircleKanbanAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delDjCircleKanbanAkpByVo(DjCircleKanbanAkpVO djCircleKanbanAkpVO) throws Exception;

    /**
    * @Title: updDjCircleKanbanAkp
    * @Description: 动态更新DjCircleKanbanAkp
    * @param djCircleKanbanAkp
    * @throws Exception
    * @return: void
    */
    public void updDjCircleKanbanAkp(DjCircleKanbanAkp djCircleKanbanAkp) throws Exception;

    /**
    * @Title: getDjCircleKanbanAkpByPage
    * @Description: 分页查询
    * @param djCircleKanbanAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<DjCircleKanbanAkp> getDjCircleKanbanAkpByPage(DjCircleKanbanAkpVO djCircleKanbanAkpVO) throws Exception;

    /**
    * @Title: getDjCircleKanbanAkpCount
    * @Description: 获取记录数量
    * @param djCircleKanbanAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjCircleKanbanAkpCount(DjCircleKanbanAkpVO djCircleKanbanAkpVO) throws Exception;

    /**
    * @Title: getDjCircleKanbanAkp
    * @Description: 根据查询条件查询
    * @param djCircleKanbanAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjCircleKanbanAkp getDjCircleKanbanAkp(DjCircleKanbanAkpVO djCircleKanbanAkpVO) throws Exception;

}
