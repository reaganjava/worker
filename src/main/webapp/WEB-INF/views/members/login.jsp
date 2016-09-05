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
<title>登陆</title>
<script type="text/javascript">
$(document).ready(function(){
	var isView = false;
 	$("#btn_sub").click(function(){
 	    var is = true;
 		var mobile = $("#mobile").val();
 	   	if(mobile == '' || mobile.length < 10 || isNaN(mobile)) {
 	   	    $("#tipM").text('请输入手机号码');
 		  	is = false; 
 	   	}
 	    var password =  $("#password").val();
 	    if(password == '' || password.length < 6) {
 	    	$("#tipP").text('请输入密码');
		  	is = false; 
	   	}
 	   	if(is) {
 	   		$("#loginForm").submit();
 	   	}
 	});
 	
 	$("input").focus(function(){
 		$("#tipM").text('');
 		$("#tipP").text('');
 	});
 	
 	$("#viewPwd").click(function() {
 		var password =  $("#password").val();
 		if(!isView) {
 			$("#password").remove();
 			$("#tipP").remove();
 			$("#pwd").append('<input class="xsh_input" name="wMPassword" type="text"  maxlength="15" id="password"/> <span id="tipP" style="color:#FF0000"></span> ');
 			$("#password").val(password);
 			isView = true;
 		} else {
 			$("#password").remove();
 			$("#tipP").remove();
 			$("#pwd").append('<input class="xsh_input" name="wMPassword" type="password"  maxlength="15" id="password"/> <span id="tipP" style="color:#FF0000"></span> ');
 			$("#password").val(password);
 			isView = false;
 		}
 	})
}); 
</script>
</head>
<body>

<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span>登陆</span></li>
<li></li>
</ul>
</nav>
<form id="loginForm" action="${pageContext.request.contextPath}/members/login.html" method="POST">
<!---导航结束--->
<div>
<div class="xsh_cells vux-no-group-title"> 
<div class="xsh_cell xsh_cell_warn"> 
<div class="xsh_cell_hd"></div> 
<div class="xsh_cell_bd xsh_cell_primary"><input class="xsh_input" name="wMMobile" id="mobile" placeholder="输入手机号码" type="tel" ><span id="tipM" style="color:#FF0000"></span> </div> 
<div class="xsh_cell_ft">
<i class="xsh_icon xsh_icon_clear" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_success" style="display: none;"></i> 
<button style="background-color:#00cced" class="xsh_btn xsh_btn_mini"></button></div> </div> 

<div class="xsh_cell xsh_cell_warn"> 
<div class="xsh_cell_hd"></div> 
<div class="xsh_cell_bd xsh_cell_primary" id="pwd"> <input class="xsh_input" name="wMPassword" type="password" id="password"  placeholder="密码"/><span id="tipP" style="color:#FF0000"></span> </div>
<div class="xsh_cell_ft">
<i class="xsh_icon xsh_icon_clear" style="display: none;"></i> 
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_success" style="display: none;"></i> 
<span class="nosend" id="viewPwd">显示密码</span></div></div> 
</div>

</div>

</form>
<div class="dn"><a class="go-register" href="${pageContext.request.contextPath}/members/register.html"> 立即注册</a><a href="${pageContext.request.contextPath}/members/restPwd.html">忘记密码？</a></div>
<!--表单结束-->
<div class="register-btn"><a  href="javascript:void();" id="btn_sub" ><button class="rg-btn">立即登陆</button></a></div>
</div>
</div>
</div>

</body>

</html>
