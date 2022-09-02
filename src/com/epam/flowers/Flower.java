package com.epam.flowers;

import com.epam.constants.Color;
import com.epam.constants.Size;
import com.epam.exceptions.IncorrectFlowerAttributeException;
import com.epam.interfaces.Bouquetable;
import com.epam.shop.management.Price;

public abstract class Flower {

	/*
	 * Here we are declaring a price to be a protected field. It is not necessary, but we do this because both this method
	 * and Price object would have getPrice methods, which when called would seem obscure. Methods could be renamed, but
	 * I've decided to have it as protected instead, just to demonstrate it. Plus since all flowers are in the same package
	 * the value is still hidden from other classes.
	 */
	
	protected Price price;
	private String name;
	private Color color;
	private Size size;
	
	public static boolean isBouquetable(Flower flower) {
		return flower instanceof Bouquetable;
	}
	
	public abstract String toString();

	public String getName() {
		return name;
	}

	public void setName(String name) throws IncorrectFlowerAttributeException {
		if(name == null || name == "") {
			throw new IncorrectFlowerAttributeException("Name cannot be null or empty");
		}
		
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) throws IncorrectFlowerAttributeException {
		if(color == null) {
			throw new IncorrectFlowerAttributeException("Color cannot be null");
		}
		
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) throws IncorrectFlowerAttributeException {
		if(size == null) {
			throw new IncorrectFlowerAttributeException("Size cannot be null");
		}
		
		this.size = size;
	}
	
	public Price getPrice() {
		return this.price;
	}
	
	public boolean equals(Flower flower) {
		try {
			if(this.name.equals(flower.getName())) {
				return true;
			}
			return false;
		} catch (NullPointerException ex) {
			return false;
		}
	}
	
}
