package com.umbrella.worker.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IMemberService;
import com.umbrella.worker.service.IPayService;
import com.umbrella.worker.util.Constant;
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
	private IPayService payService;

	@RequestMapping(value = "info.html")
	public ModelAndView oauth(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		String orderNO = request.getParameter("orderNO");
		ResultDO result = memberService.userOAuth(code);
		if(result.isSuccess()) {
			mav.addObject("OPENID", result.getModel(ResultSupport.FIRST_MODEL_KEY));
			mav.addObject("ORDERNO", orderNO);
			mav.setViewName("info");
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
			logger.info("paySign=" + paySign);
			mav.setViewName("pay/confirm");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}

	@RequestMapping(value = "/payRes.html")
	public ModelAndView payRes(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
		return mav;
	}

	

}