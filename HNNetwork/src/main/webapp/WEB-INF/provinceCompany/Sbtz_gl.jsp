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
			width : 300
		});
		$(".select2").uedSelect({
			width : 150
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
		<ul class="placeul">
			<li>首页</li>
			<li>省公司体系同业对标基本管理</li>
			<li><font color="red"><strong>待添加中</strong></font></li>
		</ul>
	</div>
	<!--/当前位置-->

	<%-- <div class="mainindex" id="mainindex">
		<div class="maincon">
			<!--btns-->
			<ul class="btnOptions">
				<li><a href="Sbtz_new.html"><img src="${ctxStatic}/images/btn-new.jpg"
						width="75" height="35" /></a></li>
				<li id="searchbtn"><img src="${ctxStatic}/images/btn-sear.jpg" width="75"
					height="35" /></li>
				<li id="daorubtn"><img src="${ctxStatic}/images/btn-daor.jpg" width="75"
					height="35" /></li>
				<li><a href="#"><img src="${ctxStatic}/images/btn-daoc.jpg" width="75"
						height="35" /></a></li>
				<li><a href="#"><img src="${ctxStatic}/images/download.png" width="75"
						height="35" /></a></li>

			</ul>
			<!--/btns-->
			<!--列表信息-->
			<div class="ziliaobox">

				<table width="100%" class="zltab" border="0" cellspacing="0"
					cellpadding="0" id="daorutable" style="display: none">
					<tr class="tr0">
						<td colspan="4" class="tdc">资料导入</td>
					</tr>
					<tr class="tr1">
						<td width="10%" class="tdc2">上传文件：</td>
						<td width="90%" colspan="5"><input name="" type="text"
							class="dfinput" style="width: 80%; float: left" /> <a href="#"
							class="longgrey">上传</a></td>
					</tr>
					</tr>
					<tr class="tr1">
						<td width="10%"></td>
						<td width="90%" colspan="3"><a href="#" target="_blank"
							class="longred">确定</a></td>
					</tr>
				</table>
				<table width="100%" class="zltab" border="0" cellspacing="0"
					cellpadding="0" id="searchtable" style="display: none">
					<tr class="tr0">
						<td colspan="6" class="tdc">查询条件</td>
						<tr class="tr1">
							<td width="10%" class="tdc2">所属单位：</td>
							<td width="20%"><select class="select2">
									<option>请选择变单位名称</option>
							</select></td>
							<td width="10%" class="tdc2">保管单位：</td>
							<td width="20%"><select class="select2">
									<option>请选择保管单位</option>
							</select></td>
							<td width="10%" class="tdc2">设备状态：</td>
							<td width="30%"><select class="select2">
									<option>全部</option>
							</select></td>
						</tr>
						<tr class="tr1">
							<td width="10%" class="tdc2">设备一级分类：</td>
							<td width="20%"><select class="select2">
									<option>全部</option>
							</select></td>
							<td width="10%" class="tdc2">设备二级分类：</td>
							<td width="20%"><select class="select2">
									<option>全部</option>
							</select></td>
							<td width="10%" class="tdc2">到期日期：</td>
							<td width="30%"><input class="inline laydate-icon"
								id="start" style="width: 150px"></td>
						</tr>
						<tr class="tr1">
							<td width="10%"></td>
							<td width="90%" colspan="5"><a href="#" target="_blank"
								class="longred">查询</a></td>
						</tr>
				</table>
				<table width="100%" class="zltab" border="0" cellspacing="0"
					cellpadding="0">
					<tr class="tr0">
						<td width="4%" class="tdc">序号</td>
						<td width="9%">所属单位</td>
						<td width="9%">保管单位</td>
						<td width="9%">设备一级分类</td>
						<td width="9%">设备二级分类</td>
						<td width="9%">设备名称</td>
						<td width="9%">设备状态</td>
						<td width="9%">生产厂家</td>
						<td width="9%">生产日期</td>
						<td width="8%">是否到期</td>
						<td width="8%">台账状态</td>
						<td width="8%">操作</td>
					</tr>
					<tr class="tr1">
						<td class="tdc">1</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href="Sbtz_new.html">详细</a></td>
					</tr>
					<tr class="tr1">
						<td class="tdc">2</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href="Sbtz_new.html">详细</a></td>
					</tr>
					<tr class="tr2">
						<td colspan="12">
							<div id="paging1" class="page" style="float: right"></div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div> --%>

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
</body>

</html>
