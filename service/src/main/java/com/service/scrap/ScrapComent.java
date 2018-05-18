package com.service.scrap;

import com.service.common.ICuttingToolBindService;
import com.service.common.IDjItrnAkpService;
import com.service.inoutFactory.IInOutFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by logan on 2018/5/12.
 */
@Component("ScrapComent")
public class ScrapComent {

    @Autowired
    private IInOutFactoryService inOutFactoryService;
    @Autowired
    private ICuttingToolBindService cuttingToolBindService;
    @Autowired
    private IDjItrnAkpService djItrnAkpService;
    @Autowired
    private IScrapService scrapService;


    public void scrap(ScrapVO scrapVO) throws Exception{
//        scrapService.addScraps(scraps);
    }
}
