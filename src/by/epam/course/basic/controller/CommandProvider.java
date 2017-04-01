package by.epam.course.basic.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam.course.basic.controller.command.Command;
import by.epam.course.basic.controller.command.CommandName;
import by.epam.course.basic.controller.command.impl.AddItem;
import by.epam.course.basic.controller.command.impl.Registration;
import by.epam.course.basic.controller.command.impl.RemoveItem;
import by.epam.course.basic.controller.command.impl.ReturnItem;
import by.epam.course.basic.controller.command.impl.ShowAllItems;
import by.epam.course.basic.controller.command.impl.ShowAllUsers;
import by.epam.course.basic.controller.command.impl.ShowClientProducts;
import by.epam.course.basic.controller.command.impl.SignIn;
import by.epam.course.basic.controller.command.impl.TakeItem;
import by.epam.course.basic.controller.command.impl.WrongRequest;

final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();
	
	public CommandProvider() {
		repository.put(CommandName.ADD_ITEM, new AddItem());
		repository.put(CommandName.REGISTRATION, new Registration());
		repository.put(CommandName.REMOVE_ITEM, new RemoveItem());
		repository.put(CommandName.RETURN_ITEM, new ReturnItem());
		repository.put(CommandName.SHOW_ALL_ITEM, new ShowAllItems());
		repository.put(CommandName.SHOW_ALL_USERS, new ShowAllUsers());
		repository.put(CommandName.SHOW_CLIENT_PRODUCTS, new ShowClientProducts());
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.TAKE_ITEM, new TakeItem());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}
	
	Command getCommand(String name){
		Command command = null;
		CommandName commandName = null;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
			
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		
		return command;
	}
}
