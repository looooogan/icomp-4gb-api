package com.common.mapper;

import com.common.pojo.SharpenProvider;
import com.common.vo.SharpenProviderVO;

import java.util.List;


/**
*
* @ClassName ISharpenProviderMapper
* @Description TODO
* @author Jivoin
*/
public interface ISharpenProviderMapper {

    /**
    * @Title: addSharpenProvider
    * @Description: 新增SharpenProvider
    * @param sharpenProvider
    * @throws Exception
    * @return: void
    */
    public void addSharpenProvider(SharpenProvider sharpenProvider) throws Exception;

    /**
    * @Title: delSharpenProvider
    * @Description: 删除SharpenProvider
    * @param sharpenProvider
    * @throws Exception
    * @return: void
    */
    public void delSharpenProvider(SharpenProvider sharpenProvider) throws Exception;

    /**
    * @Title: delSharpenProviderForLogic
    * @Description: 逻辑删除SharpenProvider
    * @param sharpenProvider
    * @throws Exception
    * @return: void
    */
    public void delSharpenProviderForLogic(SharpenProvider sharpenProvider) throws Exception;

    /**
    * @Title: delSharpenProviderByVo
    * @Description: 根据条件删除SharpenProvider
    * @param sharpenProviderVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delSharpenProviderByVo(SharpenProviderVO sharpenProviderVO) throws Exception;

    /**
    * @Title: updSharpenProvider
    * @Description: 动态更新SharpenProvider
    * @param sharpenProvider
    * @throws Exception
    * @return: void
    */
    public void updSharpenProvider(SharpenProvider sharpenProvider) throws Exception;

    /**
    * @Title: getSharpenProviderByPage
    * @Description: 分页查询
    * @param sharpenProviderVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<SharpenProvider> getSharpenProviderByPage(SharpenProviderVO sharpenProviderVO) throws Exception;

    /**
    * @Title: getSharpenProviderCount
    * @Description: 获取记录数量
    * @param sharpenProviderVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSharpenProviderCount(SharpenProviderVO sharpenProviderVO) throws Exception;

    /**
    * @Title: getSharpenProvider
    * @Description: 根据查询条件查询
    * @param sharpenProviderVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SharpenProvider getSharpenProvider(SharpenProviderVO sharpenProviderVO) throws Exception;

}
