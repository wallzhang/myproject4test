package com.wall.myproject4test.interview;


public class SaleItem {
	private int month;
	private String transactionId;
	private double amount;
	
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public SaleItem(int month, String transactionId, double amount) {
		this.month = month;
		this.transactionId = transactionId;
		this.amount = amount;
	}

	public SaleItem(){
	}

	@Override
	public String toString() {
		return "SaleItem{" +
				"month=" + month +
				", transactionId='" + transactionId + '\'' +
				", amount=" + amount +
				'}';
	}
}
