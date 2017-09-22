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
<style>
.otherTr {
	display: none;
}

.otherTr.active {
	display: table-row;
}

.subTr1 {
	display: none;
}

.subTr1.active {
	display: table-row;
}
</style>
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
			<li>国网体系同业对标基本管理</li>
			<li>数据管理</li>
			<li><font color="red"><strong>待添加中</strong></font></li>
		</ul>
	</div>
	<!--/当前位置-->

	<!-- <div class="mainindex" id="mainindex">
		<div class="maincon">
			btns
			<ul class="btnOptions">
          <li><a href="Fangan_add.html"><img src="${ctxStatic}/images/btn-add.jpg" width="75" height="35" /></a></li>
          <li><a href="Fangan_add.html"><img src="${ctxStatic}/images/btn-edit.jpg" width="75" height="35" /></a></li>
          <li><a href="#"><img src="${ctxStatic}/images/btn-del.jpg" width="75" height="35" /></a></li>
        </ul>
			/btns
			列表信息
			<div class="ziliaobox">
				<table width="100%" class="zltab" border="0" cellspacing="0"
					cellpadding="0">

					<tr class="tr1">
						<td width="10%" class="tdc2">板块：</td>
						<td width="20%"><select class="select1" style="width: 85%">
								<option>请选择板块</option>
								<option>板块1</option>
								<option>板块1</option>
								<option>板块1</option>
						</select></td>
						<td width="10%" class="tdc2">指标名称：</td>
						<td width="20%"><select class="select1" style="width: 85%">
								<option>请选择指标名称</option>
								<option>指标名1</option>
								<option>指标名2</option>
								<option>指标名3</option>
						</select></td>
						<td width="10%" class="tdc2">属性：</td>
						<td width="20%"><select class="select1" style="width: 85%">
								<option>请选择属性</option>
								<option>属性1</option>
								<option>属性2</option>
								<option>属性3</option>
						</select></td>
					</tr>
					<tr class="tr1 otherTr">
						<td class="tdc2">牵头部门：</td>
						<td><select class="select1" style="width: 85%">
								<option>请选择牵头部门</option>
								<option>牵头部门1</option>
								<option>牵头部门2</option>
								<option>牵头部门3</option>
						</select></td>

						<td class="tdc2">发布周期：</td>
						<td><select class="select1">
								<option>请选择发布周期</option>
								<option>发布周期1</option>
								<option>发布周期2</option>
								<option>发布周期3</option>
						</select></td>
						<td class="tdc2">评价方式：</td>
						<td><select class="select1">
								<option>请选择评价方式</option>
								<option>评价方式1</option>
								<option>评价方式2</option>
								<option>评价方式3</option>
						</select></td>
					</tr>
					<tr class="tr1 otherTr">
						<td class="tdc2">正反向：</td>
						<td><select class="select1" style="width: 85%">
								<option>请选择正反向</option>
								<option>正向</option>
								<option>反向</option>
						</select></td>

						<td class="tdc2">指标类别：</td>
						<td><select class="select1">
								<option>请选择指标类别</option>
								<option>100</option>
								<option>50</option>
						</select></td>
						<td class="tdc2">指标单位：</td>
						<td><select class="select1">
								<option>请选择指标单位</option>
								<option>指标单位1</option>
								<option>指标单位2</option>
								<option>指标单位3</option>
						</select></td>
					</tr>
					<tr class="tr1 otherTr">
						<td class="tdc2">查询年份：</td>
						<td><select class="select1">
								<option>2017</option>
								<option>2016</option>
								<option>2015</option>
						</select></td>
						<td class="tdc2">季度</td>
						<td><select class="select1">
								<option>第一季度</option>
								<option>上半年</option>
								<option>第三季度</option>
								<option>全年</option>
						</select></td>
					</tr>

					<tr class="tr1">
						<td colspan="3"><a href="javascript:void(0);" target="_blank"
							onclick="displayMore($(this))" style="margin-left: 50px;">展开</a>
						</td>
						<td colspan="3">
							<div style="float: right">
								<a href="javascript:void(0);" target="_blank" class="longred">导入</a>
								<a href="javascript:void(0);" target="_blank" class="longred">查询</a>
								<a href="javascript:void(0);" target="_blank" class="longred">模板导出</a>

							</div>
						</td>
					</tr>
				</table>
				<form name="del" method="post" action="#">
					<table width="100%" class="zltab" border="0" cellspacing="0"
						cellpadding="0">
						<tr class="tr0">
							<td width="3%" class="tdc"></td>
							<td width="3%">序号</td>
							<td width="5%">板块</td>
							<td width="5%">指标名称</td>
							<td width="5%">属性</td>
							<td width="5%">牵头部门</td>
							<td width="5%">发布周期</td>
							<td width="5%">评价方式</td>
							<td width="5%">正反向</td>
							<td width="5%">指标满分</td>
							<td width="5%">指标单位</td>
							<td width="5%">指标类型</td>
							<td width="5%">当年目标段位</td>
							<td width="5%">当年目标得分</td>
							<td width="5%">当年目标值</td>
							<td width="5%">考核底线段位</td>
							<td width="5%">考核底线得分</td>
							<td width="5%">实际段位</td>
							<td width="5%">实际得分</td>
							<td width="5%">实际值</td>
							<td width="5%">指标排名</td>
						</tr>
						<tr class="tr1">
							<td class="tdc"><a href="javascript:void(0);"
								onclick="openTr($(this))" class="longred"
								style="width: 20px; height: 18px; font-size: 10px; padding: 0; border-radius: 30px; font-size: 18px; line-height: 18px;">+</a></td>
							<td>1</td>
							<td>人力管理</td>
							<td>人力资源计划完成率</td>
							<td>管理</td>
							<td>人资部</td>
							<td>半年</td>
							<td>普通</td>
							<td>正向</td>
							<td>5</td>
							<td>%</td>
							<td>计划质量与控制类</td>
							<td>A</td>
							<td>5</td>
							<td>98%</td>
							<td>B</td>
							<td>3.75</td>
							<td>实际段位</td>
							<td>实际得分</td>
							<td>实际值</td>
							<td>查看详细</td>
						</tr>
						<tr class="tr1 subTr1">
							<td></td>
							<td></td>
							<td></td>
							<td>二级指标</td>
							<td>管理</td>
							<td>人资部</td>
							<td>半年</td>
							<td>普通</td>
							<td>正向</td>
							<td>5</td>
							<td>%</td>
							<td>计划质量与控制类</td>
							<td>A</td>
							<td>5</td>
							<td>98%</td>
							<td>B</td>
							<td>3.75</td>
							<td>实际段位</td>
							<td>实际得分</td>
							<td>实际值</td>
							<td><a href="Fangan_mbdetails.html">查看详细</a></td>
						</tr>
						<tr class="tr1 subTr1">
							<td></td>
							<td></td>
							<td></td>
							<td>二级指标</td>
							<td>管理</td>
							<td>人资部</td>
							<td>半年</td>
							<td>普通</td>
							<td>正向</td>
							<td>5</td>
							<td>%</td>
							<td>计划质量与控制类</td>
							<td>A</td>
							<td>5</td>
							<td>98%</td>
							<td>B</td>
							<td>3.75</td>
							<td>实际段位</td>
							<td>实际得分</td>
							<td>实际值</td>
							<td><a href="Fangan_mbdetails.html">查看详细</a></td>
						</tr>
					</table>
					一个一级指标
					<table width="100%" class="zltab" border="0" cellspacing="0"
						cellpadding="0">
						<tr class="tr1">
							<td width="3%" class="tdc"><a href="javascript:void(0);"
								onclick="openTr($(this))" class="longred"
								style="width: 20px; height: 18px; font-size: 10px; padding: 0; border-radius: 30px; font-size: 18px; line-height: 18px;">+</a></td>
							<td width="3%">1</td>
							<td width="5%">人力管理</td>
							<td width="5%">人力资源计划完成率</td>
							<td width="5%">管理</td>
							<td width="5%">人资部</td>
							<td width="5%">半年</td>
							<td width="5%">普通</td>
							<td width="5%">正向</td>
							<td width="5%">5</td>
							<td width="5%">%</td>
							<td width="5%">计划质量与控制类</td>
							<td width="5%">A</td>
							<td width="5%">5</td>
							<td width="5%">98%</td>
							<td width="5%">B</td>
							<td width="5%">3.75</td>
							<td width="5%">实际段位</td>
							<td width="5%">实际得分</td>
							<td width="5%">实际值</td>
							<td width="5%">查看详细</td>
						</tr>
						<tr class="tr1 subTr1">
							<td></td>
							<td></td>
							<td></td>
							<td>二级指标</td>
							<td>管理</td>
							<td>人资部</td>
							<td>半年</td>
							<td>普通</td>
							<td>正向</td>
							<td>5</td>
							<td>%</td>
							<td>计划质量与控制类</td>
							<td>A</td>
							<td>5</td>
							<td>98%</td>
							<td>B</td>
							<td>3.75</td>
							<td>实际段位</td>
							<td>实际得分</td>
							<td>实际值</td>
							<td>查看详细</td>
						</tr>
						<tr class="tr1 subTr1">
							<td></td>
							<td></td>
							<td></td>
							<td>二级指标</td>
							<td>管理</td>
							<td>人资部</td>
							<td>半年</td>
							<td>普通</td>
							<td>正向</td>
							<td>5</td>
							<td>%</td>
							<td>计划质量与控制类</td>
							<td>A</td>
							<td>5</td>
							<td>98%</td>
							<td>B</td>
							<td>3.75</td>
							<td>实际段位</td>
							<td>实际得分</td>
							<td>实际值</td>
							<td>查看详细</td>
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
		function displayMore(This) {
			console.log("1")
			$(".otherTr").toggleClass("active");
			if (This.text() == "展开") {
				This.text("收起")
			} else {
				This.text("展开")
			}
		}
	</script>
</body>

</html>
