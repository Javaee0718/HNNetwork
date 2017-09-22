<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国网河南电力公司 同业对标精益化管理系统</title>
</head>
<style>
body, html {
	overflow: hidden;
}
</style>
<script src="${ctxStatic}/js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/js/jquery.common.js" type="text/javascript"></script>
<!--height Resize js-->
<script type="text/javascript">
	$(document).ready(function() {
		windowResize();
		$(window).resize(function() {
			windowResize();
		});
		document.getElementById('leftFrame').src = "${ctx}/incl/main/left";
	});
</script>
<!--/height Resize js-->
<body leftmargin=0 topmargin=0 rightmargin=0>
	<center>
		<iframe frameborder="0" id="carnoc" name="carnoc" scrolling="no"
			src="${ctx}/incl/main/top"
			style="height: 88px; visibility: inherit; width: 100%; z-index: 2">
		</iframe>
	</center>
</body>

<body scroll=no>
	<!--左侧显示隐藏 脚本-->
	<script type="text/javascript">
		function switchsysbar() {
			var obj = document.getElementById("switchpoint");
			var mains = document.getElementById("mainFrame");
			if ((obj.innertext == 3) || (obj.innertext == null)) {
				obj.innertext = 4;
				document.all("frmtitle").style.display = "none";
				obj.src = "${ctxStatic}/images/left-displaynone.jpg";
			} else {
				obj.innertext = 3;
				document.all("frmtitle").style.display = "";
				obj.src = "${ctxStatic}/images/left-display.jpg";
			}
		}
	</script>
	<!--/左侧显示隐藏 脚本-->
	<table border="0" cellpadding="0" cellspacing="0" height="100%"
		width="100%">
		<tr>
			<td align="middle" nowrap valign="top" id="frmtitle"><iframe
					frameborder="0" id="leftFrame" name="leftFrame" src="${ctx}/incl/main/left"
					style="height: 100%; overflow-y: auto; overflow-x: hidden; visibility: inherit; width: 240px; z-index: 2">
				</iframe></td>
			<td style="background-color: #00a59e;" id="midheight" valign="middle">
				<div class="midheight" id="banicon">
					<img src="${ctxStatic}/images/left-display.jpg" alt="" width="8"
						id="switchpoint" height="78" onClick="switchsysbar()"
						style="cursor: pointer;" />
				</div>
			</td>
			<td style="width: 100%" valign="top"><iframe frameborder="0"
					id="mainFrame" name="mainFrame" scrolling="yes" src="${ctx}/incl/main/index"
					style="height: 100%; visibility: inherit; width: 100%; z-index: 2"></iframe>
			</td>
		</tr>
	</table>
	<script>
		if (window.screen.width < '1024') {
			switchsysbar()
		}
	</script>
</body>
<body leftmargin=0 topmargin=0 rightmargin=0>
	<center>
		<iframe frameborder="0" id="carnoc" name="carnoc" scrolling="no"
			src="${ctx}/incl/main/foot"
			style="height: 37px; visibility: inherit; width: 100%; z-index: 2">
		</iframe>
	</center>
</body>
</html>