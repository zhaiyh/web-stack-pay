package com.puiui.plugin.tenpay;

/**
 * 对象映射规则接口,定义微信支付中javabean和xml的映射关系
 */
public interface XmlBeanMapRule {

    String getMapperStr(Class clazz, String propName);

}
