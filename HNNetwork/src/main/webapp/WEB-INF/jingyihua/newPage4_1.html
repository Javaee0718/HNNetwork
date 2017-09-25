<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	style="width:100%;height:100%">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/iestyle.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<!--scrollbar style-->
<link href="css/perfect-scrollbar.css" rel="stylesheet">
	<!--/scrollbar style-->
	<!--menu style-->
	<link href="css/style-menu.css" rel="stylesheet">
		<!--/menu style-->
		<!--分页插件style-->
		<link type="text/css" rel="stylesheet" href="css/simplePagination.css" />
		<!--/分页插件style-->
		<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<!--menu js-->
		<script type="text/javascript" src="js/jquery.menu.js"></script>
		<!--/menu js-->
		<script type="text/javascript" src="js/jquery.common.js"></script>
		<!--除IE外都可识别-->
		<!--calendar-->
		<script type="text/javascript" src="calendarjs/laydate.js"></script>
		<!--/calendar-->
		<!--分页插件 js-->
		<script type="text/javascript" src="js/jquery.simplePagination.js"></script>
		<!--/分页插件 js-->
		<!--[if !IE 8]><!--[if !IE 7]><!--[if !IE 6]><!-->
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script src="echartsjs/echarts.js"></script>
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
		<style>
.alertOutWrap {
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.3);
	position: absolute;
	left: 0;
	top: 0;
	display: none;
}
</style>
		<!--/select options-->
</head>
<body>
	<div class="maincon" style="overflow-y: scroll">
		<div class="echartbox"
			style="width: 100%; margin: 0; box-sizing: border-box; padding: 0 10px;">
			<div class="toptitle borderblue">
				<span class="titles">日前负荷预测合格率</span> <a target="subFrame"
					onclick="history.go(-1)" class="longred"
					style="float: right; margin: 10px 20px 0 0">返回</a>
			</div>
			<div class="echartpicbox">
				<div class="echartpic" id="echart-1"></div>
			</div>
		</div>
		<!--弹出框-->
		<div class="alertOutWrap">
			<div id="alertWrap"
				style="width: 90%; height: 90%; background: #ffffff; position: absolute; border: 1px solid #000000; left: 4.5%; top: 0;">
				<a href="javascript:void(0);"
					onclick="$('.alertOutWrap').css('display','none')" target="_blank"
					class="longred" style="position: absolute; right: 20px; top: 10px;">返回</a>
				<div style="width: 1380px; height: 500px; margin-top: 40px;"
					class="echartpic" id="echart-alert"></div>
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
	<script src="scrollbarjs/perfect-scrollbar.js"></script>
	<script src="scrollbarjs/jquery.scrollbar.js"></script>
	<!--/scrollbar js-->

	<!--echart js-->
	<script type="text/javascript">
		var myChart1 = echarts.init(document.getElementById('echart-1'));
		var myChartAlert = echarts
				.init(document.getElementById('echart-alert'));
		myChart1.on('click', function(params) {
			/* var name = params.name;
			window.location.href = 'newPage4_4.html'; */
			//弹出框
			$(".alertOutWrap").css("display", "block");
			myChartAlert.setOption(optionAlert);
		});
		myChart1.setOption({
			tooltip : {
				trigger : 'axis',
				axisPointer : { // 坐标轴指示器，坐标轴触发有效
					type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : [ {
				type : 'category',
				data : [ '不合格天数', '统计周期内日历天数' ],
				axisTick : {
					alignWithLabel : true
				}
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				type : 'bar',
				barWidth : '60%',
				data : [ 3, 6 ]
			} ]
		});

		var optionAlert = {
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '问题数' ]
			},
			toolbox : {
				show : false,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			grid : {
				y : 70,
				y2 : 30,
				x2 : 20
			},
			xAxis : [ {
				type : 'category',
				axisLine : {
					show : false
				},
				axisTick : {
					show : false
				},
				axisLabel : {
					interval : 0,//横轴信息全部显示  
					rotate : -0,//-30度角倾斜显示  
				},
				splitArea : {
					show : false
				},
				splitLine : {
					show : false
				},
				data : [ '洛阳', '许昌', '平顶山', '商丘', '安阳', '濮阳', '新乡', '驻马店',
						'郑州', '南阳', '济源', '焦作', '漯河', '信阳', '周口', '三门峡', '开封',
						'鹤壁' ]
			} ],
			yAxis : [ {
				type : 'value',
				axisLabel : {
					formatter : '{value}'
				}
			} ],
			series : [ {
				name : '问题数',
				type : 'bar',
				itemStyle : {
					normal : {
						color : '#2ec7c9',
						label : {
							show : true
						}
					}
				},
				data : [ 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4,
						3, 2, 1 ]
			} ]
		};
	</script>
	<!--/echart js-->
</body>

</html>
