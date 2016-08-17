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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css"/>
<title>预订页面</title>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a href="${pageContext.request.contextPath}/task.html"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
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
<a><input type="text" class="choose-date" value="8月15日（今天）" onClick="selectDate()" id="dateValue"/></a>
<a><input type="text" class="choose-hour" value="14:00" onClick="selectTime()" id="timeValue"/></a>
</div>
</div>
</section>
<!--添加时间结束-->
<p class="remind">如果阿姨因为各种原因早到或晚到一会儿（15分钟左右）请不用担心她会保证服务时长的~</p>
<div class="choose-next">
<a class="tab-bar-btn"  data-service="家庭保洁" href="确认订单.html" >确定</a>
</div>
<!--弹窗 begin-->
<div class="date-pop-ups" style="display:none" id="date">
<form name="f-date">
<input type="radio" name="date" value="d-1" onClick="getDate('8-8')">8 月 8日（今天）<br>
<input type="radio" name="date" value="d-2" onClick="getDate('8-9')">8 月 9日（明天）<br>
<input type="radio" name="date" value="d-3" onClick="getDate('8-10')">8月10日（周三）<br>
<input type="radio" name="date" value="d-4" onClick="getDate('8-11')">8月11日（周四）<br>
<input type="radio" name="date" value="d-5" onClick="getDate('8-12')">8月12日（周五）<br>
<input type="radio" name="date" value="d-6" onClick="getDate('8-13')">8月13日（周六）<br>
<input type="radio" name="date" value="d-7" onClick="getDate('8-14')">8月14日（周日）<br>
</form>
</div>
<div class=" time-pop-ups" style="display:none" id="time">
<form class="f-time">
<input type="radio" name="time" value="t-1" onClick="getTime('13:30')">13:30<br>
<input type="radio" name="time" value="t-2" onClick="getTime('14:00')">14:00<br>
<input type="radio" name="time" value="t-3" onClick="getTime('14:30')">14:30<br>
<input type="radio" name="time" value="t-4" onClick="getTime('15:00')">15:00<br>
<input type="radio" name="time" value="t-5" onClick="getTime('15:30')">15:30<br>
<input type="radio" name="time" value="t-6" onClick="getTime('16:00')">16:00<br>
<input type="radio" name="time" value="t-7" onClick="getTime('16:30')">16:30<br>
</form>
</div>
</div>
</div>
</div>
</body>
<script type="text/javascript">
	function selectDate() {
		document.getElementById('date').style.display="inline"; 
	}
	
	function selectTime() {
		document.getElementById('time').style.display="inline"; 
	}
	
	function getDate(dateValue) {
		document.getElementById('date').style.display = "none";
		document.getElementById('dateValue').value = dateValue;
	}
	function getTime(timeValue) {
		document.getElementById('time').style.display = "none";
		document.getElementById('timeValue').value = timeValue;
	}
</script>
</html>
