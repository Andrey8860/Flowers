package com.epam.exceptions;

/*
 * This is an exception which will be thrown if someone tries to create a flower with incorrect attributes.
 * We are creating our own exception here because IllegalArgumentException, the existing one, is a runtime exception,
 * but here we actually want our exception to be checked
 */
public class IncorrectFlowerAttributeException extends Exception {
	public IncorrectFlowerAttributeException(String message) {
		super(message);
	}
}
