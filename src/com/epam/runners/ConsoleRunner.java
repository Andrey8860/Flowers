package com.epam.runners;

import com.epam.shop.management.Shop;

/*
 * This is a runner which will launch the user interface through the console
 */

public class ConsoleRunner {

	public static void main(String[] args) {
		Shop shop = new Shop();
		shop.open();
	}

}
