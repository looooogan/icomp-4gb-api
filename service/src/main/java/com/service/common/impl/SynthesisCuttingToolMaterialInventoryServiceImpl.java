package com.service.common.impl;


import com.common.mapper.ISynthesisCuttingToolMapper;
import com.common.mapper.ISynthesisCuttingToolMaterialInventoryMapper;
import com.common.pojo.SynthesisCuttingToolMaterialInventory;
import com.common.vo.SynthesisCuttingToolMaterialInventoryVO;
import com.service.common.ISynthesisCuttingToolMaterialInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SynthesisCuttingToolMaterialInventoryServiceImpl
* @Description SynthesisCuttingToolMaterialInventory业务实现类
* @author Jivoin
*/
@Service("synthesisCuttingToolMaterialInventoryService")
public class SynthesisCuttingToolMaterialInventoryServiceImpl implements ISynthesisCuttingToolMaterialInventoryService{

    @Autowired
    private ISynthesisCuttingToolMaterialInventoryMapper synthesisCuttingToolMaterialInventoryMapper;

    @Autowired
    private ISynthesisCuttingToolMapper synthesisCuttingToolMapper;


    /**
    * @Title: addSynthesisCuttingToolMaterialInventory
    * @Description: 新增SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventory
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSynthesisCuttingToolMaterialInventory(SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory) throws Exception{
        synthesisCuttingToolMaterialInventoryMapper.addSynthesisCuttingToolMaterialInventory(synthesisCuttingToolMaterialInventory);
    }

    /**
    * @Title: delSynthesisCuttingToolMaterialInventory
    * @Description: 删除SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventory
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolMaterialInventory(SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory) throws Exception{
        synthesisCuttingToolMaterialInventoryMapper.delSynthesisCuttingToolMaterialInventory(synthesisCuttingToolMaterialInventory);
    }

    /**
    * @Title: delSynthesisCuttingToolMaterialInventoryForLogic
    * @Description: 逻辑删除SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventory
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolMaterialInventoryForLogic(SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory) throws Exception{
        synthesisCuttingToolMaterialInventoryMapper.delSynthesisCuttingToolMaterialInventoryForLogic(synthesisCuttingToolMaterialInventory);
    }

    /**
    * @Title: delSynthesisCuttingToolMaterialInventoryByVo
    * @Description: 根据条件删除SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventoryVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolMaterialInventoryByVo(SynthesisCuttingToolMaterialInventoryVO synthesisCuttingToolMaterialInventoryVO) throws Exception{
        synthesisCuttingToolMaterialInventoryMapper.delSynthesisCuttingToolMaterialInventoryByVo(synthesisCuttingToolMaterialInventoryVO);
    }

    /**
    * @Title: updSynthesisCuttingToolMaterialInventory
    * @Description: 动态更新SynthesisCuttingToolMaterialInventory
    * @param synthesisCuttingToolMaterialInventory
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSynthesisCuttingToolMaterialInventory(SynthesisCuttingToolMaterialInventory synthesisCuttingToolMaterialInventory) throws Exception{
        synthesisCuttingToolMaterialInventoryMapper.updSynthesisCuttingToolMaterialInventory(synthesisCuttingToolMaterialInventory);
    }

    /**
    * @Title: getSynthesisCuttingToolMaterialInventoryByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolMaterialInventoryVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SynthesisCuttingToolMaterialInventory> getSynthesisCuttingToolMaterialInventoryByPage(SynthesisCuttingToolMaterialInventoryVO synthesisCuttingToolMaterialInventoryVO) throws Exception{
        synthesisCuttingToolMaterialInventoryVO.setTotalPage(synthesisCuttingToolMaterialInventoryMapper.getSynthesisCuttingToolMaterialInventoryCount(synthesisCuttingToolMaterialInventoryVO));
        return synthesisCuttingToolMaterialInventoryMapper.getSynthesisCuttingToolMaterialInventoryByPage(synthesisCuttingToolMaterialInventoryVO);
    }

    /**
    * @Title: getSynthesisCuttingToolMaterialInventoryCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolMaterialInventoryVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolMaterialInventoryCount(SynthesisCuttingToolMaterialInventoryVO synthesisCuttingToolMaterialInventoryVO) throws Exception{
        return synthesisCuttingToolMaterialInventoryMapper.getSynthesisCuttingToolMaterialInventoryCount(synthesisCuttingToolMaterialInventoryVO);
    }

    /**
    * @Title: getSynthesisCuttingToolMaterialInventory
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolMaterialInventoryVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolMaterialInventory getSynthesisCuttingToolMaterialInventory(SynthesisCuttingToolMaterialInventoryVO synthesisCuttingToolMaterialInventoryVO) throws Exception{
        return synthesisCuttingToolMaterialInventoryMapper.getSynthesisCuttingToolMaterialInventory(synthesisCuttingToolMaterialInventoryVO);
    }

}
