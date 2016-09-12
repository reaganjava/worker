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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css?v=0.1"/>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css?v=0.1"/>
<title>订单详情</title>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a href="${pageContext.request.contextPath}/order/userOrders/1/1.html"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span>订单详情</span></li>
<li></li>
</ul>
</nav>
<div class="clean"></div>
<!--导航结束-->
<!--订单详情开始-->
<div class="clean"></div>
<div class="ding" style=" border:1px solid #c0c0c0; width:96%; padding:5px 0 15px 30px; margin-top:20px; background:#FFF">
<h4>预订信息</h4>
<ul>
<li>订单编号：<span>${ORDER_INFO.wOServiceName}</span></li>
<li>联系人&nbsp; &nbsp;：<span>${ORDER_INFO.orderDetailDO.wOContact}</span></li>
<li>联系电话：<span>${ORDER_INFO.orderDetailDO.wOTelephone}</span></li>
<li>服务地址：<span>${ORDER_INFO.orderDetailDO.wOAddress} </span></li>
<li>服务时长：<span>${ORDER_INFO.orderDetailDO.wOServerTime}小时</span></li>
<li>服务人数：<span>${ORDER_INFO.orderDetailDO.wOStaffCount}人</span></li>
<li>服务时间：<span><fmt:formatDate value="${ORDER_INFO.orderDetailDO.wOSubscribe}"  type="BOTH" dateStyle="full"/></span></li>
<li>实际付款：<span>${ORDER_INFO.orderDetailDO.wOPrice}</span></li>
</ul>
</div>
</div>
</div>
<div class="order-st"><span>订单状态</span><img src="${pageContext.request.contextPath}/images/时钟1.png"/><span>待服务</span></div>
</div>
</body>
</html>