package com.umbrella.worker.util;

import java.net.URLEncoder;

public class GetWeiXinCode {
    public static String  GetCodeRequest = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    public static String getCodeRequest(){
        String result = null;
        GetCodeRequest  = GetCodeRequest.replace("APPID", urlEnodeUTF8("wxc419a6155fcf608b"));
        GetCodeRequest  = GetCodeRequest.replace("REDIRECT_URI",urlEnodeUTF8("http://wx.xsh1314.com/pay/oauth.html"));
        GetCodeRequest = GetCodeRequest.replace("SCOPE", "snsapi_userinfo");
        result = GetCodeRequest;
        return result;
    }
    public static String urlEnodeUTF8(String str){
        String result = str;
        try {
            result = URLEncoder.encode(str,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getCodeRequest());
    }
}
