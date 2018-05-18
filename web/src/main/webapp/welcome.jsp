<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%@ include file="common/header_common.jsp" %>
    <script type="text/javascript">

        $(function () {
            jQuery('body').layout({
                center__childOptions: {
                    north__resizable: false,
                    spacing_open: 0
                },
                north: {
                    size: 'auto',
                    spacing_open: 0,
                    closable: false,
                    resizable: false
                }
            });

            $('#list').grid({
                barid: '#bar',
                datatype: 'json',
                type: 'post',
                width: '100%',
                fit: true,
                lazy: false,
                rowno: true,
                rows:${session.rowsize},
                roll: 3,
                pager: true,
                pagerpos: 'right',
                pagercon: 'first,last,number,next,prev',
                column: [{
                    title: '${session.lang.ComListTypeText}',
                    name: '',
                    format: function (r) {
                        <%--if (r.toolAlarmType == "0") {//库存异常报警--%>
                            <%--return '<span class="ui-grid-tdtx"style="color:red">${session.lang.InventoryAlarmText}</span>';--%>
                        <%--} else if (r.toolAlarmType == "1") {//在途异常报警--%>
                            <%--return '<span class="ui-grid-tdtx"style="color:red">${session.lang.TransitPlanningAlarmText}</span>';--%>
//                        } else if (r.toolAlarmType == "2") {//加工量异常报警
                            return '<span class="ui-grid-tdtx"style="color:red">${session.lang.AbnormalAlarmText}</span>';
//                        }
                    }
                }, {
                    title: '${session.lang.StatusText}',
                    name: '',
                    format: function (r) {
                        return '<span class="ui-grid-tdtx"style="color:red">${session.lang.AlarmAmountText}:' + r.toolAlarmParam + '</span>';
                    }
                }],
                success: function (d) {
                    if (d.status < 0) {
                    }
                }
            });
            var param = {
                opt: 'list',
            };
            $('#list').grid('url', 'init.action');
            $('#list').grid('data', param);
            $('#list').grid('load', 1);

        });
        //管理平台说明文档
        function openHtmlWeb() {
            window.open('<%= baseUrl%>helpFile/htmlWeb/index.html', 'newwindow', '');
        }

        //手持机说明文档
        function openHtmlAndroid() {
            window.open('<%= baseUrl%>helpFile/android/index.html', 'newwindow', '');
        }
    </script>
</head>
<body>
<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">

        <a href="javascript:void(0)" target="center" onclick="openHtmlWeb()">管理平台说明文档</a> |
        <a href="javascript:void(0)" target="center" onclick="openHtmlAndroid()">手持机说明文档</a> |

        <%@ include file="head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptt">
            ${sessionScope.lang.searchList}
        </div>
    </div>
    <div class="ui-layout-center">
        <table id="list"></table>
        <div id="bar"></div>
    </div>
</div>
</body>
</html>
