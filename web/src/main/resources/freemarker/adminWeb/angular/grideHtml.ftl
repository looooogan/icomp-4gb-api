<div ng-controller="ToasterDemoCtrl" class="panel-body" >
    <div ng-controller="${entity.name}Controller" ng-class="{'whirl double-up':isShowSpinner}">
        <!-- ngRepeat + ngResource-->
        <div class="row">
            <form name="formValidate" ng-submit="submitForm()" novalidate="" class="form-validate form-inline">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <#--<div class="form-group">-->
                            <#--<input id="input-name" type="text" placeholder="账号" ng-model="searchEntity.account" class="form-control">-->
                        <#--</div>-->
                    <#list (entity.columns)? keys  as  key>
                        <#assign column=entity.columns[key]>
                        <#if (column.importKey)>
                            <#assign importTableColumns=column.importTable.columns>
                            <#list (importTableColumns)? keys as importKey>
                        <div class="form-group">
                            <input id="${(column.importTable.name)!}Vo.${(importTableColumns[importKey].name)!}" type="text" placeholder="${(importTableColumns[importKey].comment)!}" ng-model="searchEntity.${(column.importTable.name)!}Vo.${(importTableColumns[importKey].name)!}" class="form-control">
                        </div>
                            </#list>
                        <#else >
                            <div class="form-group">
                                <input id="${(column.name)!}" type="text" placeholder="${(column.comment)!}" ng-model="searchEntity.${(column.name)!}" class="form-control">
                            </div>
                        </#if>

                    </#list>
                        <button type="submit" class="btn btn-labeled btn-default">
                            <span class="btn-label"><i class="fa fa-search"></i></span>查询
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <div class="row">
            <div class="col-sm-4">
                <button type="button" ng-click="add()" class="btn btn-labeled btn-success">
                    <span class="btn-label"><i class="fa fa-plus"></i></span>添加
                </button>
                <button type="button" ng-click="update()" class="btn btn-labeled btn-info">
                    <span class="btn-label"><i class="fa fa-pencil"></i></span>修改
                </button>
                <button type="button" ng-click="delete()" class="btn btn-labeled btn-danger">
                    <span class="btn-label"><i class="fa fa-trash"></i></span>删除
                </button>
            </div>
        </div>
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div>
                        <div ng-grid="gridOptions"></div>
                    </div>
                </div>
            </div>
            <!-- START row-->
        </div>
    </div>
    <toaster-container toaster-options="{'position-class': 'toast-bottom-right', 'close-button':true}"></toaster-container>
</div>