package com.service.common.impl;


import com.common.mapper.IDjOutapplyAkpMapper;
import com.common.pojo.DjOutapplyAkp;
import com.common.vo.DjOutapplyAkpVO;
import com.service.common.IDjOutapplyAkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName DjOutapplyAkpServiceImpl
* @Description DjOutapplyAkp业务实现类
* @author Jivoin
*/
@Service("djOutapplyAkpService")
public class DjOutapplyAkpServiceImpl implements IDjOutapplyAkpService{

    @Autowired
    private IDjOutapplyAkpMapper djOutapplyAkpMapper;



    /**
    * @Title: addDjOutapplyAkp
    * @Description: 新增DjOutapplyAkp
    * @param djOutapplyAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void addDjOutapplyAkp(DjOutapplyAkp djOutapplyAkp) throws Exception{
        djOutapplyAkpMapper.addDjOutapplyAkp(djOutapplyAkp);
    }

    /**
    * @Title: delDjOutapplyAkp
    * @Description: 删除DjOutapplyAkp
    * @param djOutapplyAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjOutapplyAkp(DjOutapplyAkp djOutapplyAkp) throws Exception{
        djOutapplyAkpMapper.delDjOutapplyAkp(djOutapplyAkp);
    }

    /**
    * @Title: delDjOutapplyAkpForLogic
    * @Description: 逻辑删除DjOutapplyAkp
    * @param djOutapplyAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjOutapplyAkpForLogic(DjOutapplyAkp djOutapplyAkp) throws Exception{
        djOutapplyAkpMapper.delDjOutapplyAkpForLogic(djOutapplyAkp);
    }

    /**
    * @Title: delDjOutapplyAkpByVo
    * @Description: 根据条件删除DjOutapplyAkp
    * @param djOutapplyAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjOutapplyAkpByVo(DjOutapplyAkpVO djOutapplyAkpVO) throws Exception{
        djOutapplyAkpMapper.delDjOutapplyAkpByVo(djOutapplyAkpVO);
    }

    /**
    * @Title: updDjOutapplyAkp
    * @Description: 动态更新DjOutapplyAkp
    * @param djOutapplyAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void updDjOutapplyAkp(DjOutapplyAkp djOutapplyAkp) throws Exception{
        djOutapplyAkpMapper.updDjOutapplyAkp(djOutapplyAkp);
    }

    /**
    * @Title: getDjOutapplyAkpByPage
    * @Description: 分页查询
    * @param djOutapplyAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<DjOutapplyAkp> getDjOutapplyAkpByPage(DjOutapplyAkpVO djOutapplyAkpVO) throws Exception{
        djOutapplyAkpVO.setTotalPage(djOutapplyAkpMapper.getDjOutapplyAkpCount(djOutapplyAkpVO));
        return djOutapplyAkpMapper.getDjOutapplyAkpByPage(djOutapplyAkpVO);
    }

    /**
    * @Title: getDjOutapplyAkpCount
    * @Description: 获取记录数量
    * @param djOutapplyAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjOutapplyAkpCount(DjOutapplyAkpVO djOutapplyAkpVO) throws Exception{
        return djOutapplyAkpMapper.getDjOutapplyAkpCount(djOutapplyAkpVO);
    }

    /**
    * @Title: getDjOutapplyAkp
    * @Description: 根据查询条件查询
    * @param djOutapplyAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjOutapplyAkp getDjOutapplyAkp(DjOutapplyAkpVO djOutapplyAkpVO) throws Exception{
        return djOutapplyAkpMapper.getDjOutapplyAkp(djOutapplyAkpVO);
    }

}
