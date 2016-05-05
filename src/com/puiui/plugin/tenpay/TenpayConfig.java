package com.puiui.plugin.tenpay;

import java.io.IOException;
import java.util.Properties;

/**
 * 微信支付基本配置信息
 */
public class TenpayConfig {
    private static String unifiedOrderUrl;
    private static String partnerId;
    private static String partnerKey;
    private static String appId;
    private static String signType;
    private static String signClass;

    static {
        Properties prop = new Properties();
        try {
            prop.load(TenpayConfig.class.getClassLoader().getResourceAsStream("tenpay.properties"));
            unifiedOrderUrl = prop.getProperty("unified_order_url");
            partnerId = prop.getProperty("partner_id");
            partnerKey = prop.getProperty("partner_key");
            appId = prop.getProperty("app_id");
            signType = prop.getProperty("sign_type");
            signClass = prop.getProperty("sign_class");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUnifiedOrderUrl() {
        return unifiedOrderUrl;
    }

    public static String getPartnerId() {
        return partnerId;
    }

    public static String getPartnerKey() {
        return partnerKey;
    }

    public static String getAppId() {
        return appId;
    }

    public static String getSignType() {
        return signType;
    }

    public static String getSignClass() {
        return signClass;
    }
}
