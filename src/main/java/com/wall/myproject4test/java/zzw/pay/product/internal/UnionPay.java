package com.wall.myproject4test.java.zzw.pay.product.internal;

/**
 * 银联支付
 * @author wall
 */
public class UnionPay implements InternalPay {
    @Override
    public void pay() {
        System.out.println("银联支付！");
    }
}
