<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PAY</title>
</head>
<body>
${appId}<br/>
${paytimestamp}<br/>
${paynonceStr}<br/>
${paypackage}<br/>
${paysignType}<br/>
${paySign}<br/>
</body>
<script type="text/javascript">
function onBridgeReady(){
	   WeixinJSBridge.invoke(
	       'getBrandWCPayRequest', {
	           "appId":"${appId}",     //公众号名称，由商户传入     
	           "timeStamp":"${paytimestamp}",         //时间戳，自1970年以来的秒数     
	           "nonceStr":"${paynonceStr}", //随机串     
	           "package":"${paypackage}",     
	           "signType":"${paysignType}",         //微信签名方式：     
	           "paySign":"${paySign}" //微信签名 
	       },
	       function(res){     
	    	  
	           if(res.err_msg == "get_brand_wcpay_request：ok" ) {
	        	  location.href = "${pageContext.request.contextPath}/order/userOrders/1.html"
	           } else if(res.err_msg == "get_brand_wcpay_request：fail" ) {
	        	   
	           } else if(res.err_msg == "get_brand_wcpay_request：cancel" )  {
	        	   
	           }  
	           
	           // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
	       }
	   ); 
	}
	if (typeof WeixinJSBridge == "undefined"){
	   if( document.addEventListener ){
	       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
	   }else if (document.attachEvent){
	       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
	       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
	   }
	}else{
	   onBridgeReady();
	} 
</script>
</html>