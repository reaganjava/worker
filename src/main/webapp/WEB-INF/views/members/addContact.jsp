<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">   
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" >  
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wei-index.css?v=0.1" />
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/css/out-use.css?v=0.1"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/icheck/jquery.icheck.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/Validform/5.3.2/Validform.min.js?v=0.1"></script>
<title>添加地址</title>
</head>
<body>
<div class="xsh">
<div class="page-all">
<div class="container">
<nav class="navbar">
<ul>
<li><a href="javascript:void();" onclick="window.history.back(-2);"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span class="navber-word">添加地址</span></li>
<li></li>
</ul>
</nav>
<!---导航结束--->
<div>
<form action="${pageContext.request.contextPath}/members/addContact.html" method="POST" id="addForm">
<div class="c-citi">
<input type="hidden" name="wCCity" value="重庆" />
<div class="xsh_cells vux-no-group-title"> 
<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <select id="d" name="wCDistrict" style="height:40px;-webkit-appearance:none;appearance:none;border:none;font-size:18px;padding:0px 10px;display:block;width:100%;-webkit-box-sizing:border-box;box-sizing:border-box;background-color: #FFFFFF;color:#333333;border-radius:4px;">
																													<option value="0">请选择所在区（县）</option>
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
																												</select> </div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="a" name="wCAddress" pattern="*" placeholder="具体地址，如3号楼 4单元 402" type="text"> </div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="c" name="wCContact" pattern="*" placeholder="联系人姓名" type="text"> </div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" id="t" name="wCTelephone" pattern="*" placeholder="联系人手机号" type="text"> </div></div>
</div> 
<span id="error_info">${ERROR_INFO}</span></div>
<!--表单结束-->
<div class="register-btn"><button class="rg-btn" onClick="onAdd()">保存</button></div>
<div class="agreement">请填写详细地址，以便于服务人员准确找到</div>
</div>
</div>
</form>
</div>
</body>
<script type="text/javascript">
	function onAdd() {
		var is = true;
 		var d = $("#d").val();
 	   	if(d == 0) {
 	   	$('#error_info').html('请选择所在区');
 		  	is = false; 
 	   	}
 	   var d = $("#a").val();
 	   if(d == '' || d.length < 1 || isNaN(d)) {
	   	$('#error_info').html('请输入正确的地址');
		  	is = false; 
	   	}
 	  if(c == '' || c.length < 1 || isNaN(c)) {
 		   	$('#error_info').html('请输入正确的联系人');
 			  	is = false; 
 	   }
 	  if(t == '' || t.length < 10 || isNaN(t)) {
		   	$('#error_info').html('请输入正确的电话号码');
			  	is = false; 
	   }
 		if(is) {
	   		document.getElementById('addForm').submit();
 		}
	}
</script>
</html>
