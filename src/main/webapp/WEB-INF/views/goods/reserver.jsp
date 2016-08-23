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
<a><input type="text" class="choose-date" value="选择日期" onClick="selectDate()" id="weekDate"/></a>
<a><input type="text" class="choose-hour" value="选择时间" onClick="selectTime()" id="viewTime"/></a>
</div>
</div>
</section>
<!--添加时间结束-->
<p class="remind">如果阿姨因为各种原因早到或晚到一会儿（15分钟左右）请不用担心她会保证服务时长的~</p>
<div class="choose-next">
<a class="tab-bar-btn"  data-service="家庭保洁" href="javascript:void(0)" onClick="getOrder()" >确定</a>
</div>
<!--弹窗 begin-->
<div class="date-pop-ups" style="display:none" id="date">

<c:forEach items="${WEEK_DATE_LIST}" var="dateValueDO">
<input type="radio" onClick="getDate('${dateValueDO.weekDate}', '${dateValueDO.dateValue}')">${dateValueDO.weekDate}<br>
</c:forEach>

</div>
<div class=" time-pop-ups" style="display:none" id="time">

<input type="radio"  onClick="getTime('13:30')">13:30<br>
<input type="radio"  onClick="getTime('14:00')">14:00<br>
<input type="radio"  onClick="getTime('14:30')">14:30<br>
<input type="radio"  onClick="getTime('15:00')">15:00<br>
<input type="radio"  onClick="getTime('15:30')">15:30<br>
<input type="radio"  onClick="getTime('16:00')">16:00<br>
<input type="radio"  onClick="getTime('16:30')">16:30<br>
<input name="subDate" type="hidden" id="dateValue"/>
<input name="subTime" type="hidden" id="timeValue"/>

</div>
</div>
</div>
</div>
</form>
</body>
<script type="text/javascript">
	function selectDate() {
		document.getElementById('date').style.display="inline"; 
		document.getElementById('time').style.display="none"; 
	}
	
	function selectTime() {
		document.getElementById('date').style.display="none"; 
		document.getElementById('time').style.display="inline"; 
	}
	
	function getDate(weekDate, dateValue) {
		document.getElementById('date').style.display = "none";
		document.getElementById('weekDate').value = weekDate;
		document.getElementById('dateValue').value = dateValue;
	}
	function getTime(timeValue) {
		document.getElementById('time').style.display = "none";
		document.getElementById('viewTime').value = timeValue;
		document.getElementById('timeValue').value = timeValue;
	}
	
	function getOrder() {
		document.getElementById('orderForm').submit();
	}
</script>
</html>
