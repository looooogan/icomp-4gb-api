package ${entity.tablePackageInfo['controller']};

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.anbo.base.controller.BaseController;
import ${entity.tablePackageInfo['vo']}.${entity.classType}VO;
import ${entity.tablePackageInfo['serviceInterFace']}.I${entity.classType}Service;
import ${entity.tablePackageInfo['pojo']}.${entity.classType};
import ${entity.tablePackageInfo['vo']}.${entity.classType}VO;


/**
 * 
 * @ClassName: ${entity.classType}Controller
 * @Description: TODO
 * @author ${entity.author}
 * @date: ${entity.createTime}
 */
@Controller
@RequestMapping("${entity.classType?uncap_first}")
public class ${entity.classType}Controller extends BaseController{

    @Autowired
    private I${entity.classType}Service ${entity.name}Service;

    /**
    * @Title: add
    * @Description: 添加${entity.classType}
    * @param ${entity.name}
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody ${entity.classType} ${entity.name}) throws Exception{
        this.${entity.name}Service.add${entity.classType}(${entity.name});
    }

    /**
    * @Title: update
    * @Description: 修改${entity.classType}
    * @param ${entity.name}
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "upd",method = RequestMethod.POST)
    @ResponseBody
    public void update(@RequestBody ${entity.classType} ${entity.name}) throws  Exception{
        this.${entity.name}Service.update${entity.classType}(${entity.name});
    }

    /**
    * @Title: del
    * @Description: 删除${entity.classType}
    * @param ${entity.name}
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public void del(@RequestBody ${entity.classType} ${entity.name}) throws  Exception{
        this.${entity.name}Service.delete${entity.classType}ForLogic(${entity.name});
    }

    /**
    * @Title: get${entity.classType}ByVo
    * @Description: 根据查询条件查询
    * @param ${entity.name}Vo
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public ${entity.classType} get${entity.classType}ByVo(@RequestBody ${entity.classType}VO ${entity.name}Vo) throws  Exception{
        return this.${entity.name}Service.get${entity.classType}(${entity.name}Vo);
    }

    /**
    * @Title: get${entity.classType}ByPage
    * @Description: 根据查询条件查询
    * @param ${entity.name}Vo
    * @throws Exception
    * @return: void
    */
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public List<${entity.classType}> get${entity.classType}ByPage(@RequestBody ${entity.classType}VO ${entity.name}Vo) throws Exception{
        return this.${entity.name}Service.get${entity.classType}ByPage(${entity.name}Vo);
    }

    /**
    * @Title: toListPage
    * @Description: 跳转到列表页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toListPage")
    public String toListPage() throws Exception{
        return "/${entity.name}/${entity.name}${webListNameSuffix}";
    }

    /**
    * @Title: toInsAndUpdPage
    * @Description: 跳转到添加 修改页面
    * @throws Exception
    * @return: void
    */
    @RequestMapping("toInsAndUpdPage")
    public String toInsAndUpdPage() throws Exception{
        return "/${entity.name}/${entity.name}${webInsNameSuffix}";
    }

}