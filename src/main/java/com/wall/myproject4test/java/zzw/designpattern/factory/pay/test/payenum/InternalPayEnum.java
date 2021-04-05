package com.wall.myproject4test.java.zzw.designpattern.factory.pay.test.payenum;

import com.wall.myproject4test.java.zzw.designpattern.factory.pay.product.internal.AliPay;
import com.wall.myproject4test.java.zzw.designpattern.factory.pay.product.internal.InternalPay;
import com.wall.myproject4test.java.zzw.designpattern.factory.pay.product.internal.UnionPay;
import com.wall.myproject4test.java.zzw.designpattern.factory.pay.product.internal.WxPay;

/**
 * 国内支付枚举类
 * @author wall
 */

public enum InternalPayEnum {

    ALI_PAY(AliPay.class),
    WX_PAY(WxPay.class),
    UNION_PAY(UnionPay.class);

    private Class clazz;
    private InternalPayEnum(Class<? extends InternalPay> clazz){
        this.clazz = clazz;
    }

    public Class getClazz(){
        return clazz;
    }
}
