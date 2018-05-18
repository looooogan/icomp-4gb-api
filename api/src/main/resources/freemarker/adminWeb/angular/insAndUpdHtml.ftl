<div ng-controller="ToasterDemoCtrl" class="panel-body">
    <!-- START row-->
    <div ng-controller="${entity.name}InsAndUpdController" class="container-fluid" ng-class="{'whirl double-up':isShowSpinner}">
        <div class="row">
            <div class="col-md-12">
                <form name="formValidate" ng-submit="submitForm()" novalidate="" class="form-validate form-horizontal">
                    <!-- START panel-->
                    <div class="panel panel-default" >
                        <div class="panel-body">
                            <fieldset class="b0">
                                <legend>数据信息</legend>
                            </fieldset>
                        <#list (entity.columns)? keys  as  key>
                            <#assign column=entity.columns[key]>
                            <#if !(column.importKey)&&!(column.exportkey)&&!(column.identifyKey)&&!(column.manyToManyKey)>
                            <fieldset>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">${(column.comment)!} </label>
                                    <div class="col-sm-6">
                                        <input id="${(column.name)!}" type="text" name="${(column.name)!}" required="" ng-model="entity.${(column.name)!}" class="form-control" />
                                        <span ng-show="validateInput('${(column.name)!}', 'required')" class="text-danger">请填写信息</span>
                                    </div>
                                    <div class="col-sm-4">
                                        <small class="text-muted">必填</small>
                                    </div>
                                </div>
                            </fieldset>
                            </#if>
                            <#if column.importKey>
                                <#assign importTableColumns=column.importTable.columns>
                                <#list (importTableColumns)? keys as importKey>
                                <#if (importTableColumns[importKey].identifyKey)>
                                    <fieldset>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">${(importTableColumns[importKey].comment)!}</label>
                                            <div class="col-sm-6">
                                                <select name="${(column.importTable.name)!}.${(importTableColumns[importKey].name)!}" required="" ng-model="entity.${(column.importTable.name)!}.${(importTableColumns[importKey].name)!}" class="form-control">
                                                    <option value="0">Nothing</option>
                                                    <option value="1">Option 1</option>
                                                    <option value="2">Option 2</option>
                                                    <option value="3">Option 3</option>
                                                    <option value="4">Option 4</option>
                                                </select>
                                                <span ng-show="validateInput('${(column.importTable.name)!}.${(importTableColumns[importKey].name)!}', 'required')" class="text-danger">请选择</span>
                                            </div>
                                            <div class="col-sm-4">
                                                <small class="text-muted">type='number'</small>
                                            </div>
                                        </div>
                                    </fieldset>
                                <#else >
                                    <fieldset>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">${(importTableColumns[importKey].comment)!}</label>
                                            <div class="col-sm-6">
                                                <input id="${(column.importTable.name)!}.${(importTableColumns[importKey].name)!}" type="text" name="${(column.importTable.name)!}.${(importTableColumns[importKey].name)!}" required="" ng-model="entity.${(column.importTable.name)!}.${(importTableColumns[importKey].name)!}" class="form-control" />
                                                <span ng-show="validateInput('${(column.importTable.name)!}.${(importTableColumns[importKey].name)!}', 'required')" class="text-danger">请填写信息</span>
                                            </div>
                                            <div class="col-sm-4">
                                                <small class="text-muted">必填</small>
                                            </div>
                                        </div>
                                    </fieldset>
                                </#if>
                                </#list>
                            </#if>
                        </#list>
                        </div>
                        <div class="panel-footer text-center">
                            <button type="submit" class="btn btn-labeled btn-primary">
                                <span class="btn-label"><i class="fa fa-database"></i></span>提交
                            </button>
                            <button type="button" ng-click="toList()" class="btn btn-labeled btn-success">
                                <span class="btn-label"><i class="fa fa-reply-all"></i></span>返回列表
                            </button>
                        </div>
                    </div>
                    <!-- END panel-->
                </form>
            </div>
        </div>
    </div>
    <toaster-container toaster-options="{'position-class': 'toast-bottom-right', 'close-button':true}"></toaster-container>
</div>