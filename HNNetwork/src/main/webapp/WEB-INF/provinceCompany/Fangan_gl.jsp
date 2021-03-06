<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<style>
.subTr1 {
	display: none;
}

.subTr1.active {
	display: table-row;
}
</style>
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
		<ul class="placeul">
			<li>首页</li>
			<li>省公司体系同业对标基本管理</li>
			<li>预警分析</li>
			<li><font color="red"><strong>待添加中</strong></font></li>
		</ul>
	</div>
	<!--/当前位置-->

	<!-- <div class="mainindex" id="mainindex">
		<div class="maincon">
			btns
			<ul class="btnOptions">
          <li><a href="Fangan_lr.html"><img src="${ctxStatic}/images/btn-lr.jpg" width="75" height="35" /></a></li>
          <li><a href="Fangan_lr.html"><img src="${ctxStatic}/images/btn-edit.jpg" width="75" height="35" /></a></li>
          <li><a href="#"><img src="${ctxStatic}/images/btn-del.jpg" width="75" height="35" /></a></li>
          <li><a href="#"><img src="${ctxStatic}/images/btn-daoc.jpg" width="75" height="35" /></a></li>
        </ul>
			/btns
			列表信息
			<div class="ziliaobox">
				<table width="100%" class="zltab" border="0" cellspacing="0"
					cellpadding="0">

					<tr class="tr1">
						<td width="20%" class="tdc2">查询年份：</td>
						<td width="30%"><select class="select1">
								<option>2017</option>
								<option>2016</option>
								<option>2015</option>
						</select></td>
						<td width="20%" class="tdc2">季度</td>
						<td width="30%"><select class="select1">
								<option>第一季度</option>
								<option>上半年</option>
								<option>第三季度</option>
								<option>全年</option>
						</select></td>
					</tr>
					<tr class="tr1">
						<td colspan="4"><a href="javascript:void(0);"
							style="float: right;" target="_blank" class="longred">查询</a></td>
					</tr>
				</table>
				<form name="del" method="post" action="#">
					<table width="100%" class="zltab" border="0" cellspacing="0"
						cellpadding="0">
						<tr class="tr0">
							<td width="4%"></td>
							<td width="5%">序号</td>
							<td width="30%" colspan="2" class="tdc">指标名</td>
							<td width="6%">目标值</td>
							<td width="6%">实际值</td>
							<td width="6%">目标段位</td>
							<td width="6%">实际段位</td>
							<td width="12%">预警等级</td>
							<td width="20%">预警原因</td>
						</tr>
						<tr class="tr1">
							<td class="tdc"><a href="javascript:void(0);"
								onclick="openTr($(this))" class="longred"
								style="width: 20px; height: 18px; font-size: 10px; padding: 0; border-radius: 30px; font-size: 18px; line-height: 18px;">+</a></td>
							<td>1</td>
							<td width="15%">一级指标</td>
							<td width="15%"></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr class="tr1 subTr1">
							<td></td>
							<td></td>
							<td></td>
							<td>二级指标</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr class="tr2">
                <td colspan="8">
                	<div id="paging1" class="page" style="float:right"></div>
                </td>
              </tr>
					</table>
					<table width="100%" class="zltab" border="0" cellspacing="0"
						cellpadding="0">
						<tr class="tr1">
							<td width="4%" class="tdc"><a href="javascript:void(0);"
								onclick="openTr($(this))" class="longred"
								style="width: 20px; height: 18px; font-size: 10px; padding: 0; border-radius: 30px; font-size: 18px; line-height: 18px;">+</a></td>
							<td width="5%">2</td>
							<td width="15%">一级指标</td>
							<td width="15%"></td>
							<td width="6%"></td>
							<td width="6%"></td>
							<td width="6%"></td>
							<td width="6%"></td>
							<td width="12%"></td>
							<td width="20%"></td>
						</tr>
						<tr class="tr1 subTr1">
							<td></td>
							<td></td>
							<td></td>
							<td>二级指标</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr class="tr2">
                <td colspan="8">
                	<div id="paging1" class="page" style="float:right"></div>
                </td>
              </tr>
					</table>
				</form>
			</div>
			/列表信息
		</div>
	</div> -->

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
		function openTr(This) {
			console.log(This)
			This.parents(".tr1").siblings(".subTr1").toggleClass("active");
			This.parents("table").siblings().find(".subTr1").removeClass(
					"active");
			if (This.text() == "+") {
				This.text("-")
			} else {
				This.text("+")
			}
			This.parents("table").siblings().find("a").text("+");
		}
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
