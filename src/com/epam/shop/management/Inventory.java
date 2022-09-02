package com.epam.shop.management;

import java.util.HashMap;

import com.epam.flowers.BigleafMagnolia;
import com.epam.flowers.ClimbingRose;
import com.epam.flowers.Flower;
import com.epam.flowers.GrandifloraRose;
import com.epam.flowers.HybridTeaRose;

public class Inventory {

	/*
	 * Here we are using Map to store the values side by side - the flower and its inventory
	 */
	
	private HashMap<Flower, Integer> inventory = new HashMap<>();
	
	/*
	 * A method to initialize inventory. Here it is not perfect since normally methods like this should not have
	 * hardcoded values, but I left it like this simply to demonstrate, once again, the encapsulation. With one method we can
	 * set the Inventory object to, so to say, default state
	 */
	
	public void initialize() {
		setInventory(new BigleafMagnolia(), 7);
		setInventory(new ClimbingRose(), 5);
		setInventory(new GrandifloraRose(), 10);
		setInventory(new HybridTeaRose(), 15);
		setInventory(new HybridTeaRose(), 10);
		setInventory(new HybridTeaRose(), 25);
	}

	public void addInventory(Flower flower) {
		replace(flower, getInventory(flower) + 1);
	}

	public void reduceInventory(Flower flower) {
		if(this.getInventory(flower) == 0) {
			throw new UnsupportedOperationException("Cannot reduce intentory - inventory is already 0");
		}
		
		replace(flower, getInventory(flower) - 1);
	}

	public void setInventory(Flower flower, int inv) {
		if(inv < 0) {
			throw new UnsupportedOperationException("Cannot set inventory to a negative value");
		}
		
		replace(flower, inv);
	}

	public Flower isPresent(String name) {
		if(name == null) {
			return null;
		}
		
		for (Flower flower : inventory.keySet()) {
			if (flower.getName().equalsIgnoreCase(name)) {
				return flower;
			}
		}
		return null;
	}

	public Integer getInventory(Flower flower) {
		if(inventory.get(flower) == null) {
			return 0;
		}
		
		return inventory.get(flower);
	}
	
	public void printInventory() {
		System.out.print("Our flowers:\n");
		inventory.forEach((flower, inv) -> System.out.println(flower.toString() + "\n" + "In stock: " + inv));
	}

	private Flower isPresent(Flower newFlower) {
		for (Flower oldFlower : inventory.keySet()) {
			if (oldFlower.equals(newFlower)) {
				return oldFlower;
			}
		}
		return null;
	}

	/*
	 * This is a helper method, which is used by other, public methods, in specific context. It's done to avoid the
	 * code duplication
	 */
	
	private void replace(Flower newFlower, int newInv) throws NullPointerException {
		if(newFlower == null) {
			throw new NullPointerException("Flower cannot be null");
		}
		
		Flower oldFlower = isPresent(newFlower);

		if (oldFlower == null) {
			inventory.put(newFlower, newInv);
		} else {
			inventory.replace(oldFlower, newInv);
		}
	}

}
