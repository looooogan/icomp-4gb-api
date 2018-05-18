package ${entity.tablePackageInfo['daoInterFace']};

import ${entity.tablePackageInfo['pojo']}.${entity.classType};
import ${entity.tablePackageInfo['vo']}.${entity.classType}VO;
import java.util.*;

/**
*
* @ClassName I${entity.classType}Mapper
* @Description TODO
* @author ${entity.author}
* @date ${entity.createTime}
*/
public interface I${entity.classType}Mapper {

    /**
    * @Title: add${entity.name}
    * @Description: 新增${entity.name}
    * @param ${entity.name}
    * @throws Exception
    * @return: void
    */
    public void add${entity.classType}(${entity.classType} ${entity.name}) throws Exception;

    /**
    * @Title: del${entity.name}
    * @Description: 删除${entity.name}
    * @param ${entity.name}
    * @throws Exception
    * @return: void
    */
    public void del${entity.classType}(${entity.classType} ${entity.name}) throws Exception;

    /**
    * @Title: del${entity.name}
    * @Description: 逻辑删除${entity.name}
    * @param ${entity.name}
    * @throws Exception
    * @return: void
    */
    public void del${entity.classType}ForLogic(${entity.classType} ${entity.name}) throws Exception;

    /**
    * @Title: upd${entity.name}
    * @Description: 更新${entity.name}
    * @param ${entity.name}
    * @throws Exception
    * @return: void
    */
    public void upd${entity.classType}(${entity.classType} ${entity.name}) throws Exception;

    /**
    * @Title: get${entity.name}ByPage
    * @Description: 分页查询${entity.name}
    * @param ${entity.name}Vo
    * @throws Exception
    * @return: void
    */
    public List<${entity.classType}> get${entity.classType}ByPage(${entity.classType}VO ${entity.name}Vo) throws Exception;

    /**
    * @Title: get${entity.name}Count
    * @Description: 查询总${entity.name}记录数
    * @param ${entity.name}Vo
    * @throws Exception
    * @return: void
    */
    public Integer get${entity.classType}Count(${entity.classType}VO ${entity.name}Vo) throws Exception;

    /**
    * @Title: get${entity.name}
    * @Description: 根据vo中的条件查询${entity.name}
    * @param ${entity.name}Vo
    * @throws Exception
    * @return: void
    */
    public ${entity.classType} get${entity.classType}(${entity.classType}VO ${entity.name}Vo) throws Exception;

}