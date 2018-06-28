package com.service.synthesiscuttingtool;

import com.common.mapper.ISynthesisBladeCodeMapper;
import com.common.pojo.SynthesisBladeCode;
import com.common.utils.exception.ExceptionConstans;
import com.common.utils.exception.SelfDefinedException;
import com.common.utils.loadConfig.IMessageSourceHanlder;
import com.common.vo.SynthesisBladeCodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by logan on 2018/6/17.
 */
@Component("BladeModel")
public class BladeModel {

    @Autowired
    private ISynthesisBladeCodeMapper bladeCodeMapper;
    @Autowired
    private IMessageSourceHanlder messageSourceHanlder;

    /**
     * 校验合成刀刀身码
     * @return
     * @throws Exception
     */
    public SynthesisBladeCode checkBladeCode(SynthesisBladeCodeVO bladeCodeVO) throws Exception{
        SynthesisBladeCode synthesisBladeCode = bladeCodeMapper.getSynthesisBladeCode(bladeCodeVO);
        if (null == synthesisBladeCode){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESIS_BIND_NOTEXISTS));
        }
        if (synthesisBladeCode.getStatus().equals("1")){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESIS_BLADE_INUSE));
        }
        synthesisBladeCode.setStatus("1");
        bladeCodeMapper.updSynthesisBladeCode(synthesisBladeCode);
        return synthesisBladeCode;
    }

    /**
     * 更新合成刀刀身码状态为绑定
     * @param synthesisBladeCodeVO
     * @throws Exception
     */
    public void bindBladeCode(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception{
        SynthesisBladeCode synthesisBladeCode = bladeCodeMapper.getSynthesisBladeCode(synthesisBladeCodeVO);
        if (null == synthesisBladeCode){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESIS_BIND_NOTEXISTS));
        }
        if (synthesisBladeCode.getStatus().equals("1")){
            throw new SelfDefinedException(messageSourceHanlder.getValue(ExceptionConstans.SYNTHESIS_BLADE_INUSE));
        }
        synthesisBladeCode.setStatus("1");
        bladeCodeMapper.updSynthesisBladeCode(synthesisBladeCode);
    }

}
