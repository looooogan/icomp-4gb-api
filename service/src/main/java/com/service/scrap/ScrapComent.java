package com.service.scrap;

import com.service.common.ICuttingToolBindService;
import com.service.common.ICuttingToolService;
import com.service.scrap.bo.ScrapBO;
import com.service.scrap.vo.ScrapVO;
import com.service.writeback.IDjWriteBackService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by logan on 2018/5/12.
 */
@Component("ScrapComent")
public class ScrapComent {

    @Autowired
    private ICuttingToolBindService cuttingToolBindService;
    @Autowired
    private ICuttingToolService cuttingToolService;
    @Autowired
    private IScrapService scrapService;
    @Autowired
    private IDjWriteBackService writeBackService;



    /**
     * 刀具报废
     * @param scrapBO
     * @throws Exception
     */
    public void scrap(ScrapBO scrapBO) throws Exception{
        //报废
        scrapService.addScraps(scrapBO);
        //数据回写
        writeBackService.writeBackScrap(scrapBO);
    }

}
