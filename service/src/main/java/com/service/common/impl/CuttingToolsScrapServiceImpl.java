package com.service.common.impl;


import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.ICuttingToolsScrapMapper;
import com.common.pojo.CuttingToolsScrap;
import com.common.vo.CuttingToolsScrapVO;
import com.service.common.ICuttingToolsScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName CuttingToolsScrapServiceImpl
* @Description CuttingToolsScrap业务实现类
* @author Jivoin
*/
@Service("cuttingToolsScrapService")
public class CuttingToolsScrapServiceImpl implements ICuttingToolsScrapService{

    @Autowired
    private ICuttingToolsScrapMapper cuttingToolsScrapMapper;

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;


    /**
    * @Title: addCuttingToolsScrap
    * @Description: 新增CuttingToolsScrap
    * @param cuttingToolsScrap
    * @throws Exception
    * @return: void
    */
    @Override
    public void addCuttingToolsScrap(CuttingToolsScrap cuttingToolsScrap) throws Exception{
        cuttingToolsScrapMapper.addCuttingToolsScrap(cuttingToolsScrap);
    }

    /**
    * @Title: delCuttingToolsScrap
    * @Description: 删除CuttingToolsScrap
    * @param cuttingToolsScrap
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolsScrap(CuttingToolsScrap cuttingToolsScrap) throws Exception{
        cuttingToolsScrapMapper.delCuttingToolsScrap(cuttingToolsScrap);
    }

    /**
    * @Title: delCuttingToolsScrapForLogic
    * @Description: 逻辑删除CuttingToolsScrap
    * @param cuttingToolsScrap
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolsScrapForLogic(CuttingToolsScrap cuttingToolsScrap) throws Exception{
        cuttingToolsScrapMapper.delCuttingToolsScrapForLogic(cuttingToolsScrap);
    }

    /**
    * @Title: delCuttingToolsScrapByVo
    * @Description: 根据条件删除CuttingToolsScrap
    * @param cuttingToolsScrapVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolsScrapByVo(CuttingToolsScrapVO cuttingToolsScrapVO) throws Exception{
        cuttingToolsScrapMapper.delCuttingToolsScrapByVo(cuttingToolsScrapVO);
    }

    /**
    * @Title: updCuttingToolsScrap
    * @Description: 动态更新CuttingToolsScrap
    * @param cuttingToolsScrap
    * @throws Exception
    * @return: void
    */
    @Override
    public void updCuttingToolsScrap(CuttingToolsScrap cuttingToolsScrap) throws Exception{
        cuttingToolsScrapMapper.updCuttingToolsScrap(cuttingToolsScrap);
    }

    /**
    * @Title: getCuttingToolsScrapByPage
    * @Description: 分页查询
    * @param cuttingToolsScrapVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<CuttingToolsScrap> getCuttingToolsScrapByPage(CuttingToolsScrapVO cuttingToolsScrapVO) throws Exception{
        cuttingToolsScrapVO.setTotalPage(cuttingToolsScrapMapper.getCuttingToolsScrapCount(cuttingToolsScrapVO));
        return cuttingToolsScrapMapper.getCuttingToolsScrapByPage(cuttingToolsScrapVO);
    }

    /**
    * @Title: getCuttingToolsScrapCount
    * @Description: 获取记录数量
    * @param cuttingToolsScrapVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getCuttingToolsScrapCount(CuttingToolsScrapVO cuttingToolsScrapVO) throws Exception{
        return cuttingToolsScrapMapper.getCuttingToolsScrapCount(cuttingToolsScrapVO);
    }

    /**
    * @Title: getCuttingToolsScrap
    * @Description: 根据查询条件查询
    * @param cuttingToolsScrapVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public CuttingToolsScrap getCuttingToolsScrap(CuttingToolsScrapVO cuttingToolsScrapVO) throws Exception{
        return cuttingToolsScrapMapper.getCuttingToolsScrap(cuttingToolsScrapVO);
    }

}
