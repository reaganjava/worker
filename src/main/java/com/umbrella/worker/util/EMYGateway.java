package com.umbrella.worker.util;

import java.util.List;

import org.apache.log4j.Logger;

import com.umbrella.worker.service.impl.ContactServiceImpl;

import cn.emay.sdk.client.api.Client;
import cn.emay.sdk.client.api.StatusReport;


/********
 * EMY短信网关实现
 * <p>
 * <li>供应商 亿美软通-阳刚
 * <li>qq:1171781170
 * <li>手机号：15086702925
 * <li>不能发送广告短信
 * <li>10分钟内最多1个手机号发3条
 * </p>
 * */

public class EMYGateway {
	private static final String SMS_PREX = "【新生活家庭式预订平台】"; // 星耀创投
	private static final String SMS_CONFIG_GUID = "sms_emy_guid";
	private Client client = null;
	
	private static Logger logger = Logger.getLogger(EMYGateway.class);

	public void init() throws Exception {
		
		String spCode = "9SDK-EMY-0999-RIXQS";
		String userName = "df311175c5040abf3f6d79d5203afeda";
		String pwd = "874972";
		

		client = SingletonClient.getClient(spCode, pwd);
		int statusCode = client.registEx(pwd);
		if (statusCode != 0) {
			logger.error("EMYGateway init fail");
			
			throw new Exception("网关初始化错误！statusCode=" + statusCode);
		} else {
			logger.info("网关初始化完毕");
		}
	}

	public boolean sendDetail(String mobile, String content, long seq) {
		int i = client.sendSMSEx(new String[] { mobile }, content, "", "GBK",
				3, seq);// 带扩展
		if (i != 0) {
			logger.error("#EMYGateway.sendDetail fail,sendResult=" + i
					+ ",content=" + content + ",mobile=" + mobile);
		}
		return i == 0;
	}
	
	public static void main(String[] args) {
		EMYGateway gateway = new EMYGateway();
		try {
			gateway.init();
			gateway.sendDetail("13983272841", "hello" + EMYGateway.SMS_PREX, 123456);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

