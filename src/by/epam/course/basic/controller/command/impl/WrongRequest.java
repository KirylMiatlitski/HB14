package by.epam.course.basic.controller.command.impl;

import by.epam.course.basic.controller.command.Command;

public class WrongRequest implements Command{

	@Override
	public String execute(String request) {
		String response;
		response = "We cannot parse the request. Check the command and try again.";
		return response;
	}

}
