<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录</title>
<link href="${ctxStatic}/css/style_login.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div class="wrap">
		<div class="box_login">
			<form method="post" action="${ctx}/sys/login">
				<ul class="logins">
					<li>
						<div class="pic">
							<img src="${ctxStatic}/images/userbg-login.png" width="41"
								height="41" />
						</div>
						<div class="inputbox">
							<input type="text" name="username" id="username"
								placeholder="请输入用户名" />
						</div>
					</li>
					<li>
						<div class="pic">
							<img src="${ctxStatic}/images/passbg.png" width="41" height="41" />
						</div>
						<div class="inputbox">
							<input type="password" name="password" id="password"
								placeholder="请输入密码" />
						</div>
					</li>
					<li class="okbut"><input name="" type="submit" value="登录" /></li>
					<!-- onclick="javascript:window.location.href='main.html'"  -->
				</ul>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		window.onload = function() {
			var message = '${message}';
			if (message != '') {
				alert(message);
			}
		}
	</script>
	<script type="text/javascript"
		src="${ctxStatic}/js/jquery-1.11.2.min.js"></script>
</body>
</html>