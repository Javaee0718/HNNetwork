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
<link rel="stylesheet" href="${ctxStatic}/css/jquery.mloading.css">
<!--/menu style-->
<!--分页插件style-->
<link type="text/css" rel="stylesheet"
	href="${ctxStatic}/css/simplePagination.css" />
<!--/分页插件style-->
<script type="text/javascript"
	src="${ctxStatic}/js/jquery-1.11.2.min.js"></script>
<!-- 遮罩插件 -->
<script src="${ctxStatic}/js/jquery.mloading.js"></script>
<!-- 一键上传插件 -->
<script src="${ctxStatic}/js/jquery.ocupload-1.1.2.js"
	type="text/javascript"></script>
<script type="text/javascript" src="${ctxStatic}/js/select-ui.min.js"></script>
<!--menu js-->
<script type="text/javascript" src="${ctxStatic}/js/jquery.menu.js"></script>
<!--/menu js-->
<script type="text/javascript" src="${ctxStatic}/js/jquery.common.js"></script>
<!--除IE外都可识别-->
<!--calendar-->
<script type="text/javascript" src="${ctxStatic}/calendarjs/laydate.js"></script>
<script type="text/javascript" src="${ctxStatic}/js/webuploader.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/css/webuploader.css" />
<!--/calendar-->
<!--分页插件 js-->
<!-- 日期控件 st -->
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/css/pikaday.css" />
<script type="text/javascript" src="${ctxStatic}/js/pikaday.min.js"></script>
<!-- 日期控件 end -->
<script type="text/javascript"
	src="${ctxStatic}/js/jquery.simplePagination.js"></script>
<!--/分页插件 js-->
<!--[if !IE 8]><!--[if !IE 7]><!--[if !IE 6]><!-->
<link href="${ctxStatic}/css/style.css" rel="stylesheet" type="text/css" />
<!-- 文件导入 -->
<script type="text/javascript">
	var message = '${message}';
	$(function() {
		/*init webuploader*/
		var $list = $("#thelist"); //这几个初始化全局的百度文档上没说明，好蛋疼。  
		var $btn = $("#ctlBtn"); //开始上传  
		/* var $filePicker = ${"#filePicker"}; */
		var thumbnailWidth = 100; //缩略图高度和宽度 （单位是像素），当宽高度是0~1的时候，是按照百分比计算，具体可以看api文档  
		var thumbnailHeight = 100;

		var uploader = WebUploader.create({
			// 选完文件后，是否自动上传。  
			auto : false,

			// swf文件路径  
			swf : '${ctxStatic }/swf/Uploader.swf',

			// 文件接收服务端。  
			server : '${ctx}/precision/precisionFile',

			// 选择文件的按钮。可选。  
			// 内部根据当前运行是创建，可能是input元素，也可能是flash.  
			pick : '#filePicker',

			// 只允许选择图片文件。  
			/*  accept: {
			     title: 'Images',
			     extensions: 'gif,jpg,jpeg,bmp,png',
			     mimeTypes: 'image/*'
			 },  */
			method : 'POST',
		});
		/* 附件上传成功  */
		uploader.on('uploadSuccess', function(file, response) {
			alert(response.msg);
		});
		
		// 当有文件添加进来的时候  
		uploader.on(
			'fileQueued',
			function(file) { // webuploader事件.当选择文件后，文件被加载到文件队列中，触发该事件。等效于 uploader.onFileueued = function(file){...} ，类似js的事件定义。  
				var $li = $('<div id="' + file.id + '" class="file-item thumbnail">'
						+ '<img>'
						+ '<div class="info">'
						+ file.name + '</div>' + '</div>'), $img = $li
						.find('img');
				// $list为容器jQuery实例  
				$list.append($li);
		});

		
		 uploader.on( 'uploadComplete', function( file ) {  
			 $list.empty();
		   }); 
		$btn.on('click', function() {
			uploader.upload();
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
<!-- 设置年份 -->
<script type="text/javascript">
	var message = "${message}";
</script>
<style>
#thelist {
	background-color: #fff;
	margin: 10px;
	min-height: 100px;
	max-height: 200px;
	overflow-x: hidden;
	overflow-y: scroll;
}

#filePicker {
	float: left;
	margin-left: 10px;
}

#ctlBtn {
	float: right;
	background: #00b7ee;
	border: none;
	padding: 0;
	width: 86px;
	height: 39px;
	font-weight: normal;
	margin-right: 10px;
}

#ctlBtn3 {
	float: left;
	background: #00b7ee;
	border: none;
	padding: 0;
	width: 86px;
	height: 39px;
	font-weight: normal;
	margin-left: 165px;
}

.file-item {
	padding: 5px 10px;
}

#datepicker {
	position: absolute;
	left: 50%;
	top: 20px;
	margin-left: -80px;
}
</style>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>国网体系同业对标管理</li>
			<li>数据导入</li>
		</ul>
	</div>

	<div
		style="font-size: 14px; width: 600px; height: auto; position: absolute; left: 50%; top: 50px; margin-left: -300px; background-color: #ebebeb; border: 1px solid #000; border-radius: 20px; padding: 10px;">
		<div id="uploader-demo">
			<!--用来存放item-->
			<div id="thelist" class="uploader-list"></div>
			<div>
				<div id="filePicker">选择文档</div>
				<button id="ctlBtn3" class="btn btn-default">
					<a href="${ctx}/model/preciFD">下载模板</a>
				</button>
				<button id="ctlBtn" class="btn btn-default">开始上传</button>
			</div>
		</div>
	</div>
	<div
		style="position: relative; left: 50%; top: 392px; width: 600px; height: auto; margin-left: -300px; background-color: #ebebeb; border: 1px solid #000; border-radius: 20px; padding: 10px;">
		<form action="${ctx}/precision/delDat" method="post" onsubmit="return delDat()">
			<input type="text" id="datepicker" name="date" />
			<div style="margin: 0 auto; width: 300px; padding-top: 50px;">
				<input type="submit" id="ctlBtn1" class="btn btn-default"
					value="删除数据">
				<!-- <button id="ctlBtn1" class="btn btn-default">删除数据</button> -->
				<button id="ctlBtn2" class="btn btn-default">指定日期</button>
				<script type="text/javascript">
					function delDat() {
						var value = $("#datepicker").val();
						if(value) {
							return true;
						} else {
							return false;
						}
					}
				</script>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var picker = new Pikaday({
			field : document.getElementById('datepicker'),
			firstDay : 1,
			minDate : new Date('2010-01-01'),
			maxDate : new Date('2020-12-31'),
			yearRange : [ 2000, 2020 ]
		});
	</script>

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
	<script type="text/javascript" src="${ctxStatic}/js/message.js"></script>
	<link href="${ctxStatic}/css/upload.css" rel="stylesheet"
		type="text/css" />
</body>
</html>