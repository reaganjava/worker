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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css?v=0.1" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css?v=0.1"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/icheck/jquery.icheck.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/Validform/5.3.2/Validform.min.js?v=0.1"></script>
<title>确认订单</title>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<section class="order-details">
<div class="ding">
<h4>预订信息</h4>
<ul>
<li>服务类型：<span>${ORDER_INFO.orderTaskDO.wOTaskName}</span></li>
<li>服务地址：<span>${ORDER_INFO.orderDetailDO.wODistrict}${ORDER_INFO.orderDetailDO.wOAddress} <i>${ORDER_INFO.orderDetailDO.wOContact}  电话:${ORDER_INFO.orderDetailDO.wOTelephone}</i></span></li>
<li>服务时长：<span>${ORDER_INFO.orderTaskDO.wOTaskHours}小时</span></li>
<li>服务时间：<span>${ORDER_INFO.orderDetailDO.wOSubscribe}上门</span></li>
<li>费用明细：<span>${ORDER_INFO.orderTaskDO.wOTaskPrice}元 X ${ORDER_INFO.orderTaskDO.wOTaskHours}小时</span></li>
</ul>
<p class="tui">服务前<i>2小时</i>取消订单，将扣除您50%的服务费用</p>
<hr>
<div class="Actual-pay">
<span class="all-pay">服务全款</span>
<span class="rel-pay">${ORDER_INFO.wOFee}元</span>
</div>
</div>
</section>
<!--预订信息 end-->
<section class="service-cont">
<div class="service-co">
${WORKER_TASK_INFO}
</div>
</section>
<!--服务内容 end-->
<section class="sale-info">
<div class="sale-in">
<form action="">
优惠：
<select name="sales">
<option value="9zhe">银牌会员 永久9.9折</option>
<option value="30">临时保洁30元优惠劵</option>
<option value="20">临时保洁20元优惠劵</option>
<option value="10">临时保洁10元优惠劵</option>
</select>
</form>
</div>
</section>
<!---优惠结束--->
<div class="pay-now">
<ul>
<li style=" text-align:right"><button class="money-btn">立即支付</button></li>
<li style="text-align:center"><span>￥${ORDER_INFO.wOFee}</span></li>
</ul>
</div>
</div>
</div>
</div>
</body>
</html>
