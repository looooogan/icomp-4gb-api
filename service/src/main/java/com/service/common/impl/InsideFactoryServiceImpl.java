package com.service.common.impl;


import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.IInsideFactoryMapper;
import com.common.pojo.InsideFactory;
import com.common.vo.InsideFactoryVO;
import com.service.common.IInsideFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName InsideFactoryServiceImpl
* @Description InsideFactory业务实现类
* @author Jivoin
*/
@Service("insideFactoryService")
public class InsideFactoryServiceImpl implements IInsideFactoryService{

    @Autowired
    private IInsideFactoryMapper insideFactoryMapper;

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;


    /**
    * @Title: addInsideFactory
    * @Description: 新增InsideFactory
    * @param insideFactory
    * @throws Exception
    * @return: void
    */
    @Override
    public void addInsideFactory(InsideFactory insideFactory) throws Exception{
        insideFactoryMapper.addInsideFactory(insideFactory);
    }

    /**
    * @Title: delInsideFactory
    * @Description: 删除InsideFactory
    * @param insideFactory
    * @throws Exception
    * @return: void
    */
    @Override
    public void delInsideFactory(InsideFactory insideFactory) throws Exception{
        insideFactoryMapper.delInsideFactory(insideFactory);
    }

    /**
    * @Title: delInsideFactoryForLogic
    * @Description: 逻辑删除InsideFactory
    * @param insideFactory
    * @throws Exception
    * @return: void
    */
    @Override
    public void delInsideFactoryForLogic(InsideFactory insideFactory) throws Exception{
        insideFactoryMapper.delInsideFactoryForLogic(insideFactory);
    }

    /**
    * @Title: delInsideFactoryByVo
    * @Description: 根据条件删除InsideFactory
    * @param insideFactoryVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delInsideFactoryByVo(InsideFactoryVO insideFactoryVO) throws Exception{
        insideFactoryMapper.delInsideFactoryByVo(insideFactoryVO);
    }

    /**
    * @Title: updInsideFactory
    * @Description: 动态更新InsideFactory
    * @param insideFactory
    * @throws Exception
    * @return: void
    */
    @Override
    public void updInsideFactory(InsideFactory insideFactory) throws Exception{
        insideFactoryMapper.updInsideFactory(insideFactory);
    }

    /**
    * @Title: getInsideFactoryByPage
    * @Description: 分页查询
    * @param insideFactoryVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<InsideFactory> getInsideFactoryByPage(InsideFactoryVO insideFactoryVO) throws Exception{
        insideFactoryVO.setTotalPage(insideFactoryMapper.getInsideFactoryCount(insideFactoryVO));
        return insideFactoryMapper.getInsideFactoryByPage(insideFactoryVO);
    }

    /**
    * @Title: getInsideFactoryCount
    * @Description: 获取记录数量
    * @param insideFactoryVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getInsideFactoryCount(InsideFactoryVO insideFactoryVO) throws Exception{
        return insideFactoryMapper.getInsideFactoryCount(insideFactoryVO);
    }

    /**
    * @Title: getInsideFactory
    * @Description: 根据查询条件查询
    * @param insideFactoryVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public InsideFactory getInsideFactory(InsideFactoryVO insideFactoryVO) throws Exception{
        return insideFactoryMapper.getInsideFactory(insideFactoryVO);
    }

}
