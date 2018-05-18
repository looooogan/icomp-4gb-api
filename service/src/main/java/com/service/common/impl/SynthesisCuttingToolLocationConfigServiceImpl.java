package com.service.common.impl;


import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.ISynthesisCuttingToolLocationConfigMapper;
import com.common.pojo.SynthesisCuttingToolLocationConfig;
import com.common.vo.SynthesisCuttingToolLocationConfigVO;
import com.service.common.ISynthesisCuttingToolLocationConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SynthesisCuttingToolLocationConfigServiceImpl
* @Description SynthesisCuttingToolLocationConfig业务实现类
* @author Jivoin
*/
@Service("synthesisCuttingToolLocationConfigService")
public class SynthesisCuttingToolLocationConfigServiceImpl implements ISynthesisCuttingToolLocationConfigService{

    @Autowired
    private ISynthesisCuttingToolLocationConfigMapper synthesisCuttingToolLocationConfigMapper;

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;


    /**
    * @Title: addSynthesisCuttingToolLocationConfig
    * @Description: 新增SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfig
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSynthesisCuttingToolLocationConfig(SynthesisCuttingToolLocationConfig synthesisCuttingToolLocationConfig) throws Exception{
        synthesisCuttingToolLocationConfigMapper.addSynthesisCuttingToolLocationConfig(synthesisCuttingToolLocationConfig);
    }

    /**
    * @Title: delSynthesisCuttingToolLocationConfig
    * @Description: 删除SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfig
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolLocationConfig(SynthesisCuttingToolLocationConfig synthesisCuttingToolLocationConfig) throws Exception{
        synthesisCuttingToolLocationConfigMapper.delSynthesisCuttingToolLocationConfig(synthesisCuttingToolLocationConfig);
    }

    /**
    * @Title: delSynthesisCuttingToolLocationConfigForLogic
    * @Description: 逻辑删除SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfig
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolLocationConfigForLogic(SynthesisCuttingToolLocationConfig synthesisCuttingToolLocationConfig) throws Exception{
        synthesisCuttingToolLocationConfigMapper.delSynthesisCuttingToolLocationConfigForLogic(synthesisCuttingToolLocationConfig);
    }

    /**
    * @Title: delSynthesisCuttingToolLocationConfigByVo
    * @Description: 根据条件删除SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfigVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolLocationConfigByVo(SynthesisCuttingToolLocationConfigVO synthesisCuttingToolLocationConfigVO) throws Exception{
        synthesisCuttingToolLocationConfigMapper.delSynthesisCuttingToolLocationConfigByVo(synthesisCuttingToolLocationConfigVO);
    }

    /**
    * @Title: updSynthesisCuttingToolLocationConfig
    * @Description: 动态更新SynthesisCuttingToolLocationConfig
    * @param synthesisCuttingToolLocationConfig
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSynthesisCuttingToolLocationConfig(SynthesisCuttingToolLocationConfig synthesisCuttingToolLocationConfig) throws Exception{
        synthesisCuttingToolLocationConfigMapper.updSynthesisCuttingToolLocationConfig(synthesisCuttingToolLocationConfig);
    }

    /**
    * @Title: getSynthesisCuttingToolLocationConfigByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolLocationConfigVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SynthesisCuttingToolLocationConfig> getSynthesisCuttingToolLocationConfigByPage(SynthesisCuttingToolLocationConfigVO synthesisCuttingToolLocationConfigVO) throws Exception{
        synthesisCuttingToolLocationConfigVO.setTotalPage(synthesisCuttingToolLocationConfigMapper.getSynthesisCuttingToolLocationConfigCount(synthesisCuttingToolLocationConfigVO));
        return synthesisCuttingToolLocationConfigMapper.getSynthesisCuttingToolLocationConfigByPage(synthesisCuttingToolLocationConfigVO);
    }

    /**
    * @Title: getSynthesisCuttingToolLocationConfigCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolLocationConfigVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolLocationConfigCount(SynthesisCuttingToolLocationConfigVO synthesisCuttingToolLocationConfigVO) throws Exception{
        return synthesisCuttingToolLocationConfigMapper.getSynthesisCuttingToolLocationConfigCount(synthesisCuttingToolLocationConfigVO);
    }

    /**
    * @Title: getSynthesisCuttingToolLocationConfig
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolLocationConfigVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolLocationConfig getSynthesisCuttingToolLocationConfig(SynthesisCuttingToolLocationConfigVO synthesisCuttingToolLocationConfigVO) throws Exception{
        return synthesisCuttingToolLocationConfigMapper.getSynthesisCuttingToolLocationConfig(synthesisCuttingToolLocationConfigVO);
    }

}
