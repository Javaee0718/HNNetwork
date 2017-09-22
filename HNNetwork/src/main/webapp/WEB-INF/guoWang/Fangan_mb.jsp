<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<link rel="stylesheet" href="${ctxStatic}/css/jquery.mloading.css">
<!--/menu style-->
<!--分页插件style-->
<link type="text/css" rel="stylesheet"
	href="${ctxStatic}/css/simplePagination.css" />
<!--/分页插件style-->
<script type="text/javascript"
	src="${ctxStatic}/js/jquery-1.11.2.min.js"></script>
<!-- 遮罩插件 -->
<script src="${ctxStatic}/js/jquery.mloading.js"></script>
<!-- 一键上传插件 -->
<script src="${ctxStatic}/js/jquery.ocupload-1.1.2.js"
	type="text/javascript"></script>
<script type="text/javascript" src="${ctxStatic}/js/select-ui.min.js"></script>
<!--menu js-->
<script type="text/javascript" src="${ctxStatic}/js/jquery.menu.js"></script>
<!--/menu js-->
<script type="text/javascript" src="${ctxStatic}/js/jquery.common.js"></script>
<!--除IE外都可识别-->
<!--calendar-->
<script type="text/javascript" src="${ctxStatic}/calendarjs/laydate.js"></script>
<script type="text/javascript" src="${ctxStatic}/js/webuploader.min.js"></script>
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
.otherTr {
	display: none;
}

.otherTr.active {
	display: table-row;
}

.subTr {
	display: none;
}

.subTr.active {
	display: table-row;
}
</style>

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

<!-- 文件导入 -->
<script type="text/javascript">
	$(function() {
		var uploader = WebUploader.create({
			// 选完文件后，是否自动上传。  
			auto : true,

			// swf文件路径  
			swf : '${ctxStatic }/swf/Uploader.swf',

			// 文件接收服务端。  
			server : '${ctx}/excel/dataFileUp',

			// 选择文件的按钮。可选。  
			// 内部根据当前运行是创建，可能是input元素，也可能是flash.  
			pick : '#upload1',

			// 只允许选择图片文件。  
			/* accept : {
				title : 'Images',
				extensions : 'gif,jpg,jpeg,bmp,png',
				mimeTypes : 'image/*'
			}, */
			method : 'POST',
		});
		/* 上传进行中 */
		uploader.on('uploadProgress', function(file, percentage) {
			$("body").mLoading();
		});
		uploader.on( 'uploadSuccess', function( file,response ) {  
			alert(response.msg);
			/* for(var i in response) {
				alert(response[i]);
			} */
			//var file = eval("(" + response + ")")
			//alert(file.msg);
		   });  
		uploader.on('uploadComplete', function(file) {
			$("body").mLoading("hide")
		//	alert(file);
			
			/* var file = eval("(" + file + ")")
			alert(file.message); */
		});
	})
</script>

<script type="text/javascript">
	$(function() {
		var mydate = new Date();
		var t = mydate.toLocaleString();
		$("#end").text(t);
	})
	/* $(function() {
		$("#upload1").upload({
			name : 'file',
			autoSubmit : true,
			enctype : 'multipart/form-data', // 编码格式 
			action : '${ctx}/excel/dataFileUp',
			onSubmit : function() {
				$("body").mLoading();
			},
			onComplete : function(response) {// 请求完成时 调用函数  
				console.log(response);
				$("body").mLoading("hide")
				var data = eval("(" + response + ")")
				alert(data.msg);
			}
		})
	}) */
</script>
<!--/select options-->
<!-- 设置年份 -->
<script type="text/javascript">
	var message = "${message}";
</script>
<script type="text/javascript">
	function formSubmit() {
		var year = $("#year").val();
		year = $.trim(year);
		var reg = /\d{4}/;
		if (!reg.exec(year)) {
			alert("请输入正确的年份");
		} else {
			if (year > 0 && year <= 9999) {
				//年份
				$("#year").val(year);
				//指标名
				var quotaName = $("#quotaName").val();
				quotaName = $.trim(quotaName);
				$("#quotaName").val(quotaName);
				//制表单位 quotaUnit
				var quotaUnit = $("#quotaUnit").val();
				quotaUnit = $.trim(quotaUnit);
				$("#quotaUnit").val(quotaUnit);
				//指标类别 quotaType
				var quotaType = $("#quotaType").val();
				quotaType = $.trim(quotaType);
				$("#quotaType").val(quotaType);
				$("#form").submit();
			} else {
				alert("请输入正确的年份");
			}
		}
	}
</script>
<!-- <script type="text/javascript">
	function upload() {
		var val = $("#file").val();
		if (val != '') {
			$("#formUpload").submit();
		}
	}
</script> -->
</head>
<body>
	<!--当前位置-->
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>首页</li>
			<li>国网体系同业对标基本管理</li>
			<li>数据管理</li>
		</ul>
	</div>
	<!--/当前位置-->

	<div class="mainindex" id="mainindex">
		<div class="maincon">
			<!--btns-->
			<!--<ul class="btnOptions">
          <li><a href="Fangan_add.html"><img src="images/btn-add.jpg" width="75" height="35" /></a></li>
          <li><a href="Fangan_add.html"><img src="images/btn-edit.jpg" width="75" height="35" /></a></li>
          <li><a href="#"><img src="images/btn-del.jpg" width="75" height="35" /></a></li>
        </ul>-->
			<!--/btns-->
			<!--列表信息-->
			<div class="ziliaobox">

				<form id="form" action="${ctx}/dtMa" method="post">
					<table width="100%" class="zltab" border="0" cellspacing="0"
						cellpadding="0">

						<tr class="tr1">
							<td>查询年份：</td>
							<td><input type="text" id="year" name="year"
								style="width: 147px; height: 20px" value="  ${query.year}" /> <!-- <select
								class="select1" id="year" name="year"> --> </select></td>
							<td>季度</td>
							<td><select name="partYear" class="select1">
									<option value="第一季度"
										<c:if test="${query.partYear == '第一季度'}">selected="selected"</c:if>>第一季度</option>
									<option value="上半年"
										<c:if test="${query.partYear == '上半年'}">selected="selected"</c:if>>上半年</option>
									<option value="第三季度"
										<c:if test="${query.partYear == '第三季度'}">selected="selected"</c:if>>第三季度</option>
									<option value="全年"
										<c:if test="${query.partYear == '全年'}">selected="selected"</c:if>>全年</option>
							</select></td>
							<td width="10%">指标名称：</td>
							<td width="20%"><input type="text" id="quotaName"
								name="quotaName" style="width: 147px; height: 20px"
								value="  ${query.quotaName}" /></td>
						</tr>

						<!-- class="tdc2"  class="select1"-->

						<tr class="tr1 otherTr">
							<td width="10%">板块：</td>
							<td width="20%"><select name="module" class="select1"
								style="width: 85%">
									<option value="">请选择板块</option>
									<c:forEach items="${modules}" var="m">
										<option value="${m.name}"
											<c:if test="${m.name == query.module}">selected="selected"</c:if>>${m.name}</option>
									</c:forEach>
							</select></td>
							<td>指标单位：</td>
							<td><input type="text" id="quotaUnit" name="quotaUnit"
								style="width: 147px; height: 20px" value="  ${query.quotaUnit}"></td>
							<td width="10%">属性：</td>
							<td width="20%"><select name="attribute" class="select1"
								style="width: 85%">
									<option value="">请选择属性</option>
									<c:forEach items="${attributes }" var="attribute">
										<option value="${attribute.name}"
											<c:if test="${attribute.name == query.attribute}">selected="selected"</c:if>>${attribute.name}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr class="tr1 otherTr">
							<td>牵头部门：</td>
							<td><select name="headDept" class="select1"
								style="width: 85%">
									<option value="">请选择牵头部门</option>
									<c:forEach items="${depts}" var="dept">
										<option value="${dept.name}"
											<c:if test="${dept.name == query.headDept}">selected="selected"</c:if>>${dept.name}</option>
									</c:forEach>
							</select></td>

							<td>发布周期：</td>
							<td><select class="select1" name="publishCycle">
									<option value="">请选择发布周期</option>
									<c:forEach items="${publishCycles}" var="publishCycle">
										<option value="${publishCycle.name}"
											<c:if test="${publishCycle.name == query.publishCycle}">selected="selected"</c:if>>${publishCycle.name}</option>
									</c:forEach>
							</select></td>
							<td>评价方式：</td>
							<td><select class="select1" name="appraiseMethod">
									<option value="">请选择评价方式</option>
									<c:forEach items="${appraiseMethods}" var="appraiseMethod">
										<option value="${appraiseMethod.name}"
											<c:if test="${appraiseMethod.name == query.appraiseMethod}">selected="selected"</c:if>>${appraiseMethod.name}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr class="tr1 otherTr">
							<td>正反向：</td>
							<td><select class="select1" name="posAndNegDir"
								style="width: 85%">
									<option value="">请选择正反向</option>
									<option value="正向"
										<c:if test="${query.posAndNegDir == '正向' }">selected="selected"</c:if>>正向</option>
									<option value="反向"
										<c:if test="${query.posAndNegDir == '反向' }">selected="selected"</c:if>>反向</option>
							</select></td>

							<td>指标类别：</td>
							<td>
								<!-- <select class="select1">
									<option value="">请选择指标类别</option>
									<option value="100">100</option>
									<option value="50">50</option>
							</select> --> <input type="text" id="quotaType" name="quotaType"
								style="width: 147px; height: 20px" value="  ${query.quotaType}">
							</td>
						</tr>
					</table>
				</form>

				<table width="100%" class="zltab" border="0" cellspacing="0"
					cellpadding="0">
					<tr class="tr1">
						<td colspan="3"><a href="javascript:void(0);" target="_blank"
							onclick="displayMore($(this))" style="margin-left: 50px;">展开</a></td>
						<td colspan="3">
							<div style="float: right;background:#ffffff" class="file">
								<a href="javascript:void(0);" onclick="formSubmit()"
									target="_blank" class="longred">查询</a> <a
									href="${ctx}/model/down" onclick="" target="_blank"
									class="longred">模板下载</a>
								<button id="upload1" class="upload1" style="width:92px;height: 30px">导入</button>
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
							<td width="4%">板块</td>
							<td width="13%">指标名称</td>
							<td width="3%">属性</td>
							<td width="5%">牵头部门</td>
							<td width="4%">发布周期</td>
							<td width="4%">评价方式</td>
							<td width="4%">正反向</td>
							<td width="4%">指标满分</td>
							<td width="4%">指标单位</td>
							<td width="7%">指标类别</td>
							<td width="5%">当年目标段位</td>
							<td width="5%">当年目标得分</td>
							<td width="5%">当年目标值</td>
							<td width="5%">考核底线段位</td>
							<td width="5%">考核底线得分</td>
							<td width="5%">实际段位</td>
							<td width="5%">实际得分</td>
							<td width="3%">实际值</td>
							<td width="5%">指标排名</td>
						</tr>
						<c:forEach items="${page.list}" var="daMas" varStatus="oIndex">
							<c:forEach items="${daMas}" var="daMa" varStatus="index">
								<c:if test="${index.index == 0}">
									<tr class="tr1">
										<!-- 在js文件中,对class与索引进行结合.将索引定义为全局变量 -->
										<c:if test="${daMas.size() > 1}">
											<td class="tdc"><a href="javascript:void(0);"
												onclick="openTr($(this),'${oIndex.index}')" class="longred"
												style="width: 20px; height: 18px; font-size: 10px; padding: 0; border-radius: 30px; font-size: 18px; line-height: 18px;">+</a>
											</td>
										</c:if>
										<c:if test="${daMas.size() <= 1}">
											<td></td>
										</c:if>
										<td>${(page.currPage-1)*page.pageSize+oIndex.count}</td>
										<td>${daMa.moduleName}</td>
										<td>${daMa.childQuotaName}</td>
										<td>${daMa.attribute}</td>
										<td>${daMa.headDept}</td>
										<td>${daMa.publishCycle}</td>
										<td>${daMa.appraiseMethod}</td>
										<td>${daMa.posAndNegDir }</td>
										<td>${daMa.quotaFullMark}</td>
										<td>${daMa.quotaUnit}</td>
										<td>${daMa.quotaType }</td>
										<td>${daMa.nowYearTarGrade }</td>
										<td>${daMa.nowYearTarScore }</td>
										<td>${daMa.nowYearTarValue }</td>
										<td>${daMa.checkBaseLineGrade }</td>
										<td>${daMa.checkBaseLineScore }</td>
										<td>${daMa.henanGradeView }</td>
										<td>${daMa.henanScore }</td>
										<td>${daMa.henanValue }</td>
										<td>${daMa.sortRank}</td>
									</tr>
								</c:if>
								<c:if test="${index.index != 0}">
									<tr class="tr1 subTr subTr${oIndex.index}">
										<td></td>
										<td></td>
										<td></td>
										<td>${daMa.childQuotaName}</td>
										<td>
											<%-- ${daMa.attribute} --%>
										</td>
										<td>
											<%-- ${daMa.headDept} --%>
										</td>
										<td>
											<%-- ${daMa.publishCycle} --%>
										</td>
										<td>
											<%-- ${daMa.appraiseMethod} --%>
										</td>
										<td>
											<%-- ${daMa.posAndNegDir} --%>
										</td>
										<td>
											<%-- ${daMa.quotaFullMark} --%>
										</td>
										<td>
											<%-- ${daMa.quotaUnit} --%>
										</td>
										<td>
											<%-- ${daMa.quotaType} --%>
										</td>
										<%-- <td>${daMa.nowYearTarGrade}</td> --%>
										<td></td>
										<td>
											<%-- ${daMa.nowYearTarScore} --%>
										</td>
										<td>
											<%-- ${daMa.nowYearTarValue} --%>
										</td>
										<td></td>
										<%-- <td>${daMa.checkBaseLineGrade}</td> --%>
										<td>
											<%-- ${daMa.checkBaseLineScore} --%>
										</td>
										<td>
											<%-- ${daMa.henanGradeView} --%>
										</td>
										<td>
											<%-- ${daMa.henanScore} --%>
										</td>
										<td>${daMa.henanValue}</td>
										<td>
											<%-- ${daMa.sortRank} --%>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>
						<tr class="tr2">
							<td colspan="21" width="100%">
								<div id="paging1" class="page" style="float: right"></div>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<!--/列表信息-->
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
	<script type="text/javascript">
		$(function() {
			$("#paging1").pagination(
					{
						items : '${page.totalCount}', //总数量
						itemsOnPage : '${page.pageSize}', //每页多少条
						currentPage : '${page.currPage}',
						cssStyle : 'compact-theme',
						onPageClick : function(pageNumber, event) {
							location.href = '${ctx}/dtMa?page=' + pageNumber
									+ '${condition}'
						}
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
		function openTr(This, num) {
			var cls = "subTr" + num;
			console.log(This)
			This.parents(".tr1").siblings("." + cls).toggleClass("active");
			This.parents("table").siblings().find("." + cls).removeClass(
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
	<script type="text/javascript" src="${ctxStatic}/js/message.js"></script>
	<link href="${ctxStatic}/css/upload.css" rel="stylesheet"
		type="text/css" />
</body>
</html>
