<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/wei-index.css?v=0.1" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/out-use.css?v=0.1" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script>
<title>预约服务</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/order/getOrder.html"
		method="POST" id="orderForm">
		<div class="xsh">
			<div class="page-all">
				<div class="container">
					<nav class="navbar" style="z-index: 1000;">
						<ul>
							<li><a href="javascript:void();"
								onclick="window.history.back(-1);"><img
									src="${pageContext.request.contextPath}/images/left.png" /></a></li>
							<li><span>预约服务</span></li>
							<li></li>
						</ul>
					</nav>
					<div class="address-detail"
						style="width: 96%; margin: 0 auto; margin-top: 45px;" id="clist">
						
				 	 </div>
				<section class="add-address">
					<div class="add-ads">
						<div class="a-ads">
							<a
								href="${pageContext.request.contextPath}/members/addContact.html"><img
								src="${pageContext.request.contextPath}/images/add-icon.png" /><span>添加服务地址</span></a>
						</div>
					</div>
				</section>
				
				<!--添加时间结束-->
				<p class="remind">若服务人员因为特殊情况早到或迟到一会儿（15分钟左右）请不用担心，他会为你提供满意的服务~</p>
				<div class="choose-next">
					<a class="tab-bar-btn" data-service="家庭保洁"
						href="javascript:void(0)" id="btn_sub">确定</a>
				</div>
			</div>
		</div>
		</div>
		</div>
		<input type="hidden" name="contactId" id="cid" value="${CONTACT_ID}" />
	
	</form>
</body>

<script type="text/javascript">

function del(id) {

	$.ajax({
		  url: "${pageContext.request.contextPath}/members/removeContact/" + id + ".json",
		  success:function(data) {
			
			  if(data != 0) {
				  $.ajax({
					  url: "${pageContext.request.contextPath}/members/contacts.json",
					  success:function(data) {
						
						  if(data != 0) {
							 $("#clist").empty();
							 $("#clist").append(data);
						  }
					  }
					});
			  }
		  }
		});
}

	
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
		  url: "${pageContext.request.contextPath}/members/contacts.json",
		  success:function(data) {
			
			  if(data != 0) {
				
				 $("#clist").append(data);
			  }
		  }
		});
		var isView = false;
	 	$("#btn_sub").click(function(){
	 	    var is = true;
	 	
	 	   	if(is) {
	 	   		$("#orderForm").submit();
	 	   	}
	 	});
	 });
	 
</script>
</html>
