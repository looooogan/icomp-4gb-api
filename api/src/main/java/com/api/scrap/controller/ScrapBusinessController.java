package com.api.scrap.controller;

import com.api.base.controller.BaseController;
import com.common.pojo.CuttingTool;
import com.common.pojo.CuttingToolBind;
import com.common.vo.AuthCustomerVO;
import com.common.vo.CuttingToolBindVO;
import com.common.vo.CuttingToolVO;
import com.service.common.IAuthCustomerService;
import com.service.scrap.IScrapService;
import com.service.scrap.ScrapComent;
import com.service.scrap.vo.ScrapVO;
import com.service.scrap.bo.ScrapBO;
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

    /**
     * 刀具报废 旧版本
     * @param scrapVO
     * @param authCustomerCode
     * @throws Exception
     */
    @RequestMapping("addScrapOld")
    @ResponseBody
    public void addScrapOld(@RequestBody ScrapVO scrapVO,@RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomerCode);
//        scrapVO.setAuthCustomer(authCustomerService.getAuthCustomer(authCustomerVO));
//        scrapComent.scrap(scrapVO);
//         scrapService.addScraps(scraps);
    }


    /**
     * 刀具报废
     * @param scrapBO 报废信息
     * @param authCustomerCode 操作者
     * @throws Exception
     */
    @RequestMapping("addScrap")
    @ResponseBody
    public void addScrap(@RequestBody ScrapBO scrapBO,@RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        AuthCustomerVO authCustomerVO = new AuthCustomerVO();
        authCustomerVO.setCode(authCustomerCode);
        scrapBO.setLoginUser(authCustomerService.getAuthCustomer(authCustomerVO));
        scrapComent.scrap(scrapBO);
//         scrapService.addScraps(scraps);
    }

}
