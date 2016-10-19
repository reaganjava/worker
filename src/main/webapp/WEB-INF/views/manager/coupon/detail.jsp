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
<title>修改优惠卷</title>
</head>
<body>
<div class="pd-20">
  <form action="${pageContext.request.contextPath}/coupon/edit.json" method="post" class="form form-horizontal" id="form-coupon-add">
    <input type="hidden" value="${COUPON_INFO.id}" name="id" />
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>优惠卷标题：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${COUPON_INFO.wCTitle}" placeholder="" id="wCTitle" name="wCTitle" datatype="*" nullmsg="优惠卷标题不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <span class="c-red">*</span><label class="form-label col-3">优惠卷类型：</label>
      <div class="formControls col-5"> <span class="select-box">
        <select class="select" size="1" name="wCType" datatype="*" nullmsg="请选择类型！">
          <option value="" selected>请选类型</option>
          <option value="1">代金卷</option>
          <option value="2">折扣券</option>
        </select>
        </span> </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>优惠卷说明：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" name="wCDesc" id="wCDesc" value="${COUPON_INFO.wCDesc}" datatype="*" nullmsg="优惠卷说明不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>优惠卷价值：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${COUPON_INFO.wCMoney}" placeholder="" id="wCMoney" name="wCMoney"  datatype="n" nullmsg="优惠卷价值">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>优惠卷折扣：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${COUPON_INFO.wCDiscount}" placeholder="" id="wCDiscount" name="wCDiscount"  datatype="n" nullmsg="优惠卷折扣">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>开始发行时间：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" value="<fmt:formatDate value="${coupon.wCBeginTime}"  type="BOTH" dateStyle="full"/>" name="beginTime" id="beginTime" onClick="WdatePicker()" nullmsg="开始发行时间不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
   <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>结束发行时间：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder=""  value="<fmt:formatDate value="${coupon.endTime}"  type="BOTH" dateStyle="full"/>" name="endTime" id="endTime" onClick="WdatePicker()" nullmsg="结束发行时间不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>有效天数：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" value="${COUPON_INFO.wCDays}"  name="wCDays" id="wCDays" datatype="n" nullmsg="真实姓名不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>发行数量：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" value="${COUPON_INFO.wCPublishiCount}" name="wCPublishiCount" id="wCPublishiCount" datatype="n" nullmsg="发行数量不能为空">
      </div>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-coupon-add").Validform({
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