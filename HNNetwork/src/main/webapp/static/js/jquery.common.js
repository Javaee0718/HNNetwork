$(function() {
	//导航字体变换
	$("#fontB").on('click',function(){
		$(this).hide();
		$("#fontB-n").show();
		$("#fontS").show();
		$("#fontS-n").hide();
		$(".venus-menu").find("a").attr('style','font-size:18px;');
	});
	$("#fontS").on('click',function(){
		$(this).hide();
		$("#fontB-n").hide();
		$("#fontB").show();
		$("#fontS-n").show();
		$(".venus-menu").find("a").attr('style','font-size:14px;');
	});
	
	$(".shpyes").click(function(){
		$("#fanganname").show();
		$("#backbtn").show();
		$("#tonggbtn").hide();
		$("#fanganlist").hide();
		$("#fanganmore").slideToggle();
		
	})
	$(".shpno").click(function(){
		$("#fanganname").show();
		$("#backbtn").show();
		$("#tonggbtn").show();
		$("#fanganlist").hide();
		$("#fanganmore").slideToggle();
		
	})
	$("#tongguo").click(function(){
		$("#fanganname").hide();
		$("#backbtn").hide();
		$("#tonggbtn").hide();
		$("#tongguo").hide();
		$("#fanganlist").show();
		$("#fanganmore").hide();
		$("#classchangeno").hide();
		$("#classchangeyes").show();
		$("#shenhe1").html("是");
		var mydate = new Date();
		var t=mydate.getFullYear()+"/"+(mydate.getMonth()+1)+"/"+mydate.getDate();
		$("#time1").text(t);
		
	})
	$("#tonggbtn").click(function(){
		$("#fanganname").hide();
		$("#backbtn").hide();
		$("#tonggbtn").hide();
		$("#tongguo").hide();
		$("#fanganlist").show();
		$("#fanganmore").hide();
		$("#classchangeno").hide();
		$("#classchangeyes").show();
		$("#shenhe1").html("是");
		var mydate = new Date();
		var t=mydate.toLocaleString();
		$("#time1").text(t);
		
	})
	$("#searchbtn").click(function(){
		$("#daorutable").hide();
		$("#searchtable").slideToggle();
		
	})
	$("#daorubtn").click(function(){
		$("#searchtable").hide();
		$("#daorutable").slideToggle();
		
	})
});
//复选框全选代码
function unselectall()
{
	if(document.del.chkAll.checked){
	document.del.chkAll.checked = document.del.chkAll.checked&0;} 	
}
function CheckAll(form){
  for (var i=0;i<form.elements.length;i++)
	{
	var e = form.elements[i];
	if (e.Name != "chkAll")
	   e.checked = form.chkAll.checked;
	}
}


//table切换脚本
var tab_sum;
$(function() {
	tab_sum = $("ul.tabOptions li").length - 1;
	
});
function tabShow(id) {
	a_id = id;
	tab_con_id_show = "#tab_con"+a_id;
	tab_title_id_add = "#tab_title"+a_id;
	for(var i=1;i<=tab_sum;i++){
		if(id==i){
			$("#tab_title"+a_id).removeClass("active").addClass("normal");
			$(tab_title_id_add).addClass("active").removeClass("nomal");
			$(tab_con_id_show).show();
		}else{			
			tab_title_id_remove = "#tab_title"+i;
			$(tab_title_id_remove).removeClass("active").addClass("normal");
				
			tab_con_id_hide = "#tab_con"+i;
			$(tab_con_id_hide).hide();
		}
	}
}

//统一录入table切换脚本
var tabShow_lrtab_sum_lr;
$(function() {
	tab_sum_lr = $(".lefttop2 ul li em").length;
	
});
function tabShow_lr(id) {
	a_id = id;
	tab_con_id_show = "#tab_con"+a_id;
	tab_title_id_add = "#tab_title"+a_id;
	for(var i=1;i<=tab_sum_lr;i++){
		if(id==i){			
			
			$(tab_title_id_add).addClass("yListrclickem");
			$(tab_con_id_show).show();
		}else{			
			tab_title_id_remove = "#tab_title"+i;
			$(tab_title_id_remove).removeClass("yListrclickem");
				
			tab_con_id_hide = "#tab_con"+i;
			$(tab_con_id_hide).hide();
		}
	}
}

//页面布局设置
function windowResize() {
	var bodyHeight = $(window).height();	
	var bodyWidth = $(window).width();
	var marTopHeight = (bodyHeight-125-78)/2;
	//$('.loginbox').css({'position':'absolute','left':($(window).width()-549)/2});
	$('#midheight,#leftFrame,#mainFrame').css({'height':(bodyHeight - 125)});
	$('#banicon').css({'margin-top':((bodyHeight-125-78)/2)});
	$('#banicon').css({'height':(bodyHeight-125-marTopHeight)});
	//$(window).resize(function(){  
	//	$('.loginbox').css({'position':'absolute','left':($(window).width()-549)/2});
	//})  
	$(".mainindex").css({'height':(bodyHeight - 40)});
	$(".maincon").css({'height':(bodyHeight - 20)});
	$(".con-leftmenu,.con-rightpart").css({'height':(bodyHeight - 80)});
	
	$(".mainindex-lr").css({'height':bodyHeight});
	//$(".lr-leftmenu").css({'height': bodyHeight});
	$(".lr-rightcon,.loclist").css({'width':(bodyWidth - 40)});
	//$(".mainindex").css({'width':(bodyWidth)});
	//$(".maincon").css({'width':(bodyWidth - 30)});
	
	
}

windowResize();
$(window).resize(function () {
    windowResize();
});