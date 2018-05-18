<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
	<head>
		<title>${sessionScope.lang.loginTitle}</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@ include file="common/header_common.jsp"%>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(<%=path%>/style/<%=session.getAttribute("languageCode")%>/image/bg_22.gif );
	background-size: 100%;
	height: 100%;
	width: 100;
}
-->
</style>
		<link href="<%=path%>/style/style.css" rel="stylesheet"
			type="text/css">
		<script type="text/javascript">
	$(function(){
			$('#fm_login').form({
				success:function(jstr){
					var d = $.parseJSON(jstr);
					$('#fm_login :input').removeClass('u-ipt-err');
					if(d.status >= 0){
						top.location.href = '<%= path%>' + d.info;
					}else{
						if(d.status == '-1'){
							$(fm_login.UserName).addClass('u-ipt-err');
							artDialog(d.message,"OK");
							$(fm_login.UserName).foucs();
							return; 
						}else if(d.status == '-2'){
							$(fm_login.UserPass).addClass('u-ipt-err');
							artDialog(d.message,"OK");
							$(fm_login.UserPass).foucs();
							return; 
						}else if(d.status == '-3'){
							$(fm_login.UserName).addClass('u-ipt-err');
							$(fm_login.UserPass).addClass('u-ipt-err');
							artDialog(d.message,"OK");
							$(fm_login.UserName).foucs();
							return; 
						}
					}
				}
			});
		});
</script>
	</head>
	<body>
		<table border="0"  style="margin-top: 70px;margin-left:32%">
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td  height="70">
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table border="0" cellspacing="0" cellpadding="0">
						<tr >
							<td >
								<div id="jp_container_1" class="jp-audio">

									<div class="cover">
										<img id="immagine_cover"
											src="style/<%=session.getAttribute("languageCode")%>/image/Dialoghi_Eccellenti_1.gif">
										<div class="riflesso"></div>
									</div>
									<!--cover-->
									<form class="g-rc" id="fm_login" name="fm_login" action="checkInput.action" method="post">
										<ul class="info">

											<li>
												<strong class="autore">Autore</strong>
												<div>
													<input type="text" name="UserName"
														style="height: 30px; width: 200px; padding: 0px 0px;">
												</div>

											</li>
											<li class="ultima">
												<strong class="film">Film</strong>
												<div>
													<input type="password" name="UserPass"
														style="height: 30px; width: 200px; padding: 0px 0px;">
												</div>
											</li>
										</ul>
									
									<!--info brano-->

									<div class="controlli">
										<div>
										<button type="submit">
											<!--<a href="#" onClick="return linksubmit()">
													</a>-->
													<img
													src="<%=path%>/style/<%=session.getAttribute("languageCode")%>/image/llogin_btn.png"
													alt=""> 
										</button>
										</div>

									</div>
									</form>
									<div class="punti bottsx"></div>
									<div class="punti bottdx"></div>
									<div class="bar"></div>
									<div class="onair">
										<div style="display: block; opacity: 0.141718566828104;"></div>
									</div>
									<h2></h2>

								</div>
							</td>
					</table>
			</tr>
		</table>
		</td>
		</tr>

		</table>
	</body>
</html>