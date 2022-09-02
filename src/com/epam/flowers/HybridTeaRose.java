package com.epam.flowers;

import com.epam.constants.Color;
import com.epam.constants.Size;
import com.epam.exceptions.IncorrectFlowerAttributeException;
import com.epam.interfaces.Bouquetable;
import com.epam.shop.management.Price;

public class HybridTeaRose extends Rose implements Bouquetable {
	
	public HybridTeaRose() {
		try {
			this.setName("Mister Lincoln");
			this.setColor(Color.RED);
			this.setSize(Size.MEDIUM);
			this.setHeightCM(35);
		} catch (IncorrectFlowerAttributeException ex) {
			System.out.println(ex.getMessage());
		}
		this.price = new Price(12);
	}
	
	/*
	 * Here we are providing an additional constructor, imagining that this type of rose has other variants which can, if requested,
	 * be purchases separately
	 */
	
	public HybridTeaRose(String name, Color color, Size size, double price, double HeightCM) throws IncorrectFlowerAttributeException {
		this.setName(name);
		this.setColor(color);
		this.setSize(size);
		this.price = new Price(price);
		this.setHeightCM(HeightCM);
	}
	
}
