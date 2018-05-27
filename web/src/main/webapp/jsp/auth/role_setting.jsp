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
            loadPowers();
        });

        function loadPowers(){
            var param = {positionId:$('#positionId').val()}
            $.ajax({
                type: "POST",
                url: "/power/getPowerForSetting",
                dataType: "json",
                data: JSON.stringify(param),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    console.log(data);
                    showPowerData(data.powerList);
                    $('input[name="parentCheckBox"]').bind('change',parentChange);
                    bindCurrentPower(data.powerInUse);
                },
                headers: {
                    "content-type": "application/json"
                }
            });
        }

        function showPowerData(powerList){
            var content = '';
            powerList.forEach(function(parentPower){
                content+='<tr style="background-color: #1c6a9e;"><th colspan="8"><center><font color="white">'+parentPower.enumValue+'</font></center></th></tr>';
                content+='<tr>';
                parentPower.childPowers.forEach(function(child,index){
                    content+='<tr style="background-color: #9acfea">' +
                        '<td colspan="8" ><input type="checkBox" id="'+child.id+'" name="parentCheckBox"/><span>'+child.enumValue+'</span></td></tr>';
                    content+='<tr>';
                    child.childPowers.forEach(function(power,index){
                        content+='<td><input type="checkBox" id="'+power.id+'" parentid="'+child.id+'" name="power"/></td>';
                        content+='<td><h2>'+power.enumValue+'</h2></td>';
                        if (index%3==0&&index>0){
                            content+='</tr><tr>';
                        }
                    });
                    content+='</tr>';
                    content+='<tr><td>&nbsp;</td></tr>';
                });
                content+='</tr>';
            });
            $('#list').append(content);
        }

        function parentChange(){
            if ($(this).attr('checked') == undefined){
                $('input[parentid='+$(this).attr('id')+']').removeAttr('checked');
            }
            if ($(this).attr('checked') == 'checked'){
                $('input[parentid='+$(this).attr('id')+']').attr('checked','checked');
            }
        }
        
        function bindCurrentPower(powerInUse) {
            powerInUse.forEach(function(power){
                $('#'+power.id).attr('checked','checked');
            })
        }
        
        function savePower() {
            $.ajax({
                type: "POST",
                url: "/power/bindPower",
                dataType: "json",
                data: JSON.stringify(initParam()),
                error: function (XHR, textStatus, errorThrown) {
                    artDialog(XHR.responseText, "OK");
                },
                success: function (data, textStatus) {
                    artDialog("操作成功", "OK");
                },
                headers: {
                    "content-type": "application/json"
                }
            });
        }
        
        function initParam() {
            var powerids = new Array();
            $('input[name="power"]').each(function(){
                if ($(this).attr('checked') == 'checked'){
                    powerids.push($(this).attr('id'));
                }
            });
            var param = {
                positionId : $('#positionId').val(),
                powerIds : powerids
            }
            return param;
        }

    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>用户管理模块>权限设置</span>
        <%@ include file="../../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="g-fx1 f-fr">
            <button type="button" class="u-btn2" onclick="savePower()">保存</button>
            <input type="hidden" id="positionId" value="<%=request.getParameter("positonId")%>"/>
        </div>
        <div class="f-cb"></div>

        <div class="u-ptt">
            权限设置
        </div>
    </div>
    <%--<div style="margin-top: 50px;">&nbsp;</div>--%>
    <div class="ui-layout-center">
        <table  id="list" width="100%" border="0" cellpadding="40" cellspacing="40" >

        </table>
        <div id="bar">
        </div>
    </div>
</div>
</body>
</html>

