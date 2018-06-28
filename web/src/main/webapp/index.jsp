<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
	<title>${sessionScope.lang.loginTitle}</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="common/header_common.jsp"%>
	<link href="<%=path%>/style/style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		$(function(){

			$('body').layout({
				center__maskContents:true,
				west__size:215,
				west__minSize:215,
				west__maxSize:215,
				west__resizable:true,
				north:{
					size:'auto',
					spacing_open:0,
					closable:false,
					resizable:false
				},
				west__childOptions:{
					south__size:74,
					south__resizable:false,
					spacing_open:0
				}
			});

			$('.m-menu > dt').click(function(){
				$this = $(this);
				$dd = $('.m-menu > dd:visible');
				$dd.hide('blind',200);
				$this.next('dd').toggle('blind',200);
			});

		});
	</script>
</head>
<body>
<div id="west" class="ui-layout-west" style="width: 259px;">
	<div class="ui-layout-center" style="background:#e2e2e2;OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN;">
		<div>
			<div class="bg_menu"></div>
		</div>
		<div class="g-sd2 m-nav">

			<dl class="m-menu">
				<dt><span>库存管理</span></dt>
				<dd style="display: block;">
					<ul>
						<li><a href="jsp/materialinventory/outpreparelibrary.jsp" target="center">出库记录</a></li>
						<li><a href="jsp/materialinventory/cuttingtool_materialinventory.jsp" target="center">刀具分布情况</a></li>
						<li><a href="jsp/materialinventory/synthesisCutting_materialinventory.jsp" target="center">合成刀状态</a></li>
					</ul>
				</dd>
				<dt><span>加工信息</span></dt>
				<dd>
					<ul>
						<li><a href="jsp/productrecord/cuttingtoolrecord.jsp" target="center">刀具消耗查询</a></li>
						<li><a href="jsp/productrecord/synthesisrecord.jsp" target="center">车间加工总量</a></li>
						<li><a href="jsp/productrecord/exchangerecord.jsp" target="center">换刀记录</a></li>
						<li><a href="jsp/productrecord/synthesisadjust.jsp" target="center">调刀记录</a></li>
					</ul>
				</dd>
				<dt><span>刃磨涂层管理</span></dt>
				<dd>
					<ul>
						<li><a href="jsp/sharpening/inside_factory.jsp" target="center">厂内刃磨记录</a></li>
						<li><a href="jsp/sharpening/outside_factory.jsp" target="center">场外刃磨记录</a></li>
						<li><a href="jsp/sharpening/synthesisCutting_materialinventory.jsp" target="center">外委刃磨</a></li>
					</ul>
				</dd>
				<dt><span>基础数据</span></dt>
				<dd>
					<ul>
						<li><a href="jsp/initdata/cuttingtool.jsp" target="center">刀具参数</a></li>
						<li><a href="jsp/initdata/initMaterialInventory.jsp" target="center">非单品刀初始化</a></li>
						<li><a href="jsp/initdata/initSynthesisConfig.jsp" target="center">合成道具参数</a></li>
						<li><a href="jsp/initdata/synthesis_blade_code.jsp" target="center">合成刀刀身码</a></li>
					</ul>
				</dd>
				<dt><span>系统配置</span></dt>
				<dd>
					<ul>
						<li><a href="jsp/systemsetting/equipment_setting.jsp" target="center">设备配置</a></li>
						<li><a href="jsp/systemsetting/process_setting.jsp" target="center">工序配置</a></li>
						<li><a href="jsp/systemsetting/parts_setting.jsp" target="center">零部件配置</a></li>
						<li><a href="jsp/systemsetting/line_setting.jsp" target="center">生产关联配置</a></li>
					</ul>
				</dd>
				<dt><span>用户管理</span></dt>
				<dd>
					<ul>
						<li><a href="jsp/auth/department.jsp" target="center">部门</a></li>
						<li><a href="jsp/auth/position.jsp" target="center">职务</a></li>
						<li><a href="jsp/auth/customer.jsp" target="center">用户</a></li>
					</ul>
				</dd>
			</dl>
		</div>
	</div>
</div>
<iframe id="center" name="center" class="ui-layout-center" scrolling="auto" src="jsp/materialinventory/outpreparelibrary.jsp"></iframe>
</body>
</html>