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
<title>预订页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/order/getOrder.html" method="POST" id="orderForm">
<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a href="${pageContext.request.contextPath}/goods/job.html"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span>预定临时保洁</span></li>
<li></li>
</ul>
</nav>
<section class="add-address">
<c:if test="${CONTACT_DEFAULT == null}">
<p>您还没有服务地址哟，请点击添加服务地址</p>
</c:if>
<c:if test="${CONTACT_DEFAULT != null}">
<p>服务地址：${CONTACT_DEFAULT.wCAddress}</p>
<p>联系人：${CONTACT_DEFAULT.wCContact}</p>
<p>联系电话：${CONTACT_DEFAULT.wCTelephone}</p>
</c:if>
<div class="add-ads">
<div class="a-ads">
<a href="${pageContext.request.contextPath}/members/contacts.html"><img  src="${pageContext.request.contextPath}/images/add-icon.png"/><span>添加服务地址</span></a>
</div>
</div>
</section>
<!--添加地址结束-->
<section class="add-time">
<div class="choose-time">
<span class="time-words">请选择服务时间</span>
<div class="time-input">
<select name="subDate" style="width:130px;">
<c:forEach items="${WEEK_DATE_LIST}" var="dateValueDO">
<option value="${dateValueDO.dateValue}">${dateValueDO.weekDate}<br>
</c:forEach>
</select>


<select name="subTime" style=" width:80px;">
<option value="8:00">8:00</option>
<option value="8:30">8:30</option>
<option value="9:00">9:00</option>
<option value="9:30">9:30</option>
<option value="10:00">10:00</option>
<option value="10:30">10:30</option>
<option value="11:00">11:00</option>
<option value="11:30">11:30</option>
</select>

</div>
</div>
</section>
<!--添加时间结束-->
<p class="remind">如果阿姨因为各种原因早到或晚到一会儿（15分钟左右）请不用担心她会保证服务时长的~</p>
<div class="choose-next">
<a class="tab-bar-btn"  data-service="家庭保洁" href="javascript:void(0)" id="btn_sub" >确定</a>
</div>
</div>
</div>
</div>
</div>
</form>
</body>
<script type="text/javascript">
	
	$(document).ready(function(){
		var isView = false;
	 	$("#btn_sub").click(function(){
	 	    var is = true;
	 	
	 	   	if(is) {
	 	   		$("#orderForm").submit();
	 	   	}
	 	});
	 });
</script>
</html>
