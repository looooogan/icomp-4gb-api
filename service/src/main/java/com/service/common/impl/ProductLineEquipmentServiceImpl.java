package com.service.common.impl;


import com.common.mapper.IProductLineEquipmentMapper;
import com.common.mapper.IRfidContainerMapper;
import com.common.pojo.ProductLineEquipment;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.ProductLineEquipmentVO;
import com.service.common.IProductLineEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName ProductLineEquipmentServiceImpl
* @Description ProductLineEquipment业务实现类
* @author Jivoin
*/
@Service("productLineEquipmentService")
public class ProductLineEquipmentServiceImpl implements IProductLineEquipmentService{

    @Autowired
    private IProductLineEquipmentMapper productLineEquipmentMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;

    @Autowired
    private IRfidContainerMapper rfidContainerMapper;


    /**
    * @Title: addProductLineEquipment
    * @Description: 新增ProductLineEquipment
    * @param productLineEquipment
    * @throws Exception
    * @return: void
    */
    @Override
    public void addProductLineEquipment(ProductLineEquipment productLineEquipment) throws Exception{
        ProductLineEquipmentVO equipmentVO = new ProductLineEquipmentVO();
        equipmentVO.setCode(productLineEquipment.getCode());
        ProductLineEquipment equipmentTMP = productLineEquipmentMapper.getProductLineEquipment(equipmentVO);
        if (null != equipmentTMP){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.LINE_EQUIPMENT_EXISTS));
        }
        productLineEquipment.setIsDel(0);
        productLineEquipmentMapper.addProductLineEquipment(productLineEquipment);
    }

    /**
    * @Title: delProductLineEquipment
    * @Description: 删除ProductLineEquipment
    * @param productLineEquipment
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineEquipment(ProductLineEquipment productLineEquipment) throws Exception{
        productLineEquipmentMapper.delProductLineEquipment(productLineEquipment);
    }

    /**
    * @Title: delProductLineEquipmentForLogic
    * @Description: 逻辑删除ProductLineEquipment
    * @param productLineEquipment
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineEquipmentForLogic(ProductLineEquipment productLineEquipment) throws Exception{
        productLineEquipmentMapper.delProductLineEquipmentForLogic(productLineEquipment);
    }

    /**
    * @Title: delProductLineEquipmentByVo
    * @Description: 根据条件删除ProductLineEquipment
    * @param productLineEquipmentVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineEquipmentByVo(ProductLineEquipmentVO productLineEquipmentVO) throws Exception{
        productLineEquipmentMapper.delProductLineEquipmentByVo(productLineEquipmentVO);
    }

    /**
    * @Title: updProductLineEquipment
    * @Description: 动态更新ProductLineEquipment
    * @param productLineEquipment
    * @throws Exception
    * @return: void
    */
    @Override
    public void updProductLineEquipment(ProductLineEquipment productLineEquipment) throws Exception{
        ProductLineEquipmentVO equipmentVO = new ProductLineEquipmentVO();
        equipmentVO.setCode(productLineEquipment.getCode());
        ProductLineEquipment equipmentTMP = productLineEquipmentMapper.getProductLineEquipment(equipmentVO);
        if (null != equipmentTMP && equipmentTMP.getId()!=productLineEquipment.getId()){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.LINE_EQUIPMENT_EXISTS));
        }
        productLineEquipmentMapper.updProductLineEquipment(productLineEquipment);
    }

    /**
    * @Title: getProductLineEquipmentByPage
    * @Description: 分页查询
    * @param productLineEquipmentVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<ProductLineEquipment> getProductLineEquipmentByPage(ProductLineEquipmentVO productLineEquipmentVO) throws Exception{
        productLineEquipmentVO.setTotalPage(productLineEquipmentMapper.getProductLineEquipmentCount(productLineEquipmentVO));
        return productLineEquipmentMapper.getProductLineEquipmentByPage(productLineEquipmentVO);
    }

    /**
    * @Title: getProductLineEquipmentCount
    * @Description: 获取记录数量
    * @param productLineEquipmentVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getProductLineEquipmentCount(ProductLineEquipmentVO productLineEquipmentVO) throws Exception{
        return productLineEquipmentMapper.getProductLineEquipmentCount(productLineEquipmentVO);
    }

    /**
    * @Title: getProductLineEquipment
    * @Description: 根据查询条件查询
    * @param productLineEquipmentVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ProductLineEquipment getProductLineEquipment(ProductLineEquipmentVO productLineEquipmentVO) throws Exception{
        return productLineEquipmentMapper.getProductLineEquipment(productLineEquipmentVO);
    }

}
