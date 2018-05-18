package com.service.common.impl;


import com.common.mapper.IDjLineAkpMapper;
import com.common.pojo.DjLineAkp;
import com.common.vo.DjLineAkpVO;
import com.service.common.IDjLineAkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName DjLineAkpServiceImpl
* @Description DjLineAkp业务实现类
* @author Jivoin
*/
@Service("djLineAkpService")
public class DjLineAkpServiceImpl implements IDjLineAkpService{

    @Autowired
    private IDjLineAkpMapper djLineAkpMapper;



    /**
    * @Title: addDjLineAkp
    * @Description: 新增DjLineAkp
    * @param djLineAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void addDjLineAkp(DjLineAkp djLineAkp) throws Exception{
        djLineAkpMapper.addDjLineAkp(djLineAkp);
    }

    /**
    * @Title: delDjLineAkp
    * @Description: 删除DjLineAkp
    * @param djLineAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjLineAkp(DjLineAkp djLineAkp) throws Exception{
        djLineAkpMapper.delDjLineAkp(djLineAkp);
    }

    /**
    * @Title: delDjLineAkpForLogic
    * @Description: 逻辑删除DjLineAkp
    * @param djLineAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjLineAkpForLogic(DjLineAkp djLineAkp) throws Exception{
        djLineAkpMapper.delDjLineAkpForLogic(djLineAkp);
    }

    /**
    * @Title: delDjLineAkpByVo
    * @Description: 根据条件删除DjLineAkp
    * @param djLineAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjLineAkpByVo(DjLineAkpVO djLineAkpVO) throws Exception{
        djLineAkpMapper.delDjLineAkpByVo(djLineAkpVO);
    }

    /**
    * @Title: updDjLineAkp
    * @Description: 动态更新DjLineAkp
    * @param djLineAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void updDjLineAkp(DjLineAkp djLineAkp) throws Exception{
        djLineAkpMapper.updDjLineAkp(djLineAkp);
    }

    /**
    * @Title: getDjLineAkpByPage
    * @Description: 分页查询
    * @param djLineAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<DjLineAkp> getDjLineAkpByPage(DjLineAkpVO djLineAkpVO) throws Exception{
        djLineAkpVO.setTotalPage(djLineAkpMapper.getDjLineAkpCount(djLineAkpVO));
        return djLineAkpMapper.getDjLineAkpByPage(djLineAkpVO);
    }

    /**
    * @Title: getDjLineAkpCount
    * @Description: 获取记录数量
    * @param djLineAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjLineAkpCount(DjLineAkpVO djLineAkpVO) throws Exception{
        return djLineAkpMapper.getDjLineAkpCount(djLineAkpVO);
    }

    /**
    * @Title: getDjLineAkp
    * @Description: 根据查询条件查询
    * @param djLineAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjLineAkp getDjLineAkp(DjLineAkpVO djLineAkpVO) throws Exception{
        return djLineAkpMapper.getDjLineAkp(djLineAkpVO);
    }

}
