package com.n26.transaction.model;

public class Statistics {

	private double sum;
	
    private double average;
    
    private double max_amount;
    
    private double min_amount;
    
    private int count;
    
    
	/**
	 * @param sum
	 * @param average
	 * @param max_amount
	 * @param min_amount
	 * @param count
	 */
	public Statistics(double sum, double average, double max_amount, double min_amount, int count) {
		super();
		this.sum = sum;
		this.average = average;
		this.max_amount = max_amount;
		this.min_amount = min_amount;
		this.count = count;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getMax_amount() {
		return max_amount;
	}

	public void setMax_amount(double max_amount) {
		this.max_amount = max_amount;
	}

	public double getMin_amount() {
		return min_amount;
	}

	public void setMin_amount(double min_amount) {
		this.min_amount = min_amount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
    
}
