package com.wall.myproject4test.java.zzw.pay.product.internal;

/**
 * 微信支付
 * @author wall
 */
public class WxPay implements InternalPay {
    @Override
    public void pay() {
        System.out.println("微信支付！");
    }
}
