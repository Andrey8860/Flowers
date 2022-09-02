package com.epam.exceptions;

/*
 * Exception which is to be thrown or caught when we are dealing with adding an item to the bouquet, since not all flowers
 * can be added to the bouquet
 */
public class ItemOnlySoldSeparatelyException extends Exception {
	public ItemOnlySoldSeparatelyException(String message) {
		super(message);
	}
}
