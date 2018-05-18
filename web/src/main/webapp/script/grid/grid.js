/**
 * $.grid
 * 
 * @extends jQuery 1.8.2
 * @fileOverview Ajax分页展示控件
 * @author Joker
 * @email 8090259@qq.com
 * @site outd.net
 * @version 0.1
 * @date 2013-04-29
 */
(function($) {
	// 绘制Grid Dom
	var drawGrid = function($this) {
		var dom = $this.data('dom');

		var setting = $this.data('setting');
		if (setting.width != '')
			dom.table.width(setting.width);
		if (setting.fit == true) {
			var pane = dom.table.parent();
			dom.grid.height('100%');
			dom.frame.height('100%');
		}
		dom.table.after(dom.grid);
		dom.table.html(dom.thead);
		dom.frame.html(dom.table);
		dom.grid.html(dom.frame);
		var fix = 2;
		if (dom.bar.length > 0) {
			dom.bar.addClass('ui-grid-bar');

			dom.grid.append(dom.bar);
			fix = dom.bar.outerHeight() + 2;
		}
		dom.grid.height(dom.grid.height() - fix);
		dom.table.width('100%');

		// $(window).resize(function(){
		// dom.table.width($(window).width()-20);
		// });

		// $(window).bind('resize', function(){
		// dom.table.width(dom.grid.width()-14);
		// $("#sys_right_list").setGridWidth($('body').width(),true);
		// });
	}

	// 绘制表头
	var drawThead = function($this) {
		var dom = $this.data('dom');
		var setting = $this.data('setting');
		var $tr = $('<tr></tr>');
		if (setting.rowno == true) {
			$tr.append('<th class="ui-grid-rowno" field="grid_rowno"></th>');
		}
		$
				.each(
						setting.column,
						function(i, item) {
							var $th = $('<th align="center"></th>');
							if (item.width != undefined) {
								if (item.width == 'auto') {
									$th.attr('auto', true);
								} else {
									$th.width(item.width);
								}
							}
							if (item.visible != undefined) {
								if (item.visible == 'true') {
									$th.show();
								} else {
									$th.hide();
								}
							}
							if (item.type != undefined) {
								if (item.type == 'checkbox') {

									var $checkbox = $('<input type="checkbox"/>');
									$checkbox
											.click(function() {
												$
														.each(
																dom.tbody
																		.find(':checkbox[name=' + item.name + ']'),
																function(s, c) {
																	if ($checkbox
																			.attr("checked")) {
																		$(c)[0].checked = true;
																	} else {
																		$(c)[0].checked = false;
																	}
																	// checkedCache($this,$(c)[0]);
																});
											});
									$th.append($checkbox);
								} else {
								}
							} else {
								$th
										.html('<span class="ui-grid-thtx">' + item.title + '</span>');
							}
							$th.click(function() {
								// 排序
									/*
									 * $tr = dom.tbody.find('tr'); $i =
									 * $(this).index(); var trValue = new
									 * Array(); for (var i=0; i<$tr.size(); i++ ){
									 * trValue[i] = $tr.eq(i); }
									 * if($this.data('Idx') == $i){
									 * trValue.reverse(); }else{ }
									 */
								});
							$tr.append($th);
						});
		dom.thead.html($tr);
		// $.each($tr.find('span'),function(i,span){
		// $th = $(span).parent('th');
		// if($th.attr('auto') == 'true'){
		// $th.width($(span).outerWidth());
		// }
		// });
	}

	/**
	 * 返回数据
	 */
	var getData = function($this) {
		var setting = $this.data('setting');
		setting.data.page = setting.page;
		setting.data.rows = setting.rows;
		$.ajax( {
			url : setting.url,
			type : setting.type,
			dataType : setting.datatype,
			async : setting.async,
			data : setting.data,
			success : function(d) {

				if (d != null) {

					updData(d, $this);
					setting.success(d);
					// drawTbody($this);
					if (setting.pager == true) {
						setting.page = d.page;
						drawPager($this, d.total);
					}
					if (setting.rowEdit) {
						_w_table_rowspan(setting.colEdit);
					}
				}
			}
		});
	}

	// 数据变更
	var updData = function(data, $this) {
		if (data != null) {

			if (data.rows !== undefined) {
				$this.data('data', data);
			} else {
				var d = $this.data('data');
				d.rows.push(data);
				$this.data('data', d);
			}
		}
	}

	// 绘制表主体
	var drawTbody = function($this) {
		var setting = $this.data('setting');
		var dom = $this.data('dom');
		var data = $this.data('data');
		dom.tbody.empty();
		try {
			if (data.rows.length > 0) {
				jQuery.each(data.rows, function(i, row) { // 遍历行

							// jQuery.each(setting.column,function(i,column){
						// //遍历行
						$tr = addRow(row, $this, i);
						dom.tbody.append($tr);
					});
			}
			dom.table.append(dom.tbody);
			if (setting.rowno == true) {
				updRowNo($this);
			}
			autoWidth($this);
		} catch (e) {
		}
		/*
		 * setting.param.p = setting.p; setting.param.size = setting.rows;
		 * $.ajax({ type:'GET', url:setting.url, data:setting.param,
		 * async:setting.async, dataType:'json', success:function(rs){
		 * dom.tbody.empty(); //清除 try { if(rs.rows.length > 0){
		 * $.each(rs.rows,function(r,row){ //遍历数据行 var tr = $('<tr></tr>');
		 * if(r%2) tr.addClass('odd');
		 * 
		 * if(typeof setting.rowCss == 'function'){ tr.css(setting.rowCss(row)); }
		 * 
		 * if(typeof setting.rowClick == 'function'){
		 * tr.bind('click',function(e){setting.rowClick(e,$(this),row,rs.other)});
		 * //事件绑定 } if(typeof setting.rowMouseover == 'function'){
		 * tr.bind('mouseover',function(e){setting.rowMouseover(e,$(this),row,rs.other)});
		 * //事件绑定 } if(typeof setting.rowMouseout == 'function'){
		 * tr.bind('mouseout',function(e){setting.rowMouseout(e,$(this),row,rs.other)});
		 * //事件绑定 } if(typeof setting.rowMousemove == 'function'){
		 * tr.bind('mousemove',function(e){setting.rowMousemove(e,$(this),row,rs.other)});
		 * //事件绑定 }
		 * 
		 * $.each(setting.items,function(d,colum){ //遍历显示列 var align =
		 * colum.align != undefined ? colum.align:'left'; var td = $('<td align="'+align+'"></td>');
		 * if(colum.type != undefined){ dom.thead.find(':checkbox')[0].checked =
		 * false; if(colum.type == 'checkbox'){ var checkbox = $('<input
		 * type="checkbox" name="'+colum.name+'"
		 * value="'+$(row).attr(colum.name)+'"/>');
		 * if(jQuery.inArray(checkbox.val(),$this.data('checked')) >= 0){
		 * checkbox.attr('checked',true); } td.click(function(e){
		 * e.stopPropagation(); }); checkbox.click(function(e){
		 * checkedCache($this,this); e.stopPropagation(); }); td.html(checkbox); }
		 * }else{ $.each(row,function(i,val){ //遍历数据列 if(colum.name == i){
		 * td.html(val); //字段列 } if(typeof colum.irender == 'function' &&
		 * colum.name == i){ td.html(colum.irender(val,row,rs.other)); //特定复杂渲染列 }
		 * if(typeof colum.render == 'function'){
		 * td.html(colum.render(row,rs.other)); //复杂渲染列 } if(typeof
		 * colum.mouseover == 'function' && colum.name == i){
		 * td.bind('mouseover',function(e){colum.mouseover(e,$(this),row,rs.other)});
		 * //事件绑定 } if(typeof colum.mouseout == 'function' && colum.name == i){
		 * td.bind('mouseout',function(e){colum.mouseout(e,$(this),row,rs.other)});
		 * //事件绑定 } if(typeof colum.mousemove == 'function' && colum.name == i){
		 * td.bind('mousemove',function(e){colum.mousemove(e,$(this),row,rs.other)});
		 * //事件绑定 } }); } if(colum.html != undefined){ //静态列
		 * td.html(colum.html); } tr.append(td); }); dom.tbody.append(tr); });
		 * }else{ dom.tbody.append('<tr><td colspan="'+setting.items.length+'" align="center">--暂无数据--</td></tr>'); } }
		 * catch (e) { dom.tbody.append('<tr><td colspan="'+setting.items.length+'" align="center">--暂无数据--</td></tr>'); }
		 * 
		 * dom.table.append(dom.tbody); if(setting.pager!=false){
		 * dom.listFrame.height(((dom.tbody.find('td').outerHeight(true))*(setting.rows)+(dom.thead.find('th').outerHeight(true))));
		 * drawPager($this,rs.total); //重绘分页器 } success($this); } });
		 */
	}

	// 重写行
	var rewriteRow = function($tr, row, $this) {
		var dom = $this.data('dom');
		var setting = $this.data('setting');
		$new = addRow(row, $this);

		$tr.replaceWith($new);
		if (setting.rowno == true) {
			updRowNo($this);
		}
	}

	var updRowNo = function($this) {
		var dom = $this.data('dom');
		var setting = $this.data('setting');
		jQuery
				.each(
						dom.tbody.children('tr'),
						function(i, tr) {
							$(tr).children('.ui-grid-rowno').remove();
							$(tr)
									.prepend(
											'<th class="ui-grid-rowno" field="grid_rowno">' + (i + 1) + '</th>');
						})
	}

	// 增加行数据
	var addRow = function(row, $this, index) {
		var dom = $this.data('dom');
		var setting = $this.data('setting');

		var $tr = $('<tr></tr>');
		// if(index%2) $tr.addClass('ui-grid-odd');

		jQuery
				.each(
						setting.column,
						function(i, column) { // 遍历列
							var $td = $('<td field="' + column.name + '" align="center"></td>');

							if (column.type != undefined) {
								if (column.type == 'checkbox') {

									jQuery
											.each(
													row,
													function(field, val) {
														if (column.name == field) {
															var $checkbox0 = $('<input type="checkbox" name="' + column.name + '" value="0" checked/>');
															var $checkbox1 = $('<input type="checkbox" name="' + column.name + '" value="1" />');
															$td
																	.append(val == '0' ? $checkbox0
																			: $checkbox1);
														}
													});
								}
							} else {
								jQuery
										.each(
												row,
												function(field, val) {
													if (column.name == field) {
														if (setting.tree == true) {
															if ((setting.treecolumn == column.name)
																	|| (setting.treecolumn == '' && i == 0)) {
																var ml = 18 * row.capabilityLevel;
																var isLeaf = 'ui-icon-triangle-1-e';
																if (row.capabilityLevel == 1) {
																	isLeaf = 'ui-icon-triangle-1-e';
																} else if (row.capabilityLevel == 2) {

																	// isLeaf =
																	// 'ui-icon-triangle-1-s';
																} else if (row.capabilityLevel == 3) {
																	isLeaf = 'ui-icon-radio-off';
																}
																$wrap = $('<div class="tree-wrap"><div style="margin-left:'
																		+ ml
																		+ 'px;" class="ui-icon treeclick '
																		+ isLeaf
																		+ '"></div></div>');
																if (row.capabilityLevel == 1
																		|| row.capabilityLevel == 2) {
																	$wrap
																			.click(function() {
																				// 节点载入关闭
																				toggleNode(
																						i,
																						row,
																						$tr,
																						$this,
																						this);
																			});
																}
																$tr
																		.attr(
																				'level',
																				row.capabilityLevel);
																$tr
																		.attr(
																				'cid',
																				row.capabilityID);
																$tr
																		.attr(
																				'pid',
																				row.capCapabilityID);
																$td
																		.append($wrap);
															}
														}

														$td
																.append('<span class="ui-grid-tdtx">' + (val != null ? htmlEncode(val)
																		: '') + '</span>');
													}
													if (typeof column.format == 'function') {
														$td.data('old', $td
																.html());
														$td.empty().append(
																column.format(
																		row,
																		$this)); // 格式化列
													}
												});
							}
							if (column.visible != undefined) {
								if (column.visible == 'true') {
									$td.show();
								} else {
									$td.hide();
								}
							}
							$tr.append($td);
							$tr.data('row', row);

						});

		if (typeof setting.addrow == 'function') {
			setting.addrow(row, $tr, $this);
		}

		$tr.mouseover(function() {
			$tr.addClass('hover');
		}).mouseout(function() {
			$tr.removeClass('hover');
		});

		// jQuery.each(row,function(field,val){ //遍历字段
		// var $td = $('<td></td>');
		// jQuery.each(setting.column,function(i,column){
		// if(column.name == field){
		// if(column.width == 'auto'){
		// $td.attr('auto',true);
		// }
		// if(setting.tree == true){
		// if((setting.treecolumn == column.name) || (setting.treecolumn == ''
		// && i == 0)){
		// var ml = 18*row.level;
		// var isLeaf = 'ui-icon-triangle-1-e';
		// if(row.isLeaf == 'false' && row.expanded == 'false'){
		// isLeaf = 'ui-icon-triangle-1-e';
		// }else if(row.isLeaf == 'false' && row.expanded == 'true'){
		// isLeaf = 'ui-icon-triangle-1-s';
		// }else if(row.isLeaf == 'true'){
		// isLeaf = 'ui-icon-radio-off';
		// }
		// $wrap = $('<div class="tree-wrap"><div style="margin-left:'+ml+'px;"
		// class="ui-icon treeclick '+isLeaf+'"></div></div>');
		// if(row.isLeaf == 'false'){
		// $wrap.click(function(){
		// //节点载入关闭
		// toggleNode(i,row,$tr,$this,this);
		// });
		// }
		// $tr.attr('level',row.level);
		// $td.append($wrap);
		// }
		// }
		// $td.append('<span class="ui-grid-tdtx">'+val+'</span>');
		// $tr.append($td);
		// }else{
		// var arr = $.makeArray(row);
		// alert($.inArray('pid',arr));
		// }
		//				
		// // else if(typeof column.format == 'function'){
		// // $td.data('old',$td.html());
		// // $td.empty().append(column.format(i,row,$this)); //复杂渲染列
		// // $tr.append($td);
		// // }
		// });
		// });
		return $tr;
	}

	//Html编码获取Html转义实体
	function htmlEncode(value){
	  return $('<div/>').text(value).html();
	}
	//Html解码获取Html实体
	function htmlDecode(value){
	  return $('<div/>').html(value).text();
	}

	// 调整列宽
	var autoWidth = function($this) {
		// var dom = $this.data('dom');
		// $span = $(dom.tbody).children('tr').eq(0).find('span');
		// jQuery.each($span,function(i,span){
		// $td = $(span).parent('td');
		// if($td.attr('auto') == 'true'){
		// $td.width($(span).outerWidth()+24);
		// }
		// });
	}

	var getIndex = function($this, str) {

	}

	// 展开关闭节点
	var toggleNode = function(i, row, $tr, $this, wrap) {
		var dom = $this.data('dom');
		var setting = $this.data('setting');
		var $wrap = $(wrap);
		var $div = $wrap.children();
		if ($div.hasClass('ui-icon-triangle-1-e')) {

			setting.data.page = setting.page;
			setting.data.rows = setting.rows;
			setting.data.nodeid = row[setting.keyname];
			setting.data.n_lvevl = row.capabilityLevel + 1;
			$.ajax( {
				url : setting.url,
				type : setting.type,
				dataType : setting.datatype,
				async : setting.async,
				data : setting.data,
				success : function(d) {
					$child = $('');
					$.each(d.rows, function(i, row) {
						$tmp = addRow(row, $this);
						$child.after($tmp);
					});
					$tr.after($child);
					$div.removeClass('ui-icon-triangle-1-e');
					$div.addClass('ui-icon-triangle-1-s');
					if (setting.rowno == true) {
						updRowNo($this);
					}
				}
			});
		} else {
			$div.removeClass('ui-icon-triangle-1-s');
			$div.addClass('ui-icon-triangle-1-e');
			$.each(
					$tr.nextUntil('tr[cid=' + row.capabilityID + ']'),
					function(key, val) {
						if ($.isPlainObject(val) || $.isArray(val)) {
							subObj(val);
						} else {
							var $tr = $(val);
							// alert($tr.attr('pid'));
							if ($tr.attr('pid') == row.capabilityID) {
								$
										.each($tr.nextUntil('tr[cid=' + $tr
												.attr('pid') + ']'), function(
												key, val) {
											if ($.isPlainObject(val)
													|| $.isArray(val)) {
												subObj(val);
											} else {
												var $tr2 = $(val);
												// alert($tr2.attr('pid'));
												if ($tr2.attr('pid') == $tr
														.attr('cid')) {
													$tr2.remove();
												}
											}
										});
								$tr.remove();
							}
						}
					});

			// if($tr.nextUntil('tr[cid='+row.capabilityID+']').attr('pid') ==
			// row.capabilityID)
			// $tr.nextUntil('tr[cid='+row.capabilityID+']').remove();
			if (setting.rowno == true) {
				updRowNo($this);
			}
		}
	}

	// 行加载完毕事件
	var success = function($this) {
		var setting = $this.data('setting');
		if (typeof setting.success == 'function') {
			setting.success();
		}
	}

	// 行选择器缓存
	var checkedCache = function($this, checkbox) {
		if ($(checkbox).prop("checked")) {
			if (jQuery.inArray($(checkbox).val(), $this.data('checked')) < 0) {
				$this.data('checked').push($(checkbox).val());
			}
		} else {
			if (jQuery.inArray($(checkbox).val(), $this.data('checked')) >= 0) {
				$this.data('checked').splice(
						jQuery
								.inArray($(checkbox).val(), $this
										.data('checked')), 1);
			}
		}
	}

	// 绘制分页器
	var drawPager = function($this, total) {

		var setting = $this.data('setting');
		var dom = $this.data('dom');

		var page = {
			currentPage : setting.page,
			countPage : Math.ceil(total / setting.rows)
		} 
		dom.grid.height('100%'); 
		var fix = 2;
		if (dom.bar.length > 0) {
			dom.bar.addClass('ui-grid-bar');

			dom.grid.append(dom.bar);
			fix = dom.bar.outerHeight() + 2;
		}
		dom.grid.height(dom.grid.height() - fix);
		if(dom.table.height() > dom.grid.height()){ 
		    dom.grid.height(dom.table.height());
		}
		var formatArr = new Array();
		var format = {
			pageinfo : null,
			record : null,
			first : null,
			prev : null,
			last : null,
			next : null,
			jump : null,
			number : null
		}
		var tmpArr = new Array();
		var $pfrm = $('<div class="m-page m-page-rt"></div>');

		if (page.currentPage <= 1) {
			format.first = $('<a href="javascript:void(0)" class="last pageprv z-dis"><span class="pagearr">&lt;&lt;</span></a>');
			format.last = $('<a href="javascript:void(0)" class="last pageprv z-dis"><span class="pagearr">&lt;</span></a>');
		} else {
			format.first = $('<a href="javascript:void(0)" class="last pageprv"><span class="pagearr">&lt;&lt;</span></a>');
			format.last = $('<a href="#" class="last pageprv"><span class="pagearr">&lt;</span></a>');
		}
		if (page.currentPage < page.countPage) {
			format.next = $('<a href="#" class="last pagenxt"><span class="pagearr">&gt;</span></a>');
			format.prev = $('<a href="javascript:void(0)" class="last pagenxt"><span class="pagearr">&gt;&gt;</span></a>');
		} else {
			format.next = $('<a href="javascript:void(0)" class="last pagenxt z-dis"><span class="pagearr">&gt;</span></a>');
			format.prev = $('<a href="javascript:void(0)" class="last pagenxt z-dis"><span class="pagearr">&gt;&gt;</span></a>');
		}

		var start = Math.max(1, page.currentPage - parseInt(setting.roll / 2));
		var end = Math.min(page.countPage, start + setting.roll - 1);
		start = Math.max(1, end - setting.roll + 1);

		for ( var i = start; i <= end; i++) {
			var number = i;
			if (number != page.currentPage) {
				tmpArr
						.push('<a href="javascript:void(0)" class="number" page="'
								+ number + '">' + number + '</a>');
			} else {
				tmpArr
						.push('<a href="javascript:void(0)" class="number z-crt" page="'
								+ number + '">' + number + '</a>');
			}
		}
		/*
		 * var tn = page.currentPage - (setting.roll/2) < 0 ? 0 :
		 * page.currentPage - (setting.roll/2); var tx = tn <
		 * 1?setting.roll:setting.roll; for ( var i = 1; i <= tx; i++) { //var
		 * number = (nowCoolPage-1) * setting.rows + i; var number = tn+i;
		 * if(number != page.currentPage){ if(number <= page.countPage && number !=
		 * page.countPage){ tmpArr.push('<a href="javascript:void(0)"
		 * page="'+number+'">'+number+'</a>'); }else{ // tmpArr.push('<a
		 * href="javascript:void(0)" page="'+number+'">'+number+'</a>'); //
		 * if(tn > (page.countPage - setting.roll)-1){ // } break; } }else{
		 * if(page.countPage != 1){ tmpArr.push('<a href="javascript:void(0)"
		 * page="'+number+'" class="z-crt">'+number+'</a>'); } } }
		 * 
		 */
		var $rowcount = $('<select style="border:0px"></select>');
		$(setting.rowlist).each(
				function(i, c) {
					if (setting.rows == c) {
						$rowcount.append('<option value="' + c + '" selected>'
								+ c + '</option>');
					} else {
						$rowcount.append('<option value="' + c + '">' + c
								+ '</option>');
					}
				});
		// $rowcount.change(function(){
		// setting.rows = this.value;
		// $this.data('setting',setting);
		// drawTbody($this);
		// })
		// format.jump = $('<li class="jump"><input id="txtJump" type="text"
		// value="'+page.currentPage+'"/><button id="btnJump"
		// type="button">跳转至</button></li>');
		// format.pageinfo = $('<li>当前页
		// '+page.currentPage+'/'+page.countPage+'</li>');
		// format.record = $('<li>'+setting.rows+'条/页 共'+total+'条记录</li>');
		// format.number = $(tmpArr.join(''));
		// format.rowcount = $('<li style="padding:4px"></li>');
		// format.rowcount.empty().append($rowcount);
		format.jump = $('<li class="jump"><input id="txtJump" type="text" value="' + page.currentPage + '"/><button id="btnJump" type="button">-&gt;</button></li>');
		format.pageinfo = $('<li>' + page.currentPage + '/' + page.countPage
				+ '</li>');
		format.record = $('<li>' + setting.rows + 'record/page records:'
				+ total + '</li>');
		format.number = $(tmpArr.join(''));
		format.rowcount = $('<li style="padding:4px"></li>');
		format.rowcount.empty().append($rowcount);
		if (total == undefined) {
			format.jump = "";
			format.pageinfo = "";
			format.record = "";
			format.number = "";
			format.rowcount = "";
			format.first = "";
			format.prev = "";
			format.last = "";
			format.next = "";
		}
		formatArr = setting.pagercon.split(',');
		$(formatArr).each(function(index, str) {
			$pfrm.append(format[str]);
		})
		dom.bar.empty();
		dom.bar.append('<div style="clear:both;"></div>');
		dom.bar.append($pfrm);
		dom.bar.append('<div style="clear:both;"></div>');

		// 事件绑定
		if (page.currentPage > 1) {
			format.first.click(function() {
				setting.page = 1;
				getData($this);
			});
			format.last.click(function() {
				setting.page = parseInt(page.currentPage) - 1;
				getData($this);
			});
		}
		if (page.currentPage < page.countPage) {
			format.prev.click(function() {
				setting.page = page.countPage;
				getData($this);
			});
			format.next.click(function() {
				setting.page = parseInt(page.currentPage) + 1;
				getData($this);
			});
		}
		format.jump.find('#btnJump').click(function() {
			var txtJump = format.jump.find('#txtJump');
			if (txtJump.val() <= page.countPage && txtJump.val() > 0) {
				setting.p = txtJump.val();
				drawTbody($this);
			} else {
				alert("您输入了错误的页码");
				txtJump.val(page.currentPage);
				txtJump.focus();
			}
		});
		format.number.click(function() {
			$a = $(this);
			if ($a.attr('class') != 'z-crt') {
				setting.page = $a.attr('page');
				getData($this);
			}

		});
	}

	var methods = {
		init : function(options) { // 初始化
			return this.each(function() {
				var $this = $(this);
				// 初始化设置
					var setting = $this.data('setting');

					if (typeof (setting) == 'undefined') {
						var defaults = {
							url : '',
							data : {},
							datatype : 'json',
							type : 'post',
							width : '100%',
							keyname : 'id',
							fit : true,
							lazy : false,
							async : true,
							column : [],
							rowlist : [ 15, 20, 25, 30 ],
							rows : 10000,
							roll : 2,
							barid : '',
							tree : false,
							pager : false,
							rowno : true,
							pagerpos : 'right',
							pagercon : 'rowcount,pageinfo,record,first,last,next,prev,jump',
							success : function(d) {
								alert(d.total);
							},
							treecolumn : '',
							page : 1
						}
						setting = $.extend( {}, defaults, options);
						$this.data('setting', setting);
					} else {
						setting = $.extend( {}, setting, options);
					}
					// 检测组件有效性
					if ($this.context.nodeName != 'TABLE') {
						alert('is Not Table');
					} else {
						// 初始化组件
						$this.data('dom', {
							grid : $('<div class="ui-grid"></div>'),
							frame : $('<div class="ui-grid-frame"></div>'),
							table : $($this.context),
							thead : $('<thead></thead>'),
							tbody : $('<tbody></tbody>'),
							bar : $(setting.barid)
						});
						// 选择器缓存
						$this.data('checked', new Array());

						drawGrid($this); // 绘制Grid
						drawThead($this); // 绘制表头
						if (!setting.lazy) {
							getData($this);
						}
					}

					// 初始化组件
					// $this.data('dom',{
					// listFrame:$('<div class="pagelist"></div>'), //列表外框
					// table:$('<table cellpadding="0" cellspacing="0"
					// border="0"></table>'), //列表
					// thead:$('<thead></thead>'), //列表头
					// tbody:$('<tbody></tbody>'), //列表体
					// pager:$('<div class="pager"></div>') //分页器
					// });
					// $this.data('checked',new Array()); //行选择器缓存
					//				
					// drawPage($this);
					//
					// drawThead($this);
					// if(!setting.lazy){
					// drawTbody($this);
					// }
				});
		},
		load : function(p) {
			return this.each(function() {
				var $this = $(this);
				$this.data('setting').page = (p != undefined ? p : $this
						.data('setting').page);
				getData($this);
			});
		},
		data : function(param) {
			return this.each(function() {
				var $this = $(this);
				data = $.extend( {}, $this.data('setting').data, param);

				$this.data('setting').data = data;
			})
		},
		url : function(url) {
			console.log(url);
			return this.each(function() {
				var $this = $(this);
				$this.data('setting').url = url;
			})
		},
		append : function(row) {
			return this.each(function() {
				var $this = $(this);
				var dom = $this.data('dom');
				var setting = $this.data('setting');
				dom.tbody.append(addRow(row, $this));
				if (setting.rowno == true) {
					updRowNo($this);
					updData(row, $this);
				}
			});
		},
		addChild : function(tr, row) {
			return this.each(function() {
				var $this = $(this);
				var $tr = $(tr);
				var $child = $tr
						.nextUntil('tr[level=' + (row.NLEVEL - 1) + ']');
				var $warp = $tr.find('.tree-wrap');
				var setting = $this.data('setting');
				$tmp = addRow(row, $this);

				if ($child.size() == 0) {
					toggleNode(0, $tr.data('row'), $tr, $this, $warp)
				} else {
					$child.eq($child.size() - 1).after($tmp);
				}
				if (setting.rowno == true) {
					updRowNo($this);
				}
			});
		},
		delNode : function(tr) {
			return this.each(function() {
				var $this = $(this);
				var $tr = $(tr);
				var row = $tr.data('row');
				var $child = $tr.nextUntil('tr[level=' + (row.NLEVEL) + ']');
				if ($child.attr('level') > row.NLEVEL) {
					$child.remove();
				}
				$tr.remove();
			});
		},
		refreshRow : function(tr, row) {
			return this.each(function() {
				var $this = $(this);
				var $tr = $(tr);
				// $tr.data('row',row);
					rewriteRow($tr, row, $this)
				});
		}
	}
	$.fn.grid = function() {
		var method = arguments[0];
		if (methods[method]) {
			method = methods[method];
			arguments = Array.prototype.slice.call(arguments, 1);
		} else if (typeof (method) == 'object' || !method) {
			method = methods.init;
		} else {
			alert('jQuery.grid 中不存在 ' + method + ' 这个方法！');
			$.error('Method ' + method + ' does not exist on jQuery.grid');
			return this;
		}
		return method.apply(this, arguments);
	}
})(jQuery);