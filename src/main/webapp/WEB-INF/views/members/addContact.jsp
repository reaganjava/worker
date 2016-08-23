<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
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
<li><a href="${pageContext.request.contextPath}/members/contacts.html"><img src="${pageContext.request.contextPath}/images/left.png"/></a></li>
<li><span>添加地址</span></li>
<li></li>
</ul>
</nav>
<!---导航结束--->
<div>
<form action="${pageContext.request.contextPath}/members/addContact.html" method="POST" id="addForm">
<div class="c-citi">
<input type="hidden" name="wCCity" value="重庆" />
<div class="xsh_cells vux-no-group-title"> 
<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <select name="wCDistrict" style="height:40px;-webkit-appearance:none;appearance:none;border:none;font-size:18px;padding:0px 10px;display:block;width:100%;-webkit-box-sizing:border-box;box-sizing:border-box;background-color: #FFFFFF;color:#333333;border-radius:4px;">
																													<option value="">请选择所在区（县）</option>
																													<option value="渝中区">渝中区</option>
																													<option value="南岸区">南岸区</option>
																													<option value="江北区">江北区</option>
																													<option value="巴南区">巴南区</option>
																													<option value="渝北区">渝北区</option>
																													<option value="九龙坡">九龙坡</option>
																												</select> </div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" name="wCAddress" pattern="*" placeholder="具体地址，如3号楼 4单元 402" type="text"> </div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" name="wCContact" pattern="*" placeholder="联系人姓名" type="text"> </div></div>

<div class="xsh_cell xsh_cell_warn"> <div class="xsh_cell_hd"></div> <div class="xsh_cell_bd xsh_cell_primary"> <input class="xsh_input" name="wCTelephone" pattern="*" placeholder="联系人手机号" type="text"> </div></div>
</div> </div>
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
		document.getElementById('addForm').submit();
	}
</script>
</html>
