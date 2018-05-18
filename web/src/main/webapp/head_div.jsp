				<div style="float: right; margin-right: 10px">
					<a href="init.action" target="center">${sessionScope.lang.BackTOHomeText}</a> | <a href="init.action"onclick="relogin();">${sessionScope.lang.ExitText}</a>| <a  href="javascript:void(0)  "id="PassWord">${sessionScope.lang.E683}</a> 
				</div>
				<script type="text/javascript">
				$("#PassWord").live('click',function(){
				
					var headtitle= '${session.lang.E683}';
					//添加内置编码
					$('#PassWordForm').form('reset');
					$('#PassWordForm :input').removeClass('u-ipt-err');
					$('#PassWordForm').find("*").each(function () { 
			    		  if($(this).hasClass("u-sel")){
			    			$(this).removeAttr("style");
			    		  }
			    	  });
					$('#PassWordForm').attr('action','ChangePassword.action');
						$.dialog({
							id:'PassWordEdit_dialog',
							title:headtitle,
							lock: true,
							content:document.getElementById('PassWordEdit'),
							button:[{
								name:'${session.lang.submitSaveText}',
								focus:true,
								callback:function(){
									$('#PassWordForm').form('submit',{
										success:function(d){
										    $('#PassWordForm :input').removeClass('u-ipt-err');
											$('#PassWordForm').find("*").each(function () { 
								    		  if($(this).hasClass("u-sel")){
								    			$(this).removeAttr("style");
								    		  }
								    	  });
											if($.parseJSON(d).status >= 0){
													artDialog($.parseJSON(d).message,"OK");
													$.dialog.list['PassWordEdit_dialog'].close();
												} else if($.parseJSON(d).status == -1){
												    artDialog(d.message,"OK");
												}else {			
												    artDialog(setContorllBackColor($('#PassWordForm'),$.parseJSON(d).message),"OK");
												}
											}
										});
										return false;
									}
								}]
							});
							return false;
						});
				</script>
				<div id="PassWordEdit" class="f-dn">
					<form id="PassWordForm" name="PassWordForm" method="post">
				    <table class="m-frmtb" width="100%">
							<tr>
								<th width="150">
									${sessionScope.lang.E685}
								</th>
								<td>
									<input name="DIVOldPassWord" type="password" class="u-ipt" maxlength="18">
									<span></span>
								</td>
							</tr>
							<tr>
								<th width="150">
									${sessionScope.lang.E686}
								</th>
								<td>
									<input name="DIVNewPassWord" type="password" class="u-ipt" maxlength="18">
									<span></span>
								</td>
							</tr>
							<tr>
								<th width="150">
									${sessionScope.lang.E687}
								</th>
								<td>
									<input name="DIVNewPassWordCheck" type="password" class="u-ipt" maxlength="18">
									<span></span>
								</td>
							</tr>
				    </table>
				</form>
			</div>