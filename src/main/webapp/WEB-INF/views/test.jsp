<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc419a6155fcf608b&redirect_uri=http://www.xsh1314.com/pay/oauth.json&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect"><H1>getUserCode</H1></a> -->
<form action="${pageContext.request.contextPath}/pay/getPay.html" method="POST">
<input type="hidden" value="${OPENID}" name="openid"/> 
<input type="hidden" value="${ORDERNO}" name="orderNo"/> 
<input type="submit" value="ok" style="width:400px; height:100px;"/>
</form>
</body>
</body>
</html>