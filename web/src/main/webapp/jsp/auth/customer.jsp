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
                    title:'真实姓名',
                    name:'name'
                },
                    {
                        title:'员工卡号',
                        name:'employeeCode'
                    },
                    {
                        title:'职务',
                        name:'authPositionName'
                    },
                    {
                        title:'部门',
                        name:'authDepartmentName'
                    },
                    {
                        title:'机构',
                        name:'authAgencyName'
                    },
                    {
                        title:'用户类型',
                        name:'type',
                        format: function (r) {
                            // 1 系统用户 2 普通用户
                            if (r.type == 1) {
                                return '<span class="ui-grid-tdtx">系统用户</span>';
                            }
                            else if (r.type == 2) {
                                return '<span class="ui-grid-tdtx">普通用户</span>';
                            }
                            return '<span class="ui-grid-tdtx"></span>';
                        }
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
                    var html = '<option value="">请选择</option>';
                    data.data.forEach(function(data){
                        html+=' <option value="'+data.id+'">'+data.name+'</option>';
                    });
                    $('#agencyCode').html(html);
                    $('#query_agencyCode').html(html);

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
                authAgencyCode:$('#query_agencyCode').val(),
                authDepartmentCode:$('#query_departmentCode').val(),
                authPositionCode:$('#query_positionId').val(),
                type:$('#query_type').val(),
                employeeCode:$('#query_employeeCode').val(),
                pageSize:15,
                currentPage : $('#currentPage').val()==""?1:$('#currentPage').val()
            }
            console.log(param);
            $.ajax({
                type: "POST",
                url: "/authCustomer/list",
                dataType: "json",
                data: JSON.stringify(param),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    console.log(data);
                    data.data.forEach(function(d){
                        d.authPositionName = d.authPosition.name;
                        d.authDepartmentName = d.authDepartment.name;
                        d.authAgencyName = d.authAgency.name;
                    });
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
                    url:"/authDepartment/del",
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
                account:$('#account').val(),
                password:$('#password').val(),
                authAgencyCode:$('#agencyCode').val(),
                authDepartmentCode:$('#departmentCode').val(),
                authPositionCode:$('#positionId').val(),
                type:$('#type').val(),
                employeeCode:$('#employeeCode').val(),
                name:$('#name').val()
            }
            $.ajax({
                type: "POST",
                url:"/authCustomer/upd",
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
                account:$('#account').val(),
                password:$('#password').val(),
                authAgencyCode:$('#agencyCode').val(),
                authDepartmentCode:$('#departmentCode').val(),
                authPositionCode:$('#positionId').val(),
                type:$('#type').val(),
                employeeCode:$('#employeeCode').val(),
                name:$('#name').val()
            }
            $.ajax({
                type: "POST",
                url:"/authCustomer/add",
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
                $('#account').val(data.account);                              //partsID
                $('#password').val(data.password);                              //partsID
                $('#agencyCode').val(data.authAgencyCode);
                $('#departmentCode').append(' <option selected value="'+data.authDepartment.id+'">'+data.authDepartment.name+'</option>');
                $('#positionId').append(' <option selected value="'+data.authPosition.id+'">'+data.authPosition.name+'</option>');
                $('#type').val(data.type);
                $('#employeeCode').val(data.employeeCode);
                $('#name').val(data.name);
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

        function queryAgencyCodeChange(){
            var param = {
                authAgencyId:$('#query_agencyCode').val()
            }
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
                    $('#query_departmentCode').html('<option value="">请选择</option>');
                    data.data.forEach(function(data){
                        html+=' <option value="'+data.id+'">'+data.name+'</option>';
                    });
                    $('#query_departmentCode').append(html);

                },
                headers: {
                    "content-type": "application/json"
                }
            });

        }
        function queryDepartmentCodeChange(){
            var param = {
                authDepartmentCode1:$('#query_departmentCode').val()
            }
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
                    var html = '';
                    $('#query_positionId').html('<option value="">请选择</option>');
                    data.data.forEach(function(data){
                        html+=' <option value="'+data.id+'">'+data.name+'</option>';
                    });
                    $('#query_positionId').append(html);

                },
                headers: {
                    "content-type": "application/json"
                }
            });

        }
        function agencyCodeChange(){
            var param = {
                authAgencyId:$('#agencyCode').val()
            }
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
                    $('#departmentCode').html('<option value="">请选择</option>');
                    data.data.forEach(function(data){
                        html+=' <option value="'+data.id+'">'+data.name+'</option>';
                    });
                    $('#departmentCode').append(html);

                },
                headers: {
                    "content-type": "application/json"
                }
            });
        }

        function departmentCodeChange(){
            var param = {
                authDepartmentCode1:$('#departmentCode').val()
            }
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
                    var html = '';
                    $('#positionId').html('<option value="">请选择</option>');
                    data.data.forEach(function(data){
                        html+=' <option value="'+data.id+'">'+data.name+'</option>';
                    });
                    $('#positionId').append(html);

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
        <span>用户管理模块> 用户管理</span>
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
                        员工号
                    </th>
                    <td>
                        <input id="query_employeeCode" type="text" class="u-ipt" maxlength="50">
                        <input name="currentPage" id="currentPage" type="hidden" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        用户类型
                    </th>
                    <td>
                        <select id="query_type" class="u-sel hidder" maxlength="2">
                            <option value="">请选择</option>
                            <option value="1">系统用户</option>
                            <option value="2">普通用户</option>
                        </select>
                    </td>
                    <th width="150">
                        机构
                    </th>
                    <td>
                        <select id="query_agencyCode" onchange="queryAgencyCodeChange()" class="u-sel hidder" maxlength="2">
                            <option value="">请选择</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th width="150">
                        部门
                    </th>
                    <td>
                        <select id="query_departmentCode" onchange="queryDepartmentCodeChange()" class="u-sel hidder" maxlength="2">
                            <option value="">请选择</option>
                        </select>
                    </td>
                    <th width="150">
                        职务
                    </th>
                    <td>
                        <select id="query_positionId" class="u-sel hidder" maxlength="2">
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
                    账号
                </th>
                <td>
                    <input id="account" type="text" class="u-ipt" maxlength="50">
                </td>
                <th width="150">
                    密码
                </th>
                <td>
                    <input id="password" type="password" class="u-ipt" maxlength="50">
                </td>
            </tr>
            <tr>
                <th width="150">
                    机构
                </th>
                <td>
                    <select name="agencyCode" id="agencyCode" onchange="agencyCodeChange()" class="u-sel hidder" maxlength="2">
                        <option value="">请选择</option>
                    </select>
                </td>
                <th width="150">
                    部门名称
                </th>
                <td>
                    <select name="departmentCode" id="departmentCode" onchange="departmentCodeChange()" class="u-sel hidder" maxlength="2">
                        <option value="">请选择</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th width="150">
                    职务
                </th>
                <td>
                    <select name="positionId" id="positionId" class="u-sel hidder" maxlength="2">
                        <option value="">请选择</option>
                    </select>
                </td>
                <th width="150">
                    用户类型
                </th>
                <td>
                    <select id="type" class="u-sel hidder" maxlength="2">
                        <option value="">请选择</option>
                        <option value="1">系统用户</option>
                        <option value="2">普通用户</option>
                    </select>
                </td>
            </tr>

            <tr>
                <th width="150">
                    员工卡
                </th>
                <td>
                    <input name="employeeCode" id="employeeCode" type="text" class="u-ipt" maxlength="50">
                </td>
                <th width="150">
                    真实姓名
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

