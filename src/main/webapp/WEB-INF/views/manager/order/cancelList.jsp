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
<title>订单管理</title>
</head>
<body>
<nav class="breadcrumb"> <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="text-c">
		<input type="text" class="input-text" style="width:250px" placeholder="输入订单号" id="" name="">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜管订单</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="r">共有数据：<strong>${PAGE_BEAN.recordCount}</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name=""></th>
				<th width="80">ID</th>
				<th width="40">订单号</th>
				<th width="40">服务名称</th>
				<th width="40">是否支付</th>
				<th width="90">费用</th>
				<th width="70">创建时间</th>
				
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		  <c:forEach items="${PAGE_BEAN.dataList}" var="order">
			<tr class="text-c">
				<td><input type="checkbox" value="${order.id}" name="idArray"></td>
				<td>${order.id}</td>
				<td>${order.wOOrderNo}</td>
				<td>${order.wOServiceName}</td>
				<td>
				<c:if test="${order.wOIsPay == 1}">
				<span class="label label-success radius">已支付</span></td>
				</c:if>
				<c:if test="${order.wOIsPay == 0}">
				<span class="label label-defaunt radius">未支付</span></td>
				</c:if>
				</td>
				<td>￥${order.wOFee}元</td>
				<td>${order.formatDate}</td>
				
				<td class="td-manage">
			
				<i class="Hui-iconfont">&#xe631;</i></a> <a title="确认取消订单" href="javascript:;" onclick="confirm_canecl(this,'${order.id}')" >
				
				<i class="Hui-iconfont">&#xe6df;</i></a> 
				
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
		  {"orderable":false,"aTargets":[0,2,5]}// 制定列不参与排序
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

/*用户-停用*/
function confirm_canecl(obj,id){
	layer.confirm('确认要取消订单吗？',function(index){
		$.ajax(
				{url:"/morder/confirmCanecl/" + id + ".json",
				async:false,
				success: function(data){
					if(data.status == 'y') {
						layer.msg('已确认消订单!',{icon: 5,time:1000});
					} else {
						layer.msg(data.info,{icon: 5,time:1000});
					}
				}
		});
		
	});
}
</script> 
</body>
</html>