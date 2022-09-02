package com.epam.constants;

/*
 * Here we are providing possible input commands. Since InputProcessor class relies on the commands being typed - 
 * we can just call this enum's value name and compare it to input. Plus, we know the limitations of InputProcessor by
 * just looking at this enum
 */

public enum InputCommands {
	INVENTORY, BUY, BOUQUET, EXIT, ADD, REMOVE, TOTAL, STOP
}
