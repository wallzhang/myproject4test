package com.wall.myproject4test.java.zzw.pay.test.payenum;

import com.wall.myproject4test.java.zzw.pay.product.abroad.AbroadPay;
import com.wall.myproject4test.java.zzw.pay.product.abroad.AmazonPay;
import com.wall.myproject4test.java.zzw.pay.product.abroad.ApplePay;

/**
 * 境外支付枚举类
 * @author wall
 */

public enum AbroadPayEnum {

    APPLE_PAY(ApplePay.class),
    AMAZON_PAY(AmazonPay.class);

    private Class clazz;
    private AbroadPayEnum(Class<? extends AbroadPay> clazz){
        this.clazz = clazz;
    }

    public Class getClazz(){
        return clazz;
    }
}
