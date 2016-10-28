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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css"/>
<title>我的优惠券</title>
</head>
<body style="overflow-y:scroll;">
<div class="xsh">
  <div class="page-all">
    <div class="container">
    <!--兑换码页面
      <div class="hey-serch">
        <input id="couponCode" maxlength="10" class="hey-num" type="number" placeholder="10 位兑换码" value="">
        <a class="hey-btn" href="javascript:;"></a> </div>
      <!--优惠券开始-->
      <div class="fragment-scroller hey-fragment-scroller u-s-n">
        <div class="hey-txt"> <span>已有券(<span>${MEMBER_COUPON_SIZE}</span>)</span> <a class="hey-sort" href="javascript:;"></a></div>
       <c:forEach items="${MEMBER_COUPON_LIST}" var="coupon">
        <div class="hey-list hey-active1">
          <div class="hey-list-t">
          <c:if test="${coupon.wMcCouponType == 1}">
          <span class="hey-rmb-icon">￥</span><span class="hey-rmb-num">${coupon.wMcMoney}</span>
          </c:if>
          <c:if test="${coupon.wMcCouponType == 2}">
          <span class="hey-rmb-icon">优惠</span><span class="hey-rmb-num">${coupon.discount}%</span>
          </c:if>
            <div class="p-c-w"><span>${coupon.wMcCouponTitle}</span><br/></div>
            </div>
          <div class="hey-list-b"><span>有效 <span><fmt:formatDate value="${coupon.wMcDeadline}"  type="BOTH" dateStyle="full"/>前</span></span></div>
          </div>
         </c:forEach>
      </div>
      <!--内容结束--> 
    </div>
  </div>
</div>
<!--内容结束--->
<div class="footerbar">
<ul class="footer-icon">
<li><a href="${pageContext.request.contextPath}/index.html"><img src="${pageContext.request.contextPath}/images/index-icon.png"/><span>首页</span></a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/1.html"><img src="${pageContext.request.contextPath}/images/order-icon.png"/><span>订单</span></a></li>
<li><a href="${pageContext.request.contextPath}/members/couponList.html"><img src="${pageContext.request.contextPath}/images/sale-icon-now.png"/><span class="be-now">优惠券</span></a></li>
<li><a href="${pageContext.request.contextPath}/members/accountInfo.html"><img src="${pageContext.request.contextPath}/images/mine.png"/><span>我的</span></li>
</ul>
</div>
<!---内容结束-->
</body>
</html>
