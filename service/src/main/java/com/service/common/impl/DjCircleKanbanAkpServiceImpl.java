package com.service.common.impl;


import com.common.mapper.IDjCircleKanbanAkpMapper;
import com.common.pojo.DjCircleKanbanAkp;
import com.common.vo.DjCircleKanbanAkpVO;
import com.service.common.IDjCircleKanbanAkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName DjCircleKanbanAkpServiceImpl
* @Description DjCircleKanbanAkp业务实现类
* @author Jivoin
*/
@Service("djCircleKanbanAkpService")
public class DjCircleKanbanAkpServiceImpl implements IDjCircleKanbanAkpService{

    @Autowired
    private IDjCircleKanbanAkpMapper djCircleKanbanAkpMapper;



    /**
    * @Title: addDjCircleKanbanAkp
    * @Description: 新增DjCircleKanbanAkp
    * @param djCircleKanbanAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void addDjCircleKanbanAkp(DjCircleKanbanAkp djCircleKanbanAkp) throws Exception{
        djCircleKanbanAkpMapper.addDjCircleKanbanAkp(djCircleKanbanAkp);
    }

    /**
    * @Title: delDjCircleKanbanAkp
    * @Description: 删除DjCircleKanbanAkp
    * @param djCircleKanbanAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjCircleKanbanAkp(DjCircleKanbanAkp djCircleKanbanAkp) throws Exception{
        djCircleKanbanAkpMapper.delDjCircleKanbanAkp(djCircleKanbanAkp);
    }

    /**
    * @Title: delDjCircleKanbanAkpForLogic
    * @Description: 逻辑删除DjCircleKanbanAkp
    * @param djCircleKanbanAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjCircleKanbanAkpForLogic(DjCircleKanbanAkp djCircleKanbanAkp) throws Exception{
        djCircleKanbanAkpMapper.delDjCircleKanbanAkpForLogic(djCircleKanbanAkp);
    }

    /**
    * @Title: delDjCircleKanbanAkpByVo
    * @Description: 根据条件删除DjCircleKanbanAkp
    * @param djCircleKanbanAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjCircleKanbanAkpByVo(DjCircleKanbanAkpVO djCircleKanbanAkpVO) throws Exception{
        djCircleKanbanAkpMapper.delDjCircleKanbanAkpByVo(djCircleKanbanAkpVO);
    }

    /**
    * @Title: updDjCircleKanbanAkp
    * @Description: 动态更新DjCircleKanbanAkp
    * @param djCircleKanbanAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void updDjCircleKanbanAkp(DjCircleKanbanAkp djCircleKanbanAkp) throws Exception{
        djCircleKanbanAkpMapper.updDjCircleKanbanAkp(djCircleKanbanAkp);
    }

    /**
    * @Title: getDjCircleKanbanAkpByPage
    * @Description: 分页查询
    * @param djCircleKanbanAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<DjCircleKanbanAkp> getDjCircleKanbanAkpByPage(DjCircleKanbanAkpVO djCircleKanbanAkpVO) throws Exception{
        djCircleKanbanAkpVO.setTotalPage(djCircleKanbanAkpMapper.getDjCircleKanbanAkpCount(djCircleKanbanAkpVO));
        return djCircleKanbanAkpMapper.getDjCircleKanbanAkpByPage(djCircleKanbanAkpVO);
    }

    /**
    * @Title: getDjCircleKanbanAkpCount
    * @Description: 获取记录数量
    * @param djCircleKanbanAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjCircleKanbanAkpCount(DjCircleKanbanAkpVO djCircleKanbanAkpVO) throws Exception{
        return djCircleKanbanAkpMapper.getDjCircleKanbanAkpCount(djCircleKanbanAkpVO);
    }

    /**
    * @Title: getDjCircleKanbanAkp
    * @Description: 根据查询条件查询
    * @param djCircleKanbanAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjCircleKanbanAkp getDjCircleKanbanAkp(DjCircleKanbanAkpVO djCircleKanbanAkpVO) throws Exception{
        return djCircleKanbanAkpMapper.getDjCircleKanbanAkp(djCircleKanbanAkpVO);
    }

}
