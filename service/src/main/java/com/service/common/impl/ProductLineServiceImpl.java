package com.service.common.impl;


import com.common.mapper.*;
import com.common.pojo.ProductLine;
import com.common.pojo.SynthesisCuttingTool;
import com.common.utils.UUID;
import com.common.vo.ProductLineVO;
import com.common.vo.SynthesisCuttingToolVO;
import com.service.common.IProductLineService;
import com.service.productline.vo.ProductLineAddVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
*
* @ClassName ProductLineServiceImpl
* @Description ProductLine业务实现类
* @author Jivoin
*/
@Service("productLineService")
public class ProductLineServiceImpl implements IProductLineService{

    @Autowired
    private IProductLineMapper productLineMapper;

    @Autowired
    private IProductLineAxleMapper productLineAxleMapper;
    @Autowired
    private IProductLineAssemblylineMapper productLineAssemblylineMapper;
    @Autowired
    private IProductLineEquipmentMapper productLineEquipmentMapper;
    @Autowired
    private IProductLineProcessMapper productLineProcessMapper;
    @Autowired
    private IProductLinePartsMapper productLinePartsMapper;
    @Autowired
    private ISynthesisCuttingToolMapper synthesisCuttingToolMapper;


    /**
    * @Title: addProductLine
    * @Description: 新增ProductLine
    * @param productLine
    * @throws Exception
    * @return: void
    */
    @Override
    public void addProductLine(ProductLine productLine) throws Exception{
        productLine.setIsDel(0);
        productLineMapper.addProductLine(productLine);
    }

    /**
    * @Title: delProductLine
    * @Description: 删除ProductLine
    * @param productLine
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLine(ProductLine productLine) throws Exception{
        productLineMapper.delProductLine(productLine);
    }

    /**
    * @Title: delProductLineForLogic
    * @Description: 逻辑删除ProductLine
    * @param productLine
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineForLogic(ProductLine productLine) throws Exception{
        productLineMapper.delProductLineForLogic(productLine);
    }

    /**
    * @Title: delProductLineByVo
    * @Description: 根据条件删除ProductLine
    * @param productLineVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delProductLineByVo(ProductLineVO productLineVO) throws Exception{
        productLineMapper.delProductLineByVo(productLineVO);
    }

    /**
    * @Title: updProductLine
    * @Description: 动态更新ProductLine
    * @param productLine
    * @throws Exception
    * @return: void
    */
    @Override
    public void updProductLine(ProductLine productLine) throws Exception{
        productLineMapper.updProductLine(productLine);
    }

    /**
    * @Title: getProductLineByPage
    * @Description: 分页查询
    * @param productLineVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<ProductLine> getProductLineByPage(ProductLineVO productLineVO) throws Exception{
        productLineVO.setTotalPage(productLineMapper.getProductLineCount(productLineVO));
        return productLineMapper.getProductLineByPage(productLineVO);
    }

    /**
    * @Title: getProductLineCount
    * @Description: 获取记录数量
    * @param productLineVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getProductLineCount(ProductLineVO productLineVO) throws Exception{
        return productLineMapper.getProductLineCount(productLineVO);
    }

    /**
    * @Title: getProductLine
    * @Description: 根据查询条件查询
    * @param productLineVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ProductLine getProductLine(ProductLineVO productLineVO) throws Exception{
        return productLineMapper.getProductLine(productLineVO);
    }

    @Override
    public void addForWeb(ProductLineAddVO productLineAddVO) throws Exception {
        ProductLine oplink = null;
        // 生产线id
        String assemblyLineID = productLineAddVO.getAssemblyLineID();
        // 工序id
        String processID = productLineAddVO.getProcessID();
        //设备id
        String[] shebeiIds = productLineAddVO.getEquipmentID().split(",");
        //轴编号
        String[] zhouIds = productLineAddVO.getAxleID().split(",");
        //零部件
        String[] lingbijianIds = productLineAddVO.getParts().split(",");
        //零部件-合成刀-耐用度拼接
        String[] hechengdaoAndNaiyongdus = productLineAddVO.getStr().split(",");
        Map insertMap = new HashMap<String, Object>();
        Map<String,Object> ret = null;
        oplink = new ProductLine();
        // 工序ID
        oplink.setProcessCode(processID);
        // 生产线ID
        oplink.setAssemblylineCode(assemblyLineID);
        for(int i = 0;i<shebeiIds.length;i++){
            //设备ID
            oplink.setEquipmentCode(shebeiIds[i]);
            for(int j = 0;j<zhouIds.length;j++){
                //轴ID
                oplink.setAxleCode(zhouIds[j]);
                for(int l = 0;l<hechengdaoAndNaiyongdus.length;l++){
                    //零部件ID
                    oplink.setPartsCode(hechengdaoAndNaiyongdus[l].split(";")[0]);
                    //合成刀ID
                    oplink.setSynthesisCuttingToolCode(hechengdaoAndNaiyongdus[l].split(";")[1]);
                    //耐用度
                    oplink.setToolDurable(Integer.parseInt(hechengdaoAndNaiyongdus[l].split(";")[2]));
                    //保存关联信息
                    oplink.setIsDel(0);
                    oplink.setProductLineCode(UUID.getInstance());
                    productLineMapper.addProductLine(oplink);
//                    ret = iCOMPV01B08S013Service.oplinkAdd(oplink,langCode, langValue);
                }
            }
        }
    }

    @Override
    public ProductLine getAssemblylineByEquipmentAndAxle(ProductLineVO productLineVO) throws Exception {
        return productLineMapper.getAssemblylineByEquipmentAndAxle(productLineVO);
    }
}
