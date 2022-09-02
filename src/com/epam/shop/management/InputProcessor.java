package com.epam.shop.management;

import java.util.Scanner;

import com.epam.constants.ConsoleOutput;
import com.epam.constants.InputCommands;
import com.epam.exceptions.ItemOnlySoldSeparatelyException;
import com.epam.exceptions.ItemOutOfStockException;
import com.epam.flowers.Bouquet;
import com.epam.flowers.Flower;

/*
 * This class takes care of user interaction. All of the methods are private, except for the one which actually starts the
 * processor. We also declare methods as static, since they do not depend on a specific instance of any object. They accept
 * them, process, but do not depend in any way on the specific state of the object
 */

public class InputProcessor {
	
	public static void start(Inventory inventory, Shop shop) throws NullPointerException {
		if(inventory == null || shop == null) {
			throw new NullPointerException("Inventory or shop cannot be null");
		}
		
		Scanner input = new Scanner(System.in);
		System.out.print(ConsoleOutput.WELCOME_TEXT);
		processInput(inventory, shop, input);
	}
	
	private static void processInput(Inventory inventory, Shop shop, Scanner input) {
		
		while(true) {
			String userInput = input.nextLine();
			
			if(userInput.trim().equalsIgnoreCase(InputCommands.INVENTORY.name())) {
				processInventory(inventory);
			} else if(userInput.trim().equalsIgnoreCase(InputCommands.BUY.name())) {
				processBuying(inventory, shop, input);
			} else if(userInput.trim().equalsIgnoreCase(InputCommands.BOUQUET.name())) {
				processBouquet(inventory, shop, input);
			} else if(userInput.trim().equalsIgnoreCase(InputCommands.EXIT.name())) {
				processExit(input);
			} else {
				System.out.print(ConsoleOutput.MAIN_TIP);
			}
		}
	}
	
	private static void processBouquet(Inventory inventory, Shop shop, Scanner input) {
		Bouquet bq = new Bouquet();
		
		System.out.print(ConsoleOutput.WELCOME_BOUQUET);
		
		while(true) {
			String userInput = input.nextLine();
			
			if(userInput.trim().equalsIgnoreCase(InputCommands.INVENTORY.name())) {
				processInventory(inventory);
			} else if(userInput.length() >= 3 && userInput.trim().substring(0, 3).equalsIgnoreCase(InputCommands.ADD.name())) {
				String flowerNameInput = userInput.substring(4).trim();
				Flower flower = inventory.isPresent(flowerNameInput);
				
				try {
					bq.add(inventory, flower);
				} catch(ItemOnlySoldSeparatelyException ex) {
					System.out.println(ex.getMessage());
				} catch(ItemOutOfStockException ex) {
					System.out.println(ex.getMessage());
				} catch(NullPointerException ex) {
					System.out.println(ConsoleOutput.BOUQUET_TIP);
				}
				
			} else if(userInput.length() >= 6 && userInput.trim().substring(0, 6).equalsIgnoreCase(InputCommands.REMOVE.name())) {
				String flowerNameInput = userInput.substring(6).trim();
				Flower flower = inventory.isPresent(flowerNameInput);
				
				try {
					bq.remove(inventory, flower);
				} catch (NullPointerException ex) {
					System.out.println(ConsoleOutput.BOUQUET_TIP);
				}
			} else if(userInput.trim().equalsIgnoreCase(InputCommands.BUY.name())) {
				shop.buy(bq);
				bq = new Bouquet();
			} else if(userInput.trim().equalsIgnoreCase(InputCommands.TOTAL.name())) {
				bq.sortByPrice();
				System.out.println(bq.toString());
			} else if(userInput.trim().equalsIgnoreCase(InputCommands.STOP.name())) {
				bq = new Bouquet();
				System.out.print(ConsoleOutput.WELCOME_BACK);
				break;
			} else {
				System.out.print(ConsoleOutput.BOUQUET_TIP);
			}
		}
		
		processInput(inventory, shop, input);
	}
	
	private static void processBuying(Inventory inventory, Shop shop, Scanner input) {
		processInventory(inventory);
		System.out.println(ConsoleOutput.SINGLE_PURCHASE_INSTRUCTION);
		
		Flower flower = inventory.isPresent(input.nextLine());
		
		if (shop.buy(flower)) {
			System.out.println(ConsoleOutput.THANK_YOU);
		} else {
			System.out.println(ConsoleOutput.OUT_OF_STOCK);
		}
	}
	
	private static void processInventory(Inventory shop) {
		shop.printInventory();
	}
	
	private static void processExit(Scanner input) {
		System.out.println(ConsoleOutput.GOODBYE_TEXT);
		input.close();
		System.exit(0);
	}
	
}
