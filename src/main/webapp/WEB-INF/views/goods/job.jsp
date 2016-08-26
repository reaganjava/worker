<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
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
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script>  
<title>临时保洁选择面积</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/goods/buyJob.html" method="post" id="buyForm">
<div class="xsh">
<div class="page-all">
<div class="container">

<nav class="navbar">
<ul>
<li><a href="javascript:void;"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span>选择面积</span></li>
<li></li>
</ul>
</nav>
<!---选择建筑面积---->
<section class="choose-area">
<p>请选择房屋面积</p>
<ul class="house-area">
<c:forEach items="${TASK_GOODS.workerItems}" var="workerItem" varStatus="status">
<li  id="item${status.index}"><a href="javascript:void(0)" onClick="setArea(${status.index}, ${workerItem.id})"><span id="itemFont${status.index}">${workerItem.wWiItem}<sup>2</sup></span><i></i></a></li>
</c:forEach>
</ul>

</section>
<div class="clean"></div>
<!-----一人服务----->
<section class="one-service">
<p>请选择服务人数及时间</p>
<ul class="house-area" id="staff_house">
</ul>
</section>
<p>
服务介绍
</p>
<span>${TASK_GOODS.wWDesc}</span>
<div class="clean"></div>
<div class="choose-next">
<a class="tab-bar-btn"  data-service="家庭保洁" href="javascript:void(0)" onClick="onSubmit()">下一步</a>
</div>
</div>
</div>
</div>
</form>
</body>
<script type="text/javascript">
	var tid = ${TASK_GOODS.id};
	var iid = 0;
	var stkd = 0;
	$(function(){
		$('#item0').css("background","#00cded");
		$('#itemFont0').css("color","#fff");
		$.ajax({
			  url: "${pageContext.request.contextPath}/goods/getStaff/${WORKER_ITEM_ID}.json",
			  success:function(data) {
				  if(data != 0) {
					$("#staff_house").children("li").remove();
				  	$("#staff_house").append(data);
				  	$('#staff0').css("background","#00cded");
					$('#staffFont0').css("color","#fff");
				  }
			  }
			});
		iid = ${WORKER_ITEM_ID};
		stkd = ${WORKER_STAFF_ID};
	})
	
	function setArea(id, itemId) {
		for(var i = 0; i < ${fn:length(TASK_GOODS.workerItems)}; i++) {
			if(id == i) {
				$('#item' +i).css("background","#00cded");
				$('#itemFont' +i).css("color","#fff");
			} else {
				$('#item' +i).css("background","#fff");
				$('#itemFont' +i).css("color","#000");
			}
		}
		iid = itemId;
		$.ajax({
			  url: "${pageContext.request.contextPath}/goods/getStaff/" + itemId + ".json",
			  success:function(data) {
				  if(data != 0) {
					$("#staff_house").children("li").remove();
				  	$("#staff_house").append(data);
				  	$('#staff0').css("background","#00cded");
					$('#staffFont0').css("color","#fff");
				  }
			  }
			});
	}
	
	function setStaff(id, staffsize, staffId) {
		for(var i = 0; i < staffsize; i++) {
			if(id == i) {
				$('#staff' +i).css("background","#00cded");
				$('#staffFont' +i).css("color","#fff");
			} else {
				$('#staff' +i).css("background","#fff");
				$('#staffFont' +i).css("color","#000");
			}
		}
		stkd = staffId
	}
	
	function onSubmit() {
		window.location.href = "${pageContext.request.contextPath}/goods/buyJob/" + tid +"/" + iid + "/" + stkd +".html";
	}
</script>
</html>
