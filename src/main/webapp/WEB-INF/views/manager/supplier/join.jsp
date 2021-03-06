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
<title>添加渠道</title>
</head>
<body>
<div class="pd-20">
  <form action="${pageContext.request.contextPath}/supplier/join.json" method="post" class="form form-horizontal" id="form-supplier-join">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>渠道名：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="" id="wSName" name="wSName" datatype="*2-30" nullmsg="渠道名不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>联系电话：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="" id="wSTelephone" name="wSTelephone"  datatype="n8-15" nullmsg="联系电话不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>联系人：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" name="wSContact" id="wSContact" datatype="*2-8" nullmsg="联系人不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <span class="c-red">*</span><label class="form-label col-3">所在城市：</label>
      <div class="formControls col-5"> <span class="select-box">
        <select class="select" size="1" name="wSCity" datatype="*" nullmsg="请选择所在城市！">
          <option value="重庆">重庆</option>
        </select>
        </span> </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <span class="c-red">*</span><label class="form-label col-3">所在区(县)：</label>
      <div class="formControls col-5"> <span class="select-box">
        <select class="select" size="1" name="wSDistrict" datatype="*" nullmsg="请选择所在城市！">
          <option value="" selected>请选择区(县)</option>
         <option value="渝中区">渝中区</option>
																													<option value="南岸区">南岸区</option>
																													<option value="江北区">江北区</option>
																													<option value="沙坪坝区">沙坪坝区</option>
																													<option value="九龙坡">九龙坡</option>
																													<option value="巴南区">巴南区</option>
																													<option value="渝北区">渝北区</option>
																													<option value="大渡口区">大渡口区</option>
																													<option value="北碚区">北碚区</option>
																													<option value="綦江区 ">綦江区</option>
																													<option value="长寿区">长寿区</option>
																													<option value="江津区">江津区</option>
																													<option value="合川区">合川区</option>
																													<option value="永川区">永川区</option>
																													<option value="南川区">南川区</option>
																													<option value="铜梁区">铜梁区</option>
																													<option value="潼南区">潼南区</option>
																													<option value="黔江区">黔江区</option>
																													<option value="荣昌区">荣昌区</option>
																													<option value="璧山区">璧山区</option>
																													<option value="万州区">万州区</option>
																													<option value="涪陵区">涪陵区</option>
        </select>
        </span> </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>公司地址：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" name="wSAddress" id="wSAddress" datatype="*" nullmsg="地址不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red"></span>网站：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" name="wSWebsite" id="wSWebsite" dragonfly="true" >
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