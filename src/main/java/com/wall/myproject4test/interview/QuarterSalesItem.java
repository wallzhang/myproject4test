package com.wall.myproject4test.interview;

public class QuarterSalesItem {
	private int quarter;
	private double amount;

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public QuarterSalesItem(int quarter, double amount) {
		this.quarter = quarter;
		this.amount = amount;
	}

	public QuarterSalesItem(){

	}

	@Override
	public String toString() {
		return "QuarterSalesItem{" +
				"quarter=" + quarter +
				", amount=" + amount +
				'}';
	}
}
