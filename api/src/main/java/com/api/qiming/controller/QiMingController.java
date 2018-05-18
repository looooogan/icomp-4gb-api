package com.api.qiming.controller;

import com.api.base.controller.BaseController;
import com.service.orders.IOutApplyBusinessService;
import com.service.orders.QiMingComent;
import com.service.orders.vo.OutApplyVO;
import com.service.orders.vo.SearchOutLiberaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by logan on 2018/5/7.
 */

@Controller
@RequestMapping("qiMing")
public class QiMingController extends BaseController{

    @Autowired
    private IOutApplyBusinessService qiMingService;

    @Autowired
    private QiMingComent qiMingComent;


    @RequestMapping("getOrders")
    @ResponseBody
    public List<SearchOutLiberaryVO> getOrders() throws Exception{

        return qiMingComent.getOrders();
    }

    /**
     * 出库
     * @param outApplyVO
     * @throws Exception
     */
    @RequestMapping("outApply")
    @ResponseBody
    public void outApply(@RequestBody OutApplyVO outApplyVO) throws Exception{
        qiMingComent.outApply(outApplyVO);
    }


    @RequestMapping("dataSouceTest")
    @ResponseBody
    public void dataSouceTest() throws Exception{
//        qiMingComent.dataTest();
    }


}
