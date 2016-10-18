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

<title>注册</title>
<script type="text/javascript">
$(function(){
	var isReg = false;
	
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
                	 $('#error_info').html('手机号码已经注册过');
                 }     
            }
        });
    });
    $('#sendCode').click(function() {
    	var is = true;
    	var mobile = $("#mobile").val();
    	if(mobile == '' || mobile.length < 10 || isNaN(mobile)) {
    		$('#error_info').html('请输入手机号码');
 		  	is = false; 
 	   	}
    	
    	var mobile = $("#mobile").val();
    	
    	if(is) {
	   		$.ajax({
	               type: "GET",
	               url: "/members/getCode/" + mobile + ".json",
	               dataType: "json",
	               success: function(data){
	            	   if(data == 1) {
                       	alert("短信已经发送请注意查收！");
                       } 
	               }
	           });
    	}
    });
    $("#btn_sub").click(function(){
 	    var is = true;
 		var mobile = $("#mobile").val();
 	   	if(mobile == '' || mobile.length < 10 || isNaN(mobile)) {
 	   	$('#error_info').html('请输入手机号码');
 		  	is = false; 
 	   	}
 	    var smsCode =  $("#smsCode").val();
 	   
	    if(smsCode == '' || smsCode.length < 6) {
	    	$('#error_info').html('请输入短信验证码');
		  	is = false; 
	   	}
 	    var password =  $("#password").val();
 	    if(password == '' || password.length < 6) {
 	    	$('#error_info').html('请输入密码');
		  	is = false; 
	   	}
 	   var repassword =  $("#repassword").val();
	    if(repassword == '' || repassword.length < 6) {
	    	$('#error_info').html('请再次输入密码');
		  	is = false; 
		  	if(repassword != password) {
		  		$('#error_info').html('两次密码输入不相同');
		  		is = false;
		  	}
	   	}
	    if(isReg) {
	    	$('#error_info').html('手机号码已经注册过');
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
 
 	 $('#smsCode').change(function() {
     	var mobile = $("#mobile").val();
     	var v = $('#smsCode').val();
     	if(v != "") {
     		$.ajax({
	               type: "GET",
	               url: "/members/vaidateMobile/" + mobile + "/" + v +".json",
	               dataType: "json",
	               success: function(data){
	                        if(data == 0) {
	                        	$('#error_info').html("验证码错误或者已经过期！");
	                        } 
	               }
	           });
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
<li><a href="${pageContext.request.contextPath}/members/login.html"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span class="navber-word">注册</span></li>
<li></li>
</ul>
</nav>
<!---导航结束--->
<form action="${pageContext.request.contextPath}/members/register.html" method="post" id="regForm">
<div>
<div class="xsh_cells vux-no-group-title"> 
<div class="xsh_cell xsh_cell_warn"> 
<div class="xsh_cell_hd"></div> 
<div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="mobile"  type="text" name="wMMobile" placeholder="输入手机号码"/></div> 
<div class="xsh_cell_ft">
<i class="xsh_icon xsh_icon_clear" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_success" style="display: none;"></i> 
<input type="button" style="background-color:#00cced" class="xsh_btn xsh_btn_mini" id="sendCode" value="获取验证码"/> </div> </div> 

<div class="xsh_cell xsh_cell_warn"> 
<div class="xsh_cell_hd"></div> 
<div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="smsCode" type="text" name="smsCode" placeholder="验证码" /></div>
<div class="xsh_cell_ft">
<i class="xsh_icon xsh_icon_clear" style="display: none;"></i> 
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_warn" style="display: none;"></i>
<i class="xsh_icon xsh_icon_success" style="display: none;"></i> 
<span class="nosend">没有收到?</span></div></div> 

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="password" name="wMPassword" type="password" placeholder="密码"> </div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="repassword" name="rePassword" type="password" placeholder="重复密码"></div></div>
</div> 
<span id="error_info">${ERROR_INFO}</span>
</div>
</form>
<!--表单结束-->
<div class="register-btn"><a  href="javascript:void();" id="btn_sub" ><button class="rg-btn">立即注册</button></a></div>
<!-- <div class="members-quota"><a href="${pageContext.request.contextPath}/members/rule.html"><img src="${pageContext.request.contextPath}/images/fire-hot.png"/>新用户注册即送60元代金卷!<span>了解详情</span></a></div> -->
</div>
</div>
</div>
</body>
<script type="text/javascript">
        $(function () {
            $('#sendCode').click(function () {
                var count = 60;
                var countdown = setInterval(CountDown, 1000);
                function CountDown() {
                    $("#sendCode").attr("disabled", true);
                    $("#sendCode").val("请等待" + count + "秒!");
                    if (count == 0) {
                        $("#sendCode").val("获取验证码").removeAttr("disabled");
                        clearInterval(countdown);
                    }
                    count--;
                }
            })
            
           
        });
   </script>
</html>