﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%@ include file="../../common/header_common.jsp" %>
    <script type="text/javascript">
        $(function () {
            jQuery('body').layout({
                center__childOptions: {
                    north__resizable: false,
                    spacing_open: 0
                },
                north: {
                    size: 'auto',
                    spacing_open: 0,
                    closable: false,
                    resizable: false
                }
            });
            initTableHeand();

            /************* 刀具类型  相关代码************/
            $("#DivToolType").change(function (e) {
                copyTypeElement($(this).val());
            });
            $("#DivToolConsumetype").change(function (e) {
                copyConsumeTypeElement($(this).val());
            });
            /******************************************/
        });

        /**
         * 查询处理
         */
        function search() {
            var param = {
                businessCode: $(toolForm.businessCode).val(),
                name: $(toolForm.name).val(),
                type: $(toolForm.type).val(),
                specifications: $(toolForm.specifications).val(),
                libraryCode: $(toolForm.libraryCode).val(),
                pageSize: 15,
                currentPage: $(toolForm.currentPage).val() == ""?1:$(toolForm.currentPage).val(),

            };
            console.log(param);

            $.ajax({
                type: "POST",
                url:"/cuttingTool/list",
                dataType:"json",
                data:JSON.stringify(param),
                error: function(XHR,textStatus,errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function(data,textStatus) {
                    console.log(data);
                    $('#list').grid('loadData',data);
                },
                headers: {
                    "content-type":"application/json"
                }
            })
            return false;
        }

        function  initTableHeand() {
            $('#list').grid({
                barid: '#bar',
                datatype: 'json',
                type: 'post',
                width: '100%',
                fit: true,
                lazy: false,
                async: false,
                rowno: true,
                rows:15,
                roll: 6,
                pager: true,
                pagerpos: 'right',
                pagercon: 'first,last,number,next,prev',
                column: [{
                    title: '刀具号',
                    name: 'businessCode'
                },{
                    title: '规格型号',
                    name: 'specifications'
                },
                    {
                        title: '刀具类型',
                        name: 'consumeType',
                        format: function (r) {
                            if (r.consumeType == 1) {
                                return '<span class="ui-grid-tdtx">可刃磨钻头</span>';
                            }
                            else if (r.consumeType == 2) {
                                return '<span class="ui-grid-tdtx">可刃磨刀片</span>';
                            }
                            else if (r.consumeType == 3) {
                                return '<span class="ui-grid-tdtx">一次性刀具</span>';
                            }
                            else if (r.consumeType == 9) {
                                return '<span class="ui-grid-tdtx">其他</span>';
                            }
                            return '<span class="ui-grid-tdtx">-</span>';
                        }
                    },
                    {
                        title: '刀具分类',
                        name: 'type',
                        format: function (r) {
                            //1刀具2辅具3配套9其他
                            if (r.type == 1) {
                                return '<span class="ui-grid-tdtx">刀具</span>';
                            }
                            else if (r.type == 2) {
                                return '<span class="ui-grid-tdtx">辅具</span>';
                            }
                            else if (r.type == 3) {
                                return '<span class="ui-grid-tdtx">配套</span>';
                            }
                            else if (r.type == 9) {
                                return '<span class="ui-grid-tdtx">其他</span>';
                            }
                            return '<span class="ui-grid-tdtx">-</span>';
                        }
                    },
                    {
                        title: '刃磨类别',
                        name: 'grinding',
                        format: function (r) {
                            //1刀具2辅具3配套9其他
                            if (r.grinding == 1) {
                                return '<span class="ui-grid-tdtx">厂内修磨</span>';
                            }
                            else if (r.grinding == 2) {
                                return '<span class="ui-grid-tdtx">厂外修磨</span>';
                            }
                            else if (r.grinding == 3) {
                                return '<span class="ui-grid-tdtx">厂外涂层</span>';
                            }
                            return '<span class="ui-grid-tdtx">-</span>';
                        }
                    },

                    {
                        title: '操作列',
                        name: '',
                        width: '130px',
                        visible: 'true',
                        format: function (r, t) {
                            return option(r, "OperationText");
                        }
                    }],
                success: function (d) {
                    console.log(d);
                    if(undefined== d.total){
                        $("#number1").text(0);
                    }else if(0== d.total){
                        $("#number1").text(1);
                    } else {
                        $("#number1").text(d.total);
                    }

                    if (d.status < 0) {
                        artDialog(d.message, "OK");
                    }
                }
            });
        }


        function copyTypeElement(type){
            $('#copy_table').html('');
            $('#ct_copy_table').html('');
            $('#DivToolConsumetype').html('');
            var content = '';
            if (type == '1'){
                $('#copy_table').append($('#assistive_device_none').html());
                content = $('#Base_cutting_tool').html();
            }else{
                content = $('#Base_assistive_device').html();
            }
            $('#DivToolConsumetype').html(content);
            $('#DivToolConsumetype').trigger("change");

        }

        function copyConsumeTypeElement(type){
            console.log(type);
            $('#ct_copy_table').html('');
            if (type == '3' || type == '9'){
                return;
            }
            $('#ct_copy_table').html($('#microtome_blade_none').html());
        }

        function clearCtr(){
            $('#toolEditForm')[0].reset();
            $('#copy_table').html('');
            $('#ct_copy_table').html('');
            $('#DivToolConsumetype').html('');
        }

        function dataHandler(data){
//            copyTypeElement(data);
            $(toolEditForm.opt).val('edit');
            $(toolEditForm.type).val(data.type);
            $(toolEditForm.type).trigger("change");
            $(toolEditForm.consumeType).val(data.consumeType);
            $(toolEditForm.consumeType).trigger("change");
            $(toolEditForm.code).val(data.code);
            $(toolEditForm.id).val(data.id);
            $(toolEditForm.businessCode).val(data.businessCode);
            $(toolEditForm.name).val(data.name);
            $(toolEditForm.pic).val(data.pic);
            $(toolEditForm.toolNumber).val(data.toolNumber);//可修磨次数
            $(toolEditForm.cutNumber).val(data.cutNumber);//刃口数
            $(toolEditForm.specifications).val(data.specifications);
            $(toolEditForm.materialMax).val(data.materialMax);
            $(toolEditForm.materialMin).val(data.materialMin);
            $(toolEditForm.beiMin).val(data.beiMin);
            $(toolEditForm.beiMax).val(data.beiMax);
            $(toolEditForm.toolPrice).val(data.toolPrice);
            $(toolEditForm.averagePrice).val(data.averagePrice);
            $(toolEditForm.userfulType).val(data.userfulType);
            $(toolEditForm.grinding).val(data.grinding);
            $(toolEditForm.libraryCode).val(data.libraryCode);
            $(toolEditForm.isDel).val(data.isDel);//删除区分
            $(toolEditForm.sharpen_num).val(data.sharpenNum);
            $(toolEditForm.materialLength).val(data.materialLength);//刀具长度
            $(toolEditForm.sharpenCriterion).val(data.sharpenCriterion);//复磨标准
            $(toolEditForm.sharpenLength).val(data.sharpenLength);//可刃磨长度
            $(toolEditForm.code).attr("disabled", "");//禁用刀具编码
        }


        //添加刀具
        function wd_tool(data) {
            clearCtr();
            $(toolEditForm.type).val('');
            if (typeof(data) == 'object') {
                //为刀具类型赋值
                dataHandler(data);

            }
//            $('#toolEditForm').form('reset');
//            $('#toolEditForm :input').removeClass('u-ipt-err');
//            $('#toolEditForm').find("*").each(function () {
//                if ($(this).hasClass("u-sel")) {
//                    $(this).removeAttr("style");
//                }
//            });

            if (typeof(data) == 'object') {
                $(toolEditForm.businessCode).attr("disabled","disabled");//启用刀具编码

            } else {
                $(toolEditForm.businessCode).removeAttr("disabled");//启用刀具编码
                $(toolEditForm.isDel).val(0);//删除区分-有效
            }
            $.dialog({
                id: 'toolEdit_dialog',
                title: "刀具参数",
                lock: true,
                content: document.getElementById('toolEdit'),
                button: [{
                    name: '保存',
                    focus: true,
                    callback: function () {
                        if (typeof(data) == 'object'){
                            editCuttingTool();
                        }else{
                            addCuttingTool();
                        }
                        $.dialog.list['toolEdit_dialog'].close();
                    }
                }]
            });
        }

        function initParam(){
            var param = {};
            param.code = $(toolEditForm.code).val();
            param.id = $(toolEditForm.id).val();
            param.libraryCode = $(toolEditForm.libraryCode).val();
            param.businessCode = $(toolEditForm.businessCode).val();
            param.name =$(toolEditForm.name).val();
            param.type = $(toolEditForm.type).val();
            param.consumeType = $(toolEditForm.consumeType).val();
            param.specifications = $(toolEditForm.specifications).val();
            param.cutNumber = $(toolEditForm.cutNumber).val();
            param.grinding = $(toolEditForm.grinding).val();
            param.sharpenNum = $(toolEditForm.sharpen_num).val();
            param.materialMax = $(toolEditForm.materialMax).val();
            param.materialMin = $(toolEditForm.materialMin).val();
            param.toolNumber = $(toolEditForm.toolNumber).val();
            param.sharpenCriterion = $(toolEditForm.sharpenCriterion).val();
            param.materialLength = $(toolEditForm.materialLength).val();
            param.sharpenLength = $(toolEditForm.sharpenLength).val();
            param.beiMin = $(toolEditForm.beiMin).val();
            param.beiMax = $(toolEditForm.beiMax).val();
            param.toolPrice = $(toolEditForm.toolPrice).val();
            param.averagePrice = $(toolEditForm.averagePrice).val();
            param.userfulType = $(toolEditForm.userfulType).val();
            param.qimingCode = $(toolEditForm.qimingCode).val();
            param.wuliaoCode = $(toolEditForm.wuliaoCode).val();
            return JSON.stringify(param);
        }

        function addCuttingTool(){
            $.ajax({
                type: "POST",
                url:"/cuttingTool/add",
                dataType:"json",
                data:initParam(),
                error: function(XHR,textStatus,errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function(data,textStatus,response) {
                    artDialog("操作成功", "OK");
                    search();
                },
                headers: {
                    "content-type":"application/json"
                }
            });
        }

        function editCuttingTool(){
            $.ajax({
                type: "POST",
                url:"/cuttingTool/upd",
                dataType:"json",
                data:initParam(),
                error: function(XHR,textStatus,errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function(data,textStatus,response) {
                    if(response.status == '200'){
                        search();
                    }else{
                        artDialog(data, "OK");
                    }
                },
                headers: {
                    "content-type":"application/json"
                }
            });
        }

        /**
         * 操作列超链接
         */
        function option(r, title) {
            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            if (title == "OperationText") {//操作
                ary_li.push($('<li><a href="javascript:void(0)">编辑</a></li>').click(function () {
                    edit(r.toolID, r.version, r)
                }));
                ary_li.push($('<li><a href="javascript:void(0)">删除</a></li>').click(function () {
                    if (r.isDel == 0) {
                        del(r.toolID, r.version, r.updateTime, r.updateUser, r)
                    }
                }));
            }
            if(title=="ToolPicText"){
                if(r.pic==null|| r.pic==undefined|| r.pic==''){

                    ary_li.push($('<li>-</li>'));
                }else {
                    ary_li.push($('<li><a href="<%= path%>/upload/b09s001/' + r.toolID + "/" + r.pic + '"target="_blank">下载</a></li>'));
                }
            }
            $.each(ary_li, function (i, o) {
                $li.after(o);
            });
            return $ul.append($li);
        }

        /**
         * 编辑处理
         */
        function edit(id, version, obj) {
            var param = {};
            param.code = obj.code;
            $.ajax({
                type: "POST",
                url:"/cuttingTool/search",
                dataType:"json",
                data:JSON.stringify(param),
                error: function(XHR,textStatus,errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function(data,textStatus,response) {
                    if(response.status == '200'){
                        wd_tool(data, data.code, data);
                    }else{
                        artDialog(data, "OK");
                    }
                },
                headers: {
                    "content-type":"application/json"
                }
            });

        }


        /**
         * 删除处理
         */
        function del(id, version, time, user, obj) {

            $.dialog.confirm('是否确认删除', function () {
                $.ajax({
                    type: "POST",
                    url:"/cuttingTool/del",
                    dataType:"json",
                    data:JSON.stringify(obj),
                    error: function(XHR,textStatus,errorThrown) {
                        artDialog(XHR.responseText, "OK");
                    },
                    success: function(data,textStatus,response) {
                        if(response.status == '200'){
                            search();
                        }else{
                            artDialog(data, "OK");
                        }
                    },
                    headers: {
                        "content-type":"application/json"
                    }
                });
            });
        }
        function pageClick(page){
            $(toolForm.currentPage).val(page);
            search();
        }

    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页>首页>基础数据管理>刀具参数</span>
        <%@ include file="../../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            检索
        </div>
        <form id="toolForm" name="toolForm" method="post">
            <table width="100%" class="m-frmtb">
                <tr>
                    <th width="150">
                        材料号
                    </th>
                    <td>
                        <input name="currentPage" type="hidden" >
                        <input name="businessCode" type="text" class="u-ipt" maxlength="16" onkeyup="this.value=this.value.toUpperCase()">
                    </td>
                    <th width="150">
                        刀具名称
                    </th>
                    <td>
                        <input name="name" type="text" class="u-ipt" maxlength="40">
                    </td>
                    <th width="150">
                        刀具类别
                    </th>
                    <td>
                        <select class="u-sel" name="type" maxlength="2">
                            <option value="">--请选择--</option>
                            <option value="1">刀具</option>
                            <option value="2">辅具</option>
                            <option value="3">配套</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th width="150">
                        规格型号
                    </th>
                    <td>
                        <input name="specifications" type="text" class="u-ipt" maxlength="150">
                    </td>
                    <th width="150">
                        库位码
                    </th>
                    <td>
                        <input name="libraryCode" type="text" class="u-ipt" maxlength="36">
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" onclick="return search()">
                    查询
                </button>
                <button type="button" class="u-btn2" onclick="return wd_tool()">
                    新建
                </button>
            </div>
        </form>
        <div class="f-cb"></div>

        <div class="u-ptt">
            <div style="float:left;">详细</div>
            <div style="float:right;">
                共：<span id="number1"></span> &nbsp;条
            </div>
            <div style="clear:both;"></div>
        </div>
    </div>
    <div class="ui-layout-center">
        <table id="list"></table>
        <div id="bar"></div>
    </div>
</div>


<!-- 新建编辑页面 -->
<div id="toolEdit" class="f-dn">
    <form id="toolEditForm" name="toolEditForm" method="post" enctype="multipart/form-data">
        <input type="text" class="f-dn" name="opt" value="add"/>
        <input type="text" class="f-dn" name="code"/>
        <input type="text" class="f-dn" name="id"/>

        <table class="m-frmtb" width="100%" id="toolEditFormTable">
            <tr>
                <th width="150">
                    刀具分类
                </th>
                <td>
                    <select class="u-sel" name="type" id="DivToolType" maxlength="2">
                        <option value="">--请选择--</option>
                        <option value="1">刀具</option>
                        <option value="2">辅具</option>
                        <option value="3">配套</option>
                    </select>
                </td>
                <th width="150">
                    消耗类别
                </th>
                <td>
                    <select class="u-sel" name="consumeType" id="DivToolConsumetype" maxlength="2">
                        <option value="">--请选择--</option>
                    </select>
                </td>
            </tr>

            <tr>
                <th width="150">
                    材料号
                </th>
                <td>
                    <input name="businessCode" type="text" class="u-ipt" maxlength="16" onkeyup="this.value=this.value.toUpperCase()" >
                </td>
                <th width="150">
                    刀具名称
                </th>
                <td>
                    <input name="name" type="text" class="u-ipt" maxlength="40">
                </td>
            </tr>
            <tr>
                <th width="150">
                    库位码
                </th>
                <td>
                    <input name="libraryCode" type="text" class="u-ipt" maxlength="16">
                </td>
                <th width="150">
                    规格型号
                </th>
                <td>
                    <input name="specifications" type="text" class="u-ipt" maxlength="80">
                </td>
            </tr>
            <tr>
                <th width="150">
                    <%--供应商--%> 库存最大值
                </th>
                <td>
                    <%--<input name="DivToolSupplier" type="text" class="u-ipt" maxlength="200">--%>
                    <input name="materialMax" type="text" class="u-ipt" maxlength="10">
                </td>

                <th width="150">
                    库存最小值
                </th>
                <td>
                    <input name="materialMin" type="text" class="u-ipt" maxlength="8">
                </td>
            </tr>
            <tr>
                <th width="150">
                    备最大值
                </th>
                <td>
                    <input name="beiMax" type="text" class="u-ipt" maxlength="10">
                </td>
                <th width="150">
                    备最小值
                </th>
                <td>
                    <input name="beiMin" type="text" class="u-ipt" maxlength="8">
                </td>
            </tr>
            <tr>
                <th width="150">
                    刀具单价
                </th>
                <td>
                    <input name="toolPrice" type="text" class="u-ipt" maxlength="10">
                    <p id="DivToolPrice"></p>
                </td>

            </tr>
        </table>
        <table class="m-frmtb" width="100%" id="copy_table">
        </table>
        <table class="m-frmtb" width="100%" id="ct_copy_table">
        </table>
    </form>
</div>




<!-- 用于复制页面  -->
<div class="f-dn">
    <table id="microtome_blade_none">
        <tr>
            <th width="150">
                平均修磨单价
            </th>
            <td>
                <input name="averagePrice" type="text" class="u-ipt" maxlength="10">
                <p id="DivToolAveragePrice"></p>
            </td>
            <th width="150">
                可刃磨次数
            </th>
            <td>
                <input name="sharpen_num" type="text" class="u-ipt" maxlength="4">
            </td>
        </tr>
        <tr>
            <th width="150">
                刃口数
            </th>
            <td>
                <input name="cutNumber" type="text" class="u-ipt" maxlength="4">
            </td>
            <th width="150" >
                修磨类别
            </th>
            <td >
                <select name="grinding"  class="u-sel hidder" maxlength="2">
                    <option value="" selected="selected">请选择</option>
                    <option value="1">厂内修磨</option>
                    <option value="2">厂外修磨</option>
                    <option value="3">厂外涂层</option>
                </select>
                <p id="DivToolGrinding"></p>
            </td>
        </tr>
    </table>
    <table id="assistive_device_none">
        <tr>
            <th width="150">
                刀具用途类型
            </th>
            <td>
                <select name="userfulType"  class="u-sel hidder" maxlength="2">
                    <option value="1">复合类</option>
                    <option value="2">热套类</option>
                    <option value="3">专机</option>
                    <option value="9">其他</option>
                </select>
                <p id="DivTooluserfulType"></p>
            </td>
        </tr>
    </table>

    <select class="u-sel" id="Base_cutting_tool">
        <option value="1">可刃磨钻头</option>
        <option value="2">可刃磨刀片</option>
        <option value="3">一次性刀片</option>
        <option value="9">其他</option>
    </select>
    <select class="u-sel" id="Base_assistive_device">
        <option value="9">其他</option>
    </select>
</div>

</body>
</html>

