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
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<title>注册</title>

</head>
<body>
<form action="${pageContext.request.contextPath}/members/register.html" method="post">
<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a href="登陆.html"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span>注册</span></li>
<li></li>
</ul>
</nav>
<!---导航结束--->
<div>
<div class="xsh_cells vux-no-group-title"> 
<div class="xsh_cell xsh_cell_warn"> 
<div class="xsh_cell_hd"></div> 
<div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="mobile" pattern="[0-9]*" placeholder="输入手机号码" type="text" name="wMMobile"> </div> 
<div class="xsh_cell_ft">
<i class="xsh_icon xsh_icon_clear" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_success" style="display: none;"></i> 
<input type="button" style="background-color:#00cced" class="xsh_btn xsh_btn_mini" id="smsCode" value="发送验证码"/></div> </div> 

<div class="xsh_cell xsh_cell_warn"> 
<div class="xsh_cell_hd"></div> 
<div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" pattern="[0-9]*" placeholder="验证码" type="text" name="smsCode"></div>
<div class="xsh_cell_ft">
<i class="xsh_icon xsh_icon_clear" style="display: none;"></i> 
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_success" style="display: none;"></i> 
<span class="nosend">没有收到?</span></div></div> 

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" pattern="[0-9]*" placeholder="请输入密码" name="wMPassword" type="password"> </div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" pattern="[0-9]*" placeholder="确认密码" name="rePassword" type="password"> </div></div>
</div> </div>
<!--表单结束-->
<div class="register-btn"><button class="rg-btn">立即注册</button></div>
<div class="agreement">点击-立即注册，即表示您同意<a style=" color:00cced;">《新生活使用协议》</a></div>
<div class="members-quota"><img src="${pageContext.request.contextPath}/images/fire-hot.png"/>新生活前3万名会员永久享受9.9折，名额仅剩<span>21987</span>名</div>
</div>
</div>
</div>
</form>
</body>
<script type="text/javascript">
$(function(){
    $('#smsCode').click(function(){
    	var mobile = $("#mobile").val();
         $.ajax({
             type: "GET",
             url: "/members/getCode/" + mobile + "/1234.json",
             dataType: "json",
             success: function(data){
                        alert(data);
             }
         });
    });
});
</script>
</html>
