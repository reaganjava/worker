<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/icheck/jquery.icheck.min.js?v=0.1"></script> 
<title>临时保洁选择面积</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/buyTask.html" method="post" id="buyForm">
<div class="xsh">
<div class="page-all">
<div class="container">

<nav class="navbar">
<ul>
<li><a href="首页.html"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span>选择面积</span></li>
<li></li>
</ul>
</nav>
<!---选择建筑面积---->
<section class="choose-area">
<p>请选择房屋面积</p>
<input type="hidden" name="workerTaskDO.id" value="${TASK_GOODS.id}"/>
<ul class="house-area">
<c:forEach items="${TASK_GOODS.workerItems}" var="workerItem" varStatus="status">
<li  id="item${status.index}"><a href="javascript:void" onClick="setArea(${status.index}, ${workerItem.id})"><span id="itemFont${status.index}">${workerItem.wWiItem}<sup>2</sup></span><i></i></a></li>
</c:forEach>
</ul>
<input type="hidden" name="workerTaskDO.itemId" id="itemId"/>
<input type="hidden" name="workerTaskDO.staffId" id="staffId"/>
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
<a class="tab-bar-btn"  data-service="家庭保洁" href="javascript:void" onClick="onSubmit()">下一步</a>
</div>
</div>
</div>
</div>
</form>
</body>
<script type="text/javascript">
	$(function(){
		$('#item0').css("background","#00cded");
		$('#itemFont0').css("color","#fff");
		
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
		$("#itemId").val(itemId);
		$.ajax({
			  url: "${pageContext.request.contextPath}/getStaff/" + itemId + ".json",
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
		$("#staffId").val(staffId);
	}
	
	function onSubmit() {
		document.getElementById('buyForm').submit();
	}
</script>
</html>
