package com.puiui.plugin.tenpay;

/**
 * Created by zhaiyinghao on 16/5/5.
 */
public enum SignType {
    MD5("MD5"), RSA("RSA");

    SignType(String sign) {
        this.sign = sign;
    }

    private String sign;

    public String getSign() {
        return sign;
    }

}
