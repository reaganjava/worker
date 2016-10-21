<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<title>支付确认页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<form action="${pageContext.request.contextPath}/pay/confirm.html" method="POST" id="confirmForm">
<input type="hidden" value="${PAY_INFO.id}" name="id"/> 
<input type="hidden" value="${COUPON_ID}" name="couponId"/> 
<nav class="navbar">
<ul>
<li><a href="javascript:void();" onclick="window.history.back(-1);"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span class="navber-word">支付确认</span></li>
<li></li>
</ul>
</nav>
<!---导航结束--->
<section class="pay-info">
<p>订单号：<span>${PAY_INFO.wPrOrderNo}</span></p>
<input type="hidden" value="${PAY_INFO.wPrOrderNo}" name="wPrOrderNo"/> 
<p>订单总价：<span class="pay-price">￥${PAY_INFO.wPrFee}元<c:if test="${PAY_INFO.wPrIsCoupon != 0}"> 优惠 ￥${PAY_INFO.wPrCouponPrice}元</c:if></span></p>
</section>
<!--订单信息-->
<section class="pays">
<p>支付方式：</p>
<div class="payby">
<a class="we-icon"><img src="${pageContext.request.contextPath}/images/weichat.png"/><span>微信支付</span></a>
<input type="hidden" value="0" name="payChannelValue"/> 
</div>
</section>
<!---支付方式--->
<div>
<a class="sure-pay" href="javascript:void();" id="btn_sub">确认支付</a>
</div>
</form>
</div>
</div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
		var isView = false;
	 	$("#btn_sub").click(function(){
	 	    var is = true;
	 	
	 	   	if(is) {
	 	   		$("#confirmForm").submit();
	 	   	}
	 	});
	 });
</script>
</html>