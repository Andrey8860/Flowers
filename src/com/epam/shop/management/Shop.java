package com.epam.shop.management;

import com.epam.constants.ConsoleOutput;
import com.epam.exceptions.ItemOutOfStockException;
import com.epam.flowers.Bouquet;
import com.epam.flowers.Flower;

/*
 * This is a separate class related to actual shop actions. It is kep separately, since Shop itself is not related to Flowers
 * directly, and can be later extended to perform other actions, like marketing or promos, or work with other types of
 * objects
 */
public class Shop {

	private Inventory inv;
	
	public Shop() {
		
	}
	
	public Shop(Inventory inv) {
		this.inv = inv;
	}
	
	/*
	 * Here we initialize the inventory and start the Input Processor which would
	 * handle user interaction. This is an example of encapsulation, since to use
	 * all the features of the shop we would only need to call this one method. By
	 * creating a chain, classes interact with each other, but user would not need
	 * to worry about this, as only using the open() method is enough to start and
	 * finish.
	 */
	public void open() {
			inv = new Inventory();
			inv.initialize();
			InputProcessor.start(inv, this);
	}
	
	/*
	 * Here we provide a possibility to use a custom, different inventory. If a null value is passed here - then we will
	 * just open a shop with a default inventory, instead of stopping the program
	 */
	
	public void open(Inventory customInventory) {
		try {
			inv = customInventory;
			inv.initialize();
			InputProcessor.start(inv, this);
		} catch (NullPointerException ex) {
			open();
		}
	}

	public boolean isInStock(Flower flower) {
		return inv.getInventory(flower) > 0;
	}

	public boolean buy(Flower flower) {
		if (isInStock(flower)) {
			inv.reduceInventory(flower);
			return true;
		} else {
			throw new ItemOutOfStockException(flower.getName() + " is out of stock");
		}
	}

	/*
	 * This is the only place where we are using a constant which was intended for
	 * the InputProcessor. We do this only because the action which we need also
	 * fully complies with the text which we have. This is an example of classes not
	 * directly intended to be used in these circumstances actually being useful.
	 * Note that we also do not change the inventory here, since it's already supposed
	 * to be changed when we add an item to the bouquet
	 */
	public void buy(Bouquet bouquet) {
		bouquet = new Bouquet();
		System.out.println(ConsoleOutput.THANK_YOU);
	}

}
