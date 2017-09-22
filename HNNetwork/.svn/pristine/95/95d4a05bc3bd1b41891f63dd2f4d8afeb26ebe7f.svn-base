<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>附件上传插件</title>
<!-- jquery插件 -->
<script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
<!-- js附件上传插件 -->
<script src="${pageContext.request.contextPath}/static/js/ajaxfileupload.js"></script>
<script type="text/javascript">
	function ajaxFileUpload() {
		loading();//动态加载小图标 
		$.ajaxFileUpload({
			url : '${pageContext.request.contextPath}/excel/gradeFileUp',
			secureuri : false,
			fileElementId : 'file',
			dataType : 'json',
			success : function(data, status) {
				if (typeof (data.msg) != 'undefined') {
					if (data.error != '') {
						alert(data.error);
					} else {
						alert(data.msg);
					}
				}
			},
			error : function(data, status, e) {
				alert(e);
			}
		})
		return false;
	}
	function loading() {
		$("#loading ").ajaxStart(function() {
			$(this).show();
		}).ajaxComplete(function() {
			$(this).hide();
		});
	}
</script>
</head>
<body>
	<input id="fileToUpload " type="file" size="20" name="file "
		class="input">
	<button class="button" id="buttonUpload"
		onclick="return ajaxFileUpload();">上传</button>
</body>
</html>