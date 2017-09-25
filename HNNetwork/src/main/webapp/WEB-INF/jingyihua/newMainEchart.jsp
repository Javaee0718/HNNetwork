<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	style="width:100%;height:100%">
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
		<script type="text/javascript"
			src="${ctxStatic}/calendarjs/laydate.js"></script>
		<!--/calendar-->
		<!--分页插件 js-->
		<script type="text/javascript"
			src="${ctxStatic}/js/jquery.simplePagination.js"></script>
		<!--/分页插件 js-->
		<!--[if !IE 8]><!--[if !IE 7]><!--[if !IE 6]><!-->
		<link href="${ctxStatic}/css/style.css" rel="stylesheet"
			type="text/css" />
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
	<div class="maincon" style="overflow: scroll">
		<div class="echartbox">
			<div class="toptitle">
				<span class="titles">2017年09月14日指标监控详情</span>
			</div>
			<div class="echartpicbox">
				<div class="echartpic" id="echart-2"></div>
			</div>
		</div>
		<div class="echartbox">
			<table width="100%" class="zltab" border="0" cellspacing="0"
				cellpadding="0">
				<tr class="tr0">
					<td colspan="4">问题汇总</td>
				</tr>
				<tr class="tr0">
					<td width="20%" class="tdc">指标名</td>
					<td width="20%">牵头部门</td>
					<td width="20%">预警等级</td>
					<td width="40%">预警原因</td>
				</tr>
				<tr class="tr1">
					<td>指标名1</td>
					<td>人资部</td>
					<td>2</td>
					<td>预警原因是。。。</td>
				</tr>
				<tr class="tr1">
					<td>指标名2</td>
					<td>应用部</td>
					<td>1</td>
					<td>预警原因是。。。</td>
				</tr>
				<tr class="tr1">
					<td>指标名1</td>
					<td>人资部</td>
					<td>2</td>
					<td>预警原因是。。。</td>
				</tr>
				<tr class="tr1">
					<td>指标名2</td>
					<td>应用部</td>
					<td>1</td>
					<td>预警原因是。。。</td>
				</tr>
				<tr class="tr1">
					<td>指标名1</td>
					<td>人资部</td>
					<td>2</td>
					<td>预警原因是。。。</td>
				</tr>
				<tr class="tr1">
					<td>指标名2</td>
					<td>应用部</td>
					<td>1</td>
					<td>预警原因是。。。</td>
				</tr>
			</table>
		</div>
		<div class="echartbox">
			<div class="toptitle bordergreen">
				<span class="titles">监控结果趋势统计</span>
			</div>
			<div class="echartpicbox">
				<div class="echartpic" id="echart-4"></div>
			</div>
		</div>
		<div class="echartbox">
			<div class="toptitle borderblue">
				<span class="titles">部门问题统计</span>
			</div>
			<div class="echartpicbox">
				<div class="echartpic" id="echart-1"></div>
			</div>
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

	<!--echart js-->
	<script src="${ctxStatic}/echartsjs/echarts.js"></script>
	<script type="text/javascript">
		// 部门问题统计
		var myChart1 = echarts.init(document.getElementById('echart-1'));
		// 显示标题，图例和空的坐标轴
		myChart1.setOption({
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'shadow'
				}
			},
			legend : {
				data : [ '问题数' ]
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : {
				type : 'category',
				data : [ '人资', '企协', '办公', '发展', '后勤', '安质', '建设', '物资', '科信',
						'营销', '调控', '财务', '运检' ],
				axisTick : {
					alignWithLabel : true
				}
			},
			yAxis : {

				type : 'value'
			},
			series : [ {
				name : '问题数',
				type : 'bar',
				barWidth : 20,
				itemStyle : {
					normal : {
						label : {
							show : true,
							position : 'inside'
						}
					}
				},
				data : [ 4, 6, 3, 4, 6, 5, 3, 8, 1, 9, 9, 6, 4 ]
			} ]
		});

		// 指标预警柱状图
		var myChart2 = echarts.init(document.getElementById('echart-2'));
		myChart2.setOption({
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'shadow'
				}
			},
			legend : {
				data : [ '预警数' ]
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : {
				type : 'category',
				data : [ '一级预警', '二级预警', '三级预警', '正常' ],
				axisTick : {
					alignWithLabel : true
				}
			},
			yAxis : [ {
				type : 'value',
				axisLabel : {
					formatter : '{value}'
				}
			} ],
			series : [ {
				name : '预警数',
				type : 'bar',
				itemStyle : {
					normal : {
						color : '#2ec7c9',
						label : {
							show : true
						}
					}
				},
				data : [ 1, 3, 6, 15 ]
			} ]
		})

		var myChart4 = echarts.init(document.getElementById('echart-4'));
		myChart4.setOption({
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '问题数' ]
			},
			xAxis : [ {
				type : 'category',
				boundaryGap : false,
				data : [ '三月', '四月', '五月', '六月', '七月', '八月', '九月' ]
			} ],
			yAxis : [ {
				type : 'value',
			/* axisLabel : {
				//对数据进行格式化
			    formatter: '{value} °C'
			} */
			} ],
			series : [ {
				name : '问题数',
				type : 'line',
				data : [ 2, 1, 5, 3, 2, 8, 2 ],
				markPoint : {
					data : [ {
						type : 'max',
						name : '最大值'
					}, {
						type : 'min',
						name : '最小值'
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}
			} ]
		});
	</script>
	<!--/echart js-->
</body>

</html>
