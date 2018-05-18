package com.service.common.impl;


import com.common.mapper.ISharpenProviderMapper;
import com.common.pojo.SharpenProvider;
import com.common.vo.SharpenProviderVO;
import com.service.common.ISharpenProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SharpenProviderServiceImpl
* @Description SharpenProvider业务实现类
* @author Jivoin
*/
@Service("sharpenProviderService")
public class SharpenProviderServiceImpl implements ISharpenProviderService{

    @Autowired
    private ISharpenProviderMapper sharpenProviderMapper;



    /**
    * @Title: addSharpenProvider
    * @Description: 新增SharpenProvider
    * @param sharpenProvider
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSharpenProvider(SharpenProvider sharpenProvider) throws Exception{
        sharpenProviderMapper.addSharpenProvider(sharpenProvider);
    }

    /**
    * @Title: delSharpenProvider
    * @Description: 删除SharpenProvider
    * @param sharpenProvider
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSharpenProvider(SharpenProvider sharpenProvider) throws Exception{
        sharpenProviderMapper.delSharpenProvider(sharpenProvider);
    }

    /**
    * @Title: delSharpenProviderForLogic
    * @Description: 逻辑删除SharpenProvider
    * @param sharpenProvider
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSharpenProviderForLogic(SharpenProvider sharpenProvider) throws Exception{
        sharpenProviderMapper.delSharpenProviderForLogic(sharpenProvider);
    }

    /**
    * @Title: delSharpenProviderByVo
    * @Description: 根据条件删除SharpenProvider
    * @param sharpenProviderVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSharpenProviderByVo(SharpenProviderVO sharpenProviderVO) throws Exception{
        sharpenProviderMapper.delSharpenProviderByVo(sharpenProviderVO);
    }

    /**
    * @Title: updSharpenProvider
    * @Description: 动态更新SharpenProvider
    * @param sharpenProvider
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSharpenProvider(SharpenProvider sharpenProvider) throws Exception{
        sharpenProviderMapper.updSharpenProvider(sharpenProvider);
    }

    /**
    * @Title: getSharpenProviderByPage
    * @Description: 分页查询
    * @param sharpenProviderVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SharpenProvider> getSharpenProviderByPage(SharpenProviderVO sharpenProviderVO) throws Exception{
        sharpenProviderVO.setTotalPage(sharpenProviderMapper.getSharpenProviderCount(sharpenProviderVO));
        return sharpenProviderMapper.getSharpenProviderByPage(sharpenProviderVO);
    }

    /**
    * @Title: getSharpenProviderCount
    * @Description: 获取记录数量
    * @param sharpenProviderVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSharpenProviderCount(SharpenProviderVO sharpenProviderVO) throws Exception{
        return sharpenProviderMapper.getSharpenProviderCount(sharpenProviderVO);
    }

    /**
    * @Title: getSharpenProvider
    * @Description: 根据查询条件查询
    * @param sharpenProviderVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SharpenProvider getSharpenProvider(SharpenProviderVO sharpenProviderVO) throws Exception{
        return sharpenProviderMapper.getSharpenProvider(sharpenProviderVO);
    }

}
