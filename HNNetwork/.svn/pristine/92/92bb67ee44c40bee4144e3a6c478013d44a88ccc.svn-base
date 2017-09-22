<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<script type="text/javascript">
	$(function() {
		var mydate = new Date();
		var t = mydate.toLocaleString();
		$("#end").text(t);
	})
</script>

<!-- 表单提交数据校验 -->
<script type="text/javascript">
	function checkOut() {
		//6-20个字符
		var p1 = /^(\w){4,20}$/;
		//数字字母汉字均可
		var p2 = /[A-Za-z0-9\u4e00-\u9fa5]+/;

		//用户名
		var username = $("input[name='username']").val();
		if (!p1.exec(username)) {
			$("#username").html("<font color='red'>6-20位长度的字母</font>");
			//alert("请输入用户名为6-20位长度的字母");
			//$.message.alert("","请输入用户名为6-20位长度的字母","info");
			return false;
		} else {
			$("#username").html("");
		}
		//昵称
		var nickname = $("input[name='nickname']").val();
		if (!p2.exec(nickname)) {
			//alert("请输入昵称");
			$("#nickname").html("<font color='red'>请输入用户名</font>");
			return false;
		} else {
			$("#nickname").html("");
		}
		//密码
		var password = $("input[name='password']").val();
		var rePassword = $("input[name='rePassword']").val();
		if (password != rePassword) {
			//alert("两次密码不一致");
			$("#rePassword").html("<font color='red'>两次密码不一致</font>");
			return false;
		} else {
			$("#rePassword").html("");
		}

		if (!p1.exec(password)) {
			//	alert("请输入密码,6-20位长度的字母");
			$("#password").html("<font color='red'>6-20位长度的字母</font>");
			return false;
		} else {
			$("#password").html("");
		}

		if (!p1.exec(rePassword)) {
			alert("请再次输入密码,6-20位长度的字母");
			$("#rePassword").html("<font color='red'>6-20位长度的字母</font>");
			return false;
		} else {
			$("#rePassword").html("");
		}
		return true;
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
			<li>用户管理</li>
			<li>添加</li>
		</ul>
	</div>
	<!--/当前位置-->
	<div class="mainindex" id="mainindex">
		<div class="maincon">
			<!--列表信息-->
			<div class="ziliaobox">
				<form action="${ctx}/user/adU" method="post"
					onsubmit="return checkOut()">
					<table width="100%" class="zltab" border="0" cellspacing="0"
						cellpadding="0">

						<tr class="tr0">
							<td colspan="2" class="tdc">添加用户信息</td>
						<tr class="tr1">
							<td width="20%" style="text-align: right">登录名：</td>
							<td width="80%"><input name="username"
								value="${user.username}" type="text" class="dfinput"
								style="width: 85%;" placeholder="" /> <span id="username"></span>
							</td>
						</tr>
						<tr class="tr1">
							<td width="20%" style="text-align: right">用户名：</td>
							<td width="80%"><input name="nickname"
								value="${user.nickname}" size="12" type="text" class="dfinput"
								style="width: 85%;" placeholder="" /> <span id="nickname"></span>
							</td>
						</tr>
						<tr class="tr1">
							<td width="20%" style="text-align: right">登录密码：</td>
							<td width="80%"><input name="password"
								value="${user.password}" type="text" class="dfinput"
								style="width: 85%;" placeholder="" /> <span id="password"></span>
							</td>
						</tr>
						<tr class="tr1">
							<td width="20%" style="text-align: right">确认密码：</td>
							<td width="80%"><input name="rePassword"
								value="${user.password}" type="text" class="dfinput"
								style="width: 85%;" placeholder="" /> <span id="rePassword"></span>
							</td>
						</tr>
						<tr class="tr1">
							<td width="20%" style="text-align: right">所属角色：</td>
							<td width="80%"><select class="select1" name="roleIds"
								style="width: 85%">
									<option value="">请选择</option>
									<c:if test="${roles != null && roles.size() > 0}">
										<c:forEach items="${roles}" var="role">
											<option value="${role.id}"
												<c:if test="${user != null && user.roleId != null && user.roleId == role.id}">
													selected="selected"
													</c:if>>
												${role.role}</option>
										</c:forEach>
									</c:if>
							</select></td>
						</tr>
						<tr class="tr1">
							<td width="20%" style="text-align: right">部门：</td>
							<td width="80%"><select class="select1" name="dept"
								style="width: 85%">
									<option value="">请选择</option>
									<c:forEach items="${depts}" var="dept">
										<option value="${dept.name}">${dept.name}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr class="tr1">
							<td width="20%" style="text-align: right">状态：</td>
							<td width="80%"><select class="select1" name="isDel"
								style="width: 85%">
									<option value="1">启用</option>
									<option value="0">禁用</option>
							</select></td>
						</tr>
						<tr class="tr1">
							<td width="20%"></td>
							<td width="80%" colspan="3"><input type="submit" value="保存"
								class="longblue" /> <a
								onclick="window.location.href='${ctx}/user?page=1&limit=2'"
								class="longgrey">取消 </a></td>
							<!-- <tr class="tr1">
						<td width="20%"></td>
						<td width="80%" colspan="3"><a href="Zhengshu_gl.html"
							class="longblue">保存 </a> <a onclick="history.go(-1)"
							class="longgrey">取消 </a></td>
					</tr> -->
					</table>
				</form>
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
		var message = "${message}";
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
	<script type="text/javascript" src="${ctxStatic}/js/message.js"></script>
	<script type="text/javascript"
		src="${ctxStatic}/js/jquery.easyui.min.js"></script>
</body>

</html>
