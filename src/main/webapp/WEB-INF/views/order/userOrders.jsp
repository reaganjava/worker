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
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css"/>
<title>我的订单</title>
</head>

<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<div class="order-type">
<ul>
<li><a>待付款</a></li>
<li class="not-service"><a style="color:#f30;">待服务</a></li>
<li><a>待验收</a></li>
</ul>
</div>
<!--分类结束-->
<div class="clean"></div>
<c:forEach items="${PAGE_BEAN.dataList}" var="order">
<section class="order">
<div class="order-title"><span>下单时间：${order.formatDate}</span><a href="javascript:void()"><span class="o-more"></span></a></div>
<div class="order-detail">
<ul>
<li>订单号：<span>${order.wOOrderNo}</span></li>
<li>服务名称：<span>${order.wOServiceName}</span></li>
<li>服务费用：<span>${order.wOFee}元</span></li>
<li>订单状态：
<c:if test="${order.wOIsPay == 0}" >
<span>未支付</span>
</c:if>
<c:if test="${order.wOIsPay == 1}"  >
<span>已支付</span>
</c:if>
</li>
</ul>
<div class="cancle-btn"><button>取消订单</button></div>
</div>
</section>
</c:forEach>
<!--内容结束--->
<div class="footerbar">
<ul class="footer-icon">
<li><a href="${pageContext.request.contextPath}/index.html"><img src="${pageContext.request.contextPath}/images/index-icon-now.png"/><span>首页</span></a></li>
<li><a href="javascript:void();"><img src="${pageContext.request.contextPath}/images/order-icon.png"/><span>订单</span></a></li>
<li><a href="javascript:void();"><img src="${pageContext.request.contextPath}/images/sale-icon.png"/><span>优惠券</span></a></li>
<li><a href="${pageContext.request.contextPath}/members/accountInfo.html"><img src="${pageContext.request.contextPath}/images/mine.png"/><span>我的</span></a></li>
</ul>
</div>
<!---内容结束-->
<div class="cancle-remaind" style="display:none;">
<div class="cr-title"><span>温馨提示：服务前2小时取消订单，我们将收取全款50%的误工费。</span></div>
<div class="cr-btn">
<ul>
<li><a><button>确定</button></a></li>
<li><a><button>返回</button></a></li></ul></div>
</div>
<!---弹窗开始---->
<div class=" time-pop-ups" style=" display:none">
<form class="f-time">
<input type="radio" name="time" value="t-1">时间定错了<br>
<input type="radio" name="time" value="t-2">位置定错了<br>
<input type="radio" name="time" value="t-3">不需要了<br>
<input type="radio" name="time" value="t-4">其他原因<br>
</form>
</div>
</div>
</div>
</div>
</body>
</html>
