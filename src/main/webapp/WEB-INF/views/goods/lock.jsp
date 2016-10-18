<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" >  
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css?v=0.02" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css?v=0.02"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<title>开锁-防盗门</title>
</head>
<style>
	sa{color:#00cced; border:1.5px solid #00cced; background:url(images/choosed.png) right bottom no-repeat #fff; background-size:25px}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#car-choose").hide();
	$("#price").html("￥100.00");
	$("#p").val(100.00);
	$("#btn_sub").click(function(){
	 	   
 	   	$("#lockForm").submit();
 	   
 	});
});
function selectType(t) {
	switch(t){
		case 1: {
			$("#door-type").empty();
			$("#door-type").append('<li id="s1" class="be-selected"><a style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;" id="sa1" href="javascript:void();" onclick="selectType(1)">防盗门</a></li>');
			$("#door-type").append('<li id="s2"><a id="sa2" href="javascript:void();" onclick="selectType(2);">汽车门</a></li>');
			$("#door-type").append('<li id="s3"><a id="sa3" href="javascript:void();" onclick="selectType(3);">保险柜</a></li>');
			$("#door-type").append('<li id="s4"><a id="sa4" href="javascript:void();" onclick="selectType(4);">室内锁</a></li>');
			$("#door-type").append('<li id="s5"><a id="sa5" href="javascript:void();" onclick="selectType(5);">文件柜</a></li>');
			$("#lt").val(1);
			$("#car-choose").hide();
			$("#door-choose").show();
			$("#price").html("￥100.00");
			$("#p").val(100.00);
			break;
		}
		case 2: {
			$("#door-type").empty();
			$("#door-type").append('<li id="s1"><a id="sa1" href="javascript:void();" onclick="selectType(1)">防盗门</a></li>');
			$("#door-type").append('<li id="s2" class="be-selected"><a style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;" id="sa2" href="javascript:void();" onclick="selectType(2);">汽车门</a></li>');
			$("#door-type").append('<li id="s3"><a id="sa3" href="javascript:void();" onclick="selectType(3);">保险柜</a></li>');
			$("#door-type").append('<li id="s4"><a id="sa4" href="javascript:void();" onclick="selectType(4);">室内锁</a></li>');
			$("#door-type").append('<li id="s5"><a id="sa5" href="javascript:void();" onclick="selectType(5);">文件柜</a></li>');
			$("#lt").val(2);
			$("#car-choose").show();
			$("#door-choose").hide();
			break;
		}
		case 3: {
			$("#door-type").empty();
			$("#door-type").append('<li id="s1"><a id="sa1" href="javascript:void();" onclick="selectType(1)">防盗门</a></li>');
			$("#door-type").append('<li id="s2"><a id="sa2" href="javascript:void();" onclick="selectType(2);">汽车门</a></li>');
			$("#door-type").append('<li id="s3" class="be-selected"><a style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;" id="sa3" href="javascript:void();" onclick="selectType(3);">保险柜</a></li>');
			$("#door-type").append('<li id="s4"><a id="sa4" href="javascript:void();" onclick="selectType(4);">室内锁</a></li>');
			$("#door-type").append('<li id="s5"><a id="sa5" href="javascript:void();" onclick="selectType(5);">文件柜</a></li>');
			$("#lt").val(3);
			$("#car-choose").hide();
			$("#door-choose").hide();
			$("#price").html("￥200.00");
			$("#p").val(200.00);
			break;
		}
		case 4: {
			$("#door-type").empty();
			$("#door-type").append('<li id="s1"><a id="sa1" href="javascript:void();" onclick="selectType(1)">防盗门</a></li>');
			$("#door-type").append('<li id="s2"><a id="sa2" href="javascript:void();" onclick="selectType(2);">汽车门</a></li>');
			$("#door-type").append('<li id="s3"><a id="sa2" onclick="selectType(3);">保险柜</a></li>');
			$("#door-type").append('<li id="s4" class="be-selected"><a  style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;" id="sa4" href="javascript:void();" onclick="selectType(4);">室内锁</a></li>');
			$("#door-type").append('<li id="s5"><a id="sa5" href="javascript:void();" onclick="selectType(5);">文件柜</a></li>');
			$("#lt").val(4);
			$("#car-choose").hide();
			$("#door-choose").hide();
			$("#price").html("￥80.00");
			$("#p").val(80.00);
			break;
		}
		case 5: {
			$("#door-type").empty();
			$("#door-type").append('<li id="s1"><a id="sa1" href="javascript:void();" onclick="selectType(1)">防盗门</a></li>');
			$("#door-type").append('<li id="s2"><a id="sa2" href="javascript:void();" onclick="selectType(2);">汽车门</a></li>');
			$("#door-type").append('<li id="s3"><a id="sa3" href="javascript:void();" onclick="selectType(3);">保险柜</a></li>');
			$("#door-type").append('<li id="s4"><a id="sa4" href="javascript:void();" onclick="selectType(4);">室内锁</a></li>');
			$("#door-type").append('<li id="s5"  class="be-selected"><a  style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;" id="sa5" href="javascript:void();" onclick="selectType(5);">文件柜</a></li>');
			$("#lt").val(5);
			$("#car-choose").hide();
			$("#door-choose").hide();
			$("#price").html("￥80.00");
			$("#p").val(80.00);
			break;
		}
	};
}

function selectAar(id) {
	switch(id){
	case 1: {
		$("#car-t").empty();
		$("#car-t").append('<li  class="be-selected"><a href="javascript:void(0);" onclick="selectAar(1)" style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;"><span >普通车</span><span>10万以下</span></a></li>');
		$("#car-t").append('<li><a href="javascript:void(0);" onclick="selectAar(2)"><span>中档车</span><span>10-20万</span></a></li>');
		$("#car-t").append('<li><a href="javascript:void(0);" onclick="selectAar(3)"><span>高档车</span><span>20万以上</span></a></li>');
		$("#price").html("￥100.00");
		$("#ct").val(1);
		$("#p").val(100.00);
		break;
	}
	case 2: {
		$("#car-t").empty();
		$("#car-t").append('<li><a href="javascript:void(0);" onclick="selectAar(1)"><span>普通车</span><span>10万以下</span></a></li>');
		$("#car-t").append('<li  class="be-selected"><a href="javascript:void(0);" onclick="selectAar(2)" style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;"><span >中档车</span><span>10-20万</span></a></li>');
		$("#car-t").append('<li><a href="javascript:void(0);" onclick="selectAar(3)"><span>高档车</span><span>20万以上</span></a></li>');
		$("#price").html("￥200.00");
		$("#ct").val(2);
		$("#p").val(200.00);
		break;
	}
	case 3: {
		$("#car-t").empty();
		$("#car-t").append('<li><a href="javascript:void(0);" onclick="selectAar(1)"><span>普通车</span><span>10万以下</span></a></li>');
		$("#car-t").append('<li><a href="javascript:void(0);" onclick="selectAar(2)"><span>中档车</span><span>10-20万</span></a></li>');
		$("#car-t").append('<li class="be-selected"><a href="javascript:void(0);" onclick="selectAar(3)" style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;"><span >高档车</span><span>20万以上</span></a></li>');
		$("#price").html("￥300.00");
		$("#ct").val(3);
		$("#p").val(300.00);
		break;
	}
	};
}

function selectLock(id) {
	switch(id){
	case 1: {
		$("#lock-t").empty();
		$("#lock-t").append('<li class="be-selected"><a href="javascript:void(0);" onclick="selectLock(1)" style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;">反锁</a></li>');
		$("#lock-t").append('<li><a href="javascript:void(0);" onclick="selectLock(2)">未反锁</a></li>');
		$("#il").val(0);
		break;
	}
	case 2: {
		$("#lock-t").empty();
		$("#lock-t").append('<li><a href="javascript:void(0);" onclick="selectLock(1)">反锁</a></li>');
		$("#lock-t").append('<li  class="be-selected"><a href="javascript:void(0);" onclick="selectLock(2)" style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;">未反锁</a></li>');
		$("#il").val(1);
		break;
	}
	
	};
}
</script>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a href="/"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span class="navber-word">开锁换锁</span></li>
<li></li>
</ul>
</nav>
<div class="lock-type"><span>请选择服务类型</span></div>
<div class="lock-choose">
<a href="javascript:void();">
<span class="open-img"></span>
<span class="open-title">开锁</span>
</a>
</div>
<!---选择服务类型结束-->
<section class="door-type">
<div class="door-type-title"><span>请选择锁具类型</span></div>
<div class="door-type-choose">
<ul id="door-type">
<li id="s1" class="be-selected"><a style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;" id="sa1" href="javascript:void();" onclick="selectType(1)">防盗门</a></li>
<li id="s2"><a id="sa2" href="javascript:void();" onclick="selectType(2);">汽车门</a></li>
<li id="s3"><a id="sa3" href="javascript:void();" onclick="selectType(3);">保险柜</a></li>
<li id="s4"><a id="sa4" href="javascript:void();" onclick="selectType(4);">室内锁</a></li>
<li id="s5"><a id="sa5" href="javascript:void();" onclick="selectType(5);">文件柜</a></li>
</ul>
</section>
<div class="car-choose" id="car-choose">
<ul id="car-t">
<li  class="be-selected"><a href="javascript:void(0);" onclick="selectAar(1)" style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;"><span>普通车</span><span>10万以下</span></a></li>
<li><a href="javascript:void(0);" onclick="selectAar(2)"><span>中档车</span><span>10-20万</span></a></li>
<li><a href="javascript:void(0);" onclick="selectAar(3)"><span>高档车</span><span>20万以上</span></a></li>
</ul>
</div>
<div class="door-type-choose" id="door-choose">
<ul id="lock-t">
<li class="be-selected"><a href="javascript:void(0);" onclick="selectLock(1)" style=" color:#00cced; border:1.5px solid #00cced; background:url(images/choosed.png) right bottom no-repeat #fff; background-size:25px;">反锁</a></li>
<li><a href="javascript:void(0);" onclick="selectLock(2)">未反锁</a></li>
</ul>
</div>
<form action="${pageContext.request.contextPath}/goods/buyJob.html" method="post" id="lockForm">
<!---选项结束---->
<div class="message">
<input name="serviceType" value="1" type="hidden"/>
<input name="lockType" id="lt" type="hidden"/>
<input name="carType" id="ct" type="hidden"/>
<input name="isLock" id="il" type="hidden"/>
<input name="price" id="p" type="hidden">
<input type="text" class="take-message"  placeholder="如有特殊需求，请留言"/>
</div>
</form>
<div class="recomend">
<p>温馨提示：</p>
<span>1.开锁师傅上门即会出示专业证件，请客户确认身份师傅后继续开锁
服务。<br>
2.服务人员上门后，因客户原因无法维修或更换，取消订单将收取30
元上门费，请谨慎下单。<br>
3.因开锁服务的特殊性，门锁开启后请出示房屋隶属关系证明。</span>
</div>
<div class="pay-now">


<ul>
<li style=" text-align:right"><button class="money-btn" id="btn_sub">下一步</button></li>
<li style="text-align:center">总额：<span id="price">￥0</span></li>
</ul>
</div>
</div>
</div>
</div>
</body>

</html>
