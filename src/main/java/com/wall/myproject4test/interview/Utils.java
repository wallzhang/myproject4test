package com.wall.myproject4test.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Utils {

	/**
	 * Question1, sort by firstName , lastName and  ext,
	 * if firstName is the same then sort by lastName and
	 * ext, please note lastName and ext can be empty string or null
	 **/
	public static List<Extension> sortByName(List<Extension> extensions) {
		//  lastName and  ext 有多值为null的情况下会报null异常，自己设计比较器
//		extensions.sort(Comparator.comparing(Extension::getFirstName).thenComparing(Extension::getLastName)
//		.thenComparing(Extension::getExt));
		extensions.sort(new Compare4Question1());
		return extensions;
	}


	/**
	 * Question2, sort extType, extType is a string and can
	 * be "User", "Dept", "AO", "TMO", "Other",
	 * sort by User > Dept > AO > TMO > Other;
	 * There might be new extType value, it will be in last order is it's not in prefined list.
	 **/
	public static List<Extension> sortByExtType(List<Extension> extensions) {
		// 基于自定义比较器排序
		extensions.sort(new Compare4ExtType());
		return extensions;
	}

	/**
	 * Question3, sum all sales items by quarter, sum the amount for the same quarter item.
	 **/
	public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
		// 1,2,3,4分别代表1-4季度
		AtomicReference<Double> amount1 = new AtomicReference<>((double) 0);
		AtomicReference<Double> amount2 = new AtomicReference<>((double) 0);
		AtomicReference<Double> amount3 = new AtomicReference<>((double) 0);
		AtomicReference<Double> amount4 = new AtomicReference<>((double) 0);
		// 基于月份算出各季度总和
		saleItems.stream().forEach(saleItem -> {
			if(saleItem.getMonth()<3){
				amount1.updateAndGet(v -> new Double((double) (v + saleItem.getAmount())));
			}else if(saleItem.getMonth()<6){
				amount2.updateAndGet(v -> new Double((double) (v + saleItem.getAmount())));
			}else if(saleItem.getMonth()<9){
				amount3.updateAndGet(v -> new Double((double) (v + saleItem.getAmount())));
			}else if(saleItem.getMonth()<12){
				amount4.updateAndGet(v -> new Double((double) (v + saleItem.getAmount())));
			}
		});
		QuarterSalesItem amount4Spring = new QuarterSalesItem(1,amount1.get());
		QuarterSalesItem amount4Summer = new QuarterSalesItem(2,amount2.get());
		QuarterSalesItem amount4Fall = new QuarterSalesItem(3,amount3.get());
		QuarterSalesItem amount4Winter = new QuarterSalesItem(4,amount4.get());
		List<QuarterSalesItem> res = new ArrayList<>();
		res.add(amount4Spring);
		res.add(amount4Summer);
		res.add(amount4Fall);
		res.add(amount4Winter);
		return res;
	}

	/**
	 * Question4, max all sales items by quarter, get the max amount from the item belongs to the same quarter
	 *
	 **/
	public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
		double amount4spring = 0;
		double amount4summer = 0;
		double amount4fall = 0;
		double amount4winner = 0;
		for (int i = 0; i < saleItems.size(); i++) {
			SaleItem saleItem = saleItems.get(i);
			if(saleItem.getMonth()<3){
				amount4spring = getMaxAmount(amount4spring,saleItem.getAmount());
			}else if(saleItem.getMonth()<6){
				amount4summer = getMaxAmount(amount4summer,saleItem.getAmount());
			}else if(saleItem.getMonth()<9){
				amount4fall = getMaxAmount(amount4fall,saleItem.getAmount());
			}else if(saleItem.getMonth()<12){
				amount4winner = getMaxAmount(amount4winner,saleItem.getAmount());
			}
		}
		QuarterSalesItem amount4Spring = new QuarterSalesItem(1,amount4spring);
		QuarterSalesItem amount4Summer = new QuarterSalesItem(2,amount4summer);
		QuarterSalesItem amount4Fall = new QuarterSalesItem(3,amount4fall);
		QuarterSalesItem amount4Winter = new QuarterSalesItem(4,amount4winner);
		List<QuarterSalesItem> res = new ArrayList<>();
		res.add(amount4Spring);
		res.add(amount4Summer);
		res.add(amount4Fall);
		res.add(amount4Winter);
		return res;
	}
    
	//Question5
	/**
	 * We have all Keys like 0-10000 with random order, it can be other keys in real cases;
	 * usedKeys is an array to store all used keys like :[2,3,4] with random order;
	 * We want to get all unused keys, in this example it would be: [0,1,5,6,7,8,9,....]
	 */
	
	public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
		int[] unusedKeys = new int[allKeys.length-usedKeys.length];
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (int num1:allKeys) {
			set1.add(num1);
		}
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (int num2:usedKeys){
			set2.add(num2);
		}
		set1.removeAll(set2);
		int index =0;
		for (int num:set1) {
			unusedKeys[index] = num;
			index++;
		}
		return unusedKeys;
	}

	/**
	 * getMax
	 */
	private static double getMaxAmount(Double d1,Double d2){
		return d1>d2? d1:d2;
	}
}
