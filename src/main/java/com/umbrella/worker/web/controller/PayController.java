package com.umbrella.worker.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.dto.OrderDO;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IMemberService;
import com.umbrella.worker.service.IOrderService;
import com.umbrella.worker.service.IPayService;
import com.umbrella.worker.util.Constant;
import com.umbrella.worker.util.GetWeiXinOAuthUrl;
import com.umbrella.worker.util.SignUtil;

/**
 * 微信支付服务端简单示例
 * 
 * @author seven_cm
 * @dateTime 2014-11-29
 */
@Controller
@RequestMapping("/pay")
public class PayController {

	private Logger logger = Logger.getLogger(PayController.class);
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IPayService payService;
	
	
	@RequestMapping(value = "/getCode/{orderNo}.html", method = RequestMethod.GET)
	public ModelAndView getUserCode(ModelAndView mav, 
			@PathVariable(value="orderNo") String orderNo,
			HttpServletRequest request, HttpServletResponse response) {
		String url = GetWeiXinOAuthUrl.getCodeRequest(orderNo);
		
		System.out.println(url);
		return new ModelAndView("redirect:" + url);
	}

	@RequestMapping(value = "oauth.html")
	public ModelAndView oauth(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		String orderNo = request.getParameter("orderNo");
		ResultDO result = memberService.userOAuth(code);
		if(result.isSuccess()) {
			mav.addObject("OPENID", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.addObject("ORDERNO", orderNo);
			mav.setViewName("test");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}

	@RequestMapping(value = "/getPay.html", method = RequestMethod.POST)
	public ModelAndView getPay(ModelAndView mav, String openid, String orderNo, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String nonceStr = UUID.randomUUID().toString().substring(0, 32);

		long timestamp = System.currentTimeMillis() / 1000;
		
		ResultDO result = payService.getPrepayId(orderNo, openid, request.getRemoteAddr(), nonceStr);
		
		if(result.isSuccess()) {
			String prepayid = (String) result.getModel(ResultSupport.FIRST_MODEL_KEY);
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
			logger.info("paySign=" + paySign);
			mav.setViewName("pay/confirm");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/paySuccess.html", method = RequestMethod.GET)
	public ModelAndView paySuccess(ModelAndView mav, String orderNo, HttpServletRequest request) {
		OrderDO orderDO = new OrderDO();
		orderDO.setwOOrderNo(orderNo);
		ResultDO result = orderService.updatePayStatus(orderDO);
		if(result.isSuccess()) {
			mav.setViewName("paySuccess");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}

	@RequestMapping(value = "/payRes.html")
	public String payRes( HttpServletRequest request, HttpServletResponse response) {
		String wexinRes = this.getPostString(request);
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
	

}