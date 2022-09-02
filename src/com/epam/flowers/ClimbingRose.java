package com.epam.flowers;

import com.epam.constants.Color;
import com.epam.constants.Size;
import com.epam.exceptions.IncorrectFlowerAttributeException;
import com.epam.shop.management.Price;

public class ClimbingRose extends Rose {
	
	/*
	 * The only purpose of this rose is to later be used in a check of whether it can or cannot be added to the bouquet.
	 * In scope of this exercise there is only one such object, but logically there could be many more, 
	 * including seeds or live flowers. This is why this class is the only one which does not implement the Bouquetable interface
	 */
	
	public ClimbingRose() {
		try {
			this.setName("Climbing Rose");
			this.setColor(Color.YELLOW);
			this.setSize(Size.LARGE);
			this.setHeightCM(100);
		} catch (IncorrectFlowerAttributeException ex) {
			System.out.println(ex.getMessage());
		}
		this.price = new Price(99.99);
	}
	
	
}
