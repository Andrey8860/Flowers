package com.epam.flowers;

import com.epam.exceptions.IncorrectFlowerAttributeException;

/*
 * This is the only abstract class below Flower class, suggesting that since Roses are popular - 
 * we have several of them, and we also provide their height, as a custom attribute
 */

public abstract class Rose extends Flower {

	private double heightCM;
	
	public double getHeightCM() {
		return heightCM;
	}

	public void setHeightCM(double heightCM) throws IncorrectFlowerAttributeException {
		if(heightCM <= 0) {
			throw new IncorrectFlowerAttributeException("Height cannot be 0 or less");
		}
		
		this.heightCM = heightCM;
	}
	
	/*
	 * Since information about the roses is the same, we can implement the toString method here.
	 * If any specific rose would need their own method - they could also overwrite it later
	 */
	
	@Override
	public String toString() {
		return "Name: " + getName() + "; Color: " + getColor() + "; Size: " + 
				getSize() + "; Height: " + getHeightCM() + "; Price: " + price.toString();
	}
	
}
