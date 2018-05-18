package com.service.common.impl;


import com.common.mapper.ICuttingToolBindMapper;
import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.IRfidContainerMapper;
import com.common.pojo.CuttingToolBind;
import com.common.vo.CuttingToolBindVO;
import com.service.common.ICuttingToolBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName CuttingToolBindServiceImpl
* @Description CuttingToolBind业务实现类
* @author Jivoin
*/
@Service("cuttingToolBindService")
public class CuttingToolBindServiceImpl implements ICuttingToolBindService{

    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;
    @Autowired
    private IRfidContainerMapper rfidContainerMapper;


    /**
    * @Title: addCuttingToolBind
    * @Description: 新增CuttingToolBind
    * @param cuttingToolBind
    * @throws Exception
    * @return: void
    */
    @Override
    public void addCuttingToolBind(CuttingToolBind cuttingToolBind) throws Exception{
        cuttingToolBindMapper.addCuttingToolBind(cuttingToolBind);
    }

    /**
    * @Title: delCuttingToolBind
    * @Description: 删除CuttingToolBind
    * @param cuttingToolBind
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolBind(CuttingToolBind cuttingToolBind) throws Exception{
        cuttingToolBindMapper.delCuttingToolBind(cuttingToolBind);
    }

    /**
    * @Title: delCuttingToolBindForLogic
    * @Description: 逻辑删除CuttingToolBind
    * @param cuttingToolBind
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolBindForLogic(CuttingToolBind cuttingToolBind) throws Exception{
        cuttingToolBindMapper.delCuttingToolBindForLogic(cuttingToolBind);
    }

    /**
    * @Title: delCuttingToolBindByVo
    * @Description: 根据条件删除CuttingToolBind
    * @param cuttingToolBindVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delCuttingToolBindByVo(CuttingToolBindVO cuttingToolBindVO) throws Exception{
        cuttingToolBindMapper.delCuttingToolBindByVo(cuttingToolBindVO);
    }

    /**
    * @Title: updCuttingToolBind
    * @Description: 动态更新CuttingToolBind
    * @param cuttingToolBind
    * @throws Exception
    * @return: void
    */
    @Override
    public void updCuttingToolBind(CuttingToolBind cuttingToolBind) throws Exception{
        cuttingToolBindMapper.updCuttingToolBind(cuttingToolBind);
    }

    /**
    * @Title: getCuttingToolBindByPage
    * @Description: 分页查询
    * @param cuttingToolBindVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<CuttingToolBind> getCuttingToolBindByPage(CuttingToolBindVO cuttingToolBindVO) throws Exception{
        cuttingToolBindVO.setTotalPage(cuttingToolBindMapper.getCuttingToolBindCount(cuttingToolBindVO));
        return cuttingToolBindMapper.getCuttingToolBindByPage(cuttingToolBindVO);
    }

    /**
    * @Title: getCuttingToolBindCount
    * @Description: 获取记录数量
    * @param cuttingToolBindVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getCuttingToolBindCount(CuttingToolBindVO cuttingToolBindVO) throws Exception{
        return cuttingToolBindMapper.getCuttingToolBindCount(cuttingToolBindVO);
    }

    /**
    * @Title: getCuttingToolBind
    * @Description: 根据查询条件查询
    * @param cuttingToolBindVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public CuttingToolBind getCuttingToolBind(CuttingToolBindVO cuttingToolBindVO) throws Exception{
        return cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
    }

}
