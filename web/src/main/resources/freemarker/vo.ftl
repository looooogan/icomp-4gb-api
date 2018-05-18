package ${entity.tablePackageInfo['vo']};

import java.io.Serializable;
<#list imports  as importPath>
import ${importPath!};
</#list>


/**
* @ClassName ${entity.classType}VO
* @Description
* @author ${entity.author}
* @date ${entity.createTime}
*/
public class ${entity.classType}VO implements Serializable {

    /**
    * @fieldName serialVersionUID
    * @fieldType long
    * @Description serializable
    */
    private static final long serialVersionUID = 1L;

    /**
     * @fieldName page
    * @fieldType  Integer
    * @Description  当前页数
     */
    private Integer page;

    /**
     * @fieldName pageSize
    * @fieldType  Integer
    * @Description  每页记录数
     */
    private Integer pageSize = 10;

    /**
     * @fieldName startRecord
    * @fieldType  Integer
    * @Description  每页记录数
     */
    private Integer startRecord;

    /**
     * @fieldName page
    * @fieldType  Integer
    * @Description  总记录数
     */
    private Integer pageTotalCount;

    /**
     * @fieldName maxPage
    * @fieldType  Integer
    * @Description  总记录数
     */
    private Integer maxPage;

<#list (entity.columns)? keys  as  key>
<#assign column=entity.columns[key]>
    <#if (column.importKey)!>
    /**
     * @fieldName ${(column.name)!} Vo
    * @fieldType  ${(column.classType)!} Vo
    * @Description  ${(column.comment)!} 
     */
    private ${(column.classType)!}VO ${(column.name)!}Vo;
    <#elseif (column.exportkey)!>
    /**
     * @fieldName ${(column.name)!} Vo
    * @fieldType  ${(column.classType)!} Vo
    * @Description  ${(column.comment)!} 
     */
    private Set<${(column.classType)!}VO> ${(column.name)!}Vo;
    <#else >
    /**
     * @fieldName ${(column.name)!} 
    * @fieldType  ${(column.classType)!} 
    * @Description  ${(column.comment)!} 
     */
    private ${(column.classType)!} ${(column.name)!};
    </#if>

    <#if (column.rangeKey)!>
    /**
     * @fieldName start${(column.name)!?cap_first} 
    * @fieldType  ${(column.classType)!} 
    * @Description  ${(column.comment)!} 范围开始 
     */
    private ${(column.classType)!} start${(column.name)!?cap_first};

    /**
     * @fieldName end${(column.name)!?cap_first} 
    * @fieldType  ${(column.classType)!} 
    * @Description  ${(column.comment)!}  范围结束
     */
    private ${(column.classType)!} end${(column.name)!?cap_first};

    </#if>
</#list>

<#list (entity.columns)? keys  as  key>
    <#assign column=entity.columns[key]>
    <#if (column.importKey)!>

    public  ${(column.classType)!}VO get${(column.name)?cap_first}Vo() {
        return  ${(column.name)!}Vo;
    }

    public void set${(column.name)?cap_first}Vo(${(column.classType)!}VO ${(column.name)!}Vo) {
        this.${(column.name)!}Vo = ${(column.name)!}Vo;
    }
    <#elseif (column.exportkey)!>

    public  Set<${(column.classType)!}VO> get${(column.name)?cap_first}Vo() {
        return  ${(column.name)!}Vo;
    }

    public void set${(column.name)?cap_first}Vo(Set<${(column.classType)!}VO> ${(column.name)!}Vo) {
        this.${(column.name)!}Vo = ${(column.name)!}Vo;
    }

    <#else >
    public  ${(column.classType)!} get${(column.name)?cap_first}() {
        return  ${(column.name)!};
    }

    public void set${(column.name)?cap_first}(${(column.classType)!} ${(column.name)!}) {
        this.${(column.name)!} = ${(column.name)!};
    }

    </#if>
    <#if (column.rangeKey)!>

    public  ${(column.classType)!} getStart${(column.name)?cap_first}() {
        return  start${(column.name)!?cap_first};
    }

    public void setStart${(column.name)?cap_first}(${(column.classType)!} start${(column.name)!?cap_first}) {
        this.start${(column.name)!?cap_first} = start${(column.name)!?cap_first};
    }

    public  ${(column.classType)!} getEnd${(column.name)?cap_first}() {
        return  end${(column.name)!?cap_first};
    }

    public void setEnd${(column.name)?cap_first}(${(column.classType)!} end${(column.name)!?cap_first}) {
        this.end${(column.name)!?cap_first} = end${(column.name)!?cap_first};
    }
    </#if>
</#list>

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
        this.startRecord = (this.page-1)*pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
        this.maxPage = this.pageTotalCount/this.pageSize+(this.pageTotalCount%this.pageSize)>0?1:0;
    }

    public Integer getStartRecord() {
        return startRecord;
    }

    public void setStartRecord(Integer startRecord) {
        this.startRecord = startRecord;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }

}
