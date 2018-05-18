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
                    title:'职务名称',
                    name:'name'
                },
                    {
                        title:'部门名称',
                        name:'departName'
                    },
                    {
                        title:'操作',
                        name:'',
                        width:'130px',
                        visible:'true',
                        format:function(r){
                            return option(r);
                        }
                    }],
                success:function(d){
                    if(d.status < 0){
                        artDialog(d.message,"OK");
                    }
                }
            }) ;
            initData();

        });

        function initData(){
            $.ajax({
                type: "POST",
                url:"/authAgency/list",
                dataType:"json",
                data:JSON.stringify({}),
                error: function(XHR,textStatus,errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function(data,textStatus,response) {
                    console.log(data);
                    var html = '';
                    data.data.forEach(function(data){
                        html+=' <option value="'+data.id+'">'+data.name+'</option>';
                    });
                    $('#authAgency_select').append(html);
                    $('#pop_authAgency').append(html);

                },
                headers: {
                    "content-type":"application/json"
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
                authDepartmentCode1:$('#department_select').val(),
                pageSize:15,
                currentPage : $('#currentPage').val()==""?1:$('#currentPage').val()
            }
            console.log(param);
            $.ajax({
                type: "POST",
                url: "/authPosition/list",
                dataType: "json",
                data: JSON.stringify(param),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    console.log(data);
                    data.data.forEach(function(d){
                        d.departName = d.authDepartment.name;
                    })
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
                    url:"/authPosition/del",
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
                authDepartmentCode1:$('#pop_department').val(),
                name:$('#pop_name').val()
            }
            $.ajax({
                type: "POST",
                url:"/authPosition/upd",
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
                authDepartmentCode1:$('#pop_department').val(),
                name:$('#pop_name').val()
            }
            $.ajax({
                type: "POST",
                url:"/authPosition/add",
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

        function wd_parts(data){
            console.log(data);
            $('#partsEditForm').form('reset');
            $('#partsEditForm :input').removeClass('u-ipt-err');
            $('#partsEditForm').find("*").each(function () {
                if($(this).hasClass("u-sel")){
                    $(this).removeAttr("style");
                }
            });

            if(typeof(data) == 'object'){
                // 页面赋值
                console.log(data);
                $('#id').val(data.id);                              //partsID
                $('#pop_authAgency').val(data.authDepartment.authAgencyCode);
                $('#pop_department').append(' <option selected value="'+data.authDepartment.id+'">'+data.authDepartment.name+'</option>');
//                $('#pop_department').val(data.authDepartment.authDepartmentCode1);
                $('#pop_name').val(data.name);
            }
            $.dialog({
                id:'partsEdit_dialog',
                title:'部门',
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

        function authAgencySelectChange(){
            var param = {
                authAgencyId:$('#authAgency_select').val()
            }
            console.log(param);
            $.ajax({
                type: "POST",
                url: "/authDepartment/list",
                dataType: "json",
                data: JSON.stringify(param),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    var html = '';
                    $('#department_select').html('<option value="">请选择</option>');
                    data.data.forEach(function(data){
                        html+=' <option value="'+data.id+'">'+data.name+'</option>';
                    });
                    $('#department_select').append(html);
                },
                headers: {
                    "content-type": "application/json"
                }
            });
        }

        function authAgencyChange(){
            var param = {
                authAgencyId:$('#pop_authAgency').val()
            }
            console.log(param);
            $.ajax({
                type: "POST",
                url: "/authDepartment/list",
                dataType: "json",
                data: JSON.stringify(param),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    console.log(data);
                    var html = '';
                    $('#pop_department').html('<option value="">请选择</option>');
                    data.data.forEach(function(data){
                        html+=' <option value="'+data.id+'">'+data.name+'</option>';
                    });
                    $('#pop_department').append(html);

                },
                headers: {
                    "content-type": "application/json"
                }
            });
        }
    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>用户管理模块> 部门管理</span>
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
                        机构
                    </th>
                    <td>
                        <select name="type" id="authAgency_select" onchange="authAgencySelectChange()" class="u-sel hidder" maxlength="2">
                            <option value="">请选择</option>
                        </select>
                        <input name="currentPage" id="currentPage" type="hidden" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        部门
                    </th>
                    <td>
                        <select name="type" id="department_select" class="u-sel hidder" maxlength="2">
                            <option value="">请选择</option>
                        </select>
                    </td>
                </tr>
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
                    机构
                </th>
                <td>
                    <select name="type" id="pop_authAgency" onchange="authAgencyChange()" class="u-sel hidder" maxlength="2">
                        <option value="">请选择</option>
                    </select>
                </td>
                <th width="150">
                    部门名称
                </th>
                <td>
                    <select name="type" id="pop_department"  class="u-sel hidder" maxlength="2">
                        <option value="">请选择</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th width="150">
                    职务名称
                </th>
                <td>
                    <input name="name" id="pop_name" type="text" class="u-ipt" maxlength="50">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

