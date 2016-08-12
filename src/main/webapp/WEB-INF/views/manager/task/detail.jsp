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
<link href="${pageContext.request.contextPath}/lib/icheck/icheck.css?v=0.1" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.7/iconfont.css?v=0.1" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>编辑临时工</title>
</head>
<body>
<div class="pd-20">
  <form action="${pageContext.request.contextPath}/task/add.json" method="post" class="form form-horizontal" id="form-task-add">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>任务名称：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${TASK_INFO.wWName}" placeholder="" id="wWName" name="wWName" datatype="*2-20" nullmsg="名称不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>单价(每小时价格)：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" value="${TASK_INFO.wWPrice}" name="wWPrice" id="wWPrice" datatype="*2-20" nullmsg="单价不能为空">
      </div>
      <div class="col-4"> </div>
   </div>
    <div class="row cl">
      <label class="form-label col-3">服务介绍：</label>
      <div class="formControls col-5">
        <textarea name="wWDesc" cols="" rows="" class="textarea"  placeholder="最少输入20个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="textarealength(this,100)">${TASK_INFO.wWDesc}</textarea>
        <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>任务选项</label>
      <div class="formControls col-5" id="taskItems">
      <c:forEach items="${TASK_INFO.workerItems}" var="workerItem">
        <span>项目说明[1]</span>
        <input type="text" class="input-text" placeholder="" value="${workerItem.wWiItem}" name="workerItems[0].wWiItem" id="wWiItem" datatype="*2-20" nullmsg="任务项目不能为空">
      </c:forEach>
      </div>
      <div class="col-4"> </div>
      <button id="addItem">+</button>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>人员安排与时间</label>
      <div class="formControls col-5" id="taskStaffs">
      <c:forEach items="${TASK_INFO.workerStaffs}" var="workerStaff">
        <span>人数[1]</span>
        <select  class="select" size="1" name="workerStaffs[0].wWsStaffCount" datatype="*" nullmsg="请选择人数！" selected="${workerStaff.wWsStaffCount}">
          <option value="" selected>请选人数</option>
          <option value="1">1人</option>
          <option value="2">2人</option>
          <option value="3">3人</option>
          <option value="4">4人</option>
          <option value="5">5人</option>
        </select>
        <span>时长[1]</span>
        <select class="select" size="1" name="workerStaffs[0].wWsHours" datatype="*" nullmsg="请选择时长！" selected="${workerStaff.wWsHours}">
          <option value="" selected>请选择时长</option>
          <option value="1">1小时</option>
          <option value="2">2小时</option>
          <option value="3">3小时</option>
          <option value="4">4小时</option>
        </select>
       </c:forEach>
      </div>
      <div class="col-4"> </div>
      <button id="addStaff" >+</button>
    </div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/icheck/jquery.icheck.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/Validform/5.3.2/Validform.min.js?v=0.1"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.1/layer.js?v=0.1"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/H-ui.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/H-ui.admin.js?v=0.1"></script>
<script type="text/javascript">
$(function(){
	
	var wi = 0;
	var wj = 0;
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-task-add").Validform({
		tiptype:2,
		ajaxPost:true,
		callback:function(data){
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
		
	});
	$("#addItem").click(function(){
		wi++;
		$("#taskItems").append('<span>项目选项['+ (wi+1) + ']</span><input type="text" class="input-text" placeholder="" name="workerItems[' + wi + '].wWiItem" id="wWiItem" datatype="*2-20" nullmsg="项目选项不能为空">');
	});
	$("#addStaff").click(function(){
		wj++;
		$("#taskStaffs").append('<span>人数['+ (wj+1) + ']</span>'
		        +'<select class="select" size="1" name="workerStaffs[' + wj + '].wWsStaffCount" datatype="*" nullmsg="请选择人数！">'
		        +'<option value="" selected>请选人数</option>'
		        +'<option value="1">1人</option>'
		        +'<option value="2">2人</option>'
		        +'<option value="3">3人</option>'
		        +'<option value="4">4人</option>'
		        +'<option value="5">5人</option>'
		        +'</select>'
		        +'<span>时长['+ (wj+1) + ']</span>'
		        +'<select class="select" size="1" name="workerStaffs[' + wj + '].wWsHours" datatype="*" nullmsg="请选择时长！">'
		        +'<option value="" selected>请选择时长</option>'
		        +'<option value="1">1小时</option>'
		        +'<option value="2">2小时</option>'
		        +'<option value="3">3小时</option>'
		        +'<option value="4">4小时</option>'
		        +'</select>');
	});
	
});
</script>
</body>
</html>