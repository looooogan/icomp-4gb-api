package com.service.scrap.impl;

import com.common.mapper.ICuttingToolBindMapper;
import com.common.mapper.ICuttingToolMapper;
import com.common.mapper.ICuttingToolsScrapMapper;
import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.CuttingToolsScrap;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.CuttingToolVO;
import com.service.inoutFactory.vo.SharpenVO;
import com.service.scrap.IScrapService;
import com.service.scrap.ScrapVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by logan on 2018/5/6.
 */
@Service("scrapBusinessService")
public class ScrapServiceImpl implements IScrapService{

    @Autowired
    private ICuttingToolMapper cuttingToolMapper;

    @Autowired
    private ICuttingToolBindMapper cuttingToolBindMapper;

    @Autowired
    private ICuttingToolsScrapMapper scrapMapper;


    @Override
    public CuttingTool getCuttingTool(CuttingToolVO cuttingToolVO) throws Exception {
        return cuttingToolMapper.getCuttingTool(cuttingToolVO);
    }

    @Override
    public CuttingToolBind getCuttingToolBind(CuttingToolBindVO cuttingToolBindVO) throws Exception {
        return cuttingToolBindMapper.getCuttingToolBind(cuttingToolBindVO);
    }

    @Override
    public void addScraps(ScrapVO scrapVO) throws Exception {
        for (SharpenVO sharpenVO : scrapVO.getSharpenVOS()) {

        }

//        for (CuttingToolsScrap scrap : scraps) {
//            scrapMapper.addCuttingToolsScrap(scrap);
//            //修改材料刀库存
//        }
    }
}
