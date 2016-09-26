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
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />  
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css?v=0.1" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css?v=0.1"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/icheck/jquery.icheck.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/Validform/5.3.2/Validform.min.js?v=0.1"></script>

<title>地址管理</title>
</head>
<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a href="javascript:void();" onclick="window.history.back(-1);"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span>服务地址</span></li>
<li></li>
</ul>
</nav>
<!---导航结束--->
<section>
<div class="choose-add">
<div class="scroll">
<div class="address-detail">
<c:forEach items="${CONTACT_LIST}" var="contact">
<ul>
<c:if test="${contact.wCDefault == 1}">
<li onClick="onDefault(${contact.id})" id="c${contact.id}">
</c:if>
<c:if test="${contact.wCDefault == 0}">
<li class="choose-2" onClick="onDefault(${contact.id})" id="c${contact.id}">
</c:if>
<div class="choose-con1" >
<input name="id" value="${contact.id}" type="hidden" />
<span>${contact.wCAddress}</span>
<span>${contact.wCContact}</span>
<span>${contact.wCTelephone}</span>
</div>
<div class="choose-con2">重庆</div>
</li>
</ul>
</c:forEach>
</div>

<div class="add-ads" style=" width:100%;">
<div class="a-ads">
<a href="${pageContext.request.contextPath}/members/addContact.html"><img  src="${pageContext.request.contextPath}/images/add-icon.png"/><span>添加服务地址</span></a>
</div>
</div>
</div>
</div>
</section>
</div>
</div>
</div>
<body>
</body>
<script type="text/javascript">
	function onDefault(id) {
		$.ajax({
			  url: "${pageContext.request.contextPath}/members/default/" + id + ".json",
			  success:function(data) {
				  if(data != 0) {
					 	$('li').addClass('choose-2');
					 	$('#c' + id).removeClass('choose-2');
				  }
			  }
			});
	}
</script>
</html>
