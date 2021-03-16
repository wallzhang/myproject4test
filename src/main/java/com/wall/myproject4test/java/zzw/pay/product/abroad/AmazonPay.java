package com.wall.myproject4test.java.zzw.pay.product.abroad;

/**
 * 亚马逊支付
 * @author wall
 */
public class AmazonPay implements AbroadPay {
    @Override
    public void pay() {
        System.out.println("Amazon Pay!!");
    }
}
