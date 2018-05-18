<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%@ include file="../../common/header_common.jsp"%>
    <script type="text/javascript">
        var m = 0;
        var n = 0;
        var s = 0;
        var partHtml = "";
        var synthesisParametersHtml = "";
        $(function(){
            jQuery('body').layout({
                center__childOptions:{
                    north__resizable:false,
                    spacing_open:0
                },
                north:{
                    size:'auto',
                    spacing_open:0,
                    closable:false,
                    resizable:false
                }
            });

            $('#list').grid({
                barid:'#bar',
                datatype:'json',
                type:'post',
                width:'100%',
                fit:true,
                lazy:false,
                async:false,
                rowno:true,
                rows:15,
                roll:6,
                pager:true,
                pagerpos:'right',
                pagercon:'first,last,number,next,prev',
                column:[{
                        title:'流水线',
                        name:'d_productLineAssemblyline'
                    },
                    {
                        title:'工序',
                        name:'d_productLineProcess'
                    },
                    {
                        title:'设备名称',
                        name:'d_productLineEquipment'
                    },
                    {
                        title:'合成刀具',
                        name:'d_synthesisCuttingTool'
                    },
                    {
                        title:'耐用度',
                        name:'toolDurable'
                    },
                    {
                        title:'加工工艺',
                        name:'d_productLineParts'
                    },
                    {
                        title:'轴名称',
                        name:'d_productLineAxle'
                    },
                    {
                        title: '操作',
                        name: '',
                        width: '130px',
                        visible: 'true',
                        format: function (r, t) {
                            return option(r);
                        }
                    }
                ],
                success:function(d){
                    if(d.status < 0){
                        artDialog(d.message,"OK");
                    }
                }
            }) ;
            $("#button1").click(function () {
                s += 1;
                var html = "";
                html +=	 '<tr name="newTr">';
                html +=	 '<th width="150">合成刀具</th>';
                html +=	 '<td>';
                html +=	 '<div id="SynthesisParameters'+s+'" class="selectbox" style="z-index: 10">';
                html +=  '</div>';
                html +=  '</td>';
                html +=  '<th width="150">耐用度</th>';
                html +=  '<td>';
                html +=  '<input name="DivToolDurable" type="text" class="u-ipt" maxlength="11">';
                html += '<button onclick="removeTr(this)" class="aui_state_highlight" type="button" style="margin-left: 4px;padding: 3px;">移除</button>';
                html +=	 '</td>';
                html +=	 '</tr>';
                $("#table1").append(html);
                $("#SynthesisParameters"+s).append(synthesisParametersHtml);

            });

            $("#button2").click(function(){
                m += 1;
                n += 1;
                var newDiv = "newDiv" + m;
                var newTab = "newTab" + m;
                var newButton = "nb" + n;
                var html = "";
                html +=  '<div id="'+newDiv+'" name="newDiv">';
                html +=  '<table class="m-frmtb" width="100%" id="'+newTab+'">';
                html +=  '<tr>';
                html +=  '<th width="150">零部件名称</th>';
                html +=	 '<td>';
                html +=	 '<div id="s_Parts'+m+'" name="s_Parts" class="selectbox" style="z-index: 10">';
                html +=	 '</div>';
                html +=	 '</td>';
                html +=	 '<td width="150"><button  onclick="removeTable(this)" class="aui_state_highlight" type="button" style="padding: 3px;">移除零部件</button></td>';
                html +=	 '</tr>';
                html +=	 '<tr>';
                html +=	 '<th width="150">合成刀具</th>';
                html +=	 '<td style="width: 190px;">';
                html +=	 '<div id="s_SynthesisParameters'+m+'" name="s_SynthesisParameters" class="selectbox" style="z-index: 10">';
                html +=  '</div>';
                html +=  '</td>';
                html +=  '<th width="150">耐用度</th>';
                html +=  '<td>';
                html +=  '<input name="DivToolDurable" type="text" class="u-ipt" maxlength="11">';
                html +=  '<button id="'+newButton+'" onclick="return newAdd('+m+')" class="aui_state_highlight" type="button" style="padding: 3px;margin-left: 4px;" >添加</button>';
                html +=	 '</td>';
                html +=	 '</tr>';
                html +=  '</table>';
                $("#div1").append(html);
                $("#s_Parts"+m).append(partHtml);
                $("#s_SynthesisParameters"+m).append(synthesisParametersHtml);

            });
            loadData();
            $("#test").click(function(){
                var v = $("#hEdit").val();
                if(v == "edit"){
                    var param = {
                        DivOplinkID:$(OplinkEditForm.DivOplinkID).val(),
                        DivProcess:$("select[name='DivProcess']").val(),
                        DivEquipment:$(OplinkEditForm.DivEquipment).val(),
                        DivAssemblyLine:$("select[name='DivAssemblyLine']").val(),
                        SynthesisParameters: $("select[name='SynthesisParameters']").val(),
                        Parts:$("select[name='Parts']").val(),
                        DivAxle: $(OplinkEditForm.DivAxle).val(),
                        DivToolDurable:$(OplinkEditForm.DivToolDurable).val()
                    }
                    console.log('编辑提交');
                     $.ajax({
                    type: "POST",
                        url: "/productLine/upd",
                        dataType: "json",
                        data: JSON.stringify(param),
                        error: function (XHR, textStatus, errorThrown) {
                        artDialog(XHR.responseText, "OK");
                    },
                    success: function (data, textStatus) {
                        $.dialog.list['OplinkEdit_dialog'].close();
                    },
                    headers: {
                        "content-type": "application/json"
                    }
                });
                }else{
                    // 设备名称
                    var eq = document.getElementsByName("eqCode");
                    // 轴编号
                    var axle = document.getElementsByName("axleCode");

                    // 得到checkbox数组
                    var eqStr = "";
                    var axleStr = "";
                    // 取得所选择的设备名称
                    for(var i= 0;i<eq.length;i++){
                        if(eq[i].checked){
                            eqStr += eq[i].value + ",";
                        }
                    }

                    // 取得所选择的轴编号
                    for(var i= 0;i<axle.length;i++){
                        if(axle[i].checked){
                            axleStr += axle[i].value + ",";
                        }
                    }

                    if($("select[name='DivAssemblyLine']").val()==""){
                        alert("请选择生产线");
                        return;
                    }else if($("select[name='DivProcess']").val()==""){
                        alert("请选择工序");
                        return;
                    }else if(eqStr == ""){
                        alert("请选择设备名称");
                        return;
                    }else if(axleStr == ""){
                        alert("请选择轴编号");
                        return;
                    }
                    var partFlag = false;
                    var synthesisParametersFlag = false;
                    var toolDurableFlag = false;
                    var str = "";
                    var parts = "";
                    $("select[name='Parts']").each(function(){
                        if($(this).val() == ""){
                            partFlag = true;
                            $(this).attr("style","border-color:red");
                        }else{
                            parts += $(this).val()+",";
                            $(this).removeAttr("style");
                        }
                    });
                    $("select[name='SynthesisParameters']").each(function(){
                        if($(this).val() == ""){
                            synthesisParametersFlag = true;
                            $(this).attr("style","border-color:red");
                        }else{
                            str += $(this).parent().parent().parent().parent().find(".u-sel").val() +
                                ";" + $(this).val() +
                                ";"+ $(this).parent().parent().next().next().find(".u-ipt").val() + ",";
                            $(this).removeAttr("style");
                        }
                    });
                    $("input[name='DivToolDurable']").each(function(){
                        if($(this).val() == ""){
                            toolDurableFlag = true;
                            $(this).attr("style","border-color:red");
                        }else{
                            $(this).removeAttr("style");
                        }
                    });
                    if(partFlag){
                        return;
                    }
                    if(synthesisParametersFlag){
                        return;
                    }
                    if(toolDurableFlag){
                        return;
                    }
                    str = str.substr(0,str.length-1);
                    parts = parts.substr(0,str.length-1);
                    var param = {
                        parts:parts,
                        processID:$("select[name='DivProcess']").val(),
                        assemblyLineID:$("select[name='DivAssemblyLine']").val(),
                        equipmentID:eqStr,
                        axleID:axleStr,
                        str:str
                    };
                    console.log(param);
                    //新建提交
                    console.log('新建提交');
                    $.ajax({
                        type: "POST",
                        url: "/productLine/addForWeb",
                        dataType: "json",
                        data: JSON.stringify(param),
                        error: function (XHR, textStatus, errorThrown) {
                            artDialog(XHR.responseText, "OK");
                        },
                        success: function (data, textStatus) {
                            $.dialog.list['OplinkEdit_dialog'].close();
                        },
                        headers: {
                            "content-type": "application/json"
                        }
                    });
                }
            });
        });

        function loadData(){
            $.ajax({
                type: "POST",
                url: "/synthesisCuttingTool/list",
                dataType: "json",
                data: JSON.stringify({}),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    console.log(data);
                    synthesisParametersHtml += "<select class='u-sel' name='SynthesisParameters'>";
                    synthesisParametersHtml += "<option value=''>--请选择--</option>";
                    var content = '';
                    data.data.forEach(function(d){
                        synthesisParametersHtml += '<option value="'+d.code+'">'+d.synthesisCode+'</option>';
                        content+='<option value="'+d.code+'">'+d.synthesisCode+'</option>'
                    });
                    $('#SynthesisTools_select').append(content);
                    synthesisParametersHtml += "</select>";
                },
                headers: {
                    "content-type": "application/json"
                }
            });
            $.ajax({
                type: "POST",
                url: "/productLineAxle/list",
                dataType: "json",
                data: JSON.stringify({}),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    console.log(data);
                    var content = '';
                    var axleCode = "";
                    data.data.forEach(function(d){
                        content+='<option value="'+d.code+'">'+d.name+'</option>'
                        axleCode += '<input type="checkbox" name="axleCode" value="'+d.code+'"/>' + '<font style="margin-left:3px;margin-right:3px;">'+d.name+'</font>';
                    });
                    $('#query_axleCode').append(content);
                    $('#axleCodes_select').append(content);
                    $("#axle").html(axleCode);

                },
                headers: {
                    "content-type": "application/json"
                }
            });
            $.ajax({
                type: "POST",
                url: "/productLineAssemblyline/list",
                dataType: "json",
                data: JSON.stringify({}),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    var content = '';
                    data.data.forEach(function(d){
                        content+='<option value="'+d.code+'">'+d.name+'</option>'
                    });
                    $('#query_assemblylineCode').append(content);
                    $('#assemblylineCode').append(content);

                },
                headers: {
                    "content-type": "application/json"
                }
            });
            $.ajax({
                type: "POST",
                url: "/productLineEquipment/list",
                dataType: "json",
                data: JSON.stringify({}),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    var content = '';
                    var eqCode = "";

                    data.data.forEach(function(d){
                        content+='<option value="'+d.code+'">'+d.name+'</option>'
                        eqCode += '<input type="checkbox" name="eqCode" value="'+d.code+'"/>' + '<font style="margin-left:3px;margin-right:3px;">'+d.name+'</font></br>';
                    });
                    $('#query_equipmentCosde').append(content);
                    $('#equipmentCodes_select').append(content);
                    $("#equip").html(eqCode);

                },
                headers: {
                    "content-type": "application/json"
                }
            });
            $.ajax({
                type: "POST",
                url: "/productLineProcess/list",
                dataType: "json",
                data: JSON.stringify({}),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {

                    var content = '';
                    data.data.forEach(function(d){
                        content+='<option value="'+d.code+'">'+d.name+'</option>'
                    });
                    $('#query_processCode').append(content);
                    $('#processCode').append(content);

                },
                headers: {
                    "content-type": "application/json"
                }
            });
            $.ajax({
                type: "POST",
                url: "/productLineParts/list",
                dataType: "json",
                data: JSON.stringify({}),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {

                    var content = '';
                    partHtml += "<select class='u-sel' name='Parts'>";
                    partHtml += "<option value=''>--请选择--</option>";
                    data.data.forEach(function(d){
                        content+='<option value="'+d.code+'">'+d.name+'</option>'
                        partHtml += '<option value="'+d.code+'">'+d.name+'</option>';
                    });
                    partHtml += "</select>";
                    $('#Parts_select').append(content);
                    $('#query_partsCode').append(content);

                },
                headers: {
                    "content-type": "application/json"
                }
            });
        }

        /**
         * 操作列超链接
         */
        function option(r){
            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            ary_li.push($('<li><a href="javascript:void(0)">编辑</a></li>').click(function(){wd_oplink(r)}));
            ary_li.push($('<li><a href="javascript:void(0)">删除</a></li>').click(function(){if(r.isDel == 0){del(r)}}));
            $.each(ary_li,function(i,o){
                $li.after(o);
            });
            return $ul.append($li);
        }

        /**
         * 查询处理
         */
        function search(){
            var param = {
                name:$('#query_name').val(),
                code:$('#query_code').val(),
                pageSize:15,
                currentPage : $('#currentPage').val()==""?1:$('#currentPage').val()
            }
            console.log(param);
            $.ajax({
                type: "POST",
                url: "/productLine/list",
                dataType: "json",
                data: JSON.stringify(param),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    console.log(data);
                    $('#list').grid('loadData', dataHandler(data));
                },
                headers: {
                    "content-type": "application/json"
                }
            });
        }

        function dataHandler(data){
            data.data.forEach(function (d) {
                d.d_productLineAssemblyline =d.productLineAssemblyline.name;
                d.d_productLineProcess = d.productLineProcess.name;
                d.d_productLineEquipment = d.productLineEquipment.name;
                d.d_synthesisCuttingTool = d.synthesisCuttingTool.synthesisCode;
                d.d_productLineParts = d.productLineParts.name;
                d.d_productLineAxle = d.productLineAxle.name;
            })
            return data;
        }

        /**
         * 删除处理
         */
        function del(data){
            $.dialog.confirm('确认删除?',function(){
                var param = {
                    id:data.id
                }
                $.ajax({
                    type: "POST",
                    url:"/productLine/del",
                    dataType:"json",
                    data:JSON.stringify(param),
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

        /**
         * 编辑处理
         */
        function edit(){
            var param = {
                id:$('#id').val(),
                name:$('#name').val(),
                code:$('#code').val(),
            }
            $.ajax({
                type: "POST",
                url:"/productLine/upd",
                dataType:"json",
                data:JSON.stringify(param),
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

        function add(){
            var param = {
                name:$('#name').val(),
                code:$('#code').val()
            }
            $.ajax({
                type: "POST",
                url:"/productLine/add",
                dataType:"json",
                data:JSON.stringify(param),
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

        function pageClick(page){
            $('#currentPage').val(page);
            search();
        }

        function newAdd(m){
            n += 1;
            var html = "";
            html +=  '<tr>';
            html +=  '<th width="150">${sessionScope.lang.SynthesisParametersText}</th>';
            html +=	 '<td>';
            html +=	 '<div id="SynthesisParameter'+n+'" name="SynthesisParameters" class="selectbox" style="z-index: 10">';
            html +=	 '</div>';
            html +=	 '</td>';
            html +=	 '<th width="150">${sessionScope.lang.ToolDurableText}</th>';
            html +=	 '<td>';
            html +=	 '<input name="DivToolDurable" type="text" class="u-ipt" maxlength="11">';
            html += '<button onclick="removeTr(this)" class="aui_state_highlight" type="button" style="margin-left: 4px;padding: 3px;">移除</button>';
            html +=	 '</td>';
            html +=	 '</tr>';
            $("#newTab"+m).append(html);
            $("#SynthesisParameter"+n).append(synthesisParametersHtml);
        }

        function getParent (el, parentTag) {
            do {
                el = el.parentNode;
            } while (el && el.tagName !== parentTag);
            return el;
        }

        /**
         * 移除当前Tr
         * @param el
         */
        function removeTr (el) {
            el = getParent(el, 'TR');
            var rowIndex = el.rowIndex;
            el = getParent(el, 'TABLE');
            el.deleteRow(rowIndex);
        }

        /**
         * 移除当前Table
         * @param el
         */
        function removeTable (el) {
            el = getParent(el, 'TABLE');
            el.remove();
        }
        // 2017/08/21 宋健 追加↑↑↑　dazhong@YMSC
        //	联动
        $(function(){
            $("#procedures").val("");
            $("#Equipment").val("");
        });


        function S_editInit(id,baseSelect,S_DivId){
            $("select[name="+baseSelect+"] option").each(function(){
                if($(this).val().indexOf(id)>-1){
                    $("#"+S_DivId+" input:eq(0)").val($(this).text().trim());
                }
            });
            $("#"+S_DivId+" input:eq(1)").val(id);
        }
        //添加(编辑)关联
        function wd_oplink(data,id,obj){

            $("div[name='newDiv']").remove();
            $("tr[name='newTr']").remove();

            $('#OplinkEditForm').form('reset');
            var title = '${session.lang.AddOplinkTitle}';
            $('#OplinkEditForm :input').removeClass('u-ipt-err');
            $('#OplinkEditForm').find("*").each(function () {
                if($(this).hasClass("u-sel")){
                    $(this).removeAttr("style");
                }
            });
            if(typeof(data) == 'object'){
                $(OplinkEditForm.opt).val('edit');
                // 页面赋值
                console.log(data);
                console.log(data.productLineParts.code);
                $(OplinkEditForm.DivOplinkID).val(data.id);
                $(OplinkEditForm.DivAssemblyLine).val(data.productLineAssemblyline.code);
                $(OplinkEditForm.DivProcess).val(data.productLineProcess.code);
                $(OplinkEditForm.DivSynthesisParameters).val(data.synthesisCuttingTool.code);
                S_editInit(data.productLineParts.code,'DivParts','s_Parts');
                S_editInit(data.productLineEquipment.code,'Equipment','s_DivEquipment');
                S_editInit(data.synthesisCuttingTool.code,'DivSynthesisParameters','s_SynthesisParameters');
                $(OplinkEditForm.DivEquipment).val(data.productLineEquipment.code);
                $("select[name='DivAxle']").val(data.productLineEquipment.code);
                $("select[name='Parts']").val(data.productLineParts.code);
                $("select[name='SynthesisParameters']").val(data.synthesisCuttingTool.code);
                $(OplinkEditForm.DivToolDurable).val(data.toolDurable);
                $(OplinkEditForm.DivAxle).val(data.productLineAxle.code);//机构

                title = '${session.lang.EditOplinkTitle}';

                <!-- 2017/08/21 宋健 变更↓↓↓　dazhong@YMSC -->
                $("#equip").attr("style","display:none");
                $("#axle").attr("style","display:none");
                $("#s_DivEquipment").attr("style","display:block");
                $("#DivAxle").attr("style","display:block");
                $("#div1").attr("style","height:60px;");
                $("#button1").hide();
                $("#button2").hide();
                $("#hEdit").val("edit");
                <!-- 2017/08/21 宋健 变更↑↑↑　dazhong@YMSC -->

            }else{
                <!-- 2017/08/21 宋健 变更↓↓↓　dazhong@YMSC -->
                $("#equip").attr("style","display:block;width: 275px;height: 125px;overflow-y:scroll;padding: 5px;");
                $("#axle").attr("style","display:block;width: 144px;height: 125px;padding: 5px;");
                $("#s_DivEquipment").attr("style","display:none");
                $("#DivAxle").attr("style","display:none");
                $("#div1").attr("style","height: 200px;overflow-y:scroll;");
                $("#button1").show();
                $("#button2").show();
                $("#hEdit").val("add");
                <!-- 2017/08/21 宋健 变更↑↑↑　dazhong@YMSC -->
                $(OplinkEditForm.DivVersion).val(0);//版本号
                $('#OplinkEditForm').attr('action','oplinkAdd.action');
            }
            $.dialog({
                id:'OplinkEdit_dialog',
                title:title,
                lock: true,
                content:document.getElementById('editDiv'),
            });
            return false;
        }
    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>系统配置> 生产关联配置</span>
        <%@ include file="../../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            检索
        </div>
        <form id="partsForm" name="partsForm" method="post">
            <input name="currentPage" id="currentPage" type="hidden" class="u-ipt" maxlength="50">
            <table width="100%" class="m-frmtb">
                <tr>
                    <th width="150">
                        零部件
                    </th>
                    <td>
                        <select class="u-sel" id="query_partsCode">
                            <option value="">--请选择--</option>
                        </select>
                    </td>
                    <th width="150">
                        工序
                    </th>
                    <td>
                        <select class="u-sel" id="query_processCode">
                            <option value="">--请选择--</option>
                        </select>
                    </td>
                    <th width="150">
                        设备名称
                    </th>
                    <td>
                        <select class="u-sel" id="query_equipmentCode">
                            <option value="">--请选择--</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th width="150">
                        加工工艺
                    </th>
                    <td>
                        <select class="u-sel" id="query_assemblylineCode">
                            <option value="">--请选择--</option>
                        </select>
                    </td>
                    <th width="150">
                        合成刀具
                    </th>
                    <td>
                        <input  id="synthesisCode" type="text" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        设备名称
                    </th>

                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" onclick="return search()">
                    查询
                </button>
                <button type="button" class="u-btn2" onclick="return wd_oplink()">
                    新建
                </button>
            </div>
        </form>
        <div class="f-cb"></div>

        <div class="u-ptt">
            详细
        </div>
    </div>
    <div class="ui-layout-center">
        <table id="list"></table>
        <div id="bar"></div>
    </div>
</div>
<div id="editDiv" class="f-dn">
    <form id="OplinkEditForm" name="OplinkEditForm" method="post">
        <input type="text" class="f-dn" name="opt" value="add"/>
        <input type="hidden" id="hEdit"/>
        <input type="text" class="f-dn" name="DivOplinkID" />
        <input type="text" class="f-dn" id="id" />
        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">
                    生产线名称
                </th>
                <td>
                    <select class="u-sel" name="DivAssemblyLine" id="assemblylineCode">
                        <option value="">--请选择--</option>
                    </select>
                </td>
                <th width="150">
                    工序
                </th>
                <td>
                    <select class="u-sel" id="processCode" name="DivProcess">
                        <option value="">--请选择--</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th width="150" id="eqTd">
                    设备名称
                </th>
                <td>
                    <div id="s_DivEquipment" style='display: none;'>
                        <select class="u-sel" name="DivEquipment" id="equipmentCodes_select">
                            <option value="">--请选择--</option>
                        </select>
                    </div>
                    <input type="hidden" name="DivEquipments"  class="listVal" />
                    <div id="equip" style="width: 275px;height: 125px;overflow-y:scroll;padding: 5px;"></div>
                </td>
                <th width="150" id="axTd">
                    轴编号
                </th>
                <td>
                    <div id="DivAxle" style='display: none;'>
                        <select class="u-sel" name="DivAxle"  id="axleCodes_select">
                            <option value="">--请选择--</option>
                        </select>
                    </div>
                    <input type="hidden" name="DivAxles"  class="listVal" />
                    <div id="axle" style="width: 144px;height: 125px;padding: 5px;"></div>
                </td>
            </tr>
        </table>
        <div>
            <button id="button2" class="aui_state_highlight" type="button" style="padding: 3px;">添加零部件</button>
        </div>
        <div style="height: 200px;overflow-y:scroll;" id="div1">
            <table class="m-frmtb" width="100%" id="table1">
                <tr>
                    <th width="150">
                        零部件名称
                    </th>
                    <td>
                        <div id="s_Parts" name="s_Parts" class="selectbox" style='z-index: 10'>
                            <select class="u-sel" name="Parts_select" id="Parts_select">
                                <option value="">--请选择--</option>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th width="150">
                        合成刀具
                    </th>
                    <td>
                        <div id="s_SynthesisParameters" class="selectbox" style='z-index: 10'>
                            <select class="u-sel" name="SynthesisParameters" id="SynthesisTools_select">
                                <option value="">--请选择--</option>
                            </select>
                        </div>
                    </td>
                    <th width="150">
                        耐用度
                    </th>
                    <td>
                        <input name="DivToolDurable" type="text" id="SynthesisTools_toolDurable" class="u-ipt" maxlength="11">
                        <button id="button1" class="aui_state_highlight" type="button" style="padding: 3px;">添加</button>
                    </td>
                </tr>
            </table>
        </div>
    </form>
    <div class="aui_buttons">
        <button id="test" class="aui_state_highlight">保存</button>
    </div>
</div>
<div id="base" style="display: none;">
    <select class="u-sel" name="DivSynthesisParameters">
        <option value="">
            --${sessionScope.lang.PleaseSelect}--
        </option>
        <s:iterator value="#request.SynthesisParametersList"
                    id="synthesisParameters">
            <option value="${synthesisParameters.synthesisParametersID}">
                    ${synthesisParameters.synthesisParametersCode}
            </option>
        </s:iterator>
    </select>
</div>
</body>
</html>

