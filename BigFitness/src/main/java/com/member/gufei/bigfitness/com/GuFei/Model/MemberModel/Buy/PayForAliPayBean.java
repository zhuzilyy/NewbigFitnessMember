package com.member.gufei.bigfitness.com.GuFei.Model.MemberModel.Buy;

/**
 * Created by GuFei on 2018/6/22.
 */

public class PayForAliPayBean {

    /**
     * Msg : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2018031502381009&biz_content=%7B%22body%22%3A%22%E8%AE%A2%E5%8D%95%E8%AF%A6%E6%83%85%3Aaaa.+%E8%B4%AD%E4%B9%B0%E5%8D%95%E4%BB%B7%3A15.0.+%E8%B4%AD%E4%B9%B0%E6%95%B0%E9%87%8F%3A15.+%E6%80%BB%E9%87%91%E9%A2%9D%3A225%22%2C%22out_trade_no%22%3A%220420180621103148158%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22seller_id%22%3A%22%22%2C%22subject%22%3A%22%E8%B4%AD%E4%B9%B0%E7%A7%81%E6%95%99%E8%AF%BE%3A%E5%87%8F%E8%84%82%E8%AF%BE%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%22225.00%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fapppay.tunnel.qydev.com%2FappPay%2Falipay%2FasynchronousNotify&sign=flSQx7Ude1ADtW8ZULVu8AoukBSqMNP%2B71HeWAQC47rRrmMkndJ9Ka%2Bj%2FNgfHazcBK1V%2FAfghazyfIKRPjj2gD1lPumelfIX4VdfVJ0FcIdWxP5vBv9uIh0Okw1AtzUWnTeXUIy2wvzqViNJP97uyq8YDE8yLhBQAK4KsxkiuSCpkfPLMWDYSmVTyXTgA%2FTEhRtHkay9q6VBMPdzJLMkVK2Xpz7CwZmUcleXgYp9HB%2F%2Bfp5TB6O3atfA3zzX%2B%2B0bAj3C9cqFpdJg%2FTrPEeaX8AsmCsvVLvuK5JHqMtFZpXyuJhG%2FMqGr4nzA06SKwcUlpUaATXcOU%2B0ogrd8tp2IYA%3D%3D&sign_type=RSA2&timestamp=2018-06-21+10%3A31%3A48&version=1.0
     * Ret : 0
     * OrderId : 0420180621103148158
     */

    private String Msg;
    private int Ret;
    private String OrderId;

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public int getRet() {
        return Ret;
    }

    public void setRet(int Ret) {
        this.Ret = Ret;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }
}
