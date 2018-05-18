
(function($){
	$.fn.jQSelect = function(settings){
	
		var $div = this;
		var $cartes = $div.find(".cartes");
		var $lists = $div.find(".lists");
		
		var listTxt = $cartes.find(".listTxt");
		var listVal = $cartes.find(".listVal");

		var items = $lists.find("ul > li");
		
		$div.hover(function(){
			$(this).addClass("hover");
		},function(){
			$(this).removeClass("hover");	
		});
		//绑定点击事件
		items.click(function(){
			listVal.val($(this).attr("id").trim());
			listTxt.val($(this).text().trim());
			$div.removeClass("hover");
		});
		
	};
})(jQuery); 