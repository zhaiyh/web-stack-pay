package com.puiui.plugin.tenpay;

/**
 * Created by zhaiyinghao on 16/4/30.
 */
public class TenpayCore {

    // 1.拼接统一下单需要签名的参数的xml
    public static <T> void createUnifiedOrderRequestXml(T req) {
        StringBuilder signXml = new StringBuilder();
        Class<T> clazz = (Class<T>) req.getClass();
    }
    // 2.对统一下单拼接的xml进行签名
    // 3.生成统一下单的请求的xml
    // 4.发起统一下单请求
    // 5.解析请求结果
    // 6.转换请求结果

}
