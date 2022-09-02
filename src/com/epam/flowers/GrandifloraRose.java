package com.epam.flowers;

import com.epam.constants.Color;
import com.epam.constants.Size;
import com.epam.exceptions.IncorrectFlowerAttributeException;
import com.epam.interfaces.Bouquetable;
import com.epam.shop.management.Price;

public class GrandifloraRose extends Rose implements Bouquetable {
	
	public GrandifloraRose() {
		try {
			this.setName("Grandiflora Rose");
			this.setColor(Color.WHITE);
			this.setSize(Size.LARGE);
			this.setHeightCM(50);
		} catch (IncorrectFlowerAttributeException ex) {
			System.out.println(ex.getMessage());
		}
		this.price = new Price(35);
	}
	
}
