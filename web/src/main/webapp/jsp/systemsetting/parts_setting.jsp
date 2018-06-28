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
                    title:'零部件名称',
                    name:'name'
                }
                ,{
                    title:'零部件编码',
                    name:'code'
                }
                ,{
                    title:'操作',
                    name:'',
                    width:'130px',
                    visible:'true',
                    format:function(r,t){
                        return option(r);
                    }
                }],
                success:function(d){
                    if(d.status < 0){
                        artDialog(d.message,"OK");
                    }
                }
            }) ;
        });

        /**
         * 操作列超链接
         */
        function option(r){
            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            ary_li.push($('<li><a href="javascript:void(0)">编辑</a></li>').click(function(){wd_parts(r)}));
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
                url: "/productLineParts/list",
                dataType: "json",
                data: JSON.stringify(param),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    console.log(data);
                    $('#list').grid('loadData', data);
                },
                headers: {
                    "content-type": "application/json"
                }
            });
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
                    url:"/productLineParts/del",
                    dataType:"json",
                    data:JSON.stringify(param),
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
                url:"/productLineParts/upd",
                dataType:"json",
                data:JSON.stringify(param),
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

        function add(){
            var param = {
                name:$('#name').val(),
                code:$('#code').val()
            }
            $.ajax({
                type: "POST",
                url:"/productLineParts/add",
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

        //添加零部件
        function wd_parts(data){
            $('#partsEditForm').form('reset');
            $('#partsEditForm :input').removeClass('u-ipt-err');
            $('#partsEditForm').find("*").each(function () {
                if($(this).hasClass("u-sel")){
                    $(this).removeAttr("style");
                }
            });

            if(typeof(data) == 'object'){
                // 页面赋值
                $('#id').val(data.id);                              //partsID
                $('#name').val(data.name);                              //partsID
                $('#code').val(data.code);                              //partsID
            }
            $.dialog({
                id:'partsEdit_dialog',
                title:'零部件',
                lock: true,
                content:document.getElementById('partsEdit'),
                button:[{
                    name:'保存',
                    focus:true,
                    callback:function(){
                        if(typeof(data) == 'object'){
                            edit();
                        }else {
                            add();
                        }
                        $.dialog.list['partsEdit_dialog'].close();

                    }
                }]
            });
            return false;
        }
    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>系统配置> 零部件配置</span>
        <%@ include file="../../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            检索
        </div>
        <form id="partsForm" name="partsForm" method="post">
            <table width="100%" class="m-frmtb">
                <tr>
                    <th width="150">
                        零部件名称
                    </th>
                    <td>
                        <input name="query_name" id="query_name" type="text" class="u-ipt" maxlength="50">
                        <input name="currentPage" id="currentPage" type="hidden" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        零部件编码
                    </th>
                    <td>
                        <input name="query_code" id="query_code" type="text" class="u-ipt" maxlength="50">
                    </td>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" onclick="return search()">
                    查询
                </button>
                <button type="button" class="u-btn2" onclick="return wd_parts()">
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
<div id="partsEdit" class="f-dn">
    <form id="partsEditForm" name="partsEditForm" method="post">
        <input type="text" class="f-dn" name="id" id="id" />
        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">
                    零部件编码
                </th>
                <td>
                    <input name="code" id="code" type="text" class="u-ipt" maxlength="50">
                </td>
                <th width="150">
                    零部件名称
                </th>
                <td>
                    <input name="name" id="name" type="text" class="u-ipt" maxlength="50">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

