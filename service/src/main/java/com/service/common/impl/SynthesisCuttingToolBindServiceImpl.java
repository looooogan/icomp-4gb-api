package com.service.common.impl;


import com.common.mapper.IRfidContainerMapper;
import com.common.mapper.ISynthesisCuttingToolBindMapper;
import com.common.mapper.ISynthesisCuttingToolMapper;
import com.common.pojo.SynthesisCuttingToolBind;
import com.common.vo.SynthesisCuttingToolBindVO;
import com.service.common.ISynthesisCuttingToolBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SynthesisCuttingToolBindServiceImpl
* @Description SynthesisCuttingToolBind业务实现类
* @author Jivoin
*/
@Service("synthesisCuttingToolBindService")
public class SynthesisCuttingToolBindServiceImpl implements ISynthesisCuttingToolBindService{

    @Autowired
    private ISynthesisCuttingToolBindMapper synthesisCuttingToolBindMapper;

    @Autowired
    private ISynthesisCuttingToolMapper synthesisCuttingToolMapper;
    @Autowired
    private IRfidContainerMapper rfidContainerMapper;


    /**
    * @Title: addSynthesisCuttingToolBind
    * @Description: 新增SynthesisCuttingToolBind
    * @param synthesisCuttingToolBind
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) throws Exception{
        synthesisCuttingToolBindMapper.addSynthesisCuttingToolBind(synthesisCuttingToolBind);
    }

    /**
    * @Title: delSynthesisCuttingToolBind
    * @Description: 删除SynthesisCuttingToolBind
    * @param synthesisCuttingToolBind
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) throws Exception{
        synthesisCuttingToolBindMapper.delSynthesisCuttingToolBind(synthesisCuttingToolBind);
    }

    /**
    * @Title: delSynthesisCuttingToolBindForLogic
    * @Description: 逻辑删除SynthesisCuttingToolBind
    * @param synthesisCuttingToolBind
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolBindForLogic(SynthesisCuttingToolBind synthesisCuttingToolBind) throws Exception{
        synthesisCuttingToolBindMapper.delSynthesisCuttingToolBindForLogic(synthesisCuttingToolBind);
    }

    /**
    * @Title: delSynthesisCuttingToolBindByVo
    * @Description: 根据条件删除SynthesisCuttingToolBind
    * @param synthesisCuttingToolBindVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolBindByVo(SynthesisCuttingToolBindVO synthesisCuttingToolBindVO) throws Exception{
        synthesisCuttingToolBindMapper.delSynthesisCuttingToolBindByVo(synthesisCuttingToolBindVO);
    }

    /**
    * @Title: updSynthesisCuttingToolBind
    * @Description: 动态更新SynthesisCuttingToolBind
    * @param synthesisCuttingToolBind
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSynthesisCuttingToolBind(SynthesisCuttingToolBind synthesisCuttingToolBind) throws Exception{
        synthesisCuttingToolBindMapper.updSynthesisCuttingToolBind(synthesisCuttingToolBind);
    }

    /**
    * @Title: getSynthesisCuttingToolBindByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolBindVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SynthesisCuttingToolBind> getSynthesisCuttingToolBindByPage(SynthesisCuttingToolBindVO synthesisCuttingToolBindVO) throws Exception{
        synthesisCuttingToolBindVO.setTotalPage(synthesisCuttingToolBindMapper.getSynthesisCuttingToolBindCount(synthesisCuttingToolBindVO));
        return synthesisCuttingToolBindMapper.getSynthesisCuttingToolBindByPage(synthesisCuttingToolBindVO);
    }

    /**
    * @Title: getSynthesisCuttingToolBindCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolBindVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolBindCount(SynthesisCuttingToolBindVO synthesisCuttingToolBindVO) throws Exception{
        return synthesisCuttingToolBindMapper.getSynthesisCuttingToolBindCount(synthesisCuttingToolBindVO);
    }

    /**
    * @Title: getSynthesisCuttingToolBind
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolBindVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolBind getSynthesisCuttingToolBind(SynthesisCuttingToolBindVO synthesisCuttingToolBindVO) throws Exception{
        return synthesisCuttingToolBindMapper.getSynthesisCuttingToolBind(synthesisCuttingToolBindVO);
    }

}
