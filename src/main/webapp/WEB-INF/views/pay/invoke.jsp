<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>

<body onload="callpay()">

</body>
<script type="text/javascript">
function jsApiCall(){
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
	    	  if(res.err_msg == "get_brand_wcpay_request:ok" ) {
	        	   
	        	   window.location.href = "http://wx.xsh1314.com/pay/status/${ORDERNO}/${COUPONID}/1.html"
	           } else if(res.err_msg == "get_brand_wcpay_request:fail" ) {
	        	  lwindow.location.href = "http://wx.xsh1314.com/pay/status/${ORDERNO}/${COUPONID}/2.html"
	           } else if(res.err_msg == "get_brand_wcpay_request:cancel" )  {
	        	   window.location.href  = "http://wx.xsh1314.com/pay/status/${ORDERNO}/${COUPONID}/2.html" 
	           }  
	           
	           // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
	       }
	   ); 
	}
function callpay()
{
	if (typeof WeixinJSBridge == "undefined"){
	   if( document.addEventListener ){
	       document.addEventListener('WeixinJSBridgeReady', jsApiCall, false);
	   }else if (document.attachEvent){
	       document.attachEvent('WeixinJSBridgeReady', jsApiCall); 
	       document.attachEvent('onWeixinJSBridgeReady', jsApiCall);
	   }
	}else{
		jsApiCall();
	}
}
jsApiCall();
</script>
</html>