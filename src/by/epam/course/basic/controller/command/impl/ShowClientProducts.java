package by.epam.course.basic.controller.command.impl;

import java.util.ArrayList;
import java.util.List;

import by.epam.course.basic.controller.command.Command;
import by.epam.course.basic.services.exception.ServiceException;
import by.epam.course.basic.services.factory.ServiceFactory;
import by.epam.course.basic.services.interfaces.ClientService;

public class ShowClientProducts implements Command{

	@Override
	public String execute(String request) {
		String response = "";
		String[] requstItems=request.split(" ");
		List<String> list = new ArrayList<>();
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService service = serviceFactory.getClientService();
		try {
			list = service.getAllClientProducts(requstItems[0]);
			for (int i = 0; i < list.size(); i++){
				response = response + list.get(i) + "\n"; 
			}
			
			
		} catch (ServiceException | IllegalArgumentException | NullPointerException e  ) {
			// TODO Auto-generated catch block
			response = "We have found an issue. Check the request.";
		} 
		return response;
	}

}
