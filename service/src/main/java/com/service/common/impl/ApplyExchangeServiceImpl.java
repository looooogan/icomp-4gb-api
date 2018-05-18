package com.service.common.impl;


import com.common.mapper.IApplyExchangeMapper;
import com.common.pojo.ApplyExchange;
import com.common.vo.ApplyExchangeVO;
import com.service.common.IApplyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName ApplyExchangeServiceImpl
* @Description ApplyExchange业务实现类
* @author Jivoin
*/
@Service("applyExchangeService")
public class ApplyExchangeServiceImpl implements IApplyExchangeService{

    @Autowired
    private IApplyExchangeMapper applyExchangeMapper;



    /**
    * @Title: addApplyExchange
    * @Description: 新增ApplyExchange
    * @param applyExchange
    * @throws Exception
    * @return: void
    */
    @Override
    public void addApplyExchange(ApplyExchange applyExchange) throws Exception{
        applyExchangeMapper.addApplyExchange(applyExchange);
    }

    /**
    * @Title: delApplyExchange
    * @Description: 删除ApplyExchange
    * @param applyExchange
    * @throws Exception
    * @return: void
    */
    @Override
    public void delApplyExchange(ApplyExchange applyExchange) throws Exception{
//        applyExchangeMapper.delApplyExchange(applyExchange);
    }

    /**
    * @Title: delApplyExchangeForLogic
    * @Description: 逻辑删除ApplyExchange
    * @param applyExchange
    * @throws Exception
    * @return: void
    */
    @Override
    public void delApplyExchangeForLogic(ApplyExchange applyExchange) throws Exception{
//        applyExchangeMapper.delApplyExchangeForLogic(applyExchange);
    }

    /**
    * @Title: delApplyExchangeByVo
    * @Description: 根据条件删除ApplyExchange
    * @param applyExchangeVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delApplyExchangeByVo(ApplyExchangeVO applyExchangeVO) throws Exception{
//        applyExchangeMapper.delApplyExchangeByVo(applyExchangeVO);
    }

    /**
    * @Title: updApplyExchange
    * @Description: 动态更新ApplyExchange
    * @param applyExchange
    * @throws Exception
    * @return: void
    */
    @Override
    public void updApplyExchange(ApplyExchange applyExchange) throws Exception{
//        applyExchangeMapper.updApplyExchange(applyExchange);
    }

    /**
    * @Title: getApplyExchangeByPage
    * @Description: 分页查询
    * @param applyExchangeVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<ApplyExchange> getApplyExchangeByPage(ApplyExchangeVO applyExchangeVO) throws Exception{
//        applyExchangeVO.setTotalPage(applyExchangeMapper.getApplyExchangeCount(applyExchangeVO));
//        return applyExchangeMapper.getApplyExchangeByPage(applyExchangeVO);
        return null;
    }

    /**
    * @Title: getApplyExchangeCount
    * @Description: 获取记录数量
    * @param applyExchangeVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getApplyExchangeCount(ApplyExchangeVO applyExchangeVO) throws Exception{
//        return applyExchangeMapper.getApplyExchangeCount(applyExchangeVO);
        return 0;
    }

    /**
    * @Title: getApplyExchange
    * @Description: 根据查询条件查询
    * @param applyExchangeVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ApplyExchange getApplyExchange(ApplyExchangeVO applyExchangeVO) throws Exception{
//        return applyExchangeMapper.getApplyExchange(applyExchangeVO);
        return null;
    }

}
