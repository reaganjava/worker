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
<title>添加管理员</title>
</head>
<body>
<div class="pd-20">
  <form action="${pageContext.request.contextPath}/admin/add.json" method="post" class="form form-horizontal" id="form-supplier-join">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>管理员名：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${MANAGER_INFO.wAUsername}" placeholder="" id="wAUsername" name="wAUsername" datatype="*5-20" nullmsg="管理员名不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>密码：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" name="wAPassword" id="wAPassword" datatype="*8-20" nullmsg="密码不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>联系电话：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${MANAGER_INFO.wATelephone}" placeholder="" id="wATelephone" name="wATelephone"  datatype="n8-15" nullmsg="联系电话不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>真实姓名：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" name="wARealName" id="wARealName" datatype="*3-8" nullmsg="联系人不能为空" value="${MANAGER_INFO.wARealName}">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <span class="c-red">*</span><label class="form-label col-3">所属渠道：</label>
      <div class="formControls col-5"> <span class="select-box">
        <select class="select" size="1" name="wASupplierId" datatype="*" nullmsg="请选择渠道！">
          <option value="" selected>请选渠道</option>
          <c:forEach items="${SUPPLIER_LIST}" var="supplier">
          <option value="${supplier.id}">${supplier.wSName}</option>
          </c:forEach>
         
        </select>
        </span> </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <span class="c-red">*</span><label class="form-label col-3">角色：</label>
      <div class="formControls col-5"> <span class="select-box">
        <select class="select" size="1" name="wARoleId" datatype="*" nullmsg="请选择角色！">
          <option value="" selected>请选角色</option>
          <option value="1">渠道管理员</option>
          <option value="8">平台管理员</option>
        </select>
        </span> </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/icheck/jquery.icheck.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/Validform/5.3.2/Validform.min.js?v=0.1"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.1/layer.js?v=0.1"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/H-ui.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/H-ui.admin.js?v=0.1"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-supplier-join").Validform({
		tiptype:2,
		ajaxPost:true,
		callback:function(data){
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
		
	});
});
</script>
</body>
</html>