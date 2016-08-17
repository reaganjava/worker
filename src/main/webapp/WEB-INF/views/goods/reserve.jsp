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
<p>您还没有服务地址哟，请点击添加服务地址</p>
<div class="add-ads">
<div class="a-ads">
<a href="添加地址.html"><img  src="${pageContext.request.contextPath}/images/add-icon.png"/><span>添加服务地址</span></a>
</div>
</div>
</section>
<!--添加地址结束-->
<section class="add-time">
<div class="choose-time">
<span class="time-words">请选择服务时间</span>
<div class="time-input">
<a><input type="text" class="choose-date" value="8月15日（今天）"/></a>
<a><input type="text" class="choose-hour" value="14:00"/></a>
</div>
</div>
</section>
<!--添加时间结束-->
<p class="remind">如果阿姨因为各种原因早到或晚到一会儿（15分钟左右）请不用担心她会保证服务时长的~</p>
<div class="choose-next">
<a class="tab-bar-btn"  data-service="家庭保洁" href="确认订单.html" >确定</a>
</div>
<!--弹窗 begin-->
<div class="date-pop-ups" style=" ">
<form name="f-date">
<input type="radio" name="date" value="d-1">8 月 8日（今天）<br>
<input type="radio" name="date" value="d-2">8 月 9日（明天）<br>
<input type="radio" name="date" value="d-3">8月10日（周三）<br>
<input type="radio" name="date" value="d-4">8月11日（周四）<br>
<input type="radio" name="date" value="d-5">8月12日（周五）<br>
<input type="radio" name="date" value="d-6">8月13日（周六）<br>
<input type="radio" name="date" value="d-7">8月14日（周日）<br>
</form>
</div>
<div class=" time-pop-ups" style="">
<form class="f-time">
<input type="radio" name="time" value="t-1">13:30<br>
<input type="radio" name="time" value="t-2">14:00<br>
<input type="radio" name="time" value="t-3">14:30<br>
<input type="radio" name="time" value="t-4">15:00<br>
<input type="radio" name="time" value="t-5">15:30<br>
<input type="radio" name="time" value="t-6">16:00<br>
<input type="radio" name="time" value="t-7">16:30<br>
</form>
</div>
</div>
</div>
</div>
</body>
</html>
