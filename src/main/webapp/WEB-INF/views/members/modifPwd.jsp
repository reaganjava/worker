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
<link rel="stylesheet" type="text/css" href=""${pageContext.request.contextPath}/css/wei-index.css" />
<link rel="stylesheet" type="text/css"  href=""${pageContext.request.contextPath}/css/out-use.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<title>修改密码</title>
<script type="text/javascript">
$(document).ready(function(){
	var isView = false;
 	$("#btn_sub").click(function(){
 	    var is = true;
 		var oldPassword = $("#oldPassword").val();
 	   	if(oldPassword == '' || oldPassword.length < 6) {
 	   	    $("#tipOP").text('请输旧密码');
 		  	is = false; 
 	   	}
 	    var password =  $("#password").val();
 	    if(password == '' || password.length < 6) {
 	    	$("#tipP").text('请输入密码');
		  	is = false; 
	   	}
 	   var repassword =  $("#rePassword").val();
	    if(repassword == '' || repassword.length < 6) {
	    	$("#tipRP").text('请再次输入密码');
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
 	
 	
}); 
</script>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a><img src=""${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span>修改密码</span></li>
<li></li>
</ul>
</nav>
<!---导航结束--->
<div>
<div class="xsh_cells vux-no-group-title"> 
<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="oldPassword" type="oldPassword"><span id="tipOP" style="color:#FF0000"></span></div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="password" type="password"><span id="tipP" style="color:#FF0000"></span></div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="rePassword" type="password"><span id="tipRP" style="color:#FF0000"></span></div></div>
</div> </div>
<!--表单结束-->
<div class="register-btn"><button class="rg-btn">确认修改</button></div>
</div>
</div>
</div>
</body>
</html>
