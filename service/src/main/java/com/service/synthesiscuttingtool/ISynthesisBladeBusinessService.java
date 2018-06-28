package com.service.synthesiscuttingtool;

import com.common.pojo.SynthesisBladeCode;
import com.common.vo.SynthesisBladeCodeVO;

import java.util.List;

/**
 * Created by logan on 2018/6/17.
 */
public interface ISynthesisBladeBusinessService {

    /**
     * 根据合成刀信息查询刀身码
     * @param synthesisBladeCodeVO
     * @return
     * @throws Exception
     */
    public List<SynthesisBladeCode> queryBladeCodeBySynthesis(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception;


    /**
     * 分组查询合成刀刀身码
     * @param synthesisBladeCodeVO
     * @return
     * @throws Exception
     */
    public List<SynthesisBladeCode> queryGroupBladeCode(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception;

    /**
     * 添加合成刀刀身码
     * @param synthesisBladeCodeVO
     * @return
     * @throws Exception
     */
    public void addBladeCode(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception;

    /**
     * 修改合成刀刀身码
     * @param synthesisBladeCodeVO
     * @return
     * @throws Exception
     */
    public void updBladeCode(SynthesisBladeCodeVO synthesisBladeCodeVO) throws Exception;






}
