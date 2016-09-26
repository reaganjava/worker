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
	 	   
 	   	$("#pipForm").submit();
 	   
 	});
});

function selectToitle(t) {
	switch(t){
		case 1: {
			$("#toitle-type").empty();
			$("#toitle-type").append('<a style=" border:1px solid #00cced;" href="javascript:void();" onclick="selectToitle(1)"><span style="width:100px; height:50px; background:url(${pageContext.request.contextPath}/images/squat-selected.png) center center no-repeat; background-size:50px; display:block; margin-top:10px;"></span><span class="squat-title" style="color:#00cced;">便池疏通</span></a>');
			$("#toitle-type").append('<a href="javascript:void();" onclick="selectToitle(2)"><span style="width:100px; height:50px; background:url(${pageContext.request.contextPath}/images/matong.png) center center no-repeat; background-size:50px; display:block;  margin-top:10px;"></span><span class="sit-title">马桶疏通</span></a>');
			$("#tt").val(1);
			break;
		}
		case 2: {
			$("#toitle-type").empty();
			$("#toitle-type").append('<a href="javascript:void();"  href="javascript:void();" onclick="selectToitle(1)"><span style="width:100px; height:50px; background:url(${pageContext.request.contextPath}/images/squat.png) center center no-repeat; background-size:50px; display:block; margin-top:10px;"></span><span class="squat-title">便池疏通</span></a>');
			$("#toitle-type").append('<a style=" border:1px solid #00cced;"  href="javascript:void();" onclick="selectToitle(2)"><span style="width:100px; height:50px; background:url(${pageContext.request.contextPath}/images/matong-selected.png) center center no-repeat; background-size:50px; display:block;  margin-top:10px;"></span><span class="sit-title" style="color:#00cced;">马桶疏通</span></a>');
			$("#tt").val(2);
			break;
		}
	
	};
	
}
</script>
<title>管道疏通</title>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<div class="lock-type"><span>请选择服务类型</span></div>
<div class="lock-choose">
<a href="${pageContext.request.contextPath}/goods/pip.html"">
<span class="open-img" style=" background:url(${pageContext.request.contextPath}/images/kitchen.png) center center no-repeat; background-size:50px; "></span>
<span class="change-title">厨房管道疏通</span>
</a>
<a  href="javascript:void();">
<span class="change-img" style=" background:url(${pageContext.request.contextPath}/images/toilet-selected.png) center center no-repeat; background-size:50px; "></span>
<span class="open-title">卫生间管道疏通</span>
</a>
</div>
<!---选择服务类型结束-->
<section class="toilet-type">
<div class="toilet-type-title"><span>请选择卫生间类型</span></div>
<div class="choose-toilet" id="toitle-type">
<a style=" border:1px solid #00cced;" href="javascript:void();" onclick="selectToitle(1)">
<span style="width:100px; height:50px; background:url(${pageContext.request.contextPath}/images/squat-selected.png) center center no-repeat; background-size:50px; display:block; margin-top:10px;"></span>
<span class="squat-title" style="color:#00cced;">便池疏通</span>
</a>
<a href="javascript:void();" onclick="selectToitle(2)">
<span style="width:100px; height:50px; background:url(${pageContext.request.contextPath}/images/matong.png) center center no-repeat; background-size:50px; display:block;  margin-top:10px;"></span>
<span class="sit-title">马桶疏通</span>
</a>
</div>
</section>
<!---卫生间类型选择结束--->
<form action="${pageContext.request.contextPath}/goods/buyJob.html" method="post" id="pipForm">
<input name="serviceType" value="2" type="hidden"/>
<input name="pipType" value="2" type="hidden"/>
<input name="toiletType" id="tt" type="hidden"/>
<div class="message">
<input type="text" class="take-message" placeholder="如有特殊需求，请留言">
</div>
</form>
<!---留言结束--->
<div class="recomend">
<p>温馨提示：</p>
<span>1、目前仅提供家庭式管道疏通，即疏通长度5米之内。<br>
2、服务人员上门后，因客户原因无法维修或更换，取消订单将收取30
元上门费，请谨慎下单。<br>
3、如上门检查后，因技师原因无法疏通，则退回全部相关费用。<br>
4、维修过程当中，请保持水电畅通。</span>
</div>
<div class="pay-now">
<ul>
<li style=" text-align:right"><button class="money-btn" id="btn_sub">下一步</button></li>
<li style="text-align:center">总额：<span>￥100</span></li>
</ul>
</div>
</div>
</div>
</div>
</body>
</html>
