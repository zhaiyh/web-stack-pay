package com.puiui.plugin.tenpay;

import java.util.SortedMap;

/**
 * Created by zhaiyinghao on 16/5/5.
 */
public class RSASign implements Sign {

    @Override
    public String sign(SortedMap<String, String> signMap) {
        return rsa();
    }

    private String rsa() {
        return null;
    }
}
