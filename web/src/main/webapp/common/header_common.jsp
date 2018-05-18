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

    //133,33.20
    function fmoney(s, n){
        var rtn ='';
        s=s+"";
        if(s==null||s==''||isNaN(s)){
            return '';
        }
        n = n > 0 && n <= 20 ? n : 2;
        s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
        var l = s.split(".")[0].split("").reverse(),
                r = s.split(".")[1];
        t = "";
        for(i = 0; i < l.length; i ++ ){
            t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
        }
        rtn=t.split("").reverse().join("") + "." + r;
        return rtn;
    }
    //19900120 to 1990-01-20
    function fdate3(s) {
        if(s==null||s==''){
            return '';
        }
        var r=s.substring(0,4);
        r+='-';
        r+=s.substring(4,6);
        r+='-';
        r+=s.substring(6,8);
        return r;
    }
    //1990${session.lang.Year}01${session.lang.Month1}01${session.lang.Day}
    function fdate1(s,n) {
        if(s==null||s==''){
            return '';
        }
        var r=s.substring(0,4);
        r+='${session.lang.Year}';
        r+=s.substring(5,7)*1;
        r+='${session.lang.Month1}';
        r+=s.substring(8,10)*1;
        r+='${session.lang.Day}';
        return r;
    }
    <!-- 2017/09/15 宋健 追加↓↓↓　dazhong@YMSC -->
    function fdate5(s,n) {
        if(s==null||s==''){
            return '';
        }
        var r=s.substring(0,4);
        r+='-';
        r+=s.substring(5,7)*1;
        r+='-';
        r+=s.substring(8,10)*1;
        return r;
    }
    <!-- 2017/09/15 宋健 追加↑↑↑　dazhong@YMSC -->
    //1990${session.lang.Year}01${session.lang.Month1}01${session.lang.Day}09:30
    function fdate(s) {
        if(s==null||s==''){
            return '';
        }
        var r=s.substring(0,4);
        r+='${session.lang.Year}';
        r+=s.substring(5,7)*1;
        r+='${session.lang.Month1}';
        r+=s.substring(8,10)*1;
        r+='${session.lang.Day}';
        r+=" ";
        r+=s.substring(11,16);
        return r;
    }
    //2015年7月9日 15:32:09
    function fdate4(s) {
        if(s==null||s==''){
            return '';
        }
        var r=s.substring(0,4);
        r+='${session.lang.Year}';
        r+=s.substring(5,7)*1;
        r+='${session.lang.Month1}';
        r+=s.substring(8,10)*1;
        r+='${session.lang.Day}';
        r+=" ";
        r+=s.substring(11,19);
        return r;
    }

    //19900101
    function fdate2(s) {
        if(s==null||s==''){
            return '';
        }
        var r="";
        if(s.indexOf('${session.lang.Year}')<0){
            r=s.substring(0,4);
            r+=s.substring(5,7);
            r+=s.substring(8,10);
        }else{
            r=s.substring(0,s.indexOf('${session.lang.Year}'));
            var month=s.substring(s.indexOf('${session.lang.Year}')+1,s.indexOf('${session.lang.Month1}'));
            if(month.length>1){
                r+=month;
            }else{
                r+='0'+month;
            }
            var day=s.substring(s.indexOf('${session.lang.Month1}')+1,s.indexOf('${session.lang.Day}'));
            if(day.length>1){
                r+=day;
            }else{
                r+='0'+day;
            }
        }
        return r;
    }
</script>