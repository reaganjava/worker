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
<script type="text/javascript">
$(function(){
	var isReg = false;
	$("#tipM").text('');
	$("#tipP").text('');
	$("#tipS").text('');
	$("#tipRP").text('');
    $('#sendCode').click(function(){
    	$('#code').show();
    	var mobile = $("#mobile").val();
    });
    $('#password').change(function(){
    	var mobile = $("#mobile").val();
    	$.ajax({
            type: "GET",
            url: "/members/checkMobile/" + mobile + ".json",
            dataType: "json",
            success: function(data){
                 if(data == 0) {
                	 isReg = true;
                	 $("#tipM").text('手机号码已经注册过');
                 }     
            }
        });
    });
    $('#getCode').click(function() {
    	var is = true;
    	var mobile = $("#mobile").val();
    	if(mobile == '' || mobile.length < 10 || isNaN(mobile)) {
 	   	    $("#tipM").text('请输入手机号码');
 		  	is = false; 
 	   	}
    	var code = $('#codeValue').val();
    	if(code == '' || code.length < 4){
    		 $("#tipV").text('输入验证码');
  		  	 is = false; 
    	}
    	var mobile = $("#mobile").val();
    	
    	if(is) {
    		$('#code').hide();
	   		$.ajax({
	               type: "GET",
	               url: "/members/getCode/" + mobile + "/1234.json",
	               dataType: "json",
	               success: function(data){
	                          alert(data);
	               }
	           });
    	}
    });
    $("#btn_sub").click(function(){
 	    var is = true;
 		var mobile = $("#mobile").val();
 	   	if(mobile == '' || mobile.length < 10 || isNaN(mobile)) {
 	   	    $("#tipM").text('请输入手机号码');
 		  	is = false; 
 	   	}
 	    var smsCode =  $("#smsCode").val();
 	    alert(smsCode);
	    if(smsCode == '' || smsCode.length < 6) {
	    	$("#tipS").text('请输入短信验证码');
		  	is = false; 
	   	}
 	    var password =  $("#password").val();
 	    if(password == '' || password.length < 6) {
 	    	$("#tipP").text('请输入密码');
		  	is = false; 
	   	}
 	   var repassword =  $("#repassword").val();
	    if(repassword == '' || repassword.length < 6) {
	    	$("#tipRP").text('请再次输入密码');
		  	is = false; 
		  	if(repassword != password) {
		  		$("#tipRP").text('两次密码输入不相同');
		  		is = false;
		  	}
	   	}
	    if(isReg) {
	    	$("#tipM").text('手机号码已经注册过');
	    	is = false;
	    }
 	   	if(is) {
 	   		$("#regForm").submit();
 	   	}
 	});
    
 	$("#restCode").click(function() {
 		var codeImg = document.getElementById("codeImg");  
        codeImg.src = "${pageContext.request.contextPath}/ImageCodeMakerServlet?rnd=" + Math.random();  
 	})
 	
 	$("input").focus(function(){
 		$("#tipM").text('');
 		$("#tipP").text('');
 		$("#tipS").text('');
 		$("#tipRP").text('');
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
<li><a href="${pageContext.request.contextPath}/members/login.html"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span>注册</span></li>
<li></li>
</ul>
</nav>
<!---导航结束--->
<form action="${pageContext.request.contextPath}/members/register.html" method="post" id="regForm">
<div>
<div class="xsh_cells vux-no-group-title"> 
<div class="xsh_cell xsh_cell_warn"> 
<div class="xsh_cell_hd"></div> 
<div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="mobile"  type="text" name="wMMobile" placeholder="输入手机号码"/><span id="tipM" style="color:#FF0000"></span> </div> 
<div class="xsh_cell_ft">
<i class="xsh_icon xsh_icon_clear" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_success" style="display: none;"></i> 
<input type="button" style="background-color:#00cced" class="xsh_btn xsh_btn_mini" id="sendCode" value="发送验证码"/> </div> </div> 

<div class="xsh_cell xsh_cell_warn"> 
<div class="xsh_cell_hd"></div> 
<div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="smsCode" type="text" name="smsCode" placeholder="验证码" /><span id="tipS" style="color:#FF0000"></span></div>
<div class="xsh_cell_ft">
<i class="xsh_icon xsh_icon_clear" style="display: none;"></i> 
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_success" style="display: none;"></i> 
<span class="nosend">没有收到?</span></div></div> 

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="password" name="wMPassword" type="password" placeholder="密码"> <span id="tipP" style="color:#FF0000"></span></div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="repassword" name="rePassword" type="password" placeholder="重复密码"><span id="tipRP" style="color:#FF0000"></span> </div></div>
</div> </div>
</form>
<!--表单结束-->
<div class="register-btn"><a  href="javascript:void();" id="btn_sub" ><button class="rg-btn">立即注册</button></a></div>
<div class="agreement">点击-立即注册，即表示您同意<a style=" color:00cced;">《新生活使用协议》</a></div>
<div class="members-quota"><a href="${pageContext.request.contextPath}/members/rule.html"><img src="${pageContext.request.contextPath}/images/fire-hot.png"/>新生活前3万名会员永久享受最高9.5折!<span>了解详情</span></a></div>
<!---获取验证码弹框--->
<div class="get-code" style=" display:none;" id="code">  
<div class="code-info">
<input type="text" class="text-code" id="codeValue">
<span id="tipV" style="color:#FF0000"></span>
<img src="${pageContext.request.contextPath}/ImageCodeMakerServlet" id="codeImg"/>
<a href="javascript:void();" id="restCode"><span>换一张</span></a>
</div>
<div class="code-btn">
<button class="cod-btn" id="getCode">获取验证码</button>
</div>
</div>


</div>
</div>
</div>
</body>
</html>