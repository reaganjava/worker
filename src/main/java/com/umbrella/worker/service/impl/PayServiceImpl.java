package com.umbrella.worker.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umbrella.worker.dao.WPayrecordMapper;
import com.umbrella.worker.dto.PayrecordDO;
import com.umbrella.worker.entity.WPayrecord;
import com.umbrella.worker.entity.WPayrecordExample;
import com.umbrella.worker.query.PayrecordQuery;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.result.ResultSupport;
import com.umbrella.worker.service.IPayService;
import com.umbrella.worker.util.BeanUtilsExtends;
import com.umbrella.worker.util.CommonUtil;
import com.umbrella.worker.util.Constant;
import com.umbrella.worker.util.SignUtil;
import com.umbrella.worker.util.StringUtil;
import com.umbrella.worker.util.Xml2JsonUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("payService")
public class PayServiceImpl  extends BaseServiceImpl implements IPayService {
	
	private static Logger logger = Logger.getLogger(PayServiceImpl.class);
	@Autowired
	private WPayrecordMapper payrecordMapper;

	@Override
	public ResultDO create(PayrecordDO payrecordDO) {
		
		WPayrecord payrecord = new WPayrecord();
		
		ResultSupport result = BeanUtilsExtends.copy(payrecord, payrecordDO);
		
		if(!result.isSuccess()) {
			return result;
		}
		
		int recordNum = -1;
		
		payrecord.setDatalevel(1);
		payrecord.setStatus(1);
		payrecord.setCreateTime(Calendar.getInstance().getTime());
		payrecord.setModifiTime(Calendar.getInstance().getTime());
		
		try {
			recordNum = payrecordMapper.insertSelective(payrecord);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			logger.error("[obj:coupon][opt:create][msg:" + e.getMessage()
			+ "]");
			return result;
		}
		
		if(recordNum == 1) {
			result.setModel(ResultDO.FIRST_MODEL_KEY, payrecord.getId());
		} else {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO modifi(PayrecordDO payrecordDO) {
		
		WPayrecord payrecord = new WPayrecord();

		ResultSupport result = BeanUtilsExtends.copy(payrecord, payrecordDO);
		// 拷贝失败
		if (!result.isSuccess()) {
			return result;
		}
		payrecord.setModifiTime(Calendar.getInstance().getTime());
		int recordNum = -1;
		try {
			recordNum = payrecordMapper.updateByPrimaryKey(payrecord);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
			result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			logger.error("[obj:coupon][opt:modifi][msg:" + e.getMessage()
					+ "]");
			return result;
		}
		if (recordNum < 1) {
			result.setSuccess(false);
		}

		return result;
	}

	@Override
	public ResultDO remove(int payrecordId) {
		
		ResultSupport result = new ResultSupport();
		
		WPayrecord payrecord = new WPayrecord();
		
		if(StringUtil.isGreatOne(payrecordId)) {
			payrecord.setId(payrecordId);
		} else {
		    result.setSuccess(false);
		    return result;
		}
		payrecord.setDatalevel(-1);
		int recordNum = -1;
		try {
			recordNum = payrecordMapper.updateByPrimaryKeySelective(payrecord);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:coupon][opt:remove][msg:"+e.getMessage()+"]");
	        return result;
		}
		if (recordNum != 1) {
			result.setSuccess(false);
		}
		return result;
	}

	@Override
	public ResultDO get(int payrecordId) {
		
		ResultSupport result = new ResultSupport();
		
		WPayrecord payrecord = null;
		if(!StringUtil.isGreatOne(payrecordId)) {
			 result.setSuccess(false);
			 return result;
		} 
		
		try {
			payrecord = payrecordMapper.selectByPrimaryKey(payrecordId);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:coupon][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		PayrecordDO payrecordDO = getPayrecordDO(payrecord);
		if(payrecordDO != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, payrecordDO);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
			return result;
		}
		
		return result;
	}

	@Override
	public ResultDO list(PayrecordQuery payrecordQuery) {
		
		ResultSupport result = new ResultSupport();
		
		WPayrecordExample example = new WPayrecordExample();
		WPayrecordExample.Criteria c = example.createCriteria();
	
		
		if(StringUtil.isNotEmpty(payrecordQuery.getOrderByClause())) {	
			example.setOrderByClause(" " + payrecordQuery.getOrderByClause() + " " + payrecordQuery.getSort());
		} else {
			example.setOrderByClause(" CREATE_TIME DESC");
		}
		
		if(payrecordQuery.isPage()) {
			long count = 0;
			try {
				count = payrecordMapper.countByExample(example);
			} catch (Exception e) {
				result.setSuccess(false);
		        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
		        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
		        e.printStackTrace();
		        logger.error("[obj:member][opt:get][msg:"+e.getMessage()+"]");
		        return result;
			}
			result.setModel(ResultSupport.SECOND_MODEL_KEY, count);
			int pageNO = payrecordQuery.getPageNO();
			if(pageNO > 0) {
				pageNO = pageNO -1;
			}
			String pageByClause = " limit " + (pageNO * payrecordQuery.getPageRows())
					+ "," + payrecordQuery.getPageRows();
			
			example.setPageByClause(pageByClause);
		}
		
		List<WPayrecord> list = null;
		
		try {
			list = payrecordMapper.selectByExample(example);
		} catch (Exception e) {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        logger.error("[obj:coupon][opt:get][msg:"+e.getMessage()+"]");
	        return result;
		}
		
		List<PayrecordDO> payrecordList = getPayrecordDOList(list);
		
		if(payrecordList.size() > 0) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, payrecordList);
		} else {
			result.setSuccess(false);
	        result.setErrorCode(ResultDO.SYSTEM_EXCEPTION_ERROR);
	        result.setErrorMsg(ResultDO.SYSTEM_EXCEPTION_ERROR_MSG);
	        return result;
		}
		return result;
	}
	
	public ResultDO getPrepayId(String orderNo, String openid, String memberIP, String nonceStr) {
		ResultSupport result = new ResultSupport();
		logger.info("************openid***********：" + openid);
		// 获取prepayid
		Map<String, String> map = new HashMap<String, String>();
		map.put("appid", Constant.APP_ID);
		map.put("mch_id", Constant.MCH_ID);
		map.put("nonce_str", nonceStr);
		map.put("body", "test");
		map.put("out_trade_no", orderNo);
		map.put("total_fee", "1");
		map.put("spbill_create_ip", memberIP);
		map.put("notify_url", Constant.NOTIFY_URL);
		map.put("trade_type", "JSAPI");
		map.put("openid", openid);
		String paySign = null;
		try {
			paySign = SignUtil.getPayCustomSign(map, Constant.APP_KEY);
		} catch (Exception e) {
			result.setSuccess(false);
		}
		map.put("sign", paySign);
		String xml = CommonUtil.ArrayToXml(map);
		String prepayid = getPrepayid(xml);
		if(prepayid != null) {
			result.setModel(ResultSupport.FIRST_MODEL_KEY, prepayid);
		} else {
			result.setSuccess(false);
		}
		return result;
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
			String prepayid = ((JSONArray) element.get("prepay_id")).get(0).toString();
			return prepayid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
