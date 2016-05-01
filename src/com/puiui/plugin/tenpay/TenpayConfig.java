package com.puiui.plugin.tenpay;

/**
 * 微信支付基本配置信息
 */
public class TenpayConfig {
    public static final String unifiedOrderUrl;
    public static final String partnerId;
    public static final String partnerKey;
    public static final String appId;

    static {
        unifiedOrderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        partnerId = "1325130401";
        partnerKey = "s2e830mr2bx1ji6mkjarvfb85ugjkcd3";
        appId = "wx5b78b4bb4df71725";
    }
}
