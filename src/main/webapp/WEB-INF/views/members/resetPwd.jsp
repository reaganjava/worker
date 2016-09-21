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
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/icheck/jquery.icheck.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/Validform/5.3.2/Validform.min.js?v=0.1"></script>
<title>忘记密码</title>
</head>
<body>

<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a href="${pageContext.request.contextPath}/members/login.html"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span>忘记密码</span></li>
<li></li>
</ul>
</nav>
<!---导航结束--->
<form action="" method="post" id="restForm">
<div>
<div class="xsh_cells vux-no-group-title"> 
<div class="xsh_cell xsh_cell_warn"> 
<div class="xsh_cell_hd"></div> 
<div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" pattern="[0-9]*" name="wMMobile" placeholder="输入手机号码" type="text" id="mobile"> </div> 
<div class="xsh_cell_ft">
<i class="xsh_icon xsh_icon_clear" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_success" style="display: none;"></i> 
<button style="background-color:#00cced" class="xsh_btn xsh_btn_mini" id="smsCode" > <span>发送验证码</span>  </button></div> </div> 

<div class="xsh_cell xsh_cell_warn"> 
<div class="xsh_cell_hd"></div> 
<div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" name="smsCode" pattern="[0-9]*" placeholder="验证码" type="text"></div>
<div class="xsh_cell_ft">
<i class="xsh_icon xsh_icon_clear" style="display: none;"></i> 
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_success" style="display: none;"></i> 
<span class="nosend">没有收到?</span></div></div> 

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" pattern="[0-9]*" name="rePassword" placeholder="输入新密码" type="password"> </div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" pattern="[0-9]*" name="wMPassword" placeholder="确认密码" type="password"> </div></div>
</div> 
</div>
<!--表单结束-->
<div class="register-btn"><button class="rg-btn" onClick="restPwd()">确定</button></div>
</form>
</div>
</div>
</div>
</body>
<script type="text/javascript">
	function restPwd() {
		document.getElementById("restForm").submit();
	}
	
	$(function(){
	    $('#smsCode').click(function(){
	    	var mobile = $("#mobile").val();
	         $.ajax({
	             type: "GET",
	             url: "/members/restPwd/" + mobile + ".json",
	             dataType: "json",
	             success: function(data){
	                    
	             }
	         });
	    });
	});
	
	  $(function () {
	         $('#smsCode').click(function () {
	             var count = 60;
	             var countdown = setInterval(CountDown, 1000);
	             function CountDown() {
	                 $("#smsCode").attr("disabled", true);
	                 $("#smsCode").val("请等待" + count + "秒!");
	                 if (count == 0) {
	                     $("#smsCode").val("获取验证码").removeAttr("disabled");
	                     clearInterval(countdown);
	                 }
	                 count--;
	             }
	         })
	
	     });
</script>
</html>
