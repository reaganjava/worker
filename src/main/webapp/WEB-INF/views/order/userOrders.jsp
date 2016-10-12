<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" >  
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css"/>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<title>我的订单</title>
</head>

<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<div class="order-type">
<ul>
<c:if test="${status == 1}">
<li class="not-service"><a style="color:#f30;">待付款</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/2/1.html" >待服务</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/3/1.html">待验收</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/4/1.html">退款中</a></li>
</c:if>
<c:if test="${status == 2}">
<li><a href="${pageContext.request.contextPath}/order/userOrders/1/1.html" >待付款</a></li>
<li class="not-service"><a style="color:#f30;" >待服务</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/3/1.html">待验收</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/4/1.html">退款中</a></li>
</c:if>
<c:if test="${status == 3}">
<li><a href="${pageContext.request.contextPath}/order/userOrders/1/1.html" >待付款</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/2/1.html" >待服务</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/3/1.html">待验收</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/4/1.html">退款中</a></li>
</c:if>
<c:if test="${status == 4}">
<li><a href="${pageContext.request.contextPath}/order/userOrders/1/1.html" >待付款</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/2/1.html" >待服务</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/3/1.html">待验收</a></li>
<li class="not-service"><a style="color:#f30;" >退款中</a></li>
</c:if>
</ul>
</div>
<!--分类结束-->
<div class="clean"></div>
<c:forEach items="${PAGE_BEAN.dataList}" var="order">
<section class="order">
<div class="order-title"><span>下单时间：<fmt:formatDate value="${order.createTime}"  type="BOTH" dateStyle="full"/></span><a href="${pageContext.request.contextPath}/order/orderDetail/${order.id}.html"><span class="o-more"></span></a></div>
<div class="order-detail">
<ul>
<li>订单号：<span>${order.wOOrderNo}</span></li>
<li>服务类型：<span>${order.wOServiceName}</span></li>
</ul>
<div class="cancle-btn">
<c:if test="${status == 1}">
<a href="${pageContext.request.contextPath}/order/payOrder/${order.id}.html">立即支付</a>
</c:if>
<c:if test="${status == 2}">
<a href="javascript:;" onclick="cancelShow(${order.id})">取消订单</a>
</c:if>
<c:if test="${status == 3}">
<button onclick="confirmOrder(${order.id})">确认订单</button>
</c:if>
</div>
</div>
</section>
</c:forEach>
<div class="cancle-remaind" style="display:none;">
<div class="cr-title"><span>温馨提示：服务前2小时取消订单，我们将收取全款50%的误工费。</span></div>
<div class="cr-btn">
<ul>
<li><a><button>确定</button></a></li>
<li><a><button>返回</button></a></li></ul></div>
</div>
<!---弹窗开始---->
<div class=" time-pop-ups" style=" display:none" id="cancelInfo">
<form class="f-time">
<input type="radio" name="time" value="1" onclick="cancel(1)">时间定错了<br>
<input type="radio" name="time" value="2" onclick="cancel(2)">位置定错了<br>
<input type="radio" name="time" value="3" onclick="cancel(3)">不需要了<br>
<input type="radio" name="time" value="4" onclick="cancel(4)">其他原因<br>
</form>
</div>
</div>
</div>
</div>
<!--内容结束--->
<div class="footerbar">
<ul class="footer-icon">
<li><a href="${pageContext.request.contextPath}/index.html"><img src="${pageContext.request.contextPath}/images/index-icon.png"/><span>首页</span></a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/1/1.html"><img src="${pageContext.request.contextPath}/images/order-icon-now.png"/><span class="be-now">订单</span></a></li>
<li><a href="javascript:void();"><img src="${pageContext.request.contextPath}/images/sale-icon.png"/><span>优惠券</span></a></li>
<li><a href="${pageContext.request.contextPath}/members/accountInfo.html"><img src="${pageContext.request.contextPath}/images/mine.png"/><span>我的</span></li>
</ul>
</div>
<!---内容结束-->
</body>
<script type="text/javascript">
	var id = 0;
	function cancelShow(v) {
		id = v;
		$("#cancelInfo").show();
	}
	function cancel(index) {
		alert(id + ":" + index);
		$.ajax({
			  url: "${pageContext.request.contextPath}/order/cancel/" + id + "/" + index + ".json",
			  success:function(data) {
				  if(data != 0) {
					 alert('已经提交取消申请等待管理员确认！');
				  }
			  }
			});
	}
</script>
</html>
