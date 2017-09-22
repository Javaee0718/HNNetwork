<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
<script type="text/javascript" src="${ctxStatic}/js/select-ui.min.js"></script>
<!--menu js-->
<script type="text/javascript" src="${ctxStatic}/js/jquery.menu.js"></script>
<script type="text/javascript" src="${ctxStatic}/js/message.js"></script>
<!--/menu js-->
<script type="text/javascript" src="${ctxStatic}/js/jquery.common.js"></script>
<!--除IE外都可识别-->
<!--calendar-->
<script type="text/javascript" src="${ctxStatic}/calendarjs/laydate.js"></script>
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
			width : 500
		});
	});
</script>
<!--/select options-->
<!-- 表单提交数据校验 -->
<script type="text/javascript">
	var message = "${message}";
	function checkOut() {
		//6-20个字符
		var p2 = /^(\w){2,}$/;
		//数字字母汉字均可
		var p1 = /[A-Za-z0-9\u4e00-\u9fa5]+/;

		//用户名
		var role = $("input[name='role']").val();
		if (!p1.exec(role)) {
			$("#role").html("<font color='red'>长度最短为2个字符</font>")
			return false;
		} else {
			$("#role").html("");
		}
	}
</script>
</head>
<body>
	<!--当前位置-->
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>首页</li>
			<li>系统设置</li>
			<li>权限设置</li>
			<li>修改</li>
		</ul>
	</div>
	<!--/当前位置-->
	<div class="mainindex" id="mainindex">
		<div class="maincon">
			<!--列表信息-->
			<div class="ziliaobox">
				<table width="100%" class="zltab" border="0" cellspacing="0"
					cellpadding="0">
					<tr class="tr0">
						<td colspan="2" class="tdc">添加角色信息</td>
						<form action="${ctx}/role/upRole" method="post"
							onsubmit="return checkOut()">
							<tr class="tr1">

								<td width="20%" style="text-align: right">角色名称：</td>
								<td width="80%"><input type="hidden" name="id"
									value="${role.id}"> <input name="role" type="text"
									class="dfinput" value="${role.role}" style="width: 85%;"
									placeholder="" /> <span id="role"></span></td>
							</tr>
							<tr class="tr1">
								<td width="20%" style="text-align: right">角色描述：</td>
								<td width="80%"><input name="description"
									value="${role.description}" type="text" class="dfinput"
									style="width: 85%;" placeholder="" /></td>
							</tr>
							<tr class="tr1">
								<td width="20%" style="text-align: right">部门权限：</td>
								<td width="80%"><c:if
										test="${deptRole != null && deptRole.size() > 0}">
										<c:forEach items="${deptRole}" var="dept">
											<c:set value="0" var="isExists"></c:set>
											<c:if test="${role.auths != null && role.auths.size() > 0}">
												<c:forEach items="${role.auths}" var="auth">
													<c:if test="${auth.id == dept.id}">
														<c:set value="1" var="isExists"></c:set>
													</c:if>
												</c:forEach>
												<c:if test="${isExists == 1}">
													<input name='authIds' type='checkbox' checked="checked"
														value='${dept.id}'> ${dept.description}
										</c:if>
												<c:if test="${isExists == 0}">
													<input name='authIds' type='checkbox' value='${dept.id}'> ${dept.description}
										</c:if>
											</c:if>
										</c:forEach>
									</c:if></td>
							</tr>
							<tr class="tr1">
								<td width="20%" style="text-align: right">省内其他公司权限：</td>
								<td width="80%"><c:if
										test="${otherRegion != null and otherRegion.size() > 0}">
										<c:forEach items="${otherRegion}" var="region">
											<c:set value="0" var="isExists"></c:set>
											<c:if test="${role.auths != null && role.auths.size() > 0}">
												<c:forEach items="${role.auths}" var="auth">
													<c:if test="${auth.id == region.id}">
														<c:set value="1" var="isExists"></c:set>
													</c:if>
												</c:forEach>
											</c:if>
											<c:if test="${isExists == 1}">
												<input name='authIds' type='checkbox' checked="checked"
													value='${region.id}'> ${region.description}
										</c:if>
											<c:if test="${isExists == 0}">
												<input name='authIds' type='checkbox' value='${region.id}'> ${region.description}
									</c:if>
										</c:forEach>
									</c:if></td>
							</tr>
							<tr class="tr1">
								<td width="20%" style="text-align: right">全国各省份权限：</td>
								<td width="80%"><c:if
										test="${outOfPro != null && outOfPro.size() > 0}">
										<c:forEach items="${outOfPro}" var="pro">

											<c:set value="0" var="isExists"></c:set>
											<c:if test="${role.auths != null && role.auths.size() > 0}">
												<c:forEach items="${role.auths}" var="auth">
													<c:if test="${auth.id == pro.id}">
														<c:set value="1" var="isExists"></c:set>
													</c:if>
												</c:forEach>
											</c:if>
											<c:if test="${isExists == 1}">
												<input name='authIds' type='checkbox' checked="checked"
													value='${pro.id}'> ${pro.description}
										</c:if>
											<c:if test="${isExists == 0}">
												<input name='authIds' type='checkbox' value='${pro.id}'> ${pro.description}
									</c:if>


										</c:forEach>
									</c:if></td>
							</tr>
							<tr class="tr1">
								<td width="20%" style="text-align: right">状态：</td>
								<td width="80%">
									<!-- <select class="select1" name="isDel" --> <select
									name="isDel" style="width: 300px;opacity:1!important;height: 30px;">
										<option value="1"
											<c:if test="${role.isDel == 1}">selected="selected"</c:if>>启用</option>
										<option value="0"
											<c:if test="${role.isDel == 0}">selected="selected"</c:if>>禁用</option>
								</select>
								</td>
							</tr>
							<tr class="tr1">
								<td width="20%"></td>
								<td width="80%" colspan="3"><input type="submit" value="保存"
									class="longblue"> <!-- <a href="Zhengshu_gl.html"
										class="longblue">保存</a>  --> <!-- <a onclick="history.go(-1)"
										class="longgrey">取消</a> --> <a href="${ctx}/role"
									class="longgrey">取消</a></td>
							</tr>
						</form>
				</table>
			</div>
			<!--/列表信息-->
		</div>
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
	<script type="text/javascript">
		$(function() {
			$("#paging1").pagination({
				items : 100,
				itemsOnPage : 10,
				cssStyle : 'compact-theme'
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

		var start2 = {
			elem : '#start2',
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
		laydate(start2);
		laydate(end);
	</script>
	<%-- <script type="text/javascript"
		src="${ctxStatic}/js/jquery.easyui.min.js"></script> --%>
</body>

</html>
