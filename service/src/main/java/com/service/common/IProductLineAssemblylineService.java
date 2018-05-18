package com.service.common;

import com.common.pojo.ProductLineAssemblyline;
import com.common.vo.ProductLineAssemblylineVO;

import java.util.List;


/**
*
* @ClassName IProductLineAssemblylineService
* @Description ProductLineAssemblyline业务接口
* @author Jivoin
*/
public interface IProductLineAssemblylineService {

    /**
    * @Title: addProductLineAssemblyline
    * @Description: 新增ProductLineAssemblyline
    * @param productLineAssemblyline
    * @throws Exception
    * @return: void
    */
    public void addProductLineAssemblyline(ProductLineAssemblyline productLineAssemblyline) throws Exception;

    /**
    * @Title: delProductLineAssemblyline
    * @Description: 删除ProductLineAssemblyline
    * @param productLineAssemblyline
    * @throws Exception
    * @return: void
    */
    public void delProductLineAssemblyline(ProductLineAssemblyline productLineAssemblyline) throws Exception;

    /**
    * @Title: delProductLineAssemblylineForLogic
    * @Description: 逻辑删除ProductLineAssemblyline
    * @param productLineAssemblyline
    * @throws Exception
    * @return: void
    */
    public void delProductLineAssemblylineForLogic(ProductLineAssemblyline productLineAssemblyline) throws Exception;

    /**
    * @Title: delProductLineAssemblylineByVo
    * @Description: 根据条件删除ProductLineAssemblyline
    * @param productLineAssemblylineVO 条件封装
    * @throws Exception
    * @return: void
    */
    public void delProductLineAssemblylineByVo(ProductLineAssemblylineVO productLineAssemblylineVO) throws Exception;

    /**
    * @Title: updProductLineAssemblyline
    * @Description: 动态更新ProductLineAssemblyline
    * @param productLineAssemblyline
    * @throws Exception
    * @return: void
    */
    public void updProductLineAssemblyline(ProductLineAssemblyline productLineAssemblyline) throws Exception;

    /**
    * @Title: getProductLineAssemblylineByPage
    * @Description: 分页查询
    * @param productLineAssemblylineVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    public List<ProductLineAssemblyline> getProductLineAssemblylineByPage(ProductLineAssemblylineVO productLineAssemblylineVO) throws Exception;

    /**
    * @Title: getProductLineAssemblylineCount
    * @Description: 获取记录数量
    * @param productLineAssemblylineVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getProductLineAssemblylineCount(ProductLineAssemblylineVO productLineAssemblylineVO) throws Exception;

    /**
    * @Title: getProductLineAssemblyline
    * @Description: 根据查询条件查询
    * @param productLineAssemblylineVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public ProductLineAssemblyline getProductLineAssemblyline(ProductLineAssemblylineVO productLineAssemblylineVO) throws Exception;

}
