<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String baseUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<link type="text/css" rel="stylesheet" href="<%= path%>/style/zh_CNstyles.css">
<link type="text/css" rel="stylesheet" href="<%= path%>/script/ui/themes/base/jquery.ui.core.css">
<link type="text/css" rel="stylesheet" href="<%= path%>/script/ui/themes/base/jquery.ui.theme.css">
<link type="text/css" rel="stylesheet" href="<%= path%>/script/grid/ui.grid.css">
<link type="text/css" rel="stylesheet" href="<%= path%>/script/tree/css/tree.css">
<link type="text/css" rel="stylesheet" href="<%= path%>/script/jqSelect/css/shou.css">


<script type="text/javascript" src="<%= path%>/script/jquery.js"></script>
<script type="text/javascript" src="<%= path%>/script/ui/jquery-ui-latest.js"></script>
<script type="text/javascript" src="<%= path%>/script/layout/jquery.layout.js"></script>
<script type="text/javascript" src="<%= path%>/script/raphael/raphael-min.js"></script>
<script type="text/javascript" src="<%= path%>/script/upload/swfobject.js"></script>
<script type="text/javascript" src="<%= path%>/script/upload/swfupload.js"></script>
<script type="text/javascript" src="<%= path%>/script/form/jquery.form.js"></script>
<script type="text/javascript" src="<%= path%>/script/form/jquery.tojson.js"></script>
<script type="text/javascript" src="<%= path%>/script/form/json2form.js"></script>
<script type="text/javascript" src="<%= path%>/script/dialog/jquery.artDialog.source.js?skin=black"></script>
<script type="text/javascript" src="<%= path%>/script/dialog/iframeTools.source.js"></script>
<script type="text/javascript" src="<%= path%>/script/tree/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript" src="<%= path%>/script/tree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%= path%>/script/tree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="<%= path%>/script/grid/jquery.grid.js"></script>
<script type="text/javascript" src="<%= path%>/script/datepicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%= path%>/script/datepicker/YMDClass.js"></script>

<script type="text/javascript" src="<%= path%>/script/jqSelect/js/jQSelect.js"></script>

<script type="text/javascript">


    $(".u-ipt").live("blur",function(){
        this.value=this.value.replace(/^ +| +$/g,'').trim();
    });

    $("input[name=dend],input[name=dstar]").live("blur focus",function(){
        $("input[name=dend]").next("span").remove();
        var dend=$("input[name=dend]").val();
        var dstar=$("input[name=dstar]").val();
        if(dstar.length>0&&dend.length>0){
            dend=dend.replace(/[-]/g,"");
            dstar=dstar.replace(/[-]/g,"");
            if(dstar*1>dend*1){
                $("input[name=dend]").after('<span style="color: red" class="ErroSpan" >${session.lang.E677}</span>')
            }
        }
    });

</script>