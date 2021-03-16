package com.wall.myproject4test.java.zzw.pay.factory;


import com.wall.myproject4test.java.zzw.pay.product.abroad.AbroadPay;

/**
 * 境外支付工厂
 * @author wall
 */
public class AbroadFactory extends PayAbstractFactory {

    public AbroadPay getAbroadPayByClazz(Class<? extends AbroadPay> clazz) throws Exception {
        super.init();
        return clazz.getDeclaredConstructor().newInstance();
    }
}

