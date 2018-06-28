package com.service.synthesiscuttingtool.impl;

import com.common.mapper.ISynthesisBladeCodeMapper;
import com.common.mapper.ISynthesisCuttingToolMapper;
import com.common.pojo.SynthesisBladeCode;
import com.common.pojo.SynthesisCuttingTool;
import com.common.utils.NumberFormart;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.SynthesisBladeCodeVO;
import com.common.vo.SynthesisCuttingToolVO;
import com.service.synthesiscuttingtool.ISynthesisBladeBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by logan on 2018/6/17.
 */
@Service("SynthesisBladeBusinessServiceImpl")
public class SynthesisBladeBusinessServiceImpl implements ISynthesisBladeBusinessService {

    @Autowired
    private ISynthesisBladeCodeMapper bladeCodeMapper;
    @Autowired
    private IMessageSourceHanlder messageHandler;
    @Autowired
    private ISynthesisCuttingToolMapper synthesisCuttingToolMapper;

    /**
     * 查询合成刀刀身码
     * @param synthesisBladeCodeVO
     * @return
     * @throws Exception
     */
    @Override
    public List<SynthesisBladeCode> queryBladeCodeBySynthesis(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception {
        SynthesisCuttingToolVO synthesisCuttingToolVO = new SynthesisCuttingToolVO();
        synthesisCuttingToolVO.setSynthesisCode(synthesisBladeCodeVO.getSynthesisCode());
        SynthesisCuttingTool synthesisCuttingTool = synthesisCuttingToolMapper.getSynthesisCuttingTool(synthesisCuttingToolVO);
        if (null == synthesisCuttingTool){
            throw new SelfDefinedException(messageHandler.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_NOT_EXISTS));
        }
        synthesisBladeCodeVO.setStatus("0");
        synthesisBladeCodeVO.setSynthesisCuttingToolCode(synthesisCuttingTool.getCode());
        return bladeCodeMapper.getSynthesisBladeCodeByPage(synthesisBladeCodeVO);
    }

    /**
     * 分组查询合成刀刀身码
     * @param synthesisBladeCodeVO
     * @return
     * @throws Exception
     */
    @Override
    public List<SynthesisBladeCode> queryGroupBladeCode(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception {
        synthesisBladeCodeVO.setTotalPage(bladeCodeMapper.getSynthesisBladeCodeCountForGroup(synthesisBladeCodeVO));
        return bladeCodeMapper.getSynthesisBladeCodeForGroup(synthesisBladeCodeVO);
    }

    /**
     * 添加合成刀刀身码
     * @param synthesisBladeCodeVO
     * @throws Exception
     */
    @Override
    public void addBladeCode(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception {
        SynthesisCuttingToolVO synthesisCuttingToolVO = new SynthesisCuttingToolVO();
        synthesisCuttingToolVO.setSynthesisCode(synthesisBladeCodeVO.getSynthesisCode());
        SynthesisCuttingTool synthesisCuttingTool = synthesisCuttingToolMapper.getSynthesisCuttingTool(synthesisCuttingToolVO);
        if (null == synthesisCuttingTool){
            throw new SelfDefinedException(messageHandler.getValue(ExceptionConstans.SYNTHESISCUTTINGTOOL_NOT_EXISTS));
        }

        SynthesisBladeCodeVO tmpVO = new SynthesisBladeCodeVO();
        tmpVO.setSynthesisCuttingToolCode(synthesisCuttingTool.getCode());
        List<SynthesisBladeCode> bladeCodes = bladeCodeMapper.getSynthesisBladeCodeByPage(tmpVO);
        if (null!=bladeCodes&&bladeCodes.size()>0){
            throw new SelfDefinedException(messageHandler.getValue(ExceptionConstans.SYNTHESIS_BLADE_TOOLEXISTS));
        }
        Integer maxValue = bladeCodeMapper.getMaxValue();
        Integer minValue = bladeCodeMapper.getMinValue();

        do {
            if (null == maxValue || null == minValue){
                break;
            }
            if ((minValue<=synthesisBladeCodeVO.getMinValue()&&maxValue>=synthesisBladeCodeVO.getMinValue())
                    ||(minValue<=synthesisBladeCodeVO.getMaxValue()&&maxValue>=synthesisBladeCodeVO.getMaxValue())){
                throw new SelfDefinedException(messageHandler.getValue(ExceptionConstans.SYNTHESIS_BLADE_ERROR));
            }
        }while (false);


        SynthesisBladeCode synthesisBladeCode = null;
        for (int i = synthesisBladeCodeVO.getMinValue();i<=synthesisBladeCodeVO.getMaxValue();i++){
            synthesisBladeCode = new SynthesisBladeCode();
            synthesisBladeCode.setIsDel(0);
            synthesisBladeCode.setSynthesisCuttingToolCode(synthesisCuttingTool.getCode());
            synthesisBladeCode.setMaxValue(synthesisBladeCodeVO.getMaxValue());
            synthesisBladeCode.setMinValue(synthesisBladeCodeVO.getMinValue());
            synthesisBladeCode.setBladeCode(NumberFormart.prefix0(i));
            synthesisBladeCode.setStatus("0");
            bladeCodeMapper.addSynthesisBladeCode(synthesisBladeCode);
        }
    }

    /**
     * 修改合成刀刀身码
     * @param synthesisBladeCodeVO
     * @throws Exception
     */
    @Override
    public void updBladeCode(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception {

    }
}
