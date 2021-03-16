package com.wall.myproject4test.java.zzw.pay.product.internal;

/**
 * 支付宝支付
 * @author wall
 */
public class AliPay implements InternalPay {
    @Override
    public void pay() {
        System.out.println("Ali Pay!");
    }
}
