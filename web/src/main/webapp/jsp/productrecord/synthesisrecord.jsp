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
                        title:'合成刀编码',
                        name:'synthesisCode'
                    },
                    {
                        title:'流水线',
                        name:'assemblylineName'
                    },
                    {
                        title:'工序',
                        name:'processName'
                    },
                    {
                        title:'设备名称',
                        name:'equipmentName'
                    },
                    {
                        title:'轴名称',
                        name:'axleName'
                    },
                    {
                        title:'零件',
                        name:'partsName'
                    },
                    {
                        title:'额定数量',
                        name:'ratedNumber'
                    },
                    {
                        title:'加工数量',
                        name:'processingCount'
                    }

                ],
                success:function(d){
                    if(d.status < 0){
                        artDialog(d.message,"OK");
                    }
                }
            }) ;

        });

        function numberformat(num){
            if (num == '' || num == null){
                return 0;
            }
            return num;
        }

        /**
         * 查询处理
         */
        function search(){
            var param = {
                synthesisCode : $('#query_synthesisCode').val(),
                businessCode : $('#query_businessCode').val(),
                assemblylineName : $('#query_assemblylineName').val(),
                processName : $('#query_processName').val(),
                equipmentName : $('#query_equipmentName').val(),
                axleName : $('#query_axleName').val(),
                partsName : $('#query_partsName').val(),
                pageSize:15,
                currentPage : $('#currentPage').val()==""?1:$('#currentPage').val()
            }
            console.log(param);
            $.ajax({
                type: "POST",
                url: "/synthesisCuttingToolProductionRecords/list",
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





        function pageClick(page){
            $('#currentPage').val(page);
            search();
        }

    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>用户管理模块> 厂外刃磨记录</span>
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
                        材料号
                    </th>
                    <td>
                        <input type="text" id="query_businessCode" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        合成刀编码
                    </th>
                    <td>
                        <input type="text" id="query_synthesisCode" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        流水线
                    </th>
                    <td>
                        <input type="text" id="query_assemblylineName" class="u-ipt" maxlength="50">
                    </td>
                </tr>
                <tr>
                    <th width="150">
                        工序
                    </th>
                    <td>
                        <input type="text" id="query_processName" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        设备
                    </th>
                    <td>
                        <input type="text" id="query_equipmentName" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        轴
                    </th>
                    <td>
                        <input type="text" id="query_axleName" class="u-ipt" maxlength="50">
                    </td>
                </tr>
                <tr>
                    <th width="150">
                        零件
                    </th>
                    <td>
                        <input type="text" id="query_partsName" class="u-ipt" maxlength="50">
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

