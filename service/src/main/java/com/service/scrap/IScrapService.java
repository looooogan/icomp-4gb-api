package com.service.scrap;

import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.CuttingToolsScrap;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.CuttingToolVO;
import com.service.scrap.bo.ScrapBO;

import java.util.List;

/**
 * Created by logan on 2018/5/6.
 */
public interface IScrapService {

    /**
     * 根据材料号获取材料刀
     * @param cuttingToolVO
     * @return
     * @throws Exception
     */
    public CuttingTool getCuttingTool(CuttingToolVO cuttingToolVO) throws Exception;


    /**
     * 根据RFID获取合成刀信息
     * @param cuttingToolBindVO
     * @return
     * @throws Exception
     */
    public CuttingToolBind getCuttingToolBind(CuttingToolBindVO cuttingToolBindVO) throws Exception;

    /**
     * 批量报废
     * @param scrapBO 报废刀具
     * @throws Exception
     */
    public void addScraps(ScrapBO scrapBO) throws Exception;

}
