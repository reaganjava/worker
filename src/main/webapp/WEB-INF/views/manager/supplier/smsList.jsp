<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="${pageContext.request.contextPath}/css/H-ui.min.css?v=0.1" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/H-ui.admin.css?v=0.1" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.7/iconfont.css?v=0.1" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>短信费用</title>
</head>
<body>
<nav class="breadcrumb"> <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name=""></th>
				<th width="20">ID</th>
				<th width="80">短信号码</th>
				<th width="40">费用</th>
				<th width="130">发送时间</th>
			</tr>
		</thead>
		<tbody>
		  <c:forEach items="${PAGE_BEAN.dataList}" var="smsRecord">
			<tr class="text-c">
				<td><input type="checkbox" value="${smsRecord.id}" name="idArray"></td>
				<td>${smsRecord.id}</td>
				<td>${smsRecord.sMobile}</td>
				<td>${smsRecord.sFee}</td>
				<td>${smsRecord.formatDate}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</div>
	<%@ include file="/WEB-INF/views/page.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.1/layer.js?v=0.1"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/laypage/1.2/laypage.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/WdatePicker.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/datatables/1.10.0/jquery.dataTables.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/H-ui.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/H-ui.admin.js?v=0.1"></script> 
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"bLengthChange": false, //改变每页显示数据数量
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"bPaginate" : false,// 分页按钮  
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,3,4]}// 制定列不参与排序
		]
	});
	$('.table-sort tbody').on( 'click', 'tr', function () {
		if ( $(this).hasClass('selected') ) {
			$(this).removeClass('selected');
		}
		else {
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	});
	
	
});

</script> 
</body>
</html>