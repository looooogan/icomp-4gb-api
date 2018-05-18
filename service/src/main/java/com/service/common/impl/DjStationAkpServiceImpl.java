package com.service.common.impl;


import com.common.mapper.IDjStationAkpMapper;
import com.common.pojo.DjStationAkp;
import com.common.vo.DjStationAkpVO;
import com.service.common.IDjStationAkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName DjStationAkpServiceImpl
* @Description DjStationAkp业务实现类
* @author Jivoin
*/
@Service("djStationAkpService")
public class DjStationAkpServiceImpl implements IDjStationAkpService{

    @Autowired
    private IDjStationAkpMapper djStationAkpMapper;



    /**
    * @Title: addDjStationAkp
    * @Description: 新增DjStationAkp
    * @param djStationAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void addDjStationAkp(DjStationAkp djStationAkp) throws Exception{
        djStationAkpMapper.addDjStationAkp(djStationAkp);
    }

    /**
    * @Title: delDjStationAkp
    * @Description: 删除DjStationAkp
    * @param djStationAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjStationAkp(DjStationAkp djStationAkp) throws Exception{
        djStationAkpMapper.delDjStationAkp(djStationAkp);
    }

    /**
    * @Title: delDjStationAkpForLogic
    * @Description: 逻辑删除DjStationAkp
    * @param djStationAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjStationAkpForLogic(DjStationAkp djStationAkp) throws Exception{
        djStationAkpMapper.delDjStationAkpForLogic(djStationAkp);
    }

    /**
    * @Title: delDjStationAkpByVo
    * @Description: 根据条件删除DjStationAkp
    * @param djStationAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjStationAkpByVo(DjStationAkpVO djStationAkpVO) throws Exception{
        djStationAkpMapper.delDjStationAkpByVo(djStationAkpVO);
    }

    /**
    * @Title: updDjStationAkp
    * @Description: 动态更新DjStationAkp
    * @param djStationAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void updDjStationAkp(DjStationAkp djStationAkp) throws Exception{
        djStationAkpMapper.updDjStationAkp(djStationAkp);
    }

    /**
    * @Title: getDjStationAkpByPage
    * @Description: 分页查询
    * @param djStationAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<DjStationAkp> getDjStationAkpByPage(DjStationAkpVO djStationAkpVO) throws Exception{
        djStationAkpVO.setTotalPage(djStationAkpMapper.getDjStationAkpCount(djStationAkpVO));
        return djStationAkpMapper.getDjStationAkpByPage(djStationAkpVO);
    }

    /**
    * @Title: getDjStationAkpCount
    * @Description: 获取记录数量
    * @param djStationAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjStationAkpCount(DjStationAkpVO djStationAkpVO) throws Exception{
        return djStationAkpMapper.getDjStationAkpCount(djStationAkpVO);
    }

    /**
    * @Title: getDjStationAkp
    * @Description: 根据查询条件查询
    * @param djStationAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjStationAkp getDjStationAkp(DjStationAkpVO djStationAkpVO) throws Exception{
        return djStationAkpMapper.getDjStationAkp(djStationAkpVO);
    }

}
