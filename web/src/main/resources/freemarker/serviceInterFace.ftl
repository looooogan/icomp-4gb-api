package ${entity.tablePackageInfo['serviceInterFace']};

import ${entity.tablePackageInfo['pojo']}.${entity.classType};
import ${entity.tablePackageInfo['vo']}.${entity.classType}VO;
import java.util.*;


/**
 * 
 * @ClassName ${entity.classType}Service
 * @Description TODO
 * @author ${entity.author}
 * @date ${entity.createTime}
 */
public interface I${entity.classType}Service {
    /**
     * @Title: add${entity.classType}
     * @Description: 新增${entity.classType}
     * @param ${entity.name}
     * @throws Exception
     * @return: void
     */
    public void add${entity.classType}(${entity.classType} ${entity.name}) throws Exception;

    /**
     * @Title: del${entity.classType}
     * @Description: 删除${entity.classType}
     * @param ${entity.name}
     * @throws Exception
     * @return: void
     */
    public void delete${entity.classType}(${entity.classType} ${entity.name}) throws Exception;

    /**
    * @Title: del${entity.name}
    * @Description: 逻辑删除${entity.name}
    * @param ${entity.name}
    * @throws Exception
    * @return: void
    */
    public void delete${entity.classType}ForLogic(${entity.classType} ${entity.name}) throws Exception;

    /**
     * @Title: upd${entity.classType}
     * @Description: 更新${entity.classType}
     * @param ${entity.name}
     * @throws Exception
     * @return: void
     */
    public void update${entity.classType}(${entity.classType} ${entity.name}) throws Exception;

    /**
    * @Title: get${entity.name}ByPage
    * @Description: 分页查询${entity.name}
    * @param ${entity.name}Vo
    * @throws Exception
    * @return: void
    */
    public List<${entity.classType}> get${entity.classType}ByPage(${entity.classType}VO ${entity.name}Vo) throws Exception;

    /**
    * @Title: get${entity.name}
    * @Description: 根据vo中的条件查询${entity.name}
    * @param ${entity.name}Vo
    * @throws Exception
    * @return: void
    */
    public ${entity.classType} get${entity.classType}(${entity.classType}VO ${entity.name}Vo) throws Exception;

}