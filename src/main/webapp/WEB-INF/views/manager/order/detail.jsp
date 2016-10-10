<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="${pageContext.request.contextPath}/css/H-ui.min.css?v=0.1" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/H-ui.admin.css?v=0.1" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/lib/icheck/icheck.css?v=0.1" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.7/iconfont.css?v=0.1" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css?v=0.1"/>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css?v=0.1"/>
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>订单详情</title>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<div class="clean"></div>
<!--导航结束-->
<!--订单详情开始-->
<div class="clean"></div>
<div class="ding" style=" border:1px solid #c0c0c0; width:96%; padding:5px 0 15px 30px; margin-top:20px; background:#FFF">
<h4>预订信息</h4>
<ul>
<li>订单编号：<span>${ORDER_INFO.wOServiceName}</span></li>
<li>联系人&nbsp; &nbsp;：<span>${ORDER_INFO.orderDetailDO.wOContact}</span></li>
<li>联系电话：<span>${ORDER_INFO.orderDetailDO.wOTelephone}</span></li>
<li>服务地址：<span>${ORDER_INFO.orderDetailDO.wOAddress} </span></li>
<li>服务时长：<span>${ORDER_INFO.orderDetailDO.wOServerTime}小时</span></li>
<li>服务人数：<span>${ORDER_INFO.orderDetailDO.wOStaffCount}人</span></li>
<li>服务时间：<span><fmt:formatDate value="${ORDER_INFO.orderDetailDO.wOSubscribe}"  type="BOTH" dateStyle="full"/></span></li>
<li>实际付款：<span>${ORDER_INFO.orderDetailDO.wOPrice}</span></li>
</ul>
</div>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/icheck/jquery.icheck.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/Validform/5.3.2/Validform.min.js?v=0.1"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.1/layer.js?v=0.1"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/H-ui.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/H-ui.admin.js?v=0.1"></script>
</body>
</html>