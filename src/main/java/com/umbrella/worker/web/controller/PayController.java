package com.umbrella.worker.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.umbrella.worker.dto.MemberCouponDO;
import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.dto.PayrecordDO;
import com.umbrella.worker.query.PayrecordQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;

import com.umbrella.worker.service.IMemberService;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.service.IPayService;
import com.umbrella.worker.util.CommonUtil;
import com.umbrella.worker.util.Constant;
import com.umbrella.worker.util.GetWeiXinOAuthUrl;
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
@RequestMapping("/pay")
public class PayController extends BaseController{

	private Logger logger = Logger.getLogger(PayController.class);
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IPayService payService;
	
	@Autowired
	private IMemberService memberService;
	
	
	@RequestMapping(value = "/payInfo/{orderNo}/{fee}/{couponId}.html", method = RequestMethod.GET)
	public ModelAndView payInfo(ModelAndView mav, 
			@PathVariable(value="orderNo") String orderNo,
			@PathVariable(value="fee") BigDecimal fee,
			@PathVariable(value="couponId") Integer couponId,
			HttpServletRequest request, HttpServletResponse response) {
		
		ResultDO result = memberService.getCoupon(couponId);
		
		MemberCouponDO memberCouponDO = (MemberCouponDO) result.getModel(ResultSupport.FIRST_MODEL_KEY);
		PayrecordDO payrecordDO = new PayrecordDO();
		payrecordDO.setwPrOrderNo(orderNo);
		payrecordDO.setwPrFee(fee);
		if(result.isSuccess()) {
			payrecordDO.setwPrIsCoupon(1);
			if(memberCouponDO.getwMcCouponType() == 1) {
				payrecordDO.setwPrCouponPrice(memberCouponDO.getwMcMoney());
			} else {
				float discount = memberCouponDO.getwMcDiscount();
				payrecordDO.setwPrCouponPrice(fee.divide(fee.multiply(new BigDecimal(discount))));
			}
		} else {
			payrecordDO.setwPrIsCoupon(0);
		}
		//payrecordDO.setwPrPayChannel(Constant.PAY_CHANNELS[0]);
		payrecordDO.setwPrTimestamp((int) System.currentTimeMillis());
		//0未支付 1已支付 2支付失败
		payrecordDO.setwPrStatus(0);
		payrecordDO.setStatus(1);
		payrecordDO.setCreateAuthor("system");
		payrecordDO.setModifiAuthor("system");
		payrecordDO.setDatalevel(1);
	
		result = null;
		
		result = payService.create(payrecordDO);
		if(result.isSuccess()) {
			Integer id = (Integer) result.getModel(ResultSupport.FIRST_MODEL_KEY);
			payrecordDO.setId(id);
			mav.addObject("PAY_INFO", payrecordDO);
			mav.addObject("COUPON_ID", couponId);
			mav.setViewName("pay/info");
		} else {
			mav.setViewName("pay/fail");
		}
		return mav;
	}
	
	@RequestMapping(value = "/confirm.html", method = RequestMethod.POST)
	public ModelAndView getUserCode(ModelAndView mav, 
			PayrecordDO payrecordDO,
			HttpServletRequest request, HttpServletResponse response) {
		String url = null;
		if(payrecordDO.getPayChannelValue() == 0) {
			System.out.println("************************" + payrecordDO.getwPrOrderNo());
			GetWeiXinOAuthUrl gwxa = new GetWeiXinOAuthUrl();
			url = gwxa.getCodeRequest(payrecordDO.getwPrOrderNo(), payrecordDO.getCouponId());
			System.out.println("payURL:" + url);
		}
		
		payrecordDO.setModifiAuthor((String) request.getSession().getAttribute("MEMBER_MOBILE"));
		ResultDO result = payService.modifi(payrecordDO);
		if(result.isSuccess()) {
			return new ModelAndView("redirect:" + url);
		} else {
			mav.setViewName("error");
			return mav;
		}
		
	}

	@RequestMapping(value = "oauth.html")
	public ModelAndView oauth(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		String orderNo = request.getParameter("orderNo");
		Integer couponId = Integer.parseInt(request.getParameter("couponId"));
		String openid = userOAuth(code);
		if(openid != null) {
			System.out.println(openid);
			request.getSession().setAttribute("openid", openid);
			request.getSession().setAttribute("orderNo", orderNo);
			request.getSession().setAttribute("couponId", couponId);
			return new ModelAndView("redirect:/pay/invoke.html");
		} else {
			mav.setViewName("pay/fail");
		}
		return mav;
	}

	@RequestMapping(value = "/invoke.html", method = RequestMethod.GET)
	public ModelAndView getPay(ModelAndView mav, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String openid = (String) request.getSession().getAttribute("openid");
		String orderNo = (String) request.getSession().getAttribute("orderNo");
		Integer couponId = (Integer) request.getSession().getAttribute("couponId");
		String nonceStr = UUID.randomUUID().toString().substring(0, 32);

		long timestamp = System.currentTimeMillis() / 1000;
		
		PayrecordQuery payrecordQuery = new PayrecordQuery();
		payrecordQuery.setOrderNo(orderNo);
		System.out.println("=================" + orderNo + "======================");
		ResultDO result = payService.list(payrecordQuery);
		
		if(result.isSuccess()) {
			List<PayrecordDO> payList = (List<PayrecordDO>) result.getModel(ResultSupport.FIRST_MODEL_KEY);
			String prepayid = getPrepayId(payList.get(0), openid, request.getRemoteAddr(), nonceStr);
			// 封装h5页面调用参数
			Map<String, String> signMap = new HashMap<String, String>();
			signMap.put("appId", Constant.APP_ID);
			logger.info("appId=" + Constant.APP_ID);
			signMap.put("timeStamp", timestamp + "");
			logger.info("timeStamp=" + timestamp);
			signMap.put("package", "prepay_id=" + prepayid);
			logger.info("package=" + "prepay_id=" + prepayid);
			signMap.put("signType", "MD5");
			logger.info("singType=" + "MD5");
			signMap.put("nonceStr", nonceStr);
			logger.info("nonceStr=" + nonceStr);
			mav.addObject("appId", Constant.APP_ID);
			mav.addObject("paytimestamp", timestamp);
			mav.addObject("paypackage", "prepay_id=" + prepayid);
			mav.addObject("paynonceStr", nonceStr);
			mav.addObject("paysignType", "MD5");
			String paySign = SignUtil.getPayCustomSign(signMap, Constant.APP_KEY);
			mav.addObject("paySign", paySign);
			mav.addObject("ORDERNO", orderNo);
			mav.addObject("COUPONID", couponId);
			logger.info("paySign=" + paySign);
			mav.setViewName("pay/invoke");
		} else {
			mav.setViewName("pay/fail");
		}
		return mav;
	}
	
	@RequestMapping(value = "/status/{orderNo}/{couponId}/{status}.html", method = RequestMethod.GET)
	public ModelAndView paySuccess(ModelAndView mav, 
			@PathVariable(value="orderNo") String orderNo, 
			@PathVariable(value="couponId") Integer couponId,
			@PathVariable(value="status") Integer status,
			HttpServletRequest request) {
		OrderDO orderDO = new OrderDO();
		orderDO.setwOOrderNo(orderNo);
		System.out.println("=================" + orderNo + "======================");
		ResultDO result = null;
		if(status == 1) {
			result = orderService.updateStatus(orderDO);
			if(couponId != 0) {
				memberService.verification(couponId);
			}
		} else {
			mav.addObject("ORDERNO", orderNo);
			mav.setViewName("pay/fail");
			return mav;
		}
		
		if(result.isSuccess()) {
			Integer id = (Integer) result.getModel(ResultSupport.FIRST_MODEL_KEY);
			return new ModelAndView("redirect:/order/orderDetail/" +id + ".html");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}

	@RequestMapping(value = "/payRes.html")
	public String payRes( HttpServletRequest request, HttpServletResponse response) {
		String wexinRes = this.getPostString(request);
		System.out.println(wexinRes);
		return "";
	}
	

    private String getPostString(HttpServletRequest request) {
    	String values = null;
    	InputStream in = null;
    	try {
    		in = request.getInputStream();
			int bufferSize = in.available();
			byte[] buffers = new byte[bufferSize];
			in.read(buffers);
			values = new String(buffers);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	return values;
    }
	

    public String userOAuth(String userCode) {
		
		String oauth2_url = Constant.WEIXIN_OAUTH2_URL;
		oauth2_url = oauth2_url.replace("{APPID}", Constant.APP_ID)
				  .replace("{SECRET}", Constant.APP_SECRET)
				  .replace("{CODE}", userCode);
		System.out.println(oauth2_url);
		//第一次请求 获取access_token 和 openid
		String oppid = null;
		try {
			oppid = new GetWeixinOAuth().doGet(oauth2_url);
		} catch (Exception e) {
			return null;
		}
		JSONObject oppidObj = JSONObject.fromObject(oppid);
		String access_token = (String) oppidObj.get("access_token");
		String openid = (String) oppidObj.get("openid");
		String requestUrl2 = "https://api.weixin.qq.com/sns/userinfo?access_token=" 
				+ access_token + "&openid=" + openid + "&lang=zh_CN";
		String userInfoStr = null;
		try {
			userInfoStr = new GetWeixinOAuth().doGet(requestUrl2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject wxUserInfo = JSONObject.fromObject(userInfoStr);
		
		System.out.println("====================" + openid);
	
		return openid;
	}
    
    public String getPrepayId(PayrecordDO payrecordDO, String openid, String memberIP, String nonceStr) {
	
		logger.info("************openid***********：" + openid);
		int fee = (int) (payrecordDO.getwPrFee().doubleValue() * 100);
		if(payrecordDO.getwPrIsCoupon() != 0) {
			int srcFee = (int) (payrecordDO.getwPrFee().doubleValue() * 100);
			int d = (int) (payrecordDO.getwPrCouponPrice().doubleValue() * 100);
			fee = srcFee - d;
		}
		
		// 获取prepayid
		Map<String, String> map = new HashMap<String, String>();
		map.put("appid", Constant.APP_ID);
		map.put("mch_id", Constant.MCH_ID);
		map.put("nonce_str", nonceStr);
		try {
			map.put("body", new String("嘿管家服务费".getBytes("utf-8")));
		} catch (UnsupportedEncodingException e1) {
			
			e1.printStackTrace();
		}
		map.put("out_trade_no", payrecordDO.getwPrOrderNo());
		//map.put("total_fee", fee + "");
		map.put("total_fee", "1");
		map.put("spbill_create_ip", memberIP);
		map.put("notify_url", Constant.NOTIFY_URL);
		map.put("trade_type", "JSAPI");
		map.put("openid", openid);
		String paySign = null;
	
		try {
			paySign = SignUtil.getPayCustomSign(map, Constant.APP_KEY);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		map.put("sign", paySign);
		String xml = CommonUtil.ArrayToXml(map);
		return getPrepayid(xml);
	}
	
	@SuppressWarnings("deprecation")
	private JSONObject getPrepayJson(String xml) {
		String URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		HttpClient httpClient = new HttpClient(new HttpClientParams(), new SimpleHttpConnectionManager(true));
		InputStream is = null;
		PostMethod method = null;
		try {
			String url = URL;
			method = new PostMethod(url);
			method.setRequestBody(xml);
			httpClient.executeMethod(method);
			// 读取响应
			is = method.getResponseBodyAsStream();
			JSONObject o = Xml2JsonUtil.xml2JSON(is);
			return o;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (method != null) {
				method.releaseConnection();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return null;
	}

	private String getPrepayid(String xml) {
		try {
			System.out.println(xml);
			JSONObject jo = getPrepayJson(xml);
			JSONObject element = jo.getJSONObject("xml");
			System.out.println("==================" + jo);
			String prepayid = ((JSONArray) element.get("prepay_id")).get(0).toString();
			return prepayid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(new PayController().getPrepayid("<xml><nonce_str><![CDATA[5af8cc99-9833-4189-aadb-0a486042]]>"
				+ "</nonce_str><out_trade_no><![CDATA[20160907075601534678]]>"
				+ "</out_trade_no><openid><![CDATA[oQB-Ww4tdgaWivaxF45nFXg-26MI]]>"
				+ "</openid><appid><![CDATA[wxc419a6155fcf608b]]></appid><total_fee>1</total_fee>"
				+ "<sign><![CDATA[C5835D067670969C2F277FA7FC0E3425]]></sign><trade_type>"
				+ "<![CDATA[JSAPI]]></trade_type><mch_id><![CDATA[1375882602]]></mch_id><body>"
				+ "<![CDATA[%D0%C2%C9%FA%BB%EE%BC%D2%CD%A5%B7%FE%CE%F1%C6%BD%CC%A8%B7%FE%CE%F1%B7%D1%D3%C3]]>"
				+ "</body><notify_url><![CDATA[http://wx.xsh1314.com/pay/payRes.html]]></notify_url>"
				+ "<spbill_create_ip><![CDATA[14.111.60.222]]></spbill_create_ip></xml>"));
	}
}