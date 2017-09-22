<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="width:100%;height:100%">
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
<link type="text/css" rel="stylesheet" href="${ctxStatic}/css/simplePagination.css"/>
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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--<![endif]--><!--<![endif]--><!--<![endif]-->
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
$(function(){	
	var mydate = new Date();
	var t=mydate.toLocaleString();
	$("#end").text(t);
})	
</script>
<!--/select options-->
</head>
<body>
    <div class="maincon" style="overflow:scroll">
    	<div class="echartbox">
        	<div class="toptitle"><span class="titles">2017年07月28日指标监控详情</span></div>
            <div class="echartpicbox"><div class="echartpic" id="echart-2"></div></div>
        </div>  
    	<div class="echartbox">
        	<table width="100%" class="zltab" border="0" cellspacing="0" cellpadding="0">
				<tr class="tr0"><td colspan="4">问题汇总</td></tr>
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
        	<div class="toptitle bordergreen"><span class="titles">监控结果趋势统计</span></div>
            <div class="echartpicbox"><div class="echartpic" id="echart-4"></div></div>
        </div>   
    	<div class="echartbox">
        	<div class="toptitle borderblue"><span class="titles">部门问题统计</span></div>
            <div class="echartpicbox"><div class="echartpic" id="echart-1"></div></div>
        </div>  	 	
    </div> 


<!--height Resize js-->
<script type="text/javascript">
$(document).ready(function() {	
	windowResize();
	$(window).resize(function () {
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
	
	// 路径配置
	require.config({
		paths: {
			echarts: 'echartsjs/'
		}
	});
	
	// 使用
	require(
		[
			'echarts',
			'echarts/chart/line', 				
            'echarts/chart/bar', 
			'echarts/chart/pie',		
            'echarts/chart/funnel'
		],
		function (ec) {
			// 基于准备好的dom，初始化echarts图表
			var myChart1 = ec.init(document.getElementById('echart-1')); 
			var option1 = {
					tooltip : {
						trigger: 'axis'
					},
					legend: {
						data:[
							'问题数'
						]
					},
					grid: {y: 70, y2:30, x2:20},
					xAxis : [
						{
							type : 'category',
							data : ['部门1','部门2','部门3','部门4','部门1','部门2','部门3','部门4']
						},
						{
							type : 'category',
							axisLine: {show:false},
							axisTick: {show:false},
							axisLabel: {show:false},
							splitArea: {show:false},
							splitLine: {show:false},
							data : ['部门1','部门2','部门3','部门4','部门1','部门2','部门3','部门4']
						}
					],
					yAxis : [
						{
							type : 'value',
							axisLabel:{formatter:'{value}'}
						}
					],
					series : [
						{
							name:'问题数',
							type:'bar',
							itemStyle: {normal: {color:'#2ec7c9', label:{show:true}}},
							data:[1,3,0,2,1,6,4,1]
						}
					]
				};
				
			//天津分公司设备台账.echart初始化数据
			var myChart2 = ec.init(document.getElementById('echart-2')); 		
            var ecConfig = require('echarts/config');    
              myChart2.on(ecConfig.EVENT.CLICK, eConsole2); 
              function eConsole2(param) {
                    var mes = '【' + param.type + '】';
                    if (typeof param.seriesIndex != 'undefined') {
                        mes += '  seriesIndex : ' + param.seriesIndex;
                        mes += '  dataIndex : ' + param.dataIndex;
                    }
                    if (param.type == 'hover') {
                       console.log('Event Console : ' + mes) ;
                    }
                    else {
                        console.log(mes) ;
                    }
                    console.log(param);
                    window.location.href="chartsDetail.html";
                }  	
			var option2 = {
					tooltip : {
						trigger: 'axis'
					},
					legend: {
						data:[
							'预警数'
						]
					},
					grid: {y: 70, y2:30, x2:20},
					xAxis : [
						{
							type : 'category',
							data : ['一级预警','二级预警','三级预警','正常']
						},
						{
							type : 'category',
							axisLine: {show:false},
							axisTick: {show:false},
							axisLabel: {show:false},
							splitArea: {show:false},
							splitLine: {show:false},
							data : ['一级预警','二级预警','三级预警','正常']
						}
					],
					yAxis : [
						{
							type : 'value',
							axisLabel:{formatter:'{value}'}
						}
					],
					series : [
						{
							name:'预警数',
							type:'bar',
							itemStyle: {normal: {color:'#2ec7c9', label:{show:true}}},
							data:[1,3,0,15]
						}
					]
				};
				
			
			
			var myChart4 = ec.init(document.getElementById('echart-4')); 
			var option4 = {
                    tooltip : {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['问题数']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            data : ['周一','周二','周三','周四','周五','周六','周日']
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            axisLabel : {
                                formatter: '{value} °C'
                            }
                        }
                    ],
                    series : [
                        {
                            name:'问题数',
                            type:'line',
                            data:[2, 1, 5, 3, 2, 8, 2],
                            markPoint : {
                                data : [
                                    {type : 'max', name: '最大值'},
                                    {type : 'min', name: '最小值'}
                                ]
                            },
                            markLine : {
                                data : [
                                    {type : 'average', name: '平均值'}
                                ]
                            }
                        }
                    ]
                };

			// 为echarts对象加载数据 
			myChart1.setOption(option1); 
			myChart2.setOption(option2); 
			
			myChart4.setOption(option4); 
			window.onresize = function () {
				myChart1.resize();
				myChart2.resize();
				myChart4.resize();
			}
		}
	);
</script>
<!--/echart js-->
</body>

</html>
