package com.service.common.impl;


import com.common.mapper.ICuttingToolMapper;
import com.common.pojo.CuttingTool;
import com.common.utils.UUID;
import com.common.vo.CuttingToolVO;
import com.service.common.ICuttingToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName CuttingToolServiceImpl
* @Description CuttingTool业务实现类
* @author Jivoin
*/
@Service("cuttingToolService")
public class CuttingToolServiceImpl implements ICuttingToolService{

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;



    /**
    * @Title: addCuttingTool
    * @Description: 新增CuttingTool
    * @param cuttingTool
    * @throws Exception
    * @return: void
    */
    @Override
    public void addCuttingTool(CuttingTool cuttingTool) throws Exception{
        cuttingTool.setIsDel(0);
        cuttingTool.setCode(UUID.getInstance());
        cuttingToolMapper.addCuttingTool(cuttingTool);
    }

    /**
    * @Title: delCuttingTool
    * @Description: 删除CuttingTool
    * @param cuttingTool
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingTool(CuttingTool cuttingTool) throws Exception{
        cuttingToolMapper.delCuttingTool(cuttingTool);
    }

    /**
    * @Title: delCuttingToolForLogic
    * @Description: 逻辑删除CuttingTool
    * @param cuttingTool
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolForLogic(CuttingTool cuttingTool) throws Exception{
        cuttingToolMapper.delCuttingToolForLogic(cuttingTool);
    }

    /**
    * @Title: delCuttingToolByVo
    * @Description: 根据条件删除CuttingTool
    * @param cuttingToolVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolByVo(CuttingToolVO cuttingToolVO) throws Exception{
        cuttingToolMapper.delCuttingToolByVo(cuttingToolVO);
    }

    /**
    * @Title: updCuttingTool
    * @Description: 动态更新CuttingTool
    * @param cuttingTool
    * @throws Exception
    * @return: void
    */
    @Override
    public void updCuttingTool(CuttingTool cuttingTool) throws Exception{
        cuttingToolMapper.updCuttingTool(cuttingTool);
    }

    /**
    * @Title: getCuttingToolByPage
    * @Description: 分页查询
    * @param cuttingToolVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<CuttingTool> getCuttingToolByPage(CuttingToolVO cuttingToolVO) throws Exception{
        cuttingToolVO.setTotalPage(cuttingToolMapper.getCuttingToolCount(cuttingToolVO));
        return cuttingToolMapper.getCuttingToolByPage(cuttingToolVO);
    }

    /**
    * @Title: getCuttingToolCount
    * @Description: 获取记录数量
    * @param cuttingToolVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getCuttingToolCount(CuttingToolVO cuttingToolVO) throws Exception{
        return cuttingToolMapper.getCuttingToolCount(cuttingToolVO);
    }

    /**
    * @Title: getCuttingTool
    * @Description: 根据查询条件查询
    * @param cuttingToolVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public CuttingTool getCuttingTool(CuttingToolVO cuttingToolVO) throws Exception{
        return cuttingToolMapper.getCuttingTool(cuttingToolVO);
    }

}
