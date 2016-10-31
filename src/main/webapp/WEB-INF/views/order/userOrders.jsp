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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css"/>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<title>我的订单</title>
</head>

<body >
<form action="${pageContext.request.contextPath}/order/getOrder.html"
		method="POST" id="orderForm">
<div class="xsh">
<div class="page-all">
<div class="container">
<div class="order-type">
<ul>
<c:if test="${status == 1}">
<li class="not-service"><a style="color:#f30;">待付款</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/2.html" >待服务</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/8.html">待验收</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/4.html">退款中</a></li>
</c:if>
<c:if test="${status == 2}">
<li><a href="${pageContext.request.contextPath}/order/userOrders/1.html" >待付款</a></li>
<li class="not-service"><a style="color:#f30;" >待服务</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/8.html">待验收</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/4.html">退款中</a></li>
</c:if>
<c:if test="${status == 8}">
<li><a href="${pageContext.request.contextPath}/order/userOrders/1.html" >待付款</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/2.html" >待服务</a></li>
<li class="not-service"><a style="color:#f30;" >待验收</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/4.html">退款中</a></li>
</c:if>
<c:if test="${status == 4}">
<li><a href="${pageContext.request.contextPath}/order/userOrders/1.html" >待付款</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/2.html" >待服务</a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/8.html">待验收</a></li>
<li class="not-service"><a style="color:#f30;" >退款中</a></li>
</c:if>
</ul>
</div>
<!--分类结束-->
<div class="clean"></div>
<div id="orderList">

</div>
<div class="cancle-remaind" style="display:none;">
<div class="cr-title"><span>温馨提示：服务前2小时取消订单，我们将收取全款50%的误工费。</span></div>
<div class="cr-btn">
<ul>
<li><a><button>确定</button></a></li>
<li><a><button>返回</button></a></li></ul></div>
</div>
<!---弹窗开始---->
<div id="cancelInfo" class=" time-pop-ups" style=" display:none;" >
<div class="f-time" style="padding-left:32%; font-size:16px; background:#FFF; line-height:28px; border:1px solid #B3ADAE; border-radius:4px; z-index:999;">
<input type="radio" id="time-wrong" name="time" value="1" onclick="cancel(1)"><label for="time-wrong">时间定错</label><a href="${pageContext.request.contextPath}/order/userOrders/2.html" style="float: right;margin-right: 10px;margin-top: -3px;">x</a><br>
<input type="radio" id="add-wrong" name="time" value="2" onclick="cancel(2)"><label for="add-wrong">位置定错</label><br>
<input type="radio" id="no-need" name="time" value="3" onclick="cancel(3)"><label for="no-need">不需要了</label><br>
<input type="radio" id="others" name="time" value="4" onclick="cancel(4)"><label for="others">其他原因</label><br>
</div>
</div>
<!--</div> -->
</div>
</div>
</div>
<!--内容结束--->
<div class="footerbar">
<ul class="footer-icon">
<li><a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/images/index-icon.png"/><span>首页</span></a></li>
<li><a href="${pageContext.request.contextPath}/order/userOrders/1.html"><img src="${pageContext.request.contextPath}/images/order-icon-now.png"/><span class="be-now">订单</span></a></li>
<li><a href="${pageContext.request.contextPath}/members/couponList.html"><img src="${pageContext.request.contextPath}/images/sale-icon.png"/><span>优惠券</span></a></li>
<li><a href="${pageContext.request.contextPath}/members/accountInfo.html"><img src="${pageContext.request.contextPath}/images/mine.png"/><span>我的</span></li>
</ul>
</div>
<!---内容结束-->
</form>
</body>
<script type="text/javascript">
	var id = 0;
	function cancelShow(v) {
		id = v;
		$("#cancelInfo").show();
	}
	function cancel(index) {
		
		$.ajax({
			  url: "${pageContext.request.contextPath}/order/cancel/" + id + "/" + index + ".json",
			  success:function(data) {
				  if(data != 0) {
					 alert('已经提交取消申请等待管理员确认！');
				  }
				  	//点击后刷新页面
					 window.location.reload();
			  }
			});
	}
	
	function confirmOrder(id) {
		var mes = confirm('是否确认订单！');
		if(mes == true){
			$.ajax({
				  url: "${pageContext.request.contextPath}/order/confirmOrder/" + id + ".json",
				  success:function(data) {
					
					  if(data != 0) {
						  $.ajax({
							  url: "${pageContext.request.contextPath}/order/userOrders/${status}/1.json",
							  success:function(data) {
								
								  if(data != 0) {
									 $("#orderList").empty();
									 $("#orderList").append(data);
								  }
							  }
							});
					  }
				  }
				});
		}
	}
	
	
	//删除订单
	function del(id) {

		$.ajax({
			  url: "${pageContext.request.contextPath}/order/del/" + id + ".json",
			  success:function(data) {
				
				  if(data != 0) {
					  $.ajax({
						  url: "${pageContext.request.contextPath}/order/userOrders/${status}/1.json",
						  success:function(data) {
							
							  if(data != 0) {
								 $("#orderList").empty();
								 $("#orderList").append(data);
							  }
						  }
						});
				  }
			  }
			});
		
		
		
		
	}

	//设置一个默认的	
	function onDefault(id) {
		
		$.ajax({
			  url: "${pageContext.request.contextPath}/members/default/" + id + ".json",
			  success:function(data) {
				
				  if(data != 0) {
					 	$('li').addClass('choose-2');
					 	$('#c' + id).removeClass('choose-2');
					 	$('#cid').val(id);
				  }
			  }
			});
	}
	$(function(){	
		$.ajax({
			  url: "${pageContext.request.contextPath}/order/userOrders/${status}/1.json",
			  success:function(data) {
				
				  if(data != 0) {
					
					 $("#orderList").append(data);
				  }
			  }
			});
		 });
	
	
	//showId表示弹出层的divId,backId表示遮罩层的divId;
	
	/* function del(showId,backId){
		document.getElementById(showId).style.display = 'block';
		document.getElementById(showId).style.display = 'block';
		
		var backdiv = document.getElementById(backId);
		backId.style.width = document.body.scrollWidth;
		$("#"+backId).height($(document).height());
	} */
	
	
	//关闭弹框
	/*function hideDiv(showId,backId){
		//关闭弹出层
		document.getElementById(showId).style.display = 'none';
		//关闭遮罩层
		document.getElementById(backId).style.display = 'none';
	}*/
	
</script>
</html>
