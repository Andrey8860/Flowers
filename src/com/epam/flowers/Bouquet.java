package com.epam.flowers;

import java.util.ArrayList;

import com.epam.exceptions.ItemOnlySoldSeparatelyException;
import com.epam.exceptions.ItemOutOfStockException;
import com.epam.shop.management.Inventory;
import com.epam.shop.management.Price;

public class Bouquet {
	
	// Here we are using a simple ArrayList, since we need to allow duplicates
	private ArrayList<Flower> bouquet = new ArrayList<>();
	
	
	/*
	 * Here we are throwing two user-created exceptions, one checked and one unchecked if the item cannot be added 
	 * to the bouquet. We are also reducing inventory of the item we add to the bouquet, until later it's 
	 * either bought or removed. We do this to ensure that user cannot add more than actually available in stock
	 */
	public boolean add(Inventory inv, Flower flower) throws ItemOnlySoldSeparatelyException, ItemOutOfStockException {
		if(inv.getInventory(flower) <= 0) {
			throw new ItemOutOfStockException(flower.getName() + " is out of stock");
		} else if(Flower.isBouquetable(flower)) {
			inv.reduceInventory(flower);
			return bouquet.add(flower);
		}
		else {
			throw new ItemOnlySoldSeparatelyException(flower.getName() + " cannot be added to the bouquet, as it's only sold separately");
		}
	}
	
	public boolean remove(Inventory inv, Flower flower) {
		inv.addInventory(flower);
		return bouquet.remove(flower);
	}
	
	/*
	 * An example of sorting, here simply by price
	 */
	
	public void sortByPrice() {
		bouquet.sort((Flower f1, Flower f2) -> (int) (f1.getPrice().getPrice() - f2.getPrice().getPrice()));
	}
	
	/*
	 * An example of dealing with an IndexOutOfBoundsException. Method itself is not really useful in scope of this program
	 */
	
	public Flower getAt(int index) {
		try {
			return bouquet.get(index);
		} catch(IndexOutOfBoundsException ex) {
			System.out.println("No element at this index");
			return null;
		}
	}
	
	/*
	 * An example of dealing with NaN, and also wrapping it up into an exception, rather than passing a value back
	 */
	
	public double getAveragePrice() throws ArithmeticException {
		Double averagePrice = sum() / bouquet.size();
		if(averagePrice.isNaN()) {
			throw new ArithmeticException("Cannot find an average price of an empty bouquet");
		} else {
			return averagePrice;
		}
	}
	
	@Override
	public String toString() {
		if(bouquet.size() == 0) {
			return "Your bouquet is empty";
		}
		
		String allItems = "";
		for(Flower flower : bouquet) {
			allItems += flower.toString() + "\n";
		}
		allItems += "The total is: " + new Price(sum()).toString();
		return allItems;
	}
	
	public ArrayList<Flower> getBouquet() {
		return bouquet;
	}
	
	// Here we are hiding the sum() method, since we do not expect it to be used directly. This can be changed if needed
	private double sum() {
		double sum = 0;
		for(Flower flower : bouquet) {
			sum += flower.price.getPrice();
		}
		return sum;
	}
}
