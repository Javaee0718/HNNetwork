<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	style="width:100%;height:100%">
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
		<a href="javascript:void(0);" target="_blank" onclick="nextPage();"
			class="longred"
			style="position: absolute; right: 20px; top: 50%; width: 25px; height: 85px">下一页</a>
		<a href="javascript:void(0);" target="_blank"
			onclick="window.location.href='newMainEchart.html'" class="longred"
			style="float: right; margin: 10px 30px 0 0;">返回</a>
		<div style="float: right; margin: 10px 50px 0 0;">
			<select class="select1" id="changeIndex"
				onchange="changeIndex(this.options[this.options.selectedIndex].value)"
				style="width: 100px;">
				<option value="">请选择指标</option>
				<option value="1">指标1</option>
				<option value="2">指标2</option>
				<option value="3">指标3</option>
			</select>
		</div>
		<div class="echartbox" style="margin-top: 50px;">
			<div class="toptitle">
				<span class="titles">业扩报装服务规范率</span>
			</div>
			<div class="echartpicbox">
				<div class="echartpic" id="echart-1"></div>
			</div>
		</div>
		<div class="echartbox">
			<div class="toptitle bordergreen">
				<span class="titles">物资采购计划完成率</span>
			</div>
			<div class="echartpicbox">
				<div class="echartpic" id="echart-2"></div>
			</div>
		</div>
		<div class="echartbox">
			<div class="toptitle">
				<span class="titles">物资合同履约完成率</span>
			</div>
			<div class="echartpicbox">
				<div class="echartpic" id="echart-3"></div>
			</div>
		</div>


		<div class="echartbox">
			<div class="toptitle borderblue">
				<span class="titles">智能电网调度功能应用完成率</span>
			</div>
			<div class="echartpicbox">
				<div class="echartpic" id="echart-4"></div>
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
		function nextPage() {
			window.location.href = "${ctx}/incl/jingyihua/chartsDetail2"
		}
		function changeIndex(data) {
			console.log(data);
			switch (data) {
			case "1":
				window.location.href = "newPage1.html";
				break;
			case "2":
				window.location.href = "newPage1.html";
				break;
			case "3":
				window.location.href = "newPage1.html";
				break;
			}
		}

		/* myChart3.on(ecConfig.EVENT.CLICK, eConsole3);
		function eConsole3(param) {
			window.location.href = "newPage1.html"
		} */

		var myChart1 = echarts.init(document.getElementById('echart-1'));
		myChart1.on('click', function(params) {
			/* var city = params.name;
			loadChart(city);  */
			window.location.href = "${ctx}/incl/jingyihua/newPage1";
			//alert(params);
		});
		// 添加点击事件  
		/* var ecConfig = require('echarts/config');
		myChart1.on(ecConfig.EVENT.CLICK, eConsole); */
		myChart1.setOption({
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b}: {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				x : 'left',
				data : [ '已达标率', '未达标率' ]
			},
			series : [ {
				name : '数据比例',
				type : 'pie',
				clickable : true,
				radius : [ '50%', '70%' ],
				avoidLabelOverlap : false,
				label : {
					normal : {
						show : false,
						position : 'center'
					},
					emphasis : {
						show : true,
						textStyle : {
							fontSize : '30',
							fontWeight : 'bold'
						}
					}
				},
				labelLine : {
					normal : {
						show : false
					}
				},
				data : [ {
					value : 97,
					name : '已达标率'
				}, {
					value : 3,
					name : '未达标率'
				} ]
			} ],
			color : [ 'green', 'red' ]
		});
		/* function eConsole(param) {
			if (typeof param.seriesIndex == 'undefined') {
				return;
			}
			if (param.type == 'click') {
				alert(param.name);
			}
		} */

		/* 物资采购计划完成率  */
		var myChart2 = echarts.init(document.getElementById('echart-2'));
		myChart2.on('click', function(params) {
			/* var city = params.name;
			loadChart(city);  */
			window.location.href = "${ctx}/incl/jingyihua/newPage2";
			//alert(params);
		});
		myChart2.setOption({
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				left : 'left',
				data : [ '已达标率', '未达标率' ]
			},
			series : [ {
				name : '数据比例',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],
				data : [ {
					value : 70,
					name : '已达标率'
				}, {
					value : 30,
					name : '未达标率'
				} ],
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ],
			color : [ 'green', 'red' ]
		});

		/* 物资合同履约完成率  */
		var myChart3 = echarts.init(document.getElementById('echart-3'));
		myChart3.on('click', function(params) {
			/* var city = params.name;
			loadChart(city);  */
			window.location.href = "${ctx}/incl/jingyihua/newPage3";
			//alert(params);
		});
		myChart3.setOption({
			tooltip : {
				formatter : "{a} <br/>{b} : {c}%"
			},
			/* toolbox : {
				feature : {
					show : false,
					restore : {},
					saveAsImage : {}
				}
			}, */
			series : [ {
				name : '数据比例',
				type : 'gauge',
				detail : {
					formatter : '{value}%'
				},
				data : [ {
					value : 40,
					name : '完成率'
				} ]
			} ],
			color : [ 'green', 'red' ]
		});

		/* 智能电网调度功能应用完成率 */
		var myChart4 = echarts.init(document.getElementById('echart-4'));
		myChart4.on('click', function(params) {
			/* var city = params.name;
			loadChart(city);  */
			window.location.href = "${ctx}/incl/jingyihua/newPage4";
			//alert(params);
		});
		myChart4.setOption({
			/* title : {
				text : 'Customized Pie',
				left : 'center',
				top : 20,
				textStyle : {
					color : '#ccc'
				}
			}, */

			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},

			visualMap : {
				show : false,
				min : 0,
				max : 100,
				inRange : {
					colorLightness : [ 0, 1 ]
				}
			},
			series : [ {
				name : '数据比例',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '50%' ],
				data : [ {
					value : 79,
					name : '已完成率'
				}, {
					value : 21,
					name : '未完成率'
				} ].sort(function(a, b) {
					return a.value - b.value;
				}),
				roseType : 'radius',
				label : {
					normal : {
						textStyle : {
							color : 'rgba(255, 255, 255, 0.3)'
						}
					}
				},
				labelLine : {
					normal : {
						lineStyle : {
							color : 'rgba(255, 255, 255, 0.3)'
						},
						smooth : 0.2,
						length : 10,
						length2 : 20
					}
				},
				itemStyle : {
					normal : {
						color : '#c23531',
						shadowBlur : 200,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				},

				animationType : 'scale',
				animationEasing : 'elasticOut',
				animationDelay : function(idx) {
					return Math.random() * 200;
				}
			} ],
			color : [ 'green', 'red' ]
		});
	</script>
	<!--/echart js-->
</body>

</html>