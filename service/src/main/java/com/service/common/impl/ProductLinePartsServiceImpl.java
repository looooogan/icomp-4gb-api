package com.service.common.impl;


import com.common.mapper.IProductLinePartsMapper;
import com.common.pojo.ProductLineParts;
import com.common.vo.ProductLinePartsVO;
import com.service.common.IProductLinePartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName ProductLinePartsServiceImpl
* @Description ProductLineParts业务实现类
* @author Jivoin
*/
@Service("productLinePartsService")
public class ProductLinePartsServiceImpl implements IProductLinePartsService{

    @Autowired
    private IProductLinePartsMapper productLinePartsMapper;



    /**
    * @Title: addProductLineParts
    * @Description: 新增ProductLineParts
    * @param productLineParts
    * @throws Exception
    * @return: void
    */
    @Override
    public void addProductLineParts(ProductLineParts productLineParts) throws Exception{
        productLineParts.setIsDel(0);
        productLinePartsMapper.addProductLineParts(productLineParts);
    }

    /**
    * @Title: delProductLineParts
    * @Description: 删除ProductLineParts
    * @param productLineParts
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineParts(ProductLineParts productLineParts) throws Exception{
        productLinePartsMapper.delProductLineParts(productLineParts);
    }

    /**
    * @Title: delProductLinePartsForLogic
    * @Description: 逻辑删除ProductLineParts
    * @param productLineParts
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLinePartsForLogic(ProductLineParts productLineParts) throws Exception{
        productLinePartsMapper.delProductLinePartsForLogic(productLineParts);
    }

    /**
    * @Title: delProductLinePartsByVo
    * @Description: 根据条件删除ProductLineParts
    * @param productLinePartsVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLinePartsByVo(ProductLinePartsVO productLinePartsVO) throws Exception{
        productLinePartsMapper.delProductLinePartsByVo(productLinePartsVO);
    }

    /**
    * @Title: updProductLineParts
    * @Description: 动态更新ProductLineParts
    * @param productLineParts
    * @throws Exception
    * @return: void
    */
    @Override
    public void updProductLineParts(ProductLineParts productLineParts) throws Exception{
        productLinePartsMapper.updProductLineParts(productLineParts);
    }

    /**
    * @Title: getProductLinePartsByPage
    * @Description: 分页查询
    * @param productLinePartsVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<ProductLineParts> getProductLinePartsByPage(ProductLinePartsVO productLinePartsVO) throws Exception{
        productLinePartsVO.setTotalPage(productLinePartsMapper.getProductLinePartsCount(productLinePartsVO));
        return productLinePartsMapper.getProductLinePartsByPage(productLinePartsVO);
    }

    /**
    * @Title: getProductLinePartsCount
    * @Description: 获取记录数量
    * @param productLinePartsVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getProductLinePartsCount(ProductLinePartsVO productLinePartsVO) throws Exception{
        return productLinePartsMapper.getProductLinePartsCount(productLinePartsVO);
    }

    /**
    * @Title: getProductLineParts
    * @Description: 根据查询条件查询
    * @param productLinePartsVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ProductLineParts getProductLineParts(ProductLinePartsVO productLinePartsVO) throws Exception{
        return productLinePartsMapper.getProductLineParts(productLinePartsVO);
    }

}
