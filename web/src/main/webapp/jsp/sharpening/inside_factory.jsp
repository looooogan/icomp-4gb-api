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
                        name:'materialNum'
                    },
                    {
                        title:'刃磨时间',
                        name:'prepareLibraryCount',
                        format : function(r){
                            return '<span class="ui-grid-tdtx">'+numberformat(r.prepareLibraryCount)+'</span>';
                        }
                    },
                    {
                        title:'刃磨数量',
                        name:'numberGrinding',
                        format : function(r){
                            return '<span class="ui-grid-tdtx">'+numberformat(r.productLineCount)+'</span>';
                        }
                    },
                    {
                        title:'刃磨设备',
                        name:'productLineEquipment',
                        format : function(r){
                            return '<span class="ui-grid-tdtx">'+numberformat(r.toUninstallCount)+'</span>';
                        }
                    },
                    {
                        title:'操作人',
                        name:'opratorName',
                        format : function(r){
                            return '<span class="ui-grid-tdtx">'+numberformat(r.forGrindingInCount)+'</span>';
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
                cuttingToolVO : {
                    businessCode : $('#query_businessCode').val()
                },
                pageSize:15,
                currentPage : $('#currentPage').val()==""?1:$('#currentPage').val()
            }
            console.log(param);
            $.ajax({
                type: "POST",
                url: "/insideFactory/list",
                dataType: "json",
                data: JSON.stringify(param),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    console.log(data);
                    data.data.forEach(function(d){
                        d.businessCode = d.cuttingTool.businessCode;
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
        <span>用户管理模块> 厂内刃磨记录</span>
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

