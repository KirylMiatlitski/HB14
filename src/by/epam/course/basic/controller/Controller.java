package by.epam.course.basic.controller;

import by.epam.course.basic.controller.command.Command;

public final class Controller {
	private final CommandProvider provider = new CommandProvider();
	private final char paramDelimiter = ' ';
	
	
	public String executeTask(String request){
		
		String commandName;
		Command executionCommand;
		String response;
		if ((request.indexOf(paramDelimiter)>0) & (request.indexOf(paramDelimiter)<request.length())){
			commandName = request.substring(0, request.indexOf(paramDelimiter));
			request = request.substring(request.indexOf(paramDelimiter)+1);

		} else {
			commandName = request;

		}
				
		executionCommand = provider.getCommand(commandName);
		response = executionCommand.execute(request);
		
		return response;
	}
}
