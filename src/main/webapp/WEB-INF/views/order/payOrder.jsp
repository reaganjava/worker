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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css?v=0.1" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css?v=0.1"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
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
<li>服务类型：<span>${ORDER_INFO.orderDetailDO.wOServerName}</span></li>
<li>服务地址：<span>${ORDER_INFO.orderDetailDO.wODistrict}${ORDER_INFO.orderDetailDO.wOAddress} <i>${ORDER_INFO.orderDetailDO.wOContact}  电话:${ORDER_INFO.orderDetailDO.wOTelephone}</i></span></li>
<li>服务时长：<span>${ORDER_INFO.orderDetailDO.wOServerTime}小时</span></li>
<li>服务时间：<span><fmt:formatDate value="${ORDER_INFO.orderDetailDO.wOSubscribe}"  type="BOTH" dateStyle="full"/>上门</span></li>
<li>费用明细：<span>${ORDER_INFO.orderDetailDO.wOPrice}元 X ${ORDER_INFO.orderDetailDO.wOServerTime}小时</span></li>
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
<h4>服务内容</h4>
<ul class="c-content">
<li><span>厨房大扫除<i>（不包括抽油烟机拆洗）</i></span></li>
<li><span>客厅大扫除<i>（不包括天花板及灯具拆洗，地毯清洗）</i></span></li>
<li><span>卧室大扫除<i>（不包括天花板及灯具拆洗）</i></span></li>
<li><span>阳台大扫除<i>（不包括2楼以上玻璃）</i></span></li>
<li><span>卫生间大扫除<i>（不包括2楼以上玻璃）</i></span></li>
</ul>
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
<li style=" text-align:right"><button class="money-btn" onClick="getUserCode()">立即支付</button></li>
<li style="text-align:center"><span>￥${ORDER_INFO.wOFee}</span></li>
</ul>
</div>
</div>
</div>
</div>
</body>
<script type="text/javascript">
	function getUserCode() {
		window.location ="${pageContext.request.contextPath}/pay/getCode/${ORDER_INFO.wOOrderNo}.html";
	}
</script>
</html>
