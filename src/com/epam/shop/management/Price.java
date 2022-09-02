package com.epam.shop.management;

import java.util.Comparator;

/*
 * Here we are providing price as a separate class, with intention that it might be extended with other methods or fields. 
 * It is also kept separately since this particular class does not depend on flowers only, 
 * and might be used for other purposes, theoretically
 */

public class Price {

	private double price;
	
	public Price(double price) {
		if(price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");
		}
		
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "$" + price;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");
		}
		
		this.price = price;
	}
	
}
