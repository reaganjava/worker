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
<title>会员成长规则</title>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a href="${pageContext.request.contextPath}/members/register.html"><img src="${pageContext.request.contextPath}/images/left.png?v=0.1"/></a></li>
<li><span>会员规则</span></li>
<li></li>
</ul>
</nav>
<div class="v-introduce">
<h4 class="v-p">会员成长介绍</h4>
<span>会员成长体系包含5个会员等级，会员等级由“成长值”决定，</span>
<span>成长值越高，会员等级越高</span>
<img src="${pageContext.request.contextPath}/images/rule.jpg?v=0.1"/>
</div>

<div class="cz-intro"><p class="v-p">成长值介绍</p><p><span>会员成长值</span>≈<span>累计消费金额</span></p></div>

<div class="v-right">
<p class="v-p">等级与特权</p>
<table class="table-vip">
<tr>
<th>会员等级</th>
<th>会员成长值</th>
<th>特权</th>
</tr>
<tr class="t-v1">
<td>v1</td>
<td><=500</td>
<td>永久9.9折</td>
</tr>
<tr class="t-v2">
<td>v2</td>
<td>500-5000</td>
<td>永久9.8折</td></tr>
<tr class="t-v3">
<td>v3</td>
<td>5000-20000</td>
<td>永久9.7折</td>    
</tr>
<tr class="t-v4">
<td>v4</td>
<td>20000-40000</td>
<td>永久9.6折</td>
</tr>
<tr class="t-v5">
<td>v5</td>
<td>>=40000</td>
<td>永久9.5折</td>
</tr>
</table>
</div>
</div>
</div>
</div>
</body>
</html>
