require.config({
	paths: {
		echarts: 'echartsjs/'
	}
});

// 使用
require(
	[
		'echarts',
		'echarts/chart/bar', // 使用柱状图就加载bar模块，按需加,
		'echarts/chart/pie' // 使用饼状图就加载bar模块，按需加
	],
	function (ec) {
		//天津分公司设施台账.echart初始化数据
		var myChart1 = ec.init(document.getElementById('echart-1'));                
		var option1 = {
			tooltip : {
				trigger: 'item',
				feature : {
					mark : {show: true},
					dataView : {show: true, readOnly: false},
					magicType : {
						show: true, 
						type: ['pie', 'funnel'],
						option: {
							funnel: {
								x: '25%',
								width: '50%',
								funnelAlign: 'left',
								max: 1548
							}
						}
					},
					restore : {show: true},
					saveAsImage : {show: true}
				}
			},
			legend: {
				x : 'center',
				y : 'bottom',
				data:['FPSO油轮','单点','平台','海管','海缆','陆地终端']
			},
			calculable : true,
			series : [
				{
					name:'设施台账',
					type:'pie',
					radius : [30, 110],
					center : ['50%', 200],
					roseType : 'area',
					x: '50%',               // for funnel
					max: 40,                // for funnel
					sort : 'ascending',     // for funnel
					data:[
							{value:  6,  name:'FPSO油轮'},
							{value: 6,  name:'单点'},
							{value: 156,  name:'平台'},
							{value: 214,  name:'海管'},
							{value: 97, name:'海缆'},
							{value: 7,  name:'陆地终端'}
					]
				}
			]
		};
		
		//天津分公司设备台账.echart初始化数据
		var myChart2 = ec.init(document.getElementById('echart-2'));		
		var option2 = {
			tooltip : {
				trigger: 'item',
				feature : {
					mark : {show: true},
					dataView : {show: true, readOnly: false},
					magicType : {
						show: true, 
						type: ['pie', 'funnel'],
						option: {
							funnel: {
								x: '25%',
								width: '50%',
								funnelAlign: 'left',
								max: 1548
							}
						}
					},
					restore : {show: true},
					saveAsImage : {show: true}
				}
			},
			legend: {
				x : 'center',
				y : 'bottom',
				data:['主发电机','原油外输泵','吊机','天然气压缩机','注水泵','消防泵','热介质锅炉','空气压缩机']
			},
			calculable : true,
			series : [
				{
					name:'设备台账',
					type:'pie',
					radius : [30, 110],
					center : ['50%', 200],
					roseType : 'area',
					x: '50%',               // for funnel
					max: 40,                // for funnel
					sort : 'ascending',     // for funnel
					data:[
							{value:  125,  name:'主发电机'},
							{value: 100,  name:'原油外输泵'},
							{value: 168,  name:'吊机'},
							{value: 120,  name:'天然气压缩机'},
							{value: 138, name:'注水泵'},
							{value: 143,  name:'消防泵'},
							{value: 117, name:'热介质锅炉'},
							{value: 182,  name:'空气压缩机'}
					]
				}
			]
		};
		// 各个分公司的数量，echart初始化数据加载
		var myChart3 = ec.init(document.getElementById('echart-3')); 		
		var option3 = {
			tooltip : {
				trigger: 'axis'
			},
			legend: {
				data:['数量']
			},
			calculable : true,
			xAxis : [
				{
					type : 'category',
					data : ['曹妃甸作业公司','渤南作业公司','渤西作业公司','辽东作业公司','蓬勃作业公司','秦皇岛作业公司']
				}
			],
			yAxis : [
				{
					type : 'value'
				}
			],
			series : [
				{
					name:'数量',
					type:'bar',
					itemStyle:{
						normal:{color:'#54cefb'}
					},
					data:[414, 1790, 1863, 3588, 552, 1242],
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
		myChart3.setOption(option3); 
		window.onresize = function () {
			myChart1.resize();
			myChart2.resize();
			myChart3.resize();
		} 
	}
);