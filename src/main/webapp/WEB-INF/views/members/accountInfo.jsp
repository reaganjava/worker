<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">   
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" >  
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css"/>
<title>个人中心</title>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<div class="mine_photo"> <dl id="login_in"> <dt id="people_photo"><img src="${pageContext.request.contextPath}/images/mine-photo.png"/> </dt><dd>${MEMBER_INFO.wMMobile}</dd></dl></div>
<section class=" member-right">
<div class="my-right">
<a href="${pageContext.request.contextPath}/order/userOrders/1/1.html"><span class="stuff-title">${MEMBER_INFO.orderCount}</span><span class="stuff-service">订单</span></a>
<a href="javascript:void();"><span class="stuff-title">${MEMBER_INFO.couponsCount}</span><span class="stuff-service">优惠券</span></a>
<a href="javascript:void();"><span class="stuff-title">0</span><span class="stuff-service">特权</span></a>
</div>
</section>
<section>
<div class="rights">
<a><span class=" recommend">推荐享优惠</span></a>
<a href=""javascript:void();"><span class="fankui">意见反馈</span></a>
<a href="${pageContext.request.contextPath}/members/accountPassword.html"><span class="fankui">修改密码</span></a>
<a><span class="kefu-number">客服热线 400-870-2588</span></a>
<div class="rights-down" style="margin-top:30px;"><a style="color:#ff055d;" href="${pageContext.request.contextPath}/members/loginout.html"><span class="quit">退出</span></a></div>
</div>
</section>
<!--内容 end--->
<div class="footerbar">
<ul class="footer-icon">
<li><a href="${pageContext.request.contextPath}/index.html"><img src="${pageContext.request.contextPath}/images/index-icon.png"/><span>首页</span></a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/1/1.html"><img src="${pageContext.request.contextPath}/images/order-icon.png"/><span>订单</span></a></li>
<li><a href="${pageContext.request.contextPath}/members/couponList.html"><img src="${pageContext.request.contextPath}/images/sale-icon.png"/><span>优惠券</span></a></li>
<li><a href="${pageContext.request.contextPath}/members/accountInfo.html"><img src="${pageContext.request.contextPath}/images/mine-icon-now.png"/><span class="be-now">我的</span></li>
</ul>
</div>
</div>
</div>
</div>
</body>
</html>
