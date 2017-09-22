<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>power manager</title>
<link href="${ctxStatic}/css/iestyle.css" rel="stylesheet"
	type="text/css" />
<link href="${ctxStatic}/css/select.css" rel="stylesheet"
	type="text/css" />
<!--scrollbar style-->
<link href="${ctxStatic}/css/perfect-scrollbar.css" rel="stylesheet">
<!--/scrollbar style-->
<!--menu style-->
<link href="${ctxStatic}/css/style-menu.css" rel="stylesheet">
<!--/menu style-->
<!--分页插件style-->
<link type="text/css" rel="stylesheet"
	href="${ctxStatic}/css/simplePagination.css" />
<!--/分页插件style-->
<script type="text/javascript"
	src="${ctxStatic}/js/jquery-1.11.2.min.js"></script>
<%-- <script type="text/javascript" src="${ctxStatic}/js/jquery-3.2.1.min.js"></script> --%>
<script type="text/javascript" src="${ctxStatic}/js/select-ui.min.js"></script>
<!--menu js-->
<script type="text/javascript" src="${ctxStatic}/js/jquery.menu.js"></script>
<!--/menu js-->
<script type="text/javascript" src="${ctxStatic}/js/jquery.common.js"></script>
<!--除IE外都可识别-->
<!--calendar-->
<script type="text/javascript" src="${ctxStatic}/calendarjs/laydate.js"></script>
<script type="text/javascript" src="${ctxStatic}/js/message.js"></script>
<!--/calendar-->
<!--分页插件 js-->
<script type="text/javascript"
	src="${ctxStatic}/js/jquery.simplePagination.js"></script>
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
			width : 300
		});
		$(".select2").uedSelect({
			width : 150
		});
	});
</script>
<script type="text/javascript">
	var message = "${message}";

	$(function() {
		var mydate = new Date();
		var t = mydate.toLocaleString();
		$("#end").text(t);
	})

	//修改角色
	function upRole() {
		var len = $("#ids[type='checkbox']:checked").length;
		if (len <= 0) {
			alert("请选择后再操作");
		} else if (len > 1) {
			alert("请选择一个角色");
		} else {
			$("#ids[type='checkbox']:checked").each(function() {
				var s = $(this).val();
				window.location.href = "${ctx}/role/upRole?ids=" + s;
			});
		}

	}
	/** 删除角色 */
	function delRol() {
		var len = $("#ids[type='checkbox']:checked").length;
		if (len <= 0) {
			alert("请选择后再操作");
		} else {
			var s = "?ids=";
			$("#ids[type='checkbox']:checked").each(function() {
				s += $(this).val() + ",";
			});
			s = s.substring(0, s.length - 1);
			window.location.href = "${ctx}/role/delRol" + s;
		}
	}
</script>
<!--/select options-->
</head>
<body>
	<!--当前位置-->
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>首页</li>
			<li>系统设置</li>
			<li>权限设置</li>
		</ul>
	</div>
	<!--/当前位置-->

	<div class="mainindex" id="mainindex">
		<div class="maincon">
			<!--btns-->
			<ul class="btnOptions">
				<li><a href="${ctx}/role/saUs"><img
						src="${ctxStatic}/images/btn-add.jpg" width="75" height="35" /></a></li>
				<li><a href="javascript:void(0);" onclick="upRole()"><img
						src="${ctxStatic}/images/btn-edit.jpg" width="75" height="35" /></a></li>
				<li><a href="javascript:void(0);" onclick="delRol()"><img
						src="${ctxStatic}/images/btn-del.jpg" width="75" height="35" /></a></li>

			</ul>
			<!--/btns-->
			<!--列表信息-->
			<div class="ziliaobox">

				<form name="del" method="post" action="#">
					<table width="100%" class="zltab" border="0" cellspacing="0"
						cellpadding="0">
						<tr class="tr0">
							<td width="4%" class="tdc"><input name="chkAll"
								type="checkbox" id="chkAll" onclick=CheckAll(this.form)
								value="checkbox"></td>
							<td width="4%" class="tdc">序号</td>
							<td width="10%">角色</td>
							<td width="20%">描述</td>
							<td width="56%">权限</td>
							<td width="15%">状态</td>
						</tr>
						<c:if test="${page.list != null && page.list.size() > 0 }">
							<c:forEach items="${page.list}" var="role" varStatus="index">
								<tr class="tr1">
									<td class="tdc"><input id="ids" name='ids' type='checkbox'
										onClick="unselectall()" value='${role.id}'></td>
									<td class="tdc">${index.count}</td>
									<td>${role.role}</td>
									<td>${role.description}</td>
									<td><c:if
											test="${role.descriptions != null && role.descriptions.size() > 0}">
											<c:forEach items="${role.descriptions}" var="description">
											${description} &nbsp;
										</c:forEach>
										</c:if></td>
									<td><c:if test="${role.isDel == 1}">
											启用
										</c:if> <c:if test="${role.isDel == 0}">
											禁用
										</c:if></td>
								</tr>
							</c:forEach>
						</c:if>
						<tr class="tr2">
							<td colspan="12">
								<div id="paging1" class="page" style="float: right"></div>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<!--/列表信息-->
		</div>
	</div>

	<div class="popupLayerL">
		<div id="blkh1" class="Mapdetails">
			<div class="detail-main">
				<a href="javascript:void(0)" class="closed1"></a>
				<div class="list_more">
					<img src="${ctxStatic}/images/u15.png" width="680" height="455">
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="${ctxStatic}/js/popup_layer.js"></script>
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
	<script type="text/javascript">
		/* $(function() {
			$("#paging1").pagination({
				items : 100,
				itemsOnPage : 10,
				cssStyle : 'compact-theme'
			});
		}); */

		$(function() {
			$("#paging1").pagination({
				items : '${page.totalCount}', //总数量
				itemsOnPage : '${page.pageSize}', //每页多少条
				currentPage : '${page.currPage}',
				cssStyle : 'compact-theme',
				onPageClick : function(pageNumber, event) {
					location.href = '${ctx}/role?page=' + pageNumber
				}
			});
		});
	</script>
	<script type="text/javascript">
		!function() {
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({
				elem : '#bianzhi'
			});//绑定元素
		}();

		//日期范围限制
		var start = {
			elem : '#start',
			format : 'YYYY-MM-DD',
			min : laydate.now(), //设定最小日期为当前日期
			max : '2099-06-16', //最大日期
			istime : true,
			istoday : false,
			choose : function(datas) {
				end.min = datas; //开始日选好后，重置结束日的最小日期
				end.start = datas //将结束日的初始值设定为开始日
			}
		};

		var end = {
			elem : '#end',
			format : 'YYYY-MM-DD',
			min : laydate.now(),
			max : '2099-06-16',
			istime : true,
			istoday : false,
			choose : function(datas) {
				start.max = datas; //结束日选好后，充值开始日的最大日期
			}
		};
		laydate(start);
		laydate(end);
	</script>
	<%-- <script type="text/javascript"
		src="${ctxStatic}/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctxStatic}/js/jquery.min.js"></script> --%>
</body>

</html>
