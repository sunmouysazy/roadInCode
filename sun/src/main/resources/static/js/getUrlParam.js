// 声明名为getUrlParam的函数，用于获取URL中指定名称的参数
// 示例：var id = $.getUrlParam("id");
(function ($) {
	$.getUrlParam = function (name) {
		var reg = new RegExp("(^|&)" 
				+ name + "=([^&]*)(&|$)");
		var r = window.location.search
			.substr(1).match(reg);
		if (r != null) return unescape(r[2]); return null;
	}
})(jQuery);