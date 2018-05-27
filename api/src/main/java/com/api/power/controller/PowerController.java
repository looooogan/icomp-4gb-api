package com.api.power.controller;


import com.api.base.controller.BaseController;
import com.common.constants.PowerTypeEnum;
import com.common.pojo.AuthCustomer;
import com.common.pojo.Power;
import com.common.vo.PowerVO;
import com.service.power.IPowerService;
import com.service.power.vo.PowerSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
*
* @ClassName PowerController
* @Description PowerController控制器
* @author Jivoin
*/
@Controller
@RequestMapping("power")
public class PowerController extends BaseController{

    @Autowired
    private IPowerService powerService;


    /**
    * @Title: add
    * @Description: 添加Power
    * @param power
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody Power power) throws Exception{
        this.powerService.addPower(power);
    }

    /**
    * @Title: update
    * @Description: 修改Power
    * @param power
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody Power power) throws  Exception{
        this.powerService.updPower(power);
    }

    /**
    * @Title: del
    * @Description: 删除Power
    * @param power
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody Power power) throws  Exception{
        this.powerService.delPowerForLogic(power);
    }

    /**
    * @Title: getPowerByVo
    * @Description: 根据查询条件查询
    * @param powerVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public Power getPowerByVo(@RequestBody PowerVO powerVO) throws  Exception{
        return this.powerService.getPower(powerVO);
    }

    /**
    * @Title: getPowerByPage
    * @Description: 根据查询条件查询
    * @param powerVO
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getPowerByPage(@RequestBody PowerVO powerVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("data",this.powerService.getPowerByPage(powerVO));
        result.put("vo",powerVO);
        return result;
    }

    /**
     * @Title: getPowerForSetting
     * @Description: 根据查询条件查询
     * @param powerSearchVO
     * @throws Exception
     * @return: void
     */
    @RequestMapping(value = "getPowerForSetting",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getPowerForSetting(@RequestBody PowerSearchVO powerSearchVO) throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("powerList",this.powerService.getPowerForSetting(powerSearchVO));
        result.put("powerInUse",this.powerService.getPowerByVO(powerSearchVO));
        result.put("vo",powerSearchVO);
        return result;
    }


    /**
     * @Title: getPowerForSetting
     * @Description: 根据查询条件查询
     * @param powerSearchVO
     * @throws Exception
     * @return: void
     */
    @RequestMapping(value = "getPowerForUser",method = RequestMethod.POST)
    @ResponseBody
    public List<Power> getPowerForUser(@RequestBody PowerSearchVO powerSearchVO) throws Exception{
        return this.powerService.getPowerByVO(powerSearchVO);
    }


    /**
     * @Title: impower
     * @Description: 根据查询条件查询
     * @param powerSearchVO
     * @throws Exception
     * @return: void
     */
    @RequestMapping(value = "impower",method = RequestMethod.POST)
    @ResponseBody
    public AuthCustomer impower(@RequestBody PowerSearchVO powerSearchVO) throws Exception{
        return this.powerService.imPower(powerSearchVO);
    }

    /**
    * @Title: toListPage
    * @Description: 跳转到列表页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toListPage")
    public String toListPage() throws Exception{
        return "/power/powerList";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/power/powerInsAndUpd";
    }

    @RequestMapping("toSettingPage/{id}")
    public String toSettingPage (Model model, @PathVariable("id") Integer id) throws Exception{
        System.out.println(id);
        PowerSearchVO powerSearchVO = new PowerSearchVO();
        powerSearchVO.setIsRoot(PowerTypeEnum.root.getTypeKey());
        model.addAttribute("powerList",powerService.getPowerForSetting(powerSearchVO));
        powerSearchVO.setIsRoot(null);
        powerSearchVO.setPositionId(id);
        model.addAttribute("powerInUse",powerService.getPowerForSetting(powerSearchVO));
        return "/auth/role_setting";
    }

    @RequestMapping("bindPower")
    @ResponseBody
    public void bindPower(@RequestBody PowerSearchVO powerSearchVO) throws Exception{
        powerService.bindPowersData(powerSearchVO);
    }

}
