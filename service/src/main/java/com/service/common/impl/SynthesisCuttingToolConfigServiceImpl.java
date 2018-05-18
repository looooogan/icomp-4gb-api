package com.service.common.impl;


import com.common.mapper.*;
import com.common.pojo.CuttingTool;
import com.common.pojo.SynthesisCuttingTool;
import com.common.pojo.SynthesisCuttingToolConfig;
import com.common.pojo.SynthesisCuttingToolLocationConfig;
import com.common.utils.UUID;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.CuttingToolVO;
import com.common.vo.SynthesisCuttingToolConfigVO;
import com.common.vo.SynthesisCuttingToolLocationConfigVO;
import com.common.vo.SynthesisCuttingToolVO;
import com.service.common.ISynthesisCuttingToolConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
*
* @ClassName SynthesisCuttingToolConfigServiceImpl
* @Description SynthesisCuttingToolConfig业务实现类
* @author Jivoin
*/
@Service("synthesisCuttingToolConfigService")
public class SynthesisCuttingToolConfigServiceImpl implements ISynthesisCuttingToolConfigService{

    @Autowired
    private ISynthesisCuttingToolConfigMapper synthesisCuttingToolConfigMapper;

    @Autowired
    private ISynthesisCuttingToolMapper synthesisCuttingToolMapper;
    @Autowired
    private ISynthesisCuttingToolTypeMapper synthesisCuttingToolTypeMapper;
    @Autowired
    private ISynthesisCuttingToolLocationConfigMapper synthesisCuttingToolLocationConfigMapper;

    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;


    /**
    * @Title: addSynthesisCuttingToolConfig
    * @Description: 新增SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfig
    * @throws Exception
    * @return: void
    */
    @Override
    public void addSynthesisCuttingToolConfig(SynthesisCuttingToolConfig synthesisCuttingToolConfig) throws Exception{
        //添加合成刀信息
        SynthesisCuttingToolVO synthesisCuttingToolVO = new SynthesisCuttingToolVO();
        synthesisCuttingToolVO.setSynthesisCode(synthesisCuttingToolConfig.getSynthesisCuttingTool().getSynthesisCode());
        synthesisCuttingToolVO.setIsDel(0);
        SynthesisCuttingTool synthesisCuttingToolTemp = synthesisCuttingToolMapper.getSynthesisCuttingTool(synthesisCuttingToolVO);
        if (synthesisCuttingToolTemp!= null){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_CONFIG_EXISTS));
        }
        SynthesisCuttingTool synthesisCuttingTool = synthesisCuttingToolConfig.getSynthesisCuttingTool();
        synthesisCuttingTool.setCode(UUID.getInstance());
        synthesisCuttingTool.setIsDel(0);
        synthesisCuttingToolMapper.addSynthesisCuttingTool(synthesisCuttingTool);
        //添加合成刀配置
        synthesisCuttingToolConfig.setSynthesisCuttingToolCode(synthesisCuttingTool.getCode());
        synthesisCuttingToolConfig.setIsDel(0);
        synthesisCuttingToolConfigMapper.addSynthesisCuttingToolConfig(synthesisCuttingToolConfig);

        //添加具体配置
        CuttingToolVO cuttingToolVO;
        CuttingToolVO replaceCuttingToolVO1;
        CuttingToolVO replaceCuttingToolVO2;
        CuttingTool replaceCuttingToolTemp1 = null;
        CuttingTool replaceCuttingToolTemp2 = null;
        List<SynthesisCuttingToolLocationConfig> LocationConfigs = synthesisCuttingToolConfig.getSynthesisCuttingToolLocationConfigList();
        for (SynthesisCuttingToolLocationConfig locationConfig : LocationConfigs) {
            cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setIsDel(0);
            cuttingToolVO.setBusinessCode(locationConfig.getCuttingTool().getBusinessCode());
            CuttingTool cuttingToolTemp = cuttingToolMapper.getCuttingTool(cuttingToolVO);
            if (cuttingToolTemp == null){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.CUTTINGTOOL_NOT_EXISTS));
            }

            if (!StringUtils.isBlank(locationConfig.getReplaceCuttingTool1().getBusinessCode())){
                replaceCuttingToolVO1 = new CuttingToolVO();
                replaceCuttingToolVO1.setIsDel(0);
                replaceCuttingToolVO1.setBusinessCode(locationConfig.getReplaceCuttingTool1().getBusinessCode());
                replaceCuttingToolTemp1 = cuttingToolMapper.getCuttingTool(replaceCuttingToolVO1);
                if (replaceCuttingToolTemp1 == null){
                    throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.CUTTINGTOOL_NOT_EXISTS));
                }
            }
            if (!StringUtils.isBlank(locationConfig.getReplaceCuttingTool2().getBusinessCode())){
                replaceCuttingToolVO2 = new CuttingToolVO();
                replaceCuttingToolVO2.setIsDel(0);
                replaceCuttingToolVO2.setBusinessCode(locationConfig.getReplaceCuttingTool2().getBusinessCode());
                replaceCuttingToolTemp2 = cuttingToolMapper.getCuttingTool(replaceCuttingToolVO2);
                if (replaceCuttingToolTemp2 == null){
                    throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.CUTTINGTOOL_NOT_EXISTS));
                }
            }
            locationConfig.setCuttingToolCode(cuttingToolTemp.getCode());
            if (null!=replaceCuttingToolTemp1){
                locationConfig.setReplaceCuttingToolCode1(replaceCuttingToolTemp1.getCode());
            }
            if (null!=replaceCuttingToolTemp2){
                locationConfig.setReplaceCuttingToolCode2(replaceCuttingToolTemp2.getCode());
            }
            locationConfig.setIsDel(0);
            locationConfig.setSynthesisCuttingToolConfigId(synthesisCuttingToolConfig.getId());
            synthesisCuttingToolLocationConfigMapper.addSynthesisCuttingToolLocationConfig(locationConfig);
        }

    }

    /**
    * @Title: delSynthesisCuttingToolConfig
    * @Description: 删除SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfig
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolConfig(SynthesisCuttingToolConfig synthesisCuttingToolConfig) throws Exception{
        synthesisCuttingToolConfigMapper.delSynthesisCuttingToolConfig(synthesisCuttingToolConfig);
    }

    /**
    * @Title: delSynthesisCuttingToolConfigForLogic
    * @Description: 逻辑删除SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfig
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolConfigForLogic(SynthesisCuttingToolConfig synthesisCuttingToolConfig) throws Exception{

        SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO = new SynthesisCuttingToolConfigVO();
        synthesisCuttingToolConfigVO.setId(synthesisCuttingToolConfig.getId());
        SynthesisCuttingToolConfig synthesisCuttingToolConfigTmp = synthesisCuttingToolConfigMapper.getSynthesisCuttingToolConfig(synthesisCuttingToolConfigVO);
        //删除合成刀信息
        SynthesisCuttingTool synthesisCuttingTool = synthesisCuttingToolConfigTmp.getSynthesisCuttingTool();
        synthesisCuttingToolMapper.delSynthesisCuttingToolForLogic(synthesisCuttingTool);
        synthesisCuttingTool.setSynthesisCode(synthesisCuttingTool.getCode());
        synthesisCuttingToolMapper.updSynthesisCuttingTool(synthesisCuttingTool);

        //删除具体配置
        SynthesisCuttingToolLocationConfigVO synthesisCuttingToolLocationConfigVO = new SynthesisCuttingToolLocationConfigVO();
        synthesisCuttingToolLocationConfigVO.setSynthesisCuttingToolConfigId(synthesisCuttingToolConfig.getId());
        synthesisCuttingToolLocationConfigMapper.delSynthesisCuttingToolLocationConfigByVo(synthesisCuttingToolLocationConfigVO);

        //删除配置
        synthesisCuttingToolConfigMapper.delSynthesisCuttingToolConfig(synthesisCuttingToolConfig);
    }

    /**
    * @Title: delSynthesisCuttingToolConfigByVo
    * @Description: 根据条件删除SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfigVO 条件封装
    * @throws Exception
    * @return: void
    */
    @Override
    public void delSynthesisCuttingToolConfigByVo(SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO) throws Exception{
        synthesisCuttingToolConfigMapper.delSynthesisCuttingToolConfigByVo(synthesisCuttingToolConfigVO);
    }

    /**
    * @Title: updSynthesisCuttingToolConfig
    * @Description: 动态更新SynthesisCuttingToolConfig
    * @param synthesisCuttingToolConfig
    * @throws Exception
    * @return: void
    */
    @Override
    public void updSynthesisCuttingToolConfig(SynthesisCuttingToolConfig synthesisCuttingToolConfig) throws Exception{
        //删除具体配置s
        SynthesisCuttingToolLocationConfigVO synthesisCuttingToolLocationConfigVO = new SynthesisCuttingToolLocationConfigVO();
        synthesisCuttingToolLocationConfigVO.setSynthesisCuttingToolConfigId(synthesisCuttingToolConfig.getId());
        synthesisCuttingToolLocationConfigMapper.delSynthesisCuttingToolLocationConfigByVo(synthesisCuttingToolLocationConfigVO);

        //添加具体配置
        CuttingToolVO cuttingToolVO;
        CuttingToolVO replaceCuttingToolVO;
        CuttingToolVO replaceCuttingToolVO2;
        CuttingTool replaceCuttingToolTemp = null;
        CuttingTool replaceCuttingToolTemp2 = null;
        List<SynthesisCuttingToolLocationConfig> LocationConfigs = synthesisCuttingToolConfig.getSynthesisCuttingToolLocationConfigList();
        for (SynthesisCuttingToolLocationConfig locationConfig : LocationConfigs) {
            cuttingToolVO = new CuttingToolVO();
            cuttingToolVO.setIsDel(0);
            cuttingToolVO.setBusinessCode(locationConfig.getCuttingTool().getBusinessCode());
            CuttingTool cuttingToolTemp = cuttingToolMapper.getCuttingTool(cuttingToolVO);
            if (cuttingToolTemp == null){
                throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.CUTTINGTOOL_NOT_EXISTS));
            }

            if (!StringUtils.isBlank(locationConfig.getReplaceCuttingTool1().getBusinessCode())){
                replaceCuttingToolVO = new CuttingToolVO();
                replaceCuttingToolVO.setIsDel(0);
                replaceCuttingToolVO.setBusinessCode(locationConfig.getReplaceCuttingTool1().getBusinessCode());
                replaceCuttingToolTemp = cuttingToolMapper.getCuttingTool(replaceCuttingToolVO);
                if (replaceCuttingToolTemp == null){
                    throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.CUTTINGTOOL_NOT_EXISTS));
                }
            }
            if (!StringUtils.isBlank(locationConfig.getReplaceCuttingTool2().getBusinessCode())){
                replaceCuttingToolVO2 = new CuttingToolVO();
                replaceCuttingToolVO2.setIsDel(0);
                replaceCuttingToolVO2.setBusinessCode(locationConfig.getReplaceCuttingTool2().getBusinessCode());
                replaceCuttingToolTemp2 = cuttingToolMapper.getCuttingTool(replaceCuttingToolVO2);
                if (replaceCuttingToolTemp2 == null){
                    throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.CUTTINGTOOL_NOT_EXISTS));
                }
            }
            locationConfig.setCuttingToolCode(cuttingToolTemp.getCode());
            if (null!=replaceCuttingToolTemp){
                locationConfig.setReplaceCuttingToolCode1(replaceCuttingToolTemp.getCode());
            }
            if (null!=replaceCuttingToolTemp2){
                locationConfig.setReplaceCuttingToolCode2(replaceCuttingToolTemp2.getCode());
            }
            locationConfig.setIsDel(0);
            locationConfig.setSynthesisCuttingToolConfigId(synthesisCuttingToolConfig.getId());
            synthesisCuttingToolLocationConfigMapper.addSynthesisCuttingToolLocationConfig(locationConfig);
        }
    }

    /**
    * @Title: getSynthesisCuttingToolConfigByPage
    * @Description: 分页查询
    * @param synthesisCuttingToolConfigVO 查询条件封装
    * @throws Exception
    * @return: 结果集
    */
    @Override
    public List<SynthesisCuttingToolConfig> getSynthesisCuttingToolConfigByPage(SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO) throws Exception{
        synthesisCuttingToolConfigVO.setTotalPage(synthesisCuttingToolConfigMapper.getSynthesisCuttingToolConfigCount(synthesisCuttingToolConfigVO));
        return synthesisCuttingToolConfigMapper.getSynthesisCuttingToolConfigByPage(synthesisCuttingToolConfigVO);
    }

    /**
    * @Title: getSynthesisCuttingToolConfigCount
    * @Description: 获取记录数量
    * @param synthesisCuttingToolConfigVO 查询条件封装
    * @throws Exception
    * @return: Integer
    */
    public Integer getSynthesisCuttingToolConfigCount(SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO) throws Exception{
        return synthesisCuttingToolConfigMapper.getSynthesisCuttingToolConfigCount(synthesisCuttingToolConfigVO);
    }

    /**
    * @Title: getSynthesisCuttingToolConfig
    * @Description: 根据查询条件查询
    * @param synthesisCuttingToolConfigVO 查询条件封装
    * @throws Exception
    * @return: 查询结果
    */
    public SynthesisCuttingToolConfig getSynthesisCuttingToolConfig(SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO) throws Exception{
        return synthesisCuttingToolConfigMapper.getSynthesisCuttingToolConfig(synthesisCuttingToolConfigVO);
    }

    @Override
    public SynthesisCuttingToolConfig searchAndLocations(SynthesisCuttingToolConfigVO synthesisCuttingToolConfigVO) throws Exception {
        SynthesisCuttingToolConfig synthesisCuttingToolConfig = synthesisCuttingToolConfigMapper.getSynthesisCuttingToolConfig(synthesisCuttingToolConfigVO);
        SynthesisCuttingToolLocationConfigVO locationConfigVO = new SynthesisCuttingToolLocationConfigVO();
        locationConfigVO.setSynthesisCuttingToolConfigId(synthesisCuttingToolConfig.getId());
        synthesisCuttingToolConfig.setSynthesisCuttingToolLocationConfigList(synthesisCuttingToolLocationConfigMapper.getSynthesisCuttingToolLocationConfigByPage(locationConfigVO));
        return synthesisCuttingToolConfig;
    }
}
