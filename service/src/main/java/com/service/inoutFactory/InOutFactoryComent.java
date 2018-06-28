package com.service.inoutFactory;

import com.service.inoutFactory.bo.InOutGrindingBO;
import com.service.writeback.IDjWriteBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by logan on 2018/5/12.
 */
@Component("InOutFactoryComent")
public class InOutFactoryComent {
    @Autowired
    private IInOutFactoryService inOutFactoryService;
    @Autowired
    private IDjWriteBackService writeBackService;

    /**
     * 场内刃磨
     * @param inOutGrindingBO
     * @throws Exception
     */
    public void inSideGrinding(InOutGrindingBO inOutGrindingBO) throws Exception{
        //刃磨
        inOutFactoryService.insideGrindingData(inOutGrindingBO);
        //回写
        writeBackService.writeBackGrindingIn(inOutGrindingBO);
    }

    /**
     * 场外刃磨
     * @param inOutGrindingBO
     * @throws Exception
     */
    public void outSideGrinding(InOutGrindingBO inOutGrindingBO) throws Exception{
        //刃磨
        inOutFactoryService.outsideGrindingData(inOutGrindingBO);
        //回写
        writeBackService.writeBackGrindingOut(inOutGrindingBO);
    }
}
