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
            $("#DivToolType,#DivToolConsumetype").change(function (e) {
                var toolType = $("#toolEditFormTable select[id=DivToolType]").val();
                var toolConsumetype = $("#toolEditFormTable select[id=DivToolConsumetype]").val();
                checkToolConsumetype(toolType, toolConsumetype);
            });
            $("#DivToolType").change(function (e) {
                var toolType = $("#toolEditFormTable select[id=DivToolType]").val();
                var toolConsumetype = $("#toolEditFormTable select[id=DivToolConsumetype]").val();
                checkToolType(toolType, toolConsumetype);
                $("#DivToolConsumetype").trigger("change");
            });
            /******************************************/
        });

        /**根据刀具分类-消耗类别显示输入框**/
        function checkToolType(toolType, toolConsumetype) {
            //如果是1辅具和2配套, 消耗类别为其他
            console.log(toolType);
            if (toolType == "2" || toolType == "3") {
                $("#toolEditFormTable select[id=DivToolConsumetype]").empty();
                $("#Base_DivToolConsumetype option").each(function () {
                    if ($(this).val() == "9") {
                        var $op = $(this).clone();
                        $("#toolEditFormTable select[id=DivToolConsumetype]").append($op);
                    }
                });
            } else if (toolType == "") {
                $("#toolEditFormTable select[id=DivToolConsumetype]").empty();
                $("#toolEditFormTable select[id=DivToolConsumetype]").append('<option value="">--请选择--</option>');
            } else {
                $("#toolEditFormTable select[id=DivToolConsumetype]").empty();
                $("#Base_DivToolConsumetype option").each(function () {
                    if ($(this).val() == "3" || $(this).val() == "1" || $(this).val() == "2") {
                        var $op = $(this).clone();
                        $("#toolEditFormTable select[id=DivToolConsumetype]").append($op);
                    }
                });
            }
        }
        /**根据刀具分类-消耗类别显示输入框**/
        function checkToolConsumetype(toolType, toolConsumetype) {
            //刀具分类和消耗类别都选择后再做操作
            if (toolType != "") {
                if (toolConsumetype != "") {
                    if (toolType == "1" && toolConsumetype == "1") {
                        //如果是0刀具-0可刃磨钻头
                        showOrHide("0-0");
                    } else if (toolType == "1") {
                        //如果是0刀具-非转头
                        showOrHide("0-1,2,9");
                    } else if (toolType == "2" || toolType == "3") {
                        //如果是1辅具和2配套
                        showOrHide("1,2");
                    }

                }

            }
        }

        /**str:
         *        0-0如果是0刀具-0可刃磨钻头:为显示"复磨标准 "、“可刃磨长度”、“刀具长度 ”,不需要“可使用次数”
         *        0-1,2,9如果是0刀具-非钻头:为显示“可使用次数”,不需要"复磨标准 "、“可刃磨长度”、“刀具长度 ”
         *        1,2如果是1辅具和2配套：不需要“可使用次数”、“周转量”
         *
         }
         **/
        function showOrHide(str, type) {
            $("#toolEditFormTable tr:gt(5)").remove();
            if ($("#toolEditFormTable tr:eq(6) td").length == 2) {
                $("#toolEditFormTable tr:eq(6) td:eq(0)").remove();
                $("#toolEditFormTable tr:eq(6) th:eq(0)").remove();
            }
            var $tab = $("#NotMustTr_table tr").clone();
            $tab.find(".hidder").each(function (i) {

                var flag = true;
                if (str == "0-0") {
                    if ($(this).attr('name') == "sharpenNum") {
                        flag = false;
                    }

                } else if (str == ("0-1,2,9")) {
                    if ($(this).attr('name') == "sharpenCriterion") {
                        flag = false;
                    }
                    if ($(this).attr('name') == "sharpenLength") {
                        flag = false;
                    }
                    if ($(this).attr('name') == "materialLength") {
                        flag = false;
                    }

                } else if (str == ("1,2")) {
                    if ($(this).attr('name') == "sharpenCriterion") {
                        flag = false;
                    }
                    if ($(this).attr('name') == "sharpenLength") {
                        flag = false;
                    }
                    if ($(this).attr('name') == "materialLength") {
                        flag = false;
                    }
                    if ($(this).attr('name') == "sharpenNum") {
                        flag = false;
                    }
                    if ($(this).attr('name') == "DivToolTurnover") {
                        flag = false;
                    }
                }
                if (flag) {
                    if ($("#toolEditFormTable tr:last td").length == 2) {
                        $("#toolEditFormTable ").append("<tr></tr>");
                        $("#toolEditFormTable tr:last").append($(this).parent("td").prev());
                        $("#toolEditFormTable tr:last").append($(this).parent("td"));
                    } else {
                        $("#toolEditFormTable tr:last").append($(this).parent("td").prev());
                        $("#toolEditFormTable tr:last").append($(this).parent("td"));
                    }
                }
            });
        }

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
                    title: '材料号',
                    name: 'businessCode'
                }, {
                    title: '刀具名称',
                    name: 'name'
                }, {
                    title: '规格型号',
                    name: 'specifications'
                },  //  {
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
                            return '<span class="ui-grid-tdtx"></span>';
                        }
                    },
                    {
                        title: '刀具图纸',
                        name: 'pic',
                        format: function (r) {
                            return option(r, "ToolPicText");
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



        //从选择库位码页面中 选出code返回编辑页面
        function sysCode(lcid, scode, ccode) {
            var show;

            if (ccode && ccode != "") {
                show = ccode;
            }
            else {
                show = scode;
            }
            $(toolEditForm.DivLibraryCodeID).val(lcid)
            $(toolEditForm.DivSysteCodeShow).val(show);
            $.dialog.list['codeDialog'].close();
        }


        //添加刀具
        function wd_tool(data, id, obj) {
            //复制table
            $("#toolEditFormTable tr:not(tr:lt(6))").remove();
            var $tab = $("#NotMustTr_table tr").clone();
            $tab.children("td").each(function (i) {

                if ($("#toolEditFormTable tr:last td").length == 2) {
                    $("#toolEditFormTable ").append("<tr></tr>");
                    $("#toolEditFormTable tr:last").append($(this).prev());
                    $("#toolEditFormTable tr:last").append($(this));
                } else {
                    $("#toolEditFormTable tr:last").append($(this).prev());
                    $("#toolEditFormTable tr:last").append($(this));
                }
            });


            $('#toolEditForm').form('reset');
            var title = '${session.lang.toolAddTitle}';
            $('#toolEditForm :input').removeClass('u-ipt-err');
            $('#toolEditForm').find("*").each(function () {
                if ($(this).hasClass("u-sel")) {
                    $(this).removeAttr("style");
                }
            });

            if (typeof(data) == 'object') {
                $(toolEditForm.opt).val('edit');
                // 页面赋值
                checkToolType(data.type, data.consumeType);
                checkToolConsumetype(data.type, data.consumeType);
                $(toolEditForm.type).val(data.type);
                $(toolEditForm.consumeType).val(data.consumeType);
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

                $(toolEditForm.sharpenNum).val(data.sharpenNum);
                $(toolEditForm.materialLength).val(data.materialLength);//刀具长度
                $(toolEditForm.sharpenCriterion).val(data.sharpenCriterion);//复磨标准
                $(toolEditForm.sharpenLength).val(data.sharpenLength);//可刃磨长度
                $(toolEditForm.code).attr("disabled", "");//禁用刀具编码

            } else {
                checkToolType("", "");
                $(toolEditForm.code).removeAttr("disabled");//启用刀具编码
                $(toolEditForm.isDel).val(0);//删除区分-有效
//                $('#toolEditForm').attr('action', 'toolAdd.action');
            }
            $.dialog({
                id: 'toolEdit_dialog',
                title: title,
                lock: true,
                content: document.getElementById('toolEdit'),
                button: [{
                    name: '保存',
                    focus: true,
                    callback: function () {
                        if (typeof(data) == 'object'){
                            editCuttingTool();
                            console.log('123');
                        }else{
                            addCuttingTool();
                            console.log('aaa');
                        }

                        return false;
                    }
                }]
            });
            return false;
        }

        function initParam(){
            var param = {};
            param.code = $(toolEditForm.code).val();
            param.id = $(toolEditForm.id).val();
            param.libraryCode = $(toolEditForm.libraryCode).val();
            param.businessCode = $(toolEditForm.businessCode).val();
            param.name = $(toolEditForm.name).val();
            param.type = $(toolEditForm.type).val();
            param.consumeType = $(toolEditForm.consumeType).val();
            param.pic = $(toolEditForm.pic).val();
            param.specifications = $(toolEditForm.specifications).val();
            param.cutNumber = $(toolEditForm.cutNumber).val();
            param.brand = $(toolEditForm.brand).val();
            param.grinding = $(toolEditForm.grinding).val();
            param.sharpenNum = $(toolEditForm.sharpenNum).val();
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
//            param.userfulType = $(toolEditForm.userfulType).val();
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


        /**图片过大处理**/
        var adjustImgSize = function (img, boxWidth, boxHeight) {
            // var imgWidth=img.width();
            // var imgHeight=img.height();
            // 上面这种取得img的宽度和高度的做法有点儿bug
            // src如果由两个大小不一样的图片相互替换时，上面的写法就有问题了，换过之后的图片的宽度和高度始终取得的还是换之前图片的值。
            // 解决方法：创建一个新的图片类，并将其src属性设上。
            var tempImg = new Image();
            tempImg.src = img.attr('src');
            var imgWidth = tempImg.width;
            var imgHeight = tempImg.height;
            if (imgWidth > 800 || imgHeight > 800) {
                if ((imgWidth / imgHeight) > 1) {
                    img.width(875);
                } else {
                    img.height(875);
                }
            }
        };

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

        /**文件上传js*/
        $(function () {
            $("input[type=file]").change(function () {
                $(this).parents(".uploader").find(".uplode-filename").val($(this).val());
            });
            $("input[type=file]").each(function () {
                if ($(this).val() == "") {
                    $(this).parents(".uploader").find(".uplode-filename").val("No file selected...");
                }
            });

            /**可使用次数 = 可刃磨长度/刃磨标准**/
            $('input[name=DivToolSharpennum]').focus(function () {
                var SharpenLength = $('input[name=DivToolSharpenLength]').val();
                var SharpenCriterion = $('input[name=DivToolSharpenCriterion]').val();
                var ret = parseInt(SharpenLength / SharpenCriterion);
                if (!isNaN(ret)) {
                    $(this).val(ret);
                }
            });
        });

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
                    刃口数<%--每盒数量--%>
                </th>
                <td>
                    <input name="cutNumber" type="text" class="u-ipt" maxlength="4">
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
                    库位码
                </th>
                <td>
                    <input name="libraryCode" type="text" class="u-ipt" maxlength="16">
                </td>
            </tr>
        </table>
        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">
                    刀具单价
                </th>
                <td>
                    <input name="toolPrice" type="text" class="u-ipt" maxlength="10">
                    <p id="DivToolPrice"></p>
                </td>
                <th width="150">
                    平均修磨单价
                </th>
                <td>
                    <input name="averagePrice" type="text" class="u-ipt" maxlength="10">
                    <p id="DivToolAveragePrice"></p>
                </td>
            </tr>
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
    </form>
</div>

<!-- 用于复制页面  -->
<div class="f-dn">
    <select class="u-sel" id="Base_DivToolConsumetype">
        <option value="1">可刃磨钻头</option>
        <option value="2">可刃磨刀片</option>
        <option value="3">一次性刀片</option>
        <option value="9">其他</option>
    </select>
    <table id="NotMustTr_table">
        <tr>
            <th width="150">
                可刃磨次数
            </th>
            <td>
                <input name="toolNumber" type="text" class="u-ipt hidder" maxlength="5">
                <p id="DivToolNumeber"></p>
            </td>
        </tr>
        <tr>
            <th width="150" >
                修磨类别
            </th>
            <td >
                <select name="grinding"  class="u-sel hidder" maxlength="2">
                    <option value="1" selected="selected">厂内修磨</option>
                    <option value="2">厂外修磨</option>
                    <option value="3">厂外涂层</option>
                </select>
                <p id="DivToolGrinding"></p>
            </td>
        </tr>
    </table>
</div>
<div id="showImage" class="f-dn">
</div>

</body>
</html>

