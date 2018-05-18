<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${entity.tablePackageInfo['daoInterFace']}.I${entity.classType}Mapper">
    <#--<collection property="${(column.exportTable.name)!}"  column="${(column.dbName)!}" javaType="java.util.Set"  select="get${(column.exportTable.name)!}By${(column.dbName)!}" ofType="${(column.exportTable.tablePackageInfo['pojo'])!}.${(column.exportTable.classType)!}"/>-->
    <!-- ${entity.name}列映射 暂不使用  由查询map替换-->
    <resultMap id="${entity.name}Map" type="${(entity.tablePackageInfo['pojo'])!}.${(entity.classType)!}">
    <#list identifyColumns! as identifyColumn>
        <!--${(identifyColumn.comment)!}-->
        <id property="${identifyColumn.name}" column="${identifyColumn.dbName}"/>
    </#list>
    <#list columns! as column>
        <!--${(column.comment)!}-->
        <result property="${(column.name)!}" column="${(column.dbName)!}"/>
    </#list>
    <#list importColumns! as column>
        <!--${(column.comment)!}-->
        <association property="${(column.importTable.name)!}"  column="${(column.dbName)!}" javaType="${(column.importTable.tablePackageInfo['pojo'])!}.${(column.importTable.classType)!}"  resultMap="${(column.importTable.name)!}Map"/>
    </#list>
    <#list exportColumns!  as  column>
        <!--${(column.comment)!}-->
        <collection property="${(column.exportTable.name)!}" resultMap="${(column.exportTable.name)!}Map"/>
    </#list>
    <#list manyToManyColumns! as column>
        <!--${(column.comment)!}-->
        <association property="${(column.importTable.name)!}"  column="${(column.dbName)!}" javaType="${(column.importTable.tablePackageInfo['pojo'])!}.${(column.importTable.classType)!}"  resultMap="${(column.importTable.name)!}Map"/>
    </#list>
    </resultMap>

    <!-- ${entity.name}查询列映射 加上表别名,以区别重复列-->
    <resultMap id="${entity.name}QueryMap" type="${(entity.tablePackageInfo['pojo'])!}.${(entity.classType)!}">
    <#list identifyColumns! as identifyColumn>
        <!--${(identifyColumn.comment)!}-->
        <id property="${identifyColumn.name}" column="${entity.dbName}.${identifyColumn.dbName}"/>
    </#list>
    <#list columns! as column>
        <!--${(column.comment)!}-->
        <result property="${(column.name)!}" column="${entity.dbName}.${(column.dbName)!}"/>
    </#list>
    <#list importColumns! as column>
        <!--关联 ${(column.comment)!}-->
        <association property="${(column.importTable.name)!}"  column="${entity.dbName}.${(column.dbName)!}" javaType="${(column.importTable.tablePackageInfo['pojo'])!}.${(column.importTable.classType)!}"  resultMap="${(column.importTable.name)!}Map"/>
    </#list>
    <#list exportColumns!  as  column>
        <!--关联 ${(column.comment)!}-->
        <collection property="${(column.exportTable.name)!}" resultMap="${(column.exportTable.name)!}Map"/>
    </#list>
    <#list manyToManyColumns! as column>
        <!--关联 ${(column.comment)!}-->
        <association property="${(column.importTable.name)!}"  column="${entity.dbName}.${(column.dbName)!}" javaType="${(column.importTable.tablePackageInfo['pojo'])!}.${(column.importTable.classType)!}"  resultMap="${(column.importTable.name)!}Map"/>
    </#list>
    </resultMap>

    <#list importColumns! as column>
    <!-- 关联表映射 ${(column.comment)!} -->
    <resultMap id="${(column.importTable.name)!}Map" type="${(column.importTable.tablePackageInfo['pojo'])!}.${(column.importTable.classType)!}">
        <#list (column.importTable.columns)? keys as key>
            <#assign importTablecolumn=column.importTable.columns[key]>
            <#if importTablecolumn.identifyKey>
        <!-- ${(importTablecolumn.comment)!}-->
        <id property="${importTablecolumn.name}" column="${(column.importTable.dbName)!}.${importTablecolumn.dbName}"/>
            </#if>
        </#list>
        <#list (column.importTable.columns)? keys as key>
            <#assign importTablecolumn=column.importTable.columns[key]>
        <#--todo 二层以上外键关联-->
            <#if !(importTablecolumn.identifyKey) && !(importTablecolumn.exportkey)&& !(importTablecolumn.importKey)>
        <!-- ${(importTablecolumn.comment)!}-->
        <result property="${(importTablecolumn.name)!}" column="${(column.importTable.dbName)!}.${(importTablecolumn.dbName)!}"/>
            </#if>
        </#list>
    </resultMap>

    </#list>

<#list exportColumns! as column>
    <!-- 关联表映射 -->
    <resultMap id="${(column.exportTable.name)!}Map" type="${(column.exportTable.tablePackageInfo['pojo'])!}.${(column.exportTable.classType)!}">
        <#list (column.exportTable.columns)? keys as key>
            <#assign exportTablecolumn=column.exportTable.columns[key]>
            <#if exportTablecolumn.identifyKey>
        <!-- ${(exportTablecolumn.comment)!}-->
        <id property="${exportTablecolumn.name}" column="${(column.exportTable.dbName)!}.${exportTablecolumn.dbName}"/>
            </#if>
        </#list>
        <#list (column.exportTable.columns)? keys as key>
            <#assign exportTablecolumn=column.exportTable.columns[key]>
        <#--todo 二层以上外键关联-->
            <#if !(exportTablecolumn.identifyKey) && !(exportTablecolumn.exportkey)&& !(exportTablecolumn.importKey)>
        <!-- ${(exportTablecolumn.comment)!}-->
        <result property="${(exportTablecolumn.name)!}" column="${(column.exportTable.dbName)!}.${(exportTablecolumn.dbName)!}"/>
            </#if>
        </#list>
    </resultMap>
</#list>

    <#list manyToManyColumns! as column>
    <!-- 关联表映射 -->
    <resultMap id="${(column.importTable.name)!}Map" type="${(column.importTable.tablePackageInfo['pojo'])!}.${(column.importTable.classType)!}">
        <#list (column.importTable.columns)? keys as key>
            <#assign importTablecolumn=column.importTable.columns[key]>
            <#if importTablecolumn.identifyKey>
        <id property="${importTablecolumn.name}" column="${importTablecolumn.dbName}"/>
            </#if>
        </#list>
        <#list (column.importTable.columns)? keys as key>
            <#assign importTablecolumn=column.importTable.columns[key]>
            <#if !importTablecolumn.identifyKey && !(importTablecolumn.exportkey) && !(importTablecolumn.importKey)>
        <result property="${(importTablecolumn.name)!}" column="${(importTablecolumn.dbName)!}"/>
            </#if>
        </#list>
    </resultMap>
    </#list>


    <!--添加-->
    <insert id="add${entity.classType}" parameterType="${entity.tablePackageInfo['pojo']}.${entity.classType}">
        INSERT INTO ${entity.dbName} (
    <#list identifyColumns! as identifyColumn>
        <#if (!identifyColumn.auto)??>
        ${identifyColumn.dbName},
        </#if>
    </#list>
    <#list columns! as column>
        <#--<#if !(column.defaultValue)>-->
        ${(column.dbName)!}<#if column_has_next || importColumns?size gt 0 >,</#if>
        <#--</#if>-->
    </#list>
    <#list importColumns!  as  column>
        ${column.dbName}<#if column_has_next>,</#if>
    </#list>
    <#--<#list manyToManyColumns!  as  column>
        ${column.dbName}
    </#list>-->
        )
        VALUES (
    <#list identifyColumns! as identifyColumn>
        <#if (!identifyColumn.auto)??>
        ${sign!}{${identifyColumn.name}},
        </#if>
    </#list>
    <#list columns!  as  column>
        <#--<#if !(column.defaultValue)>-->
        ${sign!}{${(column.name)!}}<#if column_has_next || importColumns?size gt 0>,</#if>
        <#--</#if>-->
    </#list>
    <#list importColumns!  as  column>
        ${sign!}{${column.importTable.name}.${column.importColumn.name}}<#if column_has_next>,</#if>
    </#list>
    <#--<#list manyToManyColumns!  as  column>
        ${sign!}{${column.importTable.name}.${column.importColumn.name}}<#if column_has_next>,</#if>
    </#list>-->
        )
    </insert>

    <!--删除-->
    <delete id="del${entity.classType}" parameterType="${entity.tablePackageInfo['pojo']}.${entity.classType}">
        DELETE
        FROM ${entity.dbName}
        WHERE
    <#list identifyColumns! as identifyColumn>
        ${identifyColumn.dbName} = ${sign!}{${identifyColumn.name}}<#if identifyColumn_has_next> AND</#if>
    </#list>
    </delete>

    <!--逻辑删除-->
    <delete id="del${entity.classType}ForLogic" parameterType="${entity.tablePackageInfo['pojo']}.${entity.classType}">
        UPDATE ${entity.dbName} SET
        ${isDelete} = ${deleteValue}
        WHERE
    <#list identifyColumns! as identifyColumn>
        ${identifyColumn.dbName} = ${sign!}{${identifyColumn.name}}<#if identifyColumn_has_next> AND</#if>
    </#list>
    </delete>

    <!--更新,如果属性不为null 则更新该属性,根据id更新-->
    <update id="upd${entity.classType}" parameterType="${entity.tablePackageInfo['pojo']}.${entity.classType}">
        UPDATE ${entity.dbName}
        SET
    <#list columns!  as  column>
        <if test="${column.name} != null">
            ${column.dbName} = ${sign!}{${column.name}},
        </if>
    </#list>
    <#list importColumns! as column>
        <if test="${column.importTable.name} != null and ${column.importTable.name}.${column.importColumn.name} != null" >
            ${column.dbName} = ${sign!}{${column.importTable.name}.${column.importColumn.name}},
        </if>
    </#list>
    <#list identifyColumns! as identifyColumn>
        ${identifyColumn.dbName} = ${sign!}{${identifyColumn.name}}<#if identifyColumn_has_next> AND</#if>
    </#list>
        WHERE
    <#list identifyColumns! as identifyColumn>
        ${identifyColumn.dbName} = ${sign!}{${identifyColumn.name}}<#if identifyColumn_has_next> AND</#if>
    </#list>
    </update>

    <!--分页查询 -->
    <select id="get${entity.classType}ByPage" parameterType="${entity.tablePackageInfo['vo']}.${entity.classType}VO" resultMap="${entity.name}QueryMap">
        SELECT
        /*${entity.dbName} begin*/
    <#list (entity.columns)? keys as key>
        <#assign column=entity.columns[key]>
        <#if (!column.importKey)&&(!column.exportkey)&&(!column.manyToManyKey)>
            ${entity.dbName}.${column.dbName} as '${entity.dbName}.${column.dbName}'<#if key_has_next>,</#if><!--${(column.comment)!}-->
        </#if>
    <#if column.importKey>
        /*${(column.importTable.dbName)} begin */
        <#list (column.importTable.columns)? keys as importKey>
            <#assign importTablecolumn=column.importTable.columns[importKey]>
            <#if (!importTablecolumn.exportkey)&&(!importTablecolumn.manyToManyKey)>
            ${(column.importTable.dbName)}.${importTablecolumn.dbName} as '${(column.importTable.dbName)}.${importTablecolumn.dbName}'<#if key_has_next || importKey_has_next>,</#if> <!--${(importTablecolumn.comment)!}-->
            </#if>
        </#list>
        /*${(column.importTable.dbName)} end*/
    </#if>
    </#list>
        <#--查询范围-->
        FROM ${entity.dbName} as ${entity.dbName}
    <#list (entity.columns)? keys as key>
        <#assign column=entity.columns[key]>
        <#if column.importKey>
        LEFT  JOIN ${column.importTable.dbName} as ${column.importTable.dbName} ON ${entity.dbName}.${column.dbName} = ${column.importTable.dbName}.${column.importColumn.dbName}
        <#elseif column.manyToManyKey>
        JOIN ${column.importTable.dbName} as ${column.importTable.dbName} ON ${entity.dbName}.${column.dbName} = ${column.importTable.dbName}.${column.importColumn.dbName}
        </#if>
    </#list>
        WHERE  1 = 1 And ${entity.dbName}.${isDelete} = ${unDeleteValue}
        <#--查询条件-->
    <#list (entity.columns)? keys as key>
        <#assign column=entity.columns[key]>

        <#--一对多-->
        <#if column.importKey>
            /*${(column.importTable.dbName)} begin*/
        <if test="${column.importTable.name}Vo != null">
            <#list (column.importTable.columns)? keys as key>
                <#assign importTablecolumn=column.importTable.columns[key]>
            <#if !(importTablecolumn.exportkey) && !(importTablecolumn.importKey)>
            <!--${(importTablecolumn.comment)!}-->
            <if test="${column.importTable.name}Vo.${importTablecolumn.name} != null and ${column.importTable.name}Vo.${importTablecolumn.name} !='' ">
                AND ${column.importTable.dbName}.${importTablecolumn.dbName} = ${sign!}{${column.importTable.name}Vo.${importTablecolumn.name}}
            </if>
            <#if (importTablecolumn.rangeKey)!>
            <if test="${column.importTable.name}Vo.start${(importTablecolumn.name)!?cap_first} != null and ${column.importTable.name}Vo.start${(importTablecolumn.name)!?cap_first} != '' " >
                AND ${column.importTable.dbName}.${importTablecolumn.dbName} &gt;= ${sign!}{${column.importTable.name}Vo.start${(importTablecolumn.name)!?cap_first}}
            </if>
            <if test="${column.importTable.name}Vo.end${(importTablecolumn.name)!?cap_first} != null and ${column.importTable.name}Vo.end${(importTablecolumn.name)!?cap_first} != '' " >
                AND ${column.importTable.dbName}.${(importTablecolumn.dbName)!?cap_first}  &lt;= ${sign!}{${column.importTable.name}Vo.end${(importTablecolumn.name)!?cap_first}}
            </if>
            </#if>
            <#elseif (importTablecolumn.importKey)>
            <!--${(importTablecolumn.comment)!}-->
            <if test="${column.importTable.name}Vo.${importTablecolumn.name}.${importTablecolumn.importColumn.name} != null and ${column.importTable.name}Vo.${importTablecolumn.name}.${importTablecolumn.importColumn.name} != '' ">
                AND ${column.importTable.dbName}.${importTablecolumn.dbName} = ${sign!}{${column.importTable.name}Vo.${importTablecolumn.name}.${importTablecolumn.importColumn.name}}
            </if>
            </#if>
        </#list>
            /*${(column.importTable.dbName)} end*/
        </if>
        <#--多对一-->
        <#elseif column.exportkey>

        <#--多对多列-->
        <#elseif column.manyToManyKey>
        <if test="${column.importTable.name}Vo != null">
            <#list (column.importTable.columns)? keys as key>
                <#assign importTablecolumn=column.importTable.columns[key]>
                <#if !(importTablecolumn.exportkey) && !(importTablecolumn.importKey)>
        <!--${(importTablecolumn.comment)!}-->
        <if test="${column.importTable.name}Vo.${importTablecolumn.name} != null and ${column.importTable.name}Vo.${importTablecolumn.name} != '' ">
            AND ${column.importTable.dbName}.${importTablecolumn.dbName} = ${sign!}{${column.importTable.name}Vo.${importTablecolumn.name}}
        </if>
                <#elseif (importTablecolumn.importKey)>
        <!--${(importTablecolumn.comment)!}-->
        <if test="${column.importTable.name}.Vo${importTablecolumn.name}.${importTablecolumn.importColumn.name} != null and ${column.importTable.name}Vo.${importTablecolumn.name}.${importTablecolumn.importColumn.name} != '' ">
            AND ${column.importTable.dbName}.${importTablecolumn.dbName} = ${sign!}{${column.importTable.name}.${importTablecolumn.name}Vo.${importTablecolumn.importColumn.name}}
        </if>
                </#if>
            </#list>
        </if>

        <#--列的范围查询-->
        <#elseif (column.rangeKey)!>
        <if test="start${(column.name)!?cap_first} != null and start${(column.name)!?cap_first} != '' " >
            AND ${entity.dbName}.${(column.dbName)!?cap_first} &gt;= ${sign!}{start${(column.name)!?cap_first}}
        </if>
        <if test="end${(column.name)!?cap_first} != null and end${(column.name)!?cap_first} != '' " >
            AND ${entity.dbName}.${(column.dbName)!?cap_first}  &lt;= ${sign!}{end${(column.name)!?cap_first}}
        </if>
        <#else >
        <!--${(column.comment)!}-->
        <if test="${column.name} != null and ${column.name} != '' " >
            AND ${entity.dbName}.${column.dbName} = ${sign!}{${column.name}}
        </if>
        </#if>
    </#list>
        <if test="startRecord != null  and pageSize != null and pageSize !='' ">
            limit ${sign!}{startRecord},${sign!}{pageSize}
        </if>
    </select>

    <!--查询总记录数 -->
    <select id="get${entity.classType}Count" parameterType="${entity.tablePackageInfo['vo']}.${entity.classType}VO" resultType="java.lang.Integer">
        SELECT COUNT(1)
        /*${entity.dbName} begin*/
    <#--查询范围-->
        FROM ${entity.dbName} as ${entity.dbName}
    <#list (entity.columns)? keys as key>
        <#assign column=entity.columns[key]>
        <#if column.importKey>
            LEFT  JOIN ${column.importTable.dbName} as ${column.importTable.dbName} ON ${entity.dbName}.${column.dbName} = ${column.importTable.dbName}.${column.importColumn.dbName}
        <#elseif column.manyToManyKey>
            JOIN ${column.importTable.dbName} as ${column.importTable.dbName} ON ${entity.dbName}.${column.dbName} = ${column.importTable.dbName}.${column.importColumn.dbName}
        </#if>
    </#list>
        WHERE  1 = 1 And ${entity.dbName}.${isDelete} = ${unDeleteValue}
    <#--查询条件-->
    <#list (entity.columns)? keys as key>
        <#assign column=entity.columns[key]>

    <#--一对多-->
        <#if column.importKey>
            /*${(column.importTable.dbName)} begin*/
            <if test="${column.importTable.name}Vo != null">
                <#list (column.importTable.columns)? keys as key>
                    <#assign importTablecolumn=column.importTable.columns[key]>
                    <#if !(importTablecolumn.exportkey) && !(importTablecolumn.importKey)>
                        <!--${(importTablecolumn.comment)!}-->
                        <if test="${column.importTable.name}Vo.${importTablecolumn.name} != null and ${column.importTable.name}Vo.${importTablecolumn.name} !='' ">
                            AND ${column.importTable.dbName}.${importTablecolumn.dbName} = ${sign!}{${column.importTable.name}Vo.${importTablecolumn.name}}
                        </if>
                        <#if (importTablecolumn.rangeKey)!>
                            <if test="${column.importTable.name}Vo.start${(importTablecolumn.name)!?cap_first} != null and ${column.importTable.name}Vo.start${(importTablecolumn.name)!?cap_first} != '' " >
                                AND ${column.importTable.dbName}.${importTablecolumn.dbName} &gt;= ${sign!}{${column.importTable.name}Vo.start${(importTablecolumn.name)!?cap_first}}
                            </if>
                            <if test="${column.importTable.name}Vo.end${(importTablecolumn.name)!?cap_first} != null and ${column.importTable.name}Vo.end${(importTablecolumn.name)!?cap_first} != '' " >
                                AND ${column.importTable.dbName}.${(importTablecolumn.dbName)!?cap_first}  &lt;= ${sign!}{${column.importTable.name}Vo.end${(importTablecolumn.name)!?cap_first}}
                            </if>
                        </#if>
                    <#elseif (importTablecolumn.importKey)>
                        <!--${(importTablecolumn.comment)!}-->
                        <if test="${column.importTable.name}Vo.${importTablecolumn.name}.${importTablecolumn.importColumn.name} != null and ${column.importTable.name}Vo.${importTablecolumn.name}.${importTablecolumn.importColumn.name} != '' ">
                            AND ${column.importTable.dbName}.${importTablecolumn.dbName} = ${sign!}{${column.importTable.name}Vo.${importTablecolumn.name}.${importTablecolumn.importColumn.name}}
                        </if>
                    </#if>
                </#list>
                /*${(column.importTable.dbName)} end*/
            </if>
        <#--多对一-->
        <#elseif column.exportkey>

        <#--多对多列-->
        <#elseif column.manyToManyKey>
            <if test="${column.importTable.name}Vo != null">
                <#list (column.importTable.columns)? keys as key>
                    <#assign importTablecolumn=column.importTable.columns[key]>
                    <#if !(importTablecolumn.exportkey) && !(importTablecolumn.importKey)>
                        <!--${(importTablecolumn.comment)!}-->
                        <if test="${column.importTable.name}Vo.${importTablecolumn.name} != null and ${column.importTable.name}Vo.${importTablecolumn.name} != '' ">
                            AND ${column.importTable.dbName}.${importTablecolumn.dbName} = ${sign!}{${column.importTable.name}Vo.${importTablecolumn.name}}
                        </if>
                    <#elseif (importTablecolumn.importKey)>
                        <!--${(importTablecolumn.comment)!}-->
                        <if test="${column.importTable.name}.Vo${importTablecolumn.name}.${importTablecolumn.importColumn.name} != null and ${column.importTable.name}Vo.${importTablecolumn.name}.${importTablecolumn.importColumn.name} != '' ">
                            AND ${column.importTable.dbName}.${importTablecolumn.dbName} = ${sign!}{${column.importTable.name}.${importTablecolumn.name}Vo.${importTablecolumn.importColumn.name}}
                        </if>
                    </#if>
                </#list>
            </if>

        <#--列的范围查询-->
        <#elseif (column.rangeKey)!>
            <if test="start${(column.name)!?cap_first} != null and start${(column.name)!?cap_first} != '' " >
                AND ${entity.dbName}.${(column.dbName)!?cap_first} &gt;= ${sign!}{start${(column.name)!?cap_first}}
            </if>
            <if test="end${(column.name)!?cap_first} != null and end${(column.name)!?cap_first} != '' " >
                AND ${entity.dbName}.${(column.dbName)!?cap_first}  &lt;= ${sign!}{end${(column.name)!?cap_first}}
            </if>
        <#else >
            <!--${(column.comment)!}-->
            <if test="${column.name} != null and ${column.name} != '' " >
                AND ${entity.dbName}.${column.dbName} = ${sign!}{${column.name}}
            </if>
        </#if>
    </#list>
    </select>


    <!--根据vo查询 -->
    <select id="get${entity.classType}" parameterType="${entity.tablePackageInfo['vo']}.${entity.classType}VO" resultMap="${entity.name}QueryMap">
        SELECT
        /*${entity.dbName} begin*/
    <#list (entity.columns)? keys as key>
        <#assign column=entity.columns[key]>
        <#if (!column.importKey)&&(!column.exportkey)&&(!column.manyToManyKey)>
        ${entity.dbName}.${column.dbName} as '${entity.dbName}.${column.dbName}'<#if key_has_next>,</#if><!--${(column.comment)!}-->
        </#if>
        <#if column.importKey>
            /*${(column.importTable.dbName)} begin*/
            <#list (column.importTable.columns)? keys as importKey>
                <#assign importTablecolumn=column.importTable.columns[importKey]>
                <#if (!importTablecolumn.exportkey)&&(!importTablecolumn.manyToManyKey)>
                ${(column.importTable.dbName)}.${importTablecolumn.dbName} as '${(column.importTable.dbName)}.${importTablecolumn.dbName}'<#if key_has_next || importKey_has_next>,</#if> <!--${(importTablecolumn.comment)!}-->
                </#if>
            </#list>
            /*${(column.importTable.dbName)} end*/
        </#if>
    </#list>
    <#--查询范围-->
        FROM ${entity.dbName} as ${entity.dbName}
    <#list (entity.columns)? keys as key>
        <#assign column=entity.columns[key]>
        <#if column.importKey>
            LEFT  JOIN ${column.importTable.dbName} as ${column.importTable.dbName} ON ${entity.dbName}.${column.dbName} = ${column.importTable.dbName}.${column.importColumn.dbName}
        <#elseif column.manyToManyKey>
            JOIN ${column.importTable.dbName} as ${column.importTable.dbName} ON ${entity.dbName}.${column.dbName} = ${column.importTable.dbName}.${column.importColumn.dbName}
        </#if>
    </#list>
        WHERE  1 = 1 And ${entity.dbName}.${isDelete} = ${unDeleteValue}
    <#--查询条件-->
    <#list (entity.columns)? keys as key>
        <#assign column=entity.columns[key]>

    <#--一对多-->
        <#if column.importKey>
            /*${(column.importTable.dbName)} begin*/
            <if test="${column.importTable.name}Vo != null">
                <#list (column.importTable.columns)? keys as key>
                    <#assign importTablecolumn=column.importTable.columns[key]>
                    <#if !(importTablecolumn.exportkey) && !(importTablecolumn.importKey)>
                        <!--${(importTablecolumn.comment)!}-->
                        <if test="${column.importTable.name}Vo.${importTablecolumn.name} != null and ${column.importTable.name}Vo.${importTablecolumn.name} !='' ">
                            AND ${column.importTable.dbName}.${importTablecolumn.dbName} = ${sign!}{${column.importTable.name}Vo.${importTablecolumn.name}}
                        </if>
                        <#if (importTablecolumn.rangeKey)!>
                            <if test="${column.importTable.name}Vo.start${(importTablecolumn.name)!?cap_first} != null and ${column.importTable.name}Vo.start${(importTablecolumn.name)!?cap_first} != '' " >
                                AND ${column.importTable.dbName}.${importTablecolumn.dbName} &gt;= ${sign!}{${column.importTable.name}Vo.start${(importTablecolumn.name)!?cap_first}}
                            </if>
                            <if test="${column.importTable.name}Vo.end${(importTablecolumn.name)!?cap_first} != null and ${column.importTable.name}Vo.end${(importTablecolumn.name)!?cap_first} != '' " >
                                AND ${column.importTable.dbName}.${(importTablecolumn.dbName)!?cap_first}  &lt;= ${sign!}{${column.importTable.name}Vo.end${(importTablecolumn.name)!?cap_first}}
                            </if>
                        </#if>
                    <#elseif (importTablecolumn.importKey)>
                        <!--${(importTablecolumn.comment)!}-->
                        <if test="${column.importTable.name}Vo.${importTablecolumn.name}.${importTablecolumn.importColumn.name} != null and ${column.importTable.name}Vo.${importTablecolumn.name}.${importTablecolumn.importColumn.name} != '' ">
                            AND ${column.importTable.dbName}.${importTablecolumn.dbName} = ${sign!}{${column.importTable.name}Vo.${importTablecolumn.name}.${importTablecolumn.importColumn.name}}
                        </if>
                    </#if>
                </#list>
                /*${(column.importTable.dbName)} end*/
            </if>
        <#--多对一-->
        <#elseif column.exportkey>

        <#--多对多列-->
        <#elseif column.manyToManyKey>
            <if test="${column.importTable.name}Vo != null">
                <#list (column.importTable.columns)? keys as key>
                    <#assign importTablecolumn=column.importTable.columns[key]>
                    <#if !(importTablecolumn.exportkey) && !(importTablecolumn.importKey)>
                        <!--${(importTablecolumn.comment)!}-->
                        <if test="${column.importTable.name}Vo.${importTablecolumn.name} != null and ${column.importTable.name}Vo.${importTablecolumn.name} != '' ">
                            AND ${column.importTable.dbName}.${importTablecolumn.dbName} = ${sign!}{${column.importTable.name}Vo.${importTablecolumn.name}}
                        </if>
                    <#elseif (importTablecolumn.importKey)>
                        <!--${(importTablecolumn.comment)!}-->
                        <if test="${column.importTable.name}.Vo${importTablecolumn.name}.${importTablecolumn.importColumn.name} != null and ${column.importTable.name}Vo.${importTablecolumn.name}.${importTablecolumn.importColumn.name} != '' ">
                            AND ${column.importTable.dbName}.${importTablecolumn.dbName} = ${sign!}{${column.importTable.name}.${importTablecolumn.name}Vo.${importTablecolumn.importColumn.name}}
                        </if>
                    </#if>
                </#list>
            </if>

        <#--列的范围查询-->
        <#elseif (column.rangeKey)!>
            <if test="start${(column.name)!?cap_first} != null and start${(column.name)!?cap_first} != '' " >
                AND ${entity.dbName}.${(column.dbName)!?cap_first} &gt;= ${sign!}{start${(column.name)!?cap_first}}
            </if>
            <if test="end${(column.name)!?cap_first} != null and end${(column.name)!?cap_first} != '' " >
                AND ${entity.dbName}.${(column.dbName)!?cap_first}  &lt;= ${sign!}{end${(column.name)!?cap_first}}
            </if>
        <#else >
            <!--${(column.comment)!}-->
            <if test="${column.name} != null and ${column.name} != '' " >
                AND ${entity.dbName}.${column.dbName} = ${sign!}{${column.name}}
            </if>
        </#if>
    </#list>
        <if test="startRecord != null  and pageSize != null and pageSize !='' ">
            limit ${sign!}{startRecord},${sign!}{pageSize}
        </if>
    </select>




    <#list exportColumns!  as  column>
    <!--关联查询-->
    <select id="get${(column.exportTable.name)!}By${(column.dbName)!}"  parameterType="Integer" resultMap="${(column.exportTable.name)!}Map" >
        SELECT *
        FROM ${(column.exportTable.dbName)}
        WHERE ${isDelete} = ${unDeleteValue}
        AND ${(column.exporColumn.dbName)} = ${(column.dbName)}
    </select>
    </#list>

</mapper>