package com.service.common.impl;


import com.common.mapper.IProductLineAxleMapper;
import com.common.pojo.ProductLineAxle;
import com.common.vo.ProductLineAxleVO;
import com.service.common.IProductLineAxleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName ProductLineAxleServiceImpl
* @Description ProductLineAxle业务实现类
* @author Jivoin
*/
@Service("productLineAxleService")
public class ProductLineAxleServiceImpl implements IProductLineAxleService{

    @Autowired
    private IProductLineAxleMapper productLineAxleMapper;



    /**
    * @Title: addProductLineAxle
    * @Description: 新增ProductLineAxle
    * @param productLineAxle
    * @throws Exception
    * @return: void
    */
    @Override
    public void addProductLineAxle(ProductLineAxle productLineAxle) throws Exception{
        productLineAxle.setIsDel(0);
        productLineAxleMapper.addProductLineAxle(productLineAxle);
    }

    /**
    * @Title: delProductLineAxle
    * @Description: 删除ProductLineAxle
    * @param productLineAxle
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineAxle(ProductLineAxle productLineAxle) throws Exception{
        productLineAxleMapper.delProductLineAxle(productLineAxle);
    }

    /**
    * @Title: delProductLineAxleForLogic
    * @Description: 逻辑删除ProductLineAxle
    * @param productLineAxle
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineAxleForLogic(ProductLineAxle productLineAxle) throws Exception{
        productLineAxleMapper.delProductLineAxleForLogic(productLineAxle);
    }

    /**
    * @Title: delProductLineAxleByVo
    * @Description: 根据条件删除ProductLineAxle
    * @param productLineAxleVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineAxleByVo(ProductLineAxleVO productLineAxleVO) throws Exception{
        productLineAxleMapper.delProductLineAxleByVo(productLineAxleVO);
    }

    /**
    * @Title: updProductLineAxle
    * @Description: 动态更新ProductLineAxle
    * @param productLineAxle
    * @throws Exception
    * @return: void
    */
    @Override
    public void updProductLineAxle(ProductLineAxle productLineAxle) throws Exception{
        productLineAxleMapper.updProductLineAxle(productLineAxle);
    }

    /**
    * @Title: getProductLineAxleByPage
    * @Description: 分页查询
    * @param productLineAxleVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<ProductLineAxle> getProductLineAxleByPage(ProductLineAxleVO productLineAxleVO) throws Exception{
        productLineAxleVO.setTotalPage(productLineAxleMapper.getProductLineAxleCount(productLineAxleVO));
        return productLineAxleMapper.getProductLineAxleByPage(productLineAxleVO);
    }

    /**
    * @Title: getProductLineAxleCount
    * @Description: 获取记录数量
    * @param productLineAxleVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getProductLineAxleCount(ProductLineAxleVO productLineAxleVO) throws Exception{
        return productLineAxleMapper.getProductLineAxleCount(productLineAxleVO);
    }

    /**
    * @Title: getProductLineAxle
    * @Description: 根据查询条件查询
    * @param productLineAxleVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ProductLineAxle getProductLineAxle(ProductLineAxleVO productLineAxleVO) throws Exception{
        return productLineAxleMapper.getProductLineAxle(productLineAxleVO);
    }

}
