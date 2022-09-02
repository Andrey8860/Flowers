package com.epam.exceptions;

/*
 * This exception is to be used when we deal with any action which relies on the flower being in stock.
 * However, this one is a runtime exception and is not checked, since we can interact with inventory a lot,
 * and many cases actually would not need a mandatory exception handling
 */
public class ItemOutOfStockException extends RuntimeException {
	public ItemOutOfStockException(String message) {
		super(message);
	}
}
