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
                column:[
                    {
                        title:'材料号',
                        name:'cuttingToolBusinessCode'
                    },
                    {
                        title:'出库单号',
                        name:'applyNo'
                    },
                    {
                        title:'出库数量',
                        name:'unitqty'
                    },
                    {
                        title:'物料号',
                        name:'mtlCode'
                    },
                    {
                        title:'刀具号',
                        name:'loc'
                    },
                    {
                        title:'工序',
                        name:'productlineProcess'
                    },
                    {
                        title:'流水线',
                        name:'productlineAssemblyline'
                    },
                    {
                        title:'工厂',
                        name:'plant'
                    },
                    {
                        title:'出库时间',
                        name:'createTime',
                        format : function (r) {
                            var newDate = new Date();
                            newDate.setTime(r.createTime);
                            return '<span class="ui-grid-tdtx">'+newDate.toLocaleDateString()+'</span>';
                        }
                    },
                    {
                        title:'库管员姓名',
                        name:'kuguanOperatorName'
                    },
                    {
                        title:'领料员姓名',
                        name:'linglOperatorName'
                    },
                    {
                        title:'科长签字',
                        name:'kezhangCode',
                        format : function (d) {
                            if (d.kezhangCode!=''){
                                return '<span class="ui-grid-tdtx">已签字</span>';
                            }else {
                                return '<span class="ui-grid-tdtx">未签字</span>';
                            }
                        }
                    }
                    ],
                success:function(d){
                    if(d.status < 0){
                        artDialog(d.message,"OK");
                    }
                }
            }) ;

        });

        /**
         * 查询处理
         */
        function search(){
            var param = {
                applyNo : $('#query_applyNo').val(),
                mtlCode : $('#query_mtlCode').val(),
                loc : $('#query_loc').val(),
                productlineProcess : $('#query_productlineProcess').val(),
                productlineAssemblyline : $('#query_productlineAssemblyline').val(),
                plant : $('#query_plant').val(),
                cuttingToolVO : {
                    businessCode : $('#query_businessCode').val()
                },
                pageSize:15,
                currentPage : $('#currentPage').val()==""?1:$('#currentPage').val()
            }
            console.log(param);
            $.ajax({
                type: "POST",
                url: "/outPrepareLibrary/list",
                dataType: "json",
                data: JSON.stringify(param),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    console.log(data);
                    data.data.forEach(function(d){
                        d.cuttingToolBusinessCode = d.cuttingTool.businessCode;
                    })
                    $('#list').grid('loadData', data);
                },
                headers: {
                    "content-type": "application/json"
                }
            });
        }





        function pageClick(page){
            $('#currentPage').val(page);
            search();
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
                        出库单号
                    </th>
                    <td>
                        <input type="text" id="query_applyNo" class="u-ipt" maxlength="50">
                        <input name="currentPage" id="currentPage" type="hidden" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        物料号
                    </th>
                    <td>
                        <input type="text" id="query_mtlCode" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        刀具号
                    </th>
                    <td>
                        <input type="text" id="query_loc" class="u-ipt" maxlength="50">
                    </td>
                </tr>
                <tr>
                    <th width="150">
                        工序
                    </th>
                    <td>
                        <input type="text" id="query_productlineProcess" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        流水线
                    </th>
                    <td>
                        <input type="text" id="query_productlineAssemblyline" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        工厂
                    </th>
                    <td>
                        <input type="text" id="query_plant" class="u-ipt" maxlength="50">
                    </td>
                </tr>
                <tr>
                    <th width="150">
                        材料号
                    </th>
                    <td>
                        <input type="text" id="query_businessCode" class="u-ipt" maxlength="50">
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" onclick="return search()">
                    查询
                </button>
                <%--<button type="button" class="u-btn2" onclick="return wd_parts()">--%>
                <%--新建--%>
                <%--</button>--%>
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
</body>
</html>

