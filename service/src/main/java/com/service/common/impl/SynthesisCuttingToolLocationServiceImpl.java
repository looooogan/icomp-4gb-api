package com.service.common.impl;


import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.ISynthesisCuttingToolLocationMapper;
import com.common.mapper.ISynthesisCuttingToolMapper;
import com.common.pojo.SynthesisCuttingToolLocation;
import com.common.vo.SynthesisCuttingToolLocationVO;
import com.service.common.ISynthesisCuttingToolLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SynthesisCuttingToolLocationServiceImpl
* @Description SynthesisCuttingToolLocation业务实现类
* @author Jivoin
*/
@Service("synthesisCuttingToolLocationService")
public class SynthesisCuttingToolLocationServiceImpl implements ISynthesisCuttingToolLocationService{

    @Autowired
    private ISynthesisCuttingToolLocationMapper synthesisCuttingToolLocationMapper;

    @Autowired
    private ISynthesisCuttingToolMapper synthesisCuttingToolMapper;
    @Autowired
    private ICuttingToolMapper cuttingToolMapper;


    /**
    * @Title: addSynthesisCuttingToolLocation
    * @Description: 新增SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocation
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSynthesisCuttingToolLocation(SynthesisCuttingToolLocation synthesisCuttingToolLocation) throws Exception{
        synthesisCuttingToolLocationMapper.addSynthesisCuttingToolLocation(synthesisCuttingToolLocation);
    }

    /**
    * @Title: delSynthesisCuttingToolLocation
    * @Description: 删除SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocation
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolLocation(SynthesisCuttingToolLocation synthesisCuttingToolLocation) throws Exception{
        synthesisCuttingToolLocationMapper.delSynthesisCuttingToolLocation(synthesisCuttingToolLocation);
    }

    /**
    * @Title: delSynthesisCuttingToolLocationForLogic
    * @Description: 逻辑删除SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocation
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolLocationForLogic(SynthesisCuttingToolLocation synthesisCuttingToolLocation) throws Exception{
        synthesisCuttingToolLocationMapper.delSynthesisCuttingToolLocationForLogic(synthesisCuttingToolLocation);
    }

    /**
    * @Title: delSynthesisCuttingToolLocationByVo
    * @Description: 根据条件删除SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocationVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolLocationByVo(SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO) throws Exception{
        synthesisCuttingToolLocationMapper.delSynthesisCuttingToolLocationByVo(synthesisCuttingToolLocationVO);
    }

    /**
    * @Title: updSynthesisCuttingToolLocation
    * @Description: 动态更新SynthesisCuttingToolLocation
    * @param synthesisCuttingToolLocation
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSynthesisCuttingToolLocation(SynthesisCuttingToolLocation synthesisCuttingToolLocation) throws Exception{
        synthesisCuttingToolLocationMapper.updSynthesisCuttingToolLocation(synthesisCuttingToolLocation);
    }

    /**
    * @Title: getSynthesisCuttingToolLocationByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolLocationVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SynthesisCuttingToolLocation> getSynthesisCuttingToolLocationByPage(SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO) throws Exception{
        synthesisCuttingToolLocationVO.setTotalPage(synthesisCuttingToolLocationMapper.getSynthesisCuttingToolLocationCount(synthesisCuttingToolLocationVO));
        return synthesisCuttingToolLocationMapper.getSynthesisCuttingToolLocationByPage(synthesisCuttingToolLocationVO);
    }

    /**
    * @Title: getSynthesisCuttingToolLocationCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolLocationVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolLocationCount(SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO) throws Exception{
        return synthesisCuttingToolLocationMapper.getSynthesisCuttingToolLocationCount(synthesisCuttingToolLocationVO);
    }

    /**
    * @Title: getSynthesisCuttingToolLocation
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolLocationVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolLocation getSynthesisCuttingToolLocation(SynthesisCuttingToolLocationVO synthesisCuttingToolLocationVO) throws Exception{
        return synthesisCuttingToolLocationMapper.getSynthesisCuttingToolLocation(synthesisCuttingToolLocationVO);
    }

}
