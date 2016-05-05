package com.puiui.plugin.tenpay;

/**
 * 微信支付:统一下单请求信息
 */
public class TenpayUnifiedOrderRequest {
    /** 应用ID */
    @Required
    private String appId;
    /** 商户号 */
    @Required
    @XmlMap("mch_id")
    private String partnerId;
    /** 设备号 */
    private String deviceInfo;
    /** 随机字符串 */
    @Required
    private String nonceStr;
    /** 签名 */
    @SignIgnore
    private String sign;
    /** 商品描述 */
    @Required
    private String body;
    /** 商品详情 */
    private String detail;
    /** 附加数据 */
    private String attach;
    /** 商户订单号 */
    @Required
    private String outTradeNo;
    /** 货币类型 */
    private String feeType;
    /** 总金额 */
    @Required
    private String totalFee;
    /** 终端IP */
    @Required
    private String spbillCreateIp;
    /** 交易起始时间 */
    private String timeStart;
    /** 交易结束时间 */
    private String timeExpire;
    /** 商品标记 */
    private String goodsTag;
    /** 通知地址 */
    @Required
    private String notifyUrl;
    /** 交易类型 */
    @Required
    private String tradeType;
    /** 指定支付方式 */
    private String limitPay;

    public TenpayUnifiedOrderRequest() {
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }
}
