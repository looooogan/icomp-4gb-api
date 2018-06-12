package com.api.rfid.controller;

import com.api.base.controller.BaseController;
import com.service.rfid.IFastQueryService;
import com.service.rfid.vo.FastQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by logan on 2018/5/26.
 */
@Controller
@RequestMapping("RFID")
public class RfidController extends BaseController{

    @Autowired
    private IFastQueryService fastQueryService;

    @RequestMapping("fastQuery")
    @ResponseBody
    public FastQueryVO fastQuery(@RequestBody FastQueryVO fastQueryVO) throws Exception{
        return fastQueryService.fastQuery(fastQueryVO);
    }

    @RequestMapping("querySyn")
    @ResponseBody
    public FastQueryVO querySyn(@RequestBody FastQueryVO fastQueryVO) throws Exception{
        return fastQueryService.fastQuery(fastQueryVO);
    }
    @RequestMapping("queryForBind")
    @ResponseBody
    public FastQueryVO queryForBind(@RequestBody FastQueryVO fastQueryVO) throws Exception{
        return fastQueryService.fastQuery(fastQueryVO);
    }


}
