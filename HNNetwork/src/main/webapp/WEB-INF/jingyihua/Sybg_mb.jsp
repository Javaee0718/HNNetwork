<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${ctxStatic}/css/iestyle.css" rel="stylesheet" type="text/css" />
<link href="${ctxStatic}/css/select.css" rel="stylesheet" type="text/css" />
<!--scrollbar style-->
<link href="${ctxStatic}/css/perfect-scrollbar.css" rel="stylesheet">
	<!--/scrollbar style-->
	<!--menu style-->
	<link href="${ctxStatic}/css/style-menu.css" rel="stylesheet">
		<!--/menu style-->
		<!--分页插件style-->
		<link type="text/css" rel="stylesheet" href="${ctxStatic}/css/simplePagination.css" />
		<!--/分页插件style-->
		<script type="text/javascript" src="${ctxStatic}/js/jquery-1.11.2.min.js"></script>
		<script type="text/javascript" src="${ctxStatic}/js/select-ui.min.js"></script>
		<!--menu js-->
		<script type="text/javascript" src="${ctxStatic}/js/jquery.menu.js"></script>
		<!--/menu js-->
		<script type="text/javascript" src="${ctxStatic}/js/jquery.common.js"></script>
		<!--除IE外都可识别-->
		<!--calendar-->
		<script type="text/javascript" src="${ctxStatic}/calendarjs/laydate.js"></script>
		<!--/calendar-->
		<!--分页插件 js-->
		<script type="text/javascript" src="${ctxStatic}/js/jquery.simplePagination.js"></script>
		<!--/分页插件 js-->
		<!--[if !IE 8]><!--[if !IE 7]><!--[if !IE 6]><!-->
		<link href="${ctxStatic}/css/style.css" rel="stylesheet" type="text/css" />
		<!--<![endif]-->
		<!--<![endif]-->
		<!--<![endif]-->
		<!--select options-->
		<script type="text/javascript">
			$(document).ready(function(e) {
				$(".select1").uedSelect({
					width : 150
				});
				$(".select2").uedSelect({
					width : 500
				});
			});
		</script>
		<script type="text/javascript">
			$(function() {
				var mydate = new Date();
				var t = mydate.toLocaleString();
				$("#end").text(t);
			})
		</script>
		<!--/select options-->
</head>
<body>
	<!--当前位置-->
	<div class="place">
		<span>位置：</span>
		<ul class="placeul" style="width: 100%">
			<li>首页</li>
			<li>同业对标精益化管理</li>
			<li>国网体系同业对标管理</li>
			<!--<li style="margin-right:0;float:right">
			 <!--<a  href="newMainEchart.html" target="subFrame" onclick="ruturnIndex()" class="longred">返回</a>-->
			<!--</li>-->
			<!--<li style="margin-right:50px;margin-top:5px;float:right">
			<select class="select2" id="changeIndex" onchange="changeIndex(this.options[this.options.selectedIndex].value)" style=" width:100px;">
			<option value="">请选择指标</option>
			<option value="1">指标1</option>
			<option value="2">指标2</option>
			<option value="3">指标3</option>
			</select>
		</li>-->

		</ul>
	</div>
	<!--/当前位置-->
	<div class="mainindex" id="mainindex">
		<iframe frameborder="0" valign="top" id="subFrame" name="subFrame"
			scrolling="yes" src="newMainEchart.html"
			style="height: 100%; visibility: inherit; width: 100%; z-index: 2"></iframe>
	</div>
	<!--height Resize js-->
	<script type="text/javascript">
		$(document).ready(function() {
			windowResize();
			$(window).resize(function() {
				windowResize();
			});
		});
	</script>
	<!--/height Resize js-->
	<!--scrollbar js-->
	<script src="${ctxStatic}/scrollbarjs/perfect-scrollbar.js"></script>
	<script src="${ctxStatic}/scrollbarjs/jquery.scrollbar.js"></script>
	<!--/scrollbar js-->

	<!--echart js-->
	<script src="${ctxStatic}/echartsjs/echarts.js"></script>
	<!--/echart js-->
</body>

</html>
