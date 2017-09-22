<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		</ul>
	</div>
	<!--/当前位置-->

	<div class="mainindex" id="mainindex">
		<div class="maincon">
			<div class="echartbox">
				<div class="toptitle">
					<span class="titles">季度指标段位分布情况</span>
				</div>
				<div class="echartpicbox">
					<div class="echartpic" id="echart-2"></div>
				</div>
			</div>
			<div class="echartbox">
				<div class="toptitle borderzi">
					<span class="titles">近期总体排名趋势</span>
				</div>
				<div class="echartpicbox">
					<div class="echartpic" id="echart-1"></div>
				</div>
			</div>
			<div class="echartbox1">
				<div class="toptitle1 bordergreen1">
					<span class="titles1">各牵头部门D段、E段指标数量统计</span>
				</div>
				<div class="echartpicbox1">
					<div class="echartpic1" id="echart-3"></div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			windowResize();
			$(window).resize(function() {
				windowResize();
			});
		});
	</script>
	<script src="${ctxStatic}/scrollbarjs/perfect-scrollbar.js"></script>
	<script src="${ctxStatic}/scrollbarjs/jquery.scrollbar.js"></script>

	<!-- echarts -->
	<script src="${ctxStatic}/echartsjs/echarts.js"></script>
	<script type="text/javascript">
		var myChart1 = echarts.init(document.getElementById('echart-1'));
		// 显示标题，图例和空的坐标轴
		myChart1.setOption({
			tooltip : {
				trigger : 'axis',
				axisPointer : { // 坐标轴指示器，坐标轴触发有效
					type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			calculable : true,
			xAxis : [
				{
					name : '年份',
					type : 'category',
					data : getHenanYear(),
					position: 'top'
				}
			],
			yAxis : [
				{
					name : '名次',
					inverse : true,
					type : 'value'
				}
			],
			series : [ {
				name : '排名',
				type : 'line',
	            data: getHenanPai()
			} ],
			color:['red', 'green','yellow','blueviolet']
		});
		
		function getHenanPai(){
			var arrStr = [];
			$.ajax({
				type : "POST",
				url : "${ctx}/mainIndex/henanPai",
				dataType : "json",
				async : false, //同步
				success : function(data) {
					arrStr = data.sortCategories;
				}
			});
			return arrStr;
		}
		
		function getHenanYear(){
			var arrStr = [];
			$.ajax({
				type : "POST",
				url : "${ctx}/mainIndex/henanPai",
				dataType : "json",
				async : false, //同步
				success : function(data) {
					arrStr = data.yearCategories;
				}
			});
			return arrStr;
		}
		
		function getHenanAGrade(grade) {
			var arrStr = [];
			$.ajax({
				type : "POST",
				url : "${ctx}/mainIndex/henanAGrade?grade="+grade,
				dataType : "json",
				async : false, //同步
				success : function(data) {
					arrStr = eval('[' + data + ']');
				}
			});
			return arrStr;
		}
		
		function getHenanBGrade() {
			var arrStr = [];
			$.ajax({
				type : "POST",
				url : "${ctx}/mainIndex/henanBGrade",
				dataType : "json",
				async : false, //同步
				success : function(data) {
					arrStr = eval('[' + data + ']');
				}
			});
			return arrStr;
		}
		
		function getHenanCGrade() {
			var arrStr = [];
			$.ajax({
				type : "POST",
				url : "${ctx}/mainIndex/henanCGrade",
				dataType : "json",
				async : false, //同步
				success : function(data) {
					arrStr = eval('[' + data + ']');
				}
			});
			return arrStr;
		}
		
		function getHenanDGrade() {
			var arrStr = [];
			$.ajax({
				type : "POST",
				url : "${ctx}/mainIndex/henanDGrade",
				dataType : "json",
				async : false, //同步
				success : function(data) {
					arrStr = eval('[' + data + ']');
				}
			});
			return arrStr;
		}
		
		function getHenanEGrade() {
			var arrStr = [];
			$.ajax({
				type : "POST",
				url : "${ctx}/mainIndex/henanEGrade",
				dataType : "json",
				async : false, //同步
				success : function(data) {
					arrStr = eval('[' + data + ']');
				}
			});
			return arrStr;
		}
		
		
		function getHeadDept() {
			var arrStr = [];
			$.ajax({
				type : "POST",
				url : "${ctx}/mainIndex/headDept",
				dataType : "json",
				async : false, //同步
				success : function(data) {
					arrStr = data.categories;
				}
			});
			return arrStr;
		}
		
		function getDGrade() {
			var arrStr = [];
			$.ajax({
				type : "POST",
				url : "${ctx}/mainIndex/dGrade",
				dataType : "json",
				async : false, //同步
				success : function(data) {
					arrStr = eval('[' + data + ']');
				}
			});
			return arrStr;
		}
		
		function getEGrade() {
			var arrStr = [];
			$.ajax({
				type : "POST",
				url : "${ctx}/mainIndex/eGrade",
				dataType : "json",
				async : false, //同步
				success : function(data) {
					arrStr = eval('[' + data + ']');
				}
			});
			return arrStr;
		}

		var myChart2 = echarts.init(document.getElementById('echart-2'));
		// 显示标题，图例和空的坐标轴
		myChart2.setOption({
			color : [ '#3398DB' ],
			tooltip : {
				trigger : 'axis',
				axisPointer : { // 坐标轴指示器，坐标轴触发有效
					type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			legend : {
				data : [ 'A段', 'B段', 'C段', 'D段', 'E段' ]
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : [ {
				type : 'category',
				data : [ '16年全年','17年1季度', '17年上半年', '17年目标'  ],
				axisTick : {
					alignWithLabel : true
				}
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ 
			{
				name : 'A段',
				type : 'bar',
				barWidth : 25,
				stack : '年',
				data : getHenanAGrade("4"),
				itemStyle : {
					normal : {
						label: {
			            	show: true,
			            	position: 'inside'
			            },
						color : 'red'
					}
				}
			}, {
				name : 'B段',
				type : 'bar',
				barWidth : 25,
				stack : '年',
				data : getHenanAGrade("3"),
				itemStyle : {
					normal : {
						label: {
			            	show: true,
			            	position: 'inside'
			            },
						color : 'orange'
					}
				}
			}, {
				name : 'C段',
				type : 'bar',
				barWidth : 25,
				stack : '年',
				data : getHenanAGrade("2"),
				itemStyle : {
					normal : {
						label: {
			            	show: true,
			            	position: 'inside'
			            },
						color : 'yellow'
					}
				}
			}, {
				name : 'D段',
				type : 'bar',
				barWidth : 25,
				stack : '年',
				data : getHenanAGrade("1"),
				itemStyle : {
					normal : {
						label: {
			            	show: true,
			            	position: 'inside'
			            },
						color : 'green'
					}
				}
			}, {
				name : 'E段',
				type : 'bar',
				barWidth : 25,
				stack : '年',
				data : getHenanAGrade("0"),
				itemStyle : {
					normal : {
						label: {
			            	show: true,
			            	position: 'inside'
			            },
						color : 'pink'
					}
				}
			} ]
		});
		
		var myChart3 = echarts.init(document.getElementById('echart-3'));
		// 显示标题，图例和空的坐标轴
		myChart3.setOption({
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'shadow'
				}
			},
			/* toolbox : {
			show : true,
			feature : {
				mark : {
					show : false
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar', 'stack', 'tiled' ]
				},
				restore : {
					show : true
				}
				saveAsImage : {
					show : true
				} 
			}
		},  */
			legend : {
				data : [ 'D段', 'E段' ]
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : {
				type : 'category',
				data : getHeadDept(),
				axisTick : {
					alignWithLabel : true
				}
			},
			yAxis : {
				type : 'value'
			},
			series : [ {
				name : 'D段',
				type : 'bar',
				itemStyle: {
	                normal: {
	                    label : {
	                        show: true, position: 'inside'
	                    }
	                }
	            },
				data : getDGrade()
			}, {
				name : 'E段',
				type : 'bar',
				itemStyle: {
	                normal: {
	                    label : {
	                        show: true, position: 'inside'
	                    }
	                }
	            },
				data : getEGrade()
			} ]
		});

		//myChart.showLoading(); //数据加载完之前先显示一段简单的loading动画
	</script>
	<!--/echart js-->
</body>

</html>
