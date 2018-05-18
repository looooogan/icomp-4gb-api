package ${entity.tablePackageInfo['serviceImpl']};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${entity.tablePackageInfo['daoInterFace']}.I${entity.classType}Mapper;
import ${entity.tablePackageInfo['serviceInterFace']}.I${entity.classType}Service;
import ${entity.tablePackageInfo['pojo']}.${entity.classType};
import ${entity.tablePackageInfo['vo']}.${entity.classType}VO;
import java.util.*;


/**
 * 
 * @ClassName ${entity.classType}ServiceImpl
 * @Description TODO
 * @author ${entity.author}
 * @date ${entity.createTime}
 */
 @Service("${entity.name}Service")
public class ${entity.classType}ServiceImpl implements I${entity.classType}Service{

    @Autowired
    private I${entity.classType}Mapper ${entity.name}Mapper;
    
    /**
     * @Title: add${entity.classType}
     * @Description: 新增${entity.classType}
     * @param ${entity.name}
     * @throws Exception
     * @return: void
     */
    public void add${entity.classType}(${entity.classType} ${entity.name}) throws Exception {
        ${entity.name}Mapper.add${entity.classType}(${entity.name});
    }
    
    /**
     * @Title: del${entity.classType}
     * @Description: 删除${entity.classType}
     * @param ${entity.name}
     * @throws Exception
     * @return: void
     */
    public void delete${entity.classType}(${entity.classType} ${entity.name}) throws Exception {
        ${entity.name}Mapper.del${entity.classType}(${entity.name});
    }

    /**
    * @Title: del${entity.name}
    * @Description: 逻辑删除${entity.name}
    * @param ${entity.name}
    * @throws Exception
    * @return: void
    */
    public void delete${entity.classType}ForLogic(${entity.classType} ${entity.name}) throws Exception{
        ${entity.name}Mapper.del${entity.classType}ForLogic(${entity.name});
    }

    /**
     * @Title: upd${entity.classType}
     * @Description: 更新${entity.classType}
     * @param ${entity.name}
     * @throws Exception
     * @return: void
     */
    public void update${entity.classType}(${entity.classType} ${entity.name}) throws Exception {
        ${entity.name}Mapper.upd${entity.classType}(${entity.name});
    }

    /**
    * @Title: get${entity.name}ByPage
    * @Description: 分页查询${entity.name}
    * @param ${entity.name}Vo
    * @throws Exception
    * @return: void
    */
    public List<${entity.classType}> get${entity.classType}ByPage(${entity.classType}VO ${entity.name}Vo) throws Exception{
        ${entity.name}Vo.setPageTotalCount(${entity.name}Mapper.get${(entity.name)!?cap_first}Count(${entity.name}Vo));
        return ${entity.name}Mapper.get${entity.classType}ByPage( ${entity.name}Vo);
    }

    /**
    * @Title: get${entity.name}
    * @Description: 根据vo中的条件查询${entity.name}
    * @param ${entity.name}Vo
    * @throws Exception
    * @return: void
    */
    public ${entity.classType} get${entity.classType}(${entity.classType}VO ${entity.name}Vo) throws Exception{
        return ${entity.name}Mapper.get${entity.classType}( ${entity.name}Vo);
    }
}