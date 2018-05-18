package com.service.common.impl;


import com.common.mapper.IProductLineAssemblylineMapper;
import com.common.mapper.IProductLineProcessMapper;
import com.common.pojo.ProductLineProcess;
import com.common.vo.ProductLineProcessVO;
import com.service.common.IProductLineProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName ProductLineProcessServiceImpl
* @Description ProductLineProcess业务实现类
* @author Jivoin
*/
@Service("productLineProcessService")
public class ProductLineProcessServiceImpl implements IProductLineProcessService{

    @Autowired
    private IProductLineProcessMapper productLineProcessMapper;

    @Autowired
    private IProductLineAssemblylineMapper productLineAssemblylineMapper;


    /**
    * @Title: addProductLineProcess
    * @Description: 新增ProductLineProcess
    * @param productLineProcess
    * @throws Exception
    * @return: void
    */
    @Override
    public void addProductLineProcess(ProductLineProcess productLineProcess) throws Exception{
        productLineProcess.setIsDel(0);
        productLineProcessMapper.addProductLineProcess(productLineProcess);
    }

    /**
    * @Title: delProductLineProcess
    * @Description: 删除ProductLineProcess
    * @param productLineProcess
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineProcess(ProductLineProcess productLineProcess) throws Exception{
        productLineProcessMapper.delProductLineProcess(productLineProcess);
    }

    /**
    * @Title: delProductLineProcessForLogic
    * @Description: 逻辑删除ProductLineProcess
    * @param productLineProcess
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineProcessForLogic(ProductLineProcess productLineProcess) throws Exception{
        productLineProcessMapper.delProductLineProcessForLogic(productLineProcess);
    }

    /**
    * @Title: delProductLineProcessByVo
    * @Description: 根据条件删除ProductLineProcess
    * @param productLineProcessVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineProcessByVo(ProductLineProcessVO productLineProcessVO) throws Exception{
        productLineProcessMapper.delProductLineProcessByVo(productLineProcessVO);
    }

    /**
    * @Title: updProductLineProcess
    * @Description: 动态更新ProductLineProcess
    * @param productLineProcess
    * @throws Exception
    * @return: void
    */
    @Override
    public void updProductLineProcess(ProductLineProcess productLineProcess) throws Exception{
        productLineProcessMapper.updProductLineProcess(productLineProcess);
    }

    /**
    * @Title: getProductLineProcessByPage
    * @Description: 分页查询
    * @param productLineProcessVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<ProductLineProcess> getProductLineProcessByPage(ProductLineProcessVO productLineProcessVO) throws Exception{
        productLineProcessVO.setTotalPage(productLineProcessMapper.getProductLineProcessCount(productLineProcessVO));
        return productLineProcessMapper.getProductLineProcessByPage(productLineProcessVO);
    }

    /**
    * @Title: getProductLineProcessCount
    * @Description: 获取记录数量
    * @param productLineProcessVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getProductLineProcessCount(ProductLineProcessVO productLineProcessVO) throws Exception{
        return productLineProcessMapper.getProductLineProcessCount(productLineProcessVO);
    }

    /**
    * @Title: getProductLineProcess
    * @Description: 根据查询条件查询
    * @param productLineProcessVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ProductLineProcess getProductLineProcess(ProductLineProcessVO productLineProcessVO) throws Exception{
        return productLineProcessMapper.getProductLineProcess(productLineProcessVO);
    }

}
