package com.service.common.impl;


import com.common.mapper.IDjUserAkpMapper;
import com.common.pojo.DjUserAkp;
import com.common.vo.DjUserAkpVO;
import com.service.common.IDjUserAkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName DjUserAkpServiceImpl
* @Description DjUserAkp业务实现类
* @author Jivoin
*/
@Service("djUserAkpService")
public class DjUserAkpServiceImpl implements IDjUserAkpService{

    @Autowired
    private IDjUserAkpMapper djUserAkpMapper;



    /**
    * @Title: addDjUserAkp
    * @Description: 新增DjUserAkp
    * @param djUserAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void addDjUserAkp(DjUserAkp djUserAkp) throws Exception{
        djUserAkpMapper.addDjUserAkp(djUserAkp);
    }

    /**
    * @Title: delDjUserAkp
    * @Description: 删除DjUserAkp
    * @param djUserAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjUserAkp(DjUserAkp djUserAkp) throws Exception{
        djUserAkpMapper.delDjUserAkp(djUserAkp);
    }

    /**
    * @Title: delDjUserAkpForLogic
    * @Description: 逻辑删除DjUserAkp
    * @param djUserAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjUserAkpForLogic(DjUserAkp djUserAkp) throws Exception{
        djUserAkpMapper.delDjUserAkpForLogic(djUserAkp);
    }

    /**
    * @Title: delDjUserAkpByVo
    * @Description: 根据条件删除DjUserAkp
    * @param djUserAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjUserAkpByVo(DjUserAkpVO djUserAkpVO) throws Exception{
        djUserAkpMapper.delDjUserAkpByVo(djUserAkpVO);
    }

    /**
    * @Title: updDjUserAkp
    * @Description: 动态更新DjUserAkp
    * @param djUserAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void updDjUserAkp(DjUserAkp djUserAkp) throws Exception{
        djUserAkpMapper.updDjUserAkp(djUserAkp);
    }

    /**
    * @Title: getDjUserAkpByPage
    * @Description: 分页查询
    * @param djUserAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<DjUserAkp> getDjUserAkpByPage(DjUserAkpVO djUserAkpVO) throws Exception{
        djUserAkpVO.setTotalPage(djUserAkpMapper.getDjUserAkpCount(djUserAkpVO));
        return djUserAkpMapper.getDjUserAkpByPage(djUserAkpVO);
    }

    /**
    * @Title: getDjUserAkpCount
    * @Description: 获取记录数量
    * @param djUserAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjUserAkpCount(DjUserAkpVO djUserAkpVO) throws Exception{
        return djUserAkpMapper.getDjUserAkpCount(djUserAkpVO);
    }

    /**
    * @Title: getDjUserAkp
    * @Description: 根据查询条件查询
    * @param djUserAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjUserAkp getDjUserAkp(DjUserAkpVO djUserAkpVO) throws Exception{
        return djUserAkpMapper.getDjUserAkp(djUserAkpVO);
    }

}
