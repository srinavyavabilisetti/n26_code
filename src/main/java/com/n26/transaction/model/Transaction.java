package com.n26.transaction.model;

public class Transaction {
	
	private double amount;
	private long timestamp;

	/**
	 * @param amount
	 * @param timestamp
	 */
	public Transaction(double amount, long timestamp) {
		super();
		this.amount = amount;
		this.timestamp = timestamp;
	}

	/**
	 * default constructor
	 */
	public Transaction() {

	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}

