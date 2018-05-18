package com.service.common.impl;


import com.common.mapper.IProductLineAssemblylineMapper;
import com.common.pojo.ProductLineAssemblyline;
import com.common.vo.ProductLineAssemblylineVO;
import com.service.common.IProductLineAssemblylineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName ProductLineAssemblylineServiceImpl
* @Description ProductLineAssemblyline业务实现类
* @author Jivoin
*/
@Service("productLineAssemblylineService")
public class ProductLineAssemblylineServiceImpl implements IProductLineAssemblylineService{

    @Autowired
    private IProductLineAssemblylineMapper productLineAssemblylineMapper;



    /**
    * @Title: addProductLineAssemblyline
    * @Description: 新增ProductLineAssemblyline
    * @param productLineAssemblyline
    * @throws Exception
    * @return: void
    */
    @Override
    public void addProductLineAssemblyline(ProductLineAssemblyline productLineAssemblyline) throws Exception{
        productLineAssemblyline.setIsDel(0);
        productLineAssemblylineMapper.addProductLineAssemblyline(productLineAssemblyline);
    }

    /**
    * @Title: delProductLineAssemblyline
    * @Description: 删除ProductLineAssemblyline
    * @param productLineAssemblyline
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineAssemblyline(ProductLineAssemblyline productLineAssemblyline) throws Exception{
        productLineAssemblylineMapper.delProductLineAssemblyline(productLineAssemblyline);
    }

    /**
    * @Title: delProductLineAssemblylineForLogic
    * @Description: 逻辑删除ProductLineAssemblyline
    * @param productLineAssemblyline
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineAssemblylineForLogic(ProductLineAssemblyline productLineAssemblyline) throws Exception{
        productLineAssemblylineMapper.delProductLineAssemblylineForLogic(productLineAssemblyline);
    }

    /**
    * @Title: delProductLineAssemblylineByVo
    * @Description: 根据条件删除ProductLineAssemblyline
    * @param productLineAssemblylineVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineAssemblylineByVo(ProductLineAssemblylineVO productLineAssemblylineVO) throws Exception{
        productLineAssemblylineMapper.delProductLineAssemblylineByVo(productLineAssemblylineVO);
    }

    /**
    * @Title: updProductLineAssemblyline
    * @Description: 动态更新ProductLineAssemblyline
    * @param productLineAssemblyline
    * @throws Exception
    * @return: void
    */
    @Override
    public void updProductLineAssemblyline(ProductLineAssemblyline productLineAssemblyline) throws Exception{
        productLineAssemblylineMapper.updProductLineAssemblyline(productLineAssemblyline);
    }

    /**
    * @Title: getProductLineAssemblylineByPage
    * @Description: 分页查询
    * @param productLineAssemblylineVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<ProductLineAssemblyline> getProductLineAssemblylineByPage(ProductLineAssemblylineVO productLineAssemblylineVO) throws Exception{
        productLineAssemblylineVO.setTotalPage(productLineAssemblylineMapper.getProductLineAssemblylineCount(productLineAssemblylineVO));
        return productLineAssemblylineMapper.getProductLineAssemblylineByPage(productLineAssemblylineVO);
    }

    /**
    * @Title: getProductLineAssemblylineCount
    * @Description: 获取记录数量
    * @param productLineAssemblylineVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getProductLineAssemblylineCount(ProductLineAssemblylineVO productLineAssemblylineVO) throws Exception{
        return productLineAssemblylineMapper.getProductLineAssemblylineCount(productLineAssemblylineVO);
    }

    /**
    * @Title: getProductLineAssemblyline
    * @Description: 根据查询条件查询
    * @param productLineAssemblylineVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ProductLineAssemblyline getProductLineAssemblyline(ProductLineAssemblylineVO productLineAssemblylineVO) throws Exception{
        return productLineAssemblylineMapper.getProductLineAssemblyline(productLineAssemblylineVO);
    }

}
