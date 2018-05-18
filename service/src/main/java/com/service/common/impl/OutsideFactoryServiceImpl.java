package com.service.common.impl;


import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.IOutsideFactoryMapper;
import com.common.mapper.ISharpenProviderMapper;
import com.common.pojo.OutsideFactory;
import com.common.vo.OutsideFactoryVO;
import com.service.common.IOutsideFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName OutsideFactoryServiceImpl
* @Description OutsideFactory业务实现类
* @author Jivoin
*/
@Service("outsideFactoryService")
public class OutsideFactoryServiceImpl implements IOutsideFactoryService{

    @Autowired
    private IOutsideFactoryMapper outsideFactoryMapper;

    @Autowired
    private ISharpenProviderMapper sharpenProviderMapper;
    @Autowired
    private ICuttingToolMapper cuttingToolMapper;


    /**
    * @Title: addOutsideFactory
    * @Description: 新增OutsideFactory
    * @param outsideFactory
    * @throws Exception
    * @return: void
    */
    @Override
    public void addOutsideFactory(OutsideFactory outsideFactory) throws Exception{
        outsideFactoryMapper.addOutsideFactory(outsideFactory);
    }

    /**
    * @Title: delOutsideFactory
    * @Description: 删除OutsideFactory
    * @param outsideFactory
    * @throws Exception
    * @return: void
    */
    @Override
    public void delOutsideFactory(OutsideFactory outsideFactory) throws Exception{
        outsideFactoryMapper.delOutsideFactory(outsideFactory);
    }

    /**
    * @Title: delOutsideFactoryForLogic
    * @Description: 逻辑删除OutsideFactory
    * @param outsideFactory
    * @throws Exception
    * @return: void
    */
    @Override
    public void delOutsideFactoryForLogic(OutsideFactory outsideFactory) throws Exception{
        outsideFactoryMapper.delOutsideFactoryForLogic(outsideFactory);
    }

    /**
    * @Title: delOutsideFactoryByVo
    * @Description: 根据条件删除OutsideFactory
    * @param outsideFactoryVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delOutsideFactoryByVo(OutsideFactoryVO outsideFactoryVO) throws Exception{
        outsideFactoryMapper.delOutsideFactoryByVo(outsideFactoryVO);
    }

    /**
    * @Title: updOutsideFactory
    * @Description: 动态更新OutsideFactory
    * @param outsideFactory
    * @throws Exception
    * @return: void
    */
    @Override
    public void updOutsideFactory(OutsideFactory outsideFactory) throws Exception{
        outsideFactoryMapper.updOutsideFactory(outsideFactory);
    }

    /**
    * @Title: getOutsideFactoryByPage
    * @Description: 分页查询
    * @param outsideFactoryVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<OutsideFactory> getOutsideFactoryByPage(OutsideFactoryVO outsideFactoryVO) throws Exception{
        outsideFactoryVO.setTotalPage(outsideFactoryMapper.getOutsideFactoryCount(outsideFactoryVO));
        return outsideFactoryMapper.getOutsideFactoryByPage(outsideFactoryVO);
    }

    /**
    * @Title: getOutsideFactoryCount
    * @Description: 获取记录数量
    * @param outsideFactoryVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getOutsideFactoryCount(OutsideFactoryVO outsideFactoryVO) throws Exception{
        return outsideFactoryMapper.getOutsideFactoryCount(outsideFactoryVO);
    }

    /**
    * @Title: getOutsideFactory
    * @Description: 根据查询条件查询
    * @param outsideFactoryVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public OutsideFactory getOutsideFactory(OutsideFactoryVO outsideFactoryVO) throws Exception{
        return outsideFactoryMapper.getOutsideFactory(outsideFactoryVO);
    }

}
