package com.wall.myproject4test.java.zzw.inf4demo.array;

import org.apache.commons.collections.MapUtils;

import javax.jws.soap.SOAPBinding;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayListDemo {
    transient Object[] elementData;
//    String Object[] A;
    private int size;
    private String Dimension = "3423";
    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        TreeSet set = new TreeSet();
//        TreeMap map = new TreeMap();
//        map.put("a","b");
//
//        HashMap map2 = new HashMap();
//        map2.put("a","e");
//        ArrayList list = new ArrayList();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        System.out.println("size:" + new ArrayListDemo().size);
        double f = 111231.5585;

        System.out.println(String.format("%.2f", f));
    }


    /**
     * 特别全省数据特别定制短信
     * @param staffTelephones
     */
    private void provinceInsertNote(List<Map<String, Object>> gzInstallRateList, List<Map<String, Object>> zqInstallRateList,
                                    List<Map<String, Object>> gzRepairRateList, List<Map<String, Object>> zqRepairRateList,
                                    List<Map<String, Object>> installReserveRateList, List<Map<String, Object>> repairReserveRateList,
                                    List<Map<String, Object>> broadbandOrderTimeList, List<Map<String, Object>> broadbandFaultTimeList,
                                    List<Map<String, Object>> broadbandFaultRepeatRateList, List<Map<String, Object>> broadbandInstallPerformanceRateList,
                                    String dateFormat, String[] staffTelephones) {
        String noteTemplate = "全省{arg1}装维情况：公众当日装成功率{arg2}，政企当日装成功率{arg3}；" +
                "公众当日修成功率{arg4}，政企当日修成功率{arg5}；装移响应预约率{arg6}，维修工单响应预约率{arg7}；" +
                "宽带工单平均历时{arg8}小时,宽带故障平均历时{arg9}小时,宽带故障重复率{arg10}，宽带装移服务履约率{arg11}。";
        // todo 记得把全省数据去了
        // 公众当日装成功率 计算公式(num_2+num_3)/num_1
        AtomicInteger gzInstallNum1 = new AtomicInteger();
        AtomicInteger gzInstallNum2 = new AtomicInteger();
        AtomicInteger gzInstallNum3 = new AtomicInteger();
        gzInstallRateList.forEach(item->{
            if(!Dimension.equals(MapUtils.getString(item,"统计维度"))){
                gzInstallNum1.addAndGet(MapUtils.getIntValue(item, "num_1", 0));
                gzInstallNum2.addAndGet(MapUtils.getIntValue(item, "num_2", 0));
                gzInstallNum3.addAndGet(MapUtils.getIntValue(item, "num_3", 0));
            }
        });
        String gzInstallRes = String.format("%.2f", (gzInstallNum2.intValue()+gzInstallNum3.intValue())/gzInstallNum1.intValue())+"%";
        // 政企当日装成功率 计算公式(num_2+num_3)/num_1
        AtomicInteger zqInstallNum1 = new AtomicInteger();
        AtomicInteger zqInstallNum2 = new AtomicInteger();
        AtomicInteger zqInstallNum3 = new AtomicInteger();
        zqInstallRateList.forEach(item->{
            if(!Dimension.equals(MapUtils.getString(item,"统计维度"))){
                zqInstallNum1.addAndGet(MapUtils.getIntValue(item, "num_1", 0));
                zqInstallNum2.addAndGet(MapUtils.getIntValue(item, "num_2", 0));
                zqInstallNum3.addAndGet(MapUtils.getIntValue(item, "num_3", 0));
            }
        });
        String zqInstallRes = String.format("%.2f", (zqInstallNum2.intValue()+zqInstallNum3.intValue())/zqInstallNum1.intValue())+"%";
        // 公众当日修成功率 计算公式(num_2+num_3)/num_1
        AtomicInteger gzRepairNum1 = new AtomicInteger();
        AtomicInteger gzRepairNum2 = new AtomicInteger();
        AtomicInteger gzRepairNum3 = new AtomicInteger();
        gzRepairRateList.forEach(item->{
            if(!Dimension.equals(MapUtils.getString(item,"统计维度"))){
                gzRepairNum1.addAndGet(MapUtils.getIntValue(item, "num_1", 0));
                gzRepairNum2.addAndGet(MapUtils.getIntValue(item, "num_2", 0));
                gzRepairNum3.addAndGet(MapUtils.getIntValue(item, "num_3", 0));
            }
        });
        String gzRepairRes = String.format("%.2f", (gzRepairNum2.intValue()+gzRepairNum3.intValue())/gzRepairNum1.intValue())+"%";
        // 政企当日修成功率 计算公式(num_2+num_3)/num_1
        AtomicInteger zqRepairNum1 = new AtomicInteger();
        AtomicInteger zqRepairNum2 = new AtomicInteger();
        AtomicInteger zqRepairNum3 = new AtomicInteger();
        zqRepairRateList.forEach(item->{
            if(!Dimension.equals(MapUtils.getString(item,"统计维度"))){
                zqRepairNum1.addAndGet(MapUtils.getIntValue(item, "num_1", 0));
                zqRepairNum2.addAndGet(MapUtils.getIntValue(item, "num_2", 0));
                zqRepairNum3.addAndGet(MapUtils.getIntValue(item, "num_3", 0));
            }
        });
        String zqRepairRes = String.format("%.2f", (zqRepairNum2.intValue()+zqRepairNum3.intValue())/zqRepairNum1.intValue())+"%";
        // 装移响应预约率 计算公式(num_4+num_3)/num_1
        AtomicInteger installReserveNum1 = new AtomicInteger();
        AtomicInteger installReserveNum3 = new AtomicInteger();
        AtomicInteger installReserveNum4 = new AtomicInteger();
        installReserveRateList.forEach(item->{
            if(!Dimension.equals(MapUtils.getString(item,"统计维度"))){
                installReserveNum1.addAndGet(MapUtils.getIntValue(item, "num_1", 0));
                installReserveNum3.addAndGet(MapUtils.getIntValue(item, "num_3", 0));
                installReserveNum4.addAndGet(MapUtils.getIntValue(item, "num_4", 0));
            }
        });
        String installReserveRes = String.format("%.2f", (installReserveNum3.intValue()+installReserveNum4.intValue())/installReserveNum1.intValue())+"%";
        // 维修工单响应预约率 计算公式num_12/num_3
        AtomicInteger repairReserveNum3 = new AtomicInteger();
        AtomicInteger repairReserveNum12 = new AtomicInteger();
        repairReserveRateList.forEach(item->{
            if(!Dimension.equals(MapUtils.getString(item,"统计维度"))){
                repairReserveNum3.addAndGet(MapUtils.getIntValue(item, "num_3", 0));
                repairReserveNum12.addAndGet(MapUtils.getIntValue(item, "num_12", 0));
            }
        });
        String repairReserveRes = String.format("%.2f", repairReserveNum12.intValue()/repairReserveNum3.intValue())+"%";
        // 宽带工单平均历时 计算公式 num_2/num_1
        AtomicInteger broadbandOrderNum1 = new AtomicInteger();
        AtomicInteger broadbandOrderNum2 = new AtomicInteger();
        broadbandOrderTimeList.forEach(item->{
            if(!Dimension.equals(MapUtils.getString(item,"统计维度"))){
                broadbandOrderNum1.addAndGet(MapUtils.getIntValue(item, "num_1", 0));
                broadbandOrderNum2.addAndGet(MapUtils.getIntValue(item, "num_2", 0));
            }
        });
        String broadbandOrderRes = String.format("%.2f", broadbandOrderNum2.intValue()/broadbandOrderNum1.intValue());
        // 宽带故障平均历时 计算公式 num_8 / num_2+num_3
        AtomicInteger broadbandFaultNum2 = new AtomicInteger();
        AtomicInteger broadbandFaultNum3 = new AtomicInteger();
        AtomicInteger broadbandFaultNum8 = new AtomicInteger();
        broadbandFaultTimeList.forEach(item->{
            if(!Dimension.equals(MapUtils.getString(item,"统计维度"))){
                broadbandFaultNum2.addAndGet(MapUtils.getIntValue(item, "num_2", 0));
                broadbandFaultNum3.addAndGet(MapUtils.getIntValue(item, "num_3", 0));
                broadbandFaultNum8.addAndGet(MapUtils.getIntValue(item, "num_8", 0));
            }
        });
        String broadbandFaultRes = String.format("%.2f",broadbandFaultNum8.intValue() /(broadbandFaultNum2.intValue()+broadbandFaultNum3.intValue()));
        // 宽带故障重复率 计算公式 num_3/num_2
        AtomicInteger broadbandFaultRepeatNum2 = new AtomicInteger();
        AtomicInteger broadbandFaultRepeatNum3 = new AtomicInteger();
        gzRepairRateList.forEach(item->{
            if(!Dimension.equals(MapUtils.getString(item,"统计维度"))){
                broadbandFaultRepeatNum2.addAndGet(MapUtils.getIntValue(item, "num_2", 0));
                broadbandFaultRepeatNum3.addAndGet(MapUtils.getIntValue(item, "num_3", 0));
            }
        });
        String broadbandFaultRepeatRes = String.format("%.2f", broadbandFaultRepeatNum3.intValue()/broadbandFaultRepeatNum2.intValue())+"%";
        // 宽带装移服务履约率 计算公式 num_2/num_1
        AtomicInteger broadbandInstallPerformanceNum1 = new AtomicInteger();
        AtomicInteger broadbandInstallPerformanceNum2 = new AtomicInteger();
        gzRepairRateList.forEach(item->{
            if(!Dimension.equals(MapUtils.getString(item,"统计维度"))){
                broadbandInstallPerformanceNum1.addAndGet(MapUtils.getIntValue(item, "num_1", 0));
                broadbandInstallPerformanceNum2.addAndGet(MapUtils.getIntValue(item, "num_2", 0));
            }
        });
        String broadbandInstallPerformanceRes = String.format("%.2f", broadbandInstallPerformanceNum2.intValue()/broadbandInstallPerformanceNum1.intValue())+"%";

        String resNote = noteTemplate.replace("{arg1}",dateFormat)
                .replace("{arg2}",gzInstallRes).replace("{arg3}",zqInstallRes)
                .replace("{arg4}",gzRepairRes).replace("{arg5}",zqRepairRes)
                .replace("{arg6}",installReserveRes).replace("{arg7}",repairReserveRes)
                .replace("{arg8}",broadbandOrderRes).replace("{arg9}",broadbandFaultRes)
                .replace("{arg10}",broadbandFaultRepeatRes).replace("{arg11}",broadbandInstallPerformanceRes);
//        getTaskSchedulerDao().batchInsertInstallNote(resNote,staffTelephones);
    }
}
