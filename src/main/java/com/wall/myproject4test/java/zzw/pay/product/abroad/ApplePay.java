package com.wall.myproject4test.java.zzw.pay.product.abroad;

/**
 * 苹果支付
 * @author wall
 */
public class ApplePay implements AbroadPay {
    @Override
    public void pay() {
        System.out.println("Apple Pay!");
    }
}
