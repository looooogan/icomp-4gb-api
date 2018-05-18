package com.service.common.impl;


import com.common.mapper.IDjItrnAkpMapper;
import com.common.pojo.DjItrnAkp;
import com.common.vo.DjItrnAkpVO;
import com.service.common.IDjItrnAkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName DjItrnAkpServiceImpl
* @Description DjItrnAkp业务实现类
* @author Jivoin
*/
@Service("djItrnAkpService")
public class DjItrnAkpServiceImpl implements IDjItrnAkpService{

    @Autowired
    private IDjItrnAkpMapper djItrnAkpMapper;



    /**
    * @Title: addDjItrnAkp
    * @Description: 新增DjItrnAkp
    * @param djItrnAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void addDjItrnAkp(DjItrnAkp djItrnAkp) throws Exception{
        djItrnAkpMapper.addDjItrnAkp(djItrnAkp);
    }

    /**
    * @Title: delDjItrnAkp
    * @Description: 删除DjItrnAkp
    * @param djItrnAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjItrnAkp(DjItrnAkp djItrnAkp) throws Exception{
        djItrnAkpMapper.delDjItrnAkp(djItrnAkp);
    }

    /**
    * @Title: delDjItrnAkpForLogic
    * @Description: 逻辑删除DjItrnAkp
    * @param djItrnAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjItrnAkpForLogic(DjItrnAkp djItrnAkp) throws Exception{
        djItrnAkpMapper.delDjItrnAkpForLogic(djItrnAkp);
    }

    /**
    * @Title: delDjItrnAkpByVo
    * @Description: 根据条件删除DjItrnAkp
    * @param djItrnAkpVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delDjItrnAkpByVo(DjItrnAkpVO djItrnAkpVO) throws Exception{
        djItrnAkpMapper.delDjItrnAkpByVo(djItrnAkpVO);
    }

    /**
    * @Title: updDjItrnAkp
    * @Description: 动态更新DjItrnAkp
    * @param djItrnAkp
    * @throws Exception
    * @return: void
    */
    @Override
    public void updDjItrnAkp(DjItrnAkp djItrnAkp) throws Exception{
        djItrnAkpMapper.updDjItrnAkp(djItrnAkp);
    }

    /**
    * @Title: getDjItrnAkpByPage
    * @Description: 分页查询
    * @param djItrnAkpVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<DjItrnAkp> getDjItrnAkpByPage(DjItrnAkpVO djItrnAkpVO) throws Exception{
        djItrnAkpVO.setTotalPage(djItrnAkpMapper.getDjItrnAkpCount(djItrnAkpVO));
        return djItrnAkpMapper.getDjItrnAkpByPage(djItrnAkpVO);
    }

    /**
    * @Title: getDjItrnAkpCount
    * @Description: 获取记录数量
    * @param djItrnAkpVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getDjItrnAkpCount(DjItrnAkpVO djItrnAkpVO) throws Exception{
        return djItrnAkpMapper.getDjItrnAkpCount(djItrnAkpVO);
    }

    /**
    * @Title: getDjItrnAkp
    * @Description: 根据查询条件查询
    * @param djItrnAkpVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public DjItrnAkp getDjItrnAkp(DjItrnAkpVO djItrnAkpVO) throws Exception{
        return djItrnAkpMapper.getDjItrnAkp(djItrnAkpVO);
    }

    /**
     * @Title: 获取最后一条记录
     * @Description: 根据查询条件查询
     * @param djItrnAkpVO 查询条件封装
     * @throws Exception
     * @return: 查询结果
     */
    @Override
    public DjItrnAkp getLast(DjItrnAkpVO djItrnAkpVO) throws Exception {
        return djItrnAkpMapper.getLast(djItrnAkpVO);
    }



    @Override
    public Integer getMaxBatchNo() throws Exception {
        return djItrnAkpMapper.getMaxBatchNo();
    }

    @Override
    public String getMaxWWOrderNum() throws Exception {
        return djItrnAkpMapper.getMaxWWOrderNum();
    }

}
