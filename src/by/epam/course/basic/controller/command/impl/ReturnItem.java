package by.epam.course.basic.controller.command.impl;

import by.epam.course.basic.controller.command.Command;
import by.epam.course.basic.services.exception.ServiceException;
import by.epam.course.basic.services.factory.ServiceFactory;
import by.epam.course.basic.services.interfaces.ClientService;

public class ReturnItem implements Command {

	@Override
	public String execute(String request) {
		String response;
		//String[] requstItems=request.split(" ");
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService service = serviceFactory.getClientService(); 
		try {
			service.takeBackProduct(request);
			response = "The item has been returned to the stock";
			
		} catch (ServiceException | IllegalArgumentException | NullPointerException e  ) {
			// TODO Auto-generated catch block
			response = "We have found an issue. Check the request.";
		} 
		return response;
	}

}
