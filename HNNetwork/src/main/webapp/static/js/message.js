$(function() {
	setInterval(updateTime,1000);
	var oTimeSpan = $("#end");
	//var intime = new Date();
	function updateTime(){ 
		t = new Date();
		if(!oTimeSpan) oTimeSpan = $("#end");
		if(!oTimeSpan) return;
		oTimeSpan.text(t.toLocaleString());
	}
	/*var mydate = new Date();
	var t = mydate.toLocaleString();
	$("#end").text(t);*/
})
window.onload = function() {
	if (message != '') {
		alert(message);
	}
}

