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
<script type="text/javascript">
$(document).ready(function(){
	$("#btn_sub").click(function(){ 
 	   	$("#toiletForm").submit();
 	});
});

function selectToitle(t) {
	switch(t){
		case 1: {
			$("#toitle-type").empty();
			$("#toitle-type").append('<li class="be-selected"><a style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;">马桶漏水</a></li>');
			$("#toitle-type").append('<li><a href="javascript:void();" onclick="selectToitle(2);">无法冲水</a></li>');
			$("#tt").val(1);
			break;
		}
		case 2: {
			$("#toitle-type").empty();
			$("#toitle-type").append('<li><a href="javascript:void();" onclick="selectToitle(1);">马桶漏水</a></li>');
			$("#toitle-type").append('<li  class="be-selected"><a style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;" href="javascript:void();" onclick="selectToitle(2);">无法冲水</a></li>');
			$("#tt").val(2);
			break;
		}
	
	};
	
}
</script>
<title>马桶维修</title>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<div class="lock-type"><span>请选择服务类型</span></div>
<div class="lock-choose">
<a>
<span class="open-img" style=" background:url(${pageContext.request.contextPath}/images/totile-selected.png) center center no-repeat; background-size:50px; "></span>
<span class="open-title">马桶维修</span>
</a>
</div>
<!---选择服务类型结束-->
<div class="door-type-choose" style=" height:74px; background:#fff; margin-top:15px;">
<ul id="toitle-type">
<li class="be-selected"><a href="javascript:void();" onclick="selectToitle(1);" style=" color:#00cced; border:1.5px solid #00cced; background:url(${pageContext.request.contextPath}/images/choosed.png) right bottom no-repeat #fff; background-size:25px;">马桶漏水</a></li>
<li><a href="javascript:void();" onclick="selectToitle(2);">无法冲水</a></li>
</ul>
</div>
<form action="${pageContext.request.contextPath}/goods/buyJob.html" method="post" id="toiletForm">
<input name="serviceType" value="3" type="hidden"/>
<input name="damageType" id="tt" type="hidden"/>
<!---选项结束---->
<div class="message">
<input type="text" class="take-message" name="message" placeholder="如有特殊需求，请留言">
</div>
</form>
<!---留言结束--->
<div class="recomend">
<p>温馨提示：</p>
<span>1、本服务包含材料费。<br>
2.服务人员上门后，因客户原因无法维修或更换，取消订单将收取30
元上门费，请谨慎下单。<br>
3、如上门检查后，因技师原因无法修理，则退回全部相关费用。<br>
4、维修过程当中，请保持水电畅通。</span>
</div>
<div class="pay-now">
<ul>
<li style=" text-align:right"><button class="money-btn" id="btn_sub">下一步</button></li>
<li style="text-align:center">总额：<span>￥150</span></li>
</ul>
</div>
</div>
</div>
</div>
</body>
</html>

