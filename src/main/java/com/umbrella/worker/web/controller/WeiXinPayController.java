package com.umbrella.worker.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.log4j.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.umbrella.worker.tenpay.AccessTokenRequestHandler;
import com.umbrella.worker.tenpay.ClientRequestHandler;
import com.umbrella.worker.tenpay.PackageRequestHandler;
import com.umbrella.worker.tenpay.PrepayIdRequestHandler;
import com.umbrella.worker.tenpay.util.ConstantUtil;
import com.umbrella.worker.tenpay.util.TenpayUtil;
import com.umbrella.worker.tenpay.util.WXUtil;
import com.umbrella.worker.util.CommonUtil;
import com.umbrella.worker.util.GetWeixinOAuth;
import com.umbrella.worker.util.SignUtil;
import com.umbrella.worker.util.Xml2JsonUtil;

/**
 * 微信支付服务端简单示例
 * 
 * @author seven_cm
 * @dateTime 2014-11-29
 */
@Controller
@RequestMapping("/pay/")
public class WeiXinPayController {

	private Logger logger = Logger.getLogger(WeiXinPayController.class);
	
	
	
	@RequestMapping(value = "oauth.html")
	public ModelAndView wexinOAuth(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		System.out.println("==============" + code + "======================");
        String appid = "wxc419a6155fcf608b";
        String secret = "b21159d0e4dab3eac23de2a78e15d31a";
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
        //第一次请求 获取access_token 和 openid
        String oppid = null;
		try {
			oppid = new GetWeixinOAuth().doGet(requestUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JSONObject oppidObj =JSONObject.fromObject(oppid);
        String access_token = (String) oppidObj.get("access_token");
        String openid = (String) oppidObj.get("openid");
        String requestUrl2 = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
        String userInfoStr = null;
		try {
			userInfoStr = new GetWeixinOAuth().doGet(requestUrl2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JSONObject wxUserInfo =JSONObject.fromObject(userInfoStr);
        System.out.println("==============" + wxUserInfo.toString());
        mav.addObject("OPENID", openid);
        mav.setViewName("test");
		return mav; 
	}

	@RequestMapping(value = "/getPay.html", method = RequestMethod.POST)
	public ModelAndView doWeinXinRequest(ModelAndView mav, String openid ,HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		// 接收财付通通知的URL
		String notify_url = "http://wx.xsh1314.com/pay/payInfo.html";

		// ---------------生成订单号 开始------------------------
		// 当前时间 yyyyMMddHHmmss
		String currTime = TenpayUtil.getCurrTime();
		// 8位日期
		String strTime = currTime.substring(8, currTime.length());
		// 四位随机数
		String strRandom = TenpayUtil.buildRandom(4) + "";
		// 10位序列号,可以自行调整。
		String strReq = strTime + strRandom;
		// 订单号，此处用时间加随机数生成，商户根据自己情况调整，只要保持全局唯一就行
		String out_trade_no = strReq;
		 logger.info("************openid***********为："+openid);
	        //获取prepayid
	        Map<String ,String > map=new HashMap<String,String>();
	       
	         String nonceStr=UUID.randomUUID().toString().substring(0, 32);
	         
	     
	     
	        long timestamp = System.currentTimeMillis() / 1000;
	        map.put("appid", ConstantUtil.APP_ID);
	        map.put("mch_id", ConstantUtil.MCH_ID);
	        map.put("nonce_str",nonceStr);
	        map.put("body",  "test");
	        map.put("out_trade_no", out_trade_no);
	        map.put("total_fee", "1");
	        map.put("spbill_create_ip","127.0.0.1");
	        map.put("notify_url", notify_url);
	        map.put("trade_type", "JSAPI");
	        map.put("openid", openid);
	        String paySign=SignUtil.getPayCustomSign(map,ConstantUtil.APP_KEY);
	        map.put("sign",paySign);
	        String xml=    CommonUtil.ArrayToXml(map);
	        String prepayid=  getPrepayid(xml);
	        logger.info("prepareid*****************************="+prepayid);
	       //封装h5页面调用参数
	        Map<String ,String > signMap=new HashMap<String ,String >();
	        signMap.put("appId", ConstantUtil.APP_ID);
	        logger.info("appId="+ConstantUtil.APP_ID);
	        signMap.put("timeStamp", timestamp+"");
	        logger.info("timeStamp="+timestamp);
	        signMap.put("package", "prepay_id="+prepayid);
	        logger.info("package="+"prepay_id="+prepayid);
	        signMap.put("signType", "MD5");
	        logger.info("singType="+"MD5");
	        signMap.put("nonceStr", nonceStr);
	        logger.info("nonceStr="+nonceStr);
	        mav.addObject("appId", ConstantUtil.APP_ID);
	        mav.addObject("paytimestamp", timestamp);
	        mav.addObject("paypackage", "prepay_id="+prepayid);
	        mav.addObject("paynonceStr", nonceStr);
	        mav.addObject("paysignType", "MD5");
	        String paySign2=SignUtil.getPayCustomSign(signMap,ConstantUtil.APP_KEY);
	        mav.addObject("paySign",paySign2);
	        logger.info("paySign="+paySign2);
            mav.setViewName("pay/confirm");
		return mav;
	}
	
	@RequestMapping(value = "/payInfo.html")
	public ModelAndView doWeinXinRequest(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
		return mav;
	}
	
	
    @SuppressWarnings("deprecation")
    public  JSONObject getPrepayJson(String xml){
    	String URL="https://api.mch.weixin.qq.com/pay/unifiedorder";
        HttpClient httpClient = new HttpClient(new HttpClientParams(),new SimpleHttpConnectionManager(true) ); 
        InputStream is = null;
         PostMethod method=null;
        try {
            String url =URL;
             method = new PostMethod(url);
             method.setRequestBody(xml);
            httpClient.executeMethod(method);
            //读取响应
             is = method.getResponseBodyAsStream();
            JSONObject o =Xml2JsonUtil.xml2JSON(is);
            System.out.println(o.toString());
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(method!=null){
                method.releaseConnection();
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }
    
    public  String getPrepayid(String xml){
        try {
        	System.out.println(xml);
            JSONObject jo=getPrepayJson(xml);
            JSONObject element=jo.getJSONObject("xml");
            String prepayid= ((JSONArray)element.get("prepay_id")).get(0).toString();
            return prepayid;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    

}