<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" >  
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css?v=0.02" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css?v=0.02"/>
<title>支付失败</title>
<style>
*{background:#fff;}
</style>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<div class="wrong">
<div class="wrong-img"><img src="${pageContext.request.contextPath}/images/wrong.png" alt="失败"/></div>

<div class="wrong-word">
<span class="wrong-pay">抱歉，支付失败</span>
</div>
</div>
<!--提示结束-->
<div class="back-btn">
<a href="/" class="wrong-back">返回</a>
<a href="${pageContext.request.contextPath}/pay/payInfo/${ORDERNO}.html"class="pay-again">重新支付</a>
</div>
</div>
</div>
</div>
</body>
</html>
