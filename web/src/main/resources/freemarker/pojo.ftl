package ${entity.tablePackageInfo['pojo']};

import java.io.Serializable;
<#list imports  as importPath>
import ${importPath!};
</#list>


/**
* @ClassName ${entity.classType}
* @Description
* @author ${entity.author}
* @date ${entity.createTime}
*/
public class ${entity.classType} implements Serializable {

    /**
    * @fieldName serialVersionUID
    * @fieldType long
    * @Description serializable
    */
    private static final long serialVersionUID = 1L;

<#list (entity.columns)? keys  as  key>
<#assign column=entity.columns[key]>
    /**
     * @fieldName ${(column.name)!} 
    * @fieldType  ${(column.classType)!} 
    * @Description  ${(column.comment)!} 
     */
    private ${(column.classType)!} ${(column.name)!};
</#list>


<#list (entity.columns)? keys  as  key>
    <#assign column=entity.columns[key]>
    public  ${(column.classType)!} get${(column.name)?cap_first}() {
        return  ${(column.name)!};
    }

    public void set${(column.name)?cap_first}(${(column.classType)!} ${(column.name)!}) {
        this.${(column.name)!} = ${(column.name)!};
    }

</#list>


}
