package com.umbrella.worker.dto;

import java.math.BigDecimal;

public class OrderStatistics {
 
	private String date;
	
	private BigDecimal income;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	
	
}
