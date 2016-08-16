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
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>  <span class="r">共有数据：<strong>${PAGE_BEAN.recordCount}</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name=""></th>
				<th width="80">ID</th>
				<th width="40">订单号</th>
				<th width="40">服务名称</th>
				<th width="90">支付类型</th>
				<th width="90">费用</th>
				<th width="10">是否完成</th>
				<th width="10">是否支付</th>
				<th width="70">创建时间</th>
				<th width="70">状态</th>
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
				<td>${order.wOPayType}</td>
				<td>￥${order.wOFee}元</td>
				<td>${order.wOIsEnd}</td>
				<td>${order.wOIsPay}</td>
				<td>${order.formatDate}</td>
				
				<td class="td-status">
				<c:if test="${order.wOIsConfim == 1}">
				<span class="label label-success radius">已确认用</span></td>
				</c:if>
				<c:if test="${admin.wOIsConfim == 0}">
				<span class="label label-defaunt radius">未确认</span></td>
				</c:if>
				<td class="td-manage">
			
				<c:if test="${admin.status == 1}">
				<a style="text-decoration:none" onClick="admin_stop(this,'${admin.id}')" href="javascript:;" title="确认订单">
				</c:if>
				<c:if test="${admin.status == 0}">
				<a style="text-decoration:none" onClick="admin_start(this,'${admin.id}')" href="javascript:;" title="取消订单">
				</c:if>
				
				
				<i class="Hui-iconfont">&#xe631;</i></a> <a title="编辑" href="javascript:;" onclick="admin_edit('编辑','/admin/detail/${admin.id}.html','${admin.id}','','510')" class="ml-5" style="text-decoration:none">
				
				<i class="Hui-iconfont">&#xe6df;</i></a> 
				<a title="删除" href="javascript:;" onclick="admin_del(this,'${admin.id}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				
				
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
/*渠道-添加*/
function admin_add(title,url,w,h){
	layer_show(title,url,w,h);
}


/*用户-停用*/
function admin_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="admin_start(this,'+ id + ')" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
		$(obj).remove();
		$.ajax(
				{url:"/admin/stop/" + id + ".json",
				async:false,
				success: function(data){
					if(data.status == 'y') {
						layer.msg('已停用!',{icon: 5,time:1000});
					} else {
						layer.msg(data.info,{icon: 5,time:1000});
					}
				}
		});
		
	});
}

/*渠道-启用*/
function admin_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="admin_stop(this,'+id+')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove();
		$.ajax(
				{url:"/admin/start/" + id + ".json",
				async:false,
				success: function(data){
					if(data.status == 'y') {
						layer.msg('已启用!',{icon: 6,time:1000});
					} else {
						layer.msg(data.info,{icon: 6,time:1000});
					}
				}
		});
		
	});
}


/*渠道-编辑*/
function admin_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*渠道-删除*/
function admin_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		$.ajax(
				{url:"/admin/remove/" + id + ".json",
				async:false,
				success: function(data){
					if(data.status == 'y') {
						layer.msg('已删除!',{icon:1,time:1000});
					} else {
						layer.msg(data.info,{icon:1,time:1000});
					}
				}
		});
	});
}
/*渠道-删除*/
function datadel(){
	    var chk_value =[];    
	    layer.confirm('确认要删除吗？',function(index){
	      
		$('input[name="idArray"]:checked').each(function(){    
		   chk_value.push($(this).val()); 
		});
		  
		var param = "";
		for(var i = 0; i < chk_value.length; i++) {
			param += chk_value[i] + "-";
		}
		
		$.ajax(
				{url:"/supplier/removeall/" + param + ".json",
				async:false,
				success: function(data){
					if(data.status == 'y') {
						layer.msg('已删除!',{icon:1,time:1000});
					} else {
						layer.msg(data.info,{icon:1,time:1000});
					}
				}
		});
	});
}
</script> 
</body>
</html>