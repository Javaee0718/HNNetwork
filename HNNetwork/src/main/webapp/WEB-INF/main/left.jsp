<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title></title>
<!--leftmenu styles-->
<link href="${ctxStatic}/css/iejquery-accordion-menu.css"
	rel="stylesheet" type="text/css" />
<!--/leftmenu styles-->
<!--scrollbar style-->
<link href="${ctxStatic}/css/perfect-scrollbar.css" rel="stylesheet">
<!--/scrollbar style-->
<script src="${ctxStatic}/js/jquery-1.11.2.min.js"
	type="text/javascript"></script>
<!--除IE外都可识别-->
<!--[if !IE 8]><!--[if !IE 7]><!--[if !IE 6]><!-->
<link href="${ctxStatic}/css/jquery-accordion-menu.css" rel="stylesheet"
	type="text/css" />
<!--<![endif]-->
<!--<![endif]-->
<!--<![endif]-->
</head>
<body>
	<div class="conmenu">
		<div id="jquery-accordion-menu" class="jquery-accordion-menu red">
			<ul class="demo-list">
				<li class="active"><a href="${ctx}/incl/main/index"
					target="mainFrame"><img src="${ctxStatic}/images/icon_01.png"
						alt="" width="16" height="16" />&nbsp;&nbsp;系统首页</a></li>
				<li><a href="${ctx}/dtMa" target="mainFrame"><img
						src="${ctxStatic}/images/icon_tzh.png" alt="" width="16"
						height="16" />&nbsp;&nbsp;国网体系同业对标基本管理</a>
					<ul class="submenu">
						<li><a href="${ctx}/dtMa" target="mainFrame"><img
								src="${ctxStatic}/images/menu_03.png" alt="" width="16"
								height="16" />&nbsp;&nbsp;数据管理</a></li>
						<li><a href="${ctx}/dtMa/earlyWarning" target="mainFrame"><img
								src="${ctxStatic}/images/menu_03.png" alt="" width="16"
								height="16" />&nbsp;&nbsp;预警分析</a></li>
						<li><a href="${ctx}/incl/guoWang/Fangan_shp"
							target="mainFrame"><img src="${ctxStatic}/images/menu_03.png"
								alt="" width="16" height="16" />&nbsp;&nbsp;历史数据统计 </a></li>
						<li><a href="${ctx}/incl/guoWang/Fangan_shp2"
							target="mainFrame"><img src="${ctxStatic}/images/menu_03.png"
								alt="" width="16" height="16" />&nbsp;&nbsp;全网省数据统计</a></li>
						<li><a href="${ctx}/incl/guoWang/Fangan_chx"
							target="mainFrame"><img src="${ctxStatic}/images/menu_03.png"
								alt="" width="16" height="16" />&nbsp;&nbsp;数据汇总分析</a></li>
						<li><a href="${ctx}/incl/guoWang/Fangan_chx2"
							target="mainFrame"><img src="${ctxStatic}/images/menu_03.png"
								alt="" width="16" height="16" />&nbsp;&nbsp;考核评价</a></li>
					</ul></li>
				<li><a href="${ctx}/incl/provinceCompany/Sbtz_gl"
					target="mainFrame"><img src="${ctxStatic}/images/menu-xc.png"
						alt="" width="16" height="16" />&nbsp;&nbsp;省公司体系同业对标基本管理</a>
					<ul class="submenu">
						<li><a href="${ctx}/incl/provinceCompany/Fangan_mb"
							target="mainFrame"><img src="${ctxStatic}/images/menu_03.png"
								alt="" width="16" height="16" />&nbsp;&nbsp;数据管理 </a></li>
						<li><a href="${ctx}/incl/provinceCompany/Fangan_gl"
							target="mainFrame"><img src="${ctxStatic}/images/menu_03.png"
								alt="" width="16" height="16" />&nbsp;&nbsp;预警分析</a></li>
						<li><a href="${ctx}/incl/provinceCompany/Fangan_shp"
							target="mainFrame"><img src="${ctxStatic}/images/menu_03.png"
								alt="" width="16" height="16" />&nbsp;&nbsp;历史数据统计</a></li>
						<li><a href="${ctx}/incl/provinceCompany/Fangan_chx"
							target="mainFrame"><img src="${ctxStatic}/images/menu_03.png"
								alt="" width="16" height="16" />&nbsp;&nbsp;数据汇总分析</a></li>
					</ul></li>
				<li><a href="${ctx}/incl/jingyihua/Sybg_mb" target="mainFrame"><img
						src="${ctxStatic}/images/icon_03.png" alt="" width="16"
						height="16" />&nbsp;&nbsp;同业对标精益化管理</a>
					<ul class="submenu">
						<li><a href="${ctx}/incl/jingyihua/Sybg_mb"
							target="mainFrame"><img src="${ctxStatic}/images/menu_03.png"
								alt="" width="16" height="16" />&nbsp;&nbsp;国网体系同业对标管理</a></li>
						<li><a href="${ctx}/incl/jingyihua/Quanxian_set"
							target="mainFrame"><img
								src="${ctxStatic}/images/menu-set.png" alt="" width="16"
								height="16" />&nbsp;&nbsp;数据导入</a>
					</ul></li>
				<shiro:hasRole name="admin">
					<li><a href="${ctx}/role" target="mainFrame"><img
							src="${ctxStatic}/images/menu-set.png" alt="" width="16"
							height="16" />&nbsp;&nbsp;系统设置</a>
						<ul class="submenu">
							<li><a href="${ctx}/role?page=1&limit=12" target="mainFrame"><img
									src="${ctxStatic}/images/menu_03.png" alt="" width="16"
									height="16" />&nbsp;&nbsp;权限设置</a></li>
							<li><a href="${ctx}/user?page=1&limit=12" target="mainFrame"><img
									src="${ctxStatic}/images/menu_03.png" alt="" width="16"
									height="16" />&nbsp;&nbsp;用户管理</a></li>
						</ul></li>
				</shiro:hasRole>
				</li>
			</ul>
		</div>
	</div>

	<!--scrollbar js-->
	<script src="${ctxStatic}/scrollbarjs/perfect-scrollbar.js"></script>
	<script src="${ctxStatic}/scrollbarjs/jquery.scrollbar.js"></script>
	<!--/scrollbar js-->
	<!--leftmenu js-->
	<script src="${ctxStatic}/js/jquery-accordion-menu.js"
		type="text/javascript"></script>
	<script type="text/javascript">
//var bodyHeight = document.body.clientHeight;

jQuery(document).ready(function () {
	jQuery("#jquery-accordion-menu").jqueryAccordionMenu();
	$(".submenu li a").click(function(){
		$(".submenu li a").removeClass("active")
		$(this).addClass("active");
	});
	
});
$(function(){	
	//顶部导航切换
	$(".demo-list li").click(function(){
		$(".demo-list li.active").removeClass("active")
		$(this).addClass("active");
	})
	var bodyHeight = document.body.clientHeight;
	var bodyHeight = $(window).height();
	<!--<![endif]--><!--<![endif]--><!--<![endif]-->
	$(".conmenu").css({'height':bodyHeight});
})	

$(function() {
$.expr[":"].Contains = function(a, i, m) {
	return (a.textContent || a.innerText || "").toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
};
function filterList(header, list) {
	//@header 头部元素
	//@list 无需列表
	//创建一个搜素表单
	var form = $("<form>").attr({
		"class":"filterform",
		action:"#"
	}), input = $("<input>").attr({
		"class":"filterinput",
		type:"text"
	});
	$(form).append(input).appendTo(header);
	$(input).change(function() {
		var filter = $(this).val();
		if (filter) {
			$matches = $(list).find("a:Contains(" + filter + ")").parent();
			$("li", list).not($matches).slideUp();
			$matches.slideDown();
		} else {
			$(list).find("li").slideDown();
		}
		return false;
	}).keyup(function() {
		$(this).change();
	});
}
$(function() {
	filterList($("#form"), $(".demo-list"));
});
});	
</script>
	<!--/leftmenu js-->

</body>
</html>
