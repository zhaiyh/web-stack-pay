package com.puiui.plugin.tenpay;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 微信支付核心类
 */
public class TenpayCore {

    /**
     * 构建请求信息,用户生成签名和请求信息
     * 按照微信支付规定,使用有序的map存放请求信息
     *
     * @param req
     * @return
     */
    private static SortedMap<String, String> buildSignMap(TenpayUnifiedOrderRequest req) {
        SortedMap<String, String> map = new TreeMap<>();
        Class<TenpayUnifiedOrderRequest> clazz = TenpayUnifiedOrderRequest.class;
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                SignIgnore signIgnore = field.getAnnotation(SignIgnore.class);
                if (signIgnore != null) {
                    continue;
                }
                // 查看属性的注解
                Required required = field.getAnnotation(Required.class);
                if (required == null) {
                    // 如果不是必须的,查看是否为空
                    Object obj = getValue(field, req);
                    if (obj != null || !"".equals(obj)) {
                        String tagName = getXmlName(field);
                        map.put(tagName, obj.toString());
                    }
                } else {
                    Object obj = getValue(field, req);
                    if (obj == null || "".equals(obj)) {
                        throw new IllegalArgumentException(field.getName() + "不能为空");
                    } else {
                        String tagName = getXmlName(field);
                        map.put(tagName, obj.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 构建统一下单请求xml
     *
     * @param signMap
     * @return
     */
    private static String buildUnifiedOrderRequestXml(SortedMap<String, String> signMap) {
        StringBuilder reqXml = new StringBuilder();
        reqXml.append("<xml>");
        for (Map.Entry<String, String> entry : signMap.entrySet()) {
            String tagName = entry.getKey();
            String tagValue = entry.getValue();
            reqXml.append("<").append(tagName).append(">")
                    .append(tagValue).append("</")
                    .append(tagName).append(">");
        }
        reqXml.append("<sign>").append(SignGenarate.generate(signMap)).append("</sign></xml");
        return reqXml.toString();
    }


    /**
     * 获取对象中指定属性的值
     *
     * @param field
     * @param obj
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static Object getValue(Field field, Object obj)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String fieldName = field.getName();
        String methodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        Class<?> clazz = obj.getClass();
        Method method = clazz.getMethod(methodName);
        return method.invoke(obj);
    }

    /**
     * 获取属性对应的xml标签名称
     *
     * @param field
     * @return
     */
    private static String getXmlName(Field field) {
        XmlMap xmlMap = field.getAnnotation(XmlMap.class);
        if (xmlMap == null) {
            StringBuilder tagName = new StringBuilder();
            String name = field.getName();
            for (int i = 0; i < name.length(); i++) {
                char ch = name.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    tagName.append("_").append(Character.toLowerCase(ch));
                } else {
                    tagName.append(ch);
                }
            }
            return tagName.toString();
        } else {
            return xmlMap.value();
        }
    }

    /**
     * 发起微信统一下单请求
     *
     * @param content
     * @return
     */
    private static String sendUnifiedOrderRequest(String content) {
        String respContent = null;
        try {
            URL url = new URL(TenpayConfig.getUnifiedOrderUrl());
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Content-Type", "text/xml");
            conn.getOutputStream().write(content.getBytes());
            // TODO 获取响应的信息

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respContent;
    }

    /**
     * 解析微信统一下单相应信息
     *
     * @param respContent
     * @return
     */
    private static TenpayUnifiedOrderResponse parseUnifiedOrderResponse(String respContent) {
        TenpayUnifiedOrderResponse response = null;
        if (respContent == null || "".equals(respContent)) {
            throw new IllegalStateException("微信支付统一下单响应信息不合法");
        } else {
            // TODO 解析响应内容
        }
        return response;
    }

    public static TenpayUnifiedOrderResponse getUnifiedOrderResponse(TenpayUnifiedOrderRequest request) {
        return parseUnifiedOrderResponse(
                sendUnifiedOrderRequest(
                        buildUnifiedOrderRequestXml(
                                buildSignMap(request))));
    }

}
