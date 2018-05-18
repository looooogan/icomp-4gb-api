package com.service.common.impl;


import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.IOutsidefactoryhistoryMapper;
import com.common.mapper.ISharpenProviderMapper;
import com.common.pojo.Outsidefactoryhistory;
import com.common.vo.OutsidefactoryhistoryVO;
import com.service.common.IOutsidefactoryhistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName OutsidefactoryhistoryServiceImpl
* @Description Outsidefactoryhistory业务实现类
* @author Jivoin
*/
@Service("outsidefactoryhistoryService")
public class OutsidefactoryhistoryServiceImpl implements IOutsidefactoryhistoryService{

    @Autowired
    private IOutsidefactoryhistoryMapper outsidefactoryhistoryMapper;

    @Autowired
    private ISharpenProviderMapper sharpenProviderMapper;
    @Autowired
    private ICuttingToolMapper cuttingToolMapper;


    /**
    * @Title: addOutsidefactoryhistory
    * @Description: 新增Outsidefactoryhistory
    * @param outsidefactoryhistory
    * @throws Exception
    * @return: void
    */
    @Override
    public void addOutsidefactoryhistory(Outsidefactoryhistory outsidefactoryhistory) throws Exception{
        outsidefactoryhistoryMapper.addOutsidefactoryhistory(outsidefactoryhistory);
    }

    /**
    * @Title: delOutsidefactoryhistory
    * @Description: 删除Outsidefactoryhistory
    * @param outsidefactoryhistory
    * @throws Exception
    * @return: void
    */
    @Override
    public void delOutsidefactoryhistory(Outsidefactoryhistory outsidefactoryhistory) throws Exception{
        outsidefactoryhistoryMapper.delOutsidefactoryhistory(outsidefactoryhistory);
    }

    /**
    * @Title: delOutsidefactoryhistoryForLogic
    * @Description: 逻辑删除Outsidefactoryhistory
    * @param outsidefactoryhistory
    * @throws Exception
    * @return: void
    */
    @Override
    public void delOutsidefactoryhistoryForLogic(Outsidefactoryhistory outsidefactoryhistory) throws Exception{
        outsidefactoryhistoryMapper.delOutsidefactoryhistoryForLogic(outsidefactoryhistory);
    }

    /**
    * @Title: delOutsidefactoryhistoryByVo
    * @Description: 根据条件删除Outsidefactoryhistory
    * @param outsidefactoryhistoryVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delOutsidefactoryhistoryByVo(OutsidefactoryhistoryVO outsidefactoryhistoryVO) throws Exception{
        outsidefactoryhistoryMapper.delOutsidefactoryhistoryByVo(outsidefactoryhistoryVO);
    }

    /**
    * @Title: updOutsidefactoryhistory
    * @Description: 动态更新Outsidefactoryhistory
    * @param outsidefactoryhistory
    * @throws Exception
    * @return: void
    */
    @Override
    public void updOutsidefactoryhistory(Outsidefactoryhistory outsidefactoryhistory) throws Exception{
        outsidefactoryhistoryMapper.updOutsidefactoryhistory(outsidefactoryhistory);
    }

    /**
    * @Title: getOutsidefactoryhistoryByPage
    * @Description: 分页查询
    * @param outsidefactoryhistoryVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<Outsidefactoryhistory> getOutsidefactoryhistoryByPage(OutsidefactoryhistoryVO outsidefactoryhistoryVO) throws Exception{
        outsidefactoryhistoryVO.setTotalPage(outsidefactoryhistoryMapper.getOutsidefactoryhistoryCount(outsidefactoryhistoryVO));
        return outsidefactoryhistoryMapper.getOutsidefactoryhistoryByPage(outsidefactoryhistoryVO);
    }

    /**
    * @Title: getOutsidefactoryhistoryCount
    * @Description: 获取记录数量
    * @param outsidefactoryhistoryVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getOutsidefactoryhistoryCount(OutsidefactoryhistoryVO outsidefactoryhistoryVO) throws Exception{
        return outsidefactoryhistoryMapper.getOutsidefactoryhistoryCount(outsidefactoryhistoryVO);
    }

    /**
    * @Title: getOutsidefactoryhistory
    * @Description: 根据查询条件查询
    * @param outsidefactoryhistoryVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public Outsidefactoryhistory getOutsidefactoryhistory(OutsidefactoryhistoryVO outsidefactoryhistoryVO) throws Exception{
        return outsidefactoryhistoryMapper.getOutsidefactoryhistory(outsidefactoryhistoryVO);
    }

}
