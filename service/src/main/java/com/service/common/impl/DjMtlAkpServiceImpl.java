package com.service.common.impl;


import com.common.mapper.IDjMtlAkpMapper;
import com.common.pojo.DjMtlAkp;
import com.common.vo.DjMtlAkpVO;
import com.service.common.IDjMtlAkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName DjMtlAkpServiceImpl
* @Description DjMtlAkp业务实现类
* @author Jivoin
*/
@Service("djMtlAkpService")
public class DjMtlAkpServiceImpl implements IDjMtlAkpService{

    @Autowired
    private IDjMtlAkpMapper djMtlAkpMapper;



    /**
    * @Title: addDjMtlAkp
    * @Description: 新增DjMtlAkp
    * @param djMtlAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void addDjMtlAkp(DjMtlAkp djMtlAkp) throws Exception{
        djMtlAkpMapper.addDjMtlAkp(djMtlAkp);
    }

    /**
    * @Title: delDjMtlAkp
    * @Description: 删除DjMtlAkp
    * @param djMtlAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjMtlAkp(DjMtlAkp djMtlAkp) throws Exception{
        djMtlAkpMapper.delDjMtlAkp(djMtlAkp);
    }

    /**
    * @Title: delDjMtlAkpForLogic
    * @Description: 逻辑删除DjMtlAkp
    * @param djMtlAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjMtlAkpForLogic(DjMtlAkp djMtlAkp) throws Exception{
        djMtlAkpMapper.delDjMtlAkpForLogic(djMtlAkp);
    }

    /**
    * @Title: delDjMtlAkpByVo
    * @Description: 根据条件删除DjMtlAkp
    * @param djMtlAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjMtlAkpByVo(DjMtlAkpVO djMtlAkpVO) throws Exception{
        djMtlAkpMapper.delDjMtlAkpByVo(djMtlAkpVO);
    }

    /**
    * @Title: updDjMtlAkp
    * @Description: 动态更新DjMtlAkp
    * @param djMtlAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void updDjMtlAkp(DjMtlAkp djMtlAkp) throws Exception{
        djMtlAkpMapper.updDjMtlAkp(djMtlAkp);
    }

    /**
    * @Title: getDjMtlAkpByPage
    * @Description: 分页查询
    * @param djMtlAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<DjMtlAkp> getDjMtlAkpByPage(DjMtlAkpVO djMtlAkpVO) throws Exception{
        djMtlAkpVO.setTotalPage(djMtlAkpMapper.getDjMtlAkpCount(djMtlAkpVO));
        return djMtlAkpMapper.getDjMtlAkpByPage(djMtlAkpVO);
    }

    /**
    * @Title: getDjMtlAkpCount
    * @Description: 获取记录数量
    * @param djMtlAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjMtlAkpCount(DjMtlAkpVO djMtlAkpVO) throws Exception{
        return djMtlAkpMapper.getDjMtlAkpCount(djMtlAkpVO);
    }

    /**
    * @Title: getDjMtlAkp
    * @Description: 根据查询条件查询
    * @param djMtlAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjMtlAkp getDjMtlAkp(DjMtlAkpVO djMtlAkpVO) throws Exception{
        return djMtlAkpMapper.getDjMtlAkp(djMtlAkpVO);
    }

}
