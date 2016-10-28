<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/wei-index.css?v=0.1" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/out-use.css?v=0.1" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script>
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
							<li>服务类型：<span>${ORDER_INFO.wOServiceName}</span></li>
							<li>服务地址：<span>${ORDER_INFO.orderDetailDO.wODistrict}${ORDER_INFO.orderDetailDO.wOAddress}
									<i>${ORDER_INFO.orderDetailDO.wOContact}
										电话:${ORDER_INFO.orderDetailDO.wOTelephone}</i>
							</span></li>
							<li>服务时长：<span>${ORDER_INFO.orderDetailDO.wOServerTime}小时</span></li>
							<li>服务时间：<span><fmt:formatDate
										value="${ORDER_INFO.orderDetailDO.wOSubscribe}" type="BOTH"
										dateStyle="full" />上门</span></li>
							<li>费用明细：<span>${ORDER_INFO.orderDetailDO.wOPrice}元 X
									${ORDER_INFO.orderDetailDO.wOServerTime}小时</span></li>
						</ul>
						<!-- <p class="tui">服务前<i>2小时</i>取消订单，将扣除您50%的服务费用</p> -->
						<hr>
						<div class="Actual-pay">
							<span class="all-pay">服务全款</span> <span class="rel-pay">${ORDER_INFO.wOFee}元</span>
						</div>
					</div>
				</section>
				<!--预订信息 end-->
				<section class="service-cont">
					<div class="service-co"></div>
				</section>
				<!--服务内容 end-->
				<section class="sale-info">
					<div class="sale-in">
						
							优惠： <select id="sales" style="background-size:20px;">
							<option value="0">请使用优惠券</option>
							 <c:forEach items="${MEMBER_COUPON_LIST}" var="coupon">
								<option value="${coupon.id}">${coupon.wMcMoney}元优惠劵</option>
							 </c:forEach>
							</select>
						
					</div>
				</section>
				<!---优惠结束--->
				<div class="pay-now">
					<ul>
						<li style="text-align: right"><button class="money-btn"
								onClick="payInfo()">支付详情</button></li>
						<li style="text-align: center"><span>￥${ORDER_INFO.wOFee}</span></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function payInfo() {
		var couponId = $("#sales").val();
		window.location = "${pageContext.request.contextPath}/pay/payInfo/${ORDER_INFO.wOOrderNo}/" + ${ORDER_INFO.wOFee} + "/" + couponId + ".html";
		
	}
</script>
</html>
