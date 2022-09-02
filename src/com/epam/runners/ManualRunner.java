package com.epam.runners;

import java.util.Arrays;

import com.epam.constants.Color;
import com.epam.constants.Size;
import com.epam.exceptions.IncorrectFlowerAttributeException;
import com.epam.exceptions.ItemOnlySoldSeparatelyException;
import com.epam.exceptions.ItemOutOfStockException;
import com.epam.flowers.*;
import com.epam.shop.management.Inventory;
import com.epam.shop.management.Shop;

/*
 * This is the manual runner. It also triggers a few exceptions.
 * Overall, the program has five built-in exceptions, which are not all triggered here:
 * NullPointerException
 * UnsupportedOperationException
 * ArithmeticException
 * IllegalArgumentException
 * IndexOutOfBoundsException
 */

public class ManualRunner {

	public static void main(String[] args) {

		Flower magnolia = new BigleafMagnolia();
		Flower climbingRose = new ClimbingRose();
		Flower grandRose = new GrandifloraRose();
		Flower hybridRose = new HybridTeaRose();
		Flower customHybridRose = new HybridTeaRose();
		Flower secondCustomHybridRose = new HybridTeaRose();

		try {
			customHybridRose = new HybridTeaRose("custom rose", Color.GREEN, Size.XSMALL, 50, 20);
			secondCustomHybridRose = new HybridTeaRose("custom rose 2", Color.BLUE, Size.XSMALL, 50, 20);
		} catch (IncorrectFlowerAttributeException ex) {
			System.out.println(ex.getMessage());
		}

		Inventory inventory = new Inventory();

		inventory.addInventory(magnolia);
		inventory.addInventory(climbingRose);
		inventory.setInventory(grandRose, 10);
		inventory.reduceInventory(grandRose);
		inventory.setInventory(hybridRose, 2);
		inventory.setInventory(customHybridRose, 5);

		System.out.println("The inventory of the first custom rose: " + inventory.getInventory(customHybridRose));
		inventory.printInventory();

		Shop shop = new Shop(inventory);

		System.out.println("Is grand rose in stock: " + shop.isInStock(grandRose));
		shop.buy(customHybridRose);

		System.out.println("----------------------------------------");


		Bouquet bouquet = new Bouquet();
		try {
			bouquet.add(inventory, grandRose);
			bouquet.add(inventory, grandRose);
			bouquet.add(inventory, magnolia);
			bouquet.add(inventory, secondCustomHybridRose);
			bouquet.remove(inventory, magnolia);
		} catch (ItemOutOfStockException ex) {
			System.out.println(ex.getMessage());
		} catch (ItemOnlySoldSeparatelyException ex) {
			System.out.println(ex.getMessage());
		}
		
		// triggering three exceptions in a row and also triggering an arithmetic exception
		bouquet.getAt(20);
		
		try {
			inventory.reduceInventory(secondCustomHybridRose);
		} catch (UnsupportedOperationException ex) {
			System.out.println(ex.getMessage());
		}
		
		try {
			inventory.setInventory(secondCustomHybridRose, -2);
		} catch (UnsupportedOperationException ex) {
			System.out.println(ex.getMessage());
		}
		
		try {
			System.out.println(new Bouquet().getAveragePrice());
		} catch (ArithmeticException ex) {
			System.out.println(ex.getMessage());
		}

		System.out.println("Bouquet before sorting:\n" + bouquet.toString());
		bouquet.sortByPrice();
		System.out.println("Bouquet after sorting:\n" + bouquet.toString());
		shop.buy(bouquet);
		
		System.out.println("----------------------------------------");
		
		inventory.printInventory();
	}

}
