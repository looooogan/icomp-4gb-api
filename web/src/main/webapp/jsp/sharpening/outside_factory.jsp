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
                        title:'外委单号',
                        name:'orderNum'
                    },
                    {
                        title:'资材单号',
                        name:'zcCode'
                    },
                    {
                        title:'刃磨数量',
                        name:'numberGrinding'
                    },
                    {
                        title:'外委商',
                        name:'qmSharpenProviderName'
                    },
                    {
                        title:'外委方式',
                        name:'outWay'
                    },
                    {
                        title:'出厂日期',
                        name:'manufactureDate',
                        format : function(r){
                            return '<span class="ui-grid-tdtx">'+fmtDate(r.manufactureDate)+'</span>';
                        }
                    },
                    {
                        title:'经手人',
                        name:'handlers'
                    },
                    {
                        title:'邮寄人',
                        name:'sender'
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
                orderNum : $('#query_orderNum').val(),
                zcCode : $('#query_zcCode').val(),
                cuttingToolVO : {
                    businessCode : $('#query_businessCode').val()
                },
                pageSize:15,
                currentPage : $('#currentPage').val()==""?1:$('#currentPage').val()
            }
            console.log(param);
            $.ajax({
                type: "POST",
                url: "/outsideFactory/list",
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



        function fmtDate(obj){
            var date =  new Date(obj);
            var y = 1900+date.getYear();
            var m = "0"+(date.getMonth()+1);
            var d = "0"+date.getDate();
            return y+"-"+m.substring(m.length-2,m.length)+"-"+d.substring(d.length-2,d.length);
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
                        外委单号
                    </th>
                    <td>
                        <input type="text" id="query_orderNum" class="u-ipt" maxlength="50">
                    </td>
                    <th width="150">
                        资材单号
                    </th>
                    <td>
                        <input type="text" id="query_zcCode" class="u-ipt" maxlength="50">
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

