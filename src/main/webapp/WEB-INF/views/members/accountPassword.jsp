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
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" >  
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<title>修改密码</title>
<script type="text/javascript">
$(document).ready(function(){
	var isView = false;
 	$("#btn_sub").click(function(){
 	    var is = true;
 		var oldPassword = $("#oldPassword").val();
 	   	if(oldPassword == '' || oldPassword.length < 6) {
 	   	    alert('请重新输入当前密码');
 		  	is = false; 
 	   	}
 	    var password =  $("#password").val();
 	    if(password == '' || password.length < 6) {
 	    	alert('新密码长度不足,请重新输入');
		  	is = false; 
	   	}
 	   var repassword =  $("#rePassword").val();
	    if(repassword == '' || repassword.length < 6) {
	    	alert('请再次输入新密码');
		  	is = false; 
		}
		  if(repassword != password&&repassword.length>=6&&password.length>=6) {
		  		alert('两次密码输入不一致');
		  		is = false;
		  	}else if(repassword == password&&repassword.length>=6&&password.length>=6){
		  		alert('修改密码成功');
		  	}
	  
	
 	   	if(is) {
 	   		$("#mdPwdForm").submit();
 	   	}
 	});
 
}); 
</script>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a href="javascript:void();" onclick="window.history.back(-1);"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span class="navber-word">修改密码</span></li>
<li></li>
</ul>
</nav>
<!---导航结束--->
<div>
<form action="${pageContext.request.contextPath}/members/accountPassword.html" method="post" id="mdPwdForm">
<div class="xsh_cells vux-no-group-title"> 
<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="oldPassword" name="oldPassword" placeholder="输入旧密码" type="password"></div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="password" name="wMPassword" placeholder="输入新密码"  type="password"></div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="rePassword" placeholder="再次输入新密码"  type="password"></div></div>
</div><span id="error_info">${ERROR_INFO}</span> </div>
</form>
<!--表单结束-->
<div class="register-btn"><button class="rg-btn" id="btn_sub">确认修改</button></div>
</div>
</div>
</div>
</body>
</html>
