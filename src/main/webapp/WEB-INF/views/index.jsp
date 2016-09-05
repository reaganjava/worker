<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css" />
<title>新生活首页</title>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<div class="banner">
<div class="nav-box"><a><span class="city-btn-bg">重庆</span><span class="expand-city"></span></a></div>
<div class="banner-img"><a><img src="${pageContext.request.contextPath}/images/banner.jpg"/></a></div>
<div class="banner-slider"><span class="slider"></span></div>
</div>
<!---banner-end-->
<div class="home-service-box">
<ul class="home-service">
<li><a href="${pageContext.request.contextPath}/goods/clean.html"><img src="${pageContext.request.contextPath}/images/house-clean.png"/><span>临时保洁</span></a></li>
<li><a><img src="${pageContext.request.contextPath}/images/hour-worker.png"/><span>长期钟点工</span></a></li>
<li><a><img src="${pageContext.request.contextPath}/images/bao-mu.png"/><span>住家保姆</span></a></li>
<li><a><img src="${pageContext.request.contextPath}/images/yuer-sao.png"/><span>育儿嫂</span></a></li>
<li><a><img src="${pageContext.request.contextPath}/images/yue-sao.png"/><span>月嫂</span></a></li>
<li><a><img src="${pageContext.request.contextPath}/images/hospital-icon.png"/><span>医院护工</span></a></li>
<li><a><img src="${pageContext.request.contextPath}/images/old-icon.png"/><span>看护老人</span></a></li>
</ul>
</div>
<!---icon-end-->
<div class="footerbar">
<ul class="footer-icon">
<li><a href="javascript:void();"><img src="${pageContext.request.contextPath}/images/index-icon-now.png"/><span>首页</span></a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/1.html"><img src="${pageContext.request.contextPath}/images/order-icon.png"/><span>订单</span></a></li>
<li><a href="javascript:void();"><img src="${pageContext.request.contextPath}/images/sale-icon.png"/><span>优惠券</span></a></li>
<li><a href="${pageContext.request.contextPath}/members/accountInfo.html"><img src="${pageContext.request.contextPath}/images/mine.png"/><span>我的</span></a></li>
</ul>
</div>
<!--底部结束-->
<div class="tan-qidai" style="display:none;">敬请期待</div>
</div>
</div>
</div>
</body>
</html>
