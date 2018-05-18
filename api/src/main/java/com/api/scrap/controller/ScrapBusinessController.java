package com.api.scrap.controller;

import com.api.base.controller.BaseController;
import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.pojo.CuttingToolsScrap;
import com.common.vo.AuthCustomerVO;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.CuttingToolVO;
import com.service.common.IAuthCustomerService;
import com.service.scrap.IScrapService;
import com.service.scrap.ScrapComent;
import com.service.scrap.ScrapVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by logan on 2018/5/6.
 */
@Controller
@RequestMapping("ScrapBusiness")
public class ScrapBusinessController extends BaseController {

    @Autowired
    private IScrapService scrapService;
    @Autowired
    private IAuthCustomerService authCustomerService;
    @Autowired
    private ScrapComent scrapComent;

    @RequestMapping("getCuttingTool")
    @ResponseBody
    public CuttingTool getCuttingTool(@RequestBody CuttingToolVO cuttingToolVO) throws Exception{
        return scrapService.getCuttingTool(cuttingToolVO);
    }

    @RequestMapping("getCuttingToolBind")
    @ResponseBody
    public CuttingToolBind getCuttingToolBind(@RequestBody CuttingToolBindVO cuttingToolBindVO) throws Exception{
        return scrapService.getCuttingToolBind(cuttingToolBindVO);
    }

    @RequestMapping("addScrap")
    @ResponseBody
    public void addScrap(@RequestBody ScrapVO scrapVO,@RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomerCode);
        scrapVO.setAuthCustomer(authCustomerService.getAuthCustomer(authCustomerVO));
        scrapComent.scrap(scrapVO);
//         scrapService.addScraps(scraps);
    }

}
