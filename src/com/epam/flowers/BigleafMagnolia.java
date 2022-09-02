package com.epam.flowers;

import com.epam.constants.Color;
import com.epam.constants.Size;
import com.epam.exceptions.IncorrectFlowerAttributeException;
import com.epam.interfaces.Bouquetable;
import com.epam.shop.management.Price;

public class BigleafMagnolia extends Flower implements Bouquetable {
	
	/*
	 * In this example we are storing the numberOfLeaves, a value which is specific to Magnolia.
	 * This is also an example of polymorphism, as we are directly extending from Flower, unlike Roses,
	 * which had another class on top of it
	 */
	
	private int numberOfLeaves;
	
	public BigleafMagnolia() {
		try {
			this.setName("Bigleaf Magnolia");
			this.setColor(Color.GREEN);
			this.setSize(Size.SMALL);
		} catch (IncorrectFlowerAttributeException ex) {
			System.out.println(ex.getMessage());
		}
		this.price = new Price(10);
		this.numberOfLeaves = 5;
	}
	
	@Override
	public String toString() {
		return "Name: " + getName() + "; Color: " + getColor() + "; Size: " + 
				getSize() + "; Number of leaves: " + numberOfLeaves + "; Price: " + price.toString();
	}
	
}
