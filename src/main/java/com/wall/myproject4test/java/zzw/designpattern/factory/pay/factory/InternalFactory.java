package com.wall.myproject4test.java.zzw.designpattern.factory.pay.factory;

import com.wall.myproject4test.java.zzw.designpattern.factory.pay.product.internal.InternalPay;

/**
 * 国内支付工厂
 * @author wall
 */
public class InternalFactory extends PayAbstractFactory {

    public InternalPay getInternalFactory(Class<? extends InternalPay> clazz) throws Exception {
        super.init();
        return clazz.getDeclaredConstructor().newInstance();
    }
}
