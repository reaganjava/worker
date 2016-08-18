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
<title>登陆</title>

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
<div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" name="wMMobile" pattern="[0-9]*" placeholder="输入手机号码" type="tel"> </div> 
<div class="xsh_cell_ft">
<i class="xsh_icon xsh_icon_clear" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_success" style="display: none;"></i> 
<button style="background-color:#00cced" class="xsh_btn xsh_btn_mini"></button></div> </div> 

<div class="xsh_cell xsh_cell_warn"> 
<div class="xsh_cell_hd"></div> 
<div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" name="wMPassword" pattern="[0-9]*" placeholder="密码" type="password"></div>
<div class="xsh_cell_ft">
<i class="xsh_icon xsh_icon_clear" style="display: none;"></i> 
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_success" style="display: none;"></i> 
<span class="nosend">显示密码</span></div></div> 
</div></div>
</form>
<div class="dn"><a class="go-register" href="${pageContext.request.contextPath}/members/register.html"> 立即注册</a><a href="忘记密码.html">忘记密码？</a></div>
<!--表单结束-->
<div class="register-btn"><a  href="javascript:void;" onClick="onLogin()"><button class="rg-btn">立即登陆</button></a></div>
</div>
</div>
</div>

</body>
<script type="text/javascript">
	function onLogin() {
		document.getElementById("loginForm").submit();
	}
</script>
</html>
