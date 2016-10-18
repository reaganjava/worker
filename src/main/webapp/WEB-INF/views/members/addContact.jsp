<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!--[if lt IE 9]>
　　　　<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
　　<![endif]-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/wei-index.css?v=0.1" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/out-use.css?v=0.1" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/icheck/jquery.icheck.min.js?v=0.1"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js?v=0.1"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/Validform/5.3.2/Validform.min.js?v=0.1"></script>
<title>添加地址</title>
</head>
<body>
	<div class="xsh">
		<div class="page-all">
			<div class="container">
				<nav class="navbar">
					<ul>
						<li><a href="javascript:void();"
							onclick="window.history.back(-2);"><img
								src="${pageContext.request.contextPath}/images/left.png" /></a></li>
						<li><span class="navber-word">添加地址</span></li>
						<li></li>
					</ul>
				</nav>
				<!---导航结束--->
				<div>
					<form
						action="${pageContext.request.contextPath}/members/addContact.html"
						method="POST" id="addForm" onsubmit="return onAdd();">
						<div class="c-citi">
							<input type="hidden" name="wCCity" value="重庆" />
							<div class="xsh_cells vux-no-group-title">
								<div class="xsh_cell xsh_cell_warn">
									<div class="xsh_cell_hd"></div>
									<div class="xsh_cell_bd xsh_cell_primary">
										<input type="hidden" id="addrValue" value=""/>
										<select name="wCDistrict" id="ad" onchange="setAddrValue();"
											style="height: 40px; -webkit-appearance: none; appearance: none; border: none; font-size: 18px; padding: 0px 10px; display: block; width: 100%; -webkit-box-sizing: border-box; box-sizing: border-box; background-color: #FFFFFF; color: #333333; border-radius: 4px;">
											<option value="">请选择所在区（县）</option>
											<option value="渝中区">渝中区</option>
											<option value="南岸区">南岸区</option>
											<option value="江北区">江北区</option>
											<option value="巴南区">巴南区</option>
											<option value="渝北区">渝北区</option>
											<option value="北碚区">北碚区</option>
											<option value="沙坪坝区">沙坪坝区</option>
											<option value="九龙坡区">九龙坡区</option>
											<option value="大渡口区">大渡口区</option>
										</select>
									</div>
								</div>

								<div class="xsh_cell xsh_cell_warn">
									<div class="xsh_cell_hd"></div>
									<div class="xsh_cell_bd xsh_cell_primary">
										<input class="xsh_input" id="addr" name="wCAddress"
											pattern="*" placeholder="具体地址，如3号楼 4单元 402" type="text">
									</div>
								</div>

								<div class="xsh_cell xsh_cell_warn">
									<div class="xsh_cell_hd"></div>
									<div class="xsh_cell_bd xsh_cell_primary">
										<input class="xsh_input" id="name" name="wCContact"
											pattern="*" placeholder="联系人姓名" type="text"
											onblur="vName(this)">
									</div>
								</div>

								<div class="xsh_cell xsh_cell_warn">
									<div class="xsh_cell_hd"></div>
									<div class="xsh_cell_bd xsh_cell_primary">
										<input class="xsh_input" id="tel" name="wCTelephone"
											pattern="*" placeholder="联系人手机号" type="text"
											onblur="tel(this)">
									</div>
								</div>
							</div>
						</div>
						<!--表单结束-->
						<div class="register-btn">
							<input type="submit" class="rg-btn" value="保存" />
						</div>
						<div class="agreement">请填写详细地址，以便于服务人员准确找到</div>
				</div>
			</div>
			</form>
		</div>
</body>
<script type="text/javascript">
	function onAdd() {
		if (checkad()+checkAddr() + checkName() + checkTel() == 0) {
			//document.getElementById('addForm').submit();
			return true;
		} else {
			//alert('请输入个人详细信息');
			return false;
		}
	}
	function setAddrValue() {
		var ad = document.getElementById("ad");
		var addrValue = document.getElementById("addrValue");
		addrValue.value = ad.value;
	}
	function checkad(){
		var ad = document.getElementById("addrValue");
		//alert(ad.value);
		//if(ad.children.value.length>0){-
		if (ad.value.length > 0) {
			return 0;
		} else {
			alert('请选择所在区县');
			return 1;
		}
	}
	//var tt=function(){
	//	alert($("#ad option:selected").val());
	//	}

	function checkAddr() {
		var addr = document.getElementById("addr");
		if (addr.value.length > 0) {
			//alert('输入地址有效');
			return 0;
		} else {
			alert('输入地址无效');
			addr.value = "";
			return 1;
		}
	}

	function checkName() {
		var name = document.getElementById("name")
		var regex = /[\u4E00-\u9FA5]{2,4}/;
		if (regex.test(name.value)) {
			//alert('名字输入正确');
			return 0;
		} else {
			alert('请输入合法名字');
			name.value = "";
			return 1;

		}
	}

	function checkTel() {
		var tel = document.getElementById("tel");
		var regex = /^1\d{10}$/;
		if (regex.test(tel.value)) {
			//alert('手机号输入正确');
			return 0;
		} else {
			alert('手机号判断失败,请重新输入');
			tel.value = "";
			return 1;
		}
	}
</script>
</html>
