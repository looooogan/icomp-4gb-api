<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%@ include file="../../common/header_common.jsp"%>
    <script type="text/javascript">
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
            <!-- 2017/08/24 宋健 变更↓↓↓　dazhong@YMSC -->
            $("#synthesisCuttingToolTypeId").change(function(){
                var v = $("input[name='location[0]']").val();
                var type = $("#synthesisCuttingToolTypeId").val();
                $("#DivSynthesisCount").val("1");
                var html = '';
                html += '<thead style="display: table-header-group;">';
                html += '<tr>';
//                html += '<th width="120">位置号</th>';
                html += '<th>位置类型</th>';
                html += '<th>刀具编码</th>';
                html += '<th>替换刀具编码1</th>';
                html += '<th>替换刀具编码2</th>';
                html += '<th>刀具数量</th>';
                html += '</tr>';
                html += '</thead>';
                html += '<tbody>';
                html += '<tr>';
//                html += '<th><input name="location[0]" type="text" class="f-dn" value="0"><p>0</p>'</th>';
                html += '<td>';
                html += '<select class="u-sel" name="type[0]" id="typeId">';
                html += '<option value="1">刀具</option>';
                html += '<option value="2">辅具</option>';
                html += '</select>';
                html += '</td>';
                html += '<td>';
                html += '<input name="cuttingToolCode[0]" type="text" class="u-ipt" maxlength="45">';
                html += '</td>';
                html += '<td>';
                html += '<input name="replaceCuttingToolCode1[0]" type="text" class="u-ipt" maxlength="45">';
                html += '</td>';
                html += '<td>';
                html += '<input name="replaceCuttingToolCode2[0]" type="text" class="u-ipt" maxlength="45">';
                html += '</td>';
                html += '<td>';
                html += '<input name="count[0]" type="text" class="u-ipt" maxlength="45">';
                html += '</td>';
                html += '<td></td>';
                html += '</tr>';
                html += '</tbody>';
                $("#synthesisEditTable").html(html);
                if( type == "4" ){
                    $("div .aui_buttons button:first").hide();
                }else{
                    $("div .aui_buttons button:first").show();
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
                    title:'合成道具编码',
                    name:'synthesisCode'
                }
//                ,{
//                    title:'位置数',
//                    name:'synthesisCount',
//                }
                    ,{
                        title:'组成类型',
                        name:'createType',
                        format:function(r){
                            if(r.synthesisCuttingToolTypeId=='1'){
                                return '<span class="ui-grid-tdtx">复合刀</span>';
                            }else if(r.synthesisCuttingToolTypeId=='2'){
                                return '<span class="ui-grid-tdtx">热套类</span>';
                            }else if(r.synthesisCuttingToolTypeId=='3'){
                                return '<span class="ui-grid-tdtx">专机</span>';
                            }else if(r.synthesisCuttingToolTypeId=='9'){
                                return '<span class="ui-grid-tdtx">专其他</span>';
                            }
                        }
                    },
                    {
                        title:'操作列',
                        name:'-',
                        width:'130px',
                        visible:'true',
                        format:function(r,t){
                            return option(r,"OperationText");
                        }
                    }],
                success:function(d){
                    if(undefined== d.total){
                        $("#number1").text(0);
                    }else if(0== d.total){
                        $("#number1").text(1);
                    } else {
                        $("#number1").text(d.total);
                    }

                    if(d.status < 0){
                        artDialog(d.message,"OK");
                    }
                }
            }) ;
        });

        /**
         * 操作列超链接
         */
        function option(r,title){
            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            if(title=="OperationText"){
                ary_li.push($('<li><a href="javascript:void(0)">编辑</a></li>').click(function(){edit(r.synthesisParametersCode,r.synthesisParametersID,r.version,r)}));
                ary_li.push($('<li><a href="javascript:void(0)">删除</a></li>').click(function(){if(r.isDel == 0){del(r.synthesisParametersCode,r.synthesisParametersID,r.version,r.updateTime,r.updateUser,r)}}));
            }
            if(title=="ToolPicText"){
                if(r.picurl==null|| r.picurl==undefined|| r.picurl==''){

                    ary_li.push($('<li>-</li>'));
                }else {
                    ary_li.push($('<li><a href="<%= path%>/upload/b09s002/' + r.synthesisParametersID + "/" + r.picurl + '"target="_blank">下载</a></li>'));
                }


            }
            $.each(ary_li,function(i,o){
                $li.after(o);
            });
            return $ul.append($li);
        }

        /**浏览图片**/
        function showImage(r){

            var title = '${session.lang.SearchPicture}';
            $('#showImage').empty();
            if(r.toolPic==null|| r.toolPic==undefined){

                $('#showImage').append($('wu'));
            }else{

                $('#showImage').append($('<a href="downloads.action?filenames='+r.synthesisParametersID+"/"+r.toolPic+'"></a>'));
            }
            <%--$('#showImage').append($("<a herf ='<%= path%>/icomp/upload/b09s002/"+r.synthesisParametersID+"/"+r.toolPic+"'/>"));--%>
            $.dialog({
                id:'showImage_dialog',
                title:title,
                lock: true,
                content:document.getElementById('showImage'),
                button:[]
            });
            return false;
        }
        /**图片过大处理**/
        var adjustImgSize = function(img, boxWidth, boxHeight) {
            // var imgWidth=img.width();
            // var imgHeight=img.height();
            // 上面这种取得img的宽度和高度的做法有点儿bug
            // src如果由两个大小不一样的图片相互替换时，上面的写法就有问题了，换过之后的图片的宽度和高度始终取得的还是换之前图片的值。
            // 解决方法：创建一个新的图片类，并将其src属性设上。
            var tempImg = new Image();
            tempImg.src = img.attr('src');
            var imgWidth=tempImg.width;
            var imgHeight=tempImg.height;
            if(imgWidth>800||imgHeight>800){
                if((imgWidth/imgHeight)>1){
                    img.width(875);
                }else{
                    img.height(875);
                }
            }
        };

        function pageClick(page){
            $('#currentPage').val(page);
            search();
        }

        function dataHandler (data){
            data.data.forEach(function(d){
                d.synthesisCode = d.synthesisCuttingTool.synthesisCode;
                d.synthesisCuttingToolTypeId = d.synthesisCuttingTool.synthesisCuttingToolTypeId;
            })
            return data;
        }

        /**
         * 查询处理
         */
        function search(){
            var param = {
                synthesisCuttingToolVO :{
                    synthesisCode : $('#query_synthesisCode').val()
                },
                pageSize: 15,
                currentPage: $('#currentPage').val() == ""?1:$('#currentPage').val()

            };
            console.log(param);
            $.ajax({
                type: "POST",
                url:"/synthesisCuttingToolConfig/list",
                dataType:"json",
                data:JSON.stringify(param),
                error: function(XHR,textStatus,errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function(data,textStatus) {
                    console.log(data);
                    $('#list').grid('loadData',dataHandler(data));
                },
                headers: {
                    "content-type":"application/json"
                }
            });
            return false;
        }
        /**
         * 删除处理
         */
        function del(code,id,version,time,user,obj){
            $.dialog.confirm('确认删除?',function(){
                var param = {
                    id:obj.id
                }
                $.ajax({
                    type: "POST",
                    url:"/synthesisCuttingToolConfig/del",
                    dataType:"json",
                    data:JSON.stringify(param),
                    error: function(XHR,textStatus,errorThrown) {
                        artDialog(XHR.responseText, "OK");
                    },
                    success: function(data,textStatus) {
                        console.log(data);
                        search();
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
        function edit(code,id,version,obj){
            var param = {
                id:obj.id
            }
            $.ajax({
                type: "POST",
                url:"/synthesisCuttingToolConfig/searchAndLocations",
                dataType:"json",
                data:JSON.stringify(param),
                error: function(XHR,textStatus,errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function(data,textStatus) {
                    console.log(data);
                    wd_synthesisEdit(data,id,obj);
                },
                headers: {
                    "content-type":"application/json"
                }
            });
        }


        /**新建或编辑**/
        function wd_synthesisEdit(data,id,obj){
            $('#synthesisEditForm').form('reset');
            var title = '${session.lang.synthesisAddTitle}';
            $('#synthesisEditForm :input').removeClass('u-ipt-err');
            $('#synthesisEditForm').find("*").each(function () {
                if($(this).hasClass("u-sel")){
                    $(this).removeAttr("style");
                }
            });
            if(typeof(data) == 'object'){//编辑
                EdittrClumName(data) ;
//                $(synthesisEditForm.synthesisCuttingToolCode).val(data.s);//合成刀具参数ID
                $('#id').val(data.id);//组成类型
                $(synthesisEditForm.synthesisCuttingToolTypeId).val(data.synthesisCuttingToolTypeId);//组成类型
                $('#synthesisCode').val(data.synthesisCuttingTool.synthesisCode);
                $('#synthesisCode').attr("disabled","");
            }else{//新建
                //隐藏刀具位置的表头
                $('#synthesisEditTable thead').hide();
                //清空刀具位置的内容
                $("#synthesisEditTable tbody").empty();
                $("#synthesisCuttingToolTypeId").change();
                //启用合成刀具编码
                $('#synthesisCode').removeAttr("disabled");
                //初始化位置数
                $("#DivSynthesisCount").val(1);
            }

            $.dialog({
                id:'synthesisEdit_dialog',
                title:'合成刀具',
                lock: true,
                content:document.getElementById('synthesisEdit'),
                button:[{
                    name:'添加合成刀位置',
                    focus:false,
                    callback:function(){
                        AddtrClum();
                        return false;

                    }},{
                    name:'保存',
                    focus:false,
                    callback:function(){
                        initParam();
                        if (typeof(data) == 'object'){
                            upd();
                        }else{
                            add();
                        }
                        return false;
                    }
                }]
            });
            return false;
        }

        /**添加合成刀位置**/
        function AddtrClum() {
            <!-- 2017/08/22 宋健 追加↓↓↓　dazhong@YMSC -->
            var v = $("select[name='synthesisCuttingToolTypeId']").val();
            <!-- 2017/08/22 宋健 追加↑↑↑　dazhong@YMSC -->
            //显示位置的表头
            $('#synthesisEditTable thead').show();
            var a = $("#DivSynthesisCount").val();
            $("#LocationForClone tr:eq(0)").clone().appendTo("#synthesisEditTable tbody");
            if($("#synthesisEditTable tbody tr").length==1){
                $("#synthesisEditTable tbody tr:last").each(function () {
                    $(this).find("input[name='location']").attr("value",a);
                    //合成刀具位置0一定是辅具
                    $(this).find("select[name='type']").attr("name","type["+a+"]").attr("id","typeId");
                    $("#synthesisEditTable tbody tr:last").find("select[name='type["+a+"]']").find("option").each(function(){
                        //合成刀具位置0是辅具,其他是刀具
                        <!-- 2017/10/18 王冉 变更↓↓↓　dazhong@YMSC -->
                        if($(this).val()!="1" && $(this).val()!="2"){
                            $(this).remove();
                        }
                    });
                    $(this).find("p").html(a);
                    $(this).find("input[name='cuttingToolCode']").attr("name","cuttingToolCode["+a+"]");
                    $(this).find("input[name='replaceCuttingToolCode1']").attr("name","replaceCuttingToolCode1["+a+"]");
                    $(this).find("input[name='replaceCuttingToolCode2']").attr("name","replaceCuttingToolCode2["+a+"]");
                    $(this).find("input[name='count']").attr("name","count["+a+"]");
                    $(this).find("input[name='location']").attr("name","location["+a+"]");
                });
            }else{
                $("#synthesisEditTable tbody tr:last").each(function () {
                    $(this).find("input[name='location']").attr("value",a);
                    //合成刀具位置0一定是辅具
                    $(this).find("select[name='type']").attr("name","type["+a+"]");
                    $(this).find("p").html(a);
                    $(this).find("input[name='cuttingToolCode']").attr("name","cuttingToolCode["+a+"]");
                    $(this).find("input[name='replaceCuttingToolCode1']").attr("name","replaceCuttingToolCode1["+a+"]");
                    $(this).find("input[name='replaceCuttingToolCode2']").attr("name","replaceCuttingToolCode2["+a+"]");
                    $(this).find("input[name='count']").attr("name","count["+a+"]");
                    $(this).find("input[name='location']").attr("name","location["+a+"]");
                });
            }
            a++;
            $("#DivSynthesisCount").val(a);

            <!-- 2017/08/22 宋健 追加↓↓↓　dazhong@YMSC -->
            if(v == "4"){
                var html = "";
                html += '<select class="u-sel" name="type[0]" id="typeId">';
                html += '<option value="1">刀具</option>';
                html += '<option value="2">辅具</option>';
                html += '</select>';
                $("div .aui_buttons button:first").hide();
            }
            $("#typeId").html(html);

            <!-- 2017/08/22 宋健 追加↑↑↑　dazhong@YMSC -->
        }

        /**编辑-刀具位置信息初始化**/
        function EdittrClumName(data) {
            //隐藏刀具信息标题头
            $('#synthesisEditTable thead').hide();
            //清空刀具位置
            $("#synthesisEditTable tbody").empty();
            //加载刀具位置
            var SynthesisCount=0;
            $.each(data.synthesisCuttingToolLocationConfigList,function(i,location){
                $('#synthesisEditTable thead').show();
                $("#LocationForClone tr:eq(0)").clone(true).appendTo("#synthesisEditTable tbody");
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='location']").attr("value", location.location);
                $("#synthesisEditTable tbody tr:eq("+i+") th").find("p").html(location.location);
                //位置类型
                $("#synthesisEditTable tbody tr:eq("+i+")").find("select[name='type'] option[value='"+location.type+"']").attr("selected", true);
                $("#synthesisEditTable tbody tr:eq("+i+")").find("select[name='type']").attr("name","type["+i+"]").attr("id","type");
                $("#synthesisEditTable tbody tr:eq("+i+")").find("select[name='type["+i+"]']").find("option").each(function(){
                    //合成刀具位置0是辅具,其他是刀具
//                    if(i==1&&$(this).val()!="2"){
//                        $(this).remove();
//                    }else if(i>0&&$(this).val()!="0"){
//                        $(this).remove();
//                    }
                });
                //刀具编码
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='cuttingToolCode']").attr("value", location.cuttingTool.businessCode);
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='cuttingToolCode']").attr("name","cuttingToolCode["+i+"]");
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='replaceCuttingToolCode1']").attr("value", location.replaceCuttingTool1?location.replaceCuttingTool1.businessCode:'');
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='replaceCuttingToolCode1']").attr("name","replaceCuttingToolCode1["+i+"]");
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='replaceCuttingToolCode2']").attr("value", location.replaceCuttingTool2?location.replaceCuttingTool2.businessCode:''.businessCode);
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='replaceCuttingToolCode2']").attr("name","replaceCuttingToolCode2["+i+"]");
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='count']").attr("value", location.count);
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='count']").attr("name","count["+i+"]");
//                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='location']").attr("name","location["+i+"]");
                SynthesisCount++;
            });
            $("#DivSynthesisCount").val(SynthesisCount);//初始化位置数
        }

        /**文件上传js*/
        $(function(){
            $("input[type=file]").change(function(){$(this).parents(".uploader").find(".uplode-filename").val($(this).val());});
            $("input[type=file]").each(function(){
                if($(this).val()==""){$(this).parents(".uploader").find(".uplode-filename").val("No file selected...");}
            });
        });

        function initParam(){
            var LocationConfigList = [];
            var LocationConfig = {
                cuttingTool : {
                    businessCode : ''
                }
            };
            $('#synthesisEditTable tbody').find('tr').each(function(index){
                LocationConfig = {
                    cuttingTool : {
                        businessCode : ''
                    },replaceCuttingTool1 : {
                        businessCode: ''
                    },replaceCuttingTool2 : {
                        businessCode: ''
                    },count:0
                };
                LocationConfig.location = $(this).find("input[name='location["+index+"]']").val();
                LocationConfig.type = $(this).find("select[name='type["+index+"]']").val();
                LocationConfig.cuttingTool.businessCode = $(this).find("input[name='cuttingToolCode["+index+"]']").val();
                LocationConfig.replaceCuttingTool1.businessCode = $(this).find("input[name='replaceCuttingToolCode1["+index+"]']").val();
                LocationConfig.replaceCuttingTool2.businessCode = $(this).find("input[name='replaceCuttingToolCode2["+index+"]']").val();
                LocationConfig.count = $(this).find("input[name='count["+index+"]']").val();
                LocationConfigList.push(LocationConfig);
            });
            var param = {
                id:$('#id').val(),
                synthesisCuttingToolLocationConfigList : LocationConfigList,
                synthesisCuttingToolTypeId : $('#synthesisCuttingToolTypeId').val(),
                synthesisCuttingTool : {
                    synthesisCode:$('#synthesisCode').val(),
                    synthesisCuttingToolTypeId:$('#synthesisCuttingToolTypeId').val()
                },
                picUrl : $('#picUrl').val(),
                synthesisCuttingToolCode : $('#synthesisCuttingToolCode').val()
            }
            console.log(param);
            return JSON.stringify(param);
        }

        function add(){
            console.log($('#synthesisCode').val());
            $.ajax({
                type: "POST",
                url:"/synthesisCuttingToolConfig/add",
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

        function upd(){
            $.ajax({
                type: "POST",
                url:"/synthesisCuttingToolConfig/upd",
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

    </script>


</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页>首页>基础数据管理>合成刀具参数</span>
        <%@ include file="../../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            检索
        </div>
        <form id="synthesisForm" name="synthesisForm">
            <table width="100%" class="m-frmtb">
                <tr>
                    <th width="150">
                        合成道具编码
                    </th>
                    <td>
                        <input name="synthesisCuttingToolVO.synthesisCode" id="query_synthesisCode" type="text" class="u-ipt" maxlength="50">
                        <input name="currentPage" type="hidden" id="currentPage" class="u-ipt" maxlength="50">
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" onclick="return search()">
                    查询
                </button>
                <button type="button" class="u-btn2"
                        onclick="return wd_synthesisEdit()">
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

<div id="synthesisEdit" class="f-dn">

    <form id="synthesisEditForm" name="synthesisEditForm" method="post"
          enctype="multipart/form-data">
        <input name="id" id="id" type="text" class="f-dn">
        <input name="synthesisCuttingToolCode" id ="synthesisCuttingToolCode" type="text" class="f-dn">
        <input id="DivSynthesisCount" name="DivSynthesisCount" type="text" class="f-dn" value="0">

        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">
                    组成类型
                </th>
                <td>
                    <select class="u-sel" name="synthesisCuttingToolTypeId" id="synthesisCuttingToolTypeId">
                        <option value = "1">复合刀具</option>
                        <option value = "2">热套类</option>
                        <option value = "3">专机</option>
                        <option value = "9">其他</option>
                    </select>
                </td>
                <th width="150">
                    合成刀具编码
                </th>
                <td>
                    <input name="synthesisCuttingTool.synthesisCode" id="synthesisCode" type="text"
                           class="u-ipt" maxlength="50">
                </td>
            </tr>
            <%--<tr>--%>
                <%--<th width="150">--%>
                    <%--刀具图纸--%>
                <%--</th>--%>
                <%--<td>--%>
                    <%--<div class="uploader orange">--%>
                        <%--<input type="text" id="picUrl" class="uplode-filename" readonly name="picUrl"/>--%>
                        <%--<input type="button" name="file" class="uplode-button"--%>
                               <%--value="${sessionScope.lang.SelectingText}" />--%>
                        <%--<input type="file" name="upload" size="30" />--%>
                    <%--</div>--%>
                <%--</td>--%>
            <%--</tr>--%>
        </table>
        <br>
        <div style="overflow:auto; max-height:300px;">
            <table id="synthesisEditTable" class="m-frmtb" >
                <thead>
                <tr >
                    <%--<th width="120">--%>
                       <%--位置号--%>
                    <%--</th>--%>
                    <th>
                        位置类型
                    </th>
                    <th>
                        刀具编码
                    </th>
                    <th>
                        替换刀具编码1
                    </th>
                    <th>
                        替换刀具编码2
                    </th>
                    <th>
                        刀具数量
                    </th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </form>
    <table id="LocationForClone" class="f-dn">
        <tr>
            <%--<th>--%>
                <%--<input name="location" type="text" class="f-dn">--%>
                <%--<P></P>--%>
            <%--</th>--%>
            <td>
                <select class="u-sel" name="type">
                    <option value="1">刀具</option>
                    <option value="2">辅具</option>
                </select>
            </td>
            <td>
                <input name="cuttingToolCode" type="text" class="u-ipt" maxlength="45">
            </td>
            <td>
                <input name="replaceCuttingToolCode1" type="text" class="u-ipt" maxlength="45">
            </td>
            <td>
                <input name="replaceCuttingToolCode2" type="text" class="u-ipt" maxlength="45">
            </td>
            <td>
                <input name="count" type="text" class="u-ipt" maxlength="45">
            </td>
            <td>
        </tr>
    </table>
</div>
<div id="showImage" class="f-dn">
</div>
</body>
</html>

