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
                barid: '#bar',
                datatype: 'json',
                type:'post',
                width:'100%',
                fit:true,
                lazy:false,
                //async:false,
                rowno:true,
                rows:15,
                roll:6,
                pager:true,
                pagerpos:'right',
                pagercon:'first,last,number,next,prev',
                column:[{
                    title:'材料号',
                    name:'businessCode'
                },
                {
                    title:'数量',
                    name:'prepareLibraryCount'
                }
                ,{
                    title: '操作',
                    name: '-',
                    width: '130px',
                    visible: 'true',
                    format: function (r, t) {
                        return option(r);
                    }
                }
                ],
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
        function option(r){
            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            <%--ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.ToolID,'',this)}));--%>
            ary_li.push($('<li><a href="javascript:void(0)">删除</a></li>').click(function(){del(r.id,'',r.updateTime,r.updateUser,this)}));
            $.each(ary_li,function(i,o){
                $li.after(o);
            });
            return $ul.append($li);
        }


        /**
         * 删除处理
         */
        function del(id,version,time,user,obj){
            $.dialog.confirm('确认删除?',function(){
                var param = {
                    id:id
                }
                $.ajax({
                    type: "POST",
                    url:"/materialInventory/del",
                    dataType:"json",
                    data:JSON.stringify(param),
                    error: function(XHR,textStatus,errorThrown) {
                        artDialog(XHR.responseText, "OK");
                    },
                    success: function(data,textStatus,response) {
                        search();
                        artDialog('操作成功', "OK");
                    },
                    headers: {
                        "content-type":"application/json"
                    }
                });
            });
        }

        //打印项目添加
        function wd_printEdit(data,id,obj){
            $('#printEditForm').form('reset');
            var title = '新建非单品刀具初始化';
            $('#printEditForm :input').removeClass('u-ipt-err');
            $('#printEditForm').find("*").each(function () {
                if($(this).hasClass("u-sel")){
                    $(this).removeAttr("style");
                }
            });
            if(typeof(data) == 'object'){
                $(printEditForm.cuttingToolCode).val(data.cuttingToolCode);
                $(printEditForm.id).val(data.id);
                $(printEditForm.businessCode).val(data.cuttingTool.businessCode);
                $(printEditForm.prepareLibraryCount).val(data.prepareLibraryCount);
                //编辑
                $('#printEditForm').attr('action','printItemEdit.action');
                <%--title = '${session.lang.printEditText}';--%>
            }else{
                //添加

                $('#printEditForm').attr('action','sferAdd.action');

            }
            $.dialog({
                id:'printEdit_dialog',
                title:'非单品刀具初始化',
                lock: true,
                content:document.getElementById('printEdit'),
                button:[{
                    name:'保存',
                    focus:true,
                    callback:function(){
                        if (typeof(data) == 'object'){
                            edit();
                        }else{
                            add();
                        }
                        $.dialog.list['printEdit_dialog'].close();
                        return false;
                    }
                }]
            });
            return false;
        }

        function add(){
            $.ajax({
                type: "POST",
                url:"/materialInventory/add",
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

        function edit(){
            $.ajax({
                type: "POST",
                url:"/materialInventory/upd",
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

        function search(){
            var param = {
                cuttingToolVO : {
//                    businessCode : $(printEditForm.businessCode).val(),
                    likeBusinessCode : $(printForm.likeBusinessCode).val(),
                },
                pageSize: 15,
                currentPage: $(printForm.currentPage).val() == ""?1:$(printForm.currentPage).val()

            };
            console.log(param);
            $.ajax({
                type: "POST",
                url:"/materialInventory/list",
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

        function dataHandler(data){
            data.data.forEach(function(d){
                d.businessCode = d.cuttingTool.businessCode;
            })
            return data;
        }

        function initParam(){
            var param = {
                cuttingTool :{
                    businessCode:$(printEditForm.businessCode).val(),
                },
                cuttingToolCode : $(printEditForm.cuttingToolCode).val(),
                prepareLibraryCount: $(printEditForm.prepareLibraryCount).val(),
                id: $(printEditForm.id).val()
            }
            return JSON.stringify(param);
        }

        function pageClick(page){
            $(printForm.currentPage).val(page);
            search();
        }

    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页>首页>基础数据管理>非单品刀具初始化</span>
        <%@ include file="../../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            检索
        </div>
        <form id="printForm" name="printForm" method="post">

            <input type="text" class="f-dn" name="containerCarrierID" />
            <input type="text" class="f-dn" name="containRfid" />
            <input type="text" class="f-dn" name="currentPage" />
            <table width="100%" class="m-frmtb">
                <tr>
                    <th width="150">
                        材料号
                    </th>

                    <td>
                        <input name="likeBusinessCode" type="text" class="u-ipt" maxlength="36" onkeyup="this.value=this.value.toUpperCase()">
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" onclick="search()" id="submits">查询</button>
                <button type="button" class="u-btn2" onclick="return wd_printEdit()" >新建</button>
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
<div id="printEdit" class="f-dn">
    <form id="printEditForm" name="printEditForm" method="post">
        <input type="text" class="f-dn" name="cuttingToolCode"/>
        <input type="text" class="f-dn" name="id" />
        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">材料号</th>
                <td>
                    <input name="businessCode" type="text" class="u-ipt" maxlength="50" onkeyup="this.value=this.value.toUpperCase()">

                </td>
                <th width="150">数量</th>
                <td>
                    <input name="prepareLibraryCount" type="text" class="u-ipt" maxlength="8">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

