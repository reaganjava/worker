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
<body onload="loadData()">
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
				<section class="add-time">
					<div class="choose-time">
						<span class="time-words">请选择服务时间</span>
						<div class="time-input">
							<select id="year" name="subDate" style="width: 130px;">
								<c:forEach items="${WEEK_DATE_LIST}" var="dateValueDO">
									<option value="${dateValueDO.dateValue}">${dateValueDO.weekDate}<br>
								</c:forEach>
							</select> <select id="day" name="subTime" style="width: 80px;">
								<option value="8:00">8:00</option>
								<option value="8:30">8:30</option>
								<option value="9:00">9:00</option>
								<option value="9:30">9:30</option>
								<option value="10:00">10:00</option>
								<option value="10:30">10:30</option>
								<option value="11:00">11:00</option>
								<option value="11:30">11:30</option>
								<option value="12:00">12:00</option>
								<option value="12:30">12:30</option>
								<option value="13:00">13:00</option>
								<option value="13:30">13:30</option>
								<option value="14:00">14:00</option>
								<option value="14:30">14:30</option>
								<option value="15:00">15:00</option>
								<option value="15:30">15:30</option>
								<option value="16:00">16:00</option>
								<option value="16:30">16:30</option>
								<option value="17:00">17:00</option>
								<option value="17:30">17:30</option>
								<option value="18:00">18:00</option>
							</select>
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
	 
//$('.del').click(function(){
//	var del = confirm('确定删除该地址吗？')
//		if(del==true){
//			$('.address-detail').css('display','none');
//		}
	
//})
	 
	 function loadData(){
			var d=new Date();
			var year=d.getFullYear();
			var month=d.getMonth()+1;
			var day=d.getDate();
			var hour=d.getHours();
			var min=d.getMinutes();
			var secon=d.getSeconds();
			var startHour=hour;
			var startMin=min;
			if(hour>=16){
				d = new Date(d.valueOf() + 1 * 24 * 60 * 60 * 1000);
				startHour=8;
				startMin=0;
			}else{
				if(min>=0&&min<30){
					startMin=30;
					startHour+=2;
				}
				if(min>=30){
					startMin=0;
					startHour+=3;
				}
			}
			var yearHTML="";
			var coun=1;
			while(true){
				year=d.getFullYear();
				if(coun>5) break;//最多5天
				month=d.getMonth()+1;
				month=month>0&&month<=9?"0"+month:month;
				day=d.getDate();
				day=day>0&&day<=9?"0"+day:day;
				yearHTML+="<option value=\""+(year+"-"+month+"-"+day)+"\">"+(year+" 年 "+month+" 月 "+day+" 日")+"</option>";
				d = new Date(d.valueOf() + 1 * 24 * 60 * 60 * 1000);
				coun++;
			}
			document.getElementById("year").innerHTML=yearHTML;
			var dayHTML="";
			for(var i=startHour;i<=18;i++){
				var n=i>=0&&i<=9?"0"+i:i;
				if(i==startHour&&startMin==30){
					if(i!=18){
						dayHTML+="<option value=\""+(n+":30")+"\">"+(n+" : 30")+"</option>";
					}
				}else{
					dayHTML+="<option value=\""+(n+":00")+"\">"+(n+" : 00")+"</option>";
					if(i!=18){
						dayHTML+="<option value=\""+(n+":30")+"\">"+(n+" : 30")+"</option>";
					}
				}
			}
			document.getElementById("day").innerHTML=dayHTML;
		}
	 
//var today = new Date();	//获取当前系统时间
//var month = today.getMonth(); //获取当前月份(0-11,0代表1月)
//var tdate = today.getDate(); //获取当前日(1-31)
//var hour = today.getHours(); //时
//var minute = today.getMinutes(); //分

//$(function(){
	//日期
//	var months = month + 1;
//	$('.date option').html(months+'月'+tdate+'日');
	
	//时间
//	var hours = hour + 2;
//	if(minute<30){
//		minute = 30;
//	}else{
//		hours += 1;
//		minute = '00';
//	}
//	alert(hours);
//	if(hours<=16){
//		for (var i=hours;i<=16;i++) {
//			$('.hour option').html(hours+':'+'00');
//		}
//	}
//	if(hours>16){
//		for (var i=10;i<=16;i++) {
//			$('.hour option').html(i+':'+'00');
//		}
//	}
//})
</script>
</html>
