package com.puiui.plugin.tenpay;

import java.util.SortedMap;

/**
 * Created by zhaiyinghao on 16/5/5.
 */
public class SignGenarate {
    public static String generate(SortedMap<String, String> signMap) {
        Sign sign = null;
        if (SignType.MD5.getSign().equals(TenpayConfig.getSignType())) {
            sign = getSign("com.puiui.plugin.tenpay.MD5Sign");
        } else if (SignType.RSA.getSign().equals(TenpayConfig.getSignType())) {
            sign = getSign("com.puiui.plugin.tenpay.RSASign");
        } else {
            throw new IllegalStateException("签名配置出错");
        }
        return sign.sign(signMap);
    }

    private static Sign getSign(String defaultSignClass) {
        Sign sign = null;
        try {
            if (TenpayConfig.getSignClass() == null
                    || "".equals(TenpayConfig.getSignClass())) {
                Class<Sign> signClass = (Class<Sign>) Class.forName(defaultSignClass);
                sign = signClass.newInstance();
            } else {
                Class<Sign> signClass = (Class<Sign>) Class.forName(TenpayConfig.getSignClass());
                sign = signClass.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sign;
    }
}
