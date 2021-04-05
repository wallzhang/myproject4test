package com.wall.myproject4test.java.zzw.designpattern.factory.pay.test;


import com.wall.myproject4test.java.zzw.designpattern.factory.pay.factory.AbroadFactory;
import com.wall.myproject4test.java.zzw.designpattern.factory.pay.factory.InternalFactory;
import com.wall.myproject4test.java.zzw.designpattern.factory.pay.test.payenum.AbroadPayEnum;
import com.wall.myproject4test.java.zzw.designpattern.factory.pay.test.payenum.InternalPayEnum;

/**
 * 测试类
 * @author wall
 */
public class PayFactoryTest {
    public static void main(String[] args) throws Exception {

        // 国内抽象工厂
        InternalFactory internalFactory = new InternalFactory();
        internalFactory.getInternalFactory(InternalPayEnum.ALI_PAY.getClazz()).pay();
        internalFactory.getInternalFactory(InternalPayEnum.WX_PAY.getClazz()).pay();
        internalFactory.getInternalFactory(InternalPayEnum.UNION_PAY.getClazz()).pay();

        // 国外抽象工厂
        AbroadFactory abroadFactory = new AbroadFactory();
        abroadFactory.getAbroadPayByClazz(AbroadPayEnum.APPLE_PAY.getClazz()).pay();
        abroadFactory.getAbroadPayByClazz(AbroadPayEnum.AMAZON_PAY.getClazz()).pay();
    }
}
