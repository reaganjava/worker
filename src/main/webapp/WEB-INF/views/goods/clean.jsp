<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" >  
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<title>临时保洁选择面积</title>
</head>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a href="/"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span class="navber-word">选择面积</span></li>
<li></li>
</ul>
</nav>
<!---选择建筑面积---->
<section class="choose-area">
<p>请选择房屋面积</p>
<ul class="house-area">
<li id="l1"><div id="area1" onClick="selectArea(1);"><span id="a1">80m<sup>2</sup>以下</span><i></i></div></li>
<li id="l2"><div id="area2" onClick="selectArea(2);"><span id="a2">80m<sup>2</sup>-120m<sup>2</sup></span><i></i></div></li>
<li id="l3"><div id="area3" onClick="selectArea(3);"><span id="a3">120m<sup>2</sup>-140m<sup>2</sup></span><i></i></div></li>
<li id="l4"><div id="area4" onClick="selectArea(4);"><span id="a4">140m<sup>2</sup>-170m<sup>2</sup></span><i></i></div></li>
<li id="l5"><div id="area5" onClick="selectArea(5);"><span id="a5">170m<sup>2</sup>-200m<sup>2</sup></span><i></i></div></li>
<li id="l6"><div id="area6" onClick="selectArea(6);"><span id="a6">200m <sup>2</sup>以上</span><i></i></div></li>
</ul>
</section>
<div class="clean"></div>
<!-----一人服务----->
<section class="one-service">
<p>请选择服务人数及时间</p>
<ul class="house-area" id="staffSelect">
<li id="f1"><div id="staff1" onClick="selectStaff(1,1,2);"><span id="ss1">1人2小时</span></div></li>
<li id="f2"><div id="staff2" onClick="selectStaff(2,1,3);"><span id="ss2">1人3小时</span></div></li>
<li id="f3"><div id="staff3" onClick="selectStaff(3,1,4);"><span id="ss3">1人4小时</span></div></li>
<li id="f4"><div id="staff4" onClick="selectStaff(4,1,6);"><span id="ss4">1人6小时</span></div></li>
<li id="f5"><div id="staff5" onClick="selectStaff(5,1,8);"><span id="ss5">1人8小时</span></div></li>
<li id="f6"><div id="staff6" onClick="selectStaff(6,1,10);"><span id="ss6">1人10小时</span></div></li>
</ul>
</section>
<!---两人服务---->
<div class="clean"></div>
<section class="two-service" style=" height:120px;">
<p>为节省您的时间，特推出2人服务</p>
<ul class="house-area">
<li id="f7"><div id="staff7" onClick="selectStaff(7,2,3);"><span>2人3小时</span></div></li>
<li id="f8"><div id="staff8" onClick="selectStaff(8,2,4);"><span>2人4小时</span></div></li>
<li id="f9"><div id="staff9" onClick="selectStaff(9,2,5);"><span>2人5小时</span></div></li>
</ul>
</section>
<section class="lin-intro">
<div class="intro-di">
<span>服务项目：临时保洁</span>
<span>嘿管家为您提供临时保洁服务。服务涵盖卫生间、卧室、厨房、客厅、阳台等区域的保洁服务</span>
</div>
</section>
<div class="clean"></div>
</div>
</div>
</div>
<div class="choose-next">
<form action="${pageContext.request.contextPath}/goods/buyJob.html" method="post" id="cleanForm">
<input name="serviceType" value="0" type="hidden">
<input name="hours" id="h" type="hidden">
<input name="staffCount" id="sc" type="hidden">
</form>
<div class="pay-now">
<ul>
<li style=" text-align:right"><button class="money-btn" id="btn_sub">下一步</button></li>
<li style="text-align:center">总额：<span id="price">￥0</span></li>
</ul>
</div>
</div>
</body>
<script type="text/javascript">
	var bg = "";
	var cl = "";
	var fbg ="";
	var scl = "";
	$(document).ready(function(){
		bg = $("#l1").css("background");
		cl = $("#s1").css("color");
		$("#l1").css("background","#00cded");
		$("#s1").css("color","#fff");
		fbg = $("#f1").css("background");
		scl = $("#ss1").css("color");
		$("#f1").css("background","#00cded");
		$("#ss1").css("color","#fff");
		$("#h").val(2);
		$("#sc").val(1);
		var price = 34 * 1 * 2;
		$("#price").html("￥" + price);
	});
	
	function selectStaff(id, staff, hours) {
		for(var i = 1; i <= 9; i++) {
			$("#f" + i).css("background",fbg);
			$("#ss" + i).css("color",scl);
		}
		$("#f" + id).css("background","#00cded");
		$("#ss" + id).css("color","#fff");
		$("#h").val(hours);
		$("#sc").val(staff);
		
		var price = 34 * hours * staff;
		$("#price").html("￥" + price);
	}
	function selectArea(id) {
		for(var i = 1; i <= 6; i++) {
			$("#l" + i).css("background",bg);
			$("#s" + i).css("color",cl);
		}
		$("#l" + id).css("background","#00cded");
		$("#s" + id).css("color","#fff");
		switch(id) {
			case 1:{
				$("#staffSelect").empty(); 
				$("#staffSelect").append('<li id="f1"><div id="staff1" onClick="selectStaff(1, 1, 2);"><span id="ss1">1人2小时</span></div></li>');
				$("#staffSelect").append('<li id="f2"><div id="staff2" onClick="selectStaff(2, 1, 3);"><span id="ss2">1人3小时</span></div></li>');
				$("#staffSelect").append('<li id="f3"><div id="staff3" onClick="selectStaff(3, 1, 4);"><span id="ss3">1人4小时</span></div></li>');
				$("#staffSelect").append('<li id="f4"><div id="staff4" onClick="selectStaff(4, 1, 6);"><span id="ss4">1人6小时</span></div></li>');
				$("#staffSelect").append('<li id="f5"><div id="staff5" onClick="selectStaff(5, 1, 8);"><span id="ss5">1人8小时</span></div></li>');
				$("#staffSelect").append('<li id="f6"><div id="staff6" onClick="selectStaff(6, 1, 10);"><span id="ss6">1人10小时</span></div></li>');
				break;
			}
			case 2:{
				$("#staffSelect").empty(); 
				$("#staffSelect").append('<li class="no-service"><div><span>1人2小时</span></div></li>');
				$("#staffSelect").append('<li id="f2"><div id="staff2" onClick="selectStaff(2, 1, 3);"><span id="ss2">1人3小时</span></div></li>');
				$("#staffSelect").append('<li id="f3"><div id="staff3" onClick="selectStaff(3, 1, 4);"><span id="ss3">1人4小时</span></div></li>');
				$("#staffSelect").append('<li id="f4"><div id="staff4" onClick="selectStaff(4, 1, 6);"><span id="ss4">1人6小时</span></div></li>');
				$("#staffSelect").append('<li id="f5"><div id="staff5" onClick="selectStaff(5, 1, 8);"><span id="ss5">1人8小时</span></div></li>');
				$("#staffSelect").append('<li id="f6"><div id="staff6" onClick="selectStaff(6, 1, 10);"><span id="ss6">1人10小时</span></div></li>');
				break;
			}
			case 3:{
				$("#staffSelect").empty(); 
				$("#staffSelect").append('<li class="no-service"><div><span>1人2小时</span></div></li>');
				$("#staffSelect").append('<li class="no-service""><div><span>1人3小时</span></div></li>');
				$("#staffSelect").append('<li id="f3"><div id="staff3" onClick="selectStaff(3, 1, 4);"><span id="ss3">1人4小时</span></div></li>');
				$("#staffSelect").append('<li id="f4"><div id="staff4" onClick="selectStaff(4, 1, 6);"><span id="ss4">1人6小时</span></div></li>');
				$("#staffSelect").append('<li id="f5"><div id="staff5" onClick="selectStaff(5, 1, 8);"><span id="ss5">1人8小时</span></div></li>');
				$("#staffSelect").append('<li id="f6"><div id="staff6" onClick="selectStaff(6, 1, 10);"><span id="ss6">1人10小时</span></div></li>');
				break;
			}
			case 4:{
				$("#staffSelect").empty(); 
				$("#staffSelect").append('<li class="no-service"><div><span>1人2小时</span></div></li>');
				$("#staffSelect").append('<li class="no-service"><div><span>1人3小时</span></div></li>');
				$("#staffSelect").append('<li class="no-service"><div><span>1人4小时</span></div></li>');
				$("#staffSelect").append('<li id="f4"><div id="staff4" onClick="selectStaff(4, 1, 6);"><span id="ss4">1人6小时</span></div></li>');
				$("#staffSelect").append('<li id="f5"><div id="staff5" onClick="selectStaff(5, 1, 8);"><span id="ss5">1人8小时</span></div></li>');
				$("#staffSelect").append('<li id="f6"><div id="staff6" onClick="selectStaff(6, 1, 10);"><span id="ss6">1人10小时</span></div></li>');
				break;
			}
			case 5:{
				$("#staffSelect").empty(); 
				$("#staffSelect").append('<li class="no-service"><div><span>1人2小时</span></div></li>');
				$("#staffSelect").append('<li class="no-service"><div><span>1人3小时</span></div></li>');
				$("#staffSelect").append('<li class="no-service"><div><span>1人4小时</span></div></li>');
				$("#staffSelect").append('<li class="no-service"><div><span>1人6小时</span></div></li>');
				$("#staffSelect").append('<li id="f5"><div id="staff5" onClick="selectStaff(5, 1, 8);"><span id="ss5">1人8小时</span></div></li>');
				$("#staffSelect").append('<li id="f6"><div id="staff6" onClick="selectStaff(6, 1, 10);"><span id="ss6">1人10小时</span></div></li>');
				break;
			}
			case 6:{
				$("#staffSelect").empty(); 
				$("#staffSelect").append('<li class="no-service"><div><span>1人2小时</span></div></li>');
				$("#staffSelect").append('<li class="no-service"><div><span>1人3小时</span></div></li>');
				$("#staffSelect").append('<li class="no-service"><div><span>1人4小时</span></div></li>');
				$("#staffSelect").append('<li class="no-service"><div><span>1人6小时</span></div></li>');
				$("#staffSelect").append('<li class="no-service"><div><span>1人8小时</span></div></li>');
				$("#staffSelect").append('<li id="f6"><div id="staff6" onClick="selectStaff(6, 1, 10);"><span id="ss6">1人10小时</span></div></li>');
				break;
			}
		}
		
	} 
	
	
	
	$("#btn_sub").click(function(){
 	   
 	   	$("#cleanForm").submit();
 	   
 	});
</script>
</html>