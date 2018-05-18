package com.service.common.impl;


import com.common.mapper.IDjOwnerAkpMapper;
import com.common.pojo.DjOwnerAkp;
import com.common.vo.DjOwnerAkpVO;
import com.service.common.IDjOwnerAkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName DjOwnerAkpServiceImpl
* @Description DjOwnerAkp业务实现类
* @author Jivoin
*/
@Service("djOwnerAkpService")
public class DjOwnerAkpServiceImpl implements IDjOwnerAkpService{

    @Autowired
    private IDjOwnerAkpMapper djOwnerAkpMapper;



    /**
    * @Title: addDjOwnerAkp
    * @Description: 新增DjOwnerAkp
    * @param djOwnerAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void addDjOwnerAkp(DjOwnerAkp djOwnerAkp) throws Exception{
        djOwnerAkpMapper.addDjOwnerAkp(djOwnerAkp);
    }

    /**
    * @Title: delDjOwnerAkp
    * @Description: 删除DjOwnerAkp
    * @param djOwnerAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjOwnerAkp(DjOwnerAkp djOwnerAkp) throws Exception{
        djOwnerAkpMapper.delDjOwnerAkp(djOwnerAkp);
    }

    /**
    * @Title: delDjOwnerAkpForLogic
    * @Description: 逻辑删除DjOwnerAkp
    * @param djOwnerAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjOwnerAkpForLogic(DjOwnerAkp djOwnerAkp) throws Exception{
        djOwnerAkpMapper.delDjOwnerAkpForLogic(djOwnerAkp);
    }

    /**
    * @Title: delDjOwnerAkpByVo
    * @Description: 根据条件删除DjOwnerAkp
    * @param djOwnerAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjOwnerAkpByVo(DjOwnerAkpVO djOwnerAkpVO) throws Exception{
        djOwnerAkpMapper.delDjOwnerAkpByVo(djOwnerAkpVO);
    }

    /**
    * @Title: updDjOwnerAkp
    * @Description: 动态更新DjOwnerAkp
    * @param djOwnerAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void updDjOwnerAkp(DjOwnerAkp djOwnerAkp) throws Exception{
        djOwnerAkpMapper.updDjOwnerAkp(djOwnerAkp);
    }

    /**
    * @Title: getDjOwnerAkpByPage
    * @Description: 分页查询
    * @param djOwnerAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<DjOwnerAkp> getDjOwnerAkpByPage(DjOwnerAkpVO djOwnerAkpVO) throws Exception{
        djOwnerAkpVO.setTotalPage(djOwnerAkpMapper.getDjOwnerAkpCount(djOwnerAkpVO));
        return djOwnerAkpMapper.getDjOwnerAkpByPage(djOwnerAkpVO);
    }

    /**
    * @Title: getDjOwnerAkpCount
    * @Description: 获取记录数量
    * @param djOwnerAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjOwnerAkpCount(DjOwnerAkpVO djOwnerAkpVO) throws Exception{
        return djOwnerAkpMapper.getDjOwnerAkpCount(djOwnerAkpVO);
    }

    /**
    * @Title: getDjOwnerAkp
    * @Description: 根据查询条件查询
    * @param djOwnerAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjOwnerAkp getDjOwnerAkp(DjOwnerAkpVO djOwnerAkpVO) throws Exception{
        return djOwnerAkpMapper.getDjOwnerAkp(djOwnerAkpVO);
    }

}
