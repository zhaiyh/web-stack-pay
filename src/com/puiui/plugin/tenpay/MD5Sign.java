package com.puiui.plugin.tenpay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by zhaiyinghao on 16/5/5.
 */
public class MD5Sign implements Sign {
    @Override
    public String sign(SortedMap<String, String> signMap) {
        StringBuilder signContent = new StringBuilder();
        for (Map.Entry<String, String> entry : signMap.entrySet()) {
            String tagName = entry.getKey();
            String tagValue = entry.getValue();
            signContent.append(tagName).append("=").append(tagValue).append("&");
        }
        signContent.append("key=").append(TenpayConfig.getPartnerKey());
        return md5(signContent.toString().getBytes(), "UTF-8");
    }

    private String md5(byte[] bs, String charsetName) {
        return null;
    }
}
