package com.api.library.controller;

import com.api.base.controller.BaseController;
import com.common.pojo.AuthCustomer;
import com.service.orders.LibraryComent;
import com.service.orders.vo.OutApplyVO;
import com.service.orders.vo.SearchOutLiberaryVO;
import com.service.orders.vo.WBCuttingToolBindVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by logan on 2018/6/9.
 */
@Controller
@RequestMapping("library")
public class LibraryController extends BaseController {

    @Autowired
    private LibraryComent libraryComent;


    @RequestMapping("getOrders")
    @ResponseBody
    public List<SearchOutLiberaryVO> queryUnOutOrders() throws Exception{
        return libraryComent.getUnOutOrders();
    }

    /**
     * 出库
     * @param outApplyVO
     * @throws Exception
     */
    @RequestMapping("outApply")
    @ResponseBody
    public void outApply(@RequestBody OutApplyVO outApplyVO, @RequestHeader("loginUserCode") String authCustomerCode) throws Exception{
        AuthCustomer authCustomer = new AuthCustomer();
        authCustomer.setCode(authCustomerCode);
        outApplyVO.setLoginUser(authCustomer);
        libraryComent.outApply(outApplyVO);
    }

}
