<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/wei-index.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script>
<title>临时保洁选择面积</title>
</head>
<body onload="loadData()">
<form action="${pageContext.request.contextPath}/goods/buyJob.html"
			method="post" id="cleanForm">
	<div class="xsh">
	
		<div class="page-all">
			<div class="container">
				<nav class="navbar">
					<ul>
						<li><a href="/"><img
								src="${pageContext.request.contextPath}/images/left.png" /></a></li>
						<li><span>选择面积</span></li>
						<li></li>
					</ul>
				</nav>
				<section class="chooses-time">
					<p>请选择服务时间</p>
					<div class="time-input">
						<a> <select id="year" name="subDate" onchange="changeYear(this.value)" style="width: 130px;">
								<c:forEach items="${WEEK_DATE_LIST}" var="dateValueDO">
									<option value="${dateValueDO.dateValue}">${dateValueDO.weekDate}<br>
								</c:forEach></a> <a> 
								</select> 
								<select id="day" name="subTime" style="width: 80px;">
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
						</a>
					</div>

				</section>
				<!---选择建筑面积---->
				<section class="choose-area">
					<p>请选择房屋面积</p>
					<ul class="house-area">
						<li id="l1"><div id="area1" onClick="selectArea(1);">
								<span id="a1">60m <sup>2</sup>以下
								</span><i></i>
							</div></li>
						<li id="l2"><div id="area2" onClick="selectArea(2);">
								<span id="a2">60m<sup>2</sup>-80m<sup>2</sup></span><i></i>
							</div></li>
						<li id="l3"><div id="area3" onClick="selectArea(3);">
								<span id="a3">80m<sup>2</sup>-120m<sup>2</sup></span><i></i>
							</div></li>
						<li id="l4"><div id="area4" onClick="selectArea(4);">
								<span id="a4">120m<sup>2</sup>-140m<sup>2</sup></span><i></i>
							</div></li>
						<li id="l5"><div id="area5" onClick="selectArea(5);">
								<span id="a5">140m<sup>2</sup>-170m<sup>2</sup></span><i></i>
							</div></li>
						<li id="l6"><div id="area6" onClick="selectArea(6);">
								<span id="a6">170m <sup>2</sup>以上
								</span><i></i>
							</div></li>
					</ul>
				</section>
				<div class="clean"></div>
				<!-----一人服务----->
				<section class="one-service">
					<p>请选择服务人数及时间</p>
					<ul class="house-area" id="staffSelect">
						<li id="f1"><div id="staff1" onClick="selectStaff(1,1,2);">
								<span id="ss1">1人2小时</span>
							</div></li>
						<li id="f2"><div id="staff2" onClick="selectStaff(2,1,3);">
								<span id="ss2">1人3小时</span>
							</div></li>
						<li id="f3"><div id="staff3" onClick="selectStaff(3,1,4);">
								<span id="ss3">1人4小时</span>
							</div></li>
						<li id="f4"><div id="staff4" onClick="selectStaff(4,1,6);">
								<span id="ss4">1人6小时</span>
							</div></li>
						<li id="f5"><div id="staff5" onClick="selectStaff(5,1,8);">
								<span id="ss5">1人8小时</span>
							</div></li>
						<li id="f6"><div id="staff6" onClick="selectStaff(6,1,10);">
								<span id="ss6">1人10小时</span>
							</div></li>
					</ul>
				</section>
				<!---两人服务---->
				<div class="clean"></div>
				<section class="two-service" style="height: 120px;">
					<p>为节省您的时间，特推出2人服务</p>
					<ul class="house-area" id="staffsSelect">
						<li id="f7"><div id="staff7" onClick="selectStaff(7,2,3);">
								<span>2人3小时</span>
							</div></li>
						<li id="f8"><div id="staff8" onClick="selectStaff(8,2,4);">
								<span>2人4小时</span>
							</div></li>
						<li id="f9"><div id="staff9" onClick="selectStaff(9,2,5);">
								<span>2人5小时</span>
							</div></li>
					</ul>
				</section>
				<section class="service-rule">
					<p class="city-price-hour">
						单价:￥<b id="l-city-price">30.00</b>/<span id="l-city-unit">小时</span>
					</p>
					<p class="city-price-hour">
						夜间:￥<b id="l-city-price">40.00</b>/<span id="l-city-unit">小时(18:00后预约为夜间服务)</span>
					</p>
					<P class="c-content-title">服务内容</P>
					<ul class="c-content">
						<li><span>厨房大扫除<i>（不包括抽油烟机拆洗）</i></span></li>
						<li><span>客厅大扫除<i>（不包括天花板及灯具拆洗，地毯清洗）</i></span></li>
						<li><span>卧室大扫除<i>（不包括天花板及灯具拆洗）</i></span></li>
						<li><span>阳台大扫除<i>（不包括2楼以上玻璃）</i></span></li>
						<li><span>卫生间大扫除<i>（不包括2楼以上玻璃）</i></span></li>
					</ul>
			</div>
			</section>
			<div class="clean"></div>
		</div>
		
	</div>
	</div>
	<div class="choose-next">
		
			<input name="serviceType" value="0" type="hidden"/> 
			<input name="hours" id="h" type="hidden"/> 
			<input name="staffCount" id="sc" type="hidden"/>
		    <input name="price" id="pc" type="hidden" value="30"/>
		<div class="pay-now">
			<ul>
				<li style="text-align: right"><button class="money-btn"
						id="btn_sub">下一步</button></li>
				<li style="text-align: center">总额：<span id="price">￥0</span></li>
			</ul>
		</div>
	</div>
	</form>
</body>
<script type="text/javascript">
	var bg = "";
	var cl = "";
	var fbg = "";
	var scl = "";

	$(document).ready(function() {
		bg = $("#l1").css("background");
		cl = $("#s1").css("color");
		$("#l1").css("background", "#00cded");
		$("#s1").css("color", "#fff");
		fbg = $("#f1").css("background");
		scl = $("#ss1").css("color");
		$("#f1").css("background", "#00cded");
		$("#ss1").css("color", "#fff");
		$("#h").val(2);
		$("#sc").val(1);
		var price = 0;
		if($("#day").val().indexOf("18") > -1) {
			price = 40 * 1 * 2;
			$("#pc").val(40);
		} else {
			price = 30 * 1 * 2;
			$("#pc").val(30);
		}
		$("#price").html("￥" + price);
		
	});

	function selectStaff(id, staff, hours) {
		for (var i = 1; i <= 9; i++) {
			$("#f" + i).css("background", fbg);
			$("#ss" + i).css("color", scl);
			$("#f" + i).css("border", "1px solid #c0c0c0");
		}
		$("#f" + id).css("background", "#00cded");
		$("#ss" + id).css("color", "#fff");
		$("#h").val(hours);
		$("#sc").val(staff);
		var price = 0;
		if($("#day").val().indexOf("18") > -1) {
			price = 40 * hours * staff;
			$("#pc").val(40);
		} else {
			price = 30 * hours * staff;
			$("#pc").val(30);
		}
		
		$("#price").html("￥" + price);
		$("#pc").val(price);
	}
	function selectArea(id) {
		for (var i = 1; i <= 6; i++) {
			$("#l" + i).css("background", bg);
			$("#s" + i).css("color", cl);
		}
		$("#l" + id).css("background", "#00cded");
		$("#s" + id).css("color", "#fff");
		switch (id) {
		case 1: {
			$("#staffSelect").empty();
			$("#staffsSelect").empty();
			$("#staffSelect")
					.append(
							'<li style=" background:#00cded;border:1px solid #fff;list-style: outside none none;" id="f1"><div id="staff1" onClick="selectStaff(1, 1, 2);"><span id="ss1">1人2小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f2"><div id="staff2" onClick="selectStaff(2, 1, 3);"><span id="ss2">1人3小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f3"><div id="staff3" onClick="selectStaff(3, 1, 4);"><span id="ss3">1人4小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f4"><div id="staff4" onClick="selectStaff(4, 1, 6);"><span id="ss4">1人6小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f5"><div id="staff5" onClick="selectStaff(5, 1, 8);"><span id="ss5">1人8小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f6"><div id="staff6" onClick="selectStaff(6, 1, 10);"><span id="ss6">1人10小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f7"><div id="staff9" onClick="selectStaff(7,2,3);"><span>2人3小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f8"><div id="staff9" onClick="selectStaff(8,2,4);"><span>2人4小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f9"><div id="staff9" onClick="selectStaff(9,2,5);"><span>2人5小时</span></div></li>');
			var price = 0;
			if($("#day").val().indexOf("18") > -1) {
				price = 40 * 1 * 2;
				$("#pc").val(40);
			} else {
				price = 30 * 1 * 2;
				$("#pc").val(30);
			}
			
			$("#price").html("￥" + price);
			$("#pc").val(price);
			break;
		}
		case 2: {
			$("#staffSelect").empty();
			$("#staffsSelect").empty();
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人2小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li style=" background:#00cded;border:1px solid #fff; list-style: outside none none;" id="f2"><div id="staff2" onClick="selectStaff(2, 1, 3);"><span id="ss2">1人3小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f3"><div id="staff3" onClick="selectStaff(3, 1, 4);"><span id="ss3">1人4小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f4"><div id="staff4" onClick="selectStaff(4, 1, 6);"><span id="ss4">1人6小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f5"><div id="staff5" onClick="selectStaff(5, 1, 8);"><span id="ss5">1人8小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f6"><div id="staff6" onClick="selectStaff(6, 1, 10);"><span id="ss6">1人10小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f7"><div id="staff9" onClick="selectStaff(7,2,3);"><span>2人3小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f8"><div id="staff9" onClick="selectStaff(8,2,4);"><span>2人4小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f9"><div id="staff9" onClick="selectStaff(9,2,5);"><span>2人5小时</span></div></li>');
			var price = 0;
			if($("#day").val().indexOf("18") > -1) {
				price = 40 * 1 * 3;
				$("#pc").val(40);
			} else {
				price = 30 * 1 * 3;
				$("#pc").val(30);
			}
			
			$("#price").html("￥" + price);
			$("#pc").val(price);
			break;
		}
		case 3: {
			$("#staffSelect").empty();
			$("#staffsSelect").empty();
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人2小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li class="no-service""><div><span>1人3小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li style=" background:#00cded;border:1px solid #fff;list-style: outside none none;" id="f3"><div id="staff3" onClick="selectStaff(3, 1, 4);"><span id="ss3">1人4小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f4"><div id="staff4" onClick="selectStaff(4, 1, 6);"><span id="ss4">1人6小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f5"><div id="staff5" onClick="selectStaff(5, 1, 8);"><span id="ss5">1人8小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f6"><div id="staff6" onClick="selectStaff(6, 1, 10);"><span id="ss6">1人10小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f7"><div id="staff9" onClick="selectStaff(7,2,3);"><span>2人3小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f8"><div id="staff9" onClick="selectStaff(8,2,4);"><span>2人4小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f9"><div id="staff9" onClick="selectStaff(9,2,5);"><span>2人5小时</span></div></li>');
			var price = 0;
			if($("#day").val().indexOf("18") > -1) {
				price = 40 * 1 * 4;
				$("#pc").val(40);
			} else {
				price = 30 * 1 * 4;
				$("#pc").val(30);
			}
			
			$("#price").html("￥" + price);
			$("#pc").val(price);
			break;
		}
		case 4: {
			$("#staffSelect").empty();
			$("#staffsSelect").empty();
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人2小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人3小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人4小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li style=" background:#00cded;border:1px solid #fff;list-style: outside none none;" id="f4"><div id="staff4" onClick="selectStaff(4, 1, 6);"><span id="ss4">1人6小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f5"><div id="staff5" onClick="selectStaff(5, 1, 8);"><span id="ss5">1人8小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f6"><div id="staff6" onClick="selectStaff(6, 1, 10);"><span id="ss6">1人10小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f7"><div id="staff9" onClick="selectStaff(7,2,3);"><span>2人3小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f8"><div id="staff9" onClick="selectStaff(8,2,4);"><span>2人4小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f9"><div id="staff9" onClick="selectStaff(9,2,5);"><span>2人5小时</span></div></li>');
			var price = 0;
			if($("#day").val().indexOf("18") > -1) {
				price = 40 * 1 * 6;
				$("#pc").val(40);
			} else {
				price = 30 * 1 * 6;
				$("#pc").val(30);
			}
			
			$("#price").html("￥" + price);
			$("#pc").val(price);
			break;
		}
		case 5: {
			$("#staffSelect").empty();
			$("#staffsSelect").empty();
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人2小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人3小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人4小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人6小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li class="no-service"><div><span>2人3小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li style=" background:#00cded;border:1px solid #fff;list-style: outside none none;" id="f5"><div id="staff5" onClick="selectStaff(5, 1, 8);"><span id="ss5">1人8小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li id="f6"><div id="staff6" onClick="selectStaff(6, 1, 10);"><span id="ss6">1人10小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f8"><div id="staff9" onClick="selectStaff(8,2,4);"><span>2人4小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f9"><div id="staff9" onClick="selectStaff(9,2,5);"><span>2人5小时</span></div></li>');
			var price = 0;
			if($("#day").val().indexOf("18") > -1) {
				price = 40 * 1 * 8;
				$("#pc").val(40);
			} else {
				price = 30 * 1 * 8;
				$("#pc").val(30);
			}
			
			$("#price").html("￥" + price);
			$("#pc").val(price);
			break;
		}
		case 6: {
			$("#staffSelect").empty();
			$("#staffsSelect").empty();
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人2小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人3小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人4小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人6小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li class="no-service"><div><span>1人8小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li class="no-service"><div><span>2人3小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li class="no-service"><div><span>2人4小时</span></div></li>');
			$("#staffSelect")
					.append(
							'<li style=" background:#00cded;border:1px solid #fff;list-style: outside none none;" id="f6"><div id="staff6" onClick="selectStaff(6, 1, 10);"><span id="ss6">1人10小时</span></div></li>');
			$("#staffsSelect")
					.append(
							'<li id="f9"><div id="staff9" onClick="selectStaff(9,2,5);"><span>2人5小时</span></div></li>');
			var price = 0;
			if($("#day").val().indexOf("18") > -1) {
				price = 40 * 1 * 10;
				$("#pc").val(40);
			} else {
				price = 30 * 1 * 10;
				$("#pc").val(30);
			}
			
			$("#price").html("￥" + price);
			$("#pc").val(price);
			break;
		}
		}

	}

	$("#btn_sub").click(function() {

		$("#cleanForm").submit();

	});
	
	$("#day").change(function() {
		var price = 0;
		if($("#day").val().indexOf("18") > -1) {
			price = 40 * 1 * 2;
			$("#pc").val(40);
		} else {
			price = 30 * 1 * 2;
			$("#pc").val(30);
		}
		$("#price").html("￥" + price);
		
	});

	function loadData(){
		var d=new Date();
		//获取年份
		var year=d.getFullYear();
		//获取月份，js系统时间的月份从0开始算的，也就是0月代表1月
		var month=d.getMonth()+1;
		//获取当前时间是这个月的第几天
		var day=d.getDate();
		//获取小时
		var hour=d.getHours();
		//获取分钟数
		var min=d.getMinutes();
		//小时下拉框的开始小时数
		var startHour=hour;
		//小时下拉框的开始分钟数(0/30)
		var startMin=min;
		//16点以后的情况
		if(hour>=16){
			d = new Date(d.valueOf() + 1 * 24 * 60 * 60 * 1000);
			startHour=8;
			startMin=0;
		//6-16点之间的情况
		}else if(hour>=6&&hour<=16){
			if(min>=0&&min<30){
				startMin=30;
				startHour+=2;
			}
			if(min>=30){
				startMin=0;
				startHour+=3;
			}
		//16-6点之间的情况
		}else{
			startMin=0;
			startHour=8;
		}
		var yearHTML="";
		var coun=1;
		//生成日期下拉框，后面5天
		while(true){
			year=d.getFullYear();
			//最多5天
			if(coun>5) break;
			month=d.getMonth()+1;
			month=month>0&&month<=9?"0"+month:month;
			day=d.getDate();
			day=day>0&&day<=9?"0"+day:day;
			yearHTML+="<option value=\""+(year+"年"+month+"月"+day+"日")+"\">"+(year+" 年 "+month+" 月 "+day+" 日")+"</option>";
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
	function changeYear(val){
		var d=new Date();
		var year=d.getFullYear();
		var month=d.getMonth()+1;
		var day=d.getDate();
		if(val==(year+"年"+month+"月"+day+"日")){
			loadData();
		}else{
			var dayHTML="";
			for(var i=8;i<=18;i++){
				var n=i>=0&&i<=9?"0"+i:i;
				dayHTML+="<option value=\""+(n+":00")+"\">"+(n+" : 00")+"</option>";
				if(i!=18){
					dayHTML+="<option value=\""+(n+":30")+"\">"+(n+" : 30")+"</option>";
				}
			}
			document.getElementById("day").innerHTML=dayHTML;
		}
	}
</script>
</html>