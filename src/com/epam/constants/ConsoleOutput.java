package com.epam.constants;

/*
 * Here we are having all outputs which Input Processor displays to the user. This is not used, however, in toString methods
 * of classes we created. Instead, this relates only to the output related to user interactions. This class also helps keep
 * the InputProcessor class clean and focused on actions, instead of being overloaded with text
 */

public class ConsoleOutput {
	
	public static final String WELCOME_TEXT = "Hello! Welcome to the flower shop! To purchase a flower, "
			+ "please use the following commands:\n" +
			"Inventory - to view what we have in stock\n" + 
			"Bouquet - to proceed with bouquet picking\n" +
			"Buy - to buy a single flower\n" + 
			"Exit - to exit the shop\n";
	
	public static final String WELCOME_BOUQUET = "Welcome to the bouquet constructor! To make your own custom bouquet, use the following commands:\n" +
			"Inventory - to view what we have in stock\n" +
			"Add + the name of the flower - to add it to the bouquet\n" + 
			"Remove + the name of the flower - to remove it from the bouquet\n" + 
			"Buy - to buy the bouquet\n" + 
			"Total - to view the current contents of the bouquet and its total\n" + 
			"Stop - to exit the bouquet constructor\n";
	
	public static final String WELCOME_BACK = "You have left the bouquet constructor. Please use the following commands:\n" +
			"Inventory - to view what we have in stock\n" + 
			"Bouquet - to proceed with bouquet picking\n" +
			"Buy - to buy a single flower\n" + 
			"Exit - to exit the shop\n";
	
	public static final String MAIN_TIP = "We are sorry, but we did not understand your input. " + 
			"Please use the following commands:\n" + 
			"Inventory - to view what we have in stock\n" + 
			"Bouquet - to proceed with bouquet picking\n" +
			"Buy - to buy a single flower\n" + 
			"Exit - to exit the shop\n";
	
	public static final String BOUQUET_TIP = "We are sorry, but we did not understand your input. " + 
			"Please use the following commands:\n" + 
			"Inventory - to view what we have in stock\n" +
			"Add + the name of the flower - to add it to the bouquet\n" + 
			"Remove + the name of the flower - to remove it from the bouquet\n" + 
			"Buy - to buy the bouquet\n" + 
			"Total - to view the current contents of the bouquet and its total\n" + 
			"Stop - to exit the bouquet constructor\n";
	
	public static final String SINGLE_PURCHASE_INSTRUCTION = "To buy a single flower, please enter its name";
	
	public static final String THANK_YOU = "Thank you for your purchase!";
	
	public static final String OUT_OF_STOCK = "Unfortunately, this item is out of stock";
	
	public static final String GOODBYE_TEXT = "Thank you for visiting us!";
	
}
