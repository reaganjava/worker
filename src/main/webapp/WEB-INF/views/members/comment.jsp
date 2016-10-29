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
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<title>意见反馈</title>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a href="${pageContext.request.contextPath}/members/accountInfo.html"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span class="navber-word">意见反馈</span></li>
<li></li>
</ul>
</nav>
<!---导航结束--->
<div class="suggest">
<div class="suggest-tab">
<form action="${pageContext.request.contextPath}/members/comment.html" method="post" id="commentForm">
<input type="text" name="wCContent" id="wCContent" class="sugg-word" placeholder="您的支持与宝贵意见是我们改进的动力!"><br/>
<input type="text" name="wName" id="wName" class="user-name" placeholder="您的姓名" ><br/>
<input type="tel" name="wMobile" id="wMobile" class="user-tel" placeholder="您的电话" >

</form>
</div>
</div>
<span id="error_info">${ERROR_INFO}</span>
<!--内容结束-->
<div class="register-btn"><a  href="javascript:void;" id="btn_sub" ><button class="rg-btn">提交</button></a></div>
</div>
</div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	var isView = false;
 	$("#btn_sub").click(function(){
 	    var is = true;
 		var wCContent = $("#wCContent").val();
 	   	if(wCContent == '' || wCContent.length < 20) {
 	   		$('#error_info').html('不能少于20个字');
 		  	is = false; 
 	   	}
 	    var wName =  $("#wName").val();
 	    if(wName == '' || wName.length < 1) {
 	    	$('#error_info').html('请输您的姓名');
		  	is = false; 
	   	}
 	   var wMobile =  $("#wMobile").val();
	    if(wMobile == '' || wMobile.length < 10 || isNaN(wMobile)) {
	    	$('#error_info').html('请输您的手机号码');
		  	is = false; 
	   	}
 	   	if(is) {
 	   		$("#commentForm").submit();
 	   	}
 	});
 
 	
}); 
</script>
</html>
