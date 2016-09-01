package com.umbrella.worker.util;

import java.util.Map;

import org.apache.log4j.Logger;



public class SignUtil {
	
	private static Logger logger = Logger.getLogger(SignUtil.class);

	/**
     * 获取支付所需签名
     * @param ticket
     * @param timeStamp
     * @param card_id
     * @param code
     * @return
     * @throws Exception
     */
    public static String getPayCustomSign(Map<String, String> bizObj,String key) throws Exception {
        
        String bizString = CommonUtil.FormatBizQueryParaMap(bizObj,
                false);
        logger.info(bizString);
        return sign(bizString, key);
    }
    
    public static String sign(String content, String key)
            throws Exception{
        String signStr = "";
        signStr = content + "&key=" + key;
        logger.info(signStr);
        return MD5Util.MD5(signStr).toUpperCase();

    }
}
