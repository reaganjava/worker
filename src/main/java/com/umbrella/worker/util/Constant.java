package com.umbrella.worker.util;

public class Constant {

	public static final String SMS_MOBILE_VAIDATE_KEY = "sms_mobile_vaidate";
	
	public static final String SMS_ORDER_ASSIGNED_KEY = "sms_order_assigned";
	
	
	public static final String[] PAY_CHANNELS = {"微信支付", ""};
	
	//初始化
	public static String APP_ID = "wxc419a6155fcf608b";//微信开发平台应用id
	public static String APP_SECRET = "b21159d0e4dab3eac23de2a78e15d31a";//应用对应的凭证
	//应用对应的密钥
	public static String APP_KEY = "XINshengHUO1314liuPEIsong2016086";
	public static String MCH_ID = "1375882602";//财付通商户号
	public static String NOTIFY_URL = "http://wx.xsh1314.com/pay/payRes.html";
	public static String WEIXIN_OAUTH2_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={APPID}&secret={SECRET}&code={CODE}&grant_type=authorization_code";
}
