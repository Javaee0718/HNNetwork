<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${ctxStatic}/css/style.css" rel="stylesheet" type="text/css" />
<script src="${ctxStatic}/js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		//顶部导航切换
		$(".nav li a").click(function() {
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		});
		var mydate = new Date();
		var t = mydate.toLocaleString();
		$("#currentTime").text("当前时间：" + t);
	})
</script>
</head>

<body style="background: url(${ctxStatic}/images/topbg.png);">

	<div class="topleft">
		<a href="${ctx}/incl/main/main" target="_parent"><img src="${ctxStatic}/images/logo.png"
			title="系统首页" /></a>
	</div>
	<div class="topright">
		<ul>
			<li id="currentTime"></li>
			<li><a href="${ctx}/sys/logout" target="_parent">退出</a></li>
		</ul>
		<div class="user">
			<span>${username}</span>
		</div>
	</div>

</body>
</html>